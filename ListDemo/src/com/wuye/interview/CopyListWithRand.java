package com.wuye.interview;

import java.util.HashMap;



public class CopyListWithRand {

	/*
	 * 
	 *  节点的结构发生改变:多了一个rand
	 * 
	 *  第一种复制链表的方法:使用map
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
	
	public static Node copy(Node head){
		
		HashMap<Node,Node> map=new 	HashMap<Node,Node> ();
		Node cur=head;
		
		while(cur!=null){
			map.put(cur, new Node(cur.data,cur.rand));
			cur=cur.next;
			
		}
		cur=head;
		while(cur!=null){
			map.get(cur).next=map.get(cur.next);
			
			map.get(cur).rand=map.get(cur.rand);
			cur=cur.next;
		}
		return map.get(head);
		
	}
	
public static class Node{
		
		public int data;
		
		public Node rand;
		
		public Node next;
		
		Node(int data,Node n){
			this.rand=n;
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

		Node head1=new Node(1,null);
		
		Node head4=new Node(4,head1);
		Node head3=new Node(3,head4);
		Node head2=new Node(2,head3);
		head1.next=head2;
		head2.next=head3;
		head3.next=head4;
		head4.next=null;
		CopyListWithRand.printLis(head1);
		System.out.println();
		System.out.println("head1的随机节点"+head1.rand);
		System.out.println("head2的随机节点"+head2.rand.data);
		System.out.println("head3的随机节点"+head3.rand.data);
		System.out.println("head4的随机节点"+head4.rand.data);
		CopyListWithRand.printLis(CopyListWithRand.copy(head1));
		System.out.println();
		System.out.println("head1的随机节点"+head1.rand);
		System.out.println("head2的随机节点"+head2.rand.data);
		System.out.println("head3的随机节点"+head3.rand.data);
		System.out.println("head4的随机节点"+head4.rand.data);
		
	}

}
