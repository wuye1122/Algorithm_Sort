package com.wuye.array;

public class PartitionOfLeft {
/*  
 * 
 * ʱ�临�Ӷ�o(n)   �ռ临�Ӷ�o(1)
 *  ����һ����������  ���������ʹ����벿��  û���ظ�Ԫ�� ����Ҫ���Ұ벿���Ƿ�����
 *  
 *  
 *  �������Ŀ:
 *  
 *     ����һ������   ����012  ʵ������
 *     
 *       
 *     ��һ���ʷ�:һ�����������ɸ��� �����лƺ���
 *             Ҫ��:��ɫ���������� ��ɫ���м�  ��ɫ���Ҳ�
 *             
 *     ��һ���ʷ�: ��һ������  ʵ�ֱ�kС����������� ���ڵ������Ҳ�
 *             ����k���������м�  
 *                        
 * 
 *     ˼· indexʼ�մ����м���� �������
 *     
 *     ������������ index���м������Ҳ��
 *     -1[0 0 1 2 0 1]a.length
 *              1 0 2   
 *     ����ģ��:�������0--->lefʼ��++left idnex++Ϊ�����ڳ��ռ� 
 *       
 *           �������2--->index right--��������    
 *           
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
//��һ�ָߴ��ϵ�����:
//�� ���������͵�����������	
	
	public static void sort1(int []a){
		if(a==null||a.length<2){
			return;
		}
		
		int left=-1;
		int index=0;
		int right=a.length;
		
		while(index<right){
			if(a[index]==0){
				swap(a,++left,index++);//��Ҫ�ȼ���Ϊ�ʼ-1
			}else if (a[index]==2){
				swap(a,index,--right);//��Ҫ�ȼ� ��Ϊ�ʼa.length
			}else{
				index++;
			}
			
			
		}
		
	}
	
	
	
	
	
//���Ƶ� 1 1 2 2 3 4 5 5 6 7 ʵ���Ͼ���ɸѡ�� ���ظ���
//	
//	
//	
	public static void leftUnque(int []a){
		if(a.length<2||a==null){
			return;
		}
		
		int i=1;//�������Ҳ����
		int u=0;//uһֱָ���Ѿ��ź��������Ԫ��
		while(i!=a.length){
			if(a[i++]!=a[u]){
				
				//������ڵ���� i++
				swap(a,++u,i-1);//������ֲ��������һ���� ���Ͻ���
				                //��Ϊiʼ�ձ��ֵ�ǰԪ�صĺ�һ��  ����i-1 
				
			}
			
		}
		
		
	}
	
	
//���� ��һ����� 
	
	public static void swap(int [] a,int left,int right){
		int tem=0;
		tem=a[left];
		a[left]=a[right];
		a[right]=tem;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
   int []a={1,1,2,2,3,4,4,5,5,5,5,6,7};		
   PartitionOfLeft.leftUnque(a);
   for(int b:a){
	   System.out.print(b+"-");
   }
   System.out.println("----------------------");
   
   int []b={0,1,2,2,1,0,1,2,0,1,0};
   PartitionOfLeft.sort1(b);
   for(int c:b){
	   System.out.print(c+"-");
   }
	}

}
