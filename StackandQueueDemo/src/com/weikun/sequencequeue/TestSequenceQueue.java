package com.weikun.sequencequeue;

public class TestSequenceQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SequenceQueue<String> queue = new SequenceQueue<String>();
		//���ν�4��Ԫ�ؼ������
		queue.add("aaaa");
		queue.add("bbbb");
		queue.add("cccc");
		queue.add("dddd");
		System.out.println(queue);
		System.out.println("���ʶ��е�front��Ԫ��:" 
			+ queue.element());
		System.out.println("�Ƴ����е�front��Ԫ��:" 
			+ queue.remove());
		System.out.println("�Ƴ����е�front��Ԫ��:" 
			+ queue.remove());
			
		System.out.println("���ε���remove������Ķ��У�" 
			+ queue);
	}

}
