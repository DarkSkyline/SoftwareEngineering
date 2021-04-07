package com.es2.Bridge;

import java.util.HashMap;
import java.util.UUID;

public class APIRequest extends Object{

    protected HashMap<String, APIServiceInterface> services = new HashMap<>();

    public APIRequest() {}

    public String addService(APIServiceInterface service) {
        String id = UUID.randomUUID().toString();
        this.services.put(id, service);
        System.out.println("Id add service" + id);
        return id;
    }

    public String getContent(String serviceId, String contentId) throws ServiceNotFoundException {
        if(this.services.containsKey(serviceId)){
            return this.services.get(serviceId).getContent(contentId);
        }
        throw new ServiceNotFoundException();
    }

    public String setContent(String serviceId, String content) throws ServiceNotFoundException {
        if(this.services.containsKey(serviceId)) {
            return this.services.get(serviceId).getContent(content);
        }
        throw new ServiceNotFoundException();
    }
}
