package hieubt.projects.swd_crm_coffee;

import android.app.ActionBar;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class NotificationActivity extends AppCompatActivity {

    private LinearLayout layoutNoti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        layoutNoti = findViewById(R.id.layoutNoti);
        DBManager db = new DBManager(this);
        List<NotiDTO> listNoti = db.getListNoti();
        for(int i = 0; i <listNoti.size();i++){
            createNotification(listNoti.get(i).getNotiBody());
        }
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
