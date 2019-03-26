package hieubt.projects.swd_crm_coffee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

import hieubt.projects.swd_crm_coffee.Model.Membership;
import hieubt.projects.swd_crm_coffee.ultilities.UserSession;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
    }

    public void clickToLogout(View view) {
        UserSession.setUserMembership(new ArrayList<Membership>());
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("isLogout", 1);
        startActivity(intent);
    }


}
