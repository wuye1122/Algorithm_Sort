package com.wuye.array;

import java.util.HashMap;

public class GetMaxLengthOfNoOrder1 {
	/*
	 * ��δ����������� �ۼӺ�Ϊָ��ֵ������������
	 * 
	 * 1 ����:�������������� ���� �ɸ�  ���������
	 * 
	 * 
	 * 2 ��������:������������� �����ĺ͸����ĸ�����ȵ��������ĳ���
	 * 
	 * 
	 * 3 ��������:��������������ȫ����0  1��ô����ж�
	 * 
	 * ʱ�临�Ӷ�:O(N) ����ռ临�Ӷ�(N)
	 * 
	 * 
	 * 
	 * ˼·:�����˼·����: ��ÿ���ۼӵĽ��   �Ͷ�Ӧ��i������
	 * 
	 * */
	public int getMax(int []arr,int k){
		if(arr.length==0||arr==null){
			return 0;
		}
//	  ������ ���� ���� 0 ���ֿ� ����
//		for(int i=0;i<arr.length;i++){
//			if(arr[i]>0){
//				arr[i]=1;
//				
//			}else if(arr[i]<0){
//				arr[i]=-1;
//			}else{
//				arr[i]=0;
//			}
//		}
		
		
		
		
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		int len=0;
		int sum=0;
		map.put(0, -1);
		// �����������˵���� sum-k=0 ��ʱ��map������Ҫ�ҵ�һ��0
		//
		
		for(int i=0;i<arr.length;i++){
			
//			if(){
//				
//			}else{
//				
//			}
			sum+=arr[i];
			/*
			 *  ÿһλ���ۼӽ��sum   ����map ���� 
			 *  
			 *  sum-k����һ���ۼӽ�� 
			 * 
			 *  ʹ�� [0...i]+[i...j]=[0..j]
			 * 
			 *     map�����ֵ+k=map�����ֵ
			 * 
			 * 
			 * 
			 * */
			
			if(map.containsKey(sum-k)){
				len=Math.max(len, i-map.get(sum-k));
				
			}
			if(!map.containsKey(sum)){//��ĳ��ִ�����
				//��������������
				// ����ѹ������
				map.put(sum, i);
			}
			
		}
		System.out.println(map);
		return len;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		GetMaxLengthOfNoOrder1 gg=new GetMaxLengthOfNoOrder1();
		
//		int [] aa={12,3,4,5,0,-1,-3,2};
//		System.out.println(gg.getMax(aa, 23));
		
		int [] bb={0,1,3,-4,-2,10};
		//0 1 4  -2 -2 8 
		//0,1,3 , -4 -2 10
		System.out.println(gg.getMax(bb, 0));
		
		int [] cc={1,1,0,0,-1,1,-1,1};
		System.out.println(gg.getMax(cc, 0));
	}

}
