package hieubt.projects.swd_crm_coffee;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hieubt.projects.swd_crm_coffee.Model.Datum;
import hieubt.projects.swd_crm_coffee.Model.Example;
import hieubt.projects.swd_crm_coffee.retrofit.BrandApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.BrandApiInterface;
import hieubt.projects.swd_crm_coffee.ultilities.ItemGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout layoutHome;
    private final ItemGenerator itemGenerator = new ItemGenerator(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        layoutHome = findViewById(R.id.layoutHome);

        itemGenerator.createRectangleWithLabel("The Coffee House", layoutHome);
        itemGenerator.createRectangleWithLabel("StarBuck", layoutHome);
        itemGenerator.createRectangleWithLabel("Quang Trung Coffee", layoutHome);

        //////////////////////////////////////////
        //show all registed brand
        //get list registed brand
        DBManager dbManager = new DBManager(this);
        List<Integer> listBrandId = dbManager.getAllRegistedBrandId(1);
        //call api with each brand id
        final List<Datum> listRegistedBrand = new ArrayList<>();
        BrandApiInterface service = BrandApiClient.getClient().create(BrandApiInterface.class);
        for (Integer id : listBrandId) {
            Call<Example> call = service.getBrandById(id);
            call.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    Datum data = response.body().getData();
                    listRegistedBrand.add(data);
                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {
                    System.out.println("FAIL");
                }
            });
        }
    }
}
