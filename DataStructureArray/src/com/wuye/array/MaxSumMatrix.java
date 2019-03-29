package com.wuye.array;


/*
 * 
 *  1 2 -3
 *  3 7 -9
 *  3 4  5
 * 
 *  �����������ۼӺ�������� :
 *  
 *  a[]:��ûһ�� �ӵ�һ��  ���ӵ���ʽ   �����ݼ�3 2 1
 * 
 *      ��󷵻����������max
 * 
 * 
 * 
 * 
 * 
 * 
 * */

 
//һ����ά����  һ������
public class MaxSumMatrix {
	public int getMax(int [][] arr){
		 if(arr==null||arr.length==0||arr[0].length==0){
			 return 0;
		 }
		 
		 
		 //����һ��  ֻ����һ�е�����
		 
		 int sum[]=null;
		 
		 int cur=0;
		 
		 int max=Integer.MIN_VALUE;
		
		
		 //�˴�ѭ��  0 1 2 ��ʾ�ۼӵĿ�ʼ����
		 for(int i=0;i<arr.length;i++){
			 // i =0   1  2 
			 sum=new int[arr[0].length];
			 //��Ϊ����ѭ����֮�� �½�����
			 //����Ĵӿ�ʼ�кſ�ʼҪ����ѭ�������� 3
			 for(int j=i;j<arr.length;j++){//i  jд����
			 cur=0;
				
				 //������  ��ÿһ�����ۼ�����
				 for(int k=0;k<sum.length;k++){
					
					 sum[k]+=arr[j][k];
					 //sum[0]=arr[0][0] +a[1][0]+a[2][0]
					 //sum[1]=arr[0][1] +a[1][1]+a[2][1]
					 //sum[2]=arr[0][2] +a[1][2]+a[2][2]
					 cur+=sum[k];//��¼ÿһ��ֵ
					 
					 max=Math.max(max, cur);
					 
					 cur=cur<0?0:cur;
					 
				 }
				 
			 }
			 
			 
		 }
		return max;
		 
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<6;i++){
			System.out.println(i);
		
			}
		
		System.out.println("-------------------");
		for(int i=0;i!=6;i++){
			System.out.println(i);
		}
		int aa[][]={{-90,48,78},{64,-40,64},{-81,-7,66}};
		MaxSumMatrix mm=new MaxSumMatrix();
	
		System.out.println(mm.getMax(aa));
	    System.out.println("ijд���� �˷���һ��Сʱ");	
	}

}
