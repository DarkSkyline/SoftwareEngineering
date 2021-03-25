package com.es2.composite;

public class CompositePattern extends Menu {

    protected  String url;

    public CompositePattern() {}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void showOptions() {
        System.out.println(this.label);
        System.out.println(this.url);
    }
}
