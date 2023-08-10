package com.wuye.interview;

import java.util.Stack;

/*
 * ����ջ��һ��˫ջ�㷨˼·
 * 
 * ���� ����� ������
 * 
 * ����: ((7+1)*3))
 * 
 * ������ѹ��һ��ջ����
 * 
 * �����ѹ��һ��ջ����
 * 
 * ÿ������)����һ����������ҵ�����Ӧ�Ĳ����� ���ս����ѹ��ջ����
 * 
 * ������������)ʱ�������ջ�������ʣ��һ���� ���Ǳ��ʽ��������
 * 
 *  --- �÷���ֻ��Ը�λ�� +  -  *  /����  
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


public class Dijkstra {

	public static void main(String [] args){
		
		String  a ="((1+2)/2)*7)";//��������ո�
		System.out.println(compute(a));
		
	}
	
	//������㷽��
	
	public static Double compute(String str){
		
		//��������ջ
		Stack<Double> dou=new Stack<Double>();
		
		Stack<Character> cha=new Stack<Character>();
		
		//���ַ��� ��� �ַ�����
		
		 char[] ch=str.toCharArray();
		for(int i=0;i<ch.length;i++){
			
		  if(ch[i]=='+')cha.push(ch[i]);
		  else if(ch[i]=='-')cha.push(ch[i]);
		  else if(ch[i]=='*')cha.push(ch[i]);
		  else if(ch[i]=='/')cha.push(ch[i]);
		  else if(ch[i]=='(');
		  else if(ch[i]==')'){
			  Double dd=dou.pop();
			  char cc=cha.pop();
			  if(cc=='+')dd=dou.pop()+dd;
			  if(cc=='-')dd=dou.pop()-dd;
			  if(cc=='*')dd=dou.pop()*dd;
			  if(cc=='/')dd=dou.pop()/dd;
			  dou.push(dd);
			  
		  }else{
			//�����������ȫ��ѹ�� doubleStack����  �ַ���ǿתΪdouble
			  dou.push(Double.parseDouble(Character.toString(ch[i])));
			  
		  }
		  
		}
		return dou.pop();	
		

	}	
	
	
	
}
