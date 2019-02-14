package com.wuye.String;

public class ReplaceOrModify {

	
	/*
	 *  1 字符串的替换  一个字符串变成三个
	 *  
	 *   字符串最右面一点是一个字符串  其左面若干个空格-->每一个空格都替换成
	 *   ' '-->'%20' 
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
	public char[] replace(char [] cc){
		
		if(cc.length==0||cc==null){
			return null;
			
		}
		
		int num=0;//记录' '的个数
		int len=0;//新的数组的长度
		
		for(len=0;len<cc.length&&cc[len]!=0;len++){
			if(cc[len]==' '){
				num++;
				
			}
			
		}
		
		int j=len+num*2-1;//代表此时新数组的索引最大号
		char [] b=new char[j+1];
		for(int i=len-1;i>-1;i--){
			if(cc[i]!=' '){
				b[j--]=cc[i];//5>原来数组里面的数 假设右面足够大
			}else{           //返回一个字符数组
				
				b[j--]='0';
				b[j--]='2';
				b[j--]='%';
				
				
			}
			
		}
		return b;
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] a={' ','1','3','w'};
		char[] b={' ','1','3','w',' ',' ',' ',' ','a'};
		char[] c={' ',' ',' ','w'};
		System.out.println(String.valueOf(a));
		ReplaceOrModify rr=new ReplaceOrModify();
		System.out.println(String.valueOf(rr.replace(a)));
		System.out.println(String.valueOf(rr.replace(b)));
		System.out.println(String.valueOf(rr.replace(c)));
		
	}

}
