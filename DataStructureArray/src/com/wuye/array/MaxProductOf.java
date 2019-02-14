package com.wuye.array;

public class MaxProductOf {

	/*
	 *  子数组最大乘积:
	 *  对于一个 double类型的数组 : 可能有0 1 -1 0.1
	 *  
	 *  存在三种情况： 前一位的最小值 min=-n  * arr[i]<0
	 * 
	 *            前一位最大值max=n   *  arr[i]>0 
	 * 
	 *            本位置的数最大   arr[i]  那一定是前后都有0的情况且arr[i]最大
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	public static double maxProd(double [] a){
		if(a.length==0||a==null){
			return 0;
			
		}
		
		double max=a[0];
		double min=a[0];
		double res=a[0];
		double endMax=0;
		double endMin=0;
		for(int i=1;i<a.length;i++){
			endMax=max*a[i];
			endMin=min*a[i];
			max=Math.max(Math.max(endMax, endMin), a[i]);
			//比较的 此时  三种情况下的 最大值
			min=Math.min(Math.min(endMax, endMin), a[i]);
			res=Math.max(res, max);//比较此次的最大值和  之前最大值
		}
		return res;
		
		
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a[]={1,2,0,12,0,2,4,-0.8};
		double b[]={1,10,-0.7,-10,2,3,0};
		double c[]={1,2,3,4,-5,9,9};
		System.out.println(MaxProductOf.maxProd(a));
		System.out.println(MaxProductOf.maxProd(b));
		System.out.println(MaxProductOf.maxProd(c));
		
	}

}
