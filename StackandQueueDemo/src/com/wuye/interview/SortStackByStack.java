package com.wuye.interview;

import java.util.Stack;

public class SortStackByStack {

	/*
	 * 
	 * 
	 * 
	 *  *ʹ��һ��ջ ��һ��������һ��ջ�������򡢡�ʹ��old���ϵ����ɴ�С
	 *  
	 *  ����helpջ��      �Ƚ�oldջ��Ԫ��
	 *  ���С�Ļ���ѹ�� old  ��ʱold���ջ����cur������
	 *  
	 *  ��С��һ��ѹ�� help�����γ� help���ϵ��� ��С����
	 *  
	 *  
	 *    
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	 
	
	public static void sortStackByStack(Stack<Integer> old){
		Stack<Integer> help=new 	Stack<Integer> ();
		
		
		//ֻ�а���ջС��ԭ��ջ��    �ͽ�����С��ѹ����ջ 
		 //Ȼ�� ����������curѹ�� help
		 //old--->help
		while(!old.empty()){
			int cur=old.pop();
			while(!help.empty()&&help.peek()<cur){
				old.push(help.pop());
				
			}
			//С��ȫ�����ڵ�old������
			
			help.push(cur);	
		}
		
		while(!help.empty()){
			old.push(help.pop());
			
		}
		
	}
	
	
	
	//���ȫ��ѹ��ԭջ
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> old=new Stack<Integer>();
		old.add(3);
		old.add(4);
		old.add(6);
		old.add(5);
		old.add(1);
		old.add(7);
		
		System.out.println("ջ����Ԫ������"+old.toString());
		sortStackByStack(old);
		System.out.println("�ź����ջ����"+old.toString());
	}

}
