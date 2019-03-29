package com.wuye.array;

public class GetJubuLess {

	/*
	 * ��֪��һ���������������ֵ�����  ��������һ���ֲ���С��ֵ
	 * 
	 * if���м� ���� ��������  ����ı����
	 * 
	 * if������ a[1]�����
	 * 
	 * if������  a[length-2]�����
	 * 
	 * 
	 * ʹ�ö��ֲ��ҷ�  O(logN); O(1)
	 * 
	 *   left----->
	 *       <-----right            
	 *              
	 *              
	 * */
	
	public  int getless(int [] a){
		if(a==null||a.length==0){
			return -1;
		}
		
		if(a.length==1||a[0]<a[1]){//����
			return 0;
		}
		if(a[a.length-1]<a[a.length-2]){
			return a.length-1;
		}
		
		int left=1;
		int right=a.length-2;
		int mid=0;
		while(left<right){
			mid=(left+right)/2;
			
			if(a[mid]>a[mid-1]){
				right=mid-1;
				
			}else if(a[mid]>a[mid+1]){
				left=mid+1;
			}else{
				
				return mid;
			}
			
			
			
		}
		return left;
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a []={1,2,3,4,5};
		int b []={2,3,4,5,0};
		int c []={42,35,6,8,7,23};
		GetJubuLess gg=new GetJubuLess();
		System.out.println(gg.getless(a));
		System.out.println(gg.getless(b));
		System.out.println(gg.getless(c));
	}

}
