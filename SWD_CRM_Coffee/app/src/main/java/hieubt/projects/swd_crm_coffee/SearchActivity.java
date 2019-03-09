package hieubt.projects.swd_crm_coffee;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import hieubt.projects.swd_crm_coffee.Model.Datum;
import hieubt.projects.swd_crm_coffee.retrofit.BrandApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.BrandApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    BrandApiInterface service = BrandApiClient.getClient().create(BrandApiInterface.class);

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

    //regist a brand
    public void registBrand(int brandId) {
        DBManager db = new DBManager(this);
        //check wheher registed or not
        List<Integer> list = db.getAllRegistedBrandId(1);
        if (!list.contains(brandId)) { //not regist yet
            db.addRegistedBrandId(1, brandId);
        } else { //already regist
            Toast.makeText(this, "already regist this brand", Toast.LENGTH_SHORT).show();
        }
    }
}
