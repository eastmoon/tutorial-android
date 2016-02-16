package example.dynamiclayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare variable
        Button btn = null;

        // Defined Button 1 event
        // When click Button 1, start-up the activity, that is use to check basic translate time.
        btn = (Button) this.findViewById(R.id.Main_Button_1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get current time and record it.
                long time = System.currentTimeMillis();
                RuntimeTimeRecord.getInstance().setStartTime(time);
                Log.d("App-Log", "Start Time :" + time);
                // Start next activity.
                Intent intent = new Intent(MainActivity.this, EmptyActivity.class);
                startActivity(intent);
            }
        });

        // Defined Button 2 event
        // When click Button 2, start-up the activity, that Dynamic-Layout by layout resource XML file.
        btn = (Button) this.findViewById(R.id.Main_Button_2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get current time and record it.
                long time = System.currentTimeMillis();
                RuntimeTimeRecord.getInstance().setStartTime(time);
                Log.d("App-Log", "Start Time :" + time);
                // Start next activity.
                Intent intent = new Intent(MainActivity.this, DynamicLayoutByResourceFile.class);
                startActivity(intent);
            }
        });

        // Defined Button 3 event
        // When click Button 3, start-up the activity, that Dynamic-Layout by compound view component.
        btn = (Button) this.findViewById(R.id.Main_Button_3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get current time and record it.
                long time = System.currentTimeMillis();
                RuntimeTimeRecord.getInstance().setStartTime(time);
                Log.d("App-Log", "Start Time :" + time);
                // Start next activity.
                Intent intent = new Intent(MainActivity.this, DynamicLayoutByCompoundViewComponent.class);
                startActivity(intent);
            }
        });
    }
}
