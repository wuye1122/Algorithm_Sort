package com.wuye.String;

public class ReplaceOrModify {

	
	/*
	 *  1 �ַ������滻  һ���ַ����������
	 *  
	 *   �ַ���������һ����һ���ַ���  ���������ɸ��ո�-->ÿһ���ո��滻��
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
		
		int num=0;//��¼' '�ĸ���
		int len=0;//�µ�����ĳ���
		
		for(len=0;len<cc.length&&cc[len]!=0;len++){
			if(cc[len]==' '){
				num++;
				
			}
			
		}
		
		int j=len+num*2-1;//�����ʱ���������������
		char [] b=new char[j+1];
		for(int i=len-1;i>-1;i--){
			if(cc[i]!=' '){
				b[j--]=cc[i];//5>ԭ������������� ���������㹻��
			}else{           //����һ���ַ�����
				
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
