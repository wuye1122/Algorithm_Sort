package com.wuye.queue;

import java.util.Arrays;

public class LoopQueue<C> {

	/* ѭ������
	 * 
	 * �ö�����β�����Ķ��� ������size
	 * index  0--size-1
	 * ��������Ѿ����� �����һ��Ԫ�صĻ� rear�ͻ��Ϊ0
	 * �����Ƕ��пյĻ������Ķ������һ������ front==rear
	 * 
	 * ֻ�е�ob[front]=null���������Ѿ����� ������������Ѿ�����
	 * ѭ�����еĿռ����ѭ��ʹ�� 
	 * ��ͷ��Ԫ��remove֮����ռ���Լ�����ʹ��
	 * 
	 * 
	 * 
	 * */
	
	
	//private int front=0;
	public static int front=0;
	//private int rear=0;
	public  static int rear=0;
	private Object  ob[];
	
	private int cap;//���ڱ������鳤�ȵı���
	
	
	//һ��Ԫ��  һ�����鳤�� ������һ����ʼ��ѭ������
	LoopQueue(C data,int initsize){
		
		this.cap=initsize;
		
		ob=new Object[this.cap];
		
		ob[0]=data;
		
		rear++;
		
	}
	
	//������ �ж��Ƿ�Ϊ��
	
	public boolean empty(){
		
		return front==rear&&ob[front]==null;
	}
	
	//clear���
	
	public void clear(){
		
		Arrays.fill(ob, null);
		front=rear=0;
		
	}
	
	//����Ԫ�س��� �˴��ܾ���
	
	public int length(){
		if(empty()){
			return 0;
		}
		return rear>front?rear-front:this.cap-(front-rear);
//0 1 2 3 null  rear=4  front=0 (4-0)
		
//0 1 null null 4 front=4 rear=2 5-(4-2)		
	}
	
	
	//element
	
	
	public C element(){
	if(empty()){
		throw new IndexOutOfBoundsException("����Ϊ�� ��ȡʧ��");
	}	
		return (C)ob[front];
	}
	
	
	
	
	//add
	
	public void add(C data){
		
		if(front==rear&&ob[front]!=null){
			
			throw new IndexOutOfBoundsException("����Ϊ�Ѿ����� �޷����");
		}
		
		ob[rear++]=data;
		
		rear=rear==this.cap?0:rear;
	}
	
	
	//remove
	
	public C remove(){
		if(empty()){
			throw new IndexOutOfBoundsException("����Ϊ�� ��ȡʧ��");
		}	
		C o=(C)ob[front];
		
		ob[front++]=null;
		
	  front=front==this.cap?0:front;
		return o;
	}
	
	
	
	//��д
	
	public String toString(){
		
		return Arrays.toString(ob);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LoopQueue<Object> lq=new LoopQueue("111",5);
		
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
		
		lq.add("444");
		System.out.println(lq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		
	}

}
