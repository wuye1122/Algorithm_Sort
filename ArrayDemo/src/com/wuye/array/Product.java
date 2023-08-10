package com.wuye.array;



public class Product {

	
	 /*
	  *  1 ��������λ�� ����λ�õ��۳�
	  *  
	  *   Ҫ��ʱ�临�Ӷ�O(n)  �ռ临�Ӷ�O(1)
	  *   ʹ��һ������ �ܳ˻�/ÿһλ��Ԫ��
	  * 
	  * 
	  *  2 ��ʹ�ó����������
	  * 
	  *    ��һ���㷨:������ʹ�ó���
	  *    ���� �趨�������� һ����ָ��λ�õ�����lr[k-1]    rl[k+1] ��һ����ָ��λ�õ��Ҳ�
	  *                           0*����k-1      k+1*����N-1
	  * 
	  *   kλ�õ�ֵ=lr[k-1]*rl[k+1]
	  *   
	  * */
	//�ڶ��ַ���
	public int[] product(int [] a){
			
			if(a==null||a.length<2){
				return null;
			}
			
			int [] res=new int[a.length];
			
			//����ָ��һ������  ��res[i]=a[i]!
		
			res[0]=a[0];
			for(int i=1;i<a.length;i++){
				res[i]=res[i-1]*a[i];
				
			}
			
			int b=1;
			for(int i=a.length-1;i>0;i--){
				res[i]=res[i-1]*b;
				b*=a[i];
				
				
			}
			res[0]=b;
			return res;

}
	
	
	//��һ�ַ���
	public int[] product1(int [] a){
		
		if(a==null||a.length<2){
			return null;
		}
		
		int [] res=new int[a.length];
		int count =0;
		int all=1;
		for(int i=0;i<a.length;i++){//��0��ʼ
			if(a[i]!=0){
				all *=a[i];
			
			}else{
			count++;
			}
		}
		
		//�����û��������
		if(count==0){
			for(int i=0;i<a.length;i++){
				res[i]=all/a[i];
				
			}
			
		}
		
		
		//�����һ��������
		
		if(count==1){
			for(int i=0;i<a.length;i++){
			if(a[i]==0){
				res[i]=all;
			}
			 
			}
		}
		return res;
		
		
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		Product pro=new Product();
		
//		int arr[]={0,0,11,2,3,4};
//		int arr1[]={1,0,11,2,3,4};
		int arr2[]={1,2,3,4,5,6};
		
		
		
	//	pro.product1(arr);
	  int []a=pro.product(arr2);
		
	   for(int i=0;i< a.length;i++){
		   System.out.print(a[i]+" ");
		   
	   }
	
		
		
		
	
		
		
	}

}
