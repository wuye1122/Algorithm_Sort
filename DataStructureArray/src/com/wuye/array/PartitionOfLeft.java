package com.wuye.array;

public class PartitionOfLeft {
/*  
 * 
 * 时间复杂度o(n)   空间复杂度o(1)
 *  给定一个有序数组  调整数组的使其左半部分  没有重复元素 不需要管右半部分是否有序
 *  
 *  
 *  补充的题目:
 *  
 *     给定一个数组   若干012  实现排序
 *     
 *       
 *     另一种问法:一个袋子有若干个球 其中有黄红蓝
 *             要求:红色必须在左面 黄色在中间  蓝色在右侧
 *             
 *     另一种问法: 有一个数组  实现比k小的数在其左边 大于的在其右侧
 *             等于k的数在其中间  
 *                        
 * 
 *     思路 index始终代表中间的数 如果遇到
 *     
 *     划分三个区域 index是中间区最右侧的
 *     -1[0 0 1 2 0 1]a.length
 *              1 0 2   
 *     进行模拟:如果遇到0--->lef始终++left idnex++为左面腾出空间 
 *       
 *           如果遇到2--->index right--交换即可    
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
//另一种高大上的问题:
//将 对三种类型的数进行排序	
	
	public static void sort1(int []a){
		if(a==null||a.length<2){
			return;
		}
		
		int left=-1;
		int index=0;
		int right=a.length;
		
		while(index<right){
			if(a[index]==0){
				swap(a,++left,index++);//需要先加因为最开始-1
			}else if (a[index]==2){
				swap(a,index,--right);//需要先减 因为最开始a.length
			}else{
				index++;
			}
			
			
		}
		
	}
	
	
	
	
	
//类似的 1 1 2 2 3 4 5 5 6 7 实际上就是筛选出 不重复的
//	
//	
//	
	public static void leftUnque(int []a){
		if(a.length<2||a==null){
			return;
		}
		
		int i=1;//进行向右侧遍历
		int u=0;//u一直指向已经排好序的左侧的元素
		while(i!=a.length){
			if(a[i++]!=a[u]){
				
				//如果等于的情况 i++
				swap(a,++u,i-1);//如果发现不等于最后一个数 马上交换
				                //因为i始终保持当前元素的后一个  所以i-1 
				
			}
			
		}
		
		
	}
	
	
//首先 第一种情况 
	
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
