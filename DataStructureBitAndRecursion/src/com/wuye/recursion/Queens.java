package com.wuye.recursion;

public class Queens {

	/*
	 * 
	 * rescursion  N�ʺ�����
	 * 
	 *  N*NҪ��N���ʺ� :��ÿһ����  ÿһ���� ÿһб�Ų�����Żʺ�
	 * 
	 *  ���N��������԰ڼ���
	 * 
	 * ����һ��ʹ�õݹ����ʽ��һ������record[i]=j
	 * 
	 *       ���������i�� j�����j��  (i,j)--->��ȷһ���ʺ�λ��
	 * 
	 * 
	 * 
	 * 
	 * */
	//int num
	
	public int num(int n){
		if(n<1){
			return 0;
		}
		int record[]=new int[n];
		return process(0,record,n);
	}
	
	
	//����һ������ ���ؽ���� ��n�����ԷŵĻʺ�
	
	public int process(int i,int[]record,int n){
		if(i==n){
			return 1;
			
		}
		int res=0;//��¼
		for(int j=0;j<n;j++){
			if(isVaild(record,i,j)){
				record[i]=j;
				res+=process(i+1,record,n);
			}		
		}
		return res;
	}
	
	
	
	//����isVaild �ж�����ij���Ƿ���Դ�Żʺ�
	
	public boolean isVaild(int []record,int i,int j){
		for(int k=0;k<i;k++){
			if((record[k]==j)||Math.abs(k-i)==Math.abs(record[k]-j)){
				return false;
			}
			
		}
		return true;
		
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queens qq=new Queens();
		System.out.println(qq.num(1));
		System.out.println(qq.num(2));
		System.out.println(qq.num(3));
		System.out.println(qq.num(8));
		
	}

}
