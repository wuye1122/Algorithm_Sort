package com.weikun.abstractfactory;

//���幤����1
public class ConcreteFactory1 implements AbstractFactory{
	public ProductA createProductA(){
		return new ProductA();
	}
	
	public ProductB createProductB(){
		return new ProductB();
	}
	
}
