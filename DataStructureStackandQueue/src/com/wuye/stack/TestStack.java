package com.wuye.stack;

import java.util.Arrays;

public class TestStack {

	
	/* 1 �Ѻ�ջ������
	 * 
	 *  ջ��Ϊ�������ͱ��� �� ��������ñ��������ڴ�ռ�
	 *  ��һ�δ������涨�����Ϊ�����ջ�ڴ�ռ�  һ���������������������
	 *  �Զ��ͷſռ� �ÿռ���Ա���������ʹ�� 
	 *  
	 *  �Ѵ��  new �����Ķ���  �����ڶ����������ڴ�
	 * 
	 *  ������ջ�������һ������ ����������ڶ�������׵�ַ�ı���
	 *  ��֮Ϊ���ñ���
	 *  
	 *  ͨ�����������ñ����Ϳ��Բ�������Ͷ�����
	 *  
	 *  
	 *  2 
	 *  
	 *   void push(Object data);
	 *   
	 *   Object pop();
	 *   
	 *   Object peek();
	 *   
	 *   boolean empty();
	 *   
	 *   void clear();
	 *   
	 *   int length()
	 * 
	 *   void resize();�������������
	 * 
	 * */
	
   private Object[] ob=new Object[4];
   
   private int size=0;
	
   
   //�������ݳ���
   public int length(){
	   return this.size;
   }
   
   
   //����
   public void resize(){
	   
	   Object [] ob1=new Object[this.ob.length*2];
	   
	   for(int i=0;i<this.ob.length;i++){
		   ob1[i]=ob[i];
		   ob[i]=null;
		   
	   }
	   ob=ob1;
	   
   }
   
   //ѹ��
   
    public void push(Object data){
    	//���ݵĳ��ȴ��� ����ĳ���   
    	if(this.size>=this.ob.length){
    		System.out.println("����ǰ��ʱ�����鳤����"+this.ob.length);
    		System.out.println("����ǰʱ���ʱ��size��"+size);
    		resize();
    		System.out.println("���ݺ��ʱ�����鳤����"+this.ob.length);
    		System.out.println("���ݺ��ʱ��size��"+size);
    	}
    	//����� ���ݴ��� ���鳤��ʱ�� ������쳣
    	ob[size++]=data;
    	// 0 1 2 3--->����4 ����5 size����ĸ���
    }
   
   //�������ǲ�ɾ��
    
    public Object peek(){
    	
    	return ob[size-1];
    	
    }
   //������ɾ��
    
    public Object  pop(){
    	Object old=ob[size-1];//���� 5 ���� 4
    	
    	ob[--size]=null;//������Ϊ4 ��������Ϊ4�ĸ�ֵnull
    	
    	return old;
    	
    	
    	
    }
   //���
    
    public void clear(){
    	
    	for(int i=0;i<this.ob.length;i++){
    		ob[i]=null;
    	}
    	size=0;
    }
   
   //�Ƿ�Ϊ��
    
    public boolean empty(){
    	
    	return size==0;
    }
	
    //toString
    
    
    public String toString(){
    	
    	return Arrays.toString(ob);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestStack ts=new TestStack();
		
		ts.push("111");
		System.out.println("���"+ts+ts.size);
		System.out.println("peek"+ts.peek());
		ts.push("Ѽͷ");
		System.out.println("���"+ts+ts.size);
		System.out.println("peek"+ts.peek());
		ts.push("222");
		System.out.println("���"+ts+ts.size);
		System.out.println("peek"+ts.peek());
		ts.push("44");
		System.out.println("���"+ts+ts.size);
		System.out.println("peek"+ts.peek());
		ts.push("55");
		System.out.println("���"+ts+ts.size);
		System.out.println("peek"+ts.peek());
		System.out.println("pop"+ts.pop());
		System.out.println("pop"+ts.pop());
		System.out.println("pop"+ts.pop());
	    ts.clear();
		System.out.println(ts.empty());
	}

}
