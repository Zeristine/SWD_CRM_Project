package hieubt.projects.swd_crm_coffee;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout layoutHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        layoutHome = findViewById(R.id.layoutHome);

        createBrands("The Coffee House");
        createBrands("StarBuck");
        createBrands("Quang Trung Coffee");
    }

    private void createBrands(String label){
        TextView textView = new TextView(this);

        GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{
                        getResources().getColor(R.color.blueLight100),
                        getResources().getColor(R.color.blueLight200),
                        getResources().getColor(R.color.blueLight300)
                });
        gd.setCornerRadius(15f);
        textView.setBackgroundDrawable(gd);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 160);
        layoutParams.leftMargin = 10;
        layoutParams.rightMargin = 10;
        layoutParams.topMargin = 5;
        layoutParams.bottomMargin = 5;
        textView.setLayoutParams(layoutParams);

        textView.setText(label);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(getResources().getColor(R.color.black));
        layoutHome.addView(textView);
    }
}
