package com.wuye.array;


/*
 * **��һ����λ���������ҵ�һ����  ���ϵ��������𽥱���
 *   �ж�һ�����Ƿ�����������
 *   �����˼·������Ǵ����Ͻǿ�ʼ����
 *   
 *   1 ͨ��˼ά �����濪ʼ��  ���>������û����
 *                      <��ô���������֮��Ĳ�������η�Χ�ڽ��в���
 *                      �ܲ�����
 *                      
 *   2 ��������Ͻǽ��в��� ���>ȥ��һ��
 *                   ���<ȥ��һ��
 *                      =����                   
 *    
 *   3 ������������������Ի�,ע�������淶                   
 * 
 *  1 2 8 9
 *  2 4 9 10
 *  3 5 12 11 
 *  6 7 14 17
 * 
 * 
 * 
 * */
public class FindFromOrderArray {

	public static boolean findFromOrderArray(int[][] a,int row,int colum,int num ){

		boolean flag=false;

		//��Ҫ���ǵ������

		if(a!=null&&row>0&&colum>0){

			int r=0;
			int co=colum-1;

			while(r<row&&co>=0){
				//rһֱ���� coһֱ��С	
				if(a[r][co]==num){
					flag=true;
					break;//����ѭ��
				}
				else if(a[r][co]>num)

					--co;

				else
					++r;


		}
	}
	
	
	
	return flag;
	

}	

public static void main(String []args){
	
	int [][]a={{1,2,8,9},{2,4,9,10},{3,5,12,11},{6,7,14,17}};

	System.out.println(FindFromOrderArray.findFromOrderArray(a, 4, 4, 7));
	
}
	
	
}
