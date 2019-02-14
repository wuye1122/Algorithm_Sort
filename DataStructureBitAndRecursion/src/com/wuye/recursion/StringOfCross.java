package com.wuye.recursion;

public class StringOfCross {
  /*
   *  rescurtion---字符串的交错组合
   *  
   *  1  str1=AB   str2=12
   *  
   *     返回A(4,4)/4 AB的顺序二分之一   12的顺序的二分之一
   *     
   *     判断一个字符串是否是另两个的交错组合
   *     
   *  经典解法:动态规划
   *  
   *     
   *     
   *  时间压缩法:   
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
   * 
   */
	
	
	//经典的动态规划
	public boolean isCross(String str1,String str2,String aim){
		
		char []ch1=str1.toCharArray();
		char[]ch2=str2.toCharArray();
		char []aim1=aim.toCharArray();
		
		if(aim1.length!=ch1.length+ch2.length){
			return false;
		}
		
		//定义一个 boolean数组
		
		boolean[][] dp=new boolean[ch1.length+1][ch2.length+1];
		
		//进行循环
		
		dp[0][0]=true;
		for(int i=1;i<=ch1.length;i++){
			if(ch1[i-1]!=aim1[i-1]){
				break;
				
			}
			dp[i][0]= true;
		}
		for(int j=1;j<=ch2.length;j++){
			if(ch2[j-1]!=aim1[j-1]){
				break;
				
			}
			dp[0][j]= true;
		}
		
		for(int i=1;i<=ch1.length;i++){
			
			for(int j=1;j<=ch2.length;j++){
				
				if((ch1[i-1]==aim1[i+j-1]&&dp[i-1][j])||
						(ch2[j-1]==aim1[i+j-1]&&dp[i][j-1])){
					dp[i][j]=true;
					
				}
				
			}
		}
		return dp[ch1.length][ch2.length];
		
	}
	
	//采用时间压缩法
	
	public boolean isCross1(String str1,String str2,String aim){
		
		char []ch1=str1.toCharArray();
		char[]ch2=str2.toCharArray();
		char []aim1=aim.toCharArray();
		
		int longs=ch1.length>=ch2.length?ch1.length:ch2.length;
		int shorts=ch1.length<ch2.length?ch1.length:ch2.length;

		
		if(aim1.length!=ch1.length+ch2.length){
			return false;
		}
		
		//定义一个 boolean数组
		
		boolean[] dp=new boolean[ch2.length+1];
		
		//进行循环
		
		dp[0]=true;
		for(int i=1;i<=shorts;i++){
			if(ch2[i-1]!=aim1[i-1]){
				break;
				
			}
			dp[i]= true;
		}
		
		
		for(int i=1;i<=longs;i++){
			dp[0]=dp[0]&&ch1[i-1]==aim1[i-1];
			for(int j=1;j<=shorts;j++){
				
				if((ch1[i-1]==aim1[i+j-1]&&dp[j])||
						(ch2[j-1]==aim1[i+j-1]&&dp[j-1])){
					dp[j]=true;
					
				}else{
					dp[j]=false;
				}
				
			}
		}
		return dp[ch2.length];
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringOfCross sc=new StringOfCross();
		System.out.println(sc.isCross1("AB", "12", "AB12"));
		System.out.println(sc.isCross1("AB", "12", "A12B"));
		System.out.println(sc.isCross1("AB", "12", "12AB"));
		System.out.println(sc.isCross1("AB", "12", "1AB2"));
		System.out.println(sc.isCross1("AB", "12", "1A2B"));
		System.out.println(sc.isCross1("AB", "12", "A1B2"));
		System.out.println(sc.isCross1("AB", "12", "1BA2"));
	}

}
