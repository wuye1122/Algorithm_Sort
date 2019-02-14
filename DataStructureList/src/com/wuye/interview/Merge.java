package com.wuye.interview;





public class Merge {

	/*  *合并两个有序链表 M  N
	 *   
	 *   时间复杂度O(N+M) 空间复杂度O(1)
	 *   变量多一些  不利用其他数据结构 
	 *   
	 *   
	 *  方法:cur1-->头部比较小的那条链
	 *      cur2-->头部比较大的那条链
	 *      head:新的头部
	 *      pre--一只指向新加入head里面比较大的那个
	 *      next--用于往后遍历使用的变量
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
	
	// 07-33
	public static Node meger(Node head1,Node head2){
		
		
		//如果其中有一个为null 返回另一个节点
		if(head1==null||head2==null){
			return head1==null?head2:head1;
			
		}
		
		//首选将变量指在最开始位置
		
		//取第一个小的头节点
		Node head=head1.data<head2.data?head1:head2;
		
		//cur1指向较小的那条连
		Node cur1=head==head1?head1:head2;
		
		//cur2指向大的那条连
		Node cur2=head==head1?head2:head1;
		
		
		
		//next负责遍历使用的
		Node next=null;
		//pre赋值指向每一步最小的节点
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
		pre.next=cur1==null?cur2:cur1;//比较完成之后需要连上
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
