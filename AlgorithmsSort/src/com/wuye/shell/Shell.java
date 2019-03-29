package com.wuye.shell;
//1 j-=h j*=h���﷨
//2 ()��ͷ��
public class Shell {
	//ϣ������ �ı����������� 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Integer [] a={0,23,11,34,1,4,5,6,34,16,45,68,67};		
		sort(a);
		if(isSorted(a)){
			show(a);
		}else{
			System.out.println("����");
		}
		
	}
	private static boolean less(Comparable a,Comparable b){
		return a.compareTo(b)<0;
	}
	private static void exch(Comparable []a,int i,int j){
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	private static void show(Comparable [] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}

	} 
	private static boolean isSorted(Comparable [] a){
		for(int i=1;i<a.length;i++){
			if(less(a[i],a[i-1])){
				return false;

			}
		}
		return true;
	}
      private static void sort(Comparable []a){
    	  int N=a.length;
    	  int h=1;//����
    	  while(h<N/3)h=h*3+1;
    	  //0 1 2 3 /4  5  6  7/
    	  //���� 20����  h=4
    	  while(h>=1){
    		  for(int i=h;i<N;i++){
    			  show(a);
    			  System.out.println("*");
    			  //��a[i]������������a[i-h] a[i-2h]
    			  for(int j=i;j>=h && less(a[j],a[j-h]);j-=h){
    				  show(a);
        			  System.out.println("&");
    				  exch(a,j,j-h);
    				  show(a);
        			  System.out.println("^");
    				  
    			  } 
    			  
          }
    		  h=h/3; 
    		  show(a);
			  System.out.println("%");
    }
    	  
     
  }
	
	
	
	
	
	
}
