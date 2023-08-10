package com.wuye.interview;




public class ReverseList {
/*    
 *    *�Ե�������з�ת 
 *    
 *    Ҫ��ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(1)
 *    �ڶ��ζ�������з�ת���������    
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
	
	
	public static Node reverseList(Node node){
		
		//����һ�������ߵı���
		Node next=null;
		//����һ����ǰ�ߵķ�ת���ͷ��
		Node pre=null;
		
		while(node!=null){

			next=node.next;//�����ƶ�һ��
			
			node.next=pre;//ָ��ת��ͷ
			
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
		//�����쳣��Ϊ��ת֮���head-->null
		//�ٴη�ת����ṹ�����仯��
		rr.println(rr.reverseList(head));
		
	}

}
