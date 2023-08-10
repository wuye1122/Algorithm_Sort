package com.wuye.queue;

import java.util.Arrays;

public class LoopQueue<C> {

	/* 循环队列
	 * 
	 * 该队列首尾相连的队列 总数量size
	 * index  0--size-1
	 * 如果队列已经满了 再添加一个元素的话 rear就会变为0
	 * 不管是队列空的还是满的都会出现一个现象 front==rear
	 * 
	 * 只有当ob[front]=null表名队列已经空了 否则表明队列已经满了
	 * 循环队列的空间可以循环使用 
	 * 当头部元素remove之后其空间可以继续被使用
	 * 
	 * 
	 * 
	 * */
	
	
	//private int front=0;
	public static int front=0;
	//private int rear=0;
	public  static int rear=0;
	private Object  ob[];
	
	private int cap;//用于保存数组长度的变量
	
	
	//一个元素  一个数组长度 来创建一个初始的循环队列
	LoopQueue(C data,int initsize){
		
		this.cap=initsize;
		
		ob=new Object[this.cap];
		
		ob[0]=data;
		
		rear++;
		
	}
	
	//老俗套 判断是否为空
	
	public boolean empty(){
		
		return front==rear&&ob[front]==null;
	}
	
	//clear清空
	
	public void clear(){
		
		Arrays.fill(ob, null);
		front=rear=0;
		
	}
	
	//返回元素长度 此处很精妙
	
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
		throw new IndexOutOfBoundsException("队列为空 获取失败");
	}	
		return (C)ob[front];
	}
	
	
	
	
	//add
	
	public void add(C data){
		
		if(front==rear&&ob[front]!=null){
			
			throw new IndexOutOfBoundsException("队列为已经满了 无法添加");
		}
		
		ob[rear++]=data;
		
		rear=rear==this.cap?0:rear;
	}
	
	
	//remove
	
	public C remove(){
		if(empty()){
			throw new IndexOutOfBoundsException("队列为空 获取失败");
		}	
		C o=(C)ob[front];
		
		ob[front++]=null;
		
	  front=front==this.cap?0:front;
		return o;
	}
	
	
	
	//重写
	
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
		
		lq.add("444");
		System.out.println(lq);
		System.out.println("front---"+front);
		System.out.println("rear---"+rear);
		
	}

}
