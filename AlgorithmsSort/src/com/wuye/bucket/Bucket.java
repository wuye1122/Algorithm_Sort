package com.wuye.bucket;

import java.util.LinkedList;
import java.util.List;

import com.wuye.insertion.Insertion;
 //桶子法 bucket (箱排序)
//工作的原理:是将数组分到有限数量的桶子里。每个桶子再个别排序
//桶排序是鸽巢排序的一种归纳结果

//假定：输入是由一个随机过程产生的[0, 1)区间上均匀分布的实数。将区间[0, 1)划分为n个大小相等的子区间（桶）
 //每桶大小1/n:[0, 1/n), [1/n, 2/n),[2/n, 3/n)…[k/n, (k+1)/n )……
 //将n个输入元素分配到这些桶中，对桶中元素进行排序，然后依次连接桶输入0 ≤A[1..n] <1
//另外还需要一个辅助数组B[O..n-1]来存放链表实现的桶
//当要被排序的数组内的数值是均匀分配的时候，桶排序使用线性时间O(n)。但桶排序并不是 比较排序，他不受到 O(n log n) 下限的影响。
//桶排序算法要求，数据的长度必须完全一样，程序过程要产生长度相同的数据

//共十个桶，所以建立一个二维数组，行向量的下标0—9代表了10个桶，每个行形成的一维数组则是桶的空间。

//桶排序的平均时间复杂度为线性的O(N+C)，其中C=N*(logN-logM)。
//如果相对于同样的N，桶数量M越大，其效率越高，最好的时间复杂度达到O(N)。当然桶排序的空间复杂度为O(N+M)，
//如果输入数据非常庞大，而桶的数量也非常多，则空间代价无疑是昂贵的。此外，桶排序是稳定的
public class Bucket {
	public static void main(String[] args) {
	      Double[] doubles = { 0.78, 0.17, 0.39, 0.26, 0.72, 0.94,
	              0.21, 0.12, 0.23, 0.68 };
	      doubles = bucketSort(doubles);
	  
	    	show(doubles);
	    
	  }

  public static Double[] bucketSort(Double[] A) {
      List<Double>[] B = new List[10];

      for (int i = 0; i < B.length; i++)
          B[i] = new LinkedList<Double>();
      for (Double d : A)
          B[(int) (d * 10)].add(d);

      Double[][] BB = new Double[10][];
      List<Double> BBB = new LinkedList<Double>();
      for (int i = 0; i < B.length; i++) {
          BB[i] = B[i].toArray(new Double[0]);
          Insertion ist=new Insertion();
          ist.sort(A);
       /*   insertionSort(BB[i], new Comparator<Double>() {
              public int compare(Double o1, Double o2) {
                  return (int) (Math.signum(o1 - o2));
              }
          });
          */
          for (Double d : BB[i])
              BBB.add(d);
      }
      return BBB.toArray(new Double[0]);
  }
  private static void show(Comparable []a){
  	for(int i=0;i<a.length;i++){
  		
  		System.out.print(a[i]+" ");
  		
  	}
  	
  }
} ///值得注意的 double 不能比较大小
 /* public static boolean isSorted(Comparable [] a){
  	
  	for(int i=1;i<a.length;i++){
  		if(less(a[i],a[i-1]))
  			return false;//如果第二个人比第一个小就返回错误，
  		   }
  	return true;
  	}

}
/*
 * 
 * 桶排序的第一步是将各个待排元素装到桶里，
 *      第二步就是对各个桶进行插入排序。
总体来说，插入排序等是最慢的，考虑到一般性，堆排序和快速排序都是不错的选择。
如果只是整数，那看情形使用计数或者基数排序，如果是浮点数，那么可以选择桶排序。
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
 * 
 * 
 * 
 * 
 * */
