package com.wuye.interview;

import java.util.Stack;



public class Add2List2 {
    
	/*
	 *  1  将两个链表加起来
	 *    使用stack结构,将链表里面数据全部加入里面 ,然后再全部倒出来
	 *     
	 *    n=n1+n2+ca;
	 *    pre和 node将新的结果变成链表
	 *     node-->pre
	 *      ^
	 *      | 
	 *      |  
	 *     pre
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
	
	
	
	 public  static Node add2List2(Node head1,Node head2){
		  Stack<Integer> s1=new Stack<Integer>();
		  Stack<Integer> s2=new Stack<Integer>();
		  
		  //不断的压入栈
		  while(head1!=null){//加入栈里面是数据
			  s1.push(head1.data);
			  head1=head1.next;
		  }
		  while(head2!=null){//栈压错了  粘贴复制
			  s2.push(head2.data);
			  head2=head2.next;
		  }
		  
		  int n=0;
		  int n1=0;
		  int n2=0;
		  int ca=0;
		  Node pre=null;
		  Node node=null;
		//不断的从栈里面出来
		while(!s1.isEmpty()||!s2.isEmpty()){
			//有一个不等于null 就一直出栈
			n1=s1.isEmpty()?0:s1.pop();
			n2=s2.isEmpty()?0:s2.pop();
			
			n=n1+n2+ca;
			pre=node;
			node=new Node(n % 10);
			node.next=pre;
			ca=n/10;
			
		}
		if(ca==1){
			pre=node;//pre指向原来的末端
			node=new Node(1);
	        node.next=pre;	
		}
		return node;
		
		  
	  }	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node head=new Node(0);
		head.next=new Node(2);
		head.next.next=new Node(4); 

		Add2List2.printLis(head);
		System.out.println();
		
		Node head2=new Node(1);
		head2.next=new Node(3);
		head2.next.next=new Node(5);
		head2.next.next.next=new Node(7);

		System.out.println();
		Add2List2.printLis(head2);
		System.out.println();
		
		Add2List2.printLis(Add2List2.add2List2(head, head));
		
		
	}

}
