package com.wuye.String;

public class Rotation {

	/*
	 *  ��ת�� ���Ƶ�s1  s2�ҵ�s1��ͷλ�õ���ĸȻ�������-->ѭ������
	 *  
	 *           ���������֤������ת��
	 *      
	 *  KMP �㷨�̶����� getIndexOf=-1δ�ҵ�
	 *      �ҵ�һ���ַ������Ƿ������һ���ַ�
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
