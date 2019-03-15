package hieubt.projects.swd_crm_coffee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtUsername;
    private EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}

