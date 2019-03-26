package hieubt.projects.swd_crm_coffee.retrofit;


import hieubt.projects.swd_crm_coffee.Model.Mes;
import hieubt.projects.swd_crm_coffee.Model.MesObject;
import hieubt.projects.swd_crm_coffee.Model.PromotionResponse;
import hieubt.projects.swd_crm_coffee.Model.VoucherResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BigApiInterface {

    @GET("promotions")
    Call<PromotionResponse> getAllPromotion();

    @GET("promotions")
    Call<PromotionResponse> getPromotionById(@Query("ids") int id);

    @GET("vouchers")
    Call<VoucherResponse> getAllVoucher();

    @GET("vouchers")
    Call<VoucherResponse> getVoucherByPromotionId(@Query("of_promotion_id") int promotionId);

    @GET("vouchers")
    Call<VoucherResponse> getVoucherByMembershipCode(@Query("of_membership_code") String membershipCode);

    @POST("vouchers")
    Call<Mes> postVoucherByPromotionId(@Query("of_promotion_id") int promotionId, @Query("amount") int amount, @Query("apply_range") int applyRange);

    @PATCH("vouchers")
    Call<MesObject> giveVoucher(@Query("to_membership_code") String membershipCode, @Field("voucher_codes") String voucherCode);
}
