package hieubt.projects.swd_crm_coffee;

import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class PointActivity extends AppCompatActivity {

    private SurfaceView surfaceView;
    private Camera camera;
    private SurfaceHolder surfaceHolder;
    private DisplayMetrics displayMetrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        surfaceView = findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                (displayMetrics.heightPixels*3)/5);
        layoutParams.leftMargin = 20;
        layoutParams.rightMargin = 20;
        surfaceView.setLayoutParams(layoutParams);
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                camera = Camera.open();
                camera.setDisplayOrientation(90);
                try {
                    camera.setPreviewDisplay(holder);
                } catch (Exception ex) {
                    camera.release();
                    camera = null;
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                camera.startPreview();
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                camera.stopPreview();
                camera.release();
                camera = null;
            }
        });
    }
}
