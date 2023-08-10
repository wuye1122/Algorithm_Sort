package com.wuye.interview;



public class RemoveByRatio {
/*
 *  *ratio:����
 *  
 *   ���ڸ�����a/b  �ڳ���Ϊn������������ȡ�� ceil�ĵ�һ����0,n������
 *   
 *   Ȼ��ͨ��һ��ѭ��ȡ�� n-1����Node
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
	
	//������
	int n=0;
	Node cur=head;
	while(cur!=null){
       n++;
       cur=cur.next;
	}
	
	n=(int)Math.ceil((double)(a*n/(double)b));
	//�õ�Ҫɾ���Ľڵ�
	if(n==1){
		return head.next;
		
	}
	//��n����1��ʱ��cur����ɾ���ڵ��ǰһ���ڵ�
	
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
		System.out.println("�������������:");
		
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
