package com.wuye.list;

public class LinkList<T> {
	
	
    /* 数组和链表的区别***
     * 
     * 数组:定义时候长度固定 内存也是连续的 有下标 
     *     不可以任意删除某个元素 
     * 
     * 链表:长度不固定 可以根据需求申请内存 没有下标
     *     可以根据需求删除元素
     * 
     *   c:链表中相邻节点通过指针相互联系的 知道头部节点便可知道其余节点
     *     
     * java:里面没有指针 节点里保存相邻节点的对象 又称之引用    
     *     
     * 
     * 单向链表是一种数据结构  一种线性表,但是其存储的数据分散在内存中
     * 
     * 
     * 
     * 7+3增加  删除  查找 ---大小 清空  判断 +toString
     * 
     * 
     * 
     * 
     * */
	
	
	
	private class Node{
		
		
		public T data;
		
		public Node next;
		
		public Node(T data,Node next){
			this.data=data;
			
			this.next=next;
			
			
		}
	

		
	}
	
	
	private int size=0;
	
	private Node head;
	
	private Node tail;
	
	
	//3个普通
	
	public int length(){
		return this.size;
	}
	
	
	public void clear(){
		head=null;
		tail=null;
		size=0;
	}
	
	public boolean empty(){
		
		
		return size==0;
	}
	
	
	//add正常从尾部增加
	
	public void add(T data){
		
		Node newNode=new Node(data,null);
		
		if(empty()){
			head=newNode;
			tail=newNode;
		}
		tail.next=newNode;
		tail=newNode;
		size++;
		
	}
	
	
	//addHead头部开始增加
	
	public void addHead(T data){
		
		head=new Node(data,head);
		
		if(empty()){
			tail=head;
		}
		
		
		size++;
	}
	
	//插入
	
	public void insert(T data,int index){
		
		if(index<0||index>size-1){
			
			throw new IndexOutOfBoundsException("索引错误");
			
		}
		
		//如果原来没有数据
		if(empty()){
			add(data);
			
		}else{
			if(index==0){
				addHead(data);
				}
			else{
			Node current=getNodeByIndex(index-1);
			
			current.next=new Node(data,current.next);
			
			
			size++;
				
			}

		}
	
	}
	
	
	//删除指定位置
	
	public T delete(int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("索引异常 出现错误");
			
		}else{
			Node current=null;
			if(index==0){
				current=head;
				head=head.next;
			}else{
				Node pre=getNodeByIndex(index-1);
				
				current=pre.next;
				
				pre.next=current.next;
				
				current.next=null;
				
			}
			size--;
			return current.data;
			
		}
		
	}
	
	
	//删除线性表里面最后一个元素
	
	public T remove(){
		
		return delete(size-1);
		
	}
	
	
	//找到指定位置的节点
	public Node getNodeByIndex(int index){
		
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("索引异常");
		}
		Node current=head;
		for(int i=0;i<size&&current!=null;i++,current=current.next){
			if(index==i){
				return current;	
			}
		}
		//如果找不到
		return null;	
	}
	
	//进行删除数据
	
	
	
	//得到指定位置的元素
	public T get(int index){
		return getNodeByIndex(index).data;
	}
	
	public String toString(){
		
		if(empty()){
			return "[ ]";
		}else{
			
			StringBuffer sb=new StringBuffer("[");
			
			for(Node current=head;current!=null;current=current.next){
				
				sb.append(current.data.toString()+",");
				
			}
			return sb.delete(sb.length()-1, sb.length()).append("]").toString();
		}
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkList<Object> ll=new LinkList<Object>();
		
		ll.add("111");
		ll.add("222");
		ll.add("333");
		ll.add("444");
		System.out.println(ll.length());
		System.out.println(ll);
		ll.addHead("aa");
		ll.addHead("bb");
		System.out.println(ll.length());
		System.out.println(ll);
		System.out.println("---empty"+ll.empty());
		
		
		
	//	ll.clear();
//		System.out.println("---empty"+ll.empty());
//		System.out.println(ll.length());
//		System.out.println(ll);
	
	ll.add("cc");
	ll.addHead("dd");
	System.out.println(ll);
	System.out.println(ll.length());
	
	System.out.println("---------getNode--------");	
		
//	System.out.println(ll.getNodeByIndex(-1).data);
	System.out.println("index=0--"+ll.getNodeByIndex(0).data);
	System.out.println("index=3--"+ll.getNodeByIndex(3).data);
	System.out.println("index=4--"+ll.getNodeByIndex(4).data);
	System.out.println("index=7--"+ll.getNodeByIndex(7).data);
	//System.out.println("index=8--"+ll.getNodeByIndex(8).data);
	System.out.println("---------get--------");	
	System.out.println("index=0--"+ll.get(0));
	System.out.println("index=3--"+ll.get(3));
	System.out.println("index=4--"+ll.get(4));
	System.out.println("index=7--"+ll.get(7));
	System.out.println(ll);
	ll.insert("头部", 0);
	System.out.println(ll);
	
	ll.insert("中间", 4);
	System.out.println(ll);
	ll.insert("中下部位", 6);
	System.out.println(ll);
	ll.insert("尾部", 8);
	System.out.println(ll);
	ll.insert("尾部", 11);
	System.out.println(ll.length());
	
	
	System.out.println(ll.remove());
	System.out.println(ll);
	System.out.println(ll.length());
	
	System.out.println(ll.remove());
	System.out.println(ll);
	System.out.println(ll.length());
	
	System.out.println(ll.remove());
	System.out.println(ll);
	System.out.println(ll.length());
	
	System.out.println(ll.remove());
	System.out.println(ll);
	System.out.println(ll.length());
	
	System.out.println(ll.delete(0));
	System.out.println(ll);
	System.out.println(ll.length());
	
	System.out.println(ll.delete(5));
	System.out.println(ll);
	System.out.println(ll.length());
	
	}

}
