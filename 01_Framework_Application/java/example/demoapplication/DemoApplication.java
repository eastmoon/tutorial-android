package example.demoapplication;

import android.app.Application;
import android.util.Log;


/**
 * Created by Chen on 2016/3/28.
 */
public class DemoApplication extends Application {
    public DemoApplication() {
        // Reference : http://developer.android.com/intl/zh-tw/reference/android/app/Application.html
        Log.d("App-log", "Application Constructor");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Called when the application is starting, before any activity, service, or receiver objects (excluding content providers) have been created.
        Log.d("App-log", "Application Create");

    }
}
