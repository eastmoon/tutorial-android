package example.dynamiclayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DynamicLayoutByCompoundViewComponent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_layout);

        TextView text = (TextView) this.findViewById(R.id.DL_TextView);
        text.setText("Layout content created by compound view component.");

        // 1. Get layout resource file.
        LinearLayout layout = (LinearLayout) this.findViewById(R.id.DL_DynamicLayout);
        // 2. Create component.
        for(int i = 0 ; i < RuntimeTimeRecord.MAX_BUTTON_SIZE ; i++ ) {
            ComponentAlertButton component = new ComponentAlertButton(this, i);
            // 3. Add component.
            layout.addView(component);
        }

        this.onEnterAnimationComplete();
    }

    @Override
    public void onEnterAnimationComplete() {
        // Get current time and record it.
        long time = System.currentTimeMillis();
        RuntimeTimeRecord record = RuntimeTimeRecord.getInstance();
        record.setEndTime(time);
        Log.d("App-Log", "End Time :" + time);
        // Get time difference.
        Log.d("App-Log", "Time Difference :" + record.getTimeDifference());
        // Show time difference on performance text view.
        TextView text = (TextView) this.findViewById(R.id.DL_PerformanceTextView);
        text.setText("Time : " + record.getTimeDifference() + " ms");
    }
}
