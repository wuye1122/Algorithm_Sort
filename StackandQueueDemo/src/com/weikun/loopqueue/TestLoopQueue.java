package com.weikun.loopqueue;

public class TestLoopQueue {
	public static void main(String[] args) {
		LoopQueue<String> queue 
		= new LoopQueue<String>("aaaa" , 3);
		//添加两个元素
		queue.add("bbbb");
		queue.add("cccc");
		//此时队列已满
		System.out.println(queue);
		//删除一个元素后，队列可以再多加一个元素
		queue.remove();
		System.out.println("删除一个元素后的队列：" + queue);
		//再次添加一个元素，此时队列又满
		queue.add("dddd");
		System.out.println(queue);
		System.out.println("队列满时的长度：" + queue.length());
		//删除一个元素后，队列可以再多加一个元素
		queue.remove();
		
		//再次加入一个元素，此时队列又满
		queue.add("eeee");
		System.out.println(queue);
	}
}
