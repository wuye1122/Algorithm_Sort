package com.wuye.interview;



public class RemoveLastKthDNode {

	

	
	/*   该程序是删除双向列表
	 * 
	 *  *删除单链表和双链表的倒数第k个节点，并且返回链表头部节点
	 *  
	 *   要求时间复杂度为O(n)    空间复杂度O(1) 
	 * 
	 *   1 首先 知道k之后 先遍历
	 *    
	 *      遍历一遍链表且k--
	 *   2 由最终k的值可以判断到时第k个是否在表中
	 *   
	 *     >0说明k大于链表长度
	 *     =0说明返回的正式head  返回head.next;
	 *     <0则说明K在其中
	 *       0 1 2 3 4 5 6  --->k=3
	 *       2 1 0 -1-2-3-4         
	 *       -3-2-10 再循环=0时候就是所要删除节点的pre
	 *       pre.next=pre.next.next;
	 * 
	 * *
	 */
		
		public static class Node{
			
			public int data;
			
			public Node next;
			
			public Node pre;
			public Node(int data){
				this.data=data;
			}
		}

		public static void printlnlist(Node node){
			System.out.println("链表的数据如下:");
			
			while(node!=null){
				System.out.print(node.data+"--");
				node=node.next;
			}
			
		} 
		
		
	  public static Node removeLastKthDNode(Node head,int lastKth){
		//返回删除后链表的头部
		  
		  
		  //该情况不需要改变
		  if(head==null||lastKth<0){
			  return head;	  
		  }
		  Node cur=head;
		  while(cur!=null){
			  lastKth--;
			  cur=cur.next;
		  }
		  if(lastKth==0){
	         System.out.println("你删除的是头部元素"); 
	         head=head.next;
	         head.pre=null;
		  }
		  
		  if(lastKth<0){
	       cur=head;
			  while(++lastKth!=0){
				  cur=cur.next;
			  }
			  //此事cur就是删除节点的前一个节点
			  //定义删除节点后面的节点
			  Node newNext=cur.next.next;
			  cur.next=newNext;
			  if(newNext!=null){
				  newNext.pre=cur;
			  }
			  
			  
			  }
			  
			  
		  return head;
		
		
	}	
		

		public static void main(String[] args) {
			// TODO Auto-generated method stub

			RemoveLastKthDNode rr=new RemoveLastKthDNode();	
			
			//null<-1=2=3=4=4->null
			Node head=new Node(1);
			head.pre=null;
			head.next=new Node(2);
			
			head.next.pre=new Node(1);
			head.next.next=new Node(3);
			
			head.next.next.pre=new Node(3);
			head.next.next.next=new Node(4);
			
			head.next.next.next.pre=new Node(3);
			head.next.next.next.next=new Node(4);
			
			head.next.next.next.next.next=null;
			
			rr.printlnlist(head);
		rr.printlnlist(rr.removeLastKthDNode(head, 5));	
			
			
		}

	}



