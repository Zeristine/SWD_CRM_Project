package hieubt.projects.swd_crm_coffee.retrofit;


import hieubt.projects.swd_crm_coffee.Model.PromotionResponse;
import hieubt.projects.swd_crm_coffee.Model.VoucherResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BigApiInterface {

    @GET("promotions?active=true")
    Call<PromotionResponse> getAllPromotion();

    @GET("vouchers?active=true")
    Call<VoucherResponse> getAllVoucher();

}
