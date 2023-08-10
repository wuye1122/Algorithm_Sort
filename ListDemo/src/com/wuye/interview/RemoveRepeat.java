package com.wuye.interview;

import java.util.HashSet;



public class RemoveRepeat {

	/*
	 * 
	 * 1 ��һ�ַ���ʹ��HashSet �����ж��Ƿ�contain
	 *  ʱ�临�Ӷ� O(n) �ռ临�Ӷ�O(n)
	 * 
	 * 
	 * 2 �ڶ��ַ�������ѡ������ ��һ������һ����ȫ��ɾ�������Դ�����
	 *  ʱ�临�Ӷ�O(n2) �ռ临�Ӷ�O(1)
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
		System.out.println("�������������:");
		
		while(node!=null){
			System.out.print(node.data+"--");
			node=node.next;
		}
		
	} 
	public static void removeRepeat1(Node head){
		
		//������ cur next pre
		Node cur=head;
		Node pre=null;
		Node next=null;
		//����whileѭ���Ʊ� �����O(n2)�����
		while(cur!=null){
			pre=cur;
			next=cur.next;
			
			while(next!=null){
				
				if(next.data==cur.data){
					pre.next=next.next;
					
				}else{
					pre=next;
					
				}
				
				next=next.next;
			}
				
			
			
			cur=cur.next;
		}
		
		
		
		
		
		
		
		
		
		
	}
	//ʹ��һ����ϣ��
	public static void removeRepeat(Node head){
		if(head==null){
			return;
		}
		HashSet<Integer> set= new HashSet<Integer>();
		Node pre=head;
		Node cur=head.next;
		set.add(head.data);
		while(cur!=null){
			if(set.contains(cur.data)){
				pre.next=cur.next;
			}else{
				//�������Ƚ�����cur�����ֵ�����set����
				set.add(cur.data);
				pre=cur;
			}
			
			cur=cur.next;
			
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head2=new Node(1);
		head2.next=new Node(2);
		head2.next.next=new Node(2);
		head2.next.next.next=new Node(4);
		head2.next.next.next.next=new Node(1);
		head2.next.next.next.next.next=new Node(4);
		RemoveRepeat.println(head2);
		//RemoveRepeat.removeRepeat(head2);
		RemoveRepeat.removeRepeat1 (head2);

		System.out.println("��һ�ַ�������ɾ����Ľ��");
		RemoveRepeat.println(head2);
		
		
		
	}

}
