package com.wuye.array;

public class Sort1 {

	/*
	 * 
	 *  1 自然数数组的排序 1~N个数
	 *  
	 *   最终排序的结构arr[i]=i+1;
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
	public static void sort1(int [] arr){
		int tem=0;
		//将不符合的进行两两交换
		for(int i=0;i<arr.length;i++){
			while(arr[i]!=i+1){
				
				tem=arr[arr[i]-1];
				arr[arr[i]-1]=arr[i];
				arr[i]=tem;
				
				
			}
			
			
		}
		
		
	}
	public  static void sort(int [] arr){
		int tem=0;
		int next=0;
		for(int i=0;i<arr.length;i++){
			tem=arr[i];
			while(arr[i]!=i+1){     //第一遍 1 2 5 4 3
				next=arr[tem-1];
				arr[tem-1]=tem;     //变成 1 2 5 4 5
				 
				tem=next;           //tem=3
				/*
				 * 
				 * 遇到第一个不满足的 就进入一个while里面大循环 
				 * 
				 *  一只转圈 --->直到最后卡住的位置 正好等于i+1时候
				 * 
				 *  因为每次交换之后本位置的数变量  再次循环不会出现死循环
				 * 
				 * 
				 * */
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr={1,2,5,4,3};
		
		
		Sort1.sort1(arr);
		for(int a:arr){
			System.out.println(a);
		}
	}

}
