package com.es2.Bridge;

import java.util.LinkedHashMap;
import java.util.UUID;

public class APIMoodle extends Object implements APIServiceInterface{

    protected LinkedHashMap<String, String> content = new LinkedHashMap<>();

    public APIMoodle() {}

    public String getContent(String contentId) {
        if(contentId.equals("0")) {
            String all = "";
            for(String key: content.keySet())
                all += content.get(key);
            return all;
        }
        return this.content.get(contentId);
    }

    public String setContent(String content) {
        String id = UUID.randomUUID().toString();
        this.content.put(id, content);
        return id;
    }


}
