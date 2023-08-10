package com.wuye.recursion;

public class ChangeMonkeyMinCoins {
 
	
	/*  
	 * 递归-换钱的最少的货币数
	 * 
	 * 指定钱数  给出最小的货币数目 时间复杂度和空间复杂度都是O(N*P)
	 * 
	 * 给出的数是不允许重复  2 3 5:其中可以有 给出的8元钱相应的找钱种类
	 *     4*2
	 *     3+5   
	 *     3*2+2
	 * 
	 *   其中最小的是2种 
	 *   
	 *   使用动态规划:
	 *   
	 *   
	 *   dp[i][j]=min{dp[i-1][j] ,d[i][j-a[n]]+1}
	 *  
	 *   可以理解a[n]在a[n]索引处1
	 *              每次相隔a[n]在原来基础上面再加1 
	 * 
	 *   如果a[n-1]能够表示这个钱 
	 *   
	 *     a[n] 表示的一列当中下面所有值表示的就是能够表示  出几个a[n]来表示j元
	 *     
	 *      
	 *    如果第一个元素用了1种    即使 这个数是你的倍数  也需要遵循取最小值的情况  
	 * 
	 * 
	 * 方法二:使用空间压缩法下:空间复杂度变为了O(N)
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	
	//方法一:使用的额外空间是一个矩阵:  
	public int minCoin(int a[],int p){
		if(a.length==0||a==null||p<1){
			return -1;
		}
		
		//首先建立一个 还钱数组
		int dp[][]=new int[a.length][p+1];
		
		int max=Integer.MAX_VALUE;
		
		//首先进行第一行赋值
		
		for(int i=1;i<p+1;i++){
			dp[0][i]=max;//先对其赋值 
			if(i-a[0]>=0&&dp[0][i-a[0]]!=max){
				dp[0][i]=dp[0][i-a[0]]+1;
			}
			
		}
		
		//对其他几排进行赋值
		int left=0;
		for(int i=1;i<a.length;i++){
			for(int j=1;j<p+1;j++){
				left=max;
				//这句话的意思就是  遇到凑倍数的就在前一次的基础上+1
				// 5  1个5元
				// 10 1个5元再加一个5元
				// 15 再前一个基础上再加一个5元变成3个五元
				//
				if(j-a[i]>=0&&dp[i][j-a[i]]!=max){
					left=dp[i][j-a[i]]+1;
				}
				dp[i][j]=Math.min(left,dp[i-1][j]);
				// 一列当中要去最小的  说明  最顶上那个钱数能够使用最小的数进行表示
				//
				//
			}
		
			
		}

		System.out.println("------下面是找钱记录 多次难以理解的找钱矩阵------");
		for(int aa[]:dp){
			for(int b:aa){
				System.out.print(b+"-");
			}
			System.out.println( );
		}
		
		return dp[a.length-1][p]!=max?dp[a.length-1][p]:-1;
		
	}
	
	
	
	//方法二:使用的额外空间是一个数组
	public int minCoin1(int []a,int p){
		if(a.length==0||a==null||p<1){
			return -1;
		}
		
		int dp[]=new int[p+1];
		int max=Integer.MAX_VALUE;
		
		for(int i=1;i<dp.length;i++){
			dp[i]=max;
			if(i-a[0]>=0&&dp[i-a[0]]!=max){
				dp[i]=dp[i-a[0]]+1;
			}
		}
		
		int left=0;
		
		for(int i=1;i<a.length;i++){
			for(int j=1;j<dp.length;j++){
				left=max;
				if(j-a[i]>=0&&dp[j-a[i]]!=max){
					left=dp[j-a[i]]+1;
				}
				dp[j]=Math.min(left, dp[j]);
			}
		}
		System.out.println("------空间压缩法里面最简单的只用一个数组就能实现的------");
		for(int b:dp){
			System.out.print(b+"-");
		}
		System.out.println();
		return dp[dp.length-1]!=max?dp[dp.length-1]:-1;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChangeMonkeyMinCoins dd=new ChangeMonkeyMinCoins();
		int a[]={5,2,3};
		System.out.println("最终的结果:"+dd.minCoin(a, 20));
		System.out.println("--------------------------");
		System.out.println("最终的结果:"+dd.minCoin1(a, 20));
	}

}
