package com.wuye.interview;



public class Add2List1 {
   /*
    *  ����Ҫʹ����������ݽṹ
    *  ��Ҫʹ�÷�ת ������ת��----����+�ص�
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
	
	public static Node add2List1(Node head1, Node head2) {
		
		
		
		//������һ������ķ�ת
		 head1=reverserList(head1);
		 head2=reverserList(head2);
		int n=0;
		int n1=0;
		int n2=0;
		int ca=0;
		Node node=null;
		Node pre=null;
		
		Node c1=head1;
		Node c2=head2;
		while(c1!=null||c2!=null){
			
			n1=c1!=null?c1.data:0;
			n2=c2!=null?c2.data:0;
			
			n=n1+n2+ca;
			
			pre=node;
			node=new Node(n%10);
			node.next=pre;
			ca=n/10;
			c1=c1!=null?c1.next:null;
			c2=c2!=null?c2.next:null;
			
		}
		if(ca==1){
			
			pre=node;
			node=new Node(1);
			node.next=pre;
			

		}
		
		//��ת��ָ�ԭ��
		reverserList(head1);
		
		reverserList(head2);
		
		return node;
	}
	
	public  static Node reverserList(Node head){
		
		Node pre=null;
		
		Node next=null;
		
		while(head!=null){
			next=head.next;
			head.next=pre;
			pre=head;
			head=next;
			
		}
		return pre;
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node head=new Node(0);
		head.next=new Node(2);
		head.next.next=new Node(4); 
//048
		Add2List1.printLis(head);
		System.out.println();
//1381	
		Node head2=new Node(1);
		head2.next=new Node(3);
		head2.next.next=new Node(5);
		head2.next.next.next=new Node(7);
//2714
		Node head3=new Node(1);
		head3.next=new Node(3);
		head3.next.next=new Node(5);
		head3.next.next.next=new Node(7);
		
		
		System.out.println();
		Add2List1.printLis(head2);
		System.out.println();
	
		
		//�����һ��������ж��η�ת���������
		Add2List1.printLis(Add2List1.add2List1(head3, head2));
		//System.out.println(head.next.data);
        //�����쳣��Ϊ��ת֮���head-->null
        //�ٴη�ת����ṹ�����仯��
	}
		
	

}
