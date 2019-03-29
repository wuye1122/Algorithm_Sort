package com.wuye.recursion;


 /*  �ݹ�--��Ǯ�ķ�����
  * 
  * 
 * ����һ��Ǯ��:�����ҳ�10ԪǮ  �����ܹ��ļ��֡�����ʹ�ñ����ݹ�  �Ż�֮��ĵݹ�  ��̬�滮
 * 
 *          
 * 
 * 5 2 3 1:10
 * 
 * ��һ�ֱ����ݹ�: ���д��ڴ������ظ��ݹ�����㡣
 * 
 *            ��Ǯ�й���������ʱ�临�Ӷ� O(aim^n);
 * 
 * 0*5  0*2  0*3  1*10
 *           1*3  1*7 
 *           2*3  1*4
 *           .....
 *    
 *      1*2  0*3  1*8
 *           
 *           .....
 *           
 *  1*5 0*2 0*3 1*5
 *      
 *           ....�����ݹ�
 * 
 * �ڶ��ּ��������� :�Ա����ݹ���Ż� ���Ѿ��ݹ�֮��Ľ������һ�� ��ά���� ���� ����ʱ�临�Ӷ�
 * 
 *     ʱ�临�Ӷ�O(n*k^2);
 *     ���߶�����ͬ��:���߶��ǿռ任ʱ��ķ���:  ����ö�ٴ��� ��������
 *     
 *     ��̬�滮�涨�����˳��  �������������򲻹涨��Щ 
 *   
 * ������ʹ�ö�̬�滮:��������⡣
 *     ʱ�临�Ӷ�O(n*k^2);
 *     j-c3[i]*z>=0
 * 
 * ������:��̬�滮���е�һ���Ż�  ʱ�临�Ӷ�O(n*k)
 * 
 * �����ֿռ�ѹ�����Զ�̬�滮�Ŀռ临�ӶȽ������Ż�: ʱ�临�Ӷ�û�б�  ���ǿռ临�Ӷȱ��O(k)
 * 
 * 
 * 
 * */






public class ChangeMonkeyOfMinNum {

	
	//�����ݹ�:
	public int coin1(int a[],int k){
		if(a==null||a.length==0||k<1){
			return 0;
		}
		
	return  procc(a,0, k);
		
	}
	public int procc(int []a,int index,int aim){
		
		int res=0;
		if(index==a.length){
			res=aim==0?1:0;
		}else{
		
		for(int i=0;i*a[index]<=aim;i++){
			res+=procc(a,index+1,aim-i*a[index]);
		    }
		}
		return res;
	}

	
	//����������:
	//��ÿһ�εݹ�Ľ�������뵽   һ����ά�������档
	//      ���� aim+1
	//����
	//0             map[i][j]��ʾ��ֵ��p(i,j)����ֵ
	//����+1          
	//              map[i][j]==0��ʾ�ݹ�û�м����
	//
	//              map[i][j]==-1��ʾ�ݹ��������Ƿ�����0
	//
	//              3 8 ʹ����Ԫ���޷���ʾ��8Ԫ ���Է���ֵΪ-1
	//           
	//              ���򷵻�ֵp(i,j)=a 
	
	public int coin2(int c2[],int k){
	if(c2.length==0||c2==null||k<0){
		return 0;
	}
	int map[][]=new int[c2.length+1][k+1];
	
	
	
	return pro2(c2,0,k,map);
	
	
	}	
	public  int pro2(int a[],int index,int k,int[][]map){
		
		//��¼����
		int res=0;
		if(index==a.length){
			res=k==0?1:0;
		}else{
		int mapValue=0;
		
		for(int i=0;i*a[index]<=k;i++){
			//ǰһ�ֽ�Ǯ���� �̶�֮����   �Ϳ���һ�ֵ���
			  mapValue=map[index+1][k-i*a[index]]; 
			
			if(mapValue!=0){
				res+=mapValue==-1?0:mapValue;
			}else{
				res+=pro2(a,index+1,k-i*a[index],map);
			}
			
		}
			
			
			
			
			
			
		}
		
		map[index][k]=res==0?-1:res;
		return res;
		
		
		
	}
	
	
	//��̬�滮��
	
