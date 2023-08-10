package com.wuye.interview;





public class ReverseKNode2 {
public static class Node{
		
		public int data;
		
		public Node next;
		
		Node(int data){
			
			this.data=data;
		}
		
	}


  //首先 变量 pre start ....end next
public static Node reverserKNode2(Node head,int num){
	
	//cur是跟着往前遍历的变量
	
	Node cur=head;
	Node start=null;
	Node pre=null;
	Node next=null;
	
	//cur指向 数字+1
    int	count=1;
	
	while(cur!=null){
		next=cur.next;//next正好在next位置
		if(count==num){
			start=pre==null?head:pre.next;
			head=pre==null?cur:head;//第一次等于当前位置   也就是num处  之后都不变
			rever2(pre,start,cur,next);//将num个节点反转 并且 将其连在后面的未反转的链表上面
			pre=start;//pre等于反转后的 位置start.next=right;
			count=0;
		}
		
		count++;//此时正好等于num
		cur=next;//cur-->end
		
	}
	return head;
	
	
	
	
}
	
	private static void rever2(Node left, Node start, Node end, Node right) {
	// TODO Auto-generated method stub
		
		
		
		
		Node pre=start;//固定连接后面的节点
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
		System.out.println("你的链表数据如下:");
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
