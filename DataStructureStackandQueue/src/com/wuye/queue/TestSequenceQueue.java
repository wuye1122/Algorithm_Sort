package com.wuye.queue;

import java.util.Arrays;

public class TestSequenceQueue<T> {
   //  7种方法
	private Object ob[];
	
	//private int front;
	
	//private int rear;
	
	public static int front;
	
	public static int rear;//便于看清楚 front rear指在何位置
	
	//7个方法
	TestSequenceQueue(){
		
		ob=new Object[4];
	}
	//队列里面添加元素
	
	public void add(T data){
		if(rear>=this.ob.length){
			throw new IndexOutOfBoundsException("队列已经满了 只能添加指定数组大小");
		}
	    //增加元素尾++
		ob[rear++]=data;
		
		
	}
	
	//返回元素的个数
	public int length(){
		
		return rear-front;
	}
	//返回队头元素
	
	public T element(){
		
		return (T)ob[front];
	}
	
	//返回队头元素并且返回
	
	public T remove(){
		
		Object o=ob[front];
		
		//删除元素头++
		ob[front++]=null;
		
		return (T)o;
	}
	
	
	//判断是否为空
	public  boolean empty(){
		
		return front==rear;
		
	}
 	
	
	
	
	//清空
	
	public void clear(){
		
		for(int i=0;i<this.ob.length;i++){
			ob[i]=null;
			
		}
		front=rear=0;
	}
	
	//重写
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
		
		tq.add("混乱");
		
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
		System.out.println("---长度---"+tq.length());
		System.out.println("remove-----"+tq.remove());
		System.out.println("---"+tq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		System.out.println(tq.empty());
		System.out.println("---长度---"+tq.length());
		
		tq.clear();
		System.out.println("---"+tq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		System.out.println("---长度---"+tq.length());
		System.out.println(tq.empty());
	}

}
