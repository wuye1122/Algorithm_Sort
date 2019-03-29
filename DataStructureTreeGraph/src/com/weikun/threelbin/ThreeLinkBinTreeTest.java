package com.weikun.threelbin;


public class ThreeLinkBinTreeTest
{
    public static void main(String[] args) 
    {
        ThreeLinkBinTree<String> binTree = new ThreeLinkBinTree("���ڵ�");
		//������ӽڵ�
		ThreeLinkBinTree.TreeNode tn1 = binTree.addNode(binTree.root()
			,  "�ڶ�����ڵ�" , true);
		ThreeLinkBinTree.TreeNode tn2 = binTree.addNode(binTree.root()
			, "�ڶ����ҽڵ�" ,false );
		ThreeLinkBinTree.TreeNode tn3 = binTree.addNode(tn2 
			, "��������ڵ�" , true);
		ThreeLinkBinTree.TreeNode tn4 = binTree.addNode(tn2
			, "�������ҽڵ�" , false);
		ThreeLinkBinTree.TreeNode tn5 = binTree.addNode(tn3
			, "���Ĳ���ڵ�" , true);
		System.out.println("tn2�ĸ��ڵ㣺" + binTree.parent(tn2));
		System.out.println("tn2�����ӽڵ㣺" + binTree.leftChild(tn2));
		System.out.println("tn2�����ӽڵ㣺" + binTree.rightChild(tn2));
		System.out.println(binTree.deep());
    }
}
