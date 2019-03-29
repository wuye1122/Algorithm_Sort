package com.wuye.interview;

import java.util.Stack;




public class ReverseKNode1 {
/*
 *  1 ʹ��ջ ����K���ڵ�һ ��ת
 *  
 *   �Ƚ�K���ڵ�ѹ��ջ���档������ڳ�ջ  ��������������
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
			return head;//�����һλ���� ����û������Ҫ��ת
		}
		Stack<Node> ss=new Stack<Node>();
		Node newHead=head;//ָ���µ�ͷ���ڵ�
		
		Node cur=head;//����
		
		Node pre=null;//��תǰ��
		
		Node next=null;//��ת����
		
		while(cur!=null){
			next=cur.next;
			ss.push(cur);
			if(ss.size()==num){
				
				//���з�ת
				pre=rever(ss,pre,next);
				//����֮���ʱͷ���ڵ�
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
		left.next=cur;//ָ��ջ���浯�����Ľڵ�
		
	}
	//num���ڵ�ȫ������
	Node next=null;
	while(!ss.isEmpty()){
		next=ss.pop();
		cur.next=next;
		cur=next;
	}
	  cur.next=right;//�����ַ�ת������ ��ԭ������ϵ��һ��
	
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
		System.out.println("���������������:");
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
