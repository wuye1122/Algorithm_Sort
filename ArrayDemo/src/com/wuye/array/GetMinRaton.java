package com.wuye.array;

public class GetMinRaton {
  /*
   *  在有序旋转的数组里面找到最小的元素(数组元素可以重复)
   *  
   *  
   *  
   *   1 2 3 4 5 6 7  //如果 low<high 说明顺序已经基本不需要变了。
   * 
   * 
   *   剩下方法使用的是二分查找法:
   *   4 5 6 7 1 2 3---->
   *   if  mid>high 说明后半部分都拿到前面了 :断点在右侧
   *       low=mid
   *     
   *   7 6 1 2 3 4 5---->
   *                                  
   *   if low>mid 说明拿过来几个大的 如果拿过来太多超过一半就会
   *                导致low处的小于中间的导致上面的结果:断点在左侧
   *       high=mid
   *   
   *     如果不满足上述条件:low=mid=high
   *     
   *     下面三种情况:
   *     
   *     
   *     
   *    
   *     3 1 2 3 3 3 3 3 3 3            
   *     
   *     从头部开始遍历:遇到low>i  上述情况
   *     
   *     
   *     4 5 1 2 3 4 4 4 4 4 4 4 
   *     
   *      从头部开始遍历:遇到low<i 上述情况则说明 断点在 [mid=low  high]
   *     
   *      7 7 7 7 7 1 2 3 7
   *      4 4 4 4 4 5 1 2 4
   *      
   *      如果出现low=mid时候都没有发现异常:则在 [mid high]上面查找
   *       
   * */
	
	public int getMin(int []a){
		int low=0;
		int high=a.length-1;
		int mid=0;
		
		//首先进行循环查找 2分查找
		
		while(low<high){
			
			if(low==high-1){//此时判断跳出的条件  之前写的是low==a.length-1
				            //low永远不会等于 最右边的 while条件在哪呢 
				break;
			}
			
			if(a[low]<a[high]){
				return a[low];
				
			}
			
			mid=(low+high)/2;
			//下面进行2分查找
			
			if(a[low]>a[mid]){
				high=mid;
				
				continue;	
			}
			if(a[mid]>a[high]){
				low=mid;
				continue;	
			}
			
			//如果都不是的情况 只能是low=mid=high
			
			while(low<mid){//但 low=mid时候从头部开始进行2分查找--->相当于左半部都是相同的数字 需要从[mid,high]进行2分查找。
				if(a[low]==a[mid]){
					low++;
				}else if(a[low]<a[mid]){
					return a[low];//此时相当于 4 1 2 3 4 4 4 4 相同的是最大值
		
				}else{
					//a[low]>a[mid]4 5 1 2 3 4  4 4 4 4 
					//在左半部进行查询
					
					high=mid;
					break;//跳出循环 从头部开始
					
				}
				
			}
			
			
		}
		return Math.min(a[low], a[high]);//最后 low和high紧邻 
		
		
		
		
		
		
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
		
		System.out.println("旋转数组最小值"+get.getMin(f));
		System.out.println("旋转数组最小值"+get.getMin(b));
		System.out.println("旋转数组最小值"+get.getMin(c));
		System.out.println("旋转数组最小值"+get.getMin(d));
		System.out.println("旋转数组最小值"+get.getMin(e));
		 
		
	}

}
