package com.weikun.twolbin;

public class TwoLinkBinTreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoLinkBinTree<String> binTree = new TwoLinkBinTree("���ڵ�");
		//������ӽڵ�
		TwoLinkBinTree.TreeNode tn1 = binTree.addNode(binTree.root()
				,  "�ڶ�����ڵ�" , true);
		TwoLinkBinTree.TreeNode tn2 = binTree.addNode(binTree.root()
				, "�ڶ����ҽڵ�" ,false );
		TwoLinkBinTree.TreeNode tn3 = binTree.addNode(tn2 
				, "��������ڵ�" , true);
		TwoLinkBinTree.TreeNode tn4 = binTree.addNode(tn2
				, "�������ҽڵ�" , false);
		TwoLinkBinTree.TreeNode tn5 = binTree.addNode(tn3
				, "���Ĳ���ڵ�" , true);
		System.out.println("tn2�����ӽڵ㣺" + binTree.leftChild(tn2));//ȡ�������ӽڵ�
		System.out.println("tn2�����ӽڵ㣺" + binTree.rightChild(tn2));
		System.out.println(binTree.deep());
	}

}
