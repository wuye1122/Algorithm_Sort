package com.wuye.recursion;

public class LengthIncreasingSubsenquence {

	/*
	 *  rescursion   ����������� �����ǰ������ ��
	 *  
	 *           ���������   ����1��  ---> LengthOfConnectionArray
	 *  
	 *             
	 *   
	 *              
	 * 
	 * 
	 *    1 dp[i]������i��β����������0..i ��ĵ�������
	 * 
	 *      �ص�: dp[i]=max(dp[i],dp[j]+1)
	 *        
	 *           ����С���������������� ��������+1 
	 * 
	 * 
	 *     2 ����һ��end����  ����Ч��[0,right]
	 * 
	 * 
	 *      ���ַ��������۾���:��end����ʹ��1/2���ҷ�  �ҳ������һ����
	 *      
	 *           arr[i]�����
	 * 
	 * */

//�ڶ��ַ���:
	 public int[] getLong2(int arr[]){
			if(arr.length==0||arr==null){
				return null;
				
			}
			int [] dp=getDP1(arr);
			
			return getList(arr,dp);
			
		}
	
	//ʹ�ö��������end������� dp����
	public int[] getDP1(int arr[]){
		
		int []end=new int[arr.length];
		
		int []dp=new int[arr.length];
		
		end[0]=arr[0];
		
		dp[0]=1;
		
		//�����arr����ѭ��
		int right=0;
		
		int l=0;
		
		int r=0;
		
		int m=0;
		for(int i=1;i<arr.length;i++){
			
			l=0;
			r=right;
			while(l<=r){
  
				m=(l+r)/2;
				
				if(arr[i]>end[m]){
					l=m+1;
					
				}else{
					r=m-1;
					
				}
				
			}
			
			 right=Math.max(right, l);
			 end[l]=arr[i];
			 dp[i]=l+1;
			
			
			
		}
		return dp;
		
		
	}
	
	
//��һ�ַ���:	

	//����dp[] ʱ�临�Ӷ�O(n^2)
	public int [] getDP(int []arr){
		int dp[]=new int[arr.length];

		for(int i=0;i<dp.length;i++){
			dp[i]=1;

			for(int j=0;j<i;j++){
				//ѡ����С������ ��ĵ�������
				if(arr[j]<arr[i]){
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
		}
		return dp;
	}

	//��dp[]���б����ó����������
	public int [] getList(int arr[],int []dp){
		int len=0;//��¼���ȵ�
		
		int index=0;//��¼������
		
		for(int i=0;i<dp.length;i++){
			if(dp[i]>len){
				len=dp[i];
				index=i;
			}
			
			
		}
		//����һ������ַ�������
		
		int a[]=new int [len];
		
		//��������б���
		a[--len]=arr[index];
		for(int i=index;i>=0;i--){
			if((arr[i]<arr[index])&&(dp[i]==dp[index]-1)){
				a[--len]=arr[i];
				index=i;
				
			}
			
		}
		return a;
		
	}
	
	//arr dp�����������ϵó�����
    public int[] getLong(int arr[]){
		if(arr.length==0||arr==null){
			return null;
			
		}
		int [] dp=getDP(arr);
		
		return getList(arr,dp);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LengthIncreasingSubsenquence ll=new LengthIncreasingSubsenquence();
		
		int []a={2,1,5,3,6,4,8,9,7};
		int []b=ll.getDP(a);
		for(int c:b){
			System.out.print(c+".");
		}
	System.out.println("---");

	System.out.println("��һ�ֵĴ��������������:");
	
	 int lo[]=ll.getLong(a);
	 for(int c:lo){
		 System.out.print(c+"-");
	 }

	 System.out.println(""); 
		int []d=ll.getDP1(a);
		for(int c:d){
			System.out.print(c+".");
		}
	 
	 
	 
	 
		 System.out.println(""); 
	 System.out.println("�ڶ��ֵĴ��������������:");
		
	 int lo1[]=ll.getLong2(a);
	 for(int c:lo1){
		 System.out.print(c+"-");
	 }
	 
	 
	 
	}

}
