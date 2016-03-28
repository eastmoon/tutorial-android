package example.demoapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("App-log", "Sub Activity Create");

        TextView tv = (TextView) this.findViewById(R.id.TextView);
        tv.setText("Sub activity");

        Button btn = null;
        btn = (Button) this.findViewById(R.id.Button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SubActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
