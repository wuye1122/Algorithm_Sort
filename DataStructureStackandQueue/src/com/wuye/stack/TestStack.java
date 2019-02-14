package com.wuye.stack;

import java.util.Arrays;

public class TestStack {

	
	/* 1 堆和栈的区别
	 * 
	 *  栈是为基本类型变量 和 对象的引用变量分配内存空间
	 *  在一段代码里面定义变量为其分配栈内存空间  一旦超过这个变量的作用域
	 *  自动释放空间 该空间可以被其他变量使用 
	 *  
	 *  堆存放  new 创建的对象  数组在堆里面分配的内存
	 * 
	 *  可以在栈里面存入一个等于 对象和数组在堆里面的首地址的变量
	 *  称之为引用变量
	 *  
	 *  通过操作该引用变量就可以操作数组和对象了
	 *  
	 *  
	 *  2 
	 *  
	 *   void push(Object data);
	 *   
	 *   Object pop();
	 *   
	 *   Object peek();
	 *   
	 *   boolean empty();
	 *   
	 *   void clear();
	 *   
	 *   int length()
	 * 
	 *   void resize();对数组进行扩容
	 * 
	 * */
	
   private Object[] ob=new Object[4];
   
   private int size=0;
	
   
   //返回数据长度
   public int length(){
	   return this.size;
   }
   
   
   //扩容
   public void resize(){
	   
	   Object [] ob1=new Object[this.ob.length*2];
	   
	   for(int i=0;i<this.ob.length;i++){
		   ob1[i]=ob[i];
		   ob[i]=null;
		   
	   }
	   ob=ob1;
	   
   }
   
   //压入
   
    public void push(Object data){
    	//数据的长度大于 数组的长度   
    	if(this.size>=this.ob.length){
    		System.out.println("扩容前此时的数组长度是"+this.ob.length);
    		System.out.println("扩容前时候此时的size是"+size);
    		resize();
    		System.out.println("扩容后此时的数组长度是"+this.ob.length);
    		System.out.println("扩容后此时的size是"+size);
    	}
    	//如果等 数据大于 数组长度时候 会出现异常
    	ob[size++]=data;
    	// 0 1 2 3--->索引4 个数5 size代表的个数
    }
   
   //弹出但是不删除
    
    public Object peek(){
    	
    	return ob[size-1];
    	
    }
   //弹出且删除
    
    public Object  pop(){
    	Object old=ob[size-1];//个数 5 索引 4
    	
    	ob[--size]=null;//个数变为4 并将索引为4的赋值null
    	
    	return old;
    	
    	
    	
    }
   //清空
    
    public void clear(){
    	
    	for(int i=0;i<this.ob.length;i++){
    		ob[i]=null;
    	}
    	size=0;
    }
   
   //是否为空
    
    public boolean empty(){
    	
    	return size==0;
    }
	
    //toString
    
    
    public String toString(){
    	
    	return Arrays.toString(ob);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestStack ts=new TestStack();
		
		ts.push("111");
		System.out.println("输出"+ts+ts.size);
		System.out.println("peek"+ts.peek());
		ts.push("鸭头");
		System.out.println("输出"+ts+ts.size);
		System.out.println("peek"+ts.peek());
		ts.push("222");
		System.out.println("输出"+ts+ts.size);
		System.out.println("peek"+ts.peek());
		ts.push("44");
		System.out.println("输出"+ts+ts.size);
		System.out.println("peek"+ts.peek());
		ts.push("55");
		System.out.println("输出"+ts+ts.size);
		System.out.println("peek"+ts.peek());
		System.out.println("pop"+ts.pop());
		System.out.println("pop"+ts.pop());
		System.out.println("pop"+ts.pop());
	    ts.clear();
		System.out.println(ts.empty());
	}

}
