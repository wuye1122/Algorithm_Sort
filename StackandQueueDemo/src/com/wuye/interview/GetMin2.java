package com.wuye.interview;

import java.util.Stack;

public class GetMin2 {

	/*
	 *  1 *ʵ��һ�������ջ ���ҷ���ջ����СԪ�ء�
	 *  
	 *  2 pop push getMin
	 * 
	 *  ʱ�临�Ӷ�o(1)
	 *  �ռ临�Ӷ�o(n):�����������ݽṹ
	 *  ѹ��ʡ��ʱ��   ����ʡʱ��
	 * 
	 * 
	 * */
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	GetMin2(){
		
		 stackData=new Stack<Integer>();
		 stackMin=new Stack<Integer>();	
		
	}
	//ѹ���ʱ��
	public void push(int newNum){
		
		if(this.stackMin.empty()){
			this.stackMin.push(newNum);
		}else if(newNum<this.getMin()){
			this.stackMin.push(newNum);
			
		}else{
			//���Ԫ�ش��ڻ��ߵ�����Сջ������Ԫ�ض���һ��ѹ����Сջ��
			this.stackMin.push(this.stackMin.peek());
			
		}
		this.stackData.push(newNum);
		
	}
	
	//ɾ��������  ����ջ��ɾ�� ��Ϊ����5�� ɾ����ʱ�򲻷�ʱ��
	
	public int pop(){
		
		if(this.stackMin.empty()){
			throw new RuntimeException("Your stack is null");
			
		}
		this.stackMin.pop();
		return this.stackData.pop();
		
		
	}
	//ͬ�� ��ȡ��СԪ��
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
		
		System.out.println("����ջ�����Ԫ��:"+gg.stackData.toString());
		System.out.println("��Сջ�����Ԫ��:"+gg.stackMin.toString());
		System.out.println("��С��Ԫ��:"+gg.getMin());
	
		//��Ϊ�������Ԫ�� pop5�ξͿ���
		System.out.println(gg.pop());
		System.out.println("����ջ�����Ԫ��:"+gg.stackData.toString());
		System.out.println("��Сջ�����Ԫ��:"+gg.stackMin.toString());
		
		System.out.println(gg.pop());
		System.out.println("����ջ�����Ԫ��:"+gg.stackData.toString());
		System.out.println("��Сջ�����Ԫ��:"+gg.stackMin.toString());
		
		System.out.println(gg.pop());
		System.out.println("����ջ�����Ԫ��:"+gg.stackData.toString());
		System.out.println("��Сջ�����Ԫ��:"+gg.stackMin.toString());
		
		System.out.println(gg.pop());
		System.out.println("����ջ�����Ԫ��:"+gg.stackData.toString());
		System.out.println("��Сջ�����Ԫ��:"+gg.stackMin.toString());
		
		System.out.println(gg.pop());
		System.out.println("����ջ�����Ԫ��:"+gg.stackData.toString());
		System.out.println("��Сջ�����Ԫ��:"+gg.stackMin.toString());
		
		System.out.println(gg.pop());
		System.out.println("����ջ�����Ԫ��:"+gg.stackData.toString());
		System.out.println("��Сջ�����Ԫ��:"+gg.stackMin.toString());
		
//		System.out.println(gg.pop());
//		System.out.println("����ջ�����Ԫ��:"+gg.stackData.toString());
//		System.out.println("��Сջ�����Ԫ��:"+gg.stackMin.toString());
	}

}
