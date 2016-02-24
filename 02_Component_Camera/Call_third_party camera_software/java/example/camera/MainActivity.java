package example.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void takePhoto(View v) {
        // Use intent object to call software who support image capture functional.
        Intent intent_camera = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent_camera, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        // Get image view.
        ImageView iv = (ImageView)findViewById(R.id.Main_ImageView);

        // If function have result.
        if (resultCode == RESULT_OK)
        {
            // Retrieve data in intent object.
            Bundle extras = intent.getExtras();
            // Translation data to Bitmap format.
            Bitmap bmp = (Bitmap) extras.get("data");
            // Set bitmap in image view.
            iv.setImageBitmap(bmp);
        }

        // Call parent function to finish event-flow.
        super.onActivityResult(requestCode, resultCode, intent);
    }
}
