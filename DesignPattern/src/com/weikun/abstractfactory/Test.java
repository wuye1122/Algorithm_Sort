package com.weikun.abstractfactory;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//������ƷA
		ConcreteFactory1 f1= new ConcreteFactory1();  
        ProductA a =f1.createProductA();
          
        //������ƷB
     //   ConcreteFactory1 f2= new ConcreteFactory1();  
        ProductB b =f1.createProductB();
	}

}
