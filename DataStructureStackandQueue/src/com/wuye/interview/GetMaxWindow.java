package com.wuye.interview;

import java.util.LinkedList;

public class GetMaxWindow {

	/*    ***获取窗口最大值数组
	 * 
	 * 
	 *   [4 3 5] 4 3 3 6 7
	 *   4 [3 5 4] 3 3 6 7
	 *   .....
	 *   4 3 5 4 [3 3 6] 7
	 *   4 3 5 4 3 [3 6 7]
	 * 
	 *    给定数组 arr  窗口长度w
	 *    
	 *    最终的到的最大值长度 res[arr-w+1] res[i]代表每次移动的最大值
	 *   
	 *    时间复杂度达到O(N)---数组的长度。
	 * 
	 * 
	 * */
	public static int[] getMaxWindow(int[]arr,int w){
		
		
		if(arr==null||w<0||arr.length<w){
			return null;
			
		}
		//定义数组开始索引
		int index=0;
		//定义一个双向列表来不断存arr的下标
		LinkedList<Integer> qmax=new LinkedList<Integer>();
		//定义一个存最大指定值得数组
		int [] res=new int[arr.length-w+1];
		//对双向队列进行一次循环
		
		for(int i=0;i<arr.length;i++){
			//只要双向队列里面有值 其末端值小于当前i值 就将其删除
			while(!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[i]){
				qmax.pollLast();
			}
			//只有当队列里面为null或者i处的值小就填入队尾 加入元素
			qmax.addLast(i);
		
		
		
		//如果队头的值等于i-w 代表队头已经过期
	    //4 3 5 4 3 3 6 7   2
		
		if(qmax.peekFirst()==i-w){
			qmax.pollFirst();
		}
		//只要循环到2之后就取出最大值 
		
		if(i>=w-1){
			
			res[index++]=arr[qmax.peekFirst()];
		}
		
		
		
		
		
		
		
		
		
		}
		return res;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//熟悉链表的个功能：
//		LinkedList<Integer> ll=new LinkedList<Integer>();
//		ll.add(22);
//		ll.add(33);
//		ll.add(44);
//		ll.add(23);
//		ll.add(11);
//		System.out.println("------链表------"+ll);
//		System.out.println("-----peekLast-----"+ll.peekLast());
//		System.out.println("-----peekFirst------"+ll.peekFirst());
//		System.out.println("-----pollLast-----"+ll.pollLast());
//		System.out.println("-----pollFirst------"+ll.pollFirst());
//		System.out.println("------链表------"+ll);
		int []temp={4,3,5,4,3,3,6,7};
		int []a;
		a=getMaxWindow(temp,3);
		for(int b:a){
			System.out.println("每次的最大值是"+b);
			
		}
		
	}

}
