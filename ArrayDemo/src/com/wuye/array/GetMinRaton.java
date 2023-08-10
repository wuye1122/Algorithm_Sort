package com.wuye.array;

public class GetMinRaton {
  /*
   *  ��������ת�����������ҵ���С��Ԫ��(����Ԫ�ؿ����ظ�)
   *  
   *  
   *  
   *   1 2 3 4 5 6 7  //��� low<high ˵��˳���Ѿ���������Ҫ���ˡ�
   * 
   * 
   *   ʣ�·���ʹ�õ��Ƕ��ֲ��ҷ�:
   *   4 5 6 7 1 2 3---->
   *   if  mid>high ˵����벿�ֶ��õ�ǰ���� :�ϵ����Ҳ�
   *       low=mid
   *     
   *   7 6 1 2 3 4 5---->
   *                                  
   *   if low>mid ˵���ù���������� ����ù���̫�೬��һ��ͻ�
   *                ����low����С���м�ĵ�������Ľ��:�ϵ������
   *       high=mid
   *   
   *     �����������������:low=mid=high
   *     
   *     �����������:
   *     
   *     
   *     
   *    
   *     3 1 2 3 3 3 3 3 3 3            
   *     
   *     ��ͷ����ʼ����:����low>i  �������
   *     
   *     
   *     4 5 1 2 3 4 4 4 4 4 4 4 
   *     
   *      ��ͷ����ʼ����:����low<i ���������˵�� �ϵ��� [mid=low  high]
   *     
   *      7 7 7 7 7 1 2 3 7
   *      4 4 4 4 4 5 1 2 4
   *      
   *      �������low=midʱ��û�з����쳣:���� [mid high]�������
   *       
   * */
	
	public int getMin(int []a){
		int low=0;
		int high=a.length-1;
		int mid=0;
		
		//���Ƚ���ѭ������ 2�ֲ���
		
		while(low<high){
			
			if(low==high-1){//��ʱ�ж�����������  ֮ǰд����low==a.length-1
				            //low��Զ������� ���ұߵ� while���������� 
				break;
			}
			
			if(a[low]<a[high]){
				return a[low];
				
			}
			
			mid=(low+high)/2;
			//�������2�ֲ���
			
			if(a[low]>a[mid]){
				high=mid;
				
				continue;	
			}
			if(a[mid]>a[high]){
				low=mid;
				continue;	
			}
			
			//��������ǵ���� ֻ����low=mid=high
			
			while(low<mid){//�� low=midʱ���ͷ����ʼ����2�ֲ���--->�൱����벿������ͬ������ ��Ҫ��[mid,high]����2�ֲ��ҡ�
				if(a[low]==a[mid]){
					low++;
				}else if(a[low]<a[mid]){
					return a[low];//��ʱ�൱�� 4 1 2 3 4 4 4 4 ��ͬ�������ֵ
		
				}else{
					//a[low]>a[mid]4 5 1 2 3 4  4 4 4 4 
					//����벿���в�ѯ
					
					high=mid;
					break;//����ѭ�� ��ͷ����ʼ
					
				}
				
			}
			
			
		}
		return Math.min(a[low], a[high]);//��� low��high���� 
		
		
		
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetMinRaton get=new GetMinRaton();
		//int a[]={1,2,3,4,5,6,7};
		int b[]={6,7,1,2,3,4,5};
		int c[]={3,4,5,6,7,1,2};
		
		int d[]={4,4,4,4,4,1,2,3,4};
		
		int e[]={4,5,1,2,4,4,4,4,4,4,4};
		int f[]={4,1,2,3,4,4,4,4,4,4,4};
		
		System.out.println("��ת������Сֵ"+get.getMin(f));
		System.out.println("��ת������Сֵ"+get.getMin(b));
		System.out.println("��ת������Сֵ"+get.getMin(c));
		System.out.println("��ת������Сֵ"+get.getMin(d));
		System.out.println("��ת������Сֵ"+get.getMin(e));
		 
		
	}

}
