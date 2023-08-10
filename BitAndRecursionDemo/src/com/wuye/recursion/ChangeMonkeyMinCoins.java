package com.wuye.recursion;

public class ChangeMonkeyMinCoins {
 
	
	/*  
	 * �ݹ�-��Ǯ�����ٵĻ�����
	 * 
	 * ָ��Ǯ��  ������С�Ļ�����Ŀ ʱ�临�ӶȺͿռ临�Ӷȶ���O(N*P)
	 * 
	 * ���������ǲ������ظ�  2 3 5:���п����� ������8ԪǮ��Ӧ����Ǯ����
	 *     4*2
	 *     3+5   
	 *     3*2+2
	 * 
	 *   ������С����2�� 
	 *   
	 *   ʹ�ö�̬�滮:
	 *   
	 *   
	 *   dp[i][j]=min{dp[i-1][j] ,d[i][j-a[n]]+1}
	 *  
	 *   �������a[n]��a[n]������1
	 *              ÿ�����a[n]��ԭ�����������ټ�1 
	 * 
	 *   ���a[n-1]�ܹ���ʾ���Ǯ 
	 *   
	 *     a[n] ��ʾ��һ�е�����������ֵ��ʾ�ľ����ܹ���ʾ  ������a[n]����ʾjԪ
	 *     
	 *      
	 *    �����һ��Ԫ������1��    ��ʹ ���������ı���  Ҳ��Ҫ��ѭȡ��Сֵ�����  
	 * 
	 * 
	 * ������:ʹ�ÿռ�ѹ������:�ռ临�Ӷȱ�Ϊ��O(N)
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	
	//����һ:ʹ�õĶ���ռ���һ������:  
	public int minCoin(int a[],int p){
		if(a.length==0||a==null||p<1){
			return -1;
		}
		
		//���Ƚ���һ�� ��Ǯ����
		int dp[][]=new int[a.length][p+1];
		
		int max=Integer.MAX_VALUE;
		
		//���Ƚ��е�һ�и�ֵ
		
		for(int i=1;i<p+1;i++){
			dp[0][i]=max;//�ȶ��丳ֵ 
			if(i-a[0]>=0&&dp[0][i-a[0]]!=max){
				dp[0][i]=dp[0][i-a[0]]+1;
			}
			
		}
		
		//���������Ž��и�ֵ
		int left=0;
		for(int i=1;i<a.length;i++){
			for(int j=1;j<p+1;j++){
				left=max;
				//��仰����˼����  �����ձ����ľ���ǰһ�εĻ�����+1
				// 5  1��5Ԫ
				// 10 1��5Ԫ�ټ�һ��5Ԫ
				// 15 ��ǰһ���������ټ�һ��5Ԫ���3����Ԫ
				//
				if(j-a[i]>=0&&dp[i][j-a[i]]!=max){
					left=dp[i][j-a[i]]+1;
				}
				dp[i][j]=Math.min(left,dp[i-1][j]);
				// һ�е���Ҫȥ��С��  ˵��  ����Ǹ�Ǯ���ܹ�ʹ����С�������б�ʾ
				//
				//
			}
		
			
		}

		System.out.println("------��������Ǯ��¼ �������������Ǯ����------");
		for(int aa[]:dp){
			for(int b:aa){
				System.out.print(b+"-");
			}
			System.out.println( );
		}
		
		return dp[a.length-1][p]!=max?dp[a.length-1][p]:-1;
		
	}
	
	
	
	//������:ʹ�õĶ���ռ���һ������
	public int minCoin1(int []a,int p){
		if(a.length==0||a==null||p<1){
			return -1;
		}
		
		int dp[]=new int[p+1];
		int max=Integer.MAX_VALUE;
		
		for(int i=1;i<dp.length;i++){
			dp[i]=max;
			if(i-a[0]>=0&&dp[i-a[0]]!=max){
				dp[i]=dp[i-a[0]]+1;
			}
		}
		
		int left=0;
		
		for(int i=1;i<a.length;i++){
			for(int j=1;j<dp.length;j++){
				left=max;
				if(j-a[i]>=0&&dp[j-a[i]]!=max){
					left=dp[j-a[i]]+1;
				}
				dp[j]=Math.min(left, dp[j]);
			}
		}
		System.out.println("------�ռ�ѹ����������򵥵�ֻ��һ���������ʵ�ֵ�------");
		for(int b:dp){
			System.out.print(b+"-");
		}
		System.out.println();
		return dp[dp.length-1]!=max?dp[dp.length-1]:-1;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChangeMonkeyMinCoins dd=new ChangeMonkeyMinCoins();
		int a[]={5,2,3};
		System.out.println("���յĽ��:"+dd.minCoin(a, 20));
		System.out.println("--------------------------");
		System.out.println("���յĽ��:"+dd.minCoin1(a, 20));
	}

}
