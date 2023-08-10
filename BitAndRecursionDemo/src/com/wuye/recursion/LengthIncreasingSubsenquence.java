package com.wuye.recursion;

public class LengthIncreasingSubsenquence {

	/*
	 *  rescursion   最长递增的序列 后面比前面大就行 见
	 *  
	 *           最长连续序列   递增1的  ---> LengthOfConnectionArray
	 *  
	 *             
	 *   
	 *              
	 * 
	 * 
	 *    1 dp[i]代表以i结尾在数组里面0..i 最长的递增序列
	 * 
	 *      重点: dp[i]=max(dp[i],dp[j]+1)
	 *        
	 *           比他小的所有数当中最大的 递增序列+1 
	 * 
	 * 
	 *     2 定义一个end数组  其有效区[0,right]
	 * 
	 * 
	 *      这种方法的题眼就是:在end里面使用1/2查找发  找出左面第一个比
	 *      
	 *           arr[i]大的数
	 * 
	 * */

//第二种方法:
	 public int[] getLong2(int arr[]){
			if(arr.length==0||arr==null){
				return null;
				
			}
			int [] dp=getDP1(arr);
			
			return getList(arr,dp);
			
		}
	
	//使用额外的数组end进行求解 dp数组
	public int[] getDP1(int arr[]){
		
		int []end=new int[arr.length];
		
		int []dp=new int[arr.length];
		
		end[0]=arr[0];
		
		dp[0]=1;
		
		//下面对arr进行循环
		int right=0;
		
		int l=0;
		
		int r=0;
		
		int m=0;
		for(int i=1;i<arr.length;i++){
			
			l=0;
			r=right;
			while(l<=r){
  
				m=(l+r)/2;
				
				if(arr[i]>end[m]){
					l=m+1;
					
				}else{
					r=m-1;
					
				}
				
			}
			
			 right=Math.max(right, l);
			 end[l]=arr[i];
			 dp[i]=l+1;
			
			
			
		}
		return dp;
		
		
	}
	
	
//第一种方法:	

	//返回dp[] 时间复杂度O(n^2)
	public int [] getDP(int []arr){
		int dp[]=new int[arr.length];

		for(int i=0;i<dp.length;i++){
			dp[i]=1;

			for(int j=0;j<i;j++){
				//选比起小的里面 最长的递增序列
				if(arr[j]<arr[i]){
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
		}
		return dp;
	}

	//对dp[]进行遍历得出最长递增序列
	public int [] getList(int arr[],int []dp){
		int len=0;//记录长度的
		
		int index=0;//记录索引的
		
		for(int i=0;i<dp.length;i++){
			if(dp[i]>len){
				len=dp[i];
				index=i;
			}
			
			
		}
		//定义一个最长的字符串数组
		
		int a[]=new int [len];
		
		//对数组进行遍历
		a[--len]=arr[index];
		for(int i=index;i>=0;i--){
			if((arr[i]<arr[index])&&(dp[i]==dp[index]-1)){
				a[--len]=arr[i];
				index=i;
				
			}
			
		}
		return a;
		
	}
	
	//arr dp两个数组联合得出结论
    public int[] getLong(int arr[]){
		if(arr.length==0||arr==null){
			return null;
			
		}
		int [] dp=getDP(arr);
		
		return getList(arr,dp);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LengthIncreasingSubsenquence ll=new LengthIncreasingSubsenquence();
		
		int []a={2,1,5,3,6,4,8,9,7};
		int []b=ll.getDP(a);
		for(int c:b){
			System.out.print(c+".");
		}
	System.out.println("---");

	System.out.println("第一种的处最长递增序列如下:");
	
	 int lo[]=ll.getLong(a);
	 for(int c:lo){
		 System.out.print(c+"-");
	 }

	 System.out.println(""); 
		int []d=ll.getDP1(a);
		for(int c:d){
			System.out.print(c+".");
		}
	 
	 
	 
	 
		 System.out.println(""); 
	 System.out.println("第二种的处最长递增序列如下:");
		
	 int lo1[]=ll.getLong2(a);
	 for(int c:lo1){
		 System.out.print(c+"-");
	 }
	 
	 
	 
	}

}
