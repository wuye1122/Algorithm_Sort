package com.wuye.array;

public class GetMaxLengthOfNoOrder2 {

	
	/*  ***
	 *  �ҳ�û������������ С�ڵ���ָ�������������  
	 *  ����������:
	 *  
	 *  
	 *   ���� sum ����λ�õ����ۼ�
	 *   
	 *   ��� �ҵ��ۼӵ�i��������� --->�β�һ����������
	 *   
	 *   ��� ��>sum-k ���������� ʹ��2�ֲ���
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	public int getMax1(int arr[],int k){
		//����׼��һ�������������ڲ���ʹ��
		
		int re[]=new int[arr.length+1];
		
		int sum=0;
		re[0]=sum;
		//����������� �ֳ�������ֵ����  �� �����
		for(int i=0;i<arr.length;i++){
           sum+=arr[i];
		   re[i+1]=Math.max(sum, re[i]);
           
		}
		
		
		sum=0;
		int pre=0;//��¼�����Ǹ�ֵ������
		
		int res=0;//�������ֵ
		
		int len=0;//�����ʱ��������ĳ���
		
		for(int i=0;i<arr.length;i++){
			
			sum+=arr[i];
			pre=getIndex(re,sum-k);
			len=pre==-1?0:i-pre+1;
			res=Math.max(res, len);
		}
		return res;
		
	}
	
	// 2�ֲ��ҵ�������¡�
	
	public int getIndex(int []arr,int k){
		
		int low=0;
		int high=arr.length-1;
		int res=-1;
		int mid=0;
		
		while(low<=high){
			mid=(low+high)/2;
			
			if(arr[mid]>=k){
				res=mid;
				high=mid-1;
			}else{
				low=mid+1;
			}
		}
		return res;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetMaxLengthOfNoOrder2 gg=new GetMaxLengthOfNoOrder2();
	     int [] aa={3,-2,-4,0,6};
	     //3 1 
	System.out.println(gg.getMax1(aa, 0));
	
	
	}

}
