package hieubt.projects.swd_crm_coffee.ultilities;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;

import hieubt.projects.swd_crm_coffee.R;

public class ColorGradient {

    public static GradientDrawable getBlueGradient(Context context){
        GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{
                        context.getResources().getColor(R.color.blueLight100),
                        context.getResources().getColor(R.color.blueLight200),
                        context.getResources().getColor(R.color.blueLight300)
                });
        gd.setCornerRadius(15f);
        return gd;
    }
}
