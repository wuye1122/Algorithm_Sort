package com.wuye.insertion;

public class Insertion {
    //ƽ��n^2/4  ��� n^2/2  ��� n-1 �Ƚ� 0����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      //ʵ��Comparable����������:integer double string file url
	Integer [] i={12,3,5,68,1,32};
	System.out.println("����ǰ");
		show(i);
		System.out.println(" ");
		sort(i);
		if(isSorted(i)){
			System.out.println("�����");	
		show(i);
		}else{
			System.out.println("���ź� ��Ū����");}
		
		
		
		
		
           
	}
	//�Ƚ�
   
	private static boolean less(Comparable  a,Comparable  b){
    	
    	return a.compareTo(b)<0;
    	}
    //����
    
    private static void exch(Comparable [] a,int i,int j){
    	
    	Comparable t=a[i];
    	a[i]=a[j];
    	a[j]=t;
    	
    }
    //��ʾ����
    private static void show(Comparable []a){
    	for(int i=0;i<a.length;i++){
    		
    		System.out.print(a[i]+" ");
    		
    	}
    	
    }
    
    
    
    
    //�ж����ս���ǲ�������
    public static boolean isSorted(Comparable [] a){
    	
    	for(int i=1;i<a.length;i++){
    		if(less(a[i],a[i-1]))
    			return false;//����ڶ����˱ȵ�һ��С�ͷ��ش���
    		   }
    	return true;
    	}
     
    public static void sort(Comparable []a){
    	
    	int N=a.length;
    	for(int i=1;i<N;i++){
    		//��һ��ѭ����  �����һ��������     ÿ��ѭ�����µ�Ԫ�ط����ʵ�λ�� �����������յ�λ�ã�
    		//��a[i]����a[i]  a[i-1] a[i-2] a[i-3]֮��
    		for(int j=i;j>0&&less(a[j],a[j-1]);j--){
    			//���ȵڶ��������͵�һ���Ƚ�  �����ǰ���С�ͺ�������
    			show(a);
    			System.out.println("* ");
    			exch(a,j,j-1);
    			show(a);
    			System.out.println("& ");
    			//j����֮�� ������ǰ��ı� ���С���Ż� 
    		}
    		
    		
    		
    	}
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
