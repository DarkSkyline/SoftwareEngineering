package com.es2.Bridge;

import java.util.HashMap;

public class APIRequest extends Object{

    protected HashMap<String, APIServiceInterface> services;

    public APIRequest() {}

    public String addService(APIServiceInterface service) {
        return "";
    }

    public String getContent(String serviceId, String contentId) throws ServiceNotFoundException {
        return "";
    }

    public String setContent(String serviceId, String content){
        return "";
    }
}
