package hieubt.projects.swd_crm_coffee.ultilities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import hieubt.projects.swd_crm_coffee.BrandDetailActivity;
import hieubt.projects.swd_crm_coffee.Model.Datum;
import hieubt.projects.swd_crm_coffee.R;
import hieubt.projects.swd_crm_coffee.VoucherDetailActivity;

public class ItemGenerator {

    private Context context;

    public ItemGenerator(@NotNull Context context) {
        this.context = context;
    }

    public void createRectangleWithLabel(final Datum data, LinearLayout layout, String isRegistered) {
        TextView textView = new TextView(context);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                , 200);
        layoutParams.leftMargin = 10;
        layoutParams.rightMargin = 10;
        layoutParams.topMargin = 5;
        layoutParams.bottomMargin = 5;
        textView.setLayoutParams(layoutParams);

        textView.setText(data.getBrandName());
        textView.setGravity(Gravity.CENTER);
        textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
        if (isRegistered == null) {
            textView.setBackgroundResource(R.drawable.shape_brand_registered_not);
            textView.setTextColor(context.getResources().getColor(R.color.black));
        } else {
            switch (isRegistered) {
                case "true":
                    textView.setBackgroundResource(R.drawable.shape_brand_registered);
                    textView.setTextColor(context.getResources().getColor(R.color.black));
                    textView.setText(data.getBrandName() + "\n(Registered)");
                    break;
                case "false":
                    textView.setBackgroundResource(R.drawable.shape_brand_registered_not);
                    textView.setTextColor(context.getResources().getColor(R.color.black));
                    break;
            }
        }
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BrandDetailActivity.class);
                intent.putExtra("id", data.getId());
                intent.putExtra("name", data.getBrandName());
                intent.putExtra("website", data.getWebsite());
                intent.putExtra("contract", data.getContactPerson());
                intent.putExtra("fax", data.getFax());
                intent.putExtra("phone", data.getPhoneNumber());
                intent.putExtra("description", data.getDescription());
                intent.putExtra("createdDate", data.getCreateDate());
                intent.putExtra("company", data.getCompanyName());
                intent.putExtra("address", data.getAddress());
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
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);

        textView.setBackgroundDrawable(ColorGradient.getBlueGradient(context));

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                , 200);
        layoutParams.leftMargin = 10;
        layoutParams.rightMargin = 10;
        layoutParams.topMargin = 5;
        layoutParams.bottomMargin = 5;
        textView.setLayoutParams(layoutParams);

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

    public void createVoucherRectangle(String label, final String voucherCode, LinearLayout layout) {
        TextView textView = new TextView(context);
        textView.setText(label);
        textView.setGravity(Gravity.CENTER);
        textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
        textView.setTextColor(context.getResources().getColor(R.color.black));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);

        textView.setBackgroundDrawable(ColorGradient.getBlueGradient(context));

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                , 200);
        layoutParams.leftMargin = 10;
        layoutParams.rightMargin = 10;
        layoutParams.topMargin = 5;
        layoutParams.bottomMargin = 5;
        textView.setLayoutParams(layoutParams);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VoucherDetailActivity.class);
                intent.putExtra("voucherCode", voucherCode);
                context.startActivity(intent);
            }
        });

        layout.addView(textView);
    }

    public void createNotification() {

    }
}
