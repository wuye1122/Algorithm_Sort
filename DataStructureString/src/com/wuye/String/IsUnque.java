package com.wuye.String;

public class IsUnque {

	/*
	 *  判断字符数组里面是否所有的字符都只出现一次
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	public boolean isUnque(char []a){
		if(a==null){
			return false;
			
		}
		boolean []map=new boolean[256];
		
		for(int i=0;i<a.length;i++){
			if(map[a[i]]){
				return false;
			}
			map[a[i]]=true;//char-->自动转换成数字 
			               //这个方法非常好  
			
		}
		return true;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsUnque iu=new IsUnque();
		char a[]={'1','2','-','q',' '};
		char b[]={'1','2','1','q',' '};
		System.out.println(iu.isUnque(a));
		System.out.println(iu.isUnque(b));
	}

}
