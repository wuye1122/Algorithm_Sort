package com.weikun.linkstack;

public class TestLinkStack {
	public static void main(String[] args) {
		LinkStack<String> stack =
			new LinkStack<String>();
		//���ϵ���ջ
		stack.push("aaaa");
		stack.push("bbbb");
		stack.push("cccc");
		stack.push("dddd");
		System.out.println(stack);
		//����ջ��Ԫ�أ����ͷ�
		System.out.println("����ջ��Ԫ�أ�" + stack.peek());
		//����һ��Ԫ��,�ͷ�ջ��
		System.out.println("��һ�ε���ջ��Ԫ�أ�" + stack.pop());
		//�ٴε���һ��Ԫ��,�ͷ�ջ��
		System.out.println("�ڶ��ε���ջ��Ԫ�أ�" + stack.pop());
		System.out.println("����pop֮���ջ��" + stack);
	}
}
