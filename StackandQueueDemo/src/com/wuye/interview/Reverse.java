package com.wuye.interview;

import java.util.Stack;

public class Reverse {
  /*  ** ֻ���õݹ麯��ʵ�ֲ���ʹ���������ݽṹ
   *  ���ʹ��һ��ջ�� һ���ݹ麯�����������ջ
   * 
   * ��ʼ                                 reverse��ת�� 
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
	
    //��ջ��Ԫ�ط��ز����Ƴ�	

	public static int getAndRemoveLastElement(Stack<Integer> stack){
		
		int result=stack.pop();//��ȡջ��Ԫ�� ״̬
		if(stack.empty()){
			
			return result;
		}else{
			
			int last=getAndRemoveLastElement(stack);
			//��ȥ��ʱ�� ջ��Ԫ���Ѿ�û����  result���� 4 3 2 1 
			
			stack.push(result);
			//if ����һ��Ԫ�ص�ʱ��
			//   ��������һ��״̬ Ϊ�շ���
			//
			//else>= һ��Ԫ��
			//    ʵ���Ϸ��ص���last
			//
			//
			return last;
			
		}
	}
      public static void  reverse(Stack<Integer> stack){
	
	   if(stack.empty()){
		return;
	   }
	
	
	int l=getAndRemoveLastElement(stack);//��ȡջ�ײ���Ԫ��
	//ÿ�εݹ� �ֱ��ȡ 1 2 3 4 5
	//
	//
	   reverse(stack);
	 //ѹ��վ��˳���෴  
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
		reverse(stack);//��ջ���з�ת
		System.out.println(stack.toString());
		
		 
	}
	
	

}
