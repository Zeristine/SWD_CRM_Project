package hieubt.projects.swd_crm_coffee;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import hieubt.projects.swd_crm_coffee.Model.Account;
import hieubt.projects.swd_crm_coffee.Model.AccountResponse;
import hieubt.projects.swd_crm_coffee.Model.AccountToPost;
import hieubt.projects.swd_crm_coffee.Model.Membership;
import hieubt.projects.swd_crm_coffee.Model.MembershipToPost;
import hieubt.projects.swd_crm_coffee.Model.Mes;
import hieubt.projects.swd_crm_coffee.Model.PostMembershipResponse;
import hieubt.projects.swd_crm_coffee.Model.Promotion;
import hieubt.projects.swd_crm_coffee.Model.PromotionResponse;
import hieubt.projects.swd_crm_coffee.Model.Voucher;
import hieubt.projects.swd_crm_coffee.Model.VoucherResponse;
import hieubt.projects.swd_crm_coffee.retrofit.BigApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.BigApiInterface;
import hieubt.projects.swd_crm_coffee.retrofit.MembershipApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.MembershipApiInterface;
import hieubt.projects.swd_crm_coffee.ultilities.ItemGenerator;
import hieubt.projects.swd_crm_coffee.ultilities.UnitConverter;
import hieubt.projects.swd_crm_coffee.ultilities.UserSession;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrandDetailActivity extends TabActivity {

    private TextView txtTitle, txtProfile, txtExtend, txtDesc, txtAddresses, txtNotFound;
    private Button btnRegister;
    private LinearLayout mainLayout, layoutVoucher;
    private final ItemGenerator itemGenerator = new ItemGenerator(this);
    private final DBManager db = new DBManager(this);
    private final MembershipApiInterface membershipService = MembershipApiClient.getClient().create(MembershipApiInterface.class);

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
        txtNotFound = findViewById(R.id.txtNotFound);
        mainLayout = findViewById(R.id.mainLayout);
        layoutVoucher = findViewById(R.id.layoutVoucher);
        final DBManager db = new DBManager(this);
        Intent intent = getIntent();
        final String brandName = intent.getStringExtra("name");

        if (brandName == null) {
            Toast.makeText(this, "Unable to get Brand Information", Toast.LENGTH_SHORT).show();
            finish();
        }
        btnRegister.setText("Register");
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createMembership(brandName, db.getCustomerCode());
            }
        });
