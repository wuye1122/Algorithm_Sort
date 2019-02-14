package com.wuye.quick;
/*1 快速排序是分治的思想
 * 选出一个基准pivot将数组分为两部分 一部分不大于基准的 另一部分不小于基准的
 * 然后递归快排将左右子数组分别进行排序
 * 2选择切分的时候从左边扫描第一个大一基准的 和右边扫描第一小于基准的将其调换位置
 * 直至两面扫描碰到一起 然后将切分数和中间替换
 * 3快速排序的时间主要耗费在划分上了 对于长度为k的区间进行操作 共需要k-1次划分
 * 
 * */
public class Quick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integer [] i={12,34,45,68,1,32,3,5,11,455};
		//sort(i);
		//show(i);
		
		Double b[]=new Double[6];
		for(int i=0;i<6;i++){
			b[i]=Math.random();
		  System.out.println(b[i]);	
		  
		}
		sort(b);
		show(b);
	}
	private static boolean less(Comparable a,Comparable b){
		return a.compareTo(b)<0;
	}
   private static void exch(Comparable [] a,int i,int j){
	   Comparable t=a[i];
	   a[i]=a[j];
	   a[j]=t;
   }
   private static void show(Comparable [] a){
	   for(int i=0;i<a.length;i++){
		  
		   System.out.print(a[i]+" ");	
		
	   } 
	}
   public static boolean isSorted(Comparable [] a){
	   for(int i=1;i<a.length;i++){
		   if(less(a[i],a[i-1])){
			   return false;
		   }
	   }
	   return true;
   }
   
   
   private static int partition(Comparable [] a,int low,int high){
	//讲数组分成 a[low……j-1] a[j] a[j+1……high]
	 int i=low,j=high+1;
	 Comparable v=a[low];//以第一个为分界线
	while(true){
		//如果是逆序
	 while(less(a[++i],v))if(i==high)break;	
		//如果是升序 
	 while(less(v,a[--j]))if(j==low)break;	
		if(i>=j)break;
		exch(a,i,j);
		show(a);
		System.out.println("*"); 
	}   
	   exch(a,low,j);
	   show(a);
		System.out.println("&");
	   return j;
	   
	    
   }
   
   private static void sort(Comparable []a,int low,int high){
	   if(high<=low)return;
	   int j=partition(a,low,high);
	 	  
	   sort(a,low,j-1);
	
	   sort(a,j+1,high);
	
   }
   //增加一个sort不需要手动输入low high
   private static void sort(Comparable []a){
	   sort(a,0,a.length-1);
   }
   
}
/*c++
 * start =0;
 * array[start]=value;
 * while(start<end){
 *   for(;start<end;--end){
 *     if(array[end]<value){
 *     最后的一个大于基准数
 *     array[start++]=array[end];
 *     最后一个数赋值给第一个数此时 start=0;
 *     break;
 *     //之后start=1,
 *     }-----如果end大于value才能减减
    }
        if(;start<end;start++){
 *      if(array[start]>value){
 *      此时start=1
 *      此时a[1]比基准大 将其和赋值给最后的
 *      array[end--]=array[start];
 *      break;
 *      //end=最后
 *      }-----start大于value才能加加
 *     }
 * }
 *   全部完事之后
 *   array[start]=value;
 *   qsort(array,start);
 *   qsort(array+start+1,len-start-1);
 *     0 1 2 3 4 5 6 7 
 *    第一次 len=8
 *    假设start=4
 *     qsort(前面代表数组第一个index,第二个代表长度)
 *       (0,4)--array,start
 *       (5,3)--array+start+1,len-start-1
 * 
 * 
 * 
 * 
 * 
 * */
