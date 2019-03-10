package hieubt.projects.swd_crm_coffee;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import hieubt.projects.swd_crm_coffee.Model.Voucher;
import hieubt.projects.swd_crm_coffee.Model.VoucherResponse;
import hieubt.projects.swd_crm_coffee.retrofit.BigApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.BigApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VoucherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //show all voucher
        BigApiInterface service = BigApiClient.getClient().create(BigApiInterface.class);
        Call<VoucherResponse> call = service.getAllVoucher();
        call.enqueue(new Callback<VoucherResponse>() {
            @Override
            public void onResponse(Call<VoucherResponse> call, Response<VoucherResponse> response) {
                //this is list of vouchers
                List<Voucher> list = response.body().getData();
            }

            @Override
            public void onFailure(Call<VoucherResponse> call, Throwable t) {
                System.out.println("FAIL");
            }
        });
    }

}
