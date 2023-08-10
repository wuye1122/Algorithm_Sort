package com.wuye.interview;

import com.wuye.interview.IsPalindrome.Node;



public class FindMidAndRight {

	/*
	 *  找到中间节点的前一个元素和后一个元素
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
		System.out.println("链表的数据如下:");
		
		while(node!=null){
			System.out.print(node.data+"--");
			node=node.next;
		}
		
	} 
	
	public static void FindMid(Node head){
		
		//找到中间位置的前一个位置  使用 1  3 
		//如果是奇数的情况 正好1在中间前一个
		Node pre=head;
		
		Node cur=head.next.next;
		while(cur.next!=null&&cur.next.next!=null){
			pre=pre.next;
			
			cur=cur.next.next;
			
		}
		System.out.println("中间前一个位置元素"+pre.data);
		System.out.println("中间位置元素"+pre.next.data);
		
		
	}
	
public static void FindRight(Node head){
		
		//找到中间位置的前一个位置  使用 1  3 
		//如果是奇数的情况 正好1在中间前一个
		Node right=head.next;
		
		Node cur=head;
		while(cur.next!=null&&cur.next.next!=null){
			right=right.next;
			
			cur=cur.next.next;
			
		}
		System.out.println("中间前一个位置元素"+right.data);
		
		
		
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
