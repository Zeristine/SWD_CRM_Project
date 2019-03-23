package hieubt.projects.swd_crm_coffee;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;
import java.util.List;

import hieubt.projects.swd_crm_coffee.Model.Account;
import hieubt.projects.swd_crm_coffee.Model.AccountResponse;
import hieubt.projects.swd_crm_coffee.Model.Mes;
import hieubt.projects.swd_crm_coffee.Model.MesObject;
import hieubt.projects.swd_crm_coffee.retrofit.BigApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.BigApiInterface;
import hieubt.projects.swd_crm_coffee.retrofit.BrandApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.BrandApiInterface;
import hieubt.projects.swd_crm_coffee.retrofit.MembershipApiClient;
import hieubt.projects.swd_crm_coffee.retrofit.MembershipApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PointActivity extends AppCompatActivity {

    SurfaceView cameraPreview;
    TextView txtResult;
    BarcodeDetector barcodeDetector;
    CameraSource cameraSource;
    final int RequestCameraPermissionID = 1001;
    private final DBManager db = new DBManager(this);
    MembershipApiInterface membershipService = MembershipApiClient.getClient().create(MembershipApiInterface.class);
    BigApiInterface bigSerivce = BigApiClient.getClient().create(BigApiInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);

        cameraPreview = findViewById(R.id.cameraPreview);
        txtResult = findViewById(R.id.txtResult);

        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.QR_CODE)
                .build();
        cameraSource = new CameraSource
                .Builder(this, barcodeDetector)
                .setRequestedPreviewSize(640, 480)
                .build();

        cameraPreview.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(PointActivity.this,
                            new String[]{Manifest.permission.CAMERA}, RequestCameraPermissionID);
                    return;
                }
                try {
                    cameraSource.start(cameraPreview.getHolder());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> qrcodes = detections.getDetectedItems();
                if(qrcodes.size() != 0){
                    txtResult.post(new Runnable() {
                        @Override
                        public void run() {
                            Vibrator vibrator = (Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                            vibrator.vibrate(1000);
                            txtResult.setText(qrcodes.valueAt(0).displayValue);
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case RequestCameraPermissionID: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    try {
                        cameraSource.start(cameraPreview.getHolder());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //add point to membership's account
    public void addPoint(int pointAmount) throws IOException {
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
    //get point
    public int getPoint() {
        String customerCode = db.getCustomerCode();
        Call<AccountResponse> call = membershipService.getAccount(customerCode);
        try {
            Response<AccountResponse> response = call.execute();
            Account account = response.body().getData().get(0);

            return account.getBalance();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }
    //pay point
    public void payPoint(int amount) {
        String customerCode = db.getCustomerCode();
        Call<MesObject> call = membershipService.payPoint(customerCode, amount);
        call.enqueue(new Callback<MesObject>() {
            @Override
            public void onResponse(Call<MesObject> call, Response<MesObject> response) {
                System.out.println("pai point ok");
            }

            @Override
            public void onFailure(Call<MesObject> call, Throwable t) {
                System.out.println("pay point fail");
            }
        });
    }
    //post voucher
    public void postVoucher() {
        Call<Mes> call = bigSerivce.postVoucherByPromotionId(31, 1, 1);
        call.enqueue(new Callback<Mes>() {
            @Override
            public void onResponse(Call<Mes> call, Response<Mes> response) {
                System.out.println("post voucher ok");
            }

            @Override
            public void onFailure(Call<Mes> call, Throwable t) {
                System.out.println("post voucher fail");
            }
        });
    }
}
