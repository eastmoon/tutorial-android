package com.example.opencvdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
/*
◎ Import library
        1. File => New => Import module
        2. Source directory => \OpenCV-[Version]-android-sdk\OpenCV-android-sdk\java
        3. Download build tool by error message.
        4. Goto openCVLibrary[version] build.gradle.
            - modify compileSdkVersion and minSdkVersion to the library requested.
        5. Setting dependencies.

◎ Startup OpenCV
        1. Create BaseLoaderCallback, override onMangerConnected method
            - Reference : http://docs.opencv.org/java/2.4.9/org/opencv/android/BaseLoaderCallback.html
            onManagerConnected(int status)
            >> Callback method, called after OpenCV library initialization.
*/

public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG = "App-Log:OpenCV Activity";

    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS:
                {
                    Log.i(LOG_TAG, "OpenCV loaded successfully");
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
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_1_0, this, mLoaderCallback);
        } else {
            Log.d( LOG_TAG, "OpenCV library found inside package. Using it!");
            mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        }
    }
}
