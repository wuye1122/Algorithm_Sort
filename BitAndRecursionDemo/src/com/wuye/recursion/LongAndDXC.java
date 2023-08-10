package com.wuye.recursion;

public class LongAndDXC {

	/*   �ݹ�-�����������
	 * 
	 * ȥ��������:��ʿ�����Ͻǳ��������·����� ÿ��ֻ�����һ�������
	 *           ������������Ѫ��  ��������˴���Ѫƿ�ָ�Ѫ��  ���ռ�������
	 *           Ѫ����������1
	 *     
	 *   �������൱��һ�����������Ѫ�����˴���Ҫ��ȥ��Ӧ������         
	 *   -2  -3  3      
	 *   -5 -10  1 
	 *    0  30 -5
	 *    
	 *    
	 *    
	 *    7  5  2
	 *    6  11 5
	 *    1  1  6
	 * 
	 *           ���ʼѪ���Ƕ��١�
	 * 
	 * ����ʹ�ö�̬�滮���м��㡣
	 * 
	 * 
	 * �������½�ֻ������������ߡ�
	 * 
	 * �����˼·�Ǵ����½������Ͻǽ��г���  ,���Ҹտ�ʼȷ�����½ǵ�ֵ
	 * 
	 *  �ȵó����������һ��  Ȼ���ǵ����ڶ���               
	 *  
	 *  ���㷽��:<-------
	 *        <------- 
	 *        <-------    
	 *        <-------   
	 * 
	 * 
	 * */
	
	public  int minPh(int [][] b){
		if(b==null||b.length==0||b[0].length==0||b[0]==null){
			return -1;
		}
		int row=b.length;
		int col=b[0].length;
		int [][]dp=new int[row--][col--];
		//��ʱ���row  col�������������
		
		//���ȶ�dp[row][col]���и�ֵ 
		// dp[i][j]�������˼��,�ڸ�Ҫ����b[i][j]��ʱ����Ҫ����Сֵ
		// Ҳ���Ǳ�����dp[i][j]-b[i][j]>=1
		//
		dp[row][col]=b[row][col]<0?1-b[row][col]:1;
		
		//�����Ƕ�dp[][]���һ�н��и�ֵ
		//�仯����col
		for(int i=col-1;i>=0;i--){
			//1 0 
			dp[row][i]=Math.max(1, dp[row][i+1]-b[row][i]);
		}
		
		
		
		//�����Ƕ�ʣ�༸�н��и�ֵ
		int right=0;//��¼������
		int up=0;//��¼������
		
		for(int i=row-1;i>=0;i--){
			//1 0
			//���ȶ�ÿһ�ŵ����һ�����и�ֵ
			dp[i][col]=Math.max(1, dp[i+1][col]-b[i][col]);
			for(int j=col-1;j>=0;j--){
                    // 1 0
			   right=Math.max(1, dp[i][j+1]-b[i][j]);
			   up=Math.max(1, dp[i+1][j]-b[i][j]);
			   dp[i][j]=Math.min(right, up);
			
		}
		
		
	}
		
		System.out.println("---------------");
		for(int aa[]:dp){
			for(int bb:aa){
				System.out.print(bb+"-");
			}
			System.out.println();
		}
		
		
		System.out.println("---------------");
		return dp[0][0];
	
	}
	
	//��һ�ֲ��õ��ǿռ�ѹ���� O(min{M,N})
	/*
	 * 
	 * ѡ�񳤶���̵�һ����   ���������ʹ�ó��̽����ж��븳ֵ.
	 * ���row>col  ��ôѡ��colһ����������һ�е����档
	 * 
	 * ���row<col  ��ôѡ��rowһ����������һ�е����档
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	
	
	public int minPHP(int [][]a){
		
		if(a==null||a.length==0||a[0].length==0||a[0]==null){
			return 0;
		}
		
		//����ѡ�� ����more==a.length �൱�ڴ��µ���
		
		int more=Math.max(a.length, a[0].length);
		int less=Math.min(a.length, a[0].length);
		
		boolean fal=more==a.length;
		
		//����ȡ��a��������һ��ֵ
		
		int tem=a[a.length-1][a[0].length-1];
		
		int dp[]=new int[less];
		
		dp[less-1]=tem<=0?1-tem:1;
		
		
		//������������ ����ѡ�񳤿�
		int row=0;
		int col=0;
		for(int i=less-2;i>=0;i--){
			row=fal?more-1:i;
			col=fal?i:more-1;
			dp[i]=Math.max(1, dp[i+1]-a[row][col]);
		}
		
		int choose1=0;
		int choose2=0;
		
		//���������һ�Ž��и���  ���߶������ڶ��Ž��и���
		for(int i=more-2;i>=0;i--){
			row=fal?i:less-1;
			col=fal?less-1:i;
			dp[less-1]=Math.max(1, dp[less-1]-a[row][col]);
			for(int j=less-2;j>=0;j--){
				row=fal?i:j;
				col=fal?j:i;
				
				choose1=Math.max(dp[j+1]-a[row][col],1);
				choose2=Math.max(dp[j]-a[row][col], 1);
				dp[j]=Math.min(choose1, choose2);
			}
			
		
		}
		
		System.out.println("-------");
		for(int bb:dp){
			
			System.out.print(bb+" ");
			
		}
		
		
		System.out.println("-------");
		return dp[0];
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongAndDXC dd=new LongAndDXC();
		int b[][]={{-2,-3,3},{-5,-10,1},{0,30,-5},{1,2,-5}};
		System.out.println(dd.minPh(b));
		System.out.println("------------------");
		int c[][]={{-2,-3,3},{-5,-10,1}};
		System.out.println(dd.minPh(c));
		System.out.println("------------------");
		System.out.println(dd.minPHP(b));
		System.out.println("------------------");
		System.out.println(dd.minPHP(c));
		System.out.println("------------------");
		
	}

}
