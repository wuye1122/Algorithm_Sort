package com.date.Circlelist;

import java.util.Iterator;



public class CircleList1<T> {

	
	private class Node{

		private T date;

		private Node next;

		//无参数的构造器
		@SuppressWarnings("unused")
		public Node(){
		}
		//初始化全部属性的构造器
		public Node(T date,Node next){
			this.date=date;
			this.next=next;
		}

	}
	
	private Node header;
	private Node tail;
	private int size;
	
	//创建空链表
	public CircleList1(){
		this.header=null;
		this.tail=null;
	    size=0;	
	}
	//以指定一个元素创建该数组
	public CircleList1(T element){
		header =new Node(element,null);
		tail=header;
		size++;
		
		
	}
	//返回链表的长度
	public int length(){
		return size;
	}
	//根据索引index获取指定位置的节点
	private Node getNodeByIndex(int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("越界了");
		}
		Node current=header;
		for(int i=0;i<size&&current!=null;i++,current=current.next){
			if(i==index){
				return current;
			}
		}
		return null;
	}
	
	
	//获取链式线性表中索引为index处的元素
	public T get(int index){
		return  getNodeByIndex(index).date;
		
	}
	
	//查找链式线性表中指定元素的索引
	public int FindElement(T element){
		Node current=header;
		for(int i=0;i<size&&current!=null;i++,current=current.next){
			if(current.date.equals(element)){
				return i;
			}			
		}		
		return -1;		
	}
	//采用尾插法为链表添加新节点。
	public void add(T element){
		if(header==null){
			header=new Node(element,header);
			tail=header;
		}else{
		Node  newNode=new Node(element,null);
		tail.next=newNode;
		tail=newNode;
		tail.next=header;
		}	
	size++;
	
}	//采用头插法为链表添加新节点
	public void addHeader(T element){
		header=new Node(element,header);
		if(tail==null){
			tail=header;
		}
		size++;
	}

	//插入某处一个个元素
	
	public void insert(T element,int index){
		if(index<0||index>size){
			throw new IndexOutOfBoundsException("你又越界了");
		}
		if(header==null){
			add(element);
		}
		else{
			if(index==0){
			addHeader(element);
		}else{

			Node pre=getNodeByIndex(index-1);

			pre.next=new Node(element,pre.next);
			size++;		
			}	
		}
	}
	//删除链式线性表中指定索引处的元素
	public T delete(int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("越界了吧");
		}
		Node del=null;
		if(index==0){
			del=header;
			header=header.next;
		}else{
			Node pre=getNodeByIndex(index-1);
			del=pre.next;
			pre.next=del.next;
			del.next=null;
		}
		size--;
		return del.date;
	}

	
	//删除链式线性表中最后一个元素
	public T romove(){
		return delete(size-1);
	}
	//判断链式线性表是否为空表
	public boolean empty(){
		return size==0;
	}
	//清空线性表
	public void clear(){
		header=null;
		tail=null;
		size=0;
		
	}
	//遍历
	public String toString(){
		if(empty()){
			return "[]";
		}
		else{
			StringBuilder sb=new StringBuilder("[");
			int i=0;
			for(Node current=header;current!=null;current=current.next){
				if(i==size){
					break;
				}
				sb.append(current.date.toString()+",");
				i++;
			}
			int len=sb.length();	
			return sb.delete(len-1, len).append("]").toString();
		}
	}
	private class  MyIterator implements Iterator<T>{
      private int  a=0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			
			return a!=size;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			T data=CircleList1.this.get(a);
			a++;
			return data;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
		
		
	}
	public Iterator<T>  Iterator(){
		return new MyIterator();
	}
 	
	
	
	
	
	
}
