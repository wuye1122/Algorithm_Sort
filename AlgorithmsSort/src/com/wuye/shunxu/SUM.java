package com.wuye.shunxu;

public class SUM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int [] a={1,2,3,45,6,7,8,9,10};
     selectSum(a,11);
	}
	
   private static void selectSum(int []a,int sum){
	   int i=0;
	   int j=a.length-1;
	   int left=0;
	   int right=0;
	   int dif=0;
	 
	   while(i<j){
		
	    if(Math.abs((a[i]+a[j]-sum))<=dif){
		   left=a[i];
		   right=a[j];
		   dif=Math.abs(a[i]+a[j]-sum);
	   }else if(a[i]+a[j]<sum){i++;}
	   else
		   j--;
	 }
	   System.out.print(left+"和"+right+"两处的值最接近sum");
	   }  
  
}
