package com.wuye.z1;
/*1 已知两个有序的数组其大小分别为你n,m  求两个数组的中位数 o(log(m+n))
 * 
 *此题思路去掉一个小的去掉一个大的
 *a 如果最后剩两个元素求其平均 (amin amax) (bmin bmax) ((amin=amax) (bmin=bmax))
 *b 如果最后剩一个(amin=amax) (bmin=bmax)
 *
 *There are two sorted arrays A and B of size m and n respectively,
 *find the median of the two sorted we. the overall run time complexity
 *should be o(log(m+n))
 * 
 * 
 * 
 * */
public class SelectMid {

	public static void main(String[] args) {
		// TODO Auto- method stub
		System.out.println(20000/1000);
       int a[]={2,3,4};
       int b[]={4,5,6};
      System.out.println( "以上两个数组的中位数是"+findMid(a,b));
	}
	public static double findMid(int a[],int b[]){
		int aMax=a.length-1;
		int aMin=0;
		int bMax=b.length-1;
		int bMin=0;
		
		while(aMax-aMin+1+(bMax-bMin+1)>2){
			//此处说明 两个数字至少有三个元素,其中一个可用为null
			boolean minA=true;
			boolean maxA=true;
			//drop min
			if(aMax>=aMin&&bMax>=bMin){
				//每个里面至少一个元素
				minA=a[aMin]<b[bMin];
				//最小的元素在a里面
			}else if(bMax>=bMin){
				minA=false;//b里面至少有一个 
			}
			int useless=minA?aMin++:bMin++;
			
			//drop max
			if(aMax>=aMin&&bMax>=bMin){
				//每个里面至少一个元素
				maxA=a[aMax]>b[bMax];
				//最小的元素在a里面
			}else if(bMax>=bMin){
				maxA=false;//b里面至少有一个 
			}
			useless=maxA?aMax--:bMax--;
		}//循环到这结束 上面的最后结果是剩一个元素 或者剩两个元素
			if(aMax==aMin&&bMax==bMin){
				return (a[aMax]+b[bMin])*1.0/2;
				
			}
			else if (aMax==aMin){
				return a[aMax];
			}
			else if(bMax==bMin){
				return b[bMax];
			}else if(aMax-aMin==1){
				return (a[aMax]+a[aMin])*1.0/2;
			}else if(bMax-bMin==1){
				return (b[bMax]+b[bMin])*1.0/2;
			     }
		
		

		
		return -1;	
		
	}

}
