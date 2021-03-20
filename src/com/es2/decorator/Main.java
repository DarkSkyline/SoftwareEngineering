package com.es2.decorator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws AuthException, IOException{

        AuthInterface auth = new CommonWordsValidator((new Logging(new Auth())));
        auth.auth("admin", "admin");
    }
}
