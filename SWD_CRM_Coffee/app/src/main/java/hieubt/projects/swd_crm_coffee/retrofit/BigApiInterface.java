package hieubt.projects.swd_crm_coffee.retrofit;

import com.botab.retrofit_thayapi.Model.VoucherAnswer;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BigApiInterface {

    @GET("vouchers/")
    Call<VoucherAnswer> getAllVoucher();

}
