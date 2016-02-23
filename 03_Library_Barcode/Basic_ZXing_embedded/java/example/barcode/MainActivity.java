package example.barcode;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    // Member variable, translation scan result to url link
    private String mLinkURL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scanBar(View view) {
        this.scanCode("PRODUCT_MODE", null, "Scan 1D Barcode");
    }

    public void scanQR(View view) {
        this.scanCode("QR_CODE_MODE", null, "Scan 2D QRCode");
    }

    public void linkTo(View view) {
        if(mLinkURL != "")
        {
            Uri uri = Uri.parse(mLinkURL);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException anfe) {

            }
        }
    }

    //scan by ZXing
    private void scanCode(String scan_mode, String scan_format, String prompt) {
        // Default scan declare
        //new IntentIntegrator(this).initiateScan(IntentIntegrator.QR_CODE_TYPES);

        // Design scan integrator object.
        IntentIntegrator integrator = new IntentIntegrator(this);
        if(scan_mode != null)
            integrator.addExtra("SCAN_MODE", scan_mode);
        if(scan_format != null)
            integrator.addExtra("SCAN_MODE", scan_mode);
        if(prompt != null)
            integrator.setPrompt(prompt);
        integrator.setCameraId(0);
        integrator.setOrientationLocked(true);
        integrator.setCaptureActivity(CaptureActivityPortrait.class);
        integrator.initiateScan();
    }
    //on ActivityResult method
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        // Retrieve scan result
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        String contents = result.getContents();
        String format = result.getFormatName();

        if(result != null) {
            if(contents == null) {
                // if content is null, When Scan is failed, like back navigation.
                Toast.makeText(this, "Scan Cancelled", Toast.LENGTH_LONG).show();
            } else {
                // Find target
                Toast toast = null;
                Button btn = (Button) this.findViewById(R.id.Main_Button_LinkTo);
                switch(format)
                {
                    case "EAN_13" : {
                        toast = Toast.makeText(this, "ISBN:" + contents, Toast.LENGTH_LONG);
                        mLinkURL = "http://www.isbnsearch.org/isbn/" + contents;
                        btn.setText("Link To ISBN Searcher");
                    }
                    break;
                    case "QR_CODE" : {
                        toast = Toast.makeText(this, "URL:" + contents , Toast.LENGTH_LONG);
                        mLinkURL = contents;
                        btn.setText("Link To WebSite");
                    }
                    break;
                    default : {
                        toast = Toast.makeText(this, "Content:" + contents + " Format:" + format, Toast.LENGTH_LONG);
                        mLinkURL = "";
                        btn.setText("Link To");
                    }
                    break;
                }
                toast.show();
                Toast.makeText(this, "Scanned: " + result.getContents() + ", Format:" + result.getFormatName(), Toast.LENGTH_LONG).show();
            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, intent);
        }
    }
}
