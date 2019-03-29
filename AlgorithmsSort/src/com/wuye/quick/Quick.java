package com.wuye.quick;
/*1 ���������Ƿ��ε�˼��
 * ѡ��һ����׼pivot�������Ϊ������ һ���ֲ����ڻ�׼�� ��һ���ֲ�С�ڻ�׼��
 * Ȼ��ݹ���Ž�����������ֱ��������
 * 2ѡ���зֵ�ʱ������ɨ���һ����һ��׼�� ���ұ�ɨ���һС�ڻ�׼�Ľ������λ��
 * ֱ������ɨ������һ�� Ȼ���з������м��滻
 * 3���������ʱ����Ҫ�ķ��ڻ������� ���ڳ���Ϊk��������в��� ����Ҫk-1�λ���
 * 
 * */
public class Quick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integer [] i={12,34,45,68,1,32,3,5,11,455};
		//sort(i);
		//show(i);
		
		Double b[]=new Double[6];
		for(int i=0;i<6;i++){
			b[i]=Math.random();
		  System.out.println(b[i]);	
		  
		}
		sort(b);
		show(b);
	}
	private static boolean less(Comparable a,Comparable b){
		return a.compareTo(b)<0;
	}
   private static void exch(Comparable [] a,int i,int j){
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
		   if(less(a[i],a[i-1])){
			   return false;
		   }
	   }
	   return true;
   }
   
   
   private static int partition(Comparable [] a,int low,int high){
	//������ֳ� a[low����j-1] a[j] a[j+1����high]
	 int i=low,j=high+1;
	 Comparable v=a[low];//�Ե�һ��Ϊ�ֽ���
	while(true){
		//���������
	 while(less(a[++i],v))if(i==high)break;	
		//��������� 
	 while(less(v,a[--j]))if(j==low)break;	
		if(i>=j)break;
		exch(a,i,j);
		show(a);
		System.out.println("*"); 
	}   
	   exch(a,low,j);
	   show(a);
		System.out.println("&");
	   return j;
	   
	    
   }
   
   private static void sort(Comparable []a,int low,int high){
	   if(high<=low)return;
	   int j=partition(a,low,high);
	 	  
	   sort(a,low,j-1);
	
	   sort(a,j+1,high);
	
   }
   //����һ��sort����Ҫ�ֶ�����low high
   private static void sort(Comparable []a){
	   sort(a,0,a.length-1);
   }
   
}
/*c++
 * start =0;
 * array[start]=value;
 * while(start<end){
 *   for(;start<end;--end){
 *     if(array[end]<value){
 *     ����һ�����ڻ�׼��
 *     array[start++]=array[end];
 *     ���һ������ֵ����һ������ʱ start=0;
 *     break;
 *     //֮��start=1,
 *     }-----���end����value���ܼ���
    }
        if(;start<end;start++){
 *      if(array[start]>value){
 *      ��ʱstart=1
 *      ��ʱa[1]�Ȼ�׼�� ����͸�ֵ������
 *      array[end--]=array[start];
 *      break;
 *      //end=���
 *      }-----start����value���ܼӼ�
 *     }
 * }
 *   ȫ������֮��
 *   array[start]=value;
 *   qsort(array,start);
 *   qsort(array+start+1,len-start-1);
 *     0 1 2 3 4 5 6 7 
 *    ��һ�� len=8
 *    ����start=4
 *     qsort(ǰ����������һ��index,�ڶ���������)
 *       (0,4)--array,start
 *       (5,3)--array+start+1,len-start-1
 * 
 * 
 * 
 * 
 * 
 * */
