package com.wuye.stack;

import java.util.Arrays;

public class TestStack1 {

	//6+2  toString  resize
	
	//���Ԫ�ص�����
	
   private	Object ob1[]=new Object[4];
	
   private int size=0;	
	
   
   
   
   
   //����ջ����Ԫ�ظ���
   public int length(){
	   
	   return this.size;
	   
   }
  
   
   //�ж��Ƿ�Ϊ��
   public boolean empty(){
	   
	   return this.size==0;
   }
   
   
   //����������Ԫ��ȫ������
   public void clear(){
	   
	   for(int i=0;i<this.ob1.length;i++){
		   ob1[i]=null;
		   
	   }
	   size=0;
	   
   }
   
  //���� ��ԭ������ĳ��� ������ԭ����2��  3�� 
	
   public void resize(){
	   
	   Object ob2[]=new Object[this.ob1.length*3];
	   for(int i=0;i<this.ob1.length;i++){
		   ob2[i]=ob1[i];
		   ob1[i]=null;
		   
	   }
	        ob1=ob2;
	   
   }
   
   //����ջ��Ԫ��
   
   public Object peek(){
	   
	   return ob1[size-1];
	   
   }
   
   //��ջ�������Ԫ��
   
   public void push(Object data){
	   
	   if(this.size>=this.ob1.length){
		   resize();
	   }
	   //else{
		   //�˴�����ǰ�����Ҫ�������   ��else֮�����������֮ǰ�ܼ�������  
		   //����֮����벻������
		   ob1[size++]=data;//����һ��Ԫ�ء�
	  // }
	   
   }
   
   
   
   //ɾ��ջ��Ԫ�ز��ҷ��ظ�Ԫ��
   
   public Object pop(){
	   
	   Object ob=ob1[size-1];
	   
	   ob1[--size]=null;//ջ��Ԫ�ظ�ֵΪnull  ��Ԫ����������1
	   
	   return ob;
   }
   
   //toString ������д
   
   public String toString(){
	   
	   
	   return Arrays.toString(ob1);
   }
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestStack1 ts=new TestStack1();
		System.out.println("-------"+ts);
		
		ts.push("111");
		
		ts.push("222");
		
		ts.push("2016.2.14");
		
		System.out.println("-------"+ts);
		
		ts.push("����");
		
		ts.push("�ϰ�");
		
		System.out.println("-------"+ts);
		
		System.out.println("---length----"+ts.length());
		
		System.out.println("---empty----"+ts.empty());
		
	//	ts.clear();
		
		System.out.println("-------"+ts);
		
		System.out.println("---empty----"+ts.empty());
		
		System.out.println("---peek----"+ts.peek());
		
		System.out.println("-------"+ts);
		
       System.out.println("---peek----"+ts.pop());
		
		System.out.println("-------"+ts);
		
		System.out.println("---peek----"+ts.pop());
		
		System.out.println("-------"+ts);
		
		System.out.println("---peek----"+ts.pop());
		
		System.out.println("-------"+ts);
		
	}

}
