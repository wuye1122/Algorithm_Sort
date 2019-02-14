package com.wuye.stack;

import java.util.Arrays;

public class ArrayStack {

	
	/* 1 手写数组实现的栈 
	 * 
	 *  数组扩容 再在定义一个数组 使其和原来数组都一样
	 *  
	 *  不能创建一个泛型数组  
	 * 
	 *  Arrays.toString(obj);数组的遍历
	 * 
	 * 
	 * */
	
	
	
	
	
	private Object [] obj=new Object[2];
	
	private int size=0;
	
	
	
	
	public void push(Object data){
		//此时判断  数据的长度 和原来 数组的长度大小
		if(this.size>=obj.length){
			resize();
		}
		
		obj[size++]=data;//因为最开始是0    先赋值----然后再++
		
	}
	//栈 长度
	public int length(){
		//返回的是数据长度
		return this.size;
	}
	
	//返回 并且删除栈顶元素
	public Object pop(){
		// 0 1 2 3   size=4
		Object ob=this.obj[size-1];
		                      
		
		obj[--size]=null;
		
		return ob;
			
		
	}
	
	//返回栈顶元素
	public Object peek(){
		
		
		//返回栈顶元素 并不修改 栈的大小
		return this.obj[size-1];//此处一定是要size-1
		
		
	}
	
	
	//判断该栈是否为空
	public boolean empty(){
		
		
		return size==0;
		
	}
	
	//清空该栈 最后 size一定赋值为0
	
	public void clear(){
		
		for(int i=0;i<this.obj.length;i++){
			obj[i]=null;
		}
		
		size=0;
	}
	
	//对数组进行扩容
	
	
	
	
	public void resize(){
		
		Object[] obj2=new Object[this.obj.length*3];
		
		for(int i=0;i<obj.length;i++){
			
			//此处如果 选择数据少的数组为准
			
			obj2[i]=obj[i];
			 obj[i]=null;
		}
		 
		  //将原数组 设置为空
		  
		  obj=obj2;
		 //将新的引入赋值给原来的引用变量
	}
	public String toString(){
		
		 return Arrays.toString(obj);
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayStack as=new ArrayStack();
		 System.out.println(as.size);
		 as.push("111");
		 as.push("aaa");
		 as.push("333");
         System.out.println(as);
         
         System.out.println(as.size);
         System.out.println(as.length());
        // as.clear();
         System.out.println(as.peek());
         System.out.println(as.peek());
         System.out.println(as.peek());
         System.out.println("----------------------");
         System.out.println(as.pop());
         System.out.println(as.pop());
         System.out.println(as.empty());
         System.out.println(as.pop());
         System.out.println(as.size);
         System.out.println(as.length());
         System.out.println(as.empty());
         
        

	}

}
