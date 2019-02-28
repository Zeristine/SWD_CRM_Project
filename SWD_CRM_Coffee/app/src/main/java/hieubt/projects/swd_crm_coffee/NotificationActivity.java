package hieubt.projects.swd_crm_coffee;

import android.app.ActionBar;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {

    private LinearLayout layoutNoti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        layoutNoti = findViewById(R.id.layoutNoti);

        createNotification("50% Discount to Coffee House's product");
        createNotification("50% Discount to StarBuck's product");
        createNotification("70% Discount to Coffee House's product");
        createNotification("Event : Halloween at Coffee House");
        createNotification("Event : Halloween at StarBuck");
        createNotification("Mr. Coffee's 1st day opening sale");
        createNotification("50% Discount to Coffee House's product");
    }

    private void createNotification(String label){
        TextView textView = new TextView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 160);
        layoutParams.leftMargin = 10;
        layoutParams.rightMargin = 10;
        layoutParams.topMargin = 5;
        layoutParams.bottomMargin = 5;
        textView.setLayoutParams(layoutParams);
        textView.setBackgroundColor(getResources().getColor(R.color.blueLightA400));
        textView.setText(label);
        textView.setGravity(Gravity.CENTER);
        layoutNoti.addView(textView);
    }
}
