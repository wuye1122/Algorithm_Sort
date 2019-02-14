package com.wuye.interview;

import com.wuye.interview.ReverseList.Node;

public class RrversePart {
/*
 *   *对一个给定的链表进行部分颠倒
 *   需要找到from 前面一个  和to后面一个节点
 *   
 *   1 2  3 4 5 6   7 8
 *     
 *     f             t 
 * 
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

	public static void println(Node node){
		System.out.println("链表的数据如下:");
		
		while(node!=null){
			System.out.print(node.data+"--");
			node=node.next;
		}
		
	} 
	
	public static Node reversePart(Node head,int from,int to){
	
	int len=0;
	Node node1=head;
	
	Node fpre=null;
	
	Node tpos=null;
	
	//该循环固定好from-1  to+1的位置
	while(node1!=null){
		len++;
		fpre=len==from-1?node1:fpre;
		tpos=len==to+1?node1:tpos;
		node1=node1.next;
	}
	
	if(from<1||from>to||to>len){
       return head; 
		
	}
	
	
	
	//如果fpre=null head
	
	node1=fpre==null?head:fpre.next;
	
	Node node2=node1.next;
	
	node1.next=tpos;
	
	Node next=null;
	while(node2!=tpos){
		next=node2.next;
		
		node2.next=node1;
		
		node1=node2;
		
		node2=next;
		
	}
	if(fpre!=null){
		fpre.next=node1;
		return head;
		
	}
	
	return node1;
	
	
	
	}
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RrversePart rr=new RrversePart();
		
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
		head.next.next.next.next=new Node(4);
		rr.println(head);
		
		rr.println(rr.reversePart(head, 1, 5));
	}

}
