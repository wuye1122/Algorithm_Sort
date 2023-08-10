package com.wuye.interview;

import java.util.Stack;

public class TwoStacksQueue {

	/*
	 *  **两个栈组成队列
	 *  
	 *  1 主要实现 add  poll peek
	 * 
	 *  stack  queue
	 *  栈的顺序和队列的顺序相反
	 *  
	 *  一个栈把元素倒入另一个栈里面顺序==正好和队列顺序相同
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	private Stack<Integer> pushStack;
	
	private Stack<Integer> popStack;
	
	
	TwoStacksQueue (){
		
		pushStack=new Stack<Integer>();
		
		popStack=new Stack<Integer>();
	}
	
	public void add(int newNum){
		
		pushStack.push(newNum);
		
		
	}
	
	
	
	public int poll(){
		
		if(pushStack.empty()&&popStack.empty()){
			throw new RuntimeException("queue is empty");
			
		}else {
			//一定保证 pop栈是null
			if(popStack.empty()){
				while(!pushStack.empty()){
					popStack.push(pushStack.pop());
				}
			
			}
			
		}
		return popStack.pop();
		
		
	}
	
	
public int peek(){
		
		if(pushStack.empty()&&popStack.empty()){
			throw new RuntimeException("queue is empty");
			
		}else {
			//一定保证 pop栈是null
			if(popStack.empty()){
				while(!pushStack.empty()){
					popStack.push(pushStack.pop());
				}
			
			}
			
		}
		return popStack.peek();
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TwoStacksQueue queue=new TwoStacksQueue();
		queue.add(111);
		queue.add(222);
		queue.add(333);
		queue.add(444);
		queue.add(555);
		queue.add(666);
		System.out.println(queue.pushStack.toString());
		System.out.println(queue.popStack.toString());
		
		System.out.println("--"+queue.peek()+"--");
		System.out.println("--"+queue.peek()+"--");
		System.out.println("--"+queue.peek()+"--");
		
		
		System.out.println("------poll----------");
		System.out.println("--"+queue.poll());
		System.out.println("--"+queue.poll());
		System.out.println("--"+queue.poll());
		System.out.println("--"+queue.poll());
		System.out.println("--"+queue.poll());
		System.out.println("--"+queue.poll());
		System.out.println("--------------------");
		
	}

}
