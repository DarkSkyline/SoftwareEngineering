package com.es2.factorymethod;

public class FactoryProduct {
    protected FactoryProduct() {}

    public static Product makeProduct(String type) throws UndefinedProductException {
        Product product = null;

        if(type.equals("Computer")){
            product = new Computer();
        } else if(type.equals("Software")){
            product = new Software();
        } else {
            throw new UndefinedProductException();
        }
        return product;
    }
}
