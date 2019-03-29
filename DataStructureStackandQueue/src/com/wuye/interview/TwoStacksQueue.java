package com.wuye.interview;

import java.util.Stack;

public class TwoStacksQueue {

	/*
	 *  **����ջ��ɶ���
	 *  
	 *  1 ��Ҫʵ�� add  poll peek
	 * 
	 *  stack  queue
	 *  ջ��˳��Ͷ��е�˳���෴
	 *  
	 *  һ��ջ��Ԫ�ص�����һ��ջ����˳��==���úͶ���˳����ͬ
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
			//һ����֤ popջ��null
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
			//һ����֤ popջ��null
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
