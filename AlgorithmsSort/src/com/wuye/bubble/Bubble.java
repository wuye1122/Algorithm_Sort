package com.wuye.bubble;

public class Bubble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Integer []a={1,2,4,3,5,6,7,8,9};
		   sort(a);
		   if(isSorted(a)){
			  show(a); 
		   }else{
			   System.out.println("�Ѿ��ǵ��ĸ�������");
		   }
	}
	private static boolean less(Comparable a,Comparable b){
		return a.compareTo(b)<0;
		
		
	}
	private static void exch(Comparable []a ,int i ,int j){
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	private static void show(Comparable [] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
			
		}
		
	}
	public static boolean isSorted(Comparable [] a){
		for(int i=1;i<a.length;i++){
			if(less(a[i],a[i-1])){
				return false;
			}
			
		}
		return true;
	} 
	
	private static void sort(Comparable []a){
		
		int N=a.length;
		for(int i=0;i<N;i++){
			//�ƶ�N-1�� ��һ�ΰ����ķ������ �ڶ��� ����
			boolean flag=false;
		for(int j=1;j<N-i;j++){
			
			if(less(a[j],a[j-1])){
				
				exch(a,j,j-1);
				flag=true;
			}
			
	}	
		//less(a[j],a[j-1])�����������Ѿ���ǰ��Ĵ���
		if(!flag){
			System.out.println("��"+i+"�˾��Ѿ��ź�˳����");
			break;
		}
			
		}
		
	}
	
	
}
