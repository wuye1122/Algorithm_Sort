package com.wuye.recursion;

public class ChangeMonkeyCoinsUnique {

	/*  
	 *  递归-换钱的最少的货币数 进阶
	 * 
	 * 找钱问题:此题将所有情况均列出来了,使用的时候最大值就是
	 * 
	 *        整个数组的最大之和,不允许外加金币
	 *        
	 *  5 2 3 4 :组成的最大值14
	 *        
	 * dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-a[i]]+1)
	 *                可以重复的此处写的是,dp[i][j-a[i]]+1 
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
	 * 
	 * */
	
	//方法一:和之前都是一样的只不过 比较的不同了
	
	public int minCoin(int []a,int p){
		if(a.length==0||a==null||p<1){
			return -1;
		}
		
		int dp[][]=new int[a.length][p+1];
		int max=Integer.MAX_VALUE;
		
		//首选进行第一行赋值 
		for(int i=1;i<p+1;i++){
			if(i==a[0]){
				dp[0][i]=1;
			}else{
			dp[0][i]=max;
		}
			}
		
		
		//对其他几行进行赋值
		
		int left=0;
		for(int i=1;i<a.length;i++){
			for(int j=1;j<p+1;j++){
				left=max;
				if(j-a[i]>=0&&dp[i-1][j-a[i]]!=max){
					//前面说明 小于你的金钱 不要你出一个
					left=dp[i-1][j-a[i]]+1;
				}
				dp[i][j]=Math.min(dp[i-1][j], left);
			}
			
		}
		System.out.println("---------------");
		for(int b[]:dp){
			for(int c:b){
				System.out.print("-"+c);
		
			}
			System.out.println();
		}
		return dp[a.length-1][p]!=max?dp[a.length-1][p]:-1;
	}

	
	//方法二:空间压缩法
	
	public int minCoin1(int []b,int p){

		
		if(b.length==0||b==null||p<0){
			return -1;
		}
		
		int dp[]=new int[p+1];
		
		int max=Integer.MAX_VALUE;
		
		//队一行进行处理
		for(int i=1;i<p+1;i++){
			if(b[0]==i){
				dp[i]=1;
			}else{
				dp[i]=max;
			}
		}
		
		//对剩余几排进行赋值
		
		int left=0;
		for(int i=1;i<b.length;i++){
			for(int j=p;j>0;j--){//
				//因为前面的计算当前值的时候 需要前面的值进行判断   如果到最后
				//前面值已经被更新了
				//
				left=max;
				if(j-b[i]>=0&&dp[j-b[i]]!=max){
					
				//前面的式子 一定要大于钱数	
					 
					left=dp[j-b[i]]+1;
				}
				dp[j]=Math.min(left, dp[j]);
			}
		}
		
		System.out.println("-----------------------");
		for(int c:dp){
			System.out.print("-"+c);
		}
		
		
		System.out.println("-----------------------");
		return dp[p]!=max?dp[p]:-1;
		
	}
	public static void main(String[] args) {
		ChangeMonkeyCoinsUnique dd=new ChangeMonkeyCoinsUnique();
		int a[]={5,2,3,5};
		// TODO Auto-generated method stub
		
		System.out.println(dd.minCoin(a, 10));
		System.out.println(dd.minCoin1(a, 10));

	}

}
