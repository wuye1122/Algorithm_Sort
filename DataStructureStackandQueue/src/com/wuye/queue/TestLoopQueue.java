package com.wuye.queue;

import java.util.Arrays;

public class TestLoopQueue<B> {

	//���� ѭ������
	  
	
//	private int front=0;
//	
//	private int rear=0;
	
	public static int front=0;
	
	public static int rear=0;
	
	private Object ob[];
	
	//�����������
	
	private int cap;
	
	//��һ��Ԫ�ؽ��г�ʼ��
	TestLoopQueue(B data,int initsize){
		
		this.cap=initsize;
		
		ob=new Object[this.cap];
		
		ob[front]=data;//�൱�ڵ�һ��Ԫ��
		
	     rear++;
		
		
	}
	
	//�ж��Ƿ�Ϊ��
	
	public boolean empty(){
		
		return front==rear&&ob[front]==null;
		
	}
	
	
	//����ѭ������Ԫ�ظ���
	
	public int length(){
		if(empty()){
			return 0;
		}
//0 1 2 3 null   4-0
		
//0 1 null null 4  5-(4-2)		
		return rear>front?rear-front:this.cap-(front-rear);
	}
	
	//���
	public void clear(){
		
		Arrays.fill(ob, null);
		front=rear=0;
	}
	
	//��д
	
	public String toString(){
		
		
		return Arrays.toString(ob);
		
	}
	
	
	//����ѭ������ͷ��Ԫ��
	
	public B element(){
		if(empty()){
			throw new IndexOutOfBoundsException("����Ϊ�� �޷���ȡ");
			
		}
		return (B)ob[front];
	}
	
	
	//��ѭ�������������Ԫ��
	public void add(B data){
	if(front==rear&&ob[front]!=null){
		throw new IndexOutOfBoundsException("�����Ѿ����� �޷����");
		
	}	
	//�����ɸ��ǵ�ѭ������    rear��һȦһȦ�� ɾ����ʱ�����
	//
	//
	ob[rear++]=data;
	
	rear=rear==this.cap?0:rear;
		
	}
	
	
	
	//�Ӷ�������ɾ��Ԫ�ز��ҷ���
	
	public B remove(){
		if(empty()){
			throw new IndexOutOfBoundsException("����Ϊ�� ɾ���쳣");
		}
		B o=(B)ob[front];
		
		ob[front++]=null;
		
		front=front==this.cap?0:front;
		
		return o;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		TestLoopQueue<Object> lq=new TestLoopQueue("111",5);
		
		System.out.println(lq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		
		lq.add("222");
		lq.add("333");
		lq.add("444");
		
		System.out.println(lq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
	
		System.out.println("�Ƿ�Ϊ��"+lq.empty());
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		lq.add("���һ��");
		System.out.println(lq);
		System.out.println("�Ƿ�Ϊ��"+lq.empty());
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		
		System.out.println(lq.element());
		System.out.println(lq.element());
		System.out.println(lq.length());
		
		System.out.println(lq.remove());
		System.out.println(lq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		
		System.out.println(lq.remove());
		System.out.println(lq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		
		System.out.println(lq.remove());
		System.out.println(lq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		System.out.println(lq.length());
		lq.add("sd");
		System.out.println(lq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		System.out.println(lq.length());
		lq.remove();
		System.out.println(lq);
		
		lq.remove();
		System.out.println(lq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		lq.remove();
		System.out.println(lq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		
		System.out.println(lq.empty());
		System.out.println(lq.length());
		lq.add("444");
		System.out.println(lq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		
		lq.clear();
		System.out.println(lq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		
		lq.add("111");
		System.out.println(lq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		lq.add("222");
		lq.add("333");
		lq.add("444");
		lq.add("555");
		System.out.println(lq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		
	}

}
