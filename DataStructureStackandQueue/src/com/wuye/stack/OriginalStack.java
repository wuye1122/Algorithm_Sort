package com.wuye.stack;

import java.util.Enumeration;
import java.util.Stack;

public class OriginalStack {

	/* 2016 2-2  明天晚上到家
	 * 
	 * 1 Stack 一种后进先出数据结构 LIFO
	 *  上面开口下面封闭 杯子 
	 * 
	 *2  栈的几个常用的方法: 
	 *   
	 *     void push(E data);压入栈顶
	 *    
	 *     E pop();返回栈顶并且删除
	 *     
	 *     E peek();返回栈顶但是不删除
	 *     
	 *     boolean empty();测试栈是否为空
	 *     
	 *     int length();返回栈的长度
	 *     
	 *     void clear();清空
	 *     
	 *     String toString();输出
	 *
	 *     
	 *     
	 *3 栈 和 堆的区别 :*****
	 *
	 * 函数中定义的基本类型的变量   对象的引用变量都是在函数的栈内存里面分配
	 * 
	 * --在一段代码定义一个变量的时候  栈为其分配内存空间 
	 *   一旦超过这个变量的作用域 java自动放掉该变量占用的内存空间  该空间可以
	 *   被其他变量使用
	 * 
	 * 堆内存用于存放 new创建的对象 和数组在堆中分配的内存  
	 * 由java虚拟机的自动垃圾回收器进行管理
	 * 
	 * --在堆里面创建的数组或者对象 可以在栈里面存入一个变量使其等于堆的首地址
	 *   称该变量为 数组或者对象的引用变量
	 *   在程序里面直接使用引用变量来访问 该数组或者该对象
	 *   
	 * 4 stack jdk自带的 还可以自己写
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	
	
	
	public static void main(String [] args){
		//使用jdk本身带的栈 进行测试
		Stack<Object> st=new Stack<Object>();
		st.push("111");
		System.out.println(st);
		
		st.push(new Integer(22));
		System.out.println(st);
		System.out.println("peek------"+st.peek());
		System.out.println(st);
		
		st.push(new Double(22.3));
		System.out.println("pop------前"+st);
		System.out.println("pop------"+st.pop());
		System.out.println("pop------后"+st);
		
		st.push(new String("字符串"));
		System.out.println(st);
		System.out.println("size----返回长度"+st.size());
		System.out.println("clear----清空前"+st.empty());
		System.out.println(st.search(22));
		
		
		//使用 枚举进行遍历 Enumeration
		System.out.println("此方法仅仅是访问这些元素------------------");	
	Enumeration<Object> est=st.elements();
	    System.out.print("(");
		while(est.hasMoreElements()){
			System.out.println(est.nextElement()+",");
		}

		System.out.println(")");
		System.out.println("------------------");
		
		//只有 pop才能看清楚 后进先出 LIFO
		
		System.out.println(st.pop());
		System.out.println("size----返回长度"+st.size());
		System.out.println(st.peek());
		System.out.println(st.pop());
		
		
		st.clear();
		System.out.println("clear----清空后"+st.empty());
		System.out.println("clear----清空后"+st.isEmpty());		System.out.println(st.search("22"));
		
		
	}
	
	
	
	
	
}
