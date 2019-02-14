package com.wuye.interview;



public class RemoveByRatio {
/*
 *  *ratio:概率
 *  
 *   对于给定的a/b  在长度为n的链表里面上取整 ceil的到一个【0,n】的数
 *   
 *   然后通过一个循环取得 n-1处的Node
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

public static Node removeByRatio(Node head,int a,int b){
	
	if(a<0||a>b){
	return head;
	}
	
	//链表长度
	int n=0;
	Node cur=head;
	while(cur!=null){
       n++;
       cur=cur.next;
	}
	
	n=(int)Math.ceil((double)(a*n/(double)b));
	//得到要删除的节点
	if(n==1){
		return head.next;
		
	}
	//当n等于1的时候cur就是删除节点的前一个节点
	
	if(n>1){
		
	cur=head;
	while(--n!=1){
		cur=cur.next;
		
	}
	 cur.next=cur.next.next;
	}
	return head;
	
}

	public static void println(Node node){
		System.out.println("链表的数据如下:");
		
		while(node!=null){
			System.out.print(node.data+"--");
			node=node.next;
		}
		
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveByRatio  rr=new RemoveByRatio();
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
		head.next.next.next.next=new Node(4);
		rr.println(head);
		rr.println(rr.removeByRatio(head, 2, 6));
	}

}