//
        txtTitle.setText(getIntent().getStringExtra("name"));
        txtProfile.setText(
                "-Created Date :\n"
                        + (getIntent().getStringExtra("createdDate") == null ?
                        "Unknown" : UnitConverter.getDateString(getIntent().getStringExtra("createdDate")))
                        + "\n" +
                        "-Company :\n"
                        + (getIntent().getStringExtra("company") == null ?
                        "Unknown" : getIntent().getStringExtra("company"))
                        + "\n" +
                        "-Contractor :\n"
                        + (getIntent().getStringExtra("contract") == null ?
                        "Unknown" : getIntent().getStringExtra("contract"))
        );
        txtExtend.setText(
                "-Website :\n"
                        + (getIntent().getStringExtra("website") == null ?
                        "Unknown" : getIntent().getStringExtra("website"))
                        + "\n" +
                        "-Phone No.:\n"
                        + (getIntent().getStringExtra("phone") == null ?
                        "Unknown" : getIntent().getStringExtra("phone"))
                        + "\n" +
                        "-Fax : \n"
                        + (getIntent().getStringExtra("fax") == null ?
                        "Unknown" : getIntent().getStringExtra("fax"))
        );
        txtDesc.setText("-Description:\n"
                + (getIntent().getStringExtra("description") == null ?
                "No description available" : getIntent().getStringExtra("description")));
        txtAddresses.setText("There is no address for this brand");
        addTab("Member's Status", R.id.layoutStatus);
        addTab("Voucher", R.id.layoutVoucher);
        for (int i = 0; i < getTabWidget().getTabCount(); i++) {
            View v = getTabWidget().getChildTabViewAt(i);
            v.setBackgroundResource(R.drawable.brand_tab_indicator);
        }
        getTabHost().setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                setTextColorSelectionForTab();
            }
        });
        if (checkRegistered(getIntent().getStringExtra("name"))) {
            ((TextView) findViewById(R.id.txtPromotion)).setVisibility(View.VISIBLE);
            ((TextView) findViewById(R.id.txtPoint)).setVisibility(View.VISIBLE);
            btnRegister.setTextColor(getResources().getColor(R.color.blueLight500));
            btnRegister.setEnabled(false);
            getBrandPromotion();
            getVoucher();
            getPoint();
        } else {
            ((TextView) findViewById(R.id.txtPromotion)).setVisibility(View.GONE);
            ((TextView) findViewById(R.id.txtPoint)).setVisibility(View.GONE);
            getTabWidget().setVisibility(View.GONE);
            btnRegister.setTextColor(getResources().getColor(R.color.black));
            btnRegister.setEnabled(true);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTextColorSelectionForTab();
    }

    private void setTextColorSelectionForTab() {
        for (int i = 0; i < getTabWidget().getChildCount(); i++) {
            TextView tv = getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(getResources().getColor(R.color.black));
        }

        TextView tv = getTabHost().getCurrentTabView().findViewById(android.R.id.title);
        tv.setTextColor(getResources().getColor(R.color.white));
    }

    private void getVoucher() {
        BigApiInterface service = BigApiClient.getClient().create(BigApiInterface.class);
        Call<VoucherResponse> call = service.getVoucherByMembershipCode(getIntent().getStringExtra("name"));
        call.enqueue(new Callback<VoucherResponse>() {
            @Override
            public void onResponse(Call<VoucherResponse> call, Response<VoucherResponse> response) {
                if (response.body() == null) {
                    txtNotFound.setVisibility(View.VISIBLE);
                } else {
                    List<Voucher> vouchers = response.body().getData();
                    if(vouchers.isEmpty()){
                        txtNotFound.setVisibility(View.VISIBLE);
                    }else{
                        for (Voucher voucher : vouchers) {
                            itemGenerator.createPromotionRectangle(voucher.getCode(), voucher.getPromotionId(), mainLayout);
                        }
                        txtNotFound.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onFailure(Call<VoucherResponse> call, Throwable t) {
                Toast.makeText(BrandDetailActivity.this, "FAIL", Toast.LENGTH_SHORT).show();
                txtNotFound.setVisibility(View.VISIBLE);
            }
        });
    }

    private void getPoint() {
        String customerCode = db.getCustomerCode();
        Call<AccountResponse> call = membershipService.getAccount(customerCode);
        call.enqueue(new Callback<AccountResponse>() {
            @Override
            public void onResponse(Call<AccountResponse> call, Response<AccountResponse> response) {
                List<Account> accounts = response.body().getData();
                ((TextView) findViewById(R.id.txtPoint)).setText(
                        accounts.isEmpty() ? "0\nPOINT" : (accounts.get(0).getBalance() + "\nPOINT")
                );
            }

            @Override
            public void onFailure(Call<AccountResponse> call, Throwable t) {
                Toast.makeText(BrandDetailActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void clickToFinish(View view) {
        finish();
    }

    private void getBrandPromotion() {
        //get brand promotion
        BigApiInterface bigService = BigApiClient.getClient().create(BigApiInterface.class);
        Call<PromotionResponse> call1 = bigService.getPromotionById(31);
        call1.enqueue(new Callback<PromotionResponse>() {
            @Override
            public void onResponse(Call<PromotionResponse> call, Response<PromotionResponse> response) {
                //this is the list of promotion
                List<Promotion> list = response.body().getData();
                for (Promotion promotion : list) {
                    itemGenerator.createPromotionRectangle(promotion.getDescription(), promotion.getId(), mainLayout);
                }
            }

            @Override
            public void onFailure(Call<PromotionResponse> call, Throwable t) {
                Toast.makeText(BrandDetailActivity.this, "FAIL", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    private void getBrandData(int brandId) {
//        BrandApiInterface service = BrandApiClient.getClient().create(BrandApiInterface.class);
//        Call<Example> call = service.getBrandById(brandId);
//        call.enqueue(new Callback<Example>() {
//            @Override
//            public void onResponse(Call<Example> call, Response<Example> response) {
//                Datum data = response.body().getData();
//                List<ListStore> storeList = data.getListStore();
//                String addresses = "";
//                for (ListStore store : storeList) {
//                    addresses += "  +" + store.getName() + ":\n" + store.getAddress() + "\n";
//                }
//                if (addresses.isEmpty()) {
//                    addresses += "There is no address for this brand";
//                }
//                txtTitle.setText(data.getBrandName());
//                txtProfile.setText("-Created Date :\n" + UnitConverter.getDateString(data.getCreateDate()) + "\n" +
//                        "-Company :\n" + data.getCompanyName() + "\n"
//                );
//                txtExtend.setText("-Website :\n" + data.getWebsite() + "\n" +
//                        "-Contractor :\n" + data.getContactPerson() + "\n" +
//                        "-Phone No.:\n" + data.getPhoneNumber() + "\n" +
//                        "-Fax : \n" + data.getFax());
//                txtDesc.setText("-Description:\n" + data.getDescription());
//                txtAddresses.setText(addresses);
//            }
//
//            @Override
//            public void onFailure(Call<Example> call, Throwable t) {
//                System.out.println("FAIL");
//            }
//        });
//    }

    private boolean checkRegistered(String label) {
        for (Membership membership : UserSession.getUserMembership()) {
            if (membership.getBrandCode().equals(label)) {
                return true;
            }
        }
        return false;
    }

    private void addTab(String label, int layoutId) {
        TabHost.TabSpec spec = getTabHost().newTabSpec(label);
        spec.setIndicator(label);
        spec.setContent(layoutId);
        getTabHost().addTab(spec);
    }

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

    public void createMembership(final String brandName, final String customerCode) {
        btnRegister.setEnabled(false);
        MembershipToPost membershipToPost = new MembershipToPost(customerCode);
        membershipToPost.setBrandCode(brandName);
        Call<PostMembershipResponse> call1 = membershipService.postMemberShip(membershipToPost);
        call1.enqueue(new Callback<PostMembershipResponse>() {
            @Override
            public void onResponse(Call<PostMembershipResponse> call, Response<PostMembershipResponse> response) {
                int membershipId = response.body().getData().getId();
                createAccount(brandName, customerCode, membershipId);
                Membership membership = new Membership();
                membership.setBrandCode(brandName);
                UserSession.getUserMembership().add(membership);
                Toast.makeText(BrandDetailActivity.this,
                        "create membership ok, membershipID: " + membershipId,
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BrandDetailActivity.this, BrandDetailActivity.class);
                intent.putExtra("name", getIntent().getStringExtra("name"));
                intent.putExtra("website", getIntent().getStringExtra("website"));
                intent.putExtra("contract", getIntent().getStringExtra("contract"));
                intent.putExtra("fax", getIntent().getStringExtra("fax"));
                intent.putExtra("phone", getIntent().getStringExtra("phone"));
                intent.putExtra("description", getIntent().getStringExtra("description"));
                intent.putExtra("createDate", getIntent().getStringExtra("createDate"));
                intent.putExtra("company", getIntent().getStringExtra("company"));
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(Call<PostMembershipResponse> call, Throwable t) {
                btnRegister.setEnabled(true);
                Toast.makeText(BrandDetailActivity.this,
                        "Create membership fail",
                        Toast.LENGTH_SHORT).show();
                System.out.println(t.toString());
            }
        });
    }
}
