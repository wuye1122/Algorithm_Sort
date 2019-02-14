package com.wuye.search;

import java.util.Arrays;

public class BinarySearch {

	public int binary(int key,int []arry){
		int lo=0;
		int li=arry.length-1;
		
		while(lo<=li){
			//int mid=lo+(li-lo)/2;
			
			//下面的是插值查找
			/*
			 *  时间复杂度:O(logN)
			 *  对于表比较长 关键字分布均匀来说 这种好于 折半查找
			 * 
			 * */
			int mid=lo+(li-lo)*(key-arry[lo])/(arry[li]-arry[lo]);
			if(key<arry[mid]){
				li=mid-1;
				
			}else if(key>arry[mid]){
				lo=mid+1;
			}else{
				return mid;
			}
			
		}
		return -1;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int []arry={1,2,34,5,7,90,3,51,17};
			//二分查找一定要
		    Arrays.sort(arry);
			int index=new BinarySearch().binary(3, arry);
			
			System.out.println("你要查找的3在:arry["+index+"]");
			
			
	}

}
