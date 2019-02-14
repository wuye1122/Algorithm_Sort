package com.weikun.single;

public class Singleton2 {
	//种写法能够在多线程中很好的工作，效率很低，99%情况下不需要同步。
	private static Singleton2 instance;  
	private Singleton2 (){
		
	}  
	public static synchronized Singleton2 getInstance() {  
		if (instance == null) {  
			instance = new Singleton2();  
		}  
		return instance;  
	}  

}
