package com.weikun.bin;
/*
 * �ӽ�����Կ�����˳��洢��������˼����ǽ����в�ͬ�Ľڵ��������Ĳ�ͬλ�ã�
 * ���磬���ڵ㣬��Զʹ������ĵ�һ��Ԫ�������棻�ڶ���ĵڶ����ڵ㣬��Զʹ��
 * ����ĵ�����Ԫ�������棻���������ұߵĽڵ㣬��Զʹ������ĵ��߸�Ԫ�������档
 * ����ȱ���ǿռ��˷Ѻܴ�
 */
public class ArrayBinTreeTest {
	public static void main(String[] args) 
	{
		ArrayBinTree<String> binTree = 
			new ArrayBinTree<String>(4, "��");
		binTree.add(0 , "�ڶ������ӽڵ�" , false);
		binTree.add(2 , "���������ӽڵ�" , false);
		binTree.add(6 , "���Ĳ����ӽڵ�" , false);
		System.out.println(binTree);
		
	}
}
