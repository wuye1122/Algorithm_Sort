package com.date.Doublelist;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DouList<String> dd=new DouList<String>("yuo");
		System.out.println(dd.length()+" "+dd);
		dd.add("love");
		dd.add("I");
		System.out.println(dd.length()+" "+dd.AtoString());
		dd.insert("??", 0);
		System.out.println(dd.length()+" "+dd);
		System.out.println(dd.length()+" ");
		dd.add("L");
		System.out.println(dd.length()+" "+dd);
		System.out.println(dd.AtoString());
		dd.insert("eee", 4);
		System.out.println(dd.length()+" "+dd);

		System.out.println(dd.findElement("??"));
		System.out.println(dd.get(5));
	
		System.out.println(	dd);
		dd.add("??");
		System.out.println(	dd);
		dd.addHeader("RTRTYY");
		System.out.println(	dd+"****"+dd.AtoString());
		dd.insert("233", 0);
		System.out.println("ÒÆ³ý"+dd.remove());
		System.out.println("ÒÆ³ý"+dd.remove());
		System.out.println("ÒÆ³ý"+dd.remove());
		
	}

}
