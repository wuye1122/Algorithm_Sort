package com.wuye.array;

public class GetMaxLengthOfNoOrder {
  /*  
   * 
   * 对于给定一个未排序的正数数组   给定一个数  
   * 
   * 返回能够相加等于这个数的最长子数组的长度
   * 
   * 
   *  [1 2 2 1 1 1 1] ,一定是1111
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
		int right=0;//刚开始全都是0
		int sum=arr[0];
		int len=0;//记录等于k的最长的数
		
		while(right<arr.length){
			
			if(sum<k){
				right++;
				if(right==arr.length){
					break;
				}
				
				sum+=arr[right];
				
				
			}else if(sum==k){
				len=Math.max(len, right-left+1);
				//len记录的本次等于指定数的长度   和上次最大相比较
				
				//sum-arr[left]lef++;看以下一个为起点是否有
				
				sum-=arr[left++];
			}else{
				
				sum-=arr[left++];
				//如果大于说明 再往后
			}
			
			
			
		}
		return len;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetMaxLengthOfNoOrder gg=new GetMaxLengthOfNoOrder();
		int []a={1,2,2,1,1,1,1};
		int [] b={1,0,3,4,5,1,1,1};
		//当sum=3的时候就会减去 开头的值 而不会考虑添加一个零
		//
		System.out.println(gg.getLength(a, 4));
		System.out.println(gg.getLength(b, 3));
		
	}

}
