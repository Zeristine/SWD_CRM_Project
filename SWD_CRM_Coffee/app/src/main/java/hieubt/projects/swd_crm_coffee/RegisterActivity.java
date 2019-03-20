package hieubt.projects.swd_crm_coffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DBManager db = new DBManager(this);
    private EditText txtUsername, txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //if phone already had, move to home activity
        String phoneNumber = db.getPhoneNumber();
        if (!phoneNumber.isEmpty()) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
    }

    public void clickToRegis(View view) {
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        
        DBManager db = new DBManager(this);
        try{
            if(db.registed(txtUsername.getText().toString(),txtPassword.getText().toString())){
                Toast.makeText(this, "You've registered", Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(this, "Something went wrong! Please try again.", Toast.LENGTH_SHORT).show();
            } 
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        
        
    }

    public void clickToRegisByPhone(View view) {
        EditText txtPhoneNumber = findViewById(R.id.txtPhoneNumber);
        String phoneNumber = txtPhoneNumber.getText().toString();
        db.setPhoneNumber(phoneNumber);
        db.setCustomerCode(phoneNumber); //customer code == phone number

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
