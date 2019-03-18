package hieubt.projects.swd_crm_coffee;

import android.content.Intent;

import java.io.IOException;
import java.util.List;

import hieubt.projects.swd_crm_coffee.Model.Customer;
import hieubt.projects.swd_crm_coffee.Model.CustomerMetadata;
import hieubt.projects.swd_crm_coffee.Model.CustomerResponse;
import hieubt.projects.swd_crm_coffee.retrofit.CustomerApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.CustomerApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PointManage {

    CustomerApiInterface customerService = CustomerApiClient.getClient().create(CustomerApiInterface.class);
    Customer customer = null;
    //cộng điểm cho customer
    //actions: get customer, update point, post to api again
    //this code is fucking terrible but i dont know other way, sorry :((
    public void addPoint(String phoneNumber, String brandName, int amount_of_point) {
        Call<CustomerResponse> call = customerService.getRegistedBrand(phoneNumber);
        try {
            Response<CustomerResponse> response =  call.execute();
            //list of customer
            List<Customer> list = response.body().getData();
            for (Customer c : list) {
                if (brandName.equals(c.getBrandCode())) {
                    //this is the customer we need
                    customer = c;
                    break;
                }
            }

            //update point
            CustomerMetadata customerMetadata =  customer.getCustomerMetadata().get(0);
            int currentPoint = Integer.parseInt(customerMetadata.getValue());
            currentPoint += amount_of_point;

            //post to api again
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

}