	public int coin3(int c3[],int k){
		if(c3.length==0||c3==null||k<0){
			return 0;
		}
		
		//���ȶ�һ�� ��ά����
		int dp[][]=new int[c3.length][k+1];
		
		//���ȵ�һ��ȫ������1
		for(int i=0;i<c3.length;i++){
			dp[i][0]=1;
		}
		
		
		//Ȼ���ǵ�һ���� ֻ���ǵ�һ�����ı���������ʾ ���ó�1  �����ϵ�Ĳ��Ǽ��� �����ܲ���
		
		for(int i=1;c3[0]*i<=k;i++){
			
			dp[0][c3[0]*i]=1;// 5  10 15   c3[0]*i
		}
		
		
		//��ξ���dp[i][j]
		int num=0;
		for(int i=1;i<c3.length;i++){
			for(int j=1;j<k+1;j++){
				num=0;//�����ÿһ��
				
				//�˴�Ӧ���Ǵ���   ʹ��һ�Ż��߼���֮��  ����Ҫʹ��������ǰ 
				for(int z=0;j-c3[i]*z>=0;z++){
					// �ж� ���� jʹ��һ����ʱ���Ǯ   ʹ������  ʹ������
					num+=dp[i-1][j-c3[i]*z];
					//֮ǰ�Ƿ����ܹ����Ϻŵ�  �������˼����  �ʹ�ʱ��Ǯ  �������Ǹ�ǰһ��
				}
				dp[i][j]=num;
			}
			
		}
		
		
		System.out.println("-----��������б���-----");
		
		for(int a[]:dp){
			for(int b:a){
				System.out.print("-"+b);
			}
			System.out.println("-----��������б���-----");	
		}
		
		return dp[c3.length-1][k];
	}
	
	
	//��̬�滮--ʱ�临�Ӷȼ���---�Ż� O(N*k) ��ö�ٵĹ���ʡ�Ե�
	// [i][j-a[i]]
	public int coin4(int c4[],int k){
		if(c4.length==0||c4==null||k<0){
			return 0;
		}
		int dp[][]=new int[c4.length][k+1];
		
		for(int i=0;i<c4.length;i++){
			dp[i][0]=1;
		}
		
		
		//��һ�����Ķ��
		for(int j=1;c4[0]*j<=k;j++){
			dp[0][c4[0]*j]=1;
		}
		
		//dp[i][j]��һ��ֵ  +  ǰһ���Լ���ֵ
		for(int i=1;i<c4.length;i++){
			for(int j=1;j<k+1;j++){
				dp[i][j]=dp[i-1][j];
				dp[i][j]+=j-c4[i]>=0?dp[i][j-c4[i]]:0;
			}
		}
		

		System.out.println("******��������б���*******");
		
		for(int a[]:dp){
			for(int b:a){
				System.out.print("-"+b);
			}
			System.out.println("******��������б���******");	
		}

		return dp[c4.length-1][k];
		
	}
	//��̬�滮--�ռ�ѹ����----����ά������һά����
	// dp[k+1]
	public int coin5(int [] c5,int k){
		if(c5==null||c5.length==0||k<0){
			return 0;
		}
		
		int dp[]=new int[k+1];
		
		for(int i=0;c5[0]*i<=k;i++){
			dp[c5[0]*i]=1;
		}
		
		for(int i=1;i<c5.length;i++){
			for(int j=1;j<k+1;j++){
				dp[j]+=j-c5[i]>=0?dp[j-c5[i]]:0;
			}
		}
		
        System.out.println("&&&&&&&��������б���&&&&&&&&");
		
		for(int a:dp){		
			System.out.print("-"+a);
		}
		System.out.println("&&&&&&&&��������б���&&&&&&&&");			
		return dp[k];
		
	}
	public static void main(String []args){
		ChangeMonkeyOfMinNum rr=new ChangeMonkeyOfMinNum();
		int []aa={3,5,20};
		System.out.println("��һ��:"+rr.coin1(aa, 20));
		System.out.println("�ڶ���:"+rr.coin2(aa, 20));
		System.out.println("������:"+rr.coin3(aa, 20));
		System.out.println("������:"+rr.coin4(aa, 20));
		System.out.println("������:"+rr.coin5(aa, 20));
		
	}
}
