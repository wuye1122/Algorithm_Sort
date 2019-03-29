package com.wuye.String;

public class IsUnque {

	/*
	 *  �ж��ַ����������Ƿ����е��ַ���ֻ����һ��
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
			map[a[i]]=true;//char-->�Զ�ת�������� 
			               //��������ǳ���  
			
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
