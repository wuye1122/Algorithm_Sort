package com.wuye.interview;

public class GetMaxSuArray {
    /*
     *  *����������ۼӺ�����
     * 
     *  cur��¼��ǰ�ۼӽ��   ���Ϊ��������  ���Ϊ��ֱ�����
     *  
     *  maxȡ��curǰ�����ֵ
     * 
     * 
     * 
     * 
     * 
     * */
	
	public static int getMax(int [] arr){
		if(arr.length==0||arr==null){
			return 0;
		}
		
		int max=Integer.MIN_VALUE;
		//��Ϊ�ڱȽϵ��� ���ѡ��0�Ļ� ��������ǰ��λ�Ǹ�������ִ��� 
		//����ѡ��ҪС��
		int cur=0;
		
		for(int i=0;i<arr.length;i++){
			
			cur+=arr[i];
			max=Math.max(cur, max);
			cur=cur<0?0:cur;
			
		}
		
		
		
		return max;
		
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int a[]={1,-2,3,5,-2,6,-1};
		System.out.println(getMax(a));
		
	}

}
