package com.wuye.array;

public class GetMaxLengthOfNoOrder2 {

	
	/*  ***
	 *  找出没排序数组里面 小于等于指定数组的最大情况  
	 *  三星题慎重:
	 *  
	 *  
	 *   首先 sum 各个位置的数累加
	 *   
	 *   其次 找到累加到i处最大的情况 --->形参一个有序数组
	 *   
	 *   最后 找>sum-k 在数组里面 使用2分查找
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	public int getMax1(int arr[],int k){
		//首先准备一个辅助数组用于查找使用
		
		int re[]=new int[arr.length+1];
		
		int sum=0;
		re[0]=sum;
		//这个辅助数组 又称左侧最大值数组  且 有序的
		for(int i=0;i<arr.length;i++){
           sum+=arr[i];
		   re[i+1]=Math.max(sum, re[i]);
           
		}
		
		
		sum=0;
		int pre=0;//记录大于那个值得索引
		
		int res=0;//代表最大值
		
		int len=0;//代表此时的子数组的长度
		
		for(int i=0;i<arr.length;i++){
			
			sum+=arr[i];
			pre=getIndex(re,sum-k);
			len=pre==-1?0:i-pre+1;
			res=Math.max(res, len);
		}
		return res;
		
	}
	
	// 2分查找的情况如下。
	
	public int getIndex(int []arr,int k){
		
		int low=0;
		int high=arr.length-1;
		int res=-1;
		int mid=0;
		
		while(low<=high){
			mid=(low+high)/2;
			
			if(arr[mid]>=k){
				res=mid;
				high=mid-1;
			}else{
				low=mid+1;
			}
		}
		return res;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetMaxLengthOfNoOrder2 gg=new GetMaxLengthOfNoOrder2();
	     int [] aa={3,-2,-4,0,6};
	     //3 1 
	System.out.println(gg.getMax1(aa, 0));
	
	
	}

}
