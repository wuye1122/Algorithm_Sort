package com.wuye.radix;

//基数排序（radix sort）属于“分配式排序”（distribution sort），
//又称“桶子法”（bucket sort）或bin sort
//O (nlog(r)m)，其中r为所采取的基数，而m为堆数
//基数排序假设输入是由一个小范围内的整数构成，
//基数排序的过程，就是将最低位优先法用于单关键字的情况
//1 首先根据个位数的数值，在走访数值时将它们分配至编号0到9的桶子中：
//2 接下来将这些桶子中的数值重新串接起来，成为以下的数列：
//3  再根据十位数排序


public class Radix {

	
	 private static int[] countingSort(int[] A, int d) {
	        int[] B = new int[A.length];
	        int[] C = new int[10];
	        for (int i = 0; i < 10; i++)
	            C[i] = 0;
	        for (int i = 0; i < A.length; i++)
	            C[A[i] % ((int) Math.pow(10, d + 1)) / ((int) Math.pow(10, d))] += 1;
	        for (int i = 1; i < 10; i++)
	            C[i] += C[i - 1];
	        for (int i = A.length - 1; i >= 0; i--) {
	            B[C[A[i] % ((int) Math.pow(10, d + 1)) / ((int) Math.pow(10, d))] - 1] = A[i];
	            C[A[i] % ((int) Math.pow(10, d + 1)) / ((int) Math.pow(10, d))] -= 1;
	        }
	        return B;
	    }
	 
	    public static int[] radixSort(int[] A, int d) {
	        int[] B = new int[A.length];
	        for (int i = 0; i < A.length; i++)
	            B[i] = A[i];
	        for (int i = 0; i < d; i++) {
	            B = countingSort(B, i);
	        }
	        return B;
	    }
	    public static void main(String[] args)
	    {
	    	  int[] A = { 12, 25, 13, 30, 32, 43, 20, 3 };
	          int[] B = radixSort(A, 2);
	          for (int b : B) {
	              System.out.print(b + " ");
	          }
	          System.out.println();
	        }
	    }
	/*
	 * 因为第二行伪代码是说：以数组A的第i位为键，用一个稳定排序来排。
              迄今为止，《算法导论》里介绍过的稳定排序，只有前一节的计数排序，而那一节的计数排序，显然不能直接用在这里。不得不把前一节的计数排序改写一下。
	必须注意的是，这一节的计数排序public static int[] countingSort(int[] A, int d)和前一节的参数（int[] A, int d）虽然相同，
	但是意义完全不同。前一节的计数排序里，第二参数（int k），是表示数组A可能的值的个数。上一节里的例子，数组A在0到5之间，所以k为6。
	这一节，考虑排列的是10进制数，
	所以就在程序里定下为10，不由参数引入，而
	（int d）是排序的键值所在的位数，测试程序里，d会做循环，从0到1为止。
	 * 
	 * 
	 * 
	 * */


