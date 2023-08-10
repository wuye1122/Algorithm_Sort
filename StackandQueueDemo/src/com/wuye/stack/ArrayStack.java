package com.wuye.stack;

import java.util.Arrays;

public class ArrayStack {

	
	/* 1 ��д����ʵ�ֵ�ջ 
	 * 
	 *  �������� ���ڶ���һ������ ʹ���ԭ�����鶼һ��
	 *  
	 *  ���ܴ���һ����������  
	 * 
	 *  Arrays.toString(obj);����ı���
	 * 
	 * 
	 * */
	
	
	
	
	
	private Object [] obj=new Object[2];
	
	private int size=0;
	
	
	
	
	public void push(Object data){
		//��ʱ�ж�  ���ݵĳ��� ��ԭ�� ����ĳ��ȴ�С
		if(this.size>=obj.length){
			resize();
		}
		
		obj[size++]=data;//��Ϊ�ʼ��0    �ȸ�ֵ----Ȼ����++
		
	}
	//ջ ����
	public int length(){
		//���ص������ݳ���
		return this.size;
	}
	
	//���� ����ɾ��ջ��Ԫ��
	public Object pop(){
		// 0 1 2 3   size=4
		Object ob=this.obj[size-1];
		                      
		
		obj[--size]=null;
		
		return ob;
			
		
	}
	
	//����ջ��Ԫ��
	public Object peek(){
		
		
		//����ջ��Ԫ�� �����޸� ջ�Ĵ�С
		return this.obj[size-1];//�˴�һ����Ҫsize-1
		
		
	}
	
	
	//�жϸ�ջ�Ƿ�Ϊ��
	public boolean empty(){
		
		
		return size==0;
		
	}
	
	//��ո�ջ ��� sizeһ����ֵΪ0
	
	public void clear(){
		
		for(int i=0;i<this.obj.length;i++){
			obj[i]=null;
		}
		
		size=0;
	}
	
	//�������������
	
	
	
	
	public void resize(){
		
		Object[] obj2=new Object[this.obj.length*3];
		
		for(int i=0;i<obj.length;i++){
			
			//�˴���� ѡ�������ٵ�����Ϊ׼
			
			obj2[i]=obj[i];
			 obj[i]=null;
		}
		 
		  //��ԭ���� ����Ϊ��
		  
		  obj=obj2;
		 //���µ����븳ֵ��ԭ�������ñ���
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
