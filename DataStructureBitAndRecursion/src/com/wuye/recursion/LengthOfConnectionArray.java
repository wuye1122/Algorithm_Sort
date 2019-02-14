package com.wuye.recursion;

import java.util.HashMap;

public class LengthOfConnectionArray {
/*
 * 
 *  rescursion 数组里面最长连续的序列(重复只计算一次)
 *  
 *  只有在数组里面能连续上 不一定挨着
 *  
 *  使用哈希表时间复杂度O(N) 空间复杂度O(N)
 * 
 *  map(K,V)
 *  key代表遍历过得某个数  value代表这个数所在的最长连续序列长度
 *  (arr[i],1)--> 记录最小值  和最大值
 * 
 *    
 *  ***关键点:
 * 
 *     3,456 less=3 more=4
 *     int left=less-map.get(less)+1;
 *     
 *     456,7 less=6 more=7
 *     int right=more+map.get(more)-1;
 * 
 * 
 * 
 * 
 * */
	//进行筛选
	public int select(int a[]){
		if(a==null||a.length==0){
			return 0;
		}
		
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		int max=1;
		
		for(int i=0;i<a.length;i++){
			if(!map.containsKey(a[i])){
				map.put(a[i], 1);
			    //每一个值存入之后都要判断是否含有比起小或者大的
			
			    if(map.containsKey(a[i]-1)){
			    	max=Math.max(max, merger(map,a[i]-1,a[i]));
			    	
			    }
			   if(map.containsKey(a[i]+1)){
				   max=Math.max(max, merger(map,a[i],a[i]+1));
				   
				   
			   }
			
			
			}
			
			
			
		}
		return max;
		
		
	}
	
	
	//首先 将新来的一个点和原来连接上  且返回长度
	
	public  int  merger(HashMap<Integer,Integer> map,int less,int more){
		
		int left=less-map.get(less)+1;
		
		int right=more+map.get(more)-1;
		
	    int len=right-left+1;
	    
	    map.put(left, len);
	    
	    map.put(right, len);
	
	return len;
	
	
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LengthOfConnectionArray ll=new LengthOfConnectionArray();
		
		int [] a={100,4,5,6,7,200};
		
		int [] b={1,4,5,6,7,2,3,100};
		
		System.out.println("数组里面最长连续序列");
		System.out.println(ll.select(a));
		System.out.println(ll.select(b));
	}

}
