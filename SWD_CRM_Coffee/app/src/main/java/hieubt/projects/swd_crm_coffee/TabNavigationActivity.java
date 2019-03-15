package hieubt.projects.swd_crm_coffee;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class TabNavigationActivity extends TabActivity {

    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_navigation);

        tabHost = getTabHost();

        addCustomTab("Home", R.drawable.icons_home_config, new Intent(this, HomeActivity.class));
        addCustomTab("Point", R.drawable.icons_points_config, new Intent(this, PointActivity.class));
        addCustomTab("Notification", R.drawable.icons_notification_config, new Intent(this, NotificationActivity.class));
        addCustomTab("Account", R.drawable.icons_account_config, new Intent(this, AccountActivity.class));
        addCustomTab("Noti", R.drawable.icons_notification_config, new Intent(this, NotiActivity.class));

    }

    private void addCustomTab(String label, int drawableId, Intent intent) {
        TabHost.TabSpec tab = tabHost.newTabSpec(label);
        View tabIndicator = LayoutInflater.from(this).inflate(R.layout.layout_tab_with_icon, getTabWidget(), false);
        TextView txtTab = tabIndicator.findViewById(R.id.txtTab);
        txtTab.setText(label);
        ImageView imgTab = tabIndicator.findViewById(R.id.imgTab);
        imgTab.setImageResource(drawableId);
        tab.setIndicator(tabIndicator);
        tab.setContent(intent);
        tabHost.addTab(tab);
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Are you sure to log out?");
//        builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                TabNavigationActivity.super.onBackPressed();
//            }
//        });
//        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                //Do Nothing
//            }
//        });
//        builder.show();
//    }
//
//    private void showDialog() {
//        final Dialog dialog = new Dialog(this);
//        dialog.setTitle("Back to Login Screen!");
//        dialog.setContentView(R.layout.layout_dialog);
//        Button btnLogout = dialog.findViewById(R.id.btnYes);
//        Button btnCancel = dialog.findViewById(R.id.btnNo);
//        btnLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//                finish();
//            }
//        });
//        btnCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//        dialog.show();
//    }

}
