package com.wuye.interview;





public class ReverseKNode2 {
public static class Node{
		
		public int data;
		
		public Node next;
		
		Node(int data){
			
			this.data=data;
		}
		
	}


  //���� ���� pre start ....end next
public static Node reverserKNode2(Node head,int num){
	
	//cur�Ǹ�����ǰ�����ı���
	
	Node cur=head;
	Node start=null;
	Node pre=null;
	Node next=null;
	
	//curָ�� ����+1
    int	count=1;
	
	while(cur!=null){
		next=cur.next;//next������nextλ��
		if(count==num){
			start=pre==null?head:pre.next;
			head=pre==null?cur:head;//��һ�ε��ڵ�ǰλ��   Ҳ����num��  ֮�󶼲���
			rever2(pre,start,cur,next);//��num���ڵ㷴ת ���� �������ں����δ��ת����������
			pre=start;//pre���ڷ�ת��� λ��start.next=right;
			count=0;
		}
		
		count++;//��ʱ���õ���num
		cur=next;//cur-->end
		
	}
	return head;
	
	
	
	
}
	
	private static void rever2(Node left, Node start, Node end, Node right) {
	// TODO Auto-generated method stub
		
		
		
		
		Node pre=start;//�̶����Ӻ���Ľڵ�
		Node cur=start.next;
		Node next=null;
		while(cur!=right){
			next=cur.next;
			cur.next=pre;
			pre=cur;
			cur=next;
			
		}
		if(left!=null){
	       left.next=end;
			
		}
		start.next=right;
		
		
	
            }

	public static  void printLis(Node head){
		System.out.println("���������������:");
		while(head!=null){
			
			System.out.print(head.data+"--");
			head=head.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node head2=new Node(1);
		head2.next=new Node(3);
		head2.next.next=new Node(5);
		head2.next.next.next=new Node(4);
		head2.next.next.next.next=new Node(5);
		head2.next.next.next.next.next=new Node(6);
		head2.next.next.next.next.next.next=new Node(7);
		head2.next.next.next.next.next.next.next=new Node(9);
		
		ReverseKNode2.printLis(head2);
		ReverseKNode2.printLis(ReverseKNode2.reverserKNode2(head2, 4));
	}

}
