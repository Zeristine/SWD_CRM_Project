package hieubt.projects.swd_crm_coffee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import hieubt.projects.swd_crm_coffee.Model.Customer;
import hieubt.projects.swd_crm_coffee.Model.CustomerResponse;
import hieubt.projects.swd_crm_coffee.Model.CustomerToPost;
import hieubt.projects.swd_crm_coffee.Model.Datum;
import hieubt.projects.swd_crm_coffee.Model.Mes;
import hieubt.projects.swd_crm_coffee.retrofit.BrandApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.BrandApiInterface;
import hieubt.projects.swd_crm_coffee.retrofit.CustomerApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.CustomerApiInterface;
import hieubt.projects.swd_crm_coffee.ultilities.ItemGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrandSearchActivity extends AppCompatActivity {

    private EditText edtSearch;
    private LinearLayout mainLayout;
    private final ItemGenerator itemGenerator = new ItemGenerator(this);
    private final BrandApiInterface service = BrandApiClient.getClient().create(BrandApiInterface.class);
    private CustomerApiInterface customerService = CustomerApiClient.getClient().create(CustomerApiInterface.class);
    private List<Datum> prevSearchList;
    DBManager db = new DBManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_search);
        edtSearch = findViewById(R.id.edtSearch);
        mainLayout = findViewById(R.id.mainLayout);

        getAllBrands();

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String value = s.toString();
                if (!value.isEmpty()) {
                    getSearchResult(value);
                } else {
                    getAllBrands();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void getSearchResult(String value) {
        Call<List<Datum>> call = service.searchBrand(value);
        call.enqueue(new Callback<List<Datum>>() {
            @Override
            public void onResponse(Call<List<Datum>> call, Response<List<Datum>> response) {
                List<Datum> datas = response.body();
                if (datas != prevSearchList) {
                    mainLayout.removeAllViews();
                    for (Datum data : datas) {
                        itemGenerator.createRectangleWithLabel(data.getBrandName(), data.getId(), 1, mainLayout);
                    }
                }
                prevSearchList = datas;
            }

            @Override
            public void onFailure(Call<List<Datum>> call, Throwable t) {
                Toast.makeText(BrandSearchActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getAllBrands() {
        Call<List<Datum>> call = service.getAllBrand();
        call.enqueue(new Callback<List<Datum>>() {
            @Override
            public void onResponse(Call<List<Datum>> call, Response<List<Datum>> response) {
                List<Datum> datas = response.body();
                mainLayout.removeAllViews();
                for (Datum data : datas) {
                    itemGenerator.createRectangleWithLabel(data.getBrandName(), data.getId(), 1, mainLayout);
                }
            }

            @Override
            public void onFailure(Call<List<Datum>> call, Throwable t) {
                System.out.println("FAIL");
            }
        });
    }

    //regist by sending customer phone number + brand name
    //check registed or not, then regist a brand
    public void registBrand(String brandName) {
        String phoneNumber = db.getPhoneNumber();
        final CustomerToPost customerToPost = new CustomerToPost();
        //set phone number and brand name to Post
        customerToPost.setPhone(phoneNumber);
        brandName = "CoffeeHouse"; // brand name set tạm
        customerToPost.setBrandCode(brandName);
        //get customer from api
        Call<CustomerResponse> call = customerService.getRegistedBrand(phoneNumber);
        final String finalBrandName = brandName;
        call.enqueue(new Callback<CustomerResponse>() {
            @Override
            public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response) {
                List<Customer> list = response.body().getData();
                //check registed or not
                boolean registed = false;
                for (Customer c : list) {
                    if (finalBrandName.equals(c.getBrandCode())) {
                        registed = true;
                        break;
                    }
                }
                //if registed then out, other wise regist
                if (registed) {
                    System.out.println("This brand is registed");
                } else {
                    //post to api
                    Call<Mes> call1 = customerService.registNewBrand(customerToPost);
                    call1.enqueue(new Callback<Mes>() {
                        @Override
                        public void onResponse(Call<Mes> call, Response<Mes> response) {
                            System.out.println("Regist success");
                        }

                        @Override
                        public void onFailure(Call<Mes> call, Throwable t) {
                            System.out.println("FAIL post");
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<CustomerResponse> call, Throwable t) {
                System.out.println("FAIL get");
            }
        });


    }


}
