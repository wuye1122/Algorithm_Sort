package com.wuye.array;

public class FindMedianOfK {
  /*
   *  ****
   *  ������������ĵ��ǳ��Ȳ�ͬ�����������ҳ���k��С������
   *  
   *  1 ���� ��� 
   *    short
   *    1 2 3 4 5 6
   *    long
   *    1 2 3 4 5 6 7 7 8
   *    ���k<short
   *    ��ô�ֱ�ȡ�����������ǰ  k����ȡ����λ�����ǵ�k��С
   *    
   *    
   *  2 ��� 
    *   short
   *    1 2 3   4 5 6
   *    long
   *    1 2 3 4 5 6   7 8 9
   *    
   *    k
   *    1 2 3 4 5 6 7 8 9 10 11 12
   *    ���k>long
   *    ȡ��ֵ��: ( 4 5 6) 3     (7 8 9) 6
   *            �ҳ����ߵ���λ������
   *         
   *            ���6>3 ---->
   *            
   *            6�ǵ�kС
   *            
   *  3 ���    short<k<long
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
   *         ���k=8�������м�
   *         
   *         ���Ǻ� short�����κ�������������С�ġ�
   *         
   *         1 2 3 �������ǵڰ�С�ġ�
   *          
   *         13 14 15 16������ ��
   *    
   *          **���4>8--->4�ǵ�12С
   * 
   * 
   *  ���ȴ��������������������ҳ���λ��
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
		
		
		//��һ�����  ���K��С��
		if(k<=s){//ȡ��k��ֵ
			return getMid(lon,0,k-1,sto,0,k-1);
		}
		
		
		//�ڶ������ ���k>l
		if(k>l){
			if(sto[k-l-1]>=lon[l-1]){
				return sto[k-l-1];
			}
			if(lon[k-s-1]>=sto[s-1]){
				return lon[k-s-1];
			}
			return getMid(lon,k-s,l-1,sto,k-l,s-1);
		}
		
		
		//���k����sl �м���ô
		
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
		System.out.println(" ���� "+ff.getK(a2, b2, 7));
		int a3[]={2,5,6,7,8,10};
		int b3[]={1,2,3,6};
		
		// 1 2 2 3 5 6 6 7   8 10 //3
		System.out.println(" ����  "+ff.getK(a3, b3, 5));
		
		
	

	}

}
