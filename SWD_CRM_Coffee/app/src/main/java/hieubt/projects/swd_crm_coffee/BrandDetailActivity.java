package hieubt.projects.swd_crm_coffee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import hieubt.projects.swd_crm_coffee.Model.Datum;
import hieubt.projects.swd_crm_coffee.Model.Example;
import hieubt.projects.swd_crm_coffee.Model.ListStore;
import hieubt.projects.swd_crm_coffee.Model.Promotion;
import hieubt.projects.swd_crm_coffee.Model.PromotionResponse;
import hieubt.projects.swd_crm_coffee.retrofit.BigApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.BigApiInterface;
import hieubt.projects.swd_crm_coffee.retrofit.BrandApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.BrandApiInterface;
import hieubt.projects.swd_crm_coffee.ultilities.ItemGenerator;
import hieubt.projects.swd_crm_coffee.ultilities.UnitConverter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrandDetailActivity extends AppCompatActivity {

    private TextView txtTitle, txtProfile, txtExtend, txtDesc, txtAddresses;
    private Button btnRegister;
    private LinearLayout mainLayout;
    private final ItemGenerator itemGenerator = new ItemGenerator(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_detail);
        txtTitle = findViewById(R.id.txtTitle);
        txtProfile = findViewById(R.id.txtProfile);
        txtExtend = findViewById(R.id.txtExtend);
        txtDesc = findViewById(R.id.txtDescription);
        txtAddresses = findViewById(R.id.txtAddresses);
        btnRegister = findViewById(R.id.btnRegister);
        mainLayout = findViewById(R.id.mainLayout);

        final DBManager db = new DBManager(this);
        Intent intent = getIntent();
        final int brandId = intent.getIntExtra("brandId", 0);
        final int userId = intent.getIntExtra("userId", 0);
        if (brandId == 0 || userId == 0) {
            Toast.makeText(this, "Unable to get Brand Information", Toast.LENGTH_SHORT).show();
            finish();
        }
        if (db.checkUserRegisterBrand(userId, brandId)) {
            btnRegister.setText("Unregister");
        } else {
            btnRegister.setText("Register");
        }
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = btnRegister.getText().toString();
                if (value.equalsIgnoreCase("unregister")) {
//                    btnRegister.setText("Register");
                } else {
                    if (db.addRegistedBrandId(userId, brandId)) {
                        Toast.makeText(BrandDetailActivity.this, "Registered Success",
                                Toast.LENGTH_SHORT).show();
                        btnRegister.setText("Unregister");
                    } else {
                        Toast.makeText(BrandDetailActivity.this, "Registered Failed",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        getBrandData(brandId);
        getBrandPromotion();
    }

    public void clickToFinish(View view) {
        finish();
    }

    private void getBrandPromotion() {
        //get brand promotion
        BigApiInterface bigService = BigApiClient.getClient().create(BigApiInterface.class);
        Call<PromotionResponse> call1 = bigService.getAllPromotion();
        call1.enqueue(new Callback<PromotionResponse>() {
            @Override
            public void onResponse(Call<PromotionResponse> call, Response<PromotionResponse> response) {
                //this is the list of promotion
                List<Promotion> list = response.body().getData();
                for (Promotion promotion: list) {
                    itemGenerator.createPromotionRectangle(promotion.getName(), promotion.getId(), mainLayout);
                }
            }

            @Override
            public void onFailure(Call<PromotionResponse> call, Throwable t) {
                System.out.println("FAIL");
            }
        });
    }

    private void getBrandData(int brandId) {
        BrandApiInterface service = BrandApiClient.getClient().create(BrandApiInterface.class);
        Call<Example> call = service.getBrandById(brandId);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Datum data = response.body().getData();
                List<ListStore> storeList = data.getListStore();
                String addresses = "";
                for (ListStore store : storeList) {
                    addresses += "  +" + store.getName() + ":\n" + store.getAddress() + "\n";
                }
                if (addresses.isEmpty()) {
                    addresses += "There is no address for this brand";
                }
                txtTitle.setText(data.getBrandName());
                txtProfile.setText("-Created Date :\n" + UnitConverter.getDateString(data.getCreateDate()) + "\n" +
                        "-Company :\n" + data.getCompanyName() + "\n"
                );
                txtExtend.setText("-Website :\n" + data.getWebsite() + "\n" +
                        "-Contractor :\n" + data.getContactPerson() + "\n" +
                        "-Phone No.:\n" + data.getPhoneNumber() + "\n" +
                        "-Fax : \n" + data.getFax());
                txtDesc.setText("-Description:\n" + data.getDescription());
                txtAddresses.setText(addresses);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                System.out.println("FAIL");
            }
        });
    }
}
