package com.wuye.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Hafuman {
	/*7 5 4 2
	 * 
	 *       18
	 *    11   7
	 *   6  5
	 *  2 4
	 * 			
	 * 首先创建哈夫曼树  然后遍历
	 */
	
	//首先创建哈夫曼树  根据链表将哈夫曼树创建完成
	
	public Node<String> createTree(List<Node<String>> nodes){
		
		while(nodes.size()>1){
			Collections.sort(nodes);
			
			
			//因为排序之后 是从小到大的而形式  索引 取出第一个  和第二个
			Node<String> left=nodes.get(0);
			Node<String> right=nodes.get(1);
			
			Node<String> newNode=new Node(left.getWeight()+right.getWeight(), left.data+"--"+right.data);
			
			newNode.setLeft(left);
			newNode.setRight(right);
			nodes.remove(0);//当删除第一个之后  原来的而第二个变成第一个 自动删除
			nodes.remove(0);
			
			nodes.add(newNode);
			
		}
		return nodes.get(0);
		
		
	}
	
	public void Traversal(Node<String> root){
		
		Queue<Node<String>> queue=new ArrayDeque<>();
		
		 queue.add(root);
		 
		 while(!queue.isEmpty()){
			 
			 Node<String> node=queue.poll();
			 
			 System.out.println("数据:"+node.data+"   权值:"+node.weight);
		    
		      if(node.left!=null){
		    	  queue.add(node.left);
		    	  
		      }
		      
		      if(node.right!=null){
		    	  queue.add(node.right);
		      }
		 
		 }
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hafuman ha=new Hafuman();
		
		List<Node<String>> lis=new ArrayList<Node<String>>();
          
		 lis.add(new Node(7,"A")); 
		 lis.add(new Node(5,"B"));
		 lis.add(new Node(4,"C"));
		 lis.add(new Node(2,"D"));
		 
		 ha.Traversal(ha.createTree(lis));
	}

}
class Node<T> implements Comparable{

	public int weight;
	public Node<String> left;
	public Node<String> right;
	public T data;
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Node<String> getLeft() {
		return left;
	}

	public void setLeft(Node<String> left) {
		this.left = left;
	}

	public Node<String> getRight() {
		return right;
	}

	public void setRight(Node<String> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	Node(int weight,T data){
		this.weight=weight;
		this.data=data;
		
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Node nn=(Node)o;
		return this.weight-nn.weight;
	}
	
	

	
	
	
	
}