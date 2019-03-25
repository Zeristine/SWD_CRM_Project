package hieubt.projects.swd_crm_coffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;

import hieubt.projects.swd_crm_coffee.Model.MesObject;
import hieubt.projects.swd_crm_coffee.retrofit.MembershipApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.MembershipApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetPointActivity extends AppCompatActivity {

    private final DBManager db = new DBManager(this);
    MembershipApiInterface membershipService = MembershipApiClient.getClient().create(MembershipApiInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_point);
        String barcode = getIntent().getStringExtra("barcode");
        if(barcode == null){
            Toast.makeText(this, "No Barcode Existed!", Toast.LENGTH_SHORT).show();
            finish();
        }
        try{
            addPoint(Integer.parseInt(barcode));
        }catch (IOException e){
            e.printStackTrace();
            finish();
        }
    }

    private void addPoint(int pointAmount) throws IOException {
        String customerCode = db.getCustomerCode();
        Call<MesObject> call = membershipService.addPoint(customerCode, pointAmount);
        call.enqueue(new Callback<MesObject>() {
            @Override
            public void onResponse(Call<MesObject> call, Response<MesObject> response) {
                System.out.println("add point ok");
            }

            @Override
            public void onFailure(Call<MesObject> call, Throwable t) {
                System.out.println("add point fail");
                System.out.println(t.toString());
            }
        });

    }
}
