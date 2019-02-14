package com.wuye.queue;

import java.util.Arrays;

public class TestLoopQueue<B> {

	//测试 循环队列
	  
	
//	private int front=0;
//	
//	private int rear=0;
	
	public static int front=0;
	
	public static int rear=0;
	
	private Object ob[];
	
	//保存数组个数
	
	private int cap;
	
	//以一个元素进行初始化
	TestLoopQueue(B data,int initsize){
		
		this.cap=initsize;
		
		ob=new Object[this.cap];
		
		ob[front]=data;//相当于第一个元素
		
	     rear++;
		
		
	}
	
	//判断是否为空
	
	public boolean empty(){
		
		return front==rear&&ob[front]==null;
		
	}
	
	
	//返回循环队列元素个数
	
	public int length(){
		if(empty()){
			return 0;
		}
//0 1 2 3 null   4-0
		
//0 1 null null 4  5-(4-2)		
		return rear>front?rear-front:this.cap-(front-rear);
	}
	
	//清空
	public void clear(){
		
		Arrays.fill(ob, null);
		front=rear=0;
	}
	
	//重写
	
	public String toString(){
		
		
		return Arrays.toString(ob);
		
	}
	
	
	//返回循环队列头部元素
	
	public B element(){
		if(empty()){
			throw new IndexOutOfBoundsException("队列为空 无法获取");
			
		}
		return (B)ob[front];
	}
	
	
	//向循环队列里面添加元素
	public void add(B data){
	if(front==rear&&ob[front]!=null){
		throw new IndexOutOfBoundsException("队列已经满了 无法添加");
		
	}	
	//如果变成覆盖的循环队列    rear将一圈一圈走 删除的时候出现
	//
	//
	ob[rear++]=data;
	
	rear=rear==this.cap?0:rear;
		
	}
	
	
	
	//从队列里面删除元素并且返回
	
	public B remove(){
		if(empty()){
			throw new IndexOutOfBoundsException("队列为空 删除异常");
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
	
		System.out.println("是否为空"+lq.empty());
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		lq.add("最后一个");
		System.out.println(lq);
		System.out.println("是否为空"+lq.empty());
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
