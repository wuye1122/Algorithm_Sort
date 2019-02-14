package com.wuye.interview;

import java.util.Stack;

public class IsPalindrome {
/*
 *   ***
 *   判断一个链表是否是回文结构  空间复杂度O(1) 时间复杂度O(n)
 * 
 *  1 使用栈 正着看和反着看是一样的。空间复杂度O(n)使用多余的数据结构
 *    将链表里面的全部值都压入栈里面了
 *  
 *  2 整理一个很好的方法  找到中间元素 和中间偏右一个
 *    将右侧压入栈里面 在和左面的进行对比
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
	
	public  boolean isPalindrome(Node head){
		
		Stack<Node> ss=new Stack<Node>();
		Node cur=head;
		while(cur!=null){
			ss.push(cur);
			cur=cur.next;
			
		}
		//已经将链表里面数据全部入栈
		
		//再讲数据那处
		while(head!=null){
			if(head.data!=ss.pop().data){
				
				return false;
			}
			head=head.next;
		}
		return true;

	}
	
	public  boolean isPalindrome1(Node head){
		
		if(head==null||head.next==null ){
			return true;//当链表里面一个或没有元素时候返回真
			
		}
		
		//找到中间或者中间偏右的元素
		
		Node right=head.next;
		
		Node cur=head;
		
		while(cur.next!=null&&cur.next.next!=null){
			cur=cur.next.next;
			right=right.next;
		}
		Stack<Node>  s2=new Stack<Node>();
		while(right!=null){
			
			s2.push(right);
			right=right.next;
			
		}
		while(!s2.empty()){
			if(head.data!=s2.pop().data){
				return false;
				
			}
			head=head.next;
		}
		return true;
	}
	
	
	/* 3 
	 *   第三种方法 时间复杂度 O(n)  空间复杂度O(1) 只需要几个变量即可
	 *
	 *   需要将有半部分反转-->比较完成之后需要将原来链表恢复原样子
	 *   基础知识就是两次反转  +  找出一个中间值
	 */
	
	public boolean isPalindrome2(Node head){
		if(head.next==null||head.next==null){
			return true;
		}
		
		Node n1=head;
		Node n2=head;
		//最终n1指向中间元素
		
		while(n2.next!=null&&n2.next.next!=null){
			n1=n1.next;
			n2=n2.next.next;
		}
		
		//此时n1指向的是中间元素
		
	//	n1.next=n2;//代表n1-->n2
		n2=n1.next;//代表n2和右侧相等
		n1.next=null;
		
		Node n3=null;
		
		
		//对右侧进行反转
		
		while(n2!=null){
			n3=n2.next;
			n2.next=n1;
			n1=n2;//向右侧移动
			n2=n3;//向右侧移动
			
		}
		//此时保存尾部节点
		
		n3=n1;
		
		n2=head;
		boolean flag=true;
		while(n1!=null&&n2!=null){
         if(n1.data!=n2.data){
        	 flag=false;
        	 break;
         }
         n1=n1.next;
			n2=n2.next;
         }
			
		//恢复反转
		//n3指向尾部节点
		
		n1=n3.next;
		n3.next=null;//尾部节点断开 
		
			while(n1!=null){
                   n2=n1.next;
                   n1.next=n3;
                   n3=n1;
                   n1=n2;
				
			}
			return flag;
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(1); 
		IsPalindrome.printLis(head);
		IsPalindrome ii=new IsPalindrome();
		System.out.println(ii.isPalindrome(head));
		System.out.println(ii.isPalindrome1(head));
		System.out.println("最优解"+ii.isPalindrome2(head));
		Node head2=new Node(1);
		head2.next=new Node(2);
		head2.next.next=new Node(2);
		head2.next.next.next=new Node(1);
		IsPalindrome.printLis(head2);
		System.out.println(ii.isPalindrome(head2));
		System.out.println(ii.isPalindrome1(head2));
		System.out.println("最优解"+ii.isPalindrome2(head2));
		Node head3=new Node(1);
		head3.next=new Node(2);
		head3.next.next=new Node(3);
		IsPalindrome.printLis(head3);
		System.out.println(ii.isPalindrome(head3));
		System.out.println(ii.isPalindrome1(head3));
		System.out.println("最优解"+ii.isPalindrome2(head3));
	}

}
