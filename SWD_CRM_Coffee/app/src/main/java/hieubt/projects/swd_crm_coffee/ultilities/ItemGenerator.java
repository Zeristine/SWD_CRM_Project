package hieubt.projects.swd_crm_coffee.ultilities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import hieubt.projects.swd_crm_coffee.BrandDetailActivity;
import hieubt.projects.swd_crm_coffee.R;

public class ItemGenerator {

    private Context context;

    public ItemGenerator(@NotNull Context context) {
        this.context = context;
    }

    public void createRectangleWithLabel(final String label, final int brandId, final int userId, LinearLayout layout) {
        TextView textView = new TextView(context);

        GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{
                        context.getResources().getColor(R.color.blueLight100),
                        context.getResources().getColor(R.color.blueLight200),
                        context.getResources().getColor(R.color.blueLight300)
                });
        gd.setCornerRadius(15f);
        textView.setBackgroundDrawable(gd);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                , 200);
        layoutParams.leftMargin = 10;
        layoutParams.rightMargin = 10;
        layoutParams.topMargin = 5;
        layoutParams.bottomMargin = 5;
        textView.setLayoutParams(layoutParams);

        textView.setText(label);
        textView.setGravity(Gravity.CENTER);
        textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
        textView.setTextColor(context.getResources().getColor(R.color.black));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BrandDetailActivity.class);
                intent.putExtra("brandId", brandId);
                intent.putExtra("userId", userId);
                context.startActivity(intent);
            }
        });
        layout.addView(textView);
    }

    public void createBrandLabelWithButton(final String label, final int brandId, final int userId, LinearLayout layout) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                , 200);
        layoutParams.leftMargin = 10;
        layoutParams.rightMargin = 10;
        layoutParams.topMargin = 5;
        layoutParams.bottomMargin = 5;

        LinearLayout mainLayout = new LinearLayout(context);
        mainLayout.setOrientation(LinearLayout.HORIZONTAL);
        mainLayout.setBackgroundDrawable(ColorGradient.getBlueGradient(context));
        mainLayout.setWeightSum(20);
        mainLayout.setLayoutParams(layoutParams);

        TextView textView = new TextView(context);

        layoutParams = new LinearLayout.LayoutParams(0,
                ViewGroup.LayoutParams.MATCH_PARENT, 18);
        textView.setLayoutParams(layoutParams);

        textView.setText(label);
        textView.setGravity(Gravity.CENTER);
        textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
        textView.setTextColor(context.getResources().getColor(R.color.black));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BrandDetailActivity.class);
                intent.putExtra("brandId", brandId);
                intent.putExtra("userId", userId);
                context.startActivity(intent);
            }
        });

        Button button = new Button(context);
        layoutParams = new LinearLayout.LayoutParams(0,
                ViewGroup.LayoutParams.MATCH_PARENT, 2);
        button.setLayoutParams(layoutParams);


        mainLayout.addView(textView);
        layout.addView(mainLayout);
    }

    public void createPromotionRectangle(String label, final int promotionId, LinearLayout layout) {
        TextView textView = new TextView(context);
        textView.setText(label);
        textView.setGravity(Gravity.CENTER);
        textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
        textView.setTextColor(context.getResources().getColor(R.color.black));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context, BrandDetailActivity.class);
//                intent.putExtra("promotionId", promotionId);
//                context.startActivity(intent);
            }
        });

        layout.addView(textView);
    }
}
