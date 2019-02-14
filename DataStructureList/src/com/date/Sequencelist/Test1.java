package com.date.Sequencelist;

public class Test1 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    List1<String> list=new List1<String>();//默认
            List1<String> list1=new List1<String>("6666");//一个元素
          //List1<String> list2=new List1<String>("1111",10);//一个元素 自定义长度
            System.out.println(list.length());
          list.add("iiii");
          list.add("aaaa");
          list.add("rrrr");
          list.add("4444");
          System.out.println(list.length()+"***"+list);
          System.out.println(list1.length()+"***"+list1);
          list1.add("1111");
          list1.add("2222");
          list1.add("3333");
          System.out.println(list1.length()+"***"+list1);
          list1.insert("2222", 0);
        System.out.println(list1.get(3));
        System.out.println(list1.findIndex("3333"));
          System.out.println(list1.length()+"***"+list1);
          list1.toString1();
         list.toString1();
        System.out.println("******************************");
         list.delete(3);
         System.out.println(list.length()+"   "+list);
         list.remove();
         System.out.println(list.length()+"   "+list);
         list.clear();
         System.out.println(list.length()+"   "+list);
        System.out.println( "如果真则表为空 如果为假则表为假"+list.empty());
        
         
	}

}
