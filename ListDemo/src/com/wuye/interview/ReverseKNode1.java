package com.wuye.interview;

import java.util.Stack;




public class ReverseKNode1 {
/*
 *  1 使用栈 进行K个节点一 反转
 *  
 *   先将K个节点压入栈里面。其次是在出栈  和其他连接起来
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
	
	public static Node reverserKNode(Node head,int num){
		if(num<2){
			return head;//如果是一位数字 或者没有则不需要反转
		}
		Stack<Node> ss=new Stack<Node>();
		Node newHead=head;//指向新的头部节点
		
		Node cur=head;//遍历
		
		Node pre=null;//反转前面
		
		Node next=null;//反转后面
		
		while(cur!=null){
			next=cur.next;
			ss.push(cur);
			if(ss.size()==num){
				
				//进行反转
				pre=rever(ss,pre,next);
				//返回之后此时头部节点
				newHead=newHead==head?cur:newHead;
				
			}
			cur=next;
			
		}
		return newHead;
		
		
		
		
		
	}
private static Node rever(Stack<Node> ss, Node left, Node right) {
		// TODO Auto-generated method stub
	
	Node cur=ss.pop();
	
	if(left!=null){
		left.next=cur;//指向栈里面弹出来的节点
		
	}
	//num个节点全部弹出
	Node next=null;
	while(!ss.isEmpty()){
		next=ss.pop();
		cur.next=next;
		cur=next;
	}
	  cur.next=right;//将部分反转过来的 和原来的联系在一起
	
		return cur;
		
		
		
		
	}
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node head2=new Node(1);
		head2.next=new Node(3);
		head2.next.next=new Node(5);
		head2.next.next.next=new Node(4);
		head2.next.next.next.next=new Node(5);
		head2.next.next.next.next.next=new Node(6);
		head2.next.next.next.next.next.next=new Node(7);
		head2.next.next.next.next.next.next.next=new Node(9);
		
		ReverseKNode1.printLis(head2);
		ReverseKNode1.printLis(ReverseKNode1.reverserKNode(head2, 4));
		
	}

}
