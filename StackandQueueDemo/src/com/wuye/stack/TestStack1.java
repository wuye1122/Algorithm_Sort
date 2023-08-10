package com.wuye.stack;

import java.util.Arrays;

public class TestStack1 {

	//6+2  toString  resize
	
	//存放元素的数组
	
   private	Object ob1[]=new Object[4];
	
   private int size=0;	
	
   
   
   
   
   //返回栈里面元素个数
   public int length(){
	   
	   return this.size;
	   
   }
  
   
   //判断是否为空
   public boolean empty(){
	   
	   return this.size==0;
   }
   
   
   //将数组里面元素全部清零
   public void clear(){
	   
	   for(int i=0;i<this.ob1.length;i++){
		   ob1[i]=null;
		   
	   }
	   size=0;
	   
   }
   
  //扩容 将原来数组的长度 扩到到原来的2倍  3倍 
	
   public void resize(){
	   
	   Object ob2[]=new Object[this.ob1.length*3];
	   for(int i=0;i<this.ob1.length;i++){
		   ob2[i]=ob1[i];
		   ob1[i]=null;
		   
	   }
	        ob1=ob2;
	   
   }
   
   //返回栈顶元素
   
   public Object peek(){
	   
	   return ob1[size-1];
	   
   }
   
   //向栈里面添加元素
   
   public void push(Object data){
	   
	   if(this.size>=this.ob1.length){
		   resize();
	   }
	   //else{
		   //此处扩容前后均需要添加数据   加else之后则代表扩容之前能加入数据  
		   //扩容之后加入不了数据
		   ob1[size++]=data;//增加一个元素。
	  // }
	   
   }
   
   
   
   //删除栈顶元素并且返回该元素
   
   public Object pop(){
	   
	   Object ob=ob1[size-1];
	   
	   ob1[--size]=null;//栈顶元素赋值为null  且元素数量减少1
	   
	   return ob;
   }
   
   //toString 进行重写
   
   public String toString(){
	   
	   
	   return Arrays.toString(ob1);
   }
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestStack1 ts=new TestStack1();
		System.out.println("-------"+ts);
		
		ts.push("111");
		
		ts.push("222");
		
		ts.push("2016.2.14");
		
		System.out.println("-------"+ts);
		
		ts.push("初七");
		
		ts.push("上班");
		
		System.out.println("-------"+ts);
		
		System.out.println("---length----"+ts.length());
		
		System.out.println("---empty----"+ts.empty());
		
	//	ts.clear();
		
		System.out.println("-------"+ts);
		
		System.out.println("---empty----"+ts.empty());
		
		System.out.println("---peek----"+ts.peek());
		
		System.out.println("-------"+ts);
		
       System.out.println("---peek----"+ts.pop());
		
		System.out.println("-------"+ts);
		
		System.out.println("---peek----"+ts.pop());
		
		System.out.println("-------"+ts);
		
		System.out.println("---peek----"+ts.pop());
		
		System.out.println("-------"+ts);
		
	}

}
