package hieubt.projects.swd_crm_coffee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickToNavigate(View view) {
        Intent intent = new Intent(this, TabNavigationActivity.class);
        startActivity(intent);
    }
}
