package com.wuye.recursion;

public class Queens {

	/*
	 * 
	 * rescursion  N皇后问题
	 * 
	 *  N*N要摆N个皇后 :且每一横排  每一竖排 每一斜排不允许放皇后
	 * 
	 *  求出N个里面可以摆几个
	 * 
	 * 方法一：使用递归的形式。一个数组record[i]=j
	 * 
	 *       索引代表第i行 j代表第j列  (i,j)--->明确一个皇后位置
	 * 
	 * 
	 * 
	 * 
	 * */
	//int num
	
	public int num(int n){
		if(n<1){
			return 0;
		}
		int record[]=new int[n];
		return process(0,record,n);
	}
	
	
	//定义一个定义 返回结果是 到n处可以放的皇后
	
	public int process(int i,int[]record,int n){
		if(i==n){
			return 1;
			
		}
		int res=0;//记录
		for(int j=0;j<n;j++){
			if(isVaild(record,i,j)){
				record[i]=j;
				res+=process(i+1,record,n);
			}		
		}
		return res;
	}
	
	
	
	//定义isVaild 判断数组ij处是否可以存放皇后
	
	public boolean isVaild(int []record,int i,int j){
		for(int k=0;k<i;k++){
			if((record[k]==j)||Math.abs(k-i)==Math.abs(record[k]-j)){
				return false;
			}
			
		}
		return true;
		
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queens qq=new Queens();
		System.out.println(qq.num(1));
		System.out.println(qq.num(2));
		System.out.println(qq.num(3));
		System.out.println(qq.num(8));
		
	}

}
