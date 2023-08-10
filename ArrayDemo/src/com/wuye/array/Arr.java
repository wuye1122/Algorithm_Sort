package com.wuye.array;

public class Arr {

	
	 public void StringAndNum(String str,int num){
		 
		 if(str==null||num<=0||str.equals(null)){
			 System.out.println("错误输出");
		 }
		
			 int a=(int)(Math.random()*num);//随机几个数
			 String st1=str.substring(0, a);
			 System.out.println(st1);	
			 for(int i=0;i<str.length();i=i+a){
				 
	            int b=(int)(Math.random()*(num-a));
				 String st2=str.substring(i+a, b);//0-a 
				 System.out.println(st2);	
				
			 }
			

	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      new  Arr().StringAndNum("Our world is but a small part of the cosmos", 9);
	}

}
