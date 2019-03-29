package com.wuye.radix;

//��������radix sort�����ڡ�����ʽ���򡱣�distribution sort����
//�ֳơ�Ͱ�ӷ�����bucket sort����bin sort
//O (nlog(r)m)������rΪ����ȡ�Ļ�������mΪ����
//�������������������һ��С��Χ�ڵ��������ɣ�
//��������Ĺ��̣����ǽ����λ���ȷ����ڵ��ؼ��ֵ����
//1 ���ȸ��ݸ�λ������ֵ�����߷���ֵʱ�����Ƿ��������0��9��Ͱ���У�
//2 ����������ЩͰ���е���ֵ���´�����������Ϊ���µ����У�
//3  �ٸ���ʮλ������


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
	 * ��Ϊ�ڶ���α������˵��������A�ĵ�iλΪ������һ���ȶ��������š�
              ����Ϊֹ�����㷨���ۡ�����ܹ����ȶ�����ֻ��ǰһ�ڵļ������򣬶���һ�ڵļ���������Ȼ����ֱ������������ò���ǰһ�ڵļ��������дһ�¡�
	����ע����ǣ���һ�ڵļ�������public static int[] countingSort(int[] A, int d)��ǰһ�ڵĲ�����int[] A, int d����Ȼ��ͬ��
	����������ȫ��ͬ��ǰһ�ڵļ���������ڶ�������int k�����Ǳ�ʾ����A���ܵ�ֵ�ĸ�������һ��������ӣ�����A��0��5֮�䣬����kΪ6��
	��һ�ڣ��������е���10��������
	���Ծ��ڳ����ﶨ��Ϊ10�����ɲ������룬��
	��int d��������ļ�ֵ���ڵ�λ�������Գ����d����ѭ������0��1Ϊֹ��
	 * 
	 * 
	 * 
	 * */


