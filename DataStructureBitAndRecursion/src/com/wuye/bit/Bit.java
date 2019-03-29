package com.wuye.bit;



public class Bit {
 
	/* 1 ����λ����  n&(n-1)ͳ��1�ĸ���
	 * 
	 *          n&(n+1)ͳ��0�ĸ���
	 *            
	 * 
	 * &:������·  
	 * 
	 *   8&9:��λ������ ÿһλ����ô���� 
	 * 
	 *   n&(n-1) :ͳ��1�ĸ��� �Լ��ٸ�����ÿ������һ�� ��һ��1
	 *   n&(n+1) :ͳ��0�ĸ��� 
	 * 
	 * 
	 * 
	 * */
	public int fun(int x){
		int count=0;
		while(x!=0){//��c++���� while(i)
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
		System.out.println("2015���溬��1�ĸ���:"+Integer.toBinaryString(2015));
		System.out.println("2014���溬��1�ĸ���:"+Integer.toBinaryString(2014));
		System.out.println("2013���溬��1�ĸ���:"+Integer.toBinaryString(2013));
		System.out.println("2012���溬��1�ĸ���:"+Integer.toBinaryString(2012));
		System.out.println("3���溬��1�ĸ���:"+Integer.toBinaryString(3));
		System.out.println("2���溬��1�ĸ���:"+Integer.toBinaryString(2));
		System.out.println("1���溬��1�ĸ���:"+Integer.toBinaryString(1));
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
