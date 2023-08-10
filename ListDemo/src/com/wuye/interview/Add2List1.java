package com.wuye.interview;



public class Add2List1 {
   /*
    *  不需要使用其余的数据结构
    *  需要使用反转 将链表反转。----基础+重点
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
		System.out.println("你的链表数据如下:");
		while(head!=null){
			
			System.out.print(head.data+"--");
			head=head.next;
		}
	}
	
	public static Node add2List1(Node head1, Node head2) {
		
		
		
		//首先做一个链表的反转
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
		
		//反转后恢复原样
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
	
		
		//如果对一个链表进行二次反转会出现问题
		Add2List1.printLis(Add2List1.add2List1(head3, head2));
		//System.out.println(head.next.data);
        //出现异常因为反转之后的head-->null
        //再次反转链表结构发生变化了
	}
		
	

}
