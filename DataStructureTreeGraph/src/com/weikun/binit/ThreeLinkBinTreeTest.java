package com.weikun.binit;


public class ThreeLinkBinTreeTest
{
    public static void main(String[] args) 
    {
        ThreeLinkBinTree<String> binTree = new ThreeLinkBinTree("���ڵ�");
		//������ӽڵ�
		ThreeLinkBinTree.TreeNode tn1 = binTree.addNode(binTree.root()
			,  "����" , true);
		ThreeLinkBinTree.TreeNode tn2 = binTree.addNode(binTree.root()
			, "����" ,false );
		ThreeLinkBinTree.TreeNode tn3 = binTree.addNode(tn1 
			, "����" , true);
		ThreeLinkBinTree.TreeNode tn4 = binTree.addNode(tn1
			, "����" , false);
		ThreeLinkBinTree.TreeNode tn5 = binTree.addNode(tn3
			, "����" , false);//����һ���ҽڵ�
		ThreeLinkBinTree.TreeNode tn6 = binTree.addNode(tn5
			, "����" , true);
		ThreeLinkBinTree.TreeNode tn7 = binTree.addNode(tn5
			, "����" , false);
		System.out.println("���������"+binTree.preIterator());//����������ȴ�����ڵ�
		System.out.println("���������"+binTree.inIterator());//����������м䴦����ڵ�
		System.out.println("���������"+binTree.postIterator());//����������������ڵ�
		System.out.println("������ȱ�����"+binTree.breadthFirst());//������ȱ���

    }
}