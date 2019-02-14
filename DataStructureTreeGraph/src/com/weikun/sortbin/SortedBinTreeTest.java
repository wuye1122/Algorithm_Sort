package com.weikun.sortbin;

public class SortedBinTreeTest
{
	public static void main(String[] args) 
	{
		SortedBinTree<Integer> tree 
			= new SortedBinTree<Integer>();
		//添加节点
//		tree.add(5);
//		tree.add(20);
//		tree.add(10);
//		tree.add(3);
//		tree.add(8);
//		tree.add(15);
//		tree.add(30);
		
		tree.add(5);
		tree.add(3);
		tree.add(20);
		tree.add(10);
		tree.add(8);
		tree.add(15);
		tree.add(30);
		System.out.println(tree.breadthFirst());
		//删除节点
		tree.remove(20);
		System.out.println(tree.breadthFirst());
	}
}
