package example.dynamiclayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class DynamicLayoutByResourceFile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_layout);

        // Defined activity label content.
        TextView text = (TextView) this.findViewById(R.id.DL_TextView);
        text.setText("Layout content created by resource XML file.");

        // Defined Dynamic-Layout
        int i, j;
        // 1. Get layout resource file.
        LinearLayout layout = (LinearLayout) this.findViewById(R.id.DL_DynamicLayout);
        // 2. Check button amount in layout.
        ArrayList btnIDList = new ArrayList();
        int id = 0;
        i = 1;
        while ((id = this.getResources().getIdentifier("COM_AlertButton_" + i, "id", this.getPackageName())) != 0) {
            btnIDList.add(id);
            i++;
        }
        // 3. Dynamic create button layout and event.
        for(i = 0 ; i < RuntimeTimeRecord.MAX_BUTTON_SIZE ; i++) {
            // 3-0. Retrieve component layout
            View children = this.getLayoutInflater().inflate(R.layout.component_alert_button, null);
            Button btn = null;
            for(j = 0 ; j < btnIDList.size() ; j++ ) {
                // 3-1. Get Button ID from ID list.
                id = (int)btnIDList.get(j);
                btn = (Button) children.findViewById(id);
                // 3-2. Setting button text.
                btn.setText(String.format("%05d", i * 5 + j));
                // 3-3. Setting button event.
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 3-4. When button click, alert message.
                        new AlertDialog.Builder(DynamicLayoutByResourceFile.this)
                                .setTitle("Alert Message")
                                .setMessage("Button number is " + ((Button)v).getText().toString())
                                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // do nothing
                                    }
                                })
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                    }
                });
            }
            // 3-5. Add component layout.
            layout.addView(children);
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
