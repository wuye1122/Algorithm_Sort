package com.wuye.z1;
/*1 �����ظ����ĸ�������
 *  a�������ֵ��ظ����ֵĴ���--�������򣬶��ֲ��ҷ�
 *   (8>>n��Сn��  8<<n����n��)
 *2���������� 
 * 
 * 
 * */

public class SelectOver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*      System.out.println(Integer.toBinaryString(16)+" "+16);
		      System.out.println(Integer.toBinaryString(8)+" "+8);
		      System.out.println(Integer.toBinaryString(4)+" "+4);
		      System.out.println(Integer.toBinaryString(2)+" "+2);
               System.out.println(8>>1>>1);
               System.out.println(8>>2);
               System.out.println(8<<1);
               System.out.println(8<<2);*/
		int []a={1,2,2,2,8,8,8,10,11,12,13};// 0 1 2 3 4 5 6
		//����
	//�ظ��Ĳ�׼	System.out.println("������ֵΪ8�����Ժ�Ϊ"+binarySearch(a,8));
		//count()ÿ�����ظ���
		System.out.println("�����������8��һ��"+Count(a,8));
		Integer [] a1={1,2,2,3,8,8,9,10,11,12,13};
		System.out.println("------���ظ�Ԫ��"+Count(a1)+"------����ʣ�µĹ�"+(a.length-Count(a1))+"��ǰ���ظ���");
		int [] b=new int[a.length];
		System.out.println("");
		System.out.println("-----���ظ���Ԫ�ظ���ֻ����һ�εĸ���"+CountOnly(a,b));
		System.out.println("");
		//System.out.println(+CountOnly(a,b));
		
		System.out.println("�ظ��ȵ�����");
		 for(int t:b){
			 System.out.print(t+"*");	 
		 }
		 System.out.println("");
		 System.out.println("ԭ��������");
		 for(int e:a){
			 System.out.print(e+"*");	 
		 }
		
	}   
	//���binarySearch()�����ܹ�ָ��Ŀ����ֵĴ���
	public static int Count(int [] array,int value){
		 int count=0;
		 int beginIndex=binarySearch(array,value);
		 if(beginIndex==-1){//---ֱ��ת��56�� �Ҳ���value
			 System.out.print("�������ҵ������ڸ���������,��");
			 return 0;
		 }
		 for(int i=0;i<array.length;i++){
			 if(array[i]==value)
			 count++;
			 if(array[i]>value){
				 break;
			 }
		 }		
		return count;		
	}
	
	
	
    //���ֲ��ҷ�,ֻ���ҵ�Ŀ��ֵ���ڵ�index��������֧���ظ���
	public static int binarySearch(int []array,int value){
		int low=0;
		int high=array.length;
		while(low<=high){
		  	int mid=(low+high)>>1;
		    int midValue=array[mid];
		    if(midValue>value)high=mid-1;
		    else if(midValue<value)low=mid+1;
		    else return mid;
		}				
		return -1;		
	}
	//ͳ��Ԫ�ز��ظ��ĸ���,Ҳ���ǳ�ȥ�����
	public static int Count(Comparable [] a){
		int count=1;
		for(int i=1;i<a.length;i++){
			if(a[i].compareTo(a[i-1])!=0)
				count++;		
		}
		return count;		
	}
	//��¼���ظ�
	public static int CountOnly(int []a,int []b){
		int count=0;
		
		for(int i=0;i<b.length;i++){
			b[i]=Count(a,a[i]);
			if(b[i]==1)
				count++;
		}
	
		return count;
		
	}
	//����Ƶ������Ԫ����   �ظ�Ԫ�طֱ���ֵĸ���
}
