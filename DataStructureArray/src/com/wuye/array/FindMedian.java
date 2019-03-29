package com.wuye.array;

public class FindMedian {

	
	/*
	 *   1 �������鳤����� �� �����ź�˳���
	 *   
	 *  ���� arr1[a,b,c,d,e]   arr2[a1,b1,c1,d1,e1]
	 *   
	 *  ż�� arr1[a,b,c,d]   arr2[a1,b1,c1,d1]
	 *   
	 *   �����ж�:�Ƚ��м�ֵ Ȼ��ȷ��ɸѡ��Χ֮�� ���ж��ֲ��ҷ�
	 * 
	 *   ���һ: ������������mid=mid1
	 * 
	 *         �м���ֱ�ӷ��� c||c1 (�������� ż��)
	 * 
	 *   �����: ���� c>c1
	 *   
	 *         ������λ��    :
	 *         
	 *         �ȿ��ܹ��жϳ���С��: d e�ڵ���������Ϊd��õ������ǰ��������
	 *                                  abca1b1c1 
	 *                        b1 С�������� b1������ aba1b1�ŵ�����
	 *                        
	 *          ����:(a b c) (c1 d1 e1)
	 *              end1=mid1   start2=mid2
	 *              
	 *          ���ż�������                  
	 *            (a c)  (c1 d1)
	 *              end1=mid1   start2=mid2+1
	 *              
	 *                         
	 *   �����: ����c<c1                      
	 *          
	 *         ������λ��    : 
	 *   
	 *        ()      start1=mid1
	 *      ()        end2=mid2   
	 *   
	 *         ()     start1=mid1+1
	 *       ()       end2=mid2
	 *   
	 *   
	 *   
	 *   
	 * 
	 * */
	
	public int getMidian(int []a,int []b){
		if(a==null||b==null||a.length!=b.length){
			throw new RuntimeException("your is wrong");
		}
		
		int start1=0;
		int end1=a.length-1;
		int mid1=0;
		int start2=0;
		int end2=b.length-1;
		int mid2=0;
		int offset=0;//��������������
		
		while(start1<end1){
			mid1=(end1+start1)/2;
			 mid2=(end2+start2)/2;
			//����ż�� һ��Ҫ��ѭ������ �ж�ÿһ��ʣ����������ż��
			//�з�ҲҪÿһ�� ���з� ��Ȼ�������������������Խ���쳣
			offset=((end1-start1+1)&1)^1;
			
			
			
			// ����ԭ��:�����ҳ�����ż����ʱ�� ʹ�õĲ�������ĳ���  ���Ƕ���֮��ĳ���
			//
			//
			//
			if(a[mid1]>b[mid2]){
				end1=mid1;
				start2=mid2+offset;
				
			}else if(a[mid1]<b[mid2]){
				start1=mid1+offset;
				end2=mid2;
				
			}else{
				
				return a[mid1];
			}
			
		}
		return Math.min(a[start1], b[start2]);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMedian ff=new FindMedian();
		//λ���㡣
		System.out.println((6&1)^1);
		System.out.println((5&1)^1);
		System.out.println("------------");
		int a[]={1,2,4,6,8};
		int b[]={2,3,4,9,10};
		//1 2   2   3     4 4 6   8   9 10
		System.out.println(ff.getMidian(a, b));
		int a1[]={2,4,6,8};
		int b1[]={3,4,19,20};
		// 2 3   4 4  6 8 19 20
		System.out.println(ff.getMidian(a1, b1));
		
		
		
		
		
		
		int a2[]={2,5,6,7,10};
		int b2[]={1,2,3,6,7};
		
		// 1 2 2  3 5 6 6 7  7  10//5
		System.out.println(" ���� "+ff.getMidian(a2, b2));
		int a3[]={2,5,6,7};
		int b3[]={1,2,3,6};
		
		// 1 2 2 3 5 6 6 7   //3
		System.out.println(" ����  "+ff.getMidian(a3, b3));
		
		
		
		int a4[]={1,2,3,6,7};
		int b4[]={2,5,6,7,10};
		
		//
		System.out.println(" С�� "+ff.getMidian(a4, b4));
		int a5[]={1,2,3,6};
		int b5[]={2,5,6,7};
		System.out.println(" С�� "+ff.getMidian(a5, b5));
	}

}
