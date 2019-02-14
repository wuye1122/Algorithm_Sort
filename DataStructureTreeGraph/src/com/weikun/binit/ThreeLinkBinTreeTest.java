package com.weikun.binit;


public class ThreeLinkBinTreeTest
{
    public static void main(String[] args) 
    {
        ThreeLinkBinTree<String> binTree = new ThreeLinkBinTree("根节点");
		//依次添加节点
		ThreeLinkBinTree.TreeNode tn1 = binTree.addNode(binTree.root()
			,  "二左" , true);
		ThreeLinkBinTree.TreeNode tn2 = binTree.addNode(binTree.root()
			, "二右" ,false );
		ThreeLinkBinTree.TreeNode tn3 = binTree.addNode(tn1 
			, "三左" , true);
		ThreeLinkBinTree.TreeNode tn4 = binTree.addNode(tn1
			, "三右" , false);
		ThreeLinkBinTree.TreeNode tn5 = binTree.addNode(tn3
			, "四右" , false);//仅有一个右节点
		ThreeLinkBinTree.TreeNode tn6 = binTree.addNode(tn5
			, "五左" , true);
		ThreeLinkBinTree.TreeNode tn7 = binTree.addNode(tn5
			, "五右" , false);
		System.out.println("先序遍历："+binTree.preIterator());//先序遍历，先处理根节点
		System.out.println("中序遍历："+binTree.inIterator());//中序遍历，中间处理根节点
		System.out.println("后序遍历："+binTree.postIterator());//后序遍历，最后处理根节点
		System.out.println("广度优先遍历："+binTree.breadthFirst());//广度优先遍历

    }
}