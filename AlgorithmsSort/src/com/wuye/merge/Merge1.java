package com.wuye.merge;

public class Merge1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  Integer [] a={23,3,41,34,11,4,51,6,15,46,95,68};
		  show(a);
		  System.out.println("&");
		  sort(a);
		  if(isSorted(a)){
			  show(a);
		  }else{
			  System.out.println("�ܳ���");
		   }
	}
	private static Comparable []tem;
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
	    		if(less(a[i],a[i-1]))
	    			return false;//����ڶ����˱ȵ�һ��С�ͷ��ش���
	    		   }
	    	return true;
	    	}
	
	private static void sort(Comparable []a ){
		int N=a.length;
		tem=new Comparable[N];
		for(int s=1;s<N;s=s+s){//�������С
			for(int lo=0;lo<N-s;lo+=s+s){
				merge(a,lo,lo+s-1,Math.min(N-1, lo+s+s-1));
				show(a);
				System.out.println("*");
			}
			
			
			
		}
		
		
		
		
	}
	private static void merge(Comparable[] a, int ho, int mid, int hi) {
		// TODO Auto-generated method stub
		
		int i=ho,j=mid+1;
		
		for(int k=ho;k<=hi;k++){
			tem[k]=a[k];
			
		}
		for(int k=ho;k<=hi;k++){
			if(i>mid)                    a[k]=tem[j++];
			else if(j>hi)                a[k]=tem[i++];
			else if(less(tem[j],tem[i])) a[k]=tem[j++];
			else                         a[k]=tem[i++];
		}
		
	}


}

