package hieubt.projects.swd_crm_coffee;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtUsername;
    private EditText txtPassword;
    private final int PERMISSION_REQUEST_CAMERA = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.CAMERA},
                    PERMISSION_REQUEST_CAMERA);
        }

        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
    }

    public void clickToNavigate(View view) {
        DBManager db = new DBManager(this);
        try {
            if (db.checkLogin(txtUsername.getText().toString(), txtPassword.getText().toString())) {
                Toast.makeText(this, "Welcome, " + txtUsername.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, TabNavigationActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void clickToRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CAMERA: {
                if (grantResults.length > 0) {
                    for (int i = 0; i < grantResults.length; i++) {
                        String permission = permissions[i];
                        int grantResult = grantResults[i];
                        if (permission.equals(Manifest.permission.CAMERA) && grantResult == PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        }
    }

}

