package example.switchingactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Switching Activity by intent.
        // Take back button
        Button btn = (Button) this.findViewById(R.id.Main_Button);
        // Add click event listener in button.
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // New intent object.
                Intent intent = new Intent();
                // Defined class A (first assign) to class B (second assign)
                intent.setClass(MainActivity.this, IntentsActivity.class);
                // Execute intent object with startActivity function.
                startActivity(intent);
            }
        });
    }
}
