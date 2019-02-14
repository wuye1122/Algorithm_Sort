package com.weikun.abstractfactory;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建产品A
		ConcreteFactory1 f1= new ConcreteFactory1();  
        ProductA a =f1.createProductA();
          
        //创建产品B
     //   ConcreteFactory1 f2= new ConcreteFactory1();  
        ProductB b =f1.createProductB();
	}

}
