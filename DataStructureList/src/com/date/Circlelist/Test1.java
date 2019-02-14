package com.date.Circlelist;

import java.util.Iterator;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleList1<String> cc1=new CircleList1<String>();
		System.out.println(cc1.length());
		CircleList1<String> cc=new CircleList1<String>("wwww");
		cc.addHeader("WWWWW");
		System.out.println(cc+"***"+cc.length());
		cc.add("www");
		cc.add("&&&");		
		System.out.println(cc+"***"+cc.length());
		cc.addHeader("1111");
		System.out.println(cc+"***"+cc.length());
		System.out.println(cc.FindElement("&&&")+"^^^^^"+cc.get(0));
		cc.insert("7758", 4);
		System.out.println(cc+"***"+cc.length());
		cc.delete(4);
		System.out.println(cc+"***"+cc.length());
		System.out.println(cc.hashCode());
		  Iterator<String> a= cc.Iterator();
		while(a.hasNext()){
			System.out.println(a.next());
		}
		
	}

}
