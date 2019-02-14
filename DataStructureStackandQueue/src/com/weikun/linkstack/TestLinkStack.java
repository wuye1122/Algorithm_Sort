package com.weikun.linkstack;

public class TestLinkStack {
	public static void main(String[] args) {
		LinkStack<String> stack =
			new LinkStack<String>();
		//不断地入栈
		stack.push("aaaa");
		stack.push("bbbb");
		stack.push("cccc");
		stack.push("dddd");
		System.out.println(stack);
		//访问栈顶元素，不释放
		System.out.println("访问栈顶元素：" + stack.peek());
		//弹出一个元素,释放栈顶
		System.out.println("第一次弹出栈顶元素：" + stack.pop());
		//再次弹出一个元素,释放栈顶
		System.out.println("第二次弹出栈顶元素：" + stack.pop());
		System.out.println("两次pop之后的栈：" + stack);
	}
}
