package com.wuye.array;

public class GetNoOrderArryas {

	
	/*
	 *   1 3 4 2 5 6
	 *   
	 *   返回一个数组需要的排序的最短长度  
	 * 
	 *  选择最右侧值进行向左遍历  找到>右侧的 记录下来            noMin
	 * 
	 *  选择最左侧值进行向右遍历  找到<右侧的 记录下来 最后结果 noMax
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
	
	
	public int getShort(int arr[]){
		
		if(arr.length<2||arr==null){
			return 0;
		}
		
		int noMin=-1;
		int min=arr[arr.length-1];//选择最右侧进行比较
		for(int i=arr.length-2;i!=-1;i--){//=-1循环就停了
			
			if(arr[i]>min){
				noMin=i;
			}else{
				min=Math.min(min, arr[i]);
			}
	
			
		}
		
		if(noMin==-1){
			return 0;//数目数组是有序的
		}
		
		int max=arr[0];
		int noMax=-1;
		
    for(int i=1;i!=arr.length;i++){//=-1循环就停了
			
			if(arr[i]<max){
				noMax=i;
			}else{
				max=Math.max(max, arr[i]);
			}
	
			
		}
	return noMax-noMin+1;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] a={1,2,3,4,5,6,7};
		int [] b={1,3,2,4,6,5,7};
		int [] c={7,2,3,4,5,6,1};
		GetNoOrderArryas gg=new GetNoOrderArryas();
		System.out.println(gg.getShort(a));
		System.out.println(gg.getShort(b));
		System.out.println(gg.getShort(c));
		
	}

}
