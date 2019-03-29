package com.wuye.interview;

import java.util.Stack;

public class IsPalindrome {
/*
 *   ***
 *   �ж�һ�������Ƿ��ǻ��Ľṹ  �ռ临�Ӷ�O(1) ʱ�临�Ӷ�O(n)
 * 
 *  1 ʹ��ջ ���ſ��ͷ��ſ���һ���ġ��ռ临�Ӷ�O(n)ʹ�ö�������ݽṹ
 *    �����������ȫ��ֵ��ѹ��ջ������
 *  
 *  2 ����һ���ܺõķ���  �ҵ��м�Ԫ�� ���м�ƫ��һ��
 *    ���Ҳ�ѹ��ջ���� �ں�����Ľ��жԱ�
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
	
	public  boolean isPalindrome(Node head){
		
		Stack<Node> ss=new Stack<Node>();
		Node cur=head;
		while(cur!=null){
			ss.push(cur);
			cur=cur.next;
			
		}
		//�Ѿ���������������ȫ����ջ
		
		//�ٽ������Ǵ�
		while(head!=null){
			if(head.data!=ss.pop().data){
				
				return false;
			}
			head=head.next;
		}
		return true;

	}
	
	public  boolean isPalindrome1(Node head){
		
		if(head==null||head.next==null ){
			return true;//����������һ����û��Ԫ��ʱ�򷵻���
			
		}
		
		//�ҵ��м�����м�ƫ�ҵ�Ԫ��
		
		Node right=head.next;
		
		Node cur=head;
		
		while(cur.next!=null&&cur.next.next!=null){
			cur=cur.next.next;
			right=right.next;
		}
		Stack<Node>  s2=new Stack<Node>();
		while(right!=null){
			
			s2.push(right);
			right=right.next;
			
		}
		while(!s2.empty()){
			if(head.data!=s2.pop().data){
				return false;
				
			}
			head=head.next;
		}
		return true;
	}
	
	
	/* 3 
	 *   �����ַ��� ʱ�临�Ӷ� O(n)  �ռ临�Ӷ�O(1) ֻ��Ҫ������������
	 *
	 *   ��Ҫ���а벿�ַ�ת-->�Ƚ����֮����Ҫ��ԭ������ָ�ԭ����
	 *   ����֪ʶ�������η�ת  +  �ҳ�һ���м�ֵ
	 */
	
	public boolean isPalindrome2(Node head){
		if(head.next==null||head.next==null){
			return true;
		}
		
		Node n1=head;
		Node n2=head;
		//����n1ָ���м�Ԫ��
		
		while(n2.next!=null&&n2.next.next!=null){
			n1=n1.next;
			n2=n2.next.next;
		}
		
		//��ʱn1ָ������м�Ԫ��
		
	//	n1.next=n2;//����n1-->n2
		n2=n1.next;//����n2���Ҳ����
		n1.next=null;
		
		Node n3=null;
		
		
		//���Ҳ���з�ת
		
		while(n2!=null){
			n3=n2.next;
			n2.next=n1;
			n1=n2;//���Ҳ��ƶ�
			n2=n3;//���Ҳ��ƶ�
			
		}
		//��ʱ����β���ڵ�
		
		n3=n1;
		
		n2=head;
		boolean flag=true;
		while(n1!=null&&n2!=null){
         if(n1.data!=n2.data){
        	 flag=false;
        	 break;
         }
         n1=n1.next;
			n2=n2.next;
         }
			
		//�ָ���ת
		//n3ָ��β���ڵ�
		
		n1=n3.next;
		n3.next=null;//β���ڵ�Ͽ� 
		
			while(n1!=null){
                   n2=n1.next;
                   n1.next=n3;
                   n3=n1;
                   n1=n2;
				
			}
			return flag;
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(1); 
		IsPalindrome.printLis(head);
		IsPalindrome ii=new IsPalindrome();
		System.out.println(ii.isPalindrome(head));
		System.out.println(ii.isPalindrome1(head));
		System.out.println("���Ž�"+ii.isPalindrome2(head));
		Node head2=new Node(1);
		head2.next=new Node(2);
		head2.next.next=new Node(2);
		head2.next.next.next=new Node(1);
		IsPalindrome.printLis(head2);
		System.out.println(ii.isPalindrome(head2));
		System.out.println(ii.isPalindrome1(head2));
		System.out.println("���Ž�"+ii.isPalindrome2(head2));
		Node head3=new Node(1);
		head3.next=new Node(2);
		head3.next.next=new Node(3);
		IsPalindrome.printLis(head3);
		System.out.println(ii.isPalindrome(head3));
		System.out.println(ii.isPalindrome1(head3));
		System.out.println("���Ž�"+ii.isPalindrome2(head3));
	}

}
