package com.weikun.abstractfactory;

//具体工厂类1
public class ConcreteFactory1 implements AbstractFactory{
	public ProductA createProductA(){
		return new ProductA();
	}
	
	public ProductB createProductB(){
		return new ProductB();
	}
	
}
