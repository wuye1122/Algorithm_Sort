package com.wuye.interview;

import java.util.LinkedList;

public class GetNumMaxSubMin {

	/*
	 *  ***�ҳ������������ֵ��ȥ��Сֵ<=num���������
	 *  
	 *  ���Ž�����ʱ�临�Ӷ� O(N)  �ռ临�Ӷ�(N)
	 *  
	 *  
	 *  ˼·��1 ���arr[i..j]������������� �������� j-i������
	 *       ��Ϊarr[i..j-1]  ���ֵ�������ԭ����  ��Сֵ����С�������
	 *  
	 *      2������arr[i..j]�������������а������Ķ�������
	 * 
	 *     i 1 2 3 ....j һֱ��������
	 *       1 2 3 ....j һֱ��������
	 *             ....j
	 *            .j-1 j    
	 * 
	 *     ������ĸ���:n(n+1)/2
	 *     �Ӽ��ĸ���:2^n
	 *    
	 *     ���������һ��ѭ���ĸ���j-1
	 *     ���ҽ���i�йصĴ�Сֵȫ��ȥ����
	 *     ÿ��ѭ��֮��i++;
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
public static int getNum(int [] arr,int num){
	
	
	//���ȿ����������
	if(arr.length==0||arr==null){
		return 0;	
	}
	
	//ȫ�ֱ��� �� ��������ʹ�õ��� ���ݽṹ
	int i=0; //ͷ
	int j=0; //β
	int res=0;//���������ĸ���
	
	//�����ÿһ�� ���ֵ��˫�˶���
	LinkedList<Integer> qmin=new LinkedList<>();

	//�����ÿһ�� ��Сֵ��˫�˶���
	LinkedList<Integer> qmax=new LinkedList<>();
	
	
	while(i<arr.length){
      while(j<arr.length){
    	  
    	  //���ȴ������ֵ
    	  while(!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[j]){
    		  qmax.pollLast();
    	  }
    	  qmax.addLast(j);
    	  
    	  while(!qmin.isEmpty()&&arr[qmin.peekLast()]>=arr[j]){
    		  qmin.pollLast();
    	  }
    	  qmin.addLast(j);
    	  
    	  if(arr[qmax.getFirst()]-arr[qmin.getFirst()]>num){
    		  break;
    	
    	  }
    	  j++;
    	  }
      //һ��ѭ����
    	  if(qmax.peekFirst()==i){
    		  qmax.pollFirst();
    		  
    	  }
    	  if(qmin.peekFirst()==i){
    		  qmin.pollFirst();
    		  
    	  }
     //����ǰ��Ԫ��ɾ��	  
    	  res+=j-i;
    	  i++;
    //����һ��	  
      }
		
	
	return res;
 
}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int aa[]={1,4,5,6,23};//С�ڵ���num�ĸ���
		System.out.println(getNum(aa,1));
		System.out.println(getNum(aa,2));
		System.out.println(getNum(aa,100));
		System.out.println(getNum(aa,200));
		

		
//		System.out.println(getNum(a,1));// {1} {3} ���ֵ����Сֵ����0
//		System.out.println(getNum(a,2));// {1} {3} {1,3}�ܹ��������
		int a[]={1,3};//С�ڵ���num�ĸ���=3
		System.out.println("����ֵ������"+getNum(a,200));
		int b[]={1,3,5};
		//{1}{3}{5}{1,3}{1,5}{3,5}
		System.out.println("����ֵ������"+getNum(b,200));
		int c[]={1,3,5,6};
		
		//{1}{3}{5}{6}{1,3}{1,3,5}{1,3,5,6}{3,5}{3,5,6}{5,6}
		System.out.println("�ĸ�ֵ������"+getNum(c,200));
		int d[]={1,3,5,6,8};
		System.out.println("���ֵ������"+getNum(d,200));
		int e[]={1,3,5,6,10,33};
		System.out.println("����ֵ������"+getNum(e,200));
		int ab=Integer.MIN_VALUE;
		System.out.println(ab);
	}

}
