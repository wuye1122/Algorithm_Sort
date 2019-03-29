package com.wuye.z1;
/*1 ��֪����������������С�ֱ�Ϊ��n,m  �������������λ�� o(log(m+n))
 * 
 *����˼·ȥ��һ��С��ȥ��һ�����
 *a ������ʣ����Ԫ������ƽ�� (amin amax) (bmin bmax) ((amin=amax) (bmin=bmax))
 *b ������ʣһ��(amin=amax) (bmin=bmax)
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
      System.out.println( "���������������λ����"+findMid(a,b));
	}
	public static double findMid(int a[],int b[]){
		int aMax=a.length-1;
		int aMin=0;
		int bMax=b.length-1;
		int bMin=0;
		
		while(aMax-aMin+1+(bMax-bMin+1)>2){
			//�˴�˵�� ������������������Ԫ��,����һ������Ϊnull
			boolean minA=true;
			boolean maxA=true;
			//drop min
			if(aMax>=aMin&&bMax>=bMin){
				//ÿ����������һ��Ԫ��
				minA=a[aMin]<b[bMin];
				//��С��Ԫ����a����
			}else if(bMax>=bMin){
				minA=false;//b����������һ�� 
			}
			int useless=minA?aMin++:bMin++;
			
			//drop max
			if(aMax>=aMin&&bMax>=bMin){
				//ÿ����������һ��Ԫ��
				maxA=a[aMax]>b[bMax];
				//��С��Ԫ����a����
			}else if(bMax>=bMin){
				maxA=false;//b����������һ�� 
			}
			useless=maxA?aMax--:bMax--;
		}//ѭ��������� ������������ʣһ��Ԫ�� ����ʣ����Ԫ��
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
