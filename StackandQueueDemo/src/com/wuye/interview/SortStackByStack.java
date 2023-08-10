package com.wuye.interview;

import java.util.Stack;

public class SortStackByStack {

	/*
	 * 
	 * 
	 * 
	 *  *使用一个栈 和一个变量对一个栈进行排序、、使得old从上到下由大到小
	 *  
	 *  其中help栈顶      比较old栈顶元素
	 *  如果小的话就压入 old  此时old大的栈顶在cur变量处
	 *  
	 *  把小的一次压入 help最终形成 help从上到下 从小到大
	 *  
	 *  
	 *    
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	 
	
	public static void sortStackByStack(Stack<Integer> old){
		Stack<Integer> help=new 	Stack<Integer> ();
		
		
		//只有帮主栈小于原来栈顶    就将所有小于压入老栈 
		 //然后 将变量处的cur压入 help
		 //old--->help
		while(!old.empty()){
			int cur=old.pop();
			while(!help.empty()&&help.peek()<cur){
				old.push(help.pop());
				
			}
			//小的全部折腾到old里面了
			
			help.push(cur);	
		}
		
		while(!help.empty()){
			old.push(help.pop());
			
		}
		
	}
	
	
	
	//最后全部压回原栈
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> old=new Stack<Integer>();
		old.add(3);
		old.add(4);
		old.add(6);
		old.add(5);
		old.add(1);
		old.add(7);
		
		System.out.println("栈里面元素如下"+old.toString());
		sortStackByStack(old);
		System.out.println("排好序的栈如下"+old.toString());
	}

}
