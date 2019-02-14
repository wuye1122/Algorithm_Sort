package com.wuye.interview;

import java.util.HashSet;



public class RemoveRepeat {

	/*
	 * 
	 * 1 第一种方法使用HashSet 进行判断是否contain
	 *  时间复杂度 O(n) 空间复杂度O(n)
	 * 
	 * 
	 * 2 第二种方法类似选择排序 第一个后面一样的全部删除……以此类推
	 *  时间复杂度O(n2) 空间复杂度O(1)
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
	public static void removeRepeat1(Node head){
		
		//三个变 cur next pre
		Node cur=head;
		Node pre=null;
		Node next=null;
		//两个while循环势必 会出现O(n2)的情况
		while(cur!=null){
			pre=cur;
			next=cur.next;
			
			while(next!=null){
				
				if(next.data==cur.data){
					pre.next=next.next;
					
				}else{
					pre=next;
					
				}
				
				next=next.next;
			}
				
			
			
			cur=cur.next;
		}
		
		
		
		
		
		
		
		
		
		
	}
	//使用一个哈希表
	public static void removeRepeat(Node head){
		if(head==null){
			return;
		}
		HashSet<Integer> set= new HashSet<Integer>();
		Node pre=head;
		Node cur=head.next;
		set.add(head.data);
		while(cur!=null){
			if(set.contains(cur.data)){
				pre.next=cur.next;
			}else{
				//如果不相等将此事cur里面的值添加入set里面
				set.add(cur.data);
				pre=cur;
			}
			
			cur=cur.next;
			
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head2=new Node(1);
		head2.next=new Node(2);
		head2.next.next=new Node(2);
		head2.next.next.next=new Node(4);
		head2.next.next.next.next=new Node(1);
		head2.next.next.next.next.next=new Node(4);
		RemoveRepeat.println(head2);
		//RemoveRepeat.removeRepeat(head2);
		RemoveRepeat.removeRepeat1 (head2);

		System.out.println("第一种方法进行删除后的结果");
		RemoveRepeat.println(head2);
		
		
		
	}

}
