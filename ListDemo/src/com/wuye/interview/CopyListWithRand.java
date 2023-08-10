package com.wuye.interview;

import java.util.HashMap;



public class CopyListWithRand {

	/*
	 * 
	 *  �ڵ�Ľṹ�����ı�:����һ��rand
	 * 
	 *  ��һ�ָ�������ķ���:ʹ��map
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
		System.out.println("���������������:");
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
		System.out.println("head1������ڵ�"+head1.rand);
		System.out.println("head2������ڵ�"+head2.rand.data);
		System.out.println("head3������ڵ�"+head3.rand.data);
		System.out.println("head4������ڵ�"+head4.rand.data);
		CopyListWithRand.printLis(CopyListWithRand.copy(head1));
		System.out.println();
		System.out.println("head1������ڵ�"+head1.rand);
		System.out.println("head2������ڵ�"+head2.rand.data);
		System.out.println("head3������ڵ�"+head3.rand.data);
		System.out.println("head4������ڵ�"+head4.rand.data);
		
	}

}
