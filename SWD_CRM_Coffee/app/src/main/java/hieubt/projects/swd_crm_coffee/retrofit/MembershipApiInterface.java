package hieubt.projects.swd_crm_coffee.retrofit;

import hieubt.projects.swd_crm_coffee.Model.AccountResponse;
import hieubt.projects.swd_crm_coffee.Model.AccountToPost;
import hieubt.projects.swd_crm_coffee.Model.MembershipResponse;
import hieubt.projects.swd_crm_coffee.Model.MembershipToPost;
import hieubt.projects.swd_crm_coffee.Model.Mes;
import hieubt.projects.swd_crm_coffee.Model.MesObject;
import hieubt.projects.swd_crm_coffee.Model.PostMembershipResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MembershipApiInterface {

    @GET("memberships")
    Call<MembershipResponse> getMemberShipByCode(@Query("of_customer_code") String customerCode);

    @POST("memberships")
    Call<PostMembershipResponse> postMemberShip(@Body MembershipToPost membershipToPost);

    @GET("accounts")
    Call<AccountResponse> getAccount(@Query("codes") String customerCode);

    @POST("accounts")
    Call<Mes> postAccount(@Body AccountToPost accountToPost);

    @PATCH("accounts/add_point")
    Call<MesObject> addPoint(@Query("acc_code") String customerCode, @Query("point") int point);

    @PATCH("accounts/pay")
    Call<MesObject> payPoint(@Query("acc_code") String customerCode, @Query("amount") int amount);
}
