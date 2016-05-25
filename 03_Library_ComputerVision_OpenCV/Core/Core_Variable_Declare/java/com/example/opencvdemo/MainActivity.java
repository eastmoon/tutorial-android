package com.example.opencvdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Point3;
import org.opencv.core.Rect;
import org.opencv.core.Size;


public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG = "App-Log:OpenCV Activity";
    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS:
                {
                    Log.i( LOG_TAG, "OpenCV loaded successfully");

                    // 宣告二維點 ( Point )
                    Point p_2d = new Point(1, 2);
                    Log.d("App-Log", "2D Point : " + p_2d.toString());
                    // 宣告三維點 ( Point3D )
                    Point3 p_3d = new Point3(p_2d);
                    Log.d("App-Log", "3D Point : " + p_3d.toString());
                    // 宣告尺寸資訊 ( Size )
                    Size s_2d = new Size(p_2d);
                    Log.d("App-Log", "Size : " + s_2d.toString());
                    // 宣告二維空間內單一矩形空間與位置 ( Size )
                    Rect rect = new Rect(p_2d, s_2d);
                    Log.d("App-Log", "Rect : " + rect.toString());
                    // 宣告矩陣( Mat )
                    Mat mat = new Mat(3, 3, CvType.CV_16SC1);
                    Log.d("App-Log", "Matrix : " + mat.toString());
                } break;
                default:
                {
                    super.onManagerConnected(status);
                } break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        if (!OpenCVLoader.initDebug()) {
            Log.d( LOG_TAG, "Internal OpenCV library not found. Using OpenCV Manager for initialization");
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, this, mLoaderCallback);
        } else {
            Log.d( LOG_TAG, "OpenCV library found inside package. Using it!");
            mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        }
    }
}
