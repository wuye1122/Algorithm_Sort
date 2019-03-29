package com.weikun.single;


public class Singleton4 {  
	private volatile static Singleton4 singleton;  
	private Singleton4 (){

	}  
	public static Singleton4 getSingleton() {  
		if (singleton == null) {  
			synchronized (Singleton4.class) {  
				if (singleton == null) {  
					singleton = new Singleton4();  
				}  
			}  
		}  
		return singleton;  
	}  
	public static void main(String[] args) {
		System.out.println(Singleton4.getSingleton());
		System.out.println(Singleton4.getSingleton());
	}
}  