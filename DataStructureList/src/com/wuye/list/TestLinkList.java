package com.wuye.list;

public class TestLinkList<T> {

	private class Node{
		
		public T data;
		
		public Node next;
		
		Node(T data,Node next){
			this.data=data;
			
			this.next=next;
			
		}

	}
	
	private Node head;
	
	private Node tail;
	
	private int size;
	
	public int length(){
		
		return this.size;
	
	}
	
	
	public void clear(){
		
		head=null;
		
		tail=null;
		
		size=0;
	}
	
	
	public  boolean empty(){
		
		return size==0;
		
	}
	
	
	//���� ����β������  ͷ������
	
	public void add(T data){
		//����β���ڵ�
		
		Node current=new Node(data,null);
		
		if(empty()){
			head=current;
			tail=current;
		}else{
		
		tail.next=current;
		tail=current;
		}
		size++;
	}
	
	//ͷ������
	
	public void addHead(T data){
		
		Node current=new Node(data,head);
		
		if(empty()){
			tail=current;
			
		}else{
			head=current;
			
		}
		size++;
	}
	
	//�ҵ�ָ���������Ľڵ�
	
	public Node getNodeByIndex(int index){
		
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("�����쳣");
			
		}
		Node current=head;
		for(int i=0;i<size&&current!=null;i++,current=current.next){
			if(i==index){
				
				return current;
			}
			
		}
		return null;
		
	}
	//����Ԫ��
	
	public void insert(T data,int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("��������  �����쳣");
		}
		 if(empty()){
			 add(data);
		 }
			 else{
				 
				 if(index==0){
					 addHead(data);
					 
				 }else{
					 Node pre=getNodeByIndex(index-1);
					 
					 pre.next=new Node(data,pre.next);
					 
				
					 
					 size++;
				 }
				 
				 
				 
			 }
			 
		 }
		
	//�ҵ�ָ��Ԫ�ص����� �����ظ��� ֻ���ҵ���һ�γ��ֵ�
	public int findData(T data){
		
		Node current=head;
		
		for(int i=0;i<size&&current!=null;current=current.next,i++){
			if(current.data.equals(data)){
				return i;
			}
			
		}
		return -1;
		
		
	}
	
	
		
	//ɾ������Ԫ��
	
	public T remove(){
		
		return delete(size-1);
	}
	
	
	
	
	//�ҵ�ָ��������������
	
	public T get(int index){
		return getNodeByIndex(index).data;
		
	}
	
	public String toString(){
		
		if(empty()){
			return "[]";
		}else{
			
			StringBuffer sb=new StringBuffer("[");
			for(Node current=head;current!=null;current=current.next){
				
				sb.append(current.data.toString()+",");
				
			}
			
			return sb.delete(sb.length()-1,sb.length()).append("]").toString();
			
		}
		
	}
	
	
	//ɾ��ָ����������Ԫ��
	
	public T delete(int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("�����쳣 ");
			
		}
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
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		TestLinkList<Object> ll=new TestLinkList<Object>();
		
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
	ll.insert("ͷ��", 0);
	System.out.println(ll);
	
	ll.insert("�м�", 4);
	System.out.println(ll);
	ll.insert("���²�λ", 6);
	System.out.println(ll);
	ll.insert("β��", 8);
	System.out.println(ll);
	ll.insert("β��", 11);
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
	
	System.out.println(ll.delete(7));
	System.out.println(ll);
	System.out.println(ll.length());
		ll.addHead("dd");
		System.out.println(ll);
		System.out.println(ll.findData("aa"));
		System.out.println(ll.findData("dd"));
	}

}
