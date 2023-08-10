package com.wuye.interview;




public class ReverseList {
/*    
 *    *对单链表进行反转 
 *    
 *    要求时间复杂度O(n) 空间复杂度O(1)
 *    第二次对链表进行反转会出现问题    
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
	
	
	public static Node reverseList(Node node){
		
		//定义一个往后走的变量
		Node next=null;
		//定义一个往前走的反转后的头部
		Node pre=null;
		
		while(node!=null){

			next=node.next;//往后移动一部
			
			node.next=pre;//指向反转的头
			
			pre=node;
			
			node=next;

		/* 1 2 3 4 
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
		return pre;	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseList rr=new ReverseList();
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
		head.next.next.next.next=new Node(4);
		rr.println(head);
		rr.println(rr.reverseList(head));
		System.out.println(head.data);
		System.out.println(head.data);
		//System.out.println(head.next.data);
		//出现异常因为反转之后的head-->null
		//再次反转链表结构发生变化了
		rr.println(rr.reverseList(head));
		
	}

}
