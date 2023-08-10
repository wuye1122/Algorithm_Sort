package com.wuye.queue;

public class TestDoubleQueue<T> {

	 
	
	
	
	private class Node{
		
		public Node next;
		
		public Node previous;
		
		T data;
		
		Node(T data){
			this.data =data;
		}
		
		void display(){
			
			System.out.print(this.data+"--");
			
		}
	}
	
	private Node head;
	
	private Node tail;
	
	//�Ƿ�Ϊ��
	
	public boolean empty(){
		
		return head==null;
		
	}
	
	
	//����ͷ��������
	public void insertHead(T data){
		Node newNode=new Node(data);
		if(empty()){
			tail=newNode;
		}else{
			head.previous=newNode;
		}
		newNode.next=head;
		
		head=newNode;
	}
	
	
    public void insertTail(T data){
		Node newNode=new Node(data);
		
		if(empty()){
			head=newNode;
			
		}else{
			
			tail.next=newNode;
			
		}
		newNode.previous=tail;
		
		tail=newNode;
		
	}
	//��������
	public void displayHead(){
		System.out.println("from  head--->tail");
		for(Node current=head;current!=null;current=current.next){
			current.display();
		}
		System.out.println();
	}
	
	
	public void displayTail(){
		System.out.println("frm  tail--->head");
		for(Node current=tail;current!=null;current=current.previous){
			current.display();
			
			
		}
		System.out.println();
		
	}
	//����ͷɾ������
	public T removeHead(){
		if(empty()){
			throw new IndexOutOfBoundsException("����Ϊ��  ɾ��ʧ��");
			
		}
		Node old=head;
		
		head=head.next;
		
		old.next=null;
		
		head.previous=null;
		
		return old.data;
	}
	
	
	public T removeTail(){
		
		
		if(empty()){
			throw new IndexOutOfBoundsException("����Ϊ�� ɾ��ʧ��");
			
		}
		Node old=tail;
		
		tail=tail.previous;
		
		tail.next=null;
		
		old.previous=null;
		
		return old.data;
	}
	
	
	
	//��ȡ��ͷ����
	
	public T peekHead(){
		
		if(head!=null){
			return head.data;
		}
		return null;
	}
	
	
	public  T peekTail(){
		
		if(tail!=null){
			return tail.data;
			
		}
		return null;
		
		
	}
	
	//���ݳ���
	public int size(){
		
		int count=0;
		for(Node current=head;current!=null;current=current.next){			
			count++;			
		}
		return count;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestDoubleQueue<Object> dq=new  TestDoubleQueue<Object>();
		
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
	      
	      
	      System.out.println("ɾ����ͷԪ��-------"+dq.removeHead());
	      dq.displayTail();
	      dq.displayHead();
	      System.out.println(dq.size());
		
	      System.out.println("ɾ����β��Ԫ-------"+dq.removeTail());
	      dq.displayTail();
	      dq.displayHead();
	      System.out.println(dq.size());
		
		
		
	}

}
