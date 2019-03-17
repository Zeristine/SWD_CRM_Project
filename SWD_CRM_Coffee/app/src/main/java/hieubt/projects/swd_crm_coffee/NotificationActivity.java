package hieubt.projects.swd_crm_coffee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
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
        for (int i = 0; i < listNoti.size(); i++) {
            createNotification(listNoti.get(i).getNotiTitle(), listNoti.get(i).getNotiBody());
        }
    }

    private void createNotification(String title, String content) {
        View view = getLayoutInflater().inflate(R.layout.layout_notification, layoutNoti, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.leftMargin = 10;
        layoutParams.rightMargin = 10;
        layoutParams.topMargin = 5;
        layoutParams.bottomMargin = 5;
        TextView lblTitle = view.findViewById(R.id.lblTitle);
        TextView lblContent = view.findViewById(R.id.lblContent);
        lblTitle.setText(title);
        lblContent.setText(content);
        view.setLayoutParams(layoutParams);
        layoutNoti.addView(view);
    }
}
