package com.weikun.linkqueue;

public class TestLinkQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkQueue<String> queue 
		= new LinkQueue<String>("aaaa");
		//添加两个元素
		queue.add("bbbb");
		queue.add("cccc");
		System.out.println(queue);
		//删除一个元素后
		queue.remove();
		System.out.println("删除一个元素后的队列：" + queue);
		//再次添加一个元素
		queue.add("dddd");
		System.out.println("再次添加元素后的队列：" + queue);
		//删除一个元素后，队列可以再多加一个元素
		queue.remove();
		//再次加入一个元素
		queue.add("eeee");
		System.out.println("先删除，再添加元素的队列："+queue);
	}

}
