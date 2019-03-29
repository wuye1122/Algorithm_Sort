package com.wuye.interview;





public class SelectionSortList {
/*
 *  1 ����һ���������ѡ������
 *    ѡ��������Ǵ�δ����������ҳ���С��Ԫ�ط����ź����ĩ��
 *    Ҫ�� ʱ�临�Ӷ� O(n2) �ռ临�Ӷ�O(1)  
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
		 System.out.println("���������������:");
		 while(node!=null){
			 System.out.print(node.data+"--");
			 node=node.next;
		 }
		 System.out.println();
	 }
	
	 
	  //��������
	 public static Node select(Node head){
		 Node tail=null;//����Ķ�β
		 Node cur=head;//δ����Ķ�ͷ
		 Node small=null;
		 Node smallPre=null;
		 while(cur!=null){
			 small=cur;
			 smallPre=getSmallPreNode(cur);
			 //����ɾ����С�ڵ�
			 if(smallPre!=null){
				 small=smallPre.next;
				 smallPre.next=small.next;
				 
			 }
			 
			 cur=cur==small?cur.next:cur;
			 //�����С�ڵ���ͷ�������  smallPre=null  
			 //curֻ��=cur.next
			 //��֮ͷ���Ѿ���ɾ���� cur����δ�����ͷ��
			 //
			 
			 
			 //��С�Ľ�������
			 if(tail==null){
				 head=small;
			 
			 }else{
				 tail.next=small;
				 
			 }
			 tail=small;
			 
		 }
		return head;
		 
	 }
	 
	 
	 //����ѡ������ ������СԪ�ص�ǰһ���ڵ�
	 public static Node getSmallPreNode(Node head){
		 
		 //�����ĸ�����
		 
		 //ǰ�����������
		 Node pre=head;
		 Node next=head.next;
		 //ָ����С ����С��ǰһ���ڵ�
		 Node small=head;//һ��ʼ��С�ľ��� ��һ���ڵ�
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
