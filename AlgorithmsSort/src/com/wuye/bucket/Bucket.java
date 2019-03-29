package com.wuye.bucket;

import java.util.LinkedList;
import java.util.List;

import com.wuye.insertion.Insertion;
 //Ͱ�ӷ� bucket (������)
//������ԭ��:�ǽ�����ֵ�����������Ͱ���ÿ��Ͱ���ٸ�������
//Ͱ�����Ǹ볲�����һ�ֹ��ɽ��

//�ٶ�����������һ��������̲�����[0, 1)�����Ͼ��ȷֲ���ʵ����������[0, 1)����Ϊn����С��ȵ������䣨Ͱ��
 //ÿͰ��С1/n:[0, 1/n), [1/n, 2/n),[2/n, 3/n)��[k/n, (k+1)/n )����
 //��n������Ԫ�ط��䵽��ЩͰ�У���Ͱ��Ԫ�ؽ�������Ȼ����������Ͱ����0 ��A[1..n] <1
//���⻹��Ҫһ����������B[O..n-1]���������ʵ�ֵ�Ͱ
//��Ҫ������������ڵ���ֵ�Ǿ��ȷ����ʱ��Ͱ����ʹ������ʱ��O(n)����Ͱ���򲢲��� �Ƚ����������ܵ� O(n log n) ���޵�Ӱ�졣
//Ͱ�����㷨Ҫ�����ݵĳ��ȱ�����ȫһ�����������Ҫ����������ͬ������

//��ʮ��Ͱ�����Խ���һ����ά���飬���������±�0��9������10��Ͱ��ÿ�����γɵ�һά��������Ͱ�Ŀռ䡣

//Ͱ�����ƽ��ʱ�临�Ӷ�Ϊ���Ե�O(N+C)������C=N*(logN-logM)��
//��������ͬ����N��Ͱ����MԽ����Ч��Խ�ߣ���õ�ʱ�临�ӶȴﵽO(N)����ȻͰ����Ŀռ临�Ӷ�ΪO(N+M)��
//����������ݷǳ��Ӵ󣬶�Ͱ������Ҳ�ǳ��࣬��ռ���������ǰ���ġ����⣬Ͱ�������ȶ���
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
} ///ֵ��ע��� double ���ܱȽϴ�С
 /* public static boolean isSorted(Comparable [] a){
  	
  	for(int i=1;i<a.length;i++){
  		if(less(a[i],a[i-1]))
  			return false;//����ڶ����˱ȵ�һ��С�ͷ��ش���
  		   }
  	return true;
  	}

}
/*
 * 
 * Ͱ����ĵ�һ���ǽ���������Ԫ��װ��Ͱ�
 *      �ڶ������ǶԸ���Ͱ���в�������
������˵������������������ģ����ǵ�һ���ԣ�������Ϳ��������ǲ����ѡ��
���ֻ���������ǿ�����ʹ�ü������߻�����������Ǹ���������ô����ѡ��Ͱ����
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
