package com.weikun.linkqueue;

public class TestLinkQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkQueue<String> queue 
		= new LinkQueue<String>("aaaa");
		//�������Ԫ��
		queue.add("bbbb");
		queue.add("cccc");
		System.out.println(queue);
		//ɾ��һ��Ԫ�غ�
		queue.remove();
		System.out.println("ɾ��һ��Ԫ�غ�Ķ��У�" + queue);
		//�ٴ����һ��Ԫ��
		queue.add("dddd");
		System.out.println("�ٴ����Ԫ�غ�Ķ��У�" + queue);
		//ɾ��һ��Ԫ�غ󣬶��п����ٶ��һ��Ԫ��
		queue.remove();
		//�ٴμ���һ��Ԫ��
		queue.add("eeee");
		System.out.println("��ɾ���������Ԫ�صĶ��У�"+queue);
	}

}
