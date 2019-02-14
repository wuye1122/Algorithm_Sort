package com.wuye.merge;
//由上向下的排序
public class Merge{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		  Integer [] a={30,23,41,34,11,4,15,6,39,16,45,88,67};	
		  show(a);
		  System.out.println("%");
		  sort(a);
		  if(isSorted(a)){
			  show(a);
		  }else{
			  System.out.println("总出错");
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
	    			return false;//如果第二个人比第一个小就返回错误，
	    		   }
	    	return true;
	    	}
	
	private static void sort(Comparable []a ,int ho,int hi){
		if(hi<=ho)return;
		
		int mid=ho+(hi-ho)/2;
		sort(a,ho,mid);
		
		sort(a,mid+1,hi);
	
		merge(a,ho,mid,hi);
		show(a);
		System.out.println("$");
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
	public static void sort(Comparable []a){
		tem=new Comparable[a.length];
		sort(a,0,a.length-1);
	}

}
