package com.wuye.interview;





public class InsertLoop {

	/*
	 * 
	 *   向环形的单链表里面插入数据
	 * 
	 * 
	 * 
	 * 
	 * 
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

public static Node insertNum(Node head,int num){
	Node node=new Node(num);
	
	if(head==null){
		node.next=node;
		return node;
		
	}
	
	Node pre=head;//两个依次往后推进
	Node cur=head.next;
	while(cur!=head){
		if(pre.data<=node.data&&cur.data>=node.data){
			break;
		}		
		pre=cur;
		cur=cur.next;	
	}
	pre.next=node;
	node.next=cur;
//返回头部
	
	return head.data>node.data?node:head;
}


	
public static  void printLis(Node head){
	System.out.print("你的链表数据如下:"+head.data+"--");
	Node tail=head;
	head=head.next;
	
	while(head!=tail){
		
		System.out.print(head.data+"--");
		head=head.next;
	}
}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(4); 
		head.next.next.next=new Node(5);
		head.next.next.next.next=head;
		System.out.println(head);
		System.out.println(head.next.next.next.next.equals(head));
		InsertLoop.printLis(head);
		InsertLoop.insertNum(head, 0);//循环的这样对
		
		InsertLoop.printLis(head);
	}

}
