package com.wuye.interview;






/*    
 *    *对双向链表进行反转 
 *    
 *    要求时间复杂度O(n) 空间复杂度O(1)
 *      
 * 
 * 
 * 
 * */
public class ReverseList2 {
	
	
	public static class Node{
		
		public int data;
		
		public Node next;
		
		public Node pre;
		public Node(int data){
			this.data=data;
		}
	}

	public static void printlnlist(Node node){
		System.out.println("链表的数据如下:");
		
		while(node!=null){
			System.out.print(node.data+"--");
			node=node.next;
		}
		
	} 
	
	
	
	public static Node reverseList2(Node head){

		Node pre=null;
		
		Node next=null;
		while(head!=null){
			next=head.next;
			
			head.next=pre;
			
			head.pre=next;
			
			pre=head;
			
			head=next;
			
		}
		return pre;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseList2 rr=new ReverseList2();

		//null<-1=2=3=4=4->null
		Node head=new Node(1);
		head.pre=null;
		head.next=new Node(2);
		
		head.next.pre=new Node(1);
		head.next.next=new Node(3);
		
		head.next.next.pre=new Node(3);
		head.next.next.next=new Node(4);
		
		head.next.next.next.pre=new Node(3);
		head.next.next.next.next=new Node(4);
		
		head.next.next.next.next.next=null;
		
		rr.printlnlist(head);	
		
		rr.printlnlist(rr.reverseList2(head));
	
	}

}
