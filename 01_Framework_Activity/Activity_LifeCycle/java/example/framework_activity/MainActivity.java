package example.framework_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.InitialImageView();
        Log.d("App-log", "The activity is being created.");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("App-log", "The activity is about to become visible.");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("App-log", "The activity has become visible (it is now \"resumed\").");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("App-log", "Another activity is taking focus (this activity is about to be \"paused\").");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("App-log", "The activity is no longer visible (it is now \"stopped\").");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("App-log", "The activity is about to be destroyed.");
    }

    private void InitialImageView() {
        // Take back image view.
        ImageView iv = (ImageView) this.findViewById(R.id.imageView);
        // Setting image resource in Drawable folder.
        iv.setImageResource(R.drawable.activity_lifecycle);
    }
}
