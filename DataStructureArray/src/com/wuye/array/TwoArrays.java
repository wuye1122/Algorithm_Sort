package com.wuye.array;

public class TwoArrays {
   /*
    *  ���ظ���ӡ ���������������ӵ���ָ������ ��Ԫ��  �� ��Ԫ��
    *  
    *  1 ��Ԫ�� ��������������м�ƽ�
    *    ��Ϊ����������Կ��ܳ��֡��ظ����� 11����99�����������
    * 
    *  2 ��Ԫ����Կ����Ƕ�Ԫ���ټ�һ�� ����
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * */
	//��Ԫ��
	//��Ԫ�� ����arr[i][i+1...a.length-1]��һ����Ԫ��
	public static void printTree(int arr[],int k){
		if(arr==null||arr.length<3){
			return ;
		}
		
		for(int i=0;i<arr.length-2;i++){
			//���ѭ�� ����ѡ�� ֱ������������ 
			if(i==0||arr[i]!=arr[i-1]){
				printTwo1(arr,i,i+1,arr.length-1,k-arr[i]);
				
			}
			
		}
		
		
		
	}
	public  static  void printTwo1(int []arr,int f,int left,int right,int k){
		
		
		
		while(left<right){
			if(arr[left]+arr[right]<k){
				left++;
			}else if (arr[left]+arr[right]>k){
				right--;
				
			}else{
				//���==0��˵����ǰ��������ӵ���k ��������Խ������
				//���Ƶ� left=f+1
				if(left==f+1||arr[left-1]!=arr[left]){
					System.out.println(arr[f]+","+arr[left]+","+arr[right]);
				}
				left++;
				right--;
			}
			
		}
	}	
	
	//��Ԫ��
	public  static  void printTwo(int []arr,int k){
		if(arr==null||arr.length<1){
			return ;
		}
		
		//��������ָ��:
		
		int left=0;
		int right=arr.length-1;
		while(left<right){
			if(arr[left]+arr[right]<k){
				left++;
			}else if (arr[left]+arr[right]>k){
				right--;
				
			}else{
				//���==0��˵����ǰ��������ӵ���k ��������Խ������
				if(left==0||arr[left-1]!=arr[left]){
					System.out.println(arr[left]+","+arr[right]);
				}
				left++;
				right--;
			}
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		            
		int arr[]={-1,-2,-2,0,1,5,6,7,8,8,9,9};
		
		for(int i=0;i<arr.length-2;i++){
			System.out.print(arr[i]+"_");
		}
		System.out.println("---");
		TwoArrays.printTwo(arr, 6); 
		
		System.out.println("---");
		TwoArrays.printTree(arr, 12);
	}

}
