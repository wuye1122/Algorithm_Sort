package com.weikun.single;

public class Singleton1 {
	private double r;
	private static Singleton1 sp;//2
	private Singleton1(){//1
		r = java.lang.Math.random();
	}

	public static Singleton1 getInstance(){//3
		if (sp==null){//如果没有创建，那么进行创建
			sp = new Singleton1();
		}			
		return sp;

		//如果创建，则返回之前已创建的值

	}
	public double getR(){
		return r;
	}

	public static void main(String args[]){
		Singleton1 sp1 = Singleton1.getInstance();
		Singleton1 sp2 = Singleton1.getInstance();
		System.out.println(sp1.getR());
		System.out.println(sp2.getR());
	}	
}
