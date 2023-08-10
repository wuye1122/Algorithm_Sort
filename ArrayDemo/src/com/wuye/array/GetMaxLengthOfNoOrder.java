package com.wuye.array;

public class GetMaxLengthOfNoOrder {
  /*  
   * 
   * ���ڸ���һ��δ�������������   ����һ����  
   * 
   * �����ܹ���ӵ�����������������ĳ���
   * 
   * 
   *  [1 2 2 1 1 1 1] ,һ����1111
   * 
   * 
   * 
   * 
   * 
   * 
   * */
	
	public int getLength(int []arr,int k){
		if(k<=0||arr.length==0||arr==null){
			return 0;
		}
		
		int left=0;
		int right=0;//�տ�ʼȫ����0
		int sum=arr[0];
		int len=0;//��¼����k�������
		
		while(right<arr.length){
			
			if(sum<k){
				right++;
				if(right==arr.length){
					break;
				}
				
				sum+=arr[right];
				
				
			}else if(sum==k){
				len=Math.max(len, right-left+1);
				//len��¼�ı��ε���ָ�����ĳ���   ���ϴ������Ƚ�
				
				//sum-arr[left]lef++;������һ��Ϊ����Ƿ���
				
				sum-=arr[left++];
			}else{
				
				sum-=arr[left++];
				//�������˵�� ������
			}
			
			
			
		}
		return len;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetMaxLengthOfNoOrder gg=new GetMaxLengthOfNoOrder();
		int []a={1,2,2,1,1,1,1};
		int [] b={1,0,3,4,5,1,1,1};
		//��sum=3��ʱ��ͻ��ȥ ��ͷ��ֵ �����ῼ�����һ����
		//
		System.out.println(gg.getLength(a, 4));
		System.out.println(gg.getLength(b, 3));
		
	}

}
