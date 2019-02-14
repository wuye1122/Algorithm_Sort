package com.weikun.bin;
/*
 * 从结果可以看出，顺序存储二叉树的思想就是将树中不同的节点存入数组的不同位置，
 * 比如，根节点，永远使用数组的第一个元素来保存；第二层的第二个节点，永远使用
 * 数组的第三个元素来保存；第三层最右边的节点，永远使用数组的第七个元素来保存。
 * 他的缺点是空间浪费很大，
 */
public class ArrayBinTreeTest {
	public static void main(String[] args) 
	{
		ArrayBinTree<String> binTree = 
			new ArrayBinTree<String>(4, "根");
		binTree.add(0 , "第二层右子节点" , false);
		binTree.add(2 , "第三层右子节点" , false);
		binTree.add(6 , "第四层右子节点" , false);
		System.out.println(binTree);
		
	}
}
