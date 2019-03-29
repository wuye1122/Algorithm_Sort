package com.wuye.interview;

import java.util.Stack;



public class Add2List2 {
    
	/*
	 *  1  ���������������
	 *    ʹ��stack�ṹ,��������������ȫ���������� ,Ȼ����ȫ��������
	 *     
	 *    n=n1+n2+ca;
	 *    pre�� node���µĽ���������
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
		System.out.println("���������������:");
		while(head!=null){
			
			System.out.print(head.data+"--");
			head=head.next;
		}
	}
	
	
	
	 public  static Node add2List2(Node head1,Node head2){
		  Stack<Integer> s1=new Stack<Integer>();
		  Stack<Integer> s2=new Stack<Integer>();
		  
		  //���ϵ�ѹ��ջ
		  while(head1!=null){//����ջ����������
			  s1.push(head1.data);
			  head1=head1.next;
		  }
		  while(head2!=null){//ջѹ����  ճ������
			  s2.push(head2.data);
			  head2=head2.next;
		  }
		  
		  int n=0;
		  int n1=0;
		  int n2=0;
		  int ca=0;
		  Node pre=null;
		  Node node=null;
		//���ϵĴ�ջ�������
		while(!s1.isEmpty()||!s2.isEmpty()){
			//��һ��������null ��һֱ��ջ
			n1=s1.isEmpty()?0:s1.pop();
			n2=s2.isEmpty()?0:s2.pop();
			
			n=n1+n2+ca;
			pre=node;
			node=new Node(n % 10);
			node.next=pre;
			ca=n/10;
			
		}
		if(ca==1){
			pre=node;//preָ��ԭ����ĩ��
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
