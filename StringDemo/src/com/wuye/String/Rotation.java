package com.wuye.String;

public class Rotation {

	/*
	 *  旋转词 类似的s1  s2找到s1开头位置的字母然后往后读-->循环回来
	 *  
	 *           如果包含则证明是旋转词
	 *      
	 *  KMP 算法固定方法 getIndexOf=-1未找到
	 *      找到一个字符里面是否包含另一个字符
	 *  
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	
	
	public static boolean isRotation(String a,String b){
		
		if(a==null||b==null||a.length()!=b.length()){
			return false;
		}
		String s=b+b;
		//return getIndexOf(a,b)=-1;
		return true;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
