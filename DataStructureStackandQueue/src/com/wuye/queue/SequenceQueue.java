package com.wuye.queue;

import java.util.Arrays;

public class SequenceQueue<T> {

	
	/*  开发的时候所以常量都放在一个类上
	 * 
	 * 
	 * 数组实现的队列
	 * 
	 * 1  只允许在表的尾端rear进行插入数据    在表的头端front进行删除数据 队列的方向固定 
	 *  FIFO的线性表
	 * 
	 * 2 常用的操作:
	 * 队列是一种被限制的线性表 因此不允许在任意位置访问数据
	 * 
	 * 
	 * 3 顺序队列 :SequenceQueue 数组实现
	 *        
	 *         连续的存储单元依次存放从front-->rear所有数据元素
	 *         使用front 和 rear 两个整形变量记录 头尾索引  
	 *         rear似乎保存下一个进入元素的索引    
	 *         front保存队列里面即将出队列元素的索引
	 *         
	 *         0 1 2 3 4 
	 *         元素的个数   rear-front
	 *         底层采用的数组实现  所以元素位置是固定的 插入数据rear+1 删除数据front+1
	 *  
	 *  
	 *         对内存的要求很严格 需要连续的存储位置 查找时间复杂度小 效率高
	 *         
	 *  链式队列:LinkQueue
	 *         
	 *         采用指针只是存储数据的位置 这就可以在内存里面随意存储  没有必须连续存储的空间
	 *         对内存要求不是很高
	 *         对于有规律的排序的数据  时间复杂度比较小 效率比较高
	 *         对于无规律的数据 使用链式存储   时间复杂度比较大  效率比较低 
	 * 
	 *     
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	private Object [] os;
	
//	private int front;//指向队头元素
//	
//	private int rear;//指向队尾+1处索引
	
	public static int front;
	public static int rear;
	public SequenceQueue(){
		
		os=new Object[2];
	}
	
	
	//添加元素
	
	public void add(T data){
		if(rear>=os.length){
			//如果 添加完一个元素后队列已经满了  视为rear无处存在 
			throw new IndexOutOfBoundsException("队列已满 不可以添加");
		}
		os[rear++]=data;
		//
		//
		//
	}
	
	
	//删除队列头元素 返回
	public T remove(){
		if(empty()){
			throw new IndexOutOfBoundsException("队列为空不可以删除");
		}
		T o=(T)os[front];
		os[front++]=null;
		return o;
	}
	
	
	
	//仅仅返回队头元素不删除
	
	public T element(){
		
		return (T)os[front];
	}
	
	
	//返回元素个数
	
	public  int length(){
		
		return rear-front;
	}
	
	//队列为空
	
	public boolean empty(){
		return rear==front;
		
	}
	
	//清空
	
	public void clear(){
		
		//Arrays.fill(os,null);
		for(int i=0;i<os.length;i++){
			os[i]=null;
		}
		rear=front=0;//清空时候 rear和front均会在0位置处
	}
	
	//toString
	
	
	public String toString(){
		
		
		return Arrays.toString(os);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SequenceQueue<Object> queue=new SequenceQueue<Object>();
		
		System.out.println(queue);
		System.out.println("---front---"+front);
		System.out.println("---rear---"+rear);
		
		queue.add("111");
		System.out.println(queue);
		System.out.println("---front---"+front);
		System.out.println("---rear---"+rear);
	
		
		queue.add("22");
		System.out.println(queue);
		System.out.println("---front---"+front);
		System.out.println("---rear---"+rear);
		//当添加第三个的时候 才会异常 自己走一下就知道了
		
		
//		queue.add("33");
//		System.out.println(queue);
//		System.out.println("---front---"+front);
//		System.out.println("---rear---"+rear);
		
	
//		System.out.println(front);
		
		
//		System.out.println("-----"+queue.element());
//		System.out.println("-----"+queue.remove());
//		System.out.println(queue);
//		System.out.println("-----"+queue.remove());
//		System.out.println(queue);
//		System.out.println(queue.length());
//		System.out.println(queue.element());
//		System.out.println(queue.empty());
//		queue.clear();
//		//System.out.println(queue.remove());
//		System.out.println(queue.empty());
//		System.out.println(front);
//		System.out.println(rear);

		
		
	}

}
