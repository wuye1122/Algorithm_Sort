package com.wuye.list;

public class TestDoubleList1<T> {
  
	//14个方法
	
	private class Node{
		
		public T data;
		
		public Node pre;
		
		public Node next;
		
		public Node(T data,Node pre,Node next){
			this.data =data;
			this.pre =pre;
			this.next =next;
			
		}
	}
	
	private Node head;
	
	private Node tail;
	
	private int size;
	
	TestDoubleList1(){}
	
	TestDoubleList1(T data){
		head=new Node(data,null,null);
		tail=head;
		size++;
	}
	public int length(){
		
		return this.size ;
	}
	
	public void clear(){
		head=null;
		tail=null;
		size=0;
		
	}
	
	public boolean empty(){
		
		return size==0;
	}
	//获取指定位置节点
	public Node getNodeByIndex(int index){
		
		
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("索引越界");
			
		}
		Node current=null;
		if(index<=size/2){
			current=head;
			for(int i=0;i<index;i++){
				
				current=current.next;
				
			}
			
		}else{
			current=tail;
			for(int i=size-1;i>index;i--){
				
				current=current.pre;
				
			}
			
		}
		return current;
	}
	//获取指定位置元素
	public T get(int index){
		
		return getNodeByIndex(index).data;
	}
   
	//头部添加
	public void addHead(T data){
		if(empty()){
			Node current=new Node(data,null,null);
			head=current;
			tail=current;
			size++;
			
		}else{
			                     //   pre  next
			Node current=new Node(data,null,head);
			head.pre=current;
			head=current;
			size++;
			
			
		}
		
	}
	//尾部添加
	public void add(T data){
		if(empty()){
			Node current=new Node(data,null,null);
			head=current;
			tail=current;
			size++;
			
		}else{
			                     //   pre  next
			Node current=new Node(data,tail,null);
			tail.next=current;
			tail=current;
			size++;
			
			
		}
		
	}
	//插入
	public void insert(T data,int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("索引越界");
			
		}
		if(empty()){
			add(data);
			
		}else{
			if(index==0){
            addHead(data);
		    }else{
		    	Node pre=getNodeByIndex(index-1);
		    	
		    	Node next=pre.next;
		    	
		    	Node current=new Node(data,pre,next);
		    	
		    	pre.next=current;
		    	
		    	next.pre=current;
		    	
		    	size++;
		    	
			
		   }
		}
		
		
	}
	//重写
	public String toString(){
		
		if(empty()){
			
			return "[]";
		}else{
			StringBuffer sb=new StringBuffer("[");
			for(Node current=head;current!=null;current=current.next){
				
				sb.append(current.data.toString()+",");
			}
			return sb.delete(sb.length()-1, sb.length()).append("]").toString();
		}
		
		
	}
	//反转
public String AtoString(){
		
		if(empty()){
			
			return "[]";
		}else{
			StringBuffer sb=new StringBuffer("[");
			for(Node current=tail;current!=null;current=current.pre){
				
				sb.append(current.data.toString()+",");
			}
			return sb.delete(sb.length()-1, sb.length()).append("]").toString();
		}
		
		
	}
	
	//删除指定索引处的元素

   public T delete(int index){
	   
	   if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("索引越界");
			
		}
	   Node del=null;
	   if(index==0){
		   del=head;
		   head=head.next;
		   
		   head.pre=null;
		   del.next=null;
		   
	   }
	   else if(index==size-1){
		   del=tail;
		   tail=tail.pre;
		   
		   tail.next=null;
		   del.pre=null;
		   
		   
	   }
	   else{
		   del=getNodeByIndex(index);
		   
		   del.pre.next=del.next;
		   
		   del.next.pre=del.pre;
		   
		   
		   del.pre=null;
		   
		   del.next=null;
		   
		   
		   
	   }
	   size--;
	   return del.data;
   }
	
	
	//获取指定位置的值
	
	public T remove(){
		return delete(size-1);
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		TestDoubleList1<Object> dl=new TestDoubleList1<Object>("aa");
		System.out.println(dl);
		dl.add("111");
		dl.add("222");
		dl.add("333");
		dl.add("444");
		dl.add("555");
		System.out.println(dl);
		System.out.println(dl.AtoString());
		dl.addHead("头部");
		dl.addHead("头头部");
		dl.addHead("头头头部");
		dl.insert("1", 0);
		System.out.println(dl);
		dl.insert("9", 9);
		System.out.println(dl);
		dl.insert("9", 9);
		System.out.println(dl);
		dl.insert("11", 11);
		dl.insert("12", 12);
	//	dl.insert("14", 14);
		
	//	System.out.println(dl.AtoString());

//		System.out.println("------获得node-----"+dl.getNodeByIndex(-1));
		System.out.println("------获得node-----"+dl.get(0));
		System.out.println("------获得node-----"+dl.getNodeByIndex(1));
		System.out.println("------获得node-----"+dl.getNodeByIndex(2));
		System.out.println("------获得node-----"+dl.getNodeByIndex(3));
		System.out.println("------获得node-----"+dl.getNodeByIndex(4));
		System.out.println("------获得node-----"+dl.get(5));
		System.out.println("------获得node-----"+dl.getNodeByIndex(6));		
		System.out.println("------获得node-----"+dl.getNodeByIndex(7));
		System.out.println("------获得node-----"+dl.getNodeByIndex(8));
		System.out.println("------获得node-----"+dl.get(9));
		System.out.println("------获得node-----"+dl.getNodeByIndex(10));
		System.out.println("------获得node-----"+dl.getNodeByIndex(11));
		System.out.println("------获得node-----"+dl.getNodeByIndex(12));
		System.out.println("------获得node-----"+dl.get(13));
//		System.out.println("------获得node-----"+dl.getNodeByIndex(14));
		
		System.out.println(dl);
		System.out.println(dl.delete(0));
		System.out.println(dl.delete(6));
		System.out.println(dl.delete(7));
		System.out.println(dl.delete(10));
		System.out.println("---此时的长度为---"+dl.length());
		System.out.println(dl);
		System.out.println("------获得node-----"+dl.getNodeByIndex(0));
		System.out.println("------获得node-----"+dl.getNodeByIndex(1));
		System.out.println("------获得node-----"+dl.getNodeByIndex(2));
		System.out.println("------获得node-----"+dl.getNodeByIndex(3));
		System.out.println("------获得node-----"+dl.getNodeByIndex(4));
		System.out.println("------获得node-----"+dl.getNodeByIndex(5));
		System.out.println("------获得node-----"+dl.getNodeByIndex(6));		
		System.out.println("------获得node-----"+dl.getNodeByIndex(7));
		System.out.println("------获得node-----"+dl.getNodeByIndex(8));
		System.out.println("------获得node-----"+dl.getNodeByIndex(9));
		System.out.println("获取"+"-----"+dl);
		System.out.println(dl.remove());
		System.out.println(dl);
		System.out.println(dl.remove());
		System.out.println(dl);
		System.out.println(dl.remove());
		System.out.println(dl);
		System.out.println(dl.remove());
		System.out.println(dl.AtoString());
		System.out.println(dl.delete(0));
		System.out.println(dl);
		System.out.println(dl.delete(0));
		System.out.println(dl);
		System.out.println(dl.delete(0));
		System.out.println(dl);
		System.out.println(dl.delete(0));
		System.out.println(dl);
	  dl.insert(11, 0);
	  dl.insert(11, 0);
	  dl.insert(33, 3);
	  dl.insert(44, 4);
		System.out.println(dl);
//		dl.clear();
//		System.out.println(dl.empty());
//		System.out.println(dl);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
