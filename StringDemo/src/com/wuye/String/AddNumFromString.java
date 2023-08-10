package com.wuye.String;

public class AddNumFromString {
/*
 *  1 把字符串里面的所有数字都加起来
 *  
 *    --=+  -当负数处理
 * 
 * 
 * 
 * 
 * 
 * */
	
	public static int sumNum(String str){
		if(str==null){
			return 0;
		}
		int res=0;
		
		int num=0;
		
		boolean flag=true;
				
		int cur=0;		
		
		char ch[]=str.toCharArray();
		
		
		//对字符数组进行遍历并且 找出数字  和非数字
		
		for(int i=0;i<str.length();i++){
			
			//对每一位字符进行判断
			cur=ch[i]-'0';//因为从0 1 2 3 4 5开始 只有把前面都减去 才是数字
			
			if(cur<0||cur>9){//如果不是数字
				res+=num;
				num=0;
				//判断符号
				if(ch[i]=='-'){
					//-号一定从第一之后 并且-前面那个还是-
					if(i-1>-1&&ch[i-1]=='-'){
						flag=!flag;
						
					}else{
						flag=false;
					}
					
				}else{
					
					flag=true;
				}
				
				
			}else{
				//如果是数字
				
				num=num*10+(flag?cur:-cur);
			}
			
			
		}
		
		res+=num;
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      char a='a';
      int cur='a'-1;
      int cur1='a'-'0';
      for(char b='0';b<='9';b++){
    	  System.out.println("原来的字符"+b);
    	  System.out.println("字符变成数字"+(int)b);
    	  System.out.println("减了0之后的"+(b-'0'));
    	  
      }
      System.out.println(a);
      System.out.println((int)a);
      System.out.println(cur);
      System.out.println('0');
      System.out.println((int)'0');
      System.out.println(cur1);
      String d="asda13-12aa31weq--10";
      System.out.println("-----------"+AddNumFromString.sumNum(d));
		
	}

}
