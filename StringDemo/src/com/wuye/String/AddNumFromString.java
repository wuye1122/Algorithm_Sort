package com.wuye.String;

public class AddNumFromString {
/*
 *  1 ���ַ���������������ֶ�������
 *  
 *    --=+  -����������
 * 
 * 
 * 
 * 
 * 
 * */
	
	public static int sumNum(String str){
		if(str==null){
			return 0;
		}
		int res=0;
		
		int num=0;
		
		boolean flag=true;
				
		int cur=0;		
		
		char ch[]=str.toCharArray();
		
		
		//���ַ�������б������� �ҳ�����  �ͷ�����
		
		for(int i=0;i<str.length();i++){
			
			//��ÿһλ�ַ������ж�
			cur=ch[i]-'0';//��Ϊ��0 1 2 3 4 5��ʼ ֻ�а�ǰ�涼��ȥ ��������
			
			if(cur<0||cur>9){//�����������
				res+=num;
				num=0;
				//�жϷ���
				if(ch[i]=='-'){
					//-��һ���ӵ�һ֮�� ����-ǰ���Ǹ�����-
					if(i-1>-1&&ch[i-1]=='-'){
						flag=!flag;
						
					}else{
						flag=false;
					}
					
				}else{
					
					flag=true;
				}
				
				
			}else{
				//���������
				
				num=num*10+(flag?cur:-cur);
			}
			
			
		}
		
		res+=num;
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      char a='a';
      int cur='a'-1;
      int cur1='a'-'0';
      for(char b='0';b<='9';b++){
    	  System.out.println("ԭ�����ַ�"+b);
    	  System.out.println("�ַ��������"+(int)b);
    	  System.out.println("����0֮���"+(b-'0'));
    	  
      }
      System.out.println(a);
      System.out.println((int)a);
      System.out.println(cur);
      System.out.println('0');
      System.out.println((int)'0');
      System.out.println(cur1);
      String d="asda13-12aa31weq--10";
      System.out.println("-----------"+AddNumFromString.sumNum(d));
		
	}

}
