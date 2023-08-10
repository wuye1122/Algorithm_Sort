package com.wuye.array;



public class Product {

	
	 /*
	  *  1 不包括本位置 其他位置的累乘
	  *  
	  *   要求时间复杂度O(n)  空间复杂度O(1)
	  *   使用一个除法 总乘积/每一位的元素
	  * 
	  * 
	  *  2 不使用除法如何做到
	  * 
	  *    另一种算法:不允许使用除法
	  *    而是 设定两个数组 一个在指定位置的左面lr[k-1]    rl[k+1] 另一个在指定位置的右侧
	  *                           0*……k-1      k+1*……N-1
	  * 
	  *   k位置的值=lr[k-1]*rl[k+1]
	  *   
	  * */
	//第二种方法
	public int[] product(int [] a){
			
			if(a==null||a.length<2){
				return null;
			}
			
			int [] res=new int[a.length];
			
			//首先指定一个数组  是res[i]=a[i]!
		
			res[0]=a[0];
			for(int i=1;i<a.length;i++){
				res[i]=res[i-1]*a[i];
				
			}
			
			int b=1;
			for(int i=a.length-1;i>0;i--){
				res[i]=res[i-1]*b;
				b*=a[i];
				
				
			}
			res[0]=b;
			return res;

}
	
	
	//第一种方法
	public int[] product1(int [] a){
		
		if(a==null||a.length<2){
			return null;
		}
		
		int [] res=new int[a.length];
		int count =0;
		int all=1;
		for(int i=0;i<a.length;i++){//从0开始
			if(a[i]!=0){
				all *=a[i];
			
			}else{
			count++;
			}
		}
		
		//如果是没有零的情况
		if(count==0){
			for(int i=0;i<a.length;i++){
				res[i]=all/a[i];
				
			}
			
		}
		
		
		//如果是一个零的情况
		
		if(count==1){
			for(int i=0;i<a.length;i++){
			if(a[i]==0){
				res[i]=all;
			}
			 
			}
		}
		return res;
		
		
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		Product pro=new Product();
		
//		int arr[]={0,0,11,2,3,4};
//		int arr1[]={1,0,11,2,3,4};
		int arr2[]={1,2,3,4,5,6};
		
		
		
	//	pro.product1(arr);
	  int []a=pro.product(arr2);
		
	   for(int i=0;i< a.length;i++){
		   System.out.print(a[i]+" ");
		   
	   }
	
		
		
		
	
		
		
	}

}
