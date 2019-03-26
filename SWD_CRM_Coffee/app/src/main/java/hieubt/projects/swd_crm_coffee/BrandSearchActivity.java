package hieubt.projects.swd_crm_coffee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import hieubt.projects.swd_crm_coffee.Model.AccountToPost;
import hieubt.projects.swd_crm_coffee.Model.Datum;
import hieubt.projects.swd_crm_coffee.Model.Membership;
import hieubt.projects.swd_crm_coffee.Model.MembershipResponse;
import hieubt.projects.swd_crm_coffee.Model.MembershipToPost;
import hieubt.projects.swd_crm_coffee.Model.Mes;
import hieubt.projects.swd_crm_coffee.Model.MesObject;
import hieubt.projects.swd_crm_coffee.Model.PostMembershipResponse;
import hieubt.projects.swd_crm_coffee.retrofit.BrandApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.BrandApiInterface;
import hieubt.projects.swd_crm_coffee.retrofit.CustomerApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.CustomerApiInterface;
import hieubt.projects.swd_crm_coffee.retrofit.MembershipApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.MembershipApiInterface;
import hieubt.projects.swd_crm_coffee.ultilities.ItemGenerator;
import hieubt.projects.swd_crm_coffee.ultilities.UserSession;
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
    MembershipApiInterface membershipService = MembershipApiClient.getClient().create(MembershipApiInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_search);
        edtSearch = findViewById(R.id.edtSearch);
        mainLayout = findViewById(R.id.mainLayout);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
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

    @Override
    protected void onResume() {
        super.onResume();
        getAllBrands();
    }

    private void getSearchResult(String value) {
        Call<List<Datum>> call = service.searchBrand(value);
        call.enqueue(new Callback<List<Datum>>() {
            @Override
            public void onResponse(Call<List<Datum>> call, Response<List<Datum>> response) {
                List<Datum> datas = response.body();
                List<Membership> list = UserSession.getUserMembership();
                if (datas != prevSearchList) {
                    mainLayout.removeAllViews();
                    for (Datum data : datas) {
                        boolean check = false;
                        for(Membership membership : list){
                            if(membership.getBrandCode().equals(data.getBrandName())){
                                check = true;
                                break;
                            }
                        }
                        if(check){
                            itemGenerator.createRectangleWithLabel(data, mainLayout, "true");
                        }else{
                            itemGenerator.createRectangleWithLabel(data, mainLayout, "false");
                        }
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
        mainLayout.removeAllViews();
        Call<List<Datum>> call = service.getAllBrand();
        call.enqueue(new Callback<List<Datum>>() {
            @Override
            public void onResponse(Call<List<Datum>> call, Response<List<Datum>> response) {
                List<Datum> datas = response.body();
                datas.add(new Datum("PASSIO"));
                List<Membership> list = UserSession.getUserMembership();
                for (Datum data : datas) {
                    boolean check = false;
                    for(Membership membership : list){
                        if(membership.getBrandCode().equals(data.getBrandName())){
                            check = true;
                            break;
                        }
                    }
                    if(check){
                        itemGenerator.createRectangleWithLabel(data, mainLayout, "true");
                    }else{
                        itemGenerator.createRectangleWithLabel(data, mainLayout, "false");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Datum>> call, Throwable t) {
                System.out.println("FAIL");
            }
        });
    }

    //check regist or not. True for registed, False for not registed yet
    public boolean checkRegisted(String brandName, String customerCode){
        Call<MembershipResponse> call = membershipService.getMemberShipByCode(customerCode);
        Response<MembershipResponse> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Membership> membershipList = response.body().getData();
        for (Membership m : membershipList) {
            if (brandName.equals(m.getBrandCode())) {
                return true;
            }
        }

        return false;
    }

    public void clickToBack(View view) {
        finish();
    }
}
