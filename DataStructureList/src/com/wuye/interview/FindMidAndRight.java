package com.wuye.interview;

import com.wuye.interview.IsPalindrome.Node;



public class FindMidAndRight {

	/*
	 *  �ҵ��м�ڵ��ǰһ��Ԫ�غͺ�һ��Ԫ��
	 * 
	 * 
	 * 
	 * 
	 * */
public static class Node{
		
		public int data;
		
		public Node next;
		
		public Node(int data){
			this.data=data;
		}
	}

	public static void printList(Node node){
		System.out.println("�������������:");
		
		while(node!=null){
			System.out.print(node.data+"--");
			node=node.next;
		}
		
	} 
	
	public static void FindMid(Node head){
		
		//�ҵ��м�λ�õ�ǰһ��λ��  ʹ�� 1  3 
		//�������������� ����1���м�ǰһ��
		Node pre=head;
		
		Node cur=head.next.next;
		while(cur.next!=null&&cur.next.next!=null){
			pre=pre.next;
			
			cur=cur.next.next;
			
		}
		System.out.println("�м�ǰһ��λ��Ԫ��"+pre.data);
		System.out.println("�м�λ��Ԫ��"+pre.next.data);
		
		
	}
	
public static void FindRight(Node head){
		
		//�ҵ��м�λ�õ�ǰһ��λ��  ʹ�� 1  3 
		//�������������� ����1���м�ǰһ��
		Node right=head.next;
		
		Node cur=head;
		while(cur.next!=null&&cur.next.next!=null){
			right=right.next;
			
			cur=cur.next.next;
			
		}
		System.out.println("�м�ǰһ��λ��Ԫ��"+right.data);
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMidAndRight ff=new FindMidAndRight();
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3); 
		head.next.next.next=new Node(4);
		head.next.next.next.next=new Node(6);
	//	head.next.next.next.next.next=new Node(7);
		ff.printList(head);
		System.out.println();
		ff.FindMid(head);
		ff.FindRight(head);
	}

}
