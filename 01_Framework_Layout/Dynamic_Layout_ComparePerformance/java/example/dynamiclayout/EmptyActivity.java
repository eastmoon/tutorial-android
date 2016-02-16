package example.dynamiclayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class EmptyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_layout);

        TextView text = (TextView) this.findViewById(R.id.DL_TextView);
        text.setText("Empty activity, use to check basic translate time.");

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
