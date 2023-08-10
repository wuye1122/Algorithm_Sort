package com.wuye.interview;





public class CopyListWithRand1 {
	/*
	 *  不使用其他数据结构
	 *  我们将复制的节点插在原来节点的后面。
	 *  
	 * 
	 * 
	 * 
	 * 
	 * */
public static class Node{
		
		public int data;
		
		public Node rand;
		
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Node head1=new Node(1);
		
		Node head4=new Node(4);
		Node head3=new Node(3);
		Node head2=new Node(2);
		head1.next=head2;
		head2.next=head3;
		head3.next=head4;
		head4.next=null;
		head1.rand=null;
		head2.rand=head3;
		head3.rand=head2;
		head4.rand=head1;
		CopyListWithRand1.printLis(head1);
		System.out.println();
		System.out.println("head1的随机节点"+head1.rand);
		System.out.println("head2的随机节点"+head2.rand.data);
		System.out.println("head3的随机节点"+head3.rand.data);
		System.out.println("head4的随机节点"+head4.rand.data);
		CopyListWithRand1.printLis(CopyListWithRand1.copy2(head1));
		System.out.println();
		System.out.println("head1的随机节点"+head1.rand);
		System.out.println("head2的随机节点"+head2.rand.data);
		System.out.println("head3的随机节点"+head3.rand.data);
		System.out.println("head4的随机节点"+head4.rand.data);
	}

	public static Node  copy2(Node head1) {
		// TODO Auto-generated method stub
		if(head1==null){
			
			return null;
	
			
		}
		
		Node cur=head1;
		
		Node next=null;
		
		while(cur!=null){
			next=cur.next;
			cur.next=new Node(cur.data);
			cur.next.next=next;
			cur=next;
			
			
		}
		
		//首先将复制的节点插在原节点的后面
		cur=head1;
		Node copy=null;
		
		while(cur!=null){
			next=cur.next.next;
			copy=cur.next;
			copy.rand=cur.rand!=null?cur.rand.next:null;
			cur=next;
			
		}
		//弄好rand的节点
		Node res=head1.next;
		cur=head1;
		
		
		while(cur!=null){

			next=cur.next.next;//指向第三个
			copy=cur.next;//新的头部指向第二个
			cur.next=next;
			copy.next=next!=null?next.next:null;
			cur=next;
			
		}
		
		
		
		
		
		
	    //拆开
		return res;
	}

}
