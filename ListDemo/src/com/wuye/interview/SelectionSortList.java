package com.wuye.interview;





public class SelectionSortList {
/*
 *  1 对于一个链表进行选择排序
 *    选择排序就是从未排序的里面找出最小的元素放在排好序的末端
 *    要求 时间复杂度 O(n2) 空间复杂度O(1)  
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
	
public static  class Node{
		
		public int data;
		
		public Node next;
		
		public Node(int data ){
			this.data=data;
		}
	
	}
	
	 public static void printlnlist(Node node){
		 System.out.println("你的链表数据如下:");
		 while(node!=null){
			 System.out.print(node.data+"--");
			 node=node.next;
		 }
		 System.out.println();
	 }
	
	 
	  //进行排序
	 public static Node select(Node head){
		 Node tail=null;//排序的队尾
		 Node cur=head;//未排序的队头
		 Node small=null;
		 Node smallPre=null;
		 while(cur!=null){
			 small=cur;
			 smallPre=getSmallPreNode(cur);
			 //进行删除最小节点
			 if(smallPre!=null){
				 small=smallPre.next;
				 smallPre.next=small.next;
				 
			 }
			 
			 cur=cur==small?cur.next:cur;
			 //如果最小节点是头部的情况  smallPre=null  
			 //cur只能=cur.next
			 //反之头部已经被删除了 cur就是未排序的头部
			 //
			 
			 
			 //将小的进行连接
			 if(tail==null){
				 head=small;
			 
			 }else{
				 tail.next=small;
				 
			 }
			 tail=small;
			 
		 }
		return head;
		 
	 }
	 
	 
	 //进行选择排序 返回最小元素的前一个节点
	 public static Node getSmallPreNode(Node head){
		 
		 //定义四个变量
		 
		 //前后跟进的两个
		 Node pre=head;
		 Node next=head.next;
		 //指向最小 和最小的前一个节点
		 Node small=head;//一开始最小的就是 第一个节点
		 Node preSmall=null;
		 
		 while(next!=null){
			 
			 if(next.data<small.data){
				 preSmall=pre;
				 small=next;
				 
			 }
			 
			 pre=next;
			 next=next.next;
			 
		 }
		return preSmall;
	
	 }
	 
	 
	 
	
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head2=new Node(7);
		head2.next=new Node(2);
		head2.next.next=new Node(8);
		head2.next.next.next=new Node(4);
		head2.next.next.next.next=new Node(6);
		head2.next.next.next.next.next=new Node(20);
		SelectionSortList.printlnlist(head2);
		
		SelectionSortList.printlnlist(SelectionSortList.select(head2));
	}

}
