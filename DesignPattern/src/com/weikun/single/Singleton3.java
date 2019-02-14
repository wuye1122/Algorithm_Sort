package com.weikun.single;

public class Singleton3 {
	private static class SingletonHolder {  
		private static final Singleton3 INSTANCE = new Singleton3();  
	}  
	private Singleton3 (){
		
	}  
	public static final Singleton3 getInstance() {  
		return SingletonHolder.INSTANCE;  
	}  
	public static void main(String[] args) {
		Singleton3 sp=Singleton3.getInstance();
		System.out.println(sp);
		
		Singleton3 sp1=Singleton3.getInstance();
		System.out.println(sp1);
	}
}
