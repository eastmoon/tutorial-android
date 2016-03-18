package com.company.project.Pattern.Proxy.Interface;

/**
 * Created by Jacky on 2016/3/16.
 */
public interface IRemoteProxy {
    // Proxy concept : Call remote web service, and store or run response.

    // Method : invoke web service.
    void invokeWebService();
    // Method : parse response.
    void parseResponse(String _response);
    // Method : on start-up remote proxy
    void onStartProxy();
    // Method : on complete remote proxy
    void onCompleteProxy();
}
