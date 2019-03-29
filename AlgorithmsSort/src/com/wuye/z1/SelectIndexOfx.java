package com.wuye.z1;

/*1 �ҳ�һ�����������KС��Ԫ��-----�ҳ�һ�������������λ��(����)
 *  �����������ʱ�临�ӶȽ������Զ�����
 *2 �����ż����ô��(��λ��)
 *  valueOf(Comparable.toString)----��Comparableת����integer
 *3�������ҵ����������С��һ��������ʱ�������������Ե�
 */
public class SelectIndexOfx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Integer [] b={10,23,45,46,5,6,8,23,24,22};
     show(b);      //0 1   2  3 4 5 6 7 
     System.out.println("*");
     //�ҳ������ڶ������
     System.out.println(b.length-1);
     System.out.println(select(b,b.length-2));
     SelectMid(b);
    
	}

	public static void SelectMid(Comparable [] b) {
		if(b.length%2==1){//������
			 System.out.println("��λ��"+select(b,(b.length-1)/2));
		 }else{
			 System.out.println("��λ��"+(Integer.valueOf(select(b,b.length/2).toString())+Integer.valueOf(select(b,b.length/2-1).toString()))*1.0/2);
		       
		       

		 }
	}

	private static  boolean less(Comparable a,Comparable b){
		return a.compareTo(b)<0;
	}
	private static void exch(Comparable [] a,int i,int j){
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	private static void show(Comparable [] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+",");
		}
	}
	private static int partition(Comparable [] a,int ho,int hi){
		
		int i=ho,j=hi+1;
		Comparable v=a[ho];
		while(true){
		//a[ho...j-1] <=a[j] <=a[j+1...hi]	
		while(less(a[++i],v))if(i==hi)break;
		while(less(v,a[--j]))if(j==ho)break;
		if(i>=j)break;
		exch(a,i,j);//������v�ĺ�С��v�Ľ��н���
		}
		exch(a,ho,j);
		return j;
		
	}
                                              //k��������
	public static Comparable select(Comparable [] a,int k){
	
		int lo=0,li=a.length-1;
		while(lo<li){
			int j=partition(a,lo,li);
			if(j==k) return a[k];
			 else if(j>k)  li=j-1;
			 else if(j<k) lo=j+1;
		}
		return a[k];
		
		
	}
	
}































