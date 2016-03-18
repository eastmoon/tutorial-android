package com.company.project.Pattern.Proxy.Interface;

import org.json.JSONObject;

/**
 * Created by Jacky on 2016/3/17.
 */
public interface IAccessProxy {
    // Proxy concept : Access data in proxy.

    // Method : invoke web service.
    JSONObject getData(String _sourceType);
}
