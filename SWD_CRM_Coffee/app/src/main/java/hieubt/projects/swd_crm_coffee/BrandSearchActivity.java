package hieubt.projects.swd_crm_coffee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

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
    private void registBrand(String brandName) {
        CustomerToPost customer = new CustomerToPost();
        customer.setBrandCode(brandName);
        Call<Mes> call = customerService.registNewBrand(customer);
        call.enqueue(new Callback<Mes>() {
            @Override
            public void onResponse(Call<Mes> call, Response<Mes> response) {
                System.out.println("regist success");
            }

            @Override
            public void onFailure(Call<Mes> call, Throwable t) {
                System.out.println("FAIL");
            }
        });
    }


}
