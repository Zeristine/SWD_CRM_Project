package hieubt.projects.swd_crm_coffee.retrofit;

import hieubt.projects.swd_crm_coffee.Model.CustomerToPost;
import hieubt.projects.swd_crm_coffee.Model.CustomerResponse;
import hieubt.projects.swd_crm_coffee.Model.Mes;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CustomerApiInterface {

    @POST("customers")
    Call<Mes> registNewBrand(@Body CustomerToPost customerToPost);

    @GET("customers")
    Call<CustomerResponse> getRegistedBrand(@Query("by_phone") String phoneNumber);

}
