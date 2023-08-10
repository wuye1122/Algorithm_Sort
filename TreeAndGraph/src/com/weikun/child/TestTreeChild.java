package com.weikun.child;

import java.util.List;
//使用该种子节点链表示法来存储树时，添加节点时只需要找到父节点的子节点链的最后节点，并让他
//指向新增的节点。
//该种方式的特点是：每个节点都可以快速找到它的所有子节点，
//但如果要找某个节点的父节点则比较麻烦，需要遍历整个节点数组。
public class TestTreeChild {
	public static void main(String[] args){
		TreeChild<String> tp = new TreeChild<String>("root");
		TreeChild.Node root = tp.root();
		System.out.println("根节点：" + root);
		tp.addNode("节点1" , root);
		tp.addNode("节点2" , root);
		tp.addNode("节点3" , root);
		System.out.println("添加子节点后的根节点：" + root);
		System.out.println("此树的深度:" + tp.deep());
		//获取根节点的所有子节点
		List<TreeChild.Node<String>> nodes = tp.children(root);
		System.out.println("根节点的第一个子节点：" + nodes.get(0));
		//为根节点的第一个子节点新增一个子节点
		tp.addNode("节点4" , nodes.get(0));
		System.out.println("根节点的第一个子节点：" + nodes.get(0));
		System.out.println("此树的深度:" + tp.deep());
	}
}
