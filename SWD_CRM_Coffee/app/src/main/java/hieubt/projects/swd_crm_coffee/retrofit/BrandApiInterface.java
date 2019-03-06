package hieubt.projects.swd_crm_coffee.retrofit;

import hieubt.projects.swd_crm_coffee.Model.Datum;
import hieubt.projects.swd_crm_coffee.Model.Example;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BrandApiInterface {

    //get all brand
    @GET("read/")
    Call<Datum> getAllBrand();

    //for searching brand
    @GET("read/")
    Call<Datum> searchBrand(@Query("name") String name);

    //get a brand by id
    @GET("read/{id}")
    Call<Example> getBrandById(@Path("id") int id);

}
