package com.wuye.interview;

public class GetMaxSuArray {
    /*
     *  *子数组最大累加和问题
     * 
     *  cur记录当前累加结果   如果为负则清零  如果为正直则继续
     *  
     *  max取的cur前后最大值
     * 
     * 
     * 
     * 
     * 
     * */
	
	public static int getMax(int [] arr){
		if(arr.length==0||arr==null){
			return 0;
		}
		
		int max=Integer.MIN_VALUE;
		//因为在比较的是 如果选择0的话 如有数组前两位是负的则出现错误 
		//所有选择还要小的
		int cur=0;
		
		for(int i=0;i<arr.length;i++){
			
			cur+=arr[i];
			max=Math.max(cur, max);
			cur=cur<0?0:cur;
			
		}
		
		
		
		return max;
		
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int a[]={1,-2,3,5,-2,6,-1};
		System.out.println(getMax(a));
		
	}

}
