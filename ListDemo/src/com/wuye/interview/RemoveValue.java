package com.wuye.interview;

import java.util.Stack;



public class RemoveValue {
/*
 * 
 *  1 ɾ������ָ��ֵnum�Ľڵ�
 *    ʱ�� �ռ临�Ӷȶ���O(n)
 *    ʹ��stack �Ƚ�������num��ֵѹ��ջ����
 *    �����γ�������һ��
 * 
 * 
 *  2 ʹ�ñ�����������ʽ  
 *    ʱ�临�Ӷ� O(n)  �ռ临�Ӷ�O(1) 
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
		System.out.println("���������������:");
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
		//���Ͻ���������ȫ������num��ֵѹ���� ջ����
		//��ʱ head=null
	
		 while(!ss.isEmpty()){
       //��д��װ			 
			 ss.peek().next=head;
			 head=ss.pop();
		 }
		return head;
	}

	
	
	public static Node removeValue1(Node head,int num){
		//�ҵ���һ��������num��ֵ �����һ������ �ͻ�����
		
		while(head!=null){
			if(head.data!=num){
				break;
			}
			head=head.next;
		}
	
		  //ʹ������������������ʽ
		
		Node pre=head;
		Node cur=head;
		while(cur!=null){
			if(cur.data==num){
				pre.next=cur.next;
			}else {
			  //���cur b������ num�� pre����
				pre=cur;
			}
			cur=cur.next;//cur������ǰ���ߵ�
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
