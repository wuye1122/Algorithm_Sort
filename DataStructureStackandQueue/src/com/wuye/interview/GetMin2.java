package com.wuye.interview;

import java.util.Stack;

public class GetMin2 {

	/*
	 *  1 *实现一个特殊的栈 并且返回栈中最小元素。
	 *  
	 *  2 pop push getMin
	 * 
	 *  时间复杂度o(1)
	 *  空间复杂度o(n):利用其它数据结构
	 *  压入省费时间   弹出省时间
	 * 
	 * 
	 * */
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	GetMin2(){
		
		 stackData=new Stack<Integer>();
		 stackMin=new Stack<Integer>();	
		
	}
	//压入费时间
	public void push(int newNum){
		
		if(this.stackMin.empty()){
			this.stackMin.push(newNum);
		}else if(newNum<this.getMin()){
			this.stackMin.push(newNum);
			
		}else{
			//如果元素大于或者等于最小栈顶部的元素都在一次压入最小栈顶
			this.stackMin.push(this.stackMin.peek());
			
		}
		this.stackData.push(newNum);
		
	}
	
	//删除的作用  两个栈都删除 因为都是5个 删除的时候不费时间
	
	public int pop(){
		
		if(this.stackMin.empty()){
			throw new RuntimeException("Your stack is null");
			
		}
		this.stackMin.pop();
		return this.stackData.pop();
		
		
	}
	//同上 获取最小元素
	public int getMin(){
		
		if(this.stackMin.empty()){
			throw new RuntimeException("Your stack is null");
			
		}
		return this.stackMin.peek();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	GetMin2 gg=new GetMin2();
		

		gg.push(3);
		gg.push(4);
		gg.push(5);
		gg.push(1);
		gg.push(2);
		gg.push(1);
		
		System.out.println("数据栈里面的元素:"+gg.stackData.toString());
		System.out.println("最小栈里面的元素:"+gg.stackMin.toString());
		System.out.println("最小的元素:"+gg.getMin());
	
		//因为都是五个元素 pop5次就可以
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
		
//		System.out.println(gg.pop());
//		System.out.println("数据栈里面的元素:"+gg.stackData.toString());
//		System.out.println("最小栈里面的元素:"+gg.stackMin.toString());
	}

}
