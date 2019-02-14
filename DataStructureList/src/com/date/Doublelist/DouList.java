package com.date.Doublelist;



public class DouList<T> {
     private class Node{
    	 private T date;
    	 private Node pre;
    	 private Node next;
    	@SuppressWarnings("unused")
		public Node(){
    		
    	}
    	 
    	 public Node(T element,Node pre,Node next){
    		 this.date=element;
    		 this.pre=pre;
    		 this.next=next;
    	 }   	 
     }    
	
	 private Node header;
	 private Node tail;
	 private int size;
	 
	public DouList(){
		
	}
    public DouList(T element ){
		header=new Node(element,null,null);
		tail=header;
		size++;
	}
//    public H(){
//		//空链表，header和tail都是null
//		header = null;
//		tail = null;
//	}
	
	public int length(){
		return size;
	}
	//根据索引index获取指定位置的节点
	
	private Node getNodeByIndex(int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("越界了");
		}
		//0 1 2 3 4 5 6 7 8    size=9
		//
		//0 1 2 3 4从头开始/                     5 6 7 8从尾开始/
		if(index<=size/2){
			Node current=header;
			             //4.5
			for(int i=0;i<size/2&&current!=null;i++,current=current.next){
				if(index==i){
					return current;
				}

			}				
		}
		else {
			Node current=tail;
			//4.5
			for(int i=size-1;i>size/2&&current!=null;i--,current=current.pre){
				if(index==i){
					return current;
				}

			}			
			
		}
		return null;	
	}
	//获取链式线性表中索引为index处的元素	
	public T get(int index){
		return  getNodeByIndex(index).date;
	}
	//查找链式线性表中指定元素的索引
	public int findElement(T element){
		Node current=header;
		
		for(int i=0;i<size&&current!=null;i++,current=current.next){
			if(current.date.equals(element)){
				return i;
			}
		}
		
		return -1;
		
		
	}
	//两种增加	
	public void add(T element){
		if(header==null){
		header=new Node(element,null,null);
		tail=header;
		}else{
			
			Node newNode=new Node(element,tail,null);
			//<---
			tail.next=newNode;
			//-->
			tail=newNode;
			//   -->
			// /
		}
		size++;
	}
	
	
	
	public void addHeader(T element){
		Node  newNode=new Node(element,null,header);
		//-->
		header.pre=newNode;
		//<--
		header=newNode;
		//<--
		//   \
		
		if(header==null){
			tail=header;
		}
		size++;
	}
	

	
	
	//向线性链式表的指定位置插入一个元素。
	public void insert(T element,int index){
		if(index<0||index>size){
			throw new IndexOutOfBoundsException("越界了");
		}
		if(header==null){
			add(element);
		}else if(index==0){
         addHeader(element);

		}
		else{
			
			//先确定插入的节点前后   将数据插入其中分别向前向后指向  然后两边的节点再指向中间
             Node pre=getNodeByIndex(index-1);//节点前
             
             Node next=pre.next;//节点后
             
             Node newNode=new Node(element,pre,next);
             
             pre.next=newNode;
             next.pre=newNode;
             size++;
		}
  
	}
	//------------------------------------
			
//else{//删除中间，删除尾部
//		current=this.getNodeByIndex(index);//找到当前节点					
//		current.prev.next=current.next;
//		if(index!=size-1){//尾戒点
//			current.next.prev=current.prev;
//		}
//		
//		current.next=null;
//		current.prev=null;
//	
		//------------------------------------
	
	
	
	
	
	
	
	
	
	
	//此处删除有错误
	//删除链式线性表中指定索引处的元素
	public T delete(int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("越界了");
		}
		Node del=null;
		if(index==0){
			del=header;
			header=header.next;
			
			header.pre=null;
			del.next=null;	

			
			

		}else{

			Node pre=getNodeByIndex(index-1);

			del=pre.next;
//    pre del 
//
//			
			pre.next=del.next;

			if(del.next!=null){
				del.next.pre=pre;
			}
			//解绑了
			del.next=null;
			del.pre=null;
		}
		size--;
		return del.date;
	}
	//三种删除后的处理
  public T remove(){
	  return delete(size-1);
	  
  }
  public boolean empty(){
	  return size==0;
  }
	public void clear(){
		header=null;
		tail=null;
		size=0;
	}
	
	//遍历&&反转
	public String toString(){
		if(empty()){
			return "[]";
		}else{
			StringBuilder sb=new  StringBuilder("[");
			for(Node current=header;current!=null;current=current.next){
				
				sb.append(current.date.toString()+",");
			}
			int len=sb.length();
			return sb.delete(len-1, len).append("]").toString();
		}
				
	}
	public String AtoString(){
		if(empty()){
			return "[]";
		}else{
			StringBuilder sb=new  StringBuilder("[");
			
			for (Node current = tail ; current != null 
				; current = current.pre ){
				sb.append(current.date.toString() + ",");
			}
			int len=sb.length();
			return sb.delete(len-1, len).append("]").toString();
		}
				
	}



	






}
