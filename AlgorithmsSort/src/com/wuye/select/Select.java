package com.wuye.select;

public class Select {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer [] i={12,3,5,68,1,32};
		sort(i);
		if(isSorted(i)){
		show(i);
		}else{
			System.out.println("���ִ���");
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
	    	int min=i;//���αȽ�a[i]��a[i+1]----a[N]
	    	//min ���ǵ�һ��λ�ã��ڶ�����������
	    	for(int j=i+1;j<N;j++){
	    		//��һ����Ҫ�Ƚ�N-1�� Ȼ�� ��������С�ĺ�a[min]����
	    		//�ڶ�����Ҫ�Ƚ� N-2��
	    		if(less(a[j],a[min]))
	    			//�Ƚ��µ�Ԫ�غ�֮ǰ��С��
	    			min=j;
	    		
	    	}
	    	 show(a);
	    	 System.out.println("*");
	    		exch(a,i,min);//���������Ⱥ�˳��	
	    			
	    	
	    	
	    	
	    	
	      }
	   
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
