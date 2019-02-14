package com.wuye.array;

public class TwoArrays {
   /*
    *  不重复打印 有序数组里面的相加等于指定数的 二元组  和 三元组
    *  
    *  1 二元组 从数组的两端向中间逼近
    *    因为是有序的所以可能出现。重复出现 11……99、、这种情况
    * 
    *  2 三元组可以看成是二元组再加一次 遍历
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * */
	//三元组
	//三元组 看成arr[i][i+1...a.length-1]和一个二元组
	public static void printTree(int arr[],int k){
		if(arr==null||arr.length<3){
			return ;
		}
		
		for(int i=0;i<arr.length-2;i++){
			//向后循环 进行选择 直到倒数第三个 
			if(i==0||arr[i]!=arr[i-1]){
				printTwo1(arr,i,i+1,arr.length-1,k-arr[i]);
				
			}
			
		}
		
		
		
	}
	public  static  void printTwo1(int []arr,int f,int left,int right,int k){
		
		
		
		while(left<right){
			if(arr[left]+arr[right]<k){
				left++;
			}else if (arr[left]+arr[right]>k){
				right--;
				
			}else{
				//如果==0则说明其前两个数相加等于k 否则会出现越界问题
				//类似的 left=f+1
				if(left==f+1||arr[left-1]!=arr[left]){
					System.out.println(arr[f]+","+arr[left]+","+arr[right]);
				}
				left++;
				right--;
			}
			
		}
	}	
	
	//二元组
	public  static  void printTwo(int []arr,int k){
		if(arr==null||arr.length<1){
			return ;
		}
		
		//定义左右指针:
		
		int left=0;
		int right=arr.length-1;
		while(left<right){
			if(arr[left]+arr[right]<k){
				left++;
			}else if (arr[left]+arr[right]>k){
				right--;
				
			}else{
				//如果==0则说明其前两个数相加等于k 否则会出现越界问题
				if(left==0||arr[left-1]!=arr[left]){
					System.out.println(arr[left]+","+arr[right]);
				}
				left++;
				right--;
			}
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		            
		int arr[]={-1,-2,-2,0,1,5,6,7,8,8,9,9};
		
		for(int i=0;i<arr.length-2;i++){
			System.out.print(arr[i]+"_");
		}
		System.out.println("---");
		TwoArrays.printTwo(arr, 6); 
		
		System.out.println("---");
		TwoArrays.printTree(arr, 12);
	}

}
