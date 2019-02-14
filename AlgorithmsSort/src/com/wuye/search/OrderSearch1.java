package com.wuye.search;

public class OrderSearch1 {

	public int search(int key,int [] arry){
		
		int i=arry.length-1;
		while(arry[i]!=key){
			i--;
		}
		return i;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int []arry={1,2,34,5,7,90,3,51,17};
		
		int index=new OrderSearch1().search(17, arry);
		
		System.out.println("你要查找的3在:arry["+index+"]");
		
	}

}
