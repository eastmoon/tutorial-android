package example.dimension;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        // Get current activity conetent view.
        View cv = this.findViewById(android.R.id.content).getRootView();

        /*  DiaplayMetrics :
        A structure describing general information about a display, such as its size, density, and font scaling.
         */
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);

        TextView tv = (TextView) this.findViewById(R.id.Main_TextView);
        String screenInfo = "";
        screenInfo += "Width (px) : " + dm.widthPixels + ", (dp) : " + this.px2dp(dm.widthPixels) + "\n";
        screenInfo += "Height (px) : " + dm.heightPixels + ", (dp) : " + this.px2dp(dm.heightPixels) + "\n";
        screenInfo += "DPI : " + dm.densityDpi + ", Font Scale : " + dm.scaledDensity + ", Density : " + dm.density + "\n";
        screenInfo += "Activity Width(px) : " + tv.getRight() + ", Height(px) : " + tv.getBottom() + "\n";
        tv.setText(screenInfo);

        Button btn = (Button) this.findViewById(R.id.Main_Button);
        btn.setY((tv.getBottom() - btn.getHeight()) );
    }

    private float px2dp(float _value) {
        return ((_value * 160) / this.getResources().getDisplayMetrics().densityDpi);
    }
}
