package hieubt.projects.swd_crm_coffee;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import hieubt.projects.swd_crm_coffee.Model.AccountResponse;
import hieubt.projects.swd_crm_coffee.Model.AccountToPost;
import hieubt.projects.swd_crm_coffee.Model.Membership;
import hieubt.projects.swd_crm_coffee.Model.MembershipResponse;
import hieubt.projects.swd_crm_coffee.Model.MembershipToPost;
import hieubt.projects.swd_crm_coffee.Model.Mes;
import hieubt.projects.swd_crm_coffee.Model.MesObject;
import hieubt.projects.swd_crm_coffee.Model.PromotionResponse;
import hieubt.projects.swd_crm_coffee.Model.VoucherResponse;
import hieubt.projects.swd_crm_coffee.retrofit.BigApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.BigApiInterface;
import hieubt.projects.swd_crm_coffee.retrofit.MembershipApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.MembershipApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.*;

public class HomeActivityTest {

    @Test
    public void onCreate() {
    }

    @Test
    public void onResume() {
    }
    @Test
    public void tete() throws IOException {
        System.out.println("lingling company");
        MembershipApiInterface membershipService = MembershipApiClient.getClient().create(MembershipApiInterface.class);
        MembershipToPost membershipToPost = new MembershipToPost("123456");
        membershipToPost.setBrandCode("PASSIO");
        Call<Mes> call1 = membershipService.postMemberShip(membershipToPost);
        call1.enqueue(new Callback<Mes>() {
            @Override
            public void onResponse(Call<Mes> call, Response<Mes> response) {
            }

            @Override
            public void onFailure(Call<Mes> call, Throwable t) {
                System.out.println("create membership fail");
            }
        });
    }
}