package com.wuye.stack;

import java.util.Enumeration;
import java.util.Stack;

public class OriginalStack {

	/* 2016 2-2  �������ϵ���
	 * 
	 * 1 Stack һ�ֺ���ȳ����ݽṹ LIFO
	 *  ���濪�������� ���� 
	 * 
	 *2  ջ�ļ������õķ���: 
	 *   
	 *     void push(E data);ѹ��ջ��
	 *    
	 *     E pop();����ջ������ɾ��
	 *     
	 *     E peek();����ջ�����ǲ�ɾ��
	 *     
	 *     boolean empty();����ջ�Ƿ�Ϊ��
	 *     
	 *     int length();����ջ�ĳ���
	 *     
	 *     void clear();���
	 *     
	 *     String toString();���
	 *
	 *     
	 *     
	 *3 ջ �� �ѵ����� :*****
	 *
	 * �����ж���Ļ������͵ı���   ��������ñ��������ں�����ջ�ڴ��������
	 * 
	 * --��һ�δ��붨��һ��������ʱ��  ջΪ������ڴ�ռ� 
	 *   һ��������������������� java�Զ��ŵ��ñ���ռ�õ��ڴ�ռ�  �ÿռ����
	 *   ����������ʹ��
	 * 
	 * ���ڴ����ڴ�� new�����Ķ��� �������ڶ��з�����ڴ�  
	 * ��java��������Զ��������������й���
	 * 
	 * --�ڶ����洴����������߶��� ������ջ�������һ������ʹ����ڶѵ��׵�ַ
	 *   �Ƹñ���Ϊ ������߶�������ñ���
	 *   �ڳ�������ֱ��ʹ�����ñ��������� ��������߸ö���
	 *   
	 * 4 stack jdk�Դ��� �������Լ�д
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	
	
	
	public static void main(String [] args){
		//ʹ��jdk�������ջ ���в���
		Stack<Object> st=new Stack<Object>();
		st.push("111");
		System.out.println(st);
		
		st.push(new Integer(22));
		System.out.println(st);
		System.out.println("peek------"+st.peek());
		System.out.println(st);
		
		st.push(new Double(22.3));
		System.out.println("pop------ǰ"+st);
		System.out.println("pop------"+st.pop());
		System.out.println("pop------��"+st);
		
		st.push(new String("�ַ���"));
		System.out.println(st);
		System.out.println("size----���س���"+st.size());
		System.out.println("clear----���ǰ"+st.empty());
		System.out.println(st.search(22));
		
		
		//ʹ�� ö�ٽ��б��� Enumeration
		System.out.println("�˷��������Ƿ�����ЩԪ��------------------");	
	Enumeration<Object> est=st.elements();
	    System.out.print("(");
		while(est.hasMoreElements()){
			System.out.println(est.nextElement()+",");
		}

		System.out.println(")");
		System.out.println("------------------");
		
		//ֻ�� pop���ܿ���� ����ȳ� LIFO
		
		System.out.println(st.pop());
		System.out.println("size----���س���"+st.size());
		System.out.println(st.peek());
		System.out.println(st.pop());
		
		
		st.clear();
		System.out.println("clear----��պ�"+st.empty());
		System.out.println("clear----��պ�"+st.isEmpty());		System.out.println(st.search("22"));
		
		
	}
	
	
	
	
	
}
