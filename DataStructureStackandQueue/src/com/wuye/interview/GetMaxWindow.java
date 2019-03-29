package com.wuye.interview;

import java.util.LinkedList;

public class GetMaxWindow {

	/*    ***��ȡ�������ֵ����
	 * 
	 * 
	 *   [4 3 5] 4 3 3 6 7
	 *   4 [3 5 4] 3 3 6 7
	 *   .....
	 *   4 3 5 4 [3 3 6] 7
	 *   4 3 5 4 3 [3 6 7]
	 * 
	 *    �������� arr  ���ڳ���w
	 *    
	 *    ���յĵ������ֵ���� res[arr-w+1] res[i]����ÿ���ƶ������ֵ
	 *   
	 *    ʱ�临�ӶȴﵽO(N)---����ĳ��ȡ�
	 * 
	 * 
	 * */
	public static int[] getMaxWindow(int[]arr,int w){
		
		
		if(arr==null||w<0||arr.length<w){
			return null;
			
		}
		//�������鿪ʼ����
		int index=0;
		//����һ��˫���б������ϴ�arr���±�
		LinkedList<Integer> qmax=new LinkedList<Integer>();
		//����һ�������ָ��ֵ������
		int [] res=new int[arr.length-w+1];
		//��˫����н���һ��ѭ��
		
		for(int i=0;i<arr.length;i++){
			//ֻҪ˫�����������ֵ ��ĩ��ֵС�ڵ�ǰiֵ �ͽ���ɾ��
			while(!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[i]){
				qmax.pollLast();
			}
			//ֻ�е���������Ϊnull����i����ֵС�������β ����Ԫ��
			qmax.addLast(i);
		
		
		
		//�����ͷ��ֵ����i-w �����ͷ�Ѿ�����
	    //4 3 5 4 3 3 6 7   2
		
		if(qmax.peekFirst()==i-w){
			qmax.pollFirst();
		}
		//ֻҪѭ����2֮���ȡ�����ֵ 
		
		if(i>=w-1){
			
			res[index++]=arr[qmax.peekFirst()];
		}
		
		
		
		
		
		
		
		
		
		}
		return res;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//��Ϥ����ĸ����ܣ�
//		LinkedList<Integer> ll=new LinkedList<Integer>();
//		ll.add(22);
//		ll.add(33);
//		ll.add(44);
//		ll.add(23);
//		ll.add(11);
//		System.out.println("------����------"+ll);
//		System.out.println("-----peekLast-----"+ll.peekLast());
//		System.out.println("-----peekFirst------"+ll.peekFirst());
//		System.out.println("-----pollLast-----"+ll.pollLast());
//		System.out.println("-----pollFirst------"+ll.pollFirst());
//		System.out.println("------����------"+ll);
		int []temp={4,3,5,4,3,3,6,7};
		int []a;
		a=getMaxWindow(temp,3);
		for(int b:a){
			System.out.println("ÿ�ε����ֵ��"+b);
			
		}
		
	}

}
