package com.wuye.array;

public class OddAndEven {

	/*  
	 * 保证奇数下标都是奇数 偶数下标都是偶数。
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	
	public void modify(int arr[]){
		
		if(arr.equals("")||arr==null){
			return;
		}
		
		int even=0;
		int odd=1;
		int end=arr.length-1;
		
		while(even<=end&&odd<=end){
			if((arr[end]&1)==0){//如果最后一位是偶数
				
				swap(arr,even,end);
				even+=2;
				
			}else{
				
				swap(arr,odd,end);
				odd+=2;
			}
			
		}
		
	}
	
	public void swap(int arr[] ,int i,int j){
		
		int tem=arr[i];
		arr[i]=arr[j];
		arr[j]=tem;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]={21,34,7,6,1,8,0,9};
		int arr1[]={21,34,6,8,0};
		OddAndEven oo=new OddAndEven();
		oo.modify(arr1);
		oo.modify(arr);
		
		for(int a:arr1){
			System.out.print(a+"--");
		}
		System.out.println("--------------");
		for(int b:arr){
			System.out.print(b+"--");
		}
		
	}

}
