package com.wuye.String;

public class NewPointChar {

	
	/*
	 *  һ�����͵Ĺ涨 ֻ���� Сд�ַ�  ��д��д  ��дСд��һ������
	 *  
	 *   a d s f  AS DF VB Ds Hk Kj
	 *   
	 *   ָ��ĳ������ Ȼ��ô��������ַ�
	 *   
	 *   1 ͳ��K-1--0�ڼ�Ĵ�д��ĸ�ĸ���
	 *   
	 *    ���������---> k-1,k
	 *    �����ż��--->k��Ϊ��д k,k+1
	 *           --->kΪСд k
	 *      
	 *   
	 * 
	 * 
	 * */
	private boolean isUpper(char c) {
		// TODO Auto-generated method stub
		return c>='A'&&c<='Z';
	}
	public String ponitNew(String s,int index){
		
		if(s.equals(" ")||s==null||index<0||index>s.length()){
			return "";
		}
		
		char [] ch=s.toCharArray();
		int num=0;
		
		
		
		//ͳ�ƴ�д��ĸ������
		
	  for(int i=index-1;i>=0;i--){
		if(!isUpper(ch[i])){
			break;
		}
		num++;
	    }
		
	  
	
	 if((num&1)==1){//֤����ż��
		 
		 return s.substring(index-1, index+1);
	 }
	//������ż��
	 if(isUpper(ch[index])){
		 return s.substring(index, index+2);
		 
	 }
	//
	 return String.valueOf(ch[index]);
	
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewPointChar nn=new NewPointChar();
 String a="aaaAaAABa";
 

 System.out.println("������Aa---"+nn.ponitNew(a, 3));
 System.out.println("���ĸ�Aa---"+nn.ponitNew(a, 4));
 System.out.println(nn.ponitNew(a, 5));
 System.out.println(nn.ponitNew(a, 6));
 System.out.println(nn.ponitNew(a, 7));
 System.out.println(nn.ponitNew(a, 8));
	}

}
