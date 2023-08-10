package com.weikun.child;

import java.util.List;
//ʹ�ø����ӽڵ�����ʾ�����洢��ʱ����ӽڵ�ʱֻ��Ҫ�ҵ����ڵ���ӽڵ��������ڵ㣬������
//ָ�������Ľڵ㡣
//���ַ�ʽ���ص��ǣ�ÿ���ڵ㶼���Կ����ҵ����������ӽڵ㣬
//�����Ҫ��ĳ���ڵ�ĸ��ڵ���Ƚ��鷳����Ҫ���������ڵ����顣
public class TestTreeChild {
	public static void main(String[] args){
		TreeChild<String> tp = new TreeChild<String>("root");
		TreeChild.Node root = tp.root();
		System.out.println("���ڵ㣺" + root);
		tp.addNode("�ڵ�1" , root);
		tp.addNode("�ڵ�2" , root);
		tp.addNode("�ڵ�3" , root);
		System.out.println("����ӽڵ��ĸ��ڵ㣺" + root);
		System.out.println("���������:" + tp.deep());
		//��ȡ���ڵ�������ӽڵ�
		List<TreeChild.Node<String>> nodes = tp.children(root);
		System.out.println("���ڵ�ĵ�һ���ӽڵ㣺" + nodes.get(0));
		//Ϊ���ڵ�ĵ�һ���ӽڵ�����һ���ӽڵ�
		tp.addNode("�ڵ�4" , nodes.get(0));
		System.out.println("���ڵ�ĵ�һ���ӽڵ㣺" + nodes.get(0));
		System.out.println("���������:" + tp.deep());
	}
}
