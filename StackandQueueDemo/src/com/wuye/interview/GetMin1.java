package com.wuye.interview;

import java.util.Stack;



/*
 *  1 *ʵ��һ�������ջ ���ҷ���ջ����СԪ�ء�
 *  
 *  2 pop push getMin
 * 
 *  ʱ�临�Ӷ�o(1)
 *  �ռ临�Ӷ�o(n):�����������ݽṹ
 *  ѹ��ʡʱ�� ������ʱ��
 * 
 *  �ѵ� :ɾ��ʱ�� ɾ����������ջ ���ǽ�����������ջɾ����Ԫ��
 *      ɾ��ʱ����Ҫ����Сջ�����Ԫ�ص����ж� ������ɾ�� ��������Сջ��ɾ��
 *      ���������쳣
 *  
 * */


public class GetMin1 {
	
	//����ջ������������
	
	private Stack<Integer> stackData;
	
	private Stack<Integer> stackMin;
	
	GetMin1(){
		stackData=new Stack<Integer>();
		
		stackMin=new Stack<Integer>();
		
		
	}
	
	
	//��Сջ Ϊ��ѹ����߱���ջ����С��ѹ��   ����ջȫ��ѹ��
	public void push(int newNum){
		
		if(this.stackMin.empty()){
			this.stackMin.push(newNum);
		}else if(newNum<=this.getMin()){
			
			this.stackMin.push(newNum);
			
		}
		
		this.stackData.push(newNum);
	}
	
	
	//ɾ�� ����ջȫɾ��  ��Сջ������С��ɾ��
	
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
	
	
	
	
	//��ȡ����ջ�����Ԫ��
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
		
		System.out.println("����ջ�����Ԫ��:"+gg.stackData.toString());
		System.out.println("��Сջ�����Ԫ��:"+gg.stackMin.toString());
		System.out.println("��С��Ԫ��:"+gg.getMin());
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
	}
}
