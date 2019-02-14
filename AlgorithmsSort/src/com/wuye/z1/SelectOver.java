package com.wuye.z1;
/*1 关于重复数的个数问题
 *  a给定数字的重复出现的次数--利用排序，二分查找法
 *   (8>>n缩小n倍  8<<n扩大n倍)
 *2逆序数问题 
 * 
 * 
 * */

public class SelectOver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*      System.out.println(Integer.toBinaryString(16)+" "+16);
		      System.out.println(Integer.toBinaryString(8)+" "+8);
		      System.out.println(Integer.toBinaryString(4)+" "+4);
		      System.out.println(Integer.toBinaryString(2)+" "+2);
               System.out.println(8>>1>>1);
               System.out.println(8>>2);
               System.out.println(8<<1);
               System.out.println(8<<2);*/
		int []a={1,2,2,2,8,8,8,10,11,12,13};// 0 1 2 3 4 5 6
		//二分
	//重复的不准	System.out.println("数组中值为8的所以号为"+binarySearch(a,8));
		//count()每个数重复度
		System.out.println("数组里面等于8的一共"+Count(a,8));
		Integer [] a1={1,2,2,3,8,8,9,10,11,12,13};
		System.out.println("------不重复元素"+Count(a1)+"------其余剩下的共"+(a.length-Count(a1))+"和前面重复的");
		int [] b=new int[a.length];
		System.out.println("");
		System.out.println("-----不重复的元素个数只出现一次的个数"+CountOnly(a,b));
		System.out.println("");
		//System.out.println(+CountOnly(a,b));
		
		System.out.println("重复度的数组");
		 for(int t:b){
			 System.out.print(t+"*");	 
		 }
		 System.out.println("");
		 System.out.println("原数组数组");
		 for(int e:a){
			 System.out.print(e+"*");	 
		 }
		
	}   
	//结合binarySearch()方法能够指定目标出现的次数
	public static int Count(int [] array,int value){
		 int count=0;
		 int beginIndex=binarySearch(array,value);
		 if(beginIndex==-1){//---直接转到56行 找不到value
			 System.out.print("你所查找的数不在该数组里面,即");
			 return 0;
		 }
		 for(int i=0;i<array.length;i++){
			 if(array[i]==value)
			 count++;
			 if(array[i]>value){
				 break;
			 }
		 }		
		return count;		
	}
	
	
	
    //二分查找法,只是找到目标值所在的index，，并不支持重复的
	public static int binarySearch(int []array,int value){
		int low=0;
		int high=array.length;
		while(low<=high){
		  	int mid=(low+high)>>1;
		    int midValue=array[mid];
		    if(midValue>value)high=mid-1;
		    else if(midValue<value)low=mid+1;
		    else return mid;
		}				
		return -1;		
	}
	//统计元素不重复的个数,也就是出去多余的
	public static int Count(Comparable [] a){
		int count=1;
		for(int i=1;i<a.length;i++){
			if(a[i].compareTo(a[i-1])!=0)
				count++;		
		}
		return count;		
	}
	//记录不重复
	public static int CountOnly(int []a,int []b){
		int count=0;
		
		for(int i=0;i<b.length;i++){
			b[i]=Count(a,a[i]);
			if(b[i]==1)
				count++;
		}
	
		return count;
		
	}
	//出现频率最多的元素是   重复元素分别出现的个数
}
