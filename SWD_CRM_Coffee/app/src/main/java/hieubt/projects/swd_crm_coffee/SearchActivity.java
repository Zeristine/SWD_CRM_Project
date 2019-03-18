package hieubt.projects.swd_crm_coffee;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    BrandApiInterface service = BrandApiClient.getClient().create(BrandApiInterface.class);
    CustomerApiInterface customerService = CustomerApiClient.getClient().create(CustomerApiInterface.class);
    DBManager db = new DBManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //get all brand exist
        Call<List<Datum>> call = service.getAllBrand();
        call.enqueue(new Callback<List<Datum>>() {
            @Override
            public void onResponse(Call<List<Datum>> call, Response<List<Datum>> response) {
                List<Datum> listBrand = response.body();
            }

            @Override
            public void onFailure(Call<List<Datum>> call, Throwable t) {
                System.out.println("FAIL");
            }
        });
    }

    //search brand
    public void searchBrand(String name) {
        Call<List<Datum>> call = service.searchBrand(name);
        call.enqueue(new Callback<List<Datum>>() {
            @Override
            public void onResponse(Call<List<Datum>> call, Response<List<Datum>> response) {
                List<Datum> listBrand = response.body();
            }

            @Override
            public void onFailure(Call<List<Datum>> call, Throwable t) {
                System.out.println("FAIL");
            }
        });

    }

    //check registed or not, then regist a brand
    public void registBrand(final int brandId) {
        String phoneNumber = db.getPhoneNumber();
        final CustomerToPost customerToPost = new CustomerToPost();
        //set phone number and brand name to Post
        customerToPost.setPhone(phoneNumber);
        final String brandName = "CoffeeHouse"; // brand name set tạm
        customerToPost.setBrandCode(brandName);
        //get customer from api
        Call<CustomerResponse> call = customerService.getRegistedBrand(phoneNumber);
        call.enqueue(new Callback<CustomerResponse>() {
            @Override
            public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response) {
                List<Customer> list = response.body().getData();
                //check registed or not
                boolean registed = false;
                for (Customer c : list) {
                    if (brandName.equals(c.getBrandCode())) {
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
                            System.out.println("FAIL");
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<CustomerResponse> call, Throwable t) {
                System.out.println("FAIL");
            }
        });


    }

}
