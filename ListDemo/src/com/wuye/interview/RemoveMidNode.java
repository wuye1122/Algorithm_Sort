package com.wuye.interview;




public class RemoveMidNode {
/*
 *  *删除中间节点
 *  1--1
 * 
 *  一个节点或者链表为空 则不进行删除
 *   1 2--1
 *  二个节点的时候删除头部节点
 *  返回head.next;
 *  
 *  定义两个变量  一个指向第一处  另一个指向第三处
 *  另一个往后面跳两个   一个往后跳一个
 *  指定后面最后位置或者倒数第二个位置此时 一个的下一个节点就是中间节点
 *  
 *  列举几个实例进行观察
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
		System.out.println("链表的数据如下:");
		
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
		
		//找出中间元素
		Node pre=head;//指向第一个
		
		Node cur=head.next.next;//第三个
		
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
