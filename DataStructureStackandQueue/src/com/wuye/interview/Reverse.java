package com.wuye.interview;

import java.util.Stack;

public class Reverse {
  /*  ** 只能用递归函数实现不能使用其他数据结构
   *  如何使用一个栈和 一个递归函数操作逆序的栈
   * 
   * 开始                                 reverse反转后 
   *  5                 1 
   *  4					2
   *  3					3	
   *  2					4
   *  1					5
   * 
   * 
   * 
   * 
   * */
	
    //将栈底元素返回并且移除	

	public static int getAndRemoveLastElement(Stack<Integer> stack){
		
		int result=stack.pop();//获取栈顶元素 状态
		if(stack.empty()){
			
			return result;
		}else{
			
			int last=getAndRemoveLastElement(stack);
			//进去的时候 栈顶元素已经没有了  result依次 4 3 2 1 
			
			stack.push(result);
			//if 仅有一种元素的时候
			//   仅仅代表一种状态 为空返回
			//
			//else>= 一种元素
			//    实际上返回的由last
			//
			//
			return last;
			
		}
	}
      public static void  reverse(Stack<Integer> stack){
	
	   if(stack.empty()){
		return;
	   }
	
	
	int l=getAndRemoveLastElement(stack);//获取栈底不得元素
	//每次递归 分别获取 1 2 3 4 5
	//
	//
	   reverse(stack);
	 //压入站的顺序相反  
	   stack.push(l);
}		
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack=new Stack<Integer>();
		 
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.add(4);
		stack.add(5);
		System.out.println(stack.toString());
	
//		System.out.println(getAndRemoveLastElement(stack));
//		System.out.println(getAndRemoveLastElement(stack));
//		System.out.println(getAndRemoveLastElement(stack));
		reverse(stack);//对栈进行反转
		System.out.println(stack.toString());
		
		 
	}
	
	

}
