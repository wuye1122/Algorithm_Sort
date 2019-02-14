package com.date.Linklist;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          List1<String> list=new List1<String>();
	System.out.println(	list.empty());
	System.out.println(	list.length());	
   list.add("1111");
   list.add("2222");
   list.add("3333");
   System.out.println(	list.length()+"***"+list);
   list.addHeader("6666");
   System.out.println(	list.length()+"***"+list);
  System.out.println( list.FindElement("1111"));
  System.out.println( list.get(2));	
  list.Insert("7777", 3);
  System.out.println( "***"+list);
  list.delete(2);
  System.out.println(list.toString());
  List1<String> list1=new List1<String>("@@@@");
  
  list1.add("#(*%");
  list1.add("4666");
  System.out.println(list1);
	}

}
