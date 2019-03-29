package com.wuye.interview;




public class RemoveMidNode {
/*
 *  *ɾ���м�ڵ�
 *  1--1
 * 
 *  һ���ڵ��������Ϊ�� �򲻽���ɾ��
 *   1 2--1
 *  �����ڵ��ʱ��ɾ��ͷ���ڵ�
 *  ����head.next;
 *  
 *  ������������  һ��ָ���һ��  ��һ��ָ�������
 *  ��һ��������������   һ��������һ��
 *  ָ���������λ�û��ߵ����ڶ���λ�ô�ʱ һ������һ���ڵ�����м�ڵ�
 *  
 *  �оټ���ʵ�����й۲�
 * 
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
		System.out.println("�������������:");
		
		while(node!=null){
			System.out.print(node.data+"--");
			node=node.next;
		}
		
	} 
	
	
	public static Node removeMidNode(Node head){

		if(head==null||head.next==null){
   
 		  return head;
		}
		if(head.next.next==null){
			return head.next;
			
		}
		
		//�ҳ��м�Ԫ��
		Node pre=head;//ָ���һ��
		
		Node cur=head.next.next;//������
		
		while(cur.next!=null&&cur.next.next!=null){
			
		pre=pre.next;
		
		cur=cur.next.next;
			
		}
		
		pre.next=pre.next.next;
		return head;
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveMidNode rr=new RemoveMidNode();
		Node head=new Node(1);
		head.next=new Node(2);
		//head.next.next=new Node(3);
		//head.next.next.next=new Node(4);
		//head.next.next.next.next=new Node(5);
		rr.println(head);
		rr.println(rr.removeMidNode(head));
	}

}
