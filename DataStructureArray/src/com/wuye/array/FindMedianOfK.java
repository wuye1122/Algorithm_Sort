package com.wuye.array;

public class FindMedianOfK {
  /*
   *  ****
   *  对于两个排序的但是长度不同的两个数组找出第k个小的数。
   *  
   *  1 首先 如果 
   *    short
   *    1 2 3 4 5 6
   *    long
   *    1 2 3 4 5 6 7 7 8
   *    如果k<short
   *    那么分别取出两个数组的前  k个数取其中位数就是第k个小
   *    
   *    
   *  2 如果 
    *   short
   *    1 2 3   4 5 6
   *    long
   *    1 2 3 4 5 6   7 8 9
   *    
   *    k
   *    1 2 3 4 5 6 7 8 9 10 11 12
   *    如果k>long
   *    取极值法: ( 4 5 6) 3     (7 8 9) 6
   *            找出两者的中位数即可
   *         
   *            如果6>3 ---->
   *            
   *            6是第k小
   *            
   *  3 如果    short<k<long
   *       
   *        short
   *        
   *         1 2 3 4 5 6 7 8
   *           
   *         1 2 3 4 5 6 7 8 9 10 11 12  
   *           
   *         long 
   *         
   *         1 2 3  4  5 6 7 8 9 10 11 12 13 14 15 16
   * 
   *        16-8=8
   *         如果k=8处于其中间
   *         
   *         考虑好 short里面任何数都可能是最小的。
   *         
   *         1 2 3 不可能是第八小的。
   *          
   *         13 14 15 16不可能 。
   *    
   *          **如果4>8--->4是第12小
   * 
   * 
   *  首先从两个有序子数组里面找出中位数
   * 
   * 
   * 
   * 
   * 
   * */
	public int getMid(int [] a,int s1,int e1,int []b,int s2,int e2){
		int mid1=0;
		int mid2=0;
		int offset=0;
		
		while(s1<e1){
			mid1=(s1+e1)/2;
			mid2=(s2+e2)/2;
			offset=((e1-s1+1)&1)^1;
			
			if(a[mid1]>b[mid2]){
				e1=mid1;
				s2=mid2+offset;
				
			}else if(a[mid1]<b[mid2]){
				s1=mid1+offset;
				e2=mid2;
				
				
			}else{
				return a[mid1];
			}
			
			
			
		}
		return Math.min(a[s1], b[s2]);
		
	}
	
	
	public int getK(int []a,int[]b,int k){
		
		if(a==null||b==null){
			return -1;
		}
		if(k<1||k>a.length+b.length){
			return -1;
		}
		
		int [] lon=a.length>=b.length?a:b;
		
		int []sto=a.length<b.length?a:b;
		int l=lon.length;
		int s=sto.length;
		
		
		//第一种情况  如果K最小的
		if(k<=s){//取出k个值
			return getMid(lon,0,k-1,sto,0,k-1);
		}
		
		
		//第二种情况 如果k>l
		if(k>l){
			if(sto[k-l-1]>=lon[l-1]){
				return sto[k-l-1];
			}
			if(lon[k-s-1]>=sto[s-1]){
				return lon[k-s-1];
			}
			return getMid(lon,k-s,l-1,sto,k-l,s-1);
		}
		
		
		//如果k处于sl 中间那么
		
		if(lon[k-s-1]>sto[s-1]){
			return lon[k-s-1];
			
		}
		return getMid(sto,0,s-1,lon,k-s,k-1);
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FindMedianOfK ff=new FindMedianOfK();
		System.out.println("------------");
		int a[]={1,2,4,6,8};
		int b[]={2,3,4,9,10};
		//1 2   2   3     4 4 6   8   9 10
		System.out.println(ff.getK(a, b, 6));
		int a1[]={2,4,6,8};
		int b1[]={3,4,19,20};
		// 2 3   4 4  6 8 19 20
		System.out.println(ff.getK(a1, b1, 3));
		
		
		
		
		
		
		int a2[]={2,5,6,7,10};
		int b2[]={1,2,3,6,7,10,11,12};
		
		// 1 2 2  3 5 6 6 7  7  10 10 11 12
		System.out.println(" 大于 "+ff.getK(a2, b2, 7));
		int a3[]={2,5,6,7,8,10};
		int b3[]={1,2,3,6};
		
		// 1 2 2 3 5 6 6 7   8 10 //3
		System.out.println(" 大于  "+ff.getK(a3, b3, 5));
		
		
	

	}

}
