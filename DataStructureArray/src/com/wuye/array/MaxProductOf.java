package com.wuye.array;

public class MaxProductOf {

	/*
	 *  ���������˻�:
	 *  ����һ�� double���͵����� : ������0 1 -1 0.1
	 *  
	 *  ������������� ǰһλ����Сֵ min=-n  * arr[i]<0
	 * 
	 *            ǰһλ���ֵmax=n   *  arr[i]>0 
	 * 
	 *            ��λ�õ������   arr[i]  ��һ����ǰ����0�������arr[i]���
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	public static double maxProd(double [] a){
		if(a.length==0||a==null){
			return 0;
			
		}
		
		double max=a[0];
		double min=a[0];
		double res=a[0];
		double endMax=0;
		double endMin=0;
		for(int i=1;i<a.length;i++){
			endMax=max*a[i];
			endMin=min*a[i];
			max=Math.max(Math.max(endMax, endMin), a[i]);
			//�Ƚϵ� ��ʱ  ��������µ� ���ֵ
			min=Math.min(Math.min(endMax, endMin), a[i]);
			res=Math.max(res, max);//�Ƚϴ˴ε����ֵ��  ֮ǰ���ֵ
		}
		return res;
		
		
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a[]={1,2,0,12,0,2,4,-0.8};
		double b[]={1,10,-0.7,-10,2,3,0};
		double c[]={1,2,3,4,-5,9,9};
		System.out.println(MaxProductOf.maxProd(a));
		System.out.println(MaxProductOf.maxProd(b));
		System.out.println(MaxProductOf.maxProd(c));
		
	}

}
