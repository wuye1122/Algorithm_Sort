package com.weikun.simplefactory;
//������ɫ
public class Creator{
    public IProduct createProduct(int productFlag){
        switch(productFlag){
            case 1:
                return new ProductA();
            case 2:
                return new ProductB();
            default:
                return null; 
        }
    }
}