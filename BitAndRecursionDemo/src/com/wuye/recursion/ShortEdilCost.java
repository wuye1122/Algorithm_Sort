package com.wuye.recursion;

public class ShortEdilCost {
/*
 * rescursion --- 最小编辑代价
 * 
 * 1 str1---> str2 ic dc rc:插入 删除  替换
 *   
 *   使用动态规划时间复杂度O(M*N)  空间复杂度O(M*N)  
 *   
 *   使用空间压缩法 空间复杂度O(min{m,n}); 
 * 
 *   
 * 2 操作 首先定义一个(M+1)*(N+1)的一个 二维数组
 * 
 *  arr[0][0]=''   
 *  
 *  arr[i][j]:代表str1[0..i-1] --> str2[0..j-1]的最小代价
 * 
 * 
 * 
 * 
 * */
	
	//动态规划:
	public  int getShort1(String str1,String str2,int ic,int dc ,int rc){
		
		char[] ch1=str1.toCharArray();
		
		char[] ch2=str2.toCharArray();
		
		
		int row=ch1.length+1;
		
		int col=ch2.length+1;
		
		int [][]dp=new int[row][col];
		
		
		//对第一列进行赋值  str1转换成' '的代价
		
		for(int i=1;i<row;i++){
			dp[i][0]=dc*i;
			
		}
		
		
		
		//对第一行进行赋值  由' '转换成str2
		for(int j=1;j<col;j++){

			dp[0][j]=ic*j;
		}
		
		//对dp[i][j]进行赋值
		
		for(int i=1;i<dp.length;i++){
			for(int j=1;j<dp[0].length;j++){
				if(ch1[i-1]==ch2[j-1]){
					dp[i][j]=dp[i-1][j-1];
				}else{
					dp[i][j]=dp[i-1][j-1]+rc;
				}
				
				dp[i][j]=Math.min(dp[i][j], dp[i-1][j]+dc);
				dp[i][j]=Math.min(dp[i][j], dp[i][j-1]+ic);
			}
			
		}
		
		System.out.println("");
		for(int [] c:dp){
			for(int d:c){
				System.out.print(d+" ");
				
			}
			System.out.println("");
		}
		
		System.out.println("");
		return dp[row-1][col-1];
		
		
	}
	
	//采用空间压缩法:
	public int getShort2(String str1,String str2,int ic,int dc ,int rc){
		
		
        char[] ch1=str1.toCharArray();
		
		char[] ch2=str2.toCharArray();
		
		
		
		//长短还没弄明白呢？？？？？？？？？？？？？？？？？？
		int longs=ch1.length>=ch2.length?ch1.length:ch2.length;
		
		int shorts=ch1.length<ch2.length?ch1.length:ch2.length;
		
		if(ch1.length<ch2.length){
			int tem=dc;
			dc=ic;
			ic=tem;

		}

		int dp[]=new int[shorts+1];
		
		//这是一排一排的往下面走
		for(int i=1;i<=ch2.length;i++){
			dp[i]=ic*i;
			
		}
		
		//大圈循环
		
		for(int i=1;i<=ch1.length;i++){
			//首先将左上角的元素 存住
			
			int pre=dp[0];
			dp[0]=dc*i;
			for(int j=1;j<=ch2.length;j++){
				int tem=dp[j];
				
				//两字符串长度不一样 index不一样
				if(ch1[i-1]==ch2[j-1]){
					dp[j]=pre;
					
				}else{
					dp[j]=pre+rc;
					
				}
				
				dp[j]=Math.min(dp[j], dp[j-1]+ic);
				dp[j]=Math.min(dp[j], tem+dc);
				pre=tem;
			}
			
			
		}
		for(int c:dp){
			System.out.print(c+",,");
		}
		return dp[ch2.length];
		
	}
		
		
		
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortEdilCost se=new ShortEdilCost();
		
		String str1="ab12cd3";
		String str2="abcdf";
		
	int a=se.getShort1(str1, str2, 5, 3, 2);
	int b=se.getShort2(str1, str2, 5, 3, 2);
		
		System.out.println("---"+b);
		
		
	}

}
