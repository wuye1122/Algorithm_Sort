package com.wuye.interview;



public class PrintCommonPart {
  /*
   *  *�������������ͷָ�� ��ӡ������������������
   *  
   *  
   *   ������������ �����Ǹ�ͷ��С����һ�� head=head.next
   *   �������� ����������� head=head.next;
   *   
   *   ���ó�static����,�ֶ�дһ���򵥵ĵ�����
   * 
   * */   
	
	//����������ʽ
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
	
	
	public static void printCommontPart(Node head1,Node head2){
		
		System.out.println("common part:");
		
		while(head1!=null&&head2!=null){

			if(head1.data<head2.data){
				head1=head1.next;
			}else if(head2.data<head1.data){
				head2=head2.next;
			}
			else{
				System.out.print(head1.data+"--");
				head1=head1.next;
				head2=head2.next;
			}
			
		
		
		
		
		
	}
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintCommonPart pp=new PrintCommonPart();
		Node head1=new Node(1);
	    head1.next=new Node(2);
	    head1.next.next=new Node(3);
	 	head1.next.next.next=new Node(4);
	 	
		pp.printlnlist(head1);
		Node head2=new Node(2);
	    head2.next=new Node(3);
	    head2.next.next=new Node(5);
	 	head2.next.next.next=new Node(6);
	 	
		pp.printlnlist(head2);
		pp.printCommontPart(head1, head2);
		
	}

}
