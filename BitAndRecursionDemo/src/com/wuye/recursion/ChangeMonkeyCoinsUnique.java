package com.wuye.recursion;

public class ChangeMonkeyCoinsUnique {

	/*  
	 *  �ݹ�-��Ǯ�����ٵĻ����� ����
	 * 
	 * ��Ǯ����:���⽫����������г�����,ʹ�õ�ʱ�����ֵ����
	 * 
	 *        ������������֮��,��������ӽ��
	 *        
	 *  5 2 3 4 :��ɵ����ֵ14
	 *        
	 * dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-a[i]]+1)
	 *                �����ظ��Ĵ˴�д����,dp[i][j-a[i]]+1 
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
	 * 
	 * */
	
	//����һ:��֮ǰ����һ����ֻ���� �ȽϵĲ�ͬ��
	
	public int minCoin(int []a,int p){
		if(a.length==0||a==null||p<1){
			return -1;
		}
		
		int dp[][]=new int[a.length][p+1];
		int max=Integer.MAX_VALUE;
		
		//��ѡ���е�һ�и�ֵ 
		for(int i=1;i<p+1;i++){
			if(i==a[0]){
				dp[0][i]=1;
			}else{
			dp[0][i]=max;
		}
			}
		
		
		//���������н��и�ֵ
		
		int left=0;
		for(int i=1;i<a.length;i++){
			for(int j=1;j<p+1;j++){
				left=max;
				if(j-a[i]>=0&&dp[i-1][j-a[i]]!=max){
					//ǰ��˵�� С����Ľ�Ǯ ��Ҫ���һ��
					left=dp[i-1][j-a[i]]+1;
				}
				dp[i][j]=Math.min(dp[i-1][j], left);
			}
			
		}
		System.out.println("---------------");
		for(int b[]:dp){
			for(int c:b){
				System.out.print("-"+c);
		
			}
			System.out.println();
		}
		return dp[a.length-1][p]!=max?dp[a.length-1][p]:-1;
	}

	
	//������:�ռ�ѹ����
	
	public int minCoin1(int []b,int p){

		
		if(b.length==0||b==null||p<0){
			return -1;
		}
		
		int dp[]=new int[p+1];
		
		int max=Integer.MAX_VALUE;
		
		//��һ�н��д���
		for(int i=1;i<p+1;i++){
			if(b[0]==i){
				dp[i]=1;
			}else{
				dp[i]=max;
			}
		}
		
		//��ʣ�༸�Ž��и�ֵ
		
		int left=0;
		for(int i=1;i<b.length;i++){
			for(int j=p;j>0;j--){//
				//��Ϊǰ��ļ��㵱ǰֵ��ʱ�� ��Ҫǰ���ֵ�����ж�   ��������
				//ǰ��ֵ�Ѿ���������
				//
				left=max;
				if(j-b[i]>=0&&dp[j-b[i]]!=max){
					
				//ǰ���ʽ�� һ��Ҫ����Ǯ��	
					 
					left=dp[j-b[i]]+1;
				}
				dp[j]=Math.min(left, dp[j]);
			}
		}
		
		System.out.println("-----------------------");
		for(int c:dp){
			System.out.print("-"+c);
		}
		
		
		System.out.println("-----------------------");
		return dp[p]!=max?dp[p]:-1;
		
	}
	public static void main(String[] args) {
		ChangeMonkeyCoinsUnique dd=new ChangeMonkeyCoinsUnique();
		int a[]={5,2,3,5};
		// TODO Auto-generated method stub
		
		System.out.println(dd.minCoin(a, 10));
		System.out.println(dd.minCoin1(a, 10));

	}

}
