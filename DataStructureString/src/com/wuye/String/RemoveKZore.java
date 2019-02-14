package com.wuye.String;

public class RemoveKZore {

	/*
	 * 
	 *   将字符串里面连续出现k个oo的地方删除
	 * 
	 *   最后的空格删除不了。
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	public  String removerKZore(String str,int k){
		
		if(str==null||k<1||k>str.length()){
			return str;
			
		}
		char ch[]=str.toCharArray();
		
		//首先 count记录连续出现O的次数  start记录连续的开头位置
		int count=0;
		int start=-1;
		for(int i=0;i<ch.length;i++){
			if(ch[i]=='o'){
			count++;
			start=start==-1?i:start;
				
			//如果最后一次记录之后 不在进入else里面需要单写一次
			}
				else{
					if(count==k){
						//将其清除
						while(count--!=0){
							ch[start++]=0;
						}
					}
						count=0;
						start=-1;
					}
				
				
			}
			
			if(count==k){
				//将其清除
				while(count--!=0){
					ch[start++]=0;
				  }
			}
			
			return String.valueOf(ch);
		
			
		}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveKZore rr=new RemoveKZore();
		 String b="oo0oo0daoooodf2o";
		 System.out.println(String.valueOf(b));
		// RemoveKZore.removerKZore(b, 1);	
		 System.out.println("1---"+rr.removerKZore(b, 1));
		
		 System.out.println("2---"+rr.removerKZore(b, 2).trim());
		
		 System.out.println("4---"+ rr.removerKZore(b, 4));
		 
		 System.out.println("4---"+ rr.removerKZore(b, 4).replaceAll(" ", ""));
		//如果是0的情况 在字符数组里面是空格	 
		 String d="   assa  ee";
		 System.out.println(d.trim());//出去首尾空格
		System.out.println(d.replaceAll(" ", ""));
		 
	}

}
