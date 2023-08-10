package com.date.Linklist;

public class List1<T> {
       //node是一个类
	private class Node{
		private T date;
		
		private Node next;
		
		private Node(){
			
		}
		
		private Node(T date,Node next){
			this.date=date;
			this.next=next;
			
		}
	}//节点类以及结束
		
		private Node header;
		private Node tail;
		private int size;
	   //空
	    public List1(){
	    header=null;
	    tail=null;
	   }
	    //一个元素 链表
	    public List1(T element){
	    	header=new Node(element,null);//.next  .date在构造器参数里已经有了
	    	tail=header;
	    	size++;
	    }
	
	//长度
	    public int length(){
	    	return size;
	    }
	
		//采用尾插法为链表添加新节点。	    
	    
	    public void add(T element){
	    	//空
	    	if(header==null){
	    		header=new Node(element,null);
	    		tail=header;
	    	}else{
	    		//新建一个
	    		Node	newNode=new Node(element,null);
	    		tail.next=newNode;
	    		tail=newNode;
	    	}
	    	size++; 
	    }   

	    //采用头插法为链表添加新节点。
	    
	    public void addHeader(T element){  

	    	header=new Node(element,header);
	    	if(tail==null){
	    		tail=header;
	    	}
	    	size++;
	    } 
	  //根据索引index获取指定位置的节点
		private Node getNodeByIndex(int index){
	    	if(index<0||index>size){
	    		try {
					throw new Exception();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	Node currentNode=header;
	    	for(int i=0;i<size&&currentNode!=null;i++,currentNode=currentNode.next){
	    		if(i==index){
	    			return currentNode;
	    		}
	    	}
			return null;
	    	
	    	
	    } 
	    
	  //获取链式线性表中索引为index处的元素 
	    
	    public T get(int index){
	    	return getNodeByIndex(index).date;
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

	    
	//在某索引处插入元素
	    
	    public void Insert(T element,int index){
	    	if(index<0||index>size-1){
	    		throw new IndexOutOfBoundsException("卫老师提示：线性表索引越界");
	    	}
	    	if(header==null){
	    		 add(element);
	    		
	    	}else{
	    		if(index==0){
	    			addHeader(element);
	    			
	    		}else{
	    			//取得前一个节点
	    			Node pre=getNodeByIndex(index-1);
	    			//让prev的next指向新节点，让新节点的next引用指向原来prev的下一个节点
	    			pre.next=new Node(element,pre.next);
	    			size++;
	    		}
	    		
	    	}
	    	
	    }

	    
	    
	    //删除链式线性表中指定索引处的元素
	    public T delete(int index){
	    	if(index<0||index>size-1){
	    		throw new IndexOutOfBoundsException("卫老师提示：线性表索引越界");
	    	}

	    	Node del=null;
	    	if(index==0){
	    		del=header;
	    		header=header.next;
	    	}
	    	else{
	    		Node pre=getNodeByIndex(index-1);
	    		//看好关系
	    		del=pre.next;
	    		pre.next=del.next;
	    		del.next=null;
	    	}
	    	size--;
	    	return del.date;
	    }
	    
	  //删除链式线性表中最后一个元素
	    public T remove(){
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

	    	}else {
	    		StringBuilder sb=new StringBuilder("[");

	    		for(Node current=header;current!=null;current=current.next){

	    			sb.append(current.date.toString()+",");
	    		}
	    		int len=sb.length();
	    		return sb.delete(len-1, len).append("]").toString(); 
	    	}
	    }  

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
