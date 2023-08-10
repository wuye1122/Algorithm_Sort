package com.wuye.recursion;

public class LengthOfCharacterSame {

	/*
	 * rescursion-最长公共子串问题 必须挨着
	 * 
	 * 1 首先使用动态规划计算出 dp[][]
	 * 
	 * 
	 * 2 第二种方法就是斜着的形式 从右上角到左下角 一排一排
	 * 
	 *  每一排有事从左上到右下
	 * 
	 * */
	
	
	//第二种方法:
	public String same1(String str1,String str2){
		
		char [] ch1=str1.toCharArray();
		
		char [] ch2=str2.toCharArray();
		
		//记录开始的行
		int row=0;//0000123
		
		int col=ch2.length-1;//3210000
		
		int end=0;
		
		int max=0;
		while(row<str1.length()){
			int i=row;
			
			int j=col;
			
			int len=0;
			//每一邪派
			while(i<str1.length()&&j<str2.length()){
				
				 if(ch1[i]!=ch2[j]){
					 len=0;
					 
				 }else{
					 
					 len++;
				 }
				 //记录最大值
				 if(len>max){
					end=i;
				    max=len;
					 
				 }
				i++;
				j++;
				
			}
			if(col>0){
				col--;
				
			}else{
				row++;
				
			}
			
			
			
		}
		
		
		return str1.substring(end-max+1,end+1 );
		
		
		
		
		
	}
	
	
	
    //获取dp[][]数列	
	public int [][] getDp(char []ch1,char[]ch2){
		
		int dp[][] =new int[ch1.length][ch2.length];
		
		
		//首先对第一列赋值
		
		for(int i=0;i<ch1.length;i++){
			if(ch1[i]==ch2[0]){
				
				dp[i][0]=1;//每次相等都相当于一个新起点
				
				//如果这一列全部是1  那么 最长的也是1 
			}
			
		}
		
		//对第一行
		for(int j=1;j<ch2.length;j++){
			if(ch2[j]==ch1[0]){
				
				dp[0][j]=1;//每次相等都相当于一个新起点
				
				//如果这一列全部是1  那么 最长的也是1 
			}
			
		}
		
		
		for(int i=1;i<ch1.length;i++){
			for(int j=1;j<ch2.length;j++){
				if(ch1[i]==ch2[j]){
					dp[i][j]=dp[i-1][j-1]+1;
					
				}
				
			}
	
		}
		return dp;
	}

     //获取最终的字符串
	public String same(String str1,String str2){
		char[] st1=str1.toCharArray();
		char[] st2=str2.toCharArray();
		int dp[][]=getDp(st1,st2);
		int end=0;
		
		int max=0;
		
		for(int i=0;i<st1.length;i++){
			for(int j=0;j<st2.length;j++){
				if(dp[i][j]>max){
					end=i;
					max=dp[i][j];
				}
				
			}
			
			
		}
		return str1.substring(end-max+1,end+1 );
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LengthOfCharacterSame ll=new LengthOfCharacterSame();
		
		String aa="advgghu";
		String bb="gghuasd";
		
		int [][]dp=ll.getDp(aa.toCharArray(), bb.toCharArray());
		
		for(int [] a:dp){
			for(int b:a){
				System.out.print(b);
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("两个字符串公有的是"+ll.same("advgghu", "gghuasd"));
		
		System.out.println("走斜线两个字符串公有的是"+ll.same1("advgghu", "gghuasd"));
		
	}

}
