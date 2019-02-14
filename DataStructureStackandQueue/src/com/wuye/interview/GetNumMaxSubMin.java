package com.wuye.interview;

import java.util.LinkedList;

public class GetNumMaxSubMin {

	/*
	 *  ***找出数组里面最大值减去最小值<=num子数组个数
	 *  
	 *  最优解做到时间复杂度 O(N)  空间复杂度(N)
	 *  
	 *  
	 *  思路：1 如果arr[i..j]满足条件的情况 其子数组 j-i都满足
	 *       因为arr[i..j-1]  最大值不会大于原来的  最小值不会小于上面的
	 *  
	 *      2如果如果arr[i..j]不满足条件所有包含它的都不成立
	 * 
	 *     i 1 2 3 ....j 一直到不满足
	 *       1 2 3 ....j 一直到不满足
	 *             ....j
	 *            .j-1 j    
	 * 
	 *     子数组的个数:n(n+1)/2
	 *     子集的个数:2^n
	 *    
	 *     整理好上面一次循环的个数j-1
	 *     并且将跟i有关的大小值全部去掉。
	 *     每次循环之后i++;
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
	
	
	//首先考虑特殊情况
	if(arr.length==0||arr==null){
		return 0;	
	}
	
	//全局变量 和 定义所有使用的类 数据结构
	int i=0; //头
	int j=0; //尾
	int res=0;//满足条件的个数
	
	//定义存每一行 最大值的双端队列
	LinkedList<Integer> qmin=new LinkedList<>();

	//定义存每一行 最小值的双端队列
	LinkedList<Integer> qmax=new LinkedList<>();
	
	
	while(i<arr.length){
      while(j<arr.length){
    	  
    	  //首先存入最大值
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
      //一行循环完
    	  if(qmax.peekFirst()==i){
    		  qmax.pollFirst();
    		  
    	  }
    	  if(qmin.peekFirst()==i){
    		  qmin.pollFirst();
    		  
    	  }
     //将当前首元素删除	  
    	  res+=j-i;
    	  i++;
    //换新一行	  
      }
		
	
	return res;
 
}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int aa[]={1,4,5,6,23};//小于等于num的个数
		System.out.println(getNum(aa,1));
		System.out.println(getNum(aa,2));
		System.out.println(getNum(aa,100));
		System.out.println(getNum(aa,200));
		

		
//		System.out.println(getNum(a,1));// {1} {3} 最大值减最小值都是0
//		System.out.println(getNum(a,2));// {1} {3} {1,3}总共三种情况
		int a[]={1,3};//小于等于num的个数=3
		System.out.println("两个值子数组"+getNum(a,200));
		int b[]={1,3,5};
		//{1}{3}{5}{1,3}{1,5}{3,5}
		System.out.println("三个值子数组"+getNum(b,200));
		int c[]={1,3,5,6};
		
		//{1}{3}{5}{6}{1,3}{1,3,5}{1,3,5,6}{3,5}{3,5,6}{5,6}
		System.out.println("四个值子数组"+getNum(c,200));
		int d[]={1,3,5,6,8};
		System.out.println("五个值子数组"+getNum(d,200));
		int e[]={1,3,5,6,10,33};
		System.out.println("六个值子数组"+getNum(e,200));
		int ab=Integer.MIN_VALUE;
		System.out.println(ab);
	}

}
