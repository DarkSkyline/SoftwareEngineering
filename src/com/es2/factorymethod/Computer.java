package com.es2.factorymethod;

public class Computer implements Product{

    protected Computer(){}
    private String brand = null;

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getBrand(){
        return this.brand;
    }
}
