package hieubt.projects.swd_crm_coffee;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import hieubt.projects.swd_crm_coffee.Model.Datum;
import hieubt.projects.swd_crm_coffee.Model.Promotion;
import hieubt.projects.swd_crm_coffee.Model.PromotionResponse;
import hieubt.projects.swd_crm_coffee.retrofit.BigApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.BigApiInterface;
import hieubt.projects.swd_crm_coffee.retrofit.BrandApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.BrandApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MemberStatusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_status);
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

        //show brand info, member status, brand promotion
        //get extra brand's name from HomeActivity
        String brandName = "UniSpace";
        //get brand info
        BrandApiInterface brandService = BrandApiClient.getClient().create(BrandApiInterface.class);
        Call<List<Datum>> call =  brandService.searchBrand(brandName);
        call.enqueue(new Callback<List<Datum>>() {
            @Override
            public void onResponse(Call<List<Datum>> call, Response<List<Datum>> response) {
                List<Datum> list = response.body();
                //this is the brand
                Datum brand = list.get(0);
            }

            @Override
            public void onFailure(Call<List<Datum>> call, Throwable t) {
                System.out.println("FAIL");
            }
        });
        //get brand promotion
        BigApiInterface bigService = BigApiClient.getClient().create(BigApiInterface.class);
        Call<PromotionResponse> call1 =  bigService.getAllPromotion();
        call1.enqueue(new Callback<PromotionResponse>() {
            @Override
            public void onResponse(Call<PromotionResponse> call, Response<PromotionResponse> response) {
                //this is the list of promotion
                List<Promotion> list = response.body().getData();
            }

            @Override
            public void onFailure(Call<PromotionResponse> call, Throwable t) {
                System.out.println("FAIL");
            }
        });
    }

}
