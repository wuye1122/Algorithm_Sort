package com.wuye.z1;
/*1 n���������ܴ��ҳ�����k����������С��k����----topk����
 * �����㷨                                                o(nlogn)              n
 * ���ó���ʵ�ֵ����ȶ���                     o(nk)                 k
 * ���û��ڶ�ʵ�ֵ����ȶ���                 o(nlogk)              k
 * 
 * 
 * 
 * 
 * 
*/
public class Topk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int K=Integer.parseInt(args[0]);
       Integer k=10;
       
       MaxPQ<Integer> pq=new MaxPQ<Integer>(K);
		
				
	}
	
}
class MaxPQ<key extends Comparable<key>>{
	private int N=0;
	private key[] pq;
	
	public MaxPQ(int max){
		pq=(key[]) new Comparable[max+1];//���ڶ������Ĵ� 1����N
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	
	
	
}














