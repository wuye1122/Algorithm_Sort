package com.wuye.array;

public class DynamicProgramming {
 
	/*rescursion--最长公共子串问题
	 * 
	 *  传说中的动态规划:没有传说中那么难
	 *  
	 *  相当于一个二维矩阵:
	 * 

   		0 1 1 1 1 1 1 1 1 1 1 
		0 1 1 1 1 1 2 2 2 2 2 
		0 1 1 2 2 2 2 2 2 2 2 
		0 1 1 2 2 3 3 3 3 3 3 
		0 1 1 2 3 3 3 3 3 3 3 
		0 1 2 2 3 3 3 3 3 3 3 
		0 1 2 2 3 3 3 4 4 4 4 
		1 1 2 2 3 3 3 4 4 5 5 
		1 1 2 2 3 3 3 4 5 5 5 
		1 1 2 2 3 3 3 4 5 5 5 
		
		
		
		

	 */
	
	//返回最长公共子串
	public String getCommon(String str1,String str2){
		if(str1.equals("")||str2.equals("")||str1==null||str2==null){
			return "";
		}
		
		char []ch1=str1.toCharArray();
		char []ch2=str2.toCharArray();
		int m=ch1.length-1;
		int n=ch2.length-1;
		int dp[][]=getDp(ch1,ch2);
		
		
		//记录最次公共子串的长度
		char [] ch=new char[dp[ch1.length-1][ch2.length-1]];
		int index=ch.length-1;
		
		while(index>=0){
			if(m>0&&dp[m][n]==dp[m-1][n]){
				m--;
			}else if(n>0&&dp[m][n]==dp[m][n-1]){
				n--;
			}else{
				ch[index--]=ch1[m];
				//都减少
				m--;
				n--;
			}
			
		}
		return String.valueOf(ch);
	}
	
	
	
	
	//得到线性规划表
	public int[][] getDp(char [] ch1,char []ch2){
		
		int dp[][]=new int[ch1.length][ch2.length];
		
		
		dp[0][0]=ch1[0]==ch2[0]?1:0;
		
		//第一行
		
		for(int i=1;i<ch2.length;i++){
			dp[0][i]=Math.max(dp[0][i-1], ch1[0]==ch2[i]?1:0);
			
		}
		
		//第一列
		
		for(int i=1;i<ch1.length;i++){
			dp[i][0]=Math.max(dp[i-1][0], ch1[i]==ch2[0]?1:0);
		}
		
		
		//dp[i][j]
		
		for(int i=1;i<ch1.length;i++){
			
			for(int j=1;j<ch2.length;j++){
				dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
				if(ch1[i]==ch2[j]){
					
				dp[i][j]=Math.max(dp[i][j], dp[i-1][j-1]+1);	
				}
			}
		}
		return dp;
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicProgramming dd=new DynamicProgramming();
		String str1="1A2C3D4B56";
		String str2="B1D23CA45B6A";
		
		int aa[][]=dd.getDp(str1.toCharArray(), str2.toCharArray());
		
		for(int [] a:aa){
			for(int b:a){
				System.out.print(b+" ");
			}
			System.out.println();
		}
		
		
		System.out.println(dd.getCommon(str1, str2));
	}

}
