package com.es2.Bridge;

public class Main {

    static APIRequest request;

    public static void main(String[] args) throws ServiceNotFoundException {

        request = new APIRequest();
        String idService = request.addService(new APIMoodle());
        String idContent = request.setContent(idService, "555");
        String content = request.getContent(idService, idContent);

        System.out.println(idService);
        System.out.println(idContent);
        System.out.println(content);
    }
}
