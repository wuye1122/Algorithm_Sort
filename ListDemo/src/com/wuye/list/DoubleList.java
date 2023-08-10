package com.wuye.list;

public class DoubleList<T> {

	/* 双向链表
	 * 双向列表里面的每个节点包含next pre两个引用
	 * 分别指向该节点前面的和该节点后面的节点
	 * 
	 * 对称结构 克服了单向链表单向性的缺点 其中每个节点既可以向前引用
	 * 也可以向后引用 方便插入和删除
	 * 
	 * 
	 * 双向链表的查找可以从两头head tail两头出发
	 * 可以反对查找索引靠近哪头 
	 * 
	 * 双向链表的插入和删除：
	 * 插入时候 两个next 两个pre
	 * 删除时候 图个删除节点的next=null  pre=null
	 * 
	 * 
	 * 再删除节点的时候需要分情况讨论------- 删除头部  删除尾部   删除中
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	private class Node{
		
		Node pre;
		
		Node next;
		
		T data;
		
		Node(T data,Node pre,Node next){
			this.data=data;
			this.pre=pre;
			this.next=next;			
		}

	}
	
	private Node head;
	
	private Node tail;
	
	private int size;
	
	DoubleList(){
		//为空
		
		
	}
	
	//定义一个元素的双向链表
	
	DoubleList(T data){
		
		head=new Node(data,null,null);
		tail=head;
		size++;
		
	}
	
	//长度
	public int length(){
		return this.size;
	}
	
	//清空
	public void clear(){
		head=null;
		tail=null;
		size=0;
	}
	
	//判断是否为空
	public boolean empty(){
		
		return size==0;
		
	}
	//增加 add
	public void add(T data){
		
	//尾部增加 <--
		
		
		if(empty()){
			Node current=new Node(data,null,null);
			head=current;
			tail=current;
			size++;
		}else{
			//<--
			Node current=new Node(data,tail,null);
			//-->
			tail.next=current;
			//   -->
			//  /
			tail=current;
			size++;
		}
		
	}
	
	
	//头部增加-->
	public void addHead(T data){
		
		
		if(empty()){
			Node current=new Node(data,null,null);
			head=current;
			tail=current;
			size++;
		}else{
			
			//-->
			Node current=new Node(data,null,head);
			//<--
			head.pre=current;
			
			//<-- 
			//   \
			head=current;
			size++;
			
			
			
		}
	}
	
	//插入指定位置的索引
	
	public void insert(T data,int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("索引异常");
		}
		if(empty()){
			add(data);
			
			
		}else{
			if(index==0){
				addHead(data);
				
			}else{
				//获取插入处 前 后节点
				
				Node pre=getNodeByIndex(index-1);
				
				Node net=pre.next;
				
				//  <---  --->
				Node newNode=new Node(data,pre,net);
				//  --->  <---
				pre.next=newNode;
				
				net.pre=newNode;
				
				size++;
				
				
			}
			
			
			
		}
		
		
		
	}
	
	
	//删除指定索引处的元素
	
	public T delete(int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("索引超过范围");
			
		}
		Node del=null;
		if(index==0){//如果是头部元素
			 del=head;
			head=head.next;
			
			head.pre=null;
			del.next=null;
			
		}
		else if(index==size-1){
			//如果是尾部元素
			del=tail;
			tail=tail.pre;
			
			tail.next=null;
			del.pre=null;
			
			
			
		}
		
		
		else{
			         
			del=getNodeByIndex(index);//找到当前节点
			
			del.pre.next=del.next;
			//--->null--->
			del.next.pre=del.pre;
			//<---null<--- 
			
			
			 //中间删除处的索引断开两边	 
			 del.pre=null;		 
			 del.next=null;
			
			
		}
		 size--;
		 return del.data;
	}
	//删除末端元素
	
	public T remove(){
		
		return delete(size-1);
		
	}
	
	//获得指定索引处的节点
	
	public Node getNodeByIndex(int index){
		
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("索引异常 ");
			
		}
		Node current=null;
		if(index<=size/2){//
			 current=head;
			for(int i=0;i<index;i++){
				current=current.next;
			}
			
		}
		else{
			 current=tail;
			for(int i=size-1;i>index;i--){
				
				current=current.pre;
			}
			
			
		}
		return current;
		

	}
	//获得指定索引处的元素
	
	public T get(int index){
		return getNodeByIndex(index).data;
	}
	
	//toString
	
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DoubleList<Object> dl=new DoubleList<Object>("aa");
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
