package com.wuye.array;


/*
 * 
 *  1 2 -3
 *  3 7 -9
 *  3 4  5
 * 
 *  关于子数组累加和最大问题 :
 *  
 *  a[]:将没一行 加到一起  叠加的形式   层数递减3 2 1
 * 
 *      最后返回子数组最大max
 * 
 * 
 * 
 * 
 * 
 * 
 * */

 
//一个二维数组  一个矩阵
public class MaxSumMatrix {
	public int getMax(int [][] arr){
		 if(arr==null||arr.length==0||arr[0].length==0){
			 return 0;
		 }
		 
		 
		 //定义一个  只含有一行的数组
		 
		 int sum[]=null;
		 
		 int cur=0;
		 
		 int max=Integer.MIN_VALUE;
		
		
		 //此次循环  0 1 2 表示累加的开始行数
		 for(int i=0;i<arr.length;i++){
			 // i =0   1  2 
			 sum=new int[arr[0].length];
			 //因为三行循环完之后 新建数组
			 //定义的从开始行号开始要往下循环的行数 3
			 for(int j=i;j<arr.length;j++){//i  j写错了
			 cur=0;
				
				 //最后定义的  将每一横排累加起来
				 for(int k=0;k<sum.length;k++){
					
					 sum[k]+=arr[j][k];
					 //sum[0]=arr[0][0] +a[1][0]+a[2][0]
					 //sum[1]=arr[0][1] +a[1][1]+a[2][1]
					 //sum[2]=arr[0][2] +a[1][2]+a[2][2]
					 cur+=sum[k];//记录每一个值
					 
					 max=Math.max(max, cur);
					 
					 cur=cur<0?0:cur;
					 
				 }
				 
			 }
			 
			 
		 }
		return max;
		 
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<6;i++){
			System.out.println(i);
		
			}
		
		System.out.println("-------------------");
		for(int i=0;i!=6;i++){
			System.out.println(i);
		}
		int aa[][]={{-90,48,78},{64,-40,64},{-81,-7,66}};
		MaxSumMatrix mm=new MaxSumMatrix();
	
		System.out.println(mm.getMax(aa));
	    System.out.println("ij写错了 浪费我一个小时");	
	}

}
