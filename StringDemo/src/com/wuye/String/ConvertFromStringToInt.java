package com.wuye.String;

public class ConvertFromStringToInt {

	
	/*
	 *   将一个含义数字的字符串传换成数字。
	 * 
	 *   需要考虑几种不满足的情况。
	 *   
	 *   
	 *   1 -0 -
	 *   2 021 01
	 *   3 123wdq
	 * 
	 *  需要判断是否越界 31位 负数比正数多一位 因此 都化成负数
	 * 
	 * 
	 * 
	 * */
	
	public boolean isVaild(char []ch){
		if(ch[0]!='-'&&(ch[0]<'0'||ch[0]>'9')){
			return false;
			
		}
		if(ch[0]=='-'&&(ch.length==1||ch[1]=='0')){
			return false;
			
		}
		if(ch[0]=='0'&&ch.length>1){
		
		return false;}
		for(int i=1;i<ch.length;i++){
			if(ch[i]<'0'||ch[i]>'9'){
				
				return false;
			}
			
			
		}
		return true;
		
	}
	
	
	public int Convert(String str){
		
		if(str==null||str.equals(" ")){
			return 0;
			
		}
		char ch[]=str.toCharArray();
		
		
		//如果不满足
		
		if(!isVaild(ch)){
			return 0;//说明不满足
		}
		
		
		int minp=Integer.MIN_VALUE/10;
		int amin=Integer.MIN_VALUE%10;
		boolean pos=ch[0]=='-'?false:true;
		int res=0;
		int cur=0;
		
		for(int i=pos?0:1;i<ch.length;i++){//如果正数从第一位开始  如果负数从第二位开始
			
			cur='0'-ch[i];
			
			if((res<minp)||(res==minp&&cur<amin)){
				
				return 0;
			}
			
			res=res*10+cur;//此时这个是个负的
			
			if(pos&&res==Integer.MIN_VALUE){
				return 0;
				
			}
			
			
			
		}
		return pos?-res:res;
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConvertFromStringToInt cf=new ConvertFromStringToInt();
		String a="131";
		String b="-";
		String c="-0";
		String d="1w";
		String e="00";
		String f="0";
	//	String g=String.valueOf(Integer.MAX_VALUE+1);自动进行一圈循环
		String h="-2147483648";
	    String g="2147483647";
	    String i="-2147483649";
	    String j="2147483648";
		System.out.println(g+"  "+h);
		System.out.println(cf.Convert(a));
		System.out.println(cf.Convert(b));
		System.out.println(cf.Convert(c));
		System.out.println(cf.Convert(d));
		System.out.println(cf.Convert(e));
		System.out.println(cf.Convert(f));
		System.out.println(cf.Convert(g));
		System.out.println(cf.Convert(h));
		System.out.println(cf.Convert(i));
		System.out.println(cf.Convert(j));
		
		for(char aa='a';aa<='j';++aa){
			System.out.println(aa);
		}
		
	}

}
