package com.es2.Bridge;

public interface APIServiceInterface {

    /*
       @Return Return the API content
     */
    String getContent(String ContentId);

    /*
        Store new content in the API
     */
    String setContent(String content);
}
