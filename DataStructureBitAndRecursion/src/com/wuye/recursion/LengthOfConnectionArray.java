package com.wuye.recursion;

import java.util.HashMap;

public class LengthOfConnectionArray {
/*
 * 
 *  rescursion �������������������(�ظ�ֻ����һ��)
 *  
 *  ֻ�������������������� ��һ������
 *  
 *  ʹ�ù�ϣ��ʱ�临�Ӷ�O(N) �ռ临�Ӷ�O(N)
 * 
 *  map(K,V)
 *  key�����������ĳ����  value������������ڵ���������г���
 *  (arr[i],1)--> ��¼��Сֵ  �����ֵ
 * 
 *    
 *  ***�ؼ���:
 * 
 *     3,456 less=3 more=4
 *     int left=less-map.get(less)+1;
 *     
 *     456,7 less=6 more=7
 *     int right=more+map.get(more)-1;
 * 
 * 
 * 
 * 
 * */
	//����ɸѡ
	public int select(int a[]){
		if(a==null||a.length==0){
			return 0;
		}
		
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		int max=1;
		
		for(int i=0;i<a.length;i++){
			if(!map.containsKey(a[i])){
				map.put(a[i], 1);
			    //ÿһ��ֵ����֮��Ҫ�ж��Ƿ��б���С���ߴ��
			
			    if(map.containsKey(a[i]-1)){
			    	max=Math.max(max, merger(map,a[i]-1,a[i]));
			    	
			    }
			   if(map.containsKey(a[i]+1)){
				   max=Math.max(max, merger(map,a[i],a[i]+1));
				   
				   
			   }
			
			
			}
			
			
			
		}
		return max;
		
		
	}
	
	
	//���� ��������һ�����ԭ��������  �ҷ��س���
	
	public  int  merger(HashMap<Integer,Integer> map,int less,int more){
		
		int left=less-map.get(less)+1;
		
		int right=more+map.get(more)-1;
		
	    int len=right-left+1;
	    
	    map.put(left, len);
	    
	    map.put(right, len);
	
	return len;
	
	
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LengthOfConnectionArray ll=new LengthOfConnectionArray();
		
		int [] a={100,4,5,6,7,200};
		
		int [] b={1,4,5,6,7,2,3,100};
		
		System.out.println("�����������������");
		System.out.println(ll.select(a));
		System.out.println(ll.select(b));
	}

}
