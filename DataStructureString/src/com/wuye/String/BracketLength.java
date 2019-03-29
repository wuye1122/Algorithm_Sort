package com.wuye.String;

public class BracketLength {

	/*
	 * 
	 * bracket ����
	 * 
	 * 1 ()()()(())
	 *  ���ŵ�ƥ�� �ж������Ƿ�����Ч��
	 * 
	 *  
	 * 2 �������Ч����:��̬�滮  ʱ�临�Ӷ�o(n) �ռ临�Ӷ�o(n)
	 * 
	 * 
	 * 
	 */ 
	//�����������ų���
	
	public int getLength(String str){
		if(str.equals("")||str==null){
			return 0;
			
		}
		
		char aa[]=str.toCharArray();
		int res=0;
		int pre=0;
		int dp[]=new int[str.length()];
		
		for(int i=1;i<aa.length;i++){
			if(aa[i]==')'){
				pre=i-dp[i-1]-1;
				//����iǰ��dp[i-1]�Ǹ�����
				if(pre>=0&&aa[pre]=='('){
					dp[i]=dp[i-1]+2+(pre>0?dp[pre-1]:0);
					//��ƥ���֮ǰ��Ҳ����
					//
					//( )     ( ( ) )
					// pre-1  pre
				}
			}
			res=Math.max(res, dp[i]);
			
			
		}
		return res;
			
			
			
		}
		
		
		
	
	
	
	 
	//�ж������ַ����Ƿ���Ч
	public boolean isValid(String s){
		if(s==null||s.equals("")){
			return false;
		}
		
		int num=0;//��¼�����ŵĸ���
		char ch[]=s.toCharArray();
		for(int i=0;i<s.length();i++){
			if(ch[i]!='('&&ch[i]!=')'){
				return false;//������������ַ�
				
			}if(ch[i]==')'&&--num<0){
				return false;
				
			}
			if(ch[i]=='('){
				num++;
			}
			 
		}
		return num==0;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BracketLength bl=new BracketLength();
		
		
	//	String a="a";
		String b="()(";
		String c="()()(()";
		
		String d="()()(())";
		//String e="()(())";
		String g="()(())";
		String f="(()())";
	System.out.println(bl.isValid(c));
	System.out.println(bl.isValid(b));
	System.out.println(bl.isValid(c));
	System.out.println(bl.isValid(d));
	
	
	
	System.out.println(bl.getLength(c));
	System.out.println(bl.getLength(b));
	System.out.println(bl.getLength(g));
	System.out.println(bl.getLength(f));
	
	
	
	}

}
