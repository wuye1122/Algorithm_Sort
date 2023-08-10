package com.wuye.queue;



public class DoubleQueue<D> {
     /*
      * 双向队列:可以在两端同时进行插入删除 
      * 
      * Deque是 Stack和  Queue两个接口的子接口
      * 既可以当成队列使用也可以当成栈使用
      * 
      * ArrayDeque:代表顺序存储的双向队列
      * 
      * LinkedList:代表链式存储的双向队列，也是接口list的实现类。
      * 
      * LinkedBlockingList:线程安全链式结构双向队列
      * 
      * 几种常见的方法
      * 
      *    int size:计算双向队列的长度。
      * 
      *    displayFront: displayRear
      *    
      *    insertFront : insertRear
      *    
      *    empty():判断是否为空
      *    
      *    peekFront: peekRear
      *    
      *    removeFront:  removenRear
      * 
      * 一般java里面的Queue
      * 
      * public interface Queue<> extends interface collection
      * 
      *   其中每个方法都提供两种形式: 一种抛出异常  另一种返回一个特殊的值null false
      *   
      *   队列通常是FIFO排序个元素: 但是优先队列 LIFO(堆 栈)例外
      *   
      *   
      *   1优先队列通过比较器和元素的自然顺序进行排序
      *   2后者则按照后进先出的方式对元素进行排序
      *   
      * 
      * 先进先出队列:基于FIFO策略的集合
      * 
      *    主要原因:使用集合保存元素的同时 保存其相对顺序,
      *          使他们入列顺序和出列的顺序相同
      *          队列不允许随机访问元素 
      *  
      * 
      * 
      * 
      * 
      * 
      * 
      * 
      * */
	
	
	//定义节点
	
	private class Node{
		
		public Node next;
		
		public Node previous;
		
		D data;
		
		Node(D data){
			this.data=data;
			
		}
		
		void display(){
			System.out.print(data.toString()+"--");
		}
		
	}
	
	
	//定义两处节点头尾
	
	private Node head;
	
	
	private Node tail;
	
	//判断是否为空
	public boolean empty(){
		
		return head==null;
		
	}
	
	
	//向队列两端加入数据
	
	
	public void insertHead(D data){
		Node newNode=new Node(data);
		if(empty()){
			tail=newNode;
			
		}else{
			
			head.previous=newNode;
			
		}
		newNode.next=head;
		
		head=newNode;
	}
	
	
	
	
	public void insertTail(D data){
		
		Node newNode=new Node(data);
		
		if(empty()){
			head=newNode;
			
		}else{
			tail.next=newNode;
			
		}
		newNode.previous=tail;
		
		tail=newNode;
	}
	
	
	//从两端分别进行遍历
	
	public  void displayHead(){
		
		System.out.println("数据head-->tail遍历如下");
		for(Node current=head;current!=null;current=current.next){
			
			current.display();
		}
		System.out.println();
	}
      public  void displayTail(){
		
		System.out.println("数据tail-->head遍历如下");
		for(Node current=tail;current!=null;current=current.previous){
			
			current.display();
		}
		System.out.println();
		
	}
	
	
	
	//计算队列元素长度
	
    public int size(){
	int count=0;
	for(Node current=head;current!=null;current=current.next){
		
		count++;
	}
	return count;
}


//返回两头元素

public D peekHead(){
	
	if(head!=null){
		
		return head.data;
	}
	return null;
}


public D peekTail(){
	
	if(tail!=null){
		
		return tail.data;
	}
	return null;
	
}

//从两端进行数据的删除

public D removeHead(){
	
	if(empty()){
		throw new IndexOutOfBoundsException("队列为空 不可以删除");
		
	}
	 Node old=head;
	
	head=head.next;
	
	head.previous=null;
	
	old.next=null;
	
	return old.data;
}
	

//从尾端进行删除数据

public D removeTail(){
	
	if(empty()){
		throw new IndexOutOfBoundsException("队列为空 不可以删除");
		
	}
	Node old=tail;
	
	tail=tail.previous;
	
	tail.next=null;
	
	old.next=null;
	
	return old.data;
	
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 DoubleQueue<Object> dq=new  DoubleQueue<Object>();
		
	      dq.insertHead("11");
	      dq.insertHead("22");
	      dq.insertHead("33");
	      dq.displayTail();
	      dq.displayHead();
	      dq.insertTail("44");
	      dq.insertTail("55");
	      dq.displayTail();
	      dq.displayHead();
	      System.out.println(dq.size());
		
	      System.out.println(dq.empty());
	      
	      
	      System.out.println("删除的头元素-------"+dq.removeHead());
	      dq.displayTail();
	      dq.displayHead();
	      System.out.println(dq.size());
		
	      System.out.println("删除的尾部元-------"+dq.removeTail());
	      dq.displayTail();
	      dq.displayHead();
	      System.out.println(dq.size());
		
	}

}
