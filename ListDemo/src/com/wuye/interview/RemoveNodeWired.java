package com.wuye.interview;



public class RemoveNodeWired {
/*
 * 
 *  1 ��������ɾ�� �ڵ� ��������Ҫɾ����Node��������ͷ���ڵ� ��int����
 *   
 *    ����һ:���ܻ��뵽 ��node��ɺ�һ�������ֵ Ȼ�󽫺�һ���ڵ�ɾ��
 *    
 *         ������������һ���ڵ�Ļ�  node�Ҳ�������ӵ�
 *         ������ڵ�3-->null �൱�ڽ�2��next-->null
 *         null��һ���ض������� �������next-->next����
 *         ���ҵ�2���Ľڵ�
 *         
 *         
 *     ������:���ǽ��ڵ��ֵ�ı�Ȼ����ɾ�������Ǹ��ڵ�
 *          ʵ���������� �Խڵ���иı��Ǵ������    
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
	System.out.println("�������������:");

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
