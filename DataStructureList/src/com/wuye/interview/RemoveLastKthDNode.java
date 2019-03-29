package com.wuye.interview;



public class RemoveLastKthDNode {

	

	
	/*   �ó�����ɾ��˫���б�
	 * 
	 *  *ɾ���������˫����ĵ�����k���ڵ㣬���ҷ�������ͷ���ڵ�
	 *  
	 *   Ҫ��ʱ�临�Ӷ�ΪO(n)    �ռ临�Ӷ�O(1) 
	 * 
	 *   1 ���� ֪��k֮�� �ȱ���
	 *    
	 *      ����һ��������k--
	 *   2 ������k��ֵ�����жϵ�ʱ��k���Ƿ��ڱ���
	 *   
	 *     >0˵��k����������
	 *     =0˵�����ص���ʽhead  ����head.next;
	 *     <0��˵��K������
	 *       0 1 2 3 4 5 6  --->k=3
	 *       2 1 0 -1-2-3-4         
	 *       -3-2-10 ��ѭ��=0ʱ�������Ҫɾ���ڵ��pre
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
			System.out.println("�������������:");
			
			while(node!=null){
				System.out.print(node.data+"--");
				node=node.next;
			}
			
		} 
		
		
	  public static Node removeLastKthDNode(Node head,int lastKth){
		//����ɾ���������ͷ��
		  
		  
		  //���������Ҫ�ı�
		  if(head==null||lastKth<0){
			  return head;	  
		  }
		  Node cur=head;
		  while(cur!=null){
			  lastKth--;
			  cur=cur.next;
		  }
		  if(lastKth==0){
	         System.out.println("��ɾ������ͷ��Ԫ��"); 
	         head=head.next;
	         head.pre=null;
		  }
		  
		  if(lastKth<0){
	       cur=head;
			  while(++lastKth!=0){
				  cur=cur.next;
			  }
			  //����cur����ɾ���ڵ��ǰһ���ڵ�
			  //����ɾ���ڵ����Ľڵ�
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



