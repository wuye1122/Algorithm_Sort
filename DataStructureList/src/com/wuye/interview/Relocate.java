package com.wuye.interview;


public class Relocate {

	/*
	 * 
	 *  将链表中分 左面一个右边一个 始终右边比左面多一个
	 *  
	 *  left.next=right;
	 *  
	 *  首先 找到链表中间的节点 
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
		System.out.println("你的链表数据如下:");
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
		//找出左右链表的头部
		
		
	}
	public static void merge(Node left,Node right){
		//将两个链表进行归并
		Node next=null;
		
		while(left.next!=null){//遍历
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
		System.out.println("你好你进合并之后的情况如下:");
		Relocate.printLis(head);
	}

}
