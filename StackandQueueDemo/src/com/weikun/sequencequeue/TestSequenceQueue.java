package com.weikun.sequencequeue;

public class TestSequenceQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SequenceQueue<String> queue = new SequenceQueue<String>();
		//依次将4个元素加入队列
		queue.add("aaaa");
		queue.add("bbbb");
		queue.add("cccc");
		queue.add("dddd");
		System.out.println(queue);
		System.out.println("访问队列的front端元素:" 
			+ queue.element());
		System.out.println("移除队列的front端元素:" 
			+ queue.remove());
		System.out.println("移除队列的front端元素:" 
			+ queue.remove());
			
		System.out.println("两次调用remove方法后的队列：" 
			+ queue);
	}

}
