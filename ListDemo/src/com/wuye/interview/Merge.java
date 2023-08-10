package com.wuye.interview;





public class Merge {

	/*  *�ϲ������������� M  N
	 *   
	 *   ʱ�临�Ӷ�O(N+M) �ռ临�Ӷ�O(1)
	 *   ������һЩ  �������������ݽṹ 
	 *   
	 *   
	 *  ����:cur1-->ͷ���Ƚ�С��������
	 *      cur2-->ͷ���Ƚϴ��������
	 *      head:�µ�ͷ��
	 *      pre--һָֻ���¼���head����Ƚϴ���Ǹ�
	 *      next--�����������ʹ�õı���
	 *    
	 * 
	 * 
	 * 
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
	
	// 07-33
	public static Node meger(Node head1,Node head2){
		
		
		//���������һ��Ϊnull ������һ���ڵ�
		if(head1==null||head2==null){
			return head1==null?head2:head1;
			
		}
		
		//��ѡ������ָ���ʼλ��
		
		//ȡ��һ��С��ͷ�ڵ�
		Node head=head1.data<head2.data?head1:head2;
		
		//cur1ָ���С��������
		Node cur1=head==head1?head1:head2;
		
		//cur2ָ����������
		Node cur2=head==head1?head2:head1;
		
		
		
		//next�������ʹ�õ�
		Node next=null;
		//pre��ֵָ��ÿһ����С�Ľڵ�
	  Node pre=null;
		
		while(cur1!=null&&cur2!=null){
			if(cur1.data<=cur2.data){
				pre=cur1;
				cur1=cur1.next;
				
			}else{
				
				next=cur2.next;
				pre.next=cur2;
				cur2.next=cur1;
				pre=cur2;
				cur2=next;			
				
			}
			
		}
		pre.next=cur1==null?cur2:cur1;//�Ƚ����֮����Ҫ����
		return head;
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head=new Node(0);
		head.next=new Node(2);
		head.next.next=new Node(4); 
		head.next.next.next=null;
		Merge.printLis(head);
		System.out.println();
		
		Node head2=new Node(1);
		head2.next=new Node(3);
		head2.next.next=new Node(5);
		head2.next.next.next=new Node(7);
		head2.next.next.next.next=null;
		System.out.println();
		Merge.printLis(head2);
		
		System.out.println();
		Merge.printLis(Merge.meger(head2, head));
	}

}
