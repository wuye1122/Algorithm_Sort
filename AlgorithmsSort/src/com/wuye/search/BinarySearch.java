package com.wuye.search;

import java.util.Arrays;

public class BinarySearch {

	public int binary(int key,int []arry){
		int lo=0;
		int li=arry.length-1;
		
		while(lo<=li){
			//int mid=lo+(li-lo)/2;
			
			//������ǲ�ֵ����
			/*
			 *  ʱ�临�Ӷ�:O(logN)
			 *  ���ڱ�Ƚϳ� �ؼ��ֲַ�������˵ ���ֺ��� �۰����
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
			//���ֲ���һ��Ҫ
		    Arrays.sort(arry);
			int index=new BinarySearch().binary(3, arry);
			
			System.out.println("��Ҫ���ҵ�3��:arry["+index+"]");
			
			
	}

}
