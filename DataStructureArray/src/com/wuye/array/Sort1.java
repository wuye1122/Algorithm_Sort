package com.wuye.array;

public class Sort1 {

	/*
	 * 
	 *  1 ��Ȼ����������� 1~N����
	 *  
	 *   ��������Ľṹarr[i]=i+1;
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
	 * 
	 * */
	public static void sort1(int [] arr){
		int tem=0;
		//�������ϵĽ�����������
		for(int i=0;i<arr.length;i++){
			while(arr[i]!=i+1){
				
				tem=arr[arr[i]-1];
				arr[arr[i]-1]=arr[i];
				arr[i]=tem;
				
				
			}
			
			
		}
		
		
	}
	public  static void sort(int [] arr){
		int tem=0;
		int next=0;
		for(int i=0;i<arr.length;i++){
			tem=arr[i];
			while(arr[i]!=i+1){     //��һ�� 1 2 5 4 3
				next=arr[tem-1];
				arr[tem-1]=tem;     //��� 1 2 5 4 5
				 
				tem=next;           //tem=3
				/*
				 * 
				 * ������һ��������� �ͽ���һ��while�����ѭ�� 
				 * 
				 *  һֻתȦ --->ֱ�����ס��λ�� ���õ���i+1ʱ��
				 * 
				 *  ��Ϊÿ�ν���֮��λ�õ�������  �ٴ�ѭ�����������ѭ��
				 * 
				 * 
				 * */
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr={1,2,5,4,3};
		
		
		Sort1.sort1(arr);
		for(int a:arr){
			System.out.println(a);
		}
	}

}
