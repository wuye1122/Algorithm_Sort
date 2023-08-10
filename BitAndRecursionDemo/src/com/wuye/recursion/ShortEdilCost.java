package com.wuye.recursion;

public class ShortEdilCost {
/*
 * rescursion --- ��С�༭����
 * 
 * 1 str1---> str2 ic dc rc:���� ɾ��  �滻
 *   
 *   ʹ�ö�̬�滮ʱ�临�Ӷ�O(M*N)  �ռ临�Ӷ�O(M*N)  
 *   
 *   ʹ�ÿռ�ѹ���� �ռ临�Ӷ�O(min{m,n}); 
 * 
 *   
 * 2 ���� ���ȶ���һ��(M+1)*(N+1)��һ�� ��ά����
 * 
 *  arr[0][0]=''   
 *  
 *  arr[i][j]:����str1[0..i-1] --> str2[0..j-1]����С����
 * 
 * 
 * 
 * 
 * */
	
	//��̬�滮:
	public  int getShort1(String str1,String str2,int ic,int dc ,int rc){
		
		char[] ch1=str1.toCharArray();
		
		char[] ch2=str2.toCharArray();
		
		
		int row=ch1.length+1;
		
		int col=ch2.length+1;
		
		int [][]dp=new int[row][col];
		
		
		//�Ե�һ�н��и�ֵ  str1ת����' '�Ĵ���
		
		for(int i=1;i<row;i++){
			dp[i][0]=dc*i;
			
		}
		
		
		
		//�Ե�һ�н��и�ֵ  ��' 'ת����str2
		for(int j=1;j<col;j++){

			dp[0][j]=ic*j;
		}
		
		//��dp[i][j]���и�ֵ
		
		for(int i=1;i<dp.length;i++){
			for(int j=1;j<dp[0].length;j++){
				if(ch1[i-1]==ch2[j-1]){
					dp[i][j]=dp[i-1][j-1];
				}else{
					dp[i][j]=dp[i-1][j-1]+rc;
				}
				
				dp[i][j]=Math.min(dp[i][j], dp[i-1][j]+dc);
				dp[i][j]=Math.min(dp[i][j], dp[i][j-1]+ic);
			}
			
		}
		
		System.out.println("");
		for(int [] c:dp){
			for(int d:c){
				System.out.print(d+" ");
				
			}
			System.out.println("");
		}
		
		System.out.println("");
		return dp[row-1][col-1];
		
		
	}
	
	//���ÿռ�ѹ����:
	public int getShort2(String str1,String str2,int ic,int dc ,int rc){
		
		
        char[] ch1=str1.toCharArray();
		
		char[] ch2=str2.toCharArray();
		
		
		
		//���̻�ûŪ�����أ�����������������������������������
		int longs=ch1.length>=ch2.length?ch1.length:ch2.length;
		
		int shorts=ch1.length<ch2.length?ch1.length:ch2.length;
		
		if(ch1.length<ch2.length){
			int tem=dc;
			dc=ic;
			ic=tem;

		}

		int dp[]=new int[shorts+1];
		
		//����һ��һ�ŵ���������
		for(int i=1;i<=ch2.length;i++){
			dp[i]=ic*i;
			
		}
		
		//��Ȧѭ��
		
		for(int i=1;i<=ch1.length;i++){
			//���Ƚ����Ͻǵ�Ԫ�� ��ס
			
			int pre=dp[0];
			dp[0]=dc*i;
			for(int j=1;j<=ch2.length;j++){
				int tem=dp[j];
				
				//���ַ������Ȳ�һ�� index��һ��
				if(ch1[i-1]==ch2[j-1]){
					dp[j]=pre;
					
				}else{
					dp[j]=pre+rc;
					
				}
				
				dp[j]=Math.min(dp[j], dp[j-1]+ic);
				dp[j]=Math.min(dp[j], tem+dc);
				pre=tem;
			}
			
			
		}
		for(int c:dp){
			System.out.print(c+",,");
		}
		return dp[ch2.length];
		
	}
		
		
		
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortEdilCost se=new ShortEdilCost();
		
		String str1="ab12cd3";
		String str2="abcdf";
		
	int a=se.getShort1(str1, str2, 5, 3, 2);
	int b=se.getShort2(str1, str2, 5, 3, 2);
		
		System.out.println("---"+b);
		
		
	}

}
