package com.weikun.loopqueue;

public class TestLoopQueue {
	public static void main(String[] args) {
		LoopQueue<String> queue 
		= new LoopQueue<String>("aaaa" , 3);
		//�������Ԫ��
		queue.add("bbbb");
		queue.add("cccc");
		//��ʱ��������
		System.out.println(queue);
		//ɾ��һ��Ԫ�غ󣬶��п����ٶ��һ��Ԫ��
		queue.remove();
		System.out.println("ɾ��һ��Ԫ�غ�Ķ��У�" + queue);
		//�ٴ����һ��Ԫ�أ���ʱ��������
		queue.add("dddd");
		System.out.println(queue);
		System.out.println("������ʱ�ĳ��ȣ�" + queue.length());
		//ɾ��һ��Ԫ�غ󣬶��п����ٶ��һ��Ԫ��
		queue.remove();
		
		//�ٴμ���һ��Ԫ�أ���ʱ��������
		queue.add("eeee");
		System.out.println(queue);
	}
}
