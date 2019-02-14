package com.wuye.z1;
/*1 n个数据量很大，找出最大的k个数或者最小的k个数----topk问题
 * 排序算法                                                o(nlogn)              n
 * 调用初级实现的优先队列                     o(nk)                 k
 * 调用基于堆实现的优先队列                 o(nlogk)              k
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
		pq=(key[]) new Comparable[max+1];//基于二叉树的从 1……N
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	
	
	
}














