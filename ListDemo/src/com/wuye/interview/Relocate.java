package com.wuye.interview;


public class Relocate {

	/*
	 * 
	 *  �������з� ����һ���ұ�һ�� ʼ���ұ߱������һ��
	 *  
	 *  left.next=right;
	 *  
	 *  ���� �ҵ������м�Ľڵ� 
	 * 
	 * 
	 * 
	 * 
	 * */
	
public static class Node{
		
		public int data;
		
		public Node next;
		
		Node(int data){
			
			this.data=data;
		}
		
	}
	
	public static  void printLis(Node head){
		System.out.println("���������������:");
		while(head!=null){
			
			System.out.print(head.data+"--");
			head=head.next;
		}
	}
	
	public static void relocate(Node head){
		if(head==null||head.next==null){
			
			return ;		
		}
		
		Node mid=head;
		Node right=head.next;
		while(right.next!=null&&right.next.next!=null){
			
			mid=mid.next;
			right=right.next.next;
			
		}
		
		right=mid.next;
		mid.next=null;
		merge(head,right);
		//�ҳ����������ͷ��
		
		
	}
	public static void merge(Node left,Node right){
		//������������й鲢
		Node next=null;
		
		while(left.next!=null){//����
			next=right.next;
			right.next=left.next;
			left.next=right;
			left=right.next;
			right=next;
			
		}
		left.next=right;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head=new Node(0);
		head.next=new Node(2);
		head.next.next=new Node(4); 
		head.next.next.next=new Node(5);
		head.next.next.next.next=new Node(10);
	//	head.next.next.next.next.next=new Node(34);
		// 0 5 2 10 4 34
		Relocate.printLis(head);
		
		Relocate.relocate(head);
		System.out.println("�������ϲ�֮����������:");
		Relocate.printLis(head);
	}

}
