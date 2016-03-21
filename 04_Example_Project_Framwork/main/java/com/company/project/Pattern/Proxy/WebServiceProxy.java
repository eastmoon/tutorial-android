package com.company.project.Pattern.Proxy;

import com.company.project.Pattern.Facade.ExceptionBox;
import com.company.project.Pattern.Proxy.Interface.IAccessProxy;
import com.company.project.Pattern.Proxy.Interface.IRemoteProxy;
import com.company.project.Pattern.Progress.Filter;
import com.company.project.Pattern.Progress.Progress;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Iterator;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Jacky on 2016/3/15.
 */
public class WebServiceProxy extends Filter implements IRemoteProxy, IAccessProxy {
    // Static final variable
    protected static final MediaType MEDIA_JSON = MediaType.parse("application/json; charset=utf-8");
    // Static Enum
    public static final String ACCESS_TYPE_RESPONSE = "web.service.proxy.response";
    // Member variable
    private Progress mProgress;
    private OkHttpClient mClient;
    private String mResponse;
    // Constructor
    public WebServiceProxy(String _keyID) {
        super(_keyID);
        this.mProgress = null;
        this.mClient = new OkHttpClient();
        this.mResponse = "";
    }
    // Filter method
    @Override
    public void execute(Progress _progress) {
        // Remote proxy procedure
        // 0. Store progress
        this.mProgress = _progress;
        // 1. Prepare start proxy.
        this.onStartProxy();
        // 2. Start invoke web service in thread.
        this.invokeWebService();
        // 3. When HTTP connection over and retrieve response.
        // run parseResponse(mResponse).
        // 4. parse complete, than call complete proxy, and call progress.next
        // run onCompleteProxy().
    }
    // IAccessProxy method
    public JSONObject getData(String _sourceType) {
        JSONObject data = null;
        switch(_sourceType) {
            case WebServiceProxy.ACCESS_TYPE_RESPONSE :
            {
                try {
                    if(this.mResponse != null)
                        data = new JSONObject(this.mResponse);
                    else
                        throw new Exception("WebService Proxy : Response is null.");
                } catch(Exception e) {
                    this.mProgress.setErrorMessage("IAccessProxy : " + e.toString());
                }
                break;
            }
        }
        return data;
    }
    // IRemoteProxy method
    // Method : invoke web service.
    public void invokeWebService() {
        //ExceptionBox.getInstances().message("WebService Proxy : Invoke web service.", ExceptionBox.STYLE_LOG);
        try {
            // 1. create thread
            Thread thread = new Thread(mWebServiceRunnable);
            // 2. start thread
            thread.start();
            // 3. Waits for this thread to die.
            // Q : Long time waits problem ?
            thread.join();
            if (!thread.isAlive()) {
                this.parseResponse(this.mResponse);
            }
        } catch(InterruptedException e ) {
            this.mProgress.setErrorMessage("WebService Proxy : " + e.toString());
        }
    }
    // Method : parse response.
    public void parseResponse(String _response) {
        //ExceptionBox.getInstances().message("WebService Proxy : Parse response.", ExceptionBox.STYLE_LOG);
        this.onCompleteProxy();
    }
    // Method : on start-up remote proxy
    public void onStartProxy() {
        ExceptionBox.getInstances().message("WebService Proxy : on start-up proxy.", ExceptionBox.STYLE_LOG);
        // do nothing
    }
    // Method : on complete remote proxy
    public void onCompleteProxy() {
        ExceptionBox.getInstances().message("WebService Proxy : on complete proxy.", ExceptionBox.STYLE_LOG);
        // Filter complete, call progress to next step.
        Progress p = this.getProgress();
        if(p != null)
            p.nextStep();
    }

    // Get / Set method
    protected Progress getProgress() {
        return this.mProgress;
    }

    // HTTP connection
    protected boolean getConnectionMethodWithPOST() {
        return true;
    }
    protected String getURL() {
        return null;
    }
    protected String getAttribute() {
        return null;
    }
    protected String getHeader() {
        return null;
    }
    private String postMethod(String _url, String _attribute, String _header) throws IOException, JSONException {
        // 0. create request builder
        Request.Builder builder = new Request.Builder();
        // 1. assign url.
        builder.url(_url);
        // 2. assign POST attribute body.
        RequestBody body = RequestBody.create(MEDIA_JSON, _attribute);
        builder.post(body);
        // 3. assign connection header.
        if(_header != null) {
            JSONObject header = new JSONObject(_header);
            Iterator<String> iter = header.keys();
            while (iter.hasNext()) {
                String key = iter.next();
                builder.header(key, header.getString(key).toString());
            }
        }
        // 4. build request.
        Request request = builder.build();
        // 5. call web service.
        Response response = this.mClient.newCall(request).execute();
        // 6. return response string.
        return response.body().string();
    }
    private String getMethod(String _url) throws IOException {
        // 0. create request builder
        Request.Builder builder = new Request.Builder();
        // 1. assign url.
        builder.url(_url);
        // 2. build request.
        Request request = builder.build();
        // 3. call web service.
        Response response = this.mClient.newCall(request).execute();
        // 4. return response string.
        return response.body().string();
    }
    private void onServiceRunableComplete(String _response) {
        this.mResponse = _response;
    }
    private Runnable mWebServiceRunnable = new Runnable() {
        @Override
        public void run() {
            //ExceptionBox.getInstances().message("WebService Proxy : call web service.", ExceptionBox.STYLE_LOG);
            // 1. Get information for connection.
            String url = getURL();
            String attribute = getAttribute();
            String header = getHeader();
            String response = "";
            // 2. Connection to service.
            try {
                if (getConnectionMethodWithPOST()) {
                    response = postMethod(url, attribute, header);
                } else {
                    response = getMethod(url);
                }
            } catch (Exception e) {
                //ExceptionBox.getInstances().message(e.toString(), ExceptionBox.STYLE_LOG);
                mProgress.setErrorMessage(e.toString());
            }
            // 3. Complete service.
            onServiceRunableComplete(response);
        }
    };
}
