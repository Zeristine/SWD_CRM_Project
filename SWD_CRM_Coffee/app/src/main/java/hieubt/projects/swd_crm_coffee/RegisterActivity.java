package hieubt.projects.swd_crm_coffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText txtUsername, txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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
}
