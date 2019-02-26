package hieubt.projects.swd_crm_coffee;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
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
}
