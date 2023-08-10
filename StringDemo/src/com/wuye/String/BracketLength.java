package com.wuye.String;

public class BracketLength {

	/*
	 * 
	 * bracket 括号
	 * 
	 * 1 ()()()(())
	 *  括号的匹配 判断括号是否是有效的
	 * 
	 *  
	 * 2 返回最长有效长度:动态规划  时间复杂度o(n) 空间复杂度o(n)
	 * 
	 * 
	 * 
	 */ 
	//返回最大的括号长度
	
	public int getLength(String str){
		if(str.equals("")||str==null){
			return 0;
			
		}
		
		char aa[]=str.toCharArray();
		int res=0;
		int pre=0;
		int dp[]=new int[str.length()];
		
		for(int i=1;i<aa.length;i++){
			if(aa[i]==')'){
				pre=i-dp[i-1]-1;
				//代表i前面dp[i-1]那个索引
				if(pre>=0&&aa[pre]=='('){
					dp[i]=dp[i-1]+2+(pre>0?dp[pre-1]:0);
					//把匹配的之前的也加上
					//
					//( )     ( ( ) )
					// pre-1  pre
				}
			}
			res=Math.max(res, dp[i]);
			
			
		}
		return res;
			
			
			
		}
		
		
		
	
	
	
	 
	//判断括号字符串是否有效
	public boolean isValid(String s){
		if(s==null||s.equals("")){
			return false;
		}
		
		int num=0;//记录左括号的个数
		char ch[]=s.toCharArray();
		for(int i=0;i<s.length();i++){
			if(ch[i]!='('&&ch[i]!=')'){
				return false;//如果是是其他字符
				
			}if(ch[i]==')'&&--num<0){
				return false;
				
			}
			if(ch[i]=='('){
				num++;
			}
			 
		}
		return num==0;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BracketLength bl=new BracketLength();
		
		
	//	String a="a";
		String b="()(";
		String c="()()(()";
		
		String d="()()(())";
		//String e="()(())";
		String g="()(())";
		String f="(()())";
	System.out.println(bl.isValid(c));
	System.out.println(bl.isValid(b));
	System.out.println(bl.isValid(c));
	System.out.println(bl.isValid(d));
	
	
	
	System.out.println(bl.getLength(c));
	System.out.println(bl.getLength(b));
	System.out.println(bl.getLength(g));
	System.out.println(bl.getLength(f));
	
	
	
	}

}
