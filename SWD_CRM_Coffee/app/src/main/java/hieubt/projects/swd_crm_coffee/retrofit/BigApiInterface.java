package hieubt.projects.swd_crm_coffee.retrofit;


import hieubt.projects.swd_crm_coffee.Model.PromotionResponse;
import hieubt.projects.swd_crm_coffee.Model.VoucherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BigApiInterface {

    @GET("promotions")
    Call<PromotionResponse> getAllPromotion();

    @GET("promotions")
    Call<PromotionResponse> getPromotionById(@Query("ids") int id);

    @GET("vouchers")
    Call<VoucherResponse> getAllVoucher();

    @GET("vouchers")
    Call<VoucherResponse> getVoucherByPromotionId(@Query("of_promotion_id") int id);
}
