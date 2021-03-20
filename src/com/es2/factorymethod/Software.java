package com.es2.factorymethod;

import com.es2.factorymethod.Product;

public class Software implements Product {
    protected Software(){}

    private String brand = null;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand(){
        return this.brand;
    }
}
