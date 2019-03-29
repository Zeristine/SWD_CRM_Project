package hieubt.projects.swd_crm_coffee;

import android.Manifest;
import android.app.TabActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class TabNavigationActivity extends TabActivity {

    private TabHost tabHost;
    private String prevTabId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_navigation);

        tabHost = getTabHost();

        addCustomTab("Home", R.drawable.icons_home_config, new Intent(this, HomeActivity.class));
        addCustomTab("Point", R.drawable.icons_points_config, new Intent(this, PointActivity.class));
        addCustomTab("Notification", R.drawable.icons_notification_config, new Intent(this, NotificationActivity.class));
        addCustomTab("Account", R.drawable.icons_account_config, new Intent(this, AccountActivity.class));
 //       addCustomTab("Noti", R.drawable.icons_notification_config, new Intent(this, NotiActivity.class));

        tabHost.setCurrentTabByTag("Home");
        prevTabId = tabHost.getCurrentTabTag();

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                setTextColorSelectionForTab();
                if (tabId.equals("Point")) {
                    if (ActivityCompat.checkSelfPermission(TabNavigationActivity.this, Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(TabNavigationActivity.this, "Please request permission from another time",
                                Toast.LENGTH_SHORT).show();
                        tabHost.setCurrentTabByTag(prevTabId);
                    } else {
                        prevTabId = tabId;
                    }
                } else {
                    prevTabId = tabId;
                }
            }
        });
        for (int i = 0; i < getTabWidget().getTabCount(); i++) {
            View v = getTabWidget().getChildTabViewAt(i);
            v.setBackgroundResource(R.drawable.brand_tab_indicator);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTextColorSelectionForTab();
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

    private void setTextColorSelectionForTab() {
        for (int i = 0; i < getTabWidget().getChildCount(); i++) {
            TextView tv = getTabWidget().getChildAt(i).findViewById(R.id.txtTab);
            tv.setTextColor(getResources().getColor(R.color.black));
        }

        TextView tv = getTabHost().getCurrentTabView().findViewById(R.id.txtTab);
        tv.setTextColor(getResources().getColor(R.color.white));
    }
}
