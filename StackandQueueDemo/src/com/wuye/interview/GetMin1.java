package com.wuye.interview;

import java.util.Stack;



/*
 *  1 *实现一个特殊的栈 并且返回栈中最小元素。
 *  
 *  2 pop push getMin
 * 
 *  时间复杂度o(1)
 *  空间复杂度o(n):利用其它数据结构
 *  压入省时间 弹出费时间
 * 
 *  难点 :删除时候 删除的是两个栈 但是仅仅返回数据栈删掉的元素
 *      删除时候需要对最小栈里面的元素单独判断 如果相等删除 不等则最小栈不删除
 *      否则会出现异常
 *  
 * */


public class GetMin1 {
	
	//两个栈用来保存数据
	
	private Stack<Integer> stackData;
	
	private Stack<Integer> stackMin;
	
	GetMin1(){
		stackData=new Stack<Integer>();
		
		stackMin=new Stack<Integer>();
		
		
	}
	
	
	//最小栈 为空压入或者比起栈顶最小的压入   数据栈全部压入
	public void push(int newNum){
		
		if(this.stackMin.empty()){
			this.stackMin.push(newNum);
		}else if(newNum<=this.getMin()){
			
			this.stackMin.push(newNum);
			
		}
		
		this.stackData.push(newNum);
	}
	
	
	//删除 数据栈全删除  做小栈等于最小的删除
	
	public int pop(){
		if(this.stackMin.empty()){
			throw new RuntimeException("Your  stack  is  null");
			
		}
		int value=this.stackData.pop();
		
		if(value==this.getMin()){
			
			this.stackMin.pop();
		}
		
		return value;
	}
	
	
	
	
	//获取最下栈上面的元素
	public int getMin(){
		
		if(this.stackMin.empty()){
			throw new RuntimeException("Your  stack  is  null");
			
		}
		return this.stackMin.peek();
		
		
	}

	
	
	public static void main(String []args){
		
		GetMin1 gg=new GetMin1();
		

		gg.push(3);
		gg.push(4);
		gg.push(5);
		gg.push(1);
		gg.push(2);
		gg.push(1);
		
		System.out.println("数据栈里面的元素:"+gg.stackData.toString());
		System.out.println("最小栈里面的元素:"+gg.stackMin.toString());
		System.out.println("最小的元素:"+gg.getMin());
	    System.out.println(gg.pop());
	    System.out.println("数据栈里面的元素:"+gg.stackData.toString());
		System.out.println("最小栈里面的元素:"+gg.stackMin.toString());
		System.out.println(gg.pop());
	    System.out.println("数据栈里面的元素:"+gg.stackData.toString());
		System.out.println("最小栈里面的元素:"+gg.stackMin.toString());
		
		System.out.println(gg.pop());
	    System.out.println("数据栈里面的元素:"+gg.stackData.toString());
		System.out.println("最小栈里面的元素:"+gg.stackMin.toString());
		
		System.out.println(gg.pop());
	    System.out.println("数据栈里面的元素:"+gg.stackData.toString());
		System.out.println("最小栈里面的元素:"+gg.stackMin.toString());
		
		System.out.println(gg.pop());
	    System.out.println("数据栈里面的元素:"+gg.stackData.toString());
		System.out.println("最小栈里面的元素:"+gg.stackMin.toString());
		
		System.out.println(gg.pop());
	    System.out.println("数据栈里面的元素:"+gg.stackData.toString());
		System.out.println("最小栈里面的元素:"+gg.stackMin.toString());
	}
}
