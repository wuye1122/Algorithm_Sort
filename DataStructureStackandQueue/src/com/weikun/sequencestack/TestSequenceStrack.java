package com.weikun.sequencestack;

public class TestSequenceStrack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SequenceStack<String> stack =
			new SequenceStack<String>();
		//���ϵ���ջ
		stack.push("aaaa");
		stack.push("bbbb");
		stack.push("cccc");
		stack.push("dddd");
		System.out.println(stack);
		//����ջ��Ԫ�أ����ͷ�ջ��Ԫ��
		System.out.println("����ջ��Ԫ�أ�" + stack.peek());
		//����һ��Ԫ��,�������ͷ�ջ��Ԫ��
		System.out.println("��һ�ε���ջ��Ԫ�أ�" + stack.pop());
		//�ٴε���һ��Ԫ�أ��������ͷ�ջ��Ԫ��
		System.out.println("�ڶ��ε���ջ��Ԫ�أ�" + stack.pop());
		System.out.println("����pop֮���ջ��" + stack);
	}

}
