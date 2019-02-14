package com.wuye.array;

import java.util.HashMap;

public class GetMaxLengthOfNoOrder1 {
	/*
	 * 在未排序的数组中 累加和为指定值的最常数组的问题
	 * 
	 * 1 进阶:将正数数组变成了 可正 可负  可零的数组
	 * 
	 * 
	 * 2 进阶问题:在这个数组里面 正数的和负数的个数相等的最长子数组的长度
	 * 
	 * 
	 * 3 进阶问题:如果这个数组里面全都是0  1那么如何判断
	 * 
	 * 时间复杂度:O(N) 额外空间复杂度(N)
	 * 
	 * 
	 * 
	 * 思路:本题的思路就是: 将每次累加的结果   和对应的i。存入
	 * 
	 * */
	public int getMax(int []arr,int k){
		if(arr.length==0||arr==null){
			return 0;
		}
//	  将数组 正数 负数 0 都分开 试试
//		for(int i=0;i<arr.length;i++){
//			if(arr[i]>0){
//				arr[i]=1;
//				
//			}else if(arr[i]<0){
//				arr[i]=-1;
//			}else{
//				arr[i]=0;
//			}
//		}
		
		
		
		
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		int len=0;
		int sum=0;
		map.put(0, -1);
		// 如果是连续相乘的情况 sum-k=0 此时在map里面需要找到一个0
		//
		
		for(int i=0;i<arr.length;i++){
			
//			if(){
//				
//			}else{
//				
//			}
			sum+=arr[i];
			/*
			 *  每一位的累加结果sum   存入map 里面 
			 *  
			 *  sum-k还是一个累加结果 
			 * 
			 *  使用 [0...i]+[i...j]=[0..j]
			 * 
			 *     map里面的值+k=map里面的值
			 * 
			 * 
			 * 
			 * */
			
			if(map.containsKey(sum-k)){
				len=Math.max(len, i-map.get(sum-k));
				
			}
			if(!map.containsKey(sum)){//真的出现错误了
				//如果不包含的情况
				// 将其压入其中
				map.put(sum, i);
			}
			
		}
		System.out.println(map);
		return len;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		GetMaxLengthOfNoOrder1 gg=new GetMaxLengthOfNoOrder1();
		
//		int [] aa={12,3,4,5,0,-1,-3,2};
//		System.out.println(gg.getMax(aa, 23));
		
		int [] bb={0,1,3,-4,-2,10};
		//0 1 4  -2 -2 8 
		//0,1,3 , -4 -2 10
		System.out.println(gg.getMax(bb, 0));
		
		int [] cc={1,1,0,0,-1,1,-1,1};
		System.out.println(gg.getMax(cc, 0));
	}

}
