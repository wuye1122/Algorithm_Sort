package com.wuye.heap;

public class Heap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            Integer [] a={null,34,56,89,10,2,5,7,1};
            show(a);                     
			System.out.println("&");   //    7
		sort(a);                     //10         34  
		if(isSorted(a)){           //1    2    5    56
			show(a);            // 89
		}
		
	}
     private static boolean less(Comparable a,Comparable b){
    	 return a.compareTo(b)<0;
     } 
	private static void exch(Comparable [] a,int i,int j){
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	private static boolean isSorted(Comparable [] a){
		for(int i=2;i<a.length;i++){
			if(less(a[i],a[i-1])){
				return false;
			}
		}
		return true;
	}
	
	public static void show(Comparable [] a){
		for(int i=1;i<a.length;i++){
			System.out.print(a[i]+"*");
		}
		
	}
	//�ϸ������¼���ʼ ��������һ�� ֱ���������ڵ�
	private static void swim(Comparable [] a,int i,int j){
		
		while(i>1&&less(a[i/2],a[i])){
			 j=i/2;
			 exch(a,i,j);//�Ƚϸýڵ���丸�ڵ�  ������ڸ��ڵ���н���
			 //�������Ͽ����ڵ�
			 i=i/2;
		}
	}
	private static void sink(Comparable [] a,int i,int N){
		
		while(2*i<=N){
			int j=2*i;
			if(j<N && less(a[j],a[j+1]))j++;//�ҳ��ӽڵ���������һ��
			if(!less(a[i],a[j]))break;//����ӽڵ�С�ڸ��ڵ� ��Ҫ��
			exch(a,i,j);
			i=j	;//ֱ�ӿ��ӽڵ���ӽڵ�
		}
	}
	private static void sort(Comparable [] a){
		int N=a.length-1;
		for(int k=N/2;k>=1;k--){
			sink(a,k,N);
		}//���������ųɶ� ����������
		show(a);
		System.out.println("^");
		while(N>1){
			
			exch(a,1,N--);
			show(a);
			System.out.println("%");
			sink(a,1,N);
			
			show(a);
			System.out.println("%");
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
