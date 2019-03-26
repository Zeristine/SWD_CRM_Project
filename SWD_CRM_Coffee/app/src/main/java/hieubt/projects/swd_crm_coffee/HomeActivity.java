package hieubt.projects.swd_crm_coffee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.List;

import hieubt.projects.swd_crm_coffee.Model.Datum;
import hieubt.projects.swd_crm_coffee.Model.Membership;
import hieubt.projects.swd_crm_coffee.Model.MembershipResponse;
import hieubt.projects.swd_crm_coffee.retrofit.MembershipApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.MembershipApiInterface;
import hieubt.projects.swd_crm_coffee.ultilities.ItemGenerator;
import hieubt.projects.swd_crm_coffee.ultilities.UserSession;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout layoutHome;
    private ImageButton btnSearch;
    private final ItemGenerator itemGenerator = new ItemGenerator(HomeActivity.this);
    private final DBManager db = new DBManager(this);
    MembershipApiInterface membershipService = MembershipApiClient.getClient().create(MembershipApiInterface.class);

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
        getListOfRegisteredBrandByCustomerCode(db.getCustomerCode());
    }


    //get registed brand by customer code
    private void getListOfRegisteredBrandByCustomerCode(String customerCode) {
        Call<MembershipResponse> call = membershipService.getMemberShipByCode(customerCode);
        call.enqueue(new Callback<MembershipResponse>() {
            @Override
            public void onResponse(Call<MembershipResponse> call, Response<MembershipResponse> response) {
                //this is the list
                layoutHome.removeAllViews();
                List<Membership> list = response.body().getData();
                Membership prev = null;
                for (Membership membership : list) {
                    Datum data = new Datum(membership.getBrandCode());
                    data.setWebsite("passio.com.vn");
                    data.setContactPerson("Hà Triệu Kim");
                    data.setPhoneNumber("099999999");
                    data.setFax("908788");
                    data.setCreateDate("2018-05-10T14:55:00");
                    data.setDescription("The Good Coffee Chain System");
                    if (prev != null) {
                        if (!prev.getBrandCode().equals(membership.getBrandCode())) {
                            itemGenerator.createRectangleWithLabel(data, layoutHome, null);
                        }
                        prev = membership;
                    }
                    if (prev == null) {
                        itemGenerator.createRectangleWithLabel(data, layoutHome, null);
                        prev = membership;
                    }
                }
                UserSession.getUserMembership().addAll(list);
            }

            @Override
            public void onFailure(Call<MembershipResponse> call, Throwable t) {
                System.out.println("GET REGISTED BRAND FAIL");
                System.out.println(t.toString());
            }
        });
    }
}
