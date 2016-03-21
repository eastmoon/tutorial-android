package com.company.project.Pattern.Proxy;

import com.company.project.Pattern.Facade.ExceptionBox;
import com.company.project.Pattern.Progress.Filter;
import com.company.project.Pattern.Proxy.Interface.IRemoteProxy;

/**
 * Created by Jacky on 2016/3/17.
 */
public class WaitsProxy extends WebServiceProxy {
    private long mWaitTime;
    // Constructor
    public WaitsProxy(String _keyID, long _millis) {
        super(_keyID);
        this.mWaitTime = _millis;
    }
    // IRemoteProxy method
    // Method : invoke web service.
    public void invokeWebService() {
        //ExceptionBox.getInstances().message("WaitsProxy Proxy : Invoke web service.", ExceptionBox.STYLE_LOG);
        try {
            // 1. create thread
            Thread thread = new Thread(mWaitsRunnable);
            // 2. start thread
            thread.start();
            Thread.sleep(mWaitTime);
            // 3. Waits for this thread to die.
            // Q : Long time waits problem ?
            thread.join();
            if (!thread.isAlive()) {
                this.parseResponse("");
            }
        } catch(InterruptedException e ) {
            //ExceptionBox.getInstances().message("Waits Proxy : " + e.toString());
            this.getProgress().setErrorMessage(e.toString());
        }
    }

    // Waits Thread
    private Runnable mWaitsRunnable = new Runnable() {
        @Override
        public void run() {
            ExceptionBox.getInstances().message("WaitsProxy Proxy : waiting...", ExceptionBox.STYLE_LOG);
        }
    };
}
