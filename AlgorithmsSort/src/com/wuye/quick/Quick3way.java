package com.wuye.quick;
//
public class Quick3way {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
               Integer a[]={1,2,3,4,7,4,7,8};
               sort(a);
               show(a);
	}
	 private static void show(Comparable [] a){
		   for(int i=0;i<a.length;i++){
			  
			   System.out.print(a[i]+" ");	
			
		   } 
		}
	private static void exch(Comparable [] a,int i,int j){
		   Comparable t=a[i];
		   a[i]=a[j];
		   a[j]=t;
	   }
     private static void sort(Comparable [] a,int ho,int hi){
    	 if(hi<=ho)
    		 return;
    	 int it=ho,i=ho+1,gt=hi;
    	 Comparable v=a[ho];
    	 while(i<=gt){
    		 int c=a[i].compareTo(v);
    		 if(c<0)exch(a,it++,i++);
    		 else if(c>0)exch(a,i,gt--);//及时都大于 换过来之后 i=gt接着比较
    		 else i++;
    	 }
    	 sort(a,ho,it-1);
    	 sort(a,gt+1,hi);
     }
     private static void sort(Comparable []a){
  	   sort(a,0,a.length-1);
     }
}
