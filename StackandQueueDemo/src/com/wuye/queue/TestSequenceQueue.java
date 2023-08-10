package com.wuye.queue;

import java.util.Arrays;

public class TestSequenceQueue<T> {
   //  7�ַ���
	private Object ob[];
	
	//private int front;
	
	//private int rear;
	
	public static int front;
	
	public static int rear;//���ڿ���� front rearָ�ں�λ��
	
	//7������
	TestSequenceQueue(){
		
		ob=new Object[4];
	}
	//�����������Ԫ��
	
	public void add(T data){
		if(rear>=this.ob.length){
			throw new IndexOutOfBoundsException("�����Ѿ����� ֻ�����ָ�������С");
		}
	    //����Ԫ��β++
		ob[rear++]=data;
		
		
	}
	
	//����Ԫ�صĸ���
	public int length(){
		
		return rear-front;
	}
	//���ض�ͷԪ��
	
	public T element(){
		
		return (T)ob[front];
	}
	
	//���ض�ͷԪ�ز��ҷ���
	
	public T remove(){
		
		Object o=ob[front];
		
		//ɾ��Ԫ��ͷ++
		ob[front++]=null;
		
		return (T)o;
	}
	
	
	//�ж��Ƿ�Ϊ��
	public  boolean empty(){
		
		return front==rear;
		
	}
 	
	
	
	
	//���
	
	public void clear(){
		
		for(int i=0;i<this.ob.length;i++){
			ob[i]=null;
			
		}
		front=rear=0;
	}
	
	//��д
	public String toString(){
		
		return Arrays.toString(ob);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		TestSequenceQueue<Object> tq=new TestSequenceQueue<Object>();
		
		System.out.println("---"+tq);
		
		tq.add("111");
		
		tq.add("222");
		
		tq.add("333");
		
		System.out.println("---"+tq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		
		tq.add("����");
		
		System.out.println("---"+tq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		
	//	tq.add("444");
		System.out.println("element-----"+tq.element());
		
		System.out.println("remove-----"+tq.remove());
		System.out.println("---"+tq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		System.out.println("remove-----"+tq.remove());
		System.out.println("---"+tq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		System.out.println("---����---"+tq.length());
		System.out.println("remove-----"+tq.remove());
		System.out.println("---"+tq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		System.out.println(tq.empty());
		System.out.println("---����---"+tq.length());
		
		tq.clear();
		System.out.println("---"+tq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		System.out.println("---����---"+tq.length());
		System.out.println(tq.empty());
	}

}
