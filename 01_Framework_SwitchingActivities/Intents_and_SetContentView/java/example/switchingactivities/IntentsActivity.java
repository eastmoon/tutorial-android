package example.switchingactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final View contentView = getLayoutInflater().inflate(R.layout.activity_sub_view_2, null);
        final View intentView = getLayoutInflater().inflate(R.layout.activity_sub_view_1, null);

        setContentView(contentView);

        Button btn = null;
        btn = (Button) intentView.findViewById(R.id.SV1_Button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(contentView);
            }
        });

        btn = (Button) contentView.findViewById(R.id.SV2_Button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(intentView);
            }
        });
    }
}
