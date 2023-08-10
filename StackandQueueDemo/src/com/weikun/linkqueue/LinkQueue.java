package com.weikun.linkqueue;
/*
 * weikun
 * ��ʽ����
 * 2011-12-17
 * 
 */
public class LinkQueue<T> {
	//����һ���ڲ���Node��Nodeʵ�����������еĽڵ㡣
	private class Node{
		//����ڵ������
		private T data;
		//ָ���¸��ڵ������
		private Node next;
		//�޲����Ĺ�����
		public Node(){
		}
		//��ʼ��ȫ�����ԵĹ�����
		public Node(T data ,  Node next){
			this.data = data;
			this.next = next;
		}
	}
	//����������е�ͷ�ڵ�
	private Node front; 
	//����������е�β�ڵ�
	private Node rear;
	//��������������Ѱ����Ľڵ���
	private int size;
	//������������
	public LinkQueue(){
		//�������У�front��rear����null
		front = null;
		rear = null;
	}
	//��ָ������Ԫ�������������У���������ֻ��һ��Ԫ��
	public LinkQueue(T element){
		front = new Node(element , null);
		//ֻ��һ���ڵ㣬front��rear��ָ��ýڵ�
		rear = front;
		size++;
	}
	//���������еĳ���	
	public int length(){
		return size;
	}
	//����Ԫ�ؼ������
	public void add(T element){
		//����������л��ǿ�������
		if (front == null){
			front = new Node(element , null);
			//ֻ��һ���ڵ㣬front��rear��ָ��ýڵ�
			rear = front;
		}
		else{
			//�����½ڵ�
			Node newNode = new Node(element , null);
			//��β�ڵ��nextָ�������Ľڵ�
			rear.next = newNode;
			//���½ڵ���Ϊ�µ�β�ڵ�
			rear = newNode;
		}
		size++;
	}
	//ɾ������front�˵�Ԫ��
	public T remove(){
		Node oldFront = front;
		front = front.next;
		oldFront.next = null;
		size--;
		return oldFront.data;
	}
	//������ʽ���������һ��Ԫ��
	public T element(){
		return front.data;
	}
	//�ж���ʽ�����Ƿ�Ϊ�ն���
	public boolean empty(){
		return size == 0;
	}
	//���������
	public void clear(){
		//��front��rear�����ڵ㸳Ϊnull
		front = null;
		rear = null;
		size = 0;
	}
	public String toString(){
		//������Ϊ��������ʱ
		if (empty()){
			return "[]";
		}
		else{
			StringBuilder sb = new StringBuilder("[");
			for (Node current = front ; current != null
				; current = current.next ){
				sb.append(current.data.toString() + ", ");
			}
			int len = sb.length();
			return sb.delete(len - 2 , len).append("]").toString();
		}
	}
}
