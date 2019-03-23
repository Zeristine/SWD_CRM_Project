package hieubt.projects.swd_crm_coffee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
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

        //check regist
        //create membership
        //create account
        createMembership("PASSIO", "abcde");

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

    //regist a brand (post new membership & account)
//    public void registBrand(String brandName) {
//        String customerCode = db.getCustomerCode();
//        //check regist or not
//        boolean registed = checkRegisted(brandName, customerCode);
//        if (!registed) {
//            //post new membership to api
//            int membershipId = createMembership(brandName,customerCode);
//            //post new account to api
//            createAccount(brandName,customerCode, membershipId);
//        } else {
//            Toast.makeText(this, "already registed " + brandName, Toast.LENGTH_SHORT).show();
//        }
//
//    }

    private void createAccount(String brandName, String customerCode, int membershipId) {
        AccountToPost accountToPost = new AccountToPost(customerCode);
        accountToPost.setBrandCode(brandName);
        accountToPost.setMembershipId(membershipId);
        Call<Mes> call = membershipService.postAccount(accountToPost);
        call.enqueue(new Callback<Mes>() {
            @Override
            public void onResponse(Call<Mes> call, Response<Mes> response) {
                System.out.println("POST ACCOUNT OK");
            }

            @Override
            public void onFailure(Call<Mes> call, Throwable t) {
                System.out.println("POST ACCOUNT FAIL");
                System.out.println(t.toString());

            }
        });
    }

    public void createMembership(final String brandName,final String customerCode) {
        MembershipToPost membershipToPost = new MembershipToPost(customerCode);
        membershipToPost.setBrandCode(brandName);
        Call<PostMembershipResponse> call1 = membershipService.postMemberShip(membershipToPost);
        call1.enqueue(new Callback<PostMembershipResponse>() {
            @Override
            public void onResponse(Call<PostMembershipResponse> call, Response<PostMembershipResponse> response) {
                int membershipId = response.body().getData().getId();
                System.out.println("create membership ok, membershipID: " + membershipId);
                createAccount(brandName, customerCode, membershipId);
            }

            @Override
            public void onFailure(Call<PostMembershipResponse> call, Throwable t) {
                System.out.println("create membership fail");
                System.out.println(t.toString());

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

}
