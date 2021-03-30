package com.es2.objectpool;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ReusablePool {

    private static ReusablePool object = null;
    private ArrayList<HttpURLConnection> connectionsFree = new ArrayList<>();
    private ArrayList<HttpURLConnection> connectionsUsed = new ArrayList<>();
    private int maxSize = 10;

    private ReusablePool(){}

    public static ReusablePool getInstance(){
        if(object == null){
            object = new ReusablePool();
        }
        return object;
    }

    public synchronized HttpURLConnection acquire() throws IOException, PoolExhaustedException{
        HttpURLConnection conn = null;
        if(this.connectionsFree.isEmpty())
            if(this.connectionsUsed.size() < this.maxSize) {
                URL url = new URL("http://www.ipv.pt");
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                this.connectionsUsed.add(conn);
            } else {
                throw new PoolExhaustedException();
            }
        else {
            this.connectionsUsed.add(this.connectionsFree.get(0));
            this.connectionsFree.remove(0);
        }
        return conn;
    }

    public synchronized void release(HttpURLConnection conn) throws ObjectNotFoundException {
        int i = this.connectionsUsed.indexOf(conn);
        if(i != -1) {
            this.connectionsFree.add(this.connectionsUsed.get(i));
            this.connectionsUsed.remove(i);
        } else throw new ObjectNotFoundException();
    }

    public synchronized void resetPool() {
        object = null;
    }

    public void setMaxPoolSize(int size) {
        this.maxSize = size;
    }
}
