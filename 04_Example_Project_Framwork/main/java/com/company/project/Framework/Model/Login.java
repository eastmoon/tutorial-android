package com.company.project.Framework.Model;

import com.company.project.Framework.Control.ModelController;
import com.company.project.Pattern.Facade.ExceptionBox;
import com.company.project.Pattern.Proxy.WebServiceProxy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Jacky on 2016/3/16.
 */
public class Login extends WebServiceProxy {
    // Static Enum
    public static final String KEY_ID = "Login.Presentation.Model";
    // Member variable
    public String responseURL;
    // Constructor
    public Login() {
        // Call parent constructor
        super(Login.KEY_ID);
        // Register in model controller.
        ModelController.getInstances().register(this);
    }
    // Method : parse response.
    @Override
    public void parseResponse(String _response) {
        ExceptionBox.getInstances().message(_response, ExceptionBox.STYLE_LOG);
        this.responseURL = _response;
        super.parseResponse(_response);
    }
    // Method : on start-up remote proxy
    @Override
    public void onStartProxy() {
        super.onStartProxy();
    }
    // Method : on complete remote proxy
    @Override
    public void onCompleteProxy() {
        super.onCompleteProxy();
    }

    // HTTP connection method
    @Override
    protected String getURL() {
        return "http://www.roundsapp.com/post";
    }
    @Override
    protected String getAttribute() {
        JSONObject result = new JSONObject();
        try {
            result.put("winCondition", "HIGH_SCORE");
            result.put("name", "Bowling");
            result.put("round", 4);
            result.put("lastSaved", 1367711696);
            result.put("dateStarted", 1367702785);
            result.put("players", new JSONArray()
                            .put((new JSONObject()).put("name", "Player1")
                                    .put("history", new JSONArray("[10, 8, 6, 7, 8]"))
                                    .put("color", -13388315)
                                    .put("total", 39))
                            .put((new JSONObject()).put("name", "Player2")
                                    .put("history", new JSONArray("[6, 10, 5, 10, 10]"))
                                    .put("color", -48060)
                                    .put("total", 41))
            );
        } catch (JSONException e) {
            ExceptionBox.getInstances().message(e.toString());
        }
        return result.toString();
    }
    @Override
    protected String getHeader() {
        return null;
    }

}
