package com.weikun.single;

public class Singleton2 {
	//��д���ܹ��ڶ��߳��кܺõĹ�����Ч�ʺܵͣ�99%����²���Ҫͬ����
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
