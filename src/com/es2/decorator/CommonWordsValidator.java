package com.es2.decorator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CommonWordsValidator extends Decorator implements AuthInterface{

    public CommonWordsValidator(AuthInterface auth) {
        super(auth);
        // TODO Auto-generated constructor stub
    }

    public void auth(String username, String password) throws AuthException, IOException {
        try {
            String dicWord = getHTTPRequest(password);
        }catch(IOException e) {
            throw new AuthException();
        }

        super.auth(username, password);
    }

    public String getHTTPRequest(String word) throws IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL("https://owlbot.info/api/v4/dictionary/owl");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB;rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");
        conn.setRequestProperty("Authorization", "Token 2127910983b34fedfe9d0131c1b3785348c0b568");
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        if(conn.getResponseCode() == 404){
            return "Password is clean";
        }

        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

}
