package com.es2.singleton;

public class Registry extends Object {

    public static String Path;
    public static String ConnectionString;
    public static Registry object = null;

    private Registry(){

    }

    public static Registry getInstance() {

        if(object == null)
            object = new Registry();
        return object;

     }

    public void setPath(String path){  this.Path = path; }
    public String getPath() { return this.Path; }
    public void setConnectionString(String connectionString) { this.ConnectionString = connectionString; }
    public String getConnectionString() { return this.ConnectionString; }

}