package com.wuye.interview;

import java.util.Stack;

/*
 * 利用栈的一种双栈算法思路
 * 
 * 括号 运算符 操作数
 * 
 * 类似: ((7+1)*3))
 * 
 * 操作数压入一个栈里面
 * 
 * 运算符压入一个栈里面
 * 
 * 每次遇到)弹出一个运算符并且弹出响应的操作数 最终将结果压入栈里面
 * 
 * 当处理完所以)时候操作数栈里面仅仅剩下一个数 就是表达式的运算结果
 * 
 *  --- 该方法只针对个位数 +  -  *  /运算  
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


public class Dijkstra {

	public static void main(String [] args){
		
		String  a ="((1+2)/2)*7)";//必须输入空格
		System.out.println(compute(a));
		
	}
	
	//定义计算方法
	
	public static Double compute(String str){
		
		//定义两个栈
		Stack<Double> dou=new Stack<Double>();
		
		Stack<Character> cha=new Stack<Character>();
		
		//将字符串 变成 字符数组
		
		 char[] ch=str.toCharArray();
		for(int i=0;i<ch.length;i++){
			
		  if(ch[i]=='+')cha.push(ch[i]);
		  else if(ch[i]=='-')cha.push(ch[i]);
		  else if(ch[i]=='*')cha.push(ch[i]);
		  else if(ch[i]=='/')cha.push(ch[i]);
		  else if(ch[i]=='(');
		  else if(ch[i]==')'){
			  Double dd=dou.pop();
			  char cc=cha.pop();
			  if(cc=='+')dd=dou.pop()+dd;
			  if(cc=='-')dd=dou.pop()-dd;
			  if(cc=='*')dd=dou.pop()*dd;
			  if(cc=='/')dd=dou.pop()/dd;
			  dou.push(dd);
			  
		  }else{
			//将其余的数字全部压入 doubleStack里面  字符串强转为double
			  dou.push(Double.parseDouble(Character.toString(ch[i])));
			  
		  }
		  
		}
		return dou.pop();	
		

	}	
	
	
	
}
