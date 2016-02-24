package example.barcode;

import android.support.v7.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.qrcode.QRCodeWriter;

public class MainActivity extends AppCompatActivity {

    private ImageView mCodeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting ImageView
        mCodeView = (ImageView)this.findViewById(R.id.Main_CodeImageView);
        mCodeView.setDrawingCacheEnabled(true);
    }

    public void drawQRCode(View v) {
        // Generate code
        Bitmap bmp = this.generateCode("http://www.google.com.tw",
                new QRCodeWriter(),
                BarcodeFormat.QR_CODE,
                350, 350);
        // Draw code on view
        if (bmp != null) {
            this.mCodeView.setImageBitmap(bmp);
        }
    }

    public void drawBarCode(View v) {
        // Generate code
        Bitmap bmp = this.generateCode("9780321127426",
                new EAN13Writer(),
                BarcodeFormat.EAN_13,
                550, 150);
        // Draw code on view
        if (bmp != null) {
            this.mCodeView.setImageBitmap(bmp);
        }
    }

    //Change the writers as per your need
    private Bitmap generateCode(String data,
                                com.google.zxing.Writer writer,
                                com.google.zxing.BarcodeFormat fromat,
                                int width,
                                int height) {
        Log.d("App-Log", "Code input : " + data);
        Bitmap bmp = null;
        String finaldata = Uri.encode(data);
        try {
            BitMatrix bm = writer.encode(finaldata, fromat, width, height);
            bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    bmp.setPixel(i, j, bm.get(i, j) ? Color.BLACK: Color.WHITE);
                }
            }
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return bmp;
    }
}
