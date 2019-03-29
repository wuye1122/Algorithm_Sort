package com.wuye.recursion;

public class LengthOfCharacterSame {

	/*
	 * rescursion-������Ӵ����� ���밤��
	 * 
	 * 1 ����ʹ�ö�̬�滮����� dp[][]
	 * 
	 * 
	 * 2 �ڶ��ַ�������б�ŵ���ʽ �����Ͻǵ����½� һ��һ��
	 * 
	 *  ÿһ�����´����ϵ�����
	 * 
	 * */
	
	
	//�ڶ��ַ���:
	public String same1(String str1,String str2){
		
		char [] ch1=str1.toCharArray();
		
		char [] ch2=str2.toCharArray();
		
		//��¼��ʼ����
		int row=0;//0000123
		
		int col=ch2.length-1;//3210000
		
		int end=0;
		
		int max=0;
		while(row<str1.length()){
			int i=row;
			
			int j=col;
			
			int len=0;
			//ÿһа��
			while(i<str1.length()&&j<str2.length()){
				
				 if(ch1[i]!=ch2[j]){
					 len=0;
					 
				 }else{
					 
					 len++;
				 }
				 //��¼���ֵ
				 if(len>max){
					end=i;
				    max=len;
					 
				 }
				i++;
				j++;
				
			}
			if(col>0){
				col--;
				
			}else{
				row++;
				
			}
			
			
			
		}
		
		
		return str1.substring(end-max+1,end+1 );
		
		
		
		
		
	}
	
	
	
    //��ȡdp[][]����	
	public int [][] getDp(char []ch1,char[]ch2){
		
		int dp[][] =new int[ch1.length][ch2.length];
		
		
		//���ȶԵ�һ�и�ֵ
		
		for(int i=0;i<ch1.length;i++){
			if(ch1[i]==ch2[0]){
				
				dp[i][0]=1;//ÿ����ȶ��൱��һ�������
				
				//�����һ��ȫ����1  ��ô ���Ҳ��1 
			}
			
		}
		
		//�Ե�һ��
		for(int j=1;j<ch2.length;j++){
			if(ch2[j]==ch1[0]){
				
				dp[0][j]=1;//ÿ����ȶ��൱��һ�������
				
				//�����һ��ȫ����1  ��ô ���Ҳ��1 
			}
			
		}
		
		
		for(int i=1;i<ch1.length;i++){
			for(int j=1;j<ch2.length;j++){
				if(ch1[i]==ch2[j]){
					dp[i][j]=dp[i-1][j-1]+1;
					
				}
				
			}
	
		}
		return dp;
	}

     //��ȡ���յ��ַ���
	public String same(String str1,String str2){
		char[] st1=str1.toCharArray();
		char[] st2=str2.toCharArray();
		int dp[][]=getDp(st1,st2);
		int end=0;
		
		int max=0;
		
		for(int i=0;i<st1.length;i++){
			for(int j=0;j<st2.length;j++){
				if(dp[i][j]>max){
					end=i;
					max=dp[i][j];
				}
				
			}
			
			
		}
		return str1.substring(end-max+1,end+1 );
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LengthOfCharacterSame ll=new LengthOfCharacterSame();
		
		String aa="advgghu";
		String bb="gghuasd";
		
		int [][]dp=ll.getDp(aa.toCharArray(), bb.toCharArray());
		
		for(int [] a:dp){
			for(int b:a){
				System.out.print(b);
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("�����ַ������е���"+ll.same("advgghu", "gghuasd"));
		
		System.out.println("��б�������ַ������е���"+ll.same1("advgghu", "gghuasd"));
		
	}

}
