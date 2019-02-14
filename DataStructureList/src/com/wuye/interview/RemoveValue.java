package com.wuye.interview;

import java.util.Stack;



public class RemoveValue {
/*
 * 
 *  1 删除链表指定值num的节点
 *    时间 空间复杂度都是O(n)
 *    使用stack 先将不等于num的值压入栈里面
 *    在依次出来连成一串
 * 
 * 
 *  2 使用变量跟进的形式  
 *    时间复杂度 O(n)  空间复杂度O(1) 
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

	public static  void printLis(Node head){
		System.out.println("你的链表数据如下:");
		while(head!=null){

			System.out.print(head.data+"--");
			head=head.next;
		}
	}

	public static Node removeValue(Node head,int num){

		Stack<Node> ss=new Stack<Node>();
		while(head!=null){

			if(head.data!=num){
				ss.push(head);
			}
			head=head.next;

		}
		//以上将链表里面全不等于num的值压入了 栈里面
		//此时 head=null
	
		 while(!ss.isEmpty()){
       //重写组装			 
			 ss.peek().next=head;
			 head=ss.pop();
		 }
		return head;
	}

	
	
	public static Node removeValue1(Node head,int num){
		//找到第一个不等于num的值 如果第一个等于 就会跳过
		
		while(head!=null){
			if(head.data!=num){
				break;
			}
			head=head.next;
		}
	
		  //使用两个变量跟进的形式
		
		Node pre=head;
		Node cur=head;
		while(cur!=null){
			if(cur.data==num){
				pre.next=cur.next;
			}else {
			  //如果cur b不等于 num则 pre跟进
				pre=cur;
			}
			cur=cur.next;//cur不断向前面走的
		}
		return head;
		 
	}
	public static void main(String []args){
		
		//RemoveValue rv=new RemoveValue();
		Node head2=new Node(1);
		head2.next=new Node(2);
		head2.next.next=new Node(4);
		head2.next.next.next=new Node(6);
		RemoveValue.printLis(head2);
		System.out.println();
		//RemoveValue.printLis(RemoveValue.removeValue(head2, 6));
		RemoveValue.printLis(RemoveValue.removeValue1(head2, 6));
	}
	
	
	
	
	
	
}
