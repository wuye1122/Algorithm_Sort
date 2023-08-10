package com.wuye.interview;

import java.util.Date;



public class NodeQuestion {

	
public static class Node{
		
		public int data;
		
		public Node next;
		
		public Node(int data){
			this.data=data;
		}
	}

public static void getNode(Node head){
	head=head.next.next.next;
	/*
	 *  引用类型
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
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
	
}

public static int getNode1(Node head){
	
	
	return head.next.next.next.data;
	
}
public static void printlnlist(Node node){
	 System.out.println("你的链表数据如下:");
	 while(node!=null){
		 System.out.print(node.data+"--");
		 node=node.next;
	 }
	 System.out.println();
}

public static void a(int i){
	System.out.println(i);
	i=i+5;
	System.out.println(i);
}

public static void b(String a){
	System.out.println(a);
	a+="bbb";
	
  System.out.println(a);
}
public void modify(Date d){
	
	System.out.println(d);
	
	d.setYear(1000);//1900+
	System.out.println(d);
}

public void modify(String a){
	System.out.println(a);
	a="456";
	System.out.println(a);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeQuestion nn=new NodeQuestion();
		
		
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
		
		System.out.println("链表如下:");
		printlnlist(head);
		System.out.println("含return:"+nn.getNode1(head));
		getNode(head);
		System.out.println(""+head.data);
		System.out.println("--------------------");
		
		int i=10;
		a(i);
		System.out.println(i);
		System.out.println("--------------------");
		String c="2sad";
		b(c);
		System.out.println(c);
		System.out.println("-----");
		String b="abc";
		nn.modify(b);
		System.out.println(b);
		
		
		System.out.println("-----");
		Date d=new Date();
		nn.modify(d);
		System.out.println(d);
		
	}

}
