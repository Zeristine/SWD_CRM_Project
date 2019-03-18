package hieubt.projects.swd_crm_coffee;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hieubt.projects.swd_crm_coffee.Model.Customer;
import hieubt.projects.swd_crm_coffee.Model.CustomerResponse;
import hieubt.projects.swd_crm_coffee.Model.Datum;
import hieubt.projects.swd_crm_coffee.Model.Example;
import hieubt.projects.swd_crm_coffee.retrofit.BrandApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.BrandApiInterface;
import hieubt.projects.swd_crm_coffee.retrofit.CustomerApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.CustomerApiInterface;
import hieubt.projects.swd_crm_coffee.ultilities.ItemGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout layoutHome;
    private ImageButton btnSearch;
    private final ItemGenerator itemGenerator = new ItemGenerator(HomeActivity.this);
    private final DBManager db = new DBManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        layoutHome = findViewById(R.id.layoutHome);
        btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, BrandSearchActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getListOfRegisteredBrand();
    }

    private void getListOfRegisteredBrand(){
        //////////////////////////////////////////
        //show all registed brand
        //get list registed brand
        layoutHome.removeAllViews();
        List<Integer> listBrandId = db.getAllRegistedBrandId(1);
        //call api with each brand id
        BrandApiInterface service = BrandApiClient.getClient().create(BrandApiInterface.class);
        for (Integer id : listBrandId) {
            Call<Example> call = service.getBrandById(id);
            call.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    Datum data = response.body().getData();
                    itemGenerator.createRectangleWithLabel(data.getBrandName(),data.getId(), 1,layoutHome);
                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {
                    System.out.println("FAIL");
                }
            });
        }
    }

    //return registed brand by phone
    private void getListOfRegisteredBrandByPhonenumber() {
        //get phone number from db
        String phoneNumber = db.getPhoneNumber();
        CustomerApiInterface service = CustomerApiClient.getClient().create(CustomerApiInterface.class);
        Call<CustomerResponse> call = service.getRegistedBrand(phoneNumber);
        call.enqueue(new Callback<CustomerResponse>() {
            @Override
            public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response) {
                //this is the list, each object contain brand name
                List<Customer> list = response.body().getData();
            }

            @Override
            public void onFailure(Call<CustomerResponse> call, Throwable t) {
                System.out.println("FAIL");
            }
        });
    }
}
