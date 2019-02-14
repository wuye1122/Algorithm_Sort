package com.wuye.search;

public class OrderSearch {

	public int search(int key,int [] arry){
		for(int i=0;i<arry.length;i++){
			if(key==arry[i]){
				return i;
			}
		}
		return -1;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int []arry={1,2,34,5,7,90,3,51,17};
		
		int index=new OrderSearch().search(3, arry);
		
		System.out.println("你要查找的3在:arry["+index+"]");
		
		
	}

}
