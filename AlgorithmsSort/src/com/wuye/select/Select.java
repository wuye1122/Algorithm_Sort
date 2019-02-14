package com.wuye.select;

public class Select {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer [] i={12,3,5,68,1,32};
		sort(i);
		if(isSorted(i)){
		show(i);
		}else{
			System.out.println("出现错误");
		}
		;
	}
   private static boolean less(Comparable a,Comparable b){
	   return a.compareTo(b)<0;
	    }
   
   private static void exch(Comparable[] a,int i,int j){
	   Comparable t=a[i];
	   a[i]=a[j];
	   a[j]=t;
	   
 }
   private static void show(Comparable []a){
	   for(int i=0;i<a.length;i++){
		   System.out.print(a[i]+" ");
	   }
	   
   }
   public static boolean isSorted(Comparable []a){
	   for(int i=1;i<a.length;i++){
		   
		   if(less(a[i],a[i-1]))
			   return false;
		   }
		   return true;	   
	   }
	   
   public static void sort(Comparable []a){
	   int N=a.length;
	    for(int i=0;i<N;i++){
	    	int min=i;//依次比较a[i]和a[i+1]----a[N]
	    	//min 就是第一个位置，第二个…………
	    	for(int j=i+1;j<N;j++){
	    		//第一个需要比较N-1次 然后 将后面最小的和a[min]交换
	    		//第二次需要比较 N-2次
	    		if(less(a[j],a[min]))
	    			//比较新的元素和之前最小的
	    			min=j;
	    		
	    	}
	    	 show(a);
	    	 System.out.println("*");
	    		exch(a,i,min);//交换不分先后顺序	
	    			
	    	
	    	
	    	
	    	
	      }
	   
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
