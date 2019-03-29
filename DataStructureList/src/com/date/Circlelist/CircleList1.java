package com.date.Circlelist;

import java.util.Iterator;



public class CircleList1<T> {

	
	private class Node{

		private T date;

		private Node next;

		//�޲����Ĺ�����
		@SuppressWarnings("unused")
		public Node(){
		}
		//��ʼ��ȫ�����ԵĹ�����
		public Node(T date,Node next){
			this.date=date;
			this.next=next;
		}

	}
	
	private Node header;
	private Node tail;
	private int size;
	
	//����������
	public CircleList1(){
		this.header=null;
		this.tail=null;
	    size=0;	
	}
	//��ָ��һ��Ԫ�ش���������
	public CircleList1(T element){
		header =new Node(element,null);
		tail=header;
		size++;
		
		
	}
	//��������ĳ���
	public int length(){
		return size;
	}
	//��������index��ȡָ��λ�õĽڵ�
	private Node getNodeByIndex(int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("Խ����");
		}
		Node current=header;
		for(int i=0;i<size&&current!=null;i++,current=current.next){
			if(i==index){
				return current;
			}
		}
		return null;
	}
	
	
	//��ȡ��ʽ���Ա�������Ϊindex����Ԫ��
	public T get(int index){
		return  getNodeByIndex(index).date;
		
	}
	
	//������ʽ���Ա���ָ��Ԫ�ص�����
	public int FindElement(T element){
		Node current=header;
		for(int i=0;i<size&&current!=null;i++,current=current.next){
			if(current.date.equals(element)){
				return i;
			}			
		}		
		return -1;		
	}
	//����β�巨Ϊ��������½ڵ㡣
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
	
}	//����ͷ�巨Ϊ��������½ڵ�
	public void addHeader(T element){
		header=new Node(element,header);
		if(tail==null){
			tail=header;
		}
		size++;
	}

	//����ĳ��һ����Ԫ��
	
	public void insert(T element,int index){
		if(index<0||index>size){
			throw new IndexOutOfBoundsException("����Խ����");
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
	//ɾ����ʽ���Ա���ָ����������Ԫ��
	public T delete(int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("Խ���˰�");
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

	
	//ɾ����ʽ���Ա������һ��Ԫ��
	public T romove(){
		return delete(size-1);
	}
	//�ж���ʽ���Ա��Ƿ�Ϊ�ձ�
	public boolean empty(){
		return size==0;
	}
	//������Ա�
	public void clear(){
		header=null;
		tail=null;
		size=0;
		
	}
	//����
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
