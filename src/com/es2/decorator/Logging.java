package com.es2.decorator;

import java.io.IOException;

public class Logging extends Decorator implements AuthInterface{

    public Logging(AuthInterface auth){
        super(auth);
    }

    public void auth(String username, String password) throws AuthException, IOException{
        System.out.println(System.currentTimeMillis() + ", auth()");
        this.auth(username, password);
    }
}
