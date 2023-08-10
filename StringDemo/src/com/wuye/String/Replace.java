package com.wuye.String;

public class Replace {

	
	/*  
	 *   1 将字符串里面的的Str from字符换成 -->to
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
	//替换
	
	public String replace(String str,String from,String to){
		
		
		if(str==null||from==null||from.equals("")||to.equals("")){
			return str;
			
			
		}
		
		//进行替换 需要将 str from转换进字符数组里面
		char str1[]=str.toCharArray();
		char from1[]=from.toCharArray();
		
		int match=0;//记录每次比较的个数
		
		for(int i=0;i<str1.length;i++){
			
			if(str1[i]==from1[match++]){
				//还的满足所有位数全满足
				if(match==from1.length){
					clear(str1,i,from1.length);
					match=0;//第一轮匹配后设置为0
					
				}
				
			}else{
				match=0;//未能全部匹配
			}
		
		}
		String res="";
		String cur="";
		
		//第二部将上面字符串和下面的连一起来
		for(int i=0;i<str1.length;i++){
			if(str1[i]!=0){
				cur=cur+String.valueOf(str1[i]);
				
			}
			if(str1[i]==0&&(i==0||str1[i-1]!=0)){//从第一个位置 或者 前面不是o
				
				res=res+cur+to;
				cur="";//为了下次非o做准备
			}
			
			
				
			}if(!cur.equals("")){
			
				res=res+cur;
			
		}
		return res;
		
		
		
	}
	
	
	//clear 将指定字符数组的 end往前  len个重复字符变成0
	
	public void clear(char [] ah,int end,int len){
		while(len--!=0){
			ah[end--]=0;
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Replace rr=new Replace();
		System.out.println(rr.replace("asa111f tysar", "sa", "love").replaceAll(" ", ""));
		
		
		
	}

}
