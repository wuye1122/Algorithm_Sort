package com.wuye.bit;



public class Bit {
 
	/* 1 关于位运算  n&(n-1)统计1的个数
	 * 
	 *          n&(n+1)统计0的个数
	 *            
	 * 
	 * &:串联电路  
	 * 
	 *   8&9:按位与运算 每一位都这么计算 
	 * 
	 *   n&(n-1) :统计1的个数 自己举个例子每次运算一次 少一个1
	 *   n&(n+1) :统计0的个数 
	 * 
	 * 
	 * 
	 * */
	public int fun(int x){
		int count=0;
		while(x!=0){//在c++里面 while(i)
			count++;
			x=x&(x-1);
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bit bb=new Bit();
		System.out.println(bb.fun(2015));
	
		
		int h=2015;
		System.out.println(h&(h-1));
		System.out.println("2015里面含有1的个数:"+Integer.toBinaryString(2015));
		System.out.println("2014里面含有1的个数:"+Integer.toBinaryString(2014));
		System.out.println("2013里面含有1的个数:"+Integer.toBinaryString(2013));
		System.out.println("2012里面含有1的个数:"+Integer.toBinaryString(2012));
		System.out.println("3里面含有1的个数:"+Integer.toBinaryString(3));
		System.out.println("2里面含有1的个数:"+Integer.toBinaryString(2));
		System.out.println("1里面含有1的个数:"+Integer.toBinaryString(1));
		System.out.println("2015&2014------:"+Integer.toBinaryString(2015&2014));
		System.out.println("2014&2013------:"+Integer.toBinaryString(2014&2013));
		System.out.println("2013&2012------:"+Integer.toBinaryString(2013&2012));
		System.out.println("3&2------:"+Integer.toBinaryString(3&2));
		System.out.println("2&1------:"+Integer.toBinaryString(2&1));
		System.out.println("1&0-----:"+Integer.toBinaryString(1&0));
		
		
		
		System.out.println(1&1);
		System.out.println(1&0);
		System.out.println(0&0);
		
	}

}
