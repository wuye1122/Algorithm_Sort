import java.util.HashSet;


public class UnfromedSum {

	/* 
	 *  最小不可组成和:概念
	 *  
	 *  首先将一个数组子集加起来:得出max min
	 *  
	 *  在[min,max]上   数组里面不能组成的这个区间最小的那个数就是最小的不可组成和
	 *  
	 *               如果全都能组成那么 最不能组成和就是max+1
	 * 
	 * 
	 * 
	 * 进阶题目:数组里面含有1能否更快地找到最小的这个数。
	 * 
	 * 
	 * 方法一:使用暴力递归
	 * 
	 *   [1 2 3]----[1 2 3 4 5 6]
	 *  
	 *   使用递归方法进行机损子数组的值。
	 *   pro(a,i+1,sum,set)记录的而是只包含a[i]的
	 *   pro(a,i+1,sum+a[i],set)    
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 方法二:使用动态规划
	 * 
	 *   
	 *   使用数组dp[0..sum]//来记录能够被子数组表示的  
	 *   
	 *   最后遍历一些
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */

   //第二种 动态规划 其时间复杂度 O(N*sum) 空间复杂度O(N) 数组长度dp[]
	
	public int unfromSum1(int a[]){
		if(a==null||a.length==0){
			return 1;
		}
		
		
		int sum=0;//遍历数组记录最大值和最小是
		int min=Integer.MAX_VALUE;
		
		for(int i=0;i<a.length;i++){
			sum+=a[i];
			min=Math.min(min, a[i]);
			
		}
		//定义一个boolean 数组
		boolean [] dp=new boolean[sum+1];
		//这么定义的好处在于  索引:0--sum  对应的数也是0--sum
		dp[0]=true;
		
		
		//进行对这个数组进行赋值
		
		for(int i=0;i<a.length;i++){
			for(int j=sum;j>=a[i];j--){
				
				/*  2  3  5 开始一场
				 * 
				 * 反过来就当于 dp[0]+2=dp[2]=true
				 *         dp[0]+3=dp[3]=true;
				 *         .......... 
				 *        10
				 * */
			dp[j]=dp[j-a[i]]?true:dp[j];
			
			 /* 2的时候
			  * 
			  * 反着减  10-2=8
			  *      9-2=7 
			  *      。。。。
			  *      2-2=0 
			  * 
			  * 3的时候
			  * 
			  * 反着减  10-3=7
			  *      9-3=6
			  *      5-3=2
			  *      3-3=0
			  * 。。。。。。。
			  * */
				
			}
			
		}
		System.out.println("-------------"+sum);
		//sum代表的是最大值
		for(int i=min;i<dp.length;i++){
			if(!dp[i]){
				return i;
			}
		}
		
		//如果不满足上述  条件 返回sum+1很敏感
		return sum+1;//?????此处的不影响返回值  在之前已经返回了
		
		
	}
	
	//第一种使用暴力递归
	public int unfromSum(int [] arr){
		
		if(arr==null||arr.length==0){
			return 0;
		}
		
		HashSet<Integer> set=new HashSet<Integer>();
		proc(arr,0,0,set);
		//首先将set里面的 所有可以累加的和收起来
		int min=Integer.MAX_VALUE;
		
		//找出原数组里面的最小值
		for(int i=0;i<arr.length;i++){
			
			min=Math.min(min, arr[i]);
		}
		
		
		//条件的意思是一直循环  直到找出最小不可组成和 跳出
		for(int i=min+1;i!=Integer.MIN_VALUE;i++){
			if(!set.contains(i)){
				return i;
			}
			
			
		}
		return 0;
		
	}
	
	public void proc(int []a,int i,int sum,HashSet<Integer> set){
		if(i==a.length){
			set.add(sum);
			return;
		}
		proc(a,i+1,sum,set);//只包含a[i]的情况
		proc(a,i+1,sum+a[i],set);//不包含a[i]的情况
	}
	
	
	
	//第二种使用动态规划。
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> set=new HashSet<Integer>();
		UnfromedSum uu=new UnfromedSum();
		int a[]={1,4,3,7};
		uu.proc(a, 0, 0, set);
		
		System.out.println(set);
		
		System.out.println(set);
		System.out.println(Integer.MIN_VALUE);
		
		int b[]={2,3,5};
		System.out.println(uu.unfromSum(a));
		System.out.println(uu.unfromSum1(b));
	}

}
