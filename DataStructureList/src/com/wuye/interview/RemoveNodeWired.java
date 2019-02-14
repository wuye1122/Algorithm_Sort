package com.wuye.interview;



public class RemoveNodeWired {
/*
 * 
 *  1 进行特殊删除 节点 仅仅给出要删除的Node而不给出头部节点 是int类型
 *   
 *    方法一:可能会想到 将node变成后一个几点的值 然后将后一个节点删除
 *    
 *         但是如果是最后一个节点的话  node找不到代替接单
 *         如果将节点3-->null 相当于将2的next-->null
 *         null是一个特定的区域 如果将其next-->next必须
 *         先找到2处的节点
 *         
 *         
 *     方法二:就是将节点的值改变然后再删除后面那个节点
 *          实际生活里面 对节点进行改变是错误决定    
 *    
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
public static void removeNodeWire(Node node){

	if(node==null){
		return;
	}
	Node next=node.next;
	if(next==null){
		throw new RuntimeException("can not delete last node");

	}
	node.data=next.data;
	node.next=next.next;

}
public static void main(String[] args) {
	// TODO Auto-generated method stub
	Node node1=new Node(1);
	Node node2=new Node(2);
	Node node3=new Node(3);
	Node node4=new Node(4);
	node1.next=node2;
	node2.next=node3;
	node3.next=node4;
	node4.next=null;
	
	RemoveNodeWired.println(node1);
	RemoveNodeWired.removeNodeWire(node2);
	RemoveNodeWired.println(node1);

}

}
