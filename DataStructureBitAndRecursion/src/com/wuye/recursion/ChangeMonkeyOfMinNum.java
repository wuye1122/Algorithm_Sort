package com.wuye.recursion;


 /*  递归--换钱的方法数
  * 
  * 
 * 给出一组钱数:让你找出10元钱  返回总共的几种。此题使用暴力递归  优化之后的递归  动态规划
 * 
 *          
 * 
 * 5 2 3 1:10
 * 
 * 第一种暴力递归: 其中存在大量的重复递归的运算。
 * 
 *            与钱有关所以最大的时间复杂度 O(aim^n);
 * 
 * 0*5  0*2  0*3  1*10
 *           1*3  1*7 
 *           2*3  1*4
 *           .....
 *    
 *      1*2  0*3  1*8
 *           
 *           .....
 *           
 *  1*5 0*2 0*3 1*5
 *      
 *           ....暴力递归
 * 
 * 第二种记忆搜索法 :对暴力递归的优化 将已经递归之后的结果存入一个 二维数组 里面 减少时间复杂度
 * 
 *     时间复杂度O(n*k^2);
 *     两者都是相同的:两者都是空间换时间的方法:  都有枚举存在 区别在于
 *     
 *     动态规划规定计算的顺序  而记忆搜索法则不规定这些 
 *   
 * 第三种使用动态规划:超级好理解。
 *     时间复杂度O(n*k^2);
 *     j-c3[i]*z>=0
 * 
 * 第四种:动态规划进行第一次优化  时间复杂度O(n*k)
 * 
 * 第五种空间压缩法对动态规划的空间复杂度进行了优化: 时间复杂度没有变  但是空间复杂度变成O(k)
 * 
 * 
 * 
 * */






public class ChangeMonkeyOfMinNum {

	
	//暴力递归:
	public int coin1(int a[],int k){
		if(a==null||a.length==0||k<1){
			return 0;
		}
		
	return  procc(a,0, k);
		
	}
	public int procc(int []a,int index,int aim){
		
		int res=0;
		if(index==a.length){
			res=aim==0?1:0;
		}else{
		
		for(int i=0;i*a[index]<=aim;i++){
			res+=procc(a,index+1,aim-i*a[index]);
		    }
		}
		return res;
	}

	
	//记忆搜索法:
	//将每一次递归的结果都存入到   一个二维数组里面。
	//      横着 aim+1
	//竖着
	//0             map[i][j]表示的值是p(i,j)返回值
	//长度+1          
	//              map[i][j]==0表示递归没有计算过
	//
	//              map[i][j]==-1表示递归计算过但是返回是0
	//
	//              3 8 使用三元就无法表示出8元 所以返回值为-1
	//           
	//              否则返回值p(i,j)=a 
	
	public int coin2(int c2[],int k){
	if(c2.length==0||c2==null||k<0){
		return 0;
	}
	int map[][]=new int[c2.length+1][k+1];
	
	
	
	return pro2(c2,0,k,map);
	
	
	}	
	public  int pro2(int a[],int index,int k,int[][]map){
		
		//记录种类
		int res=0;
		if(index==a.length){
			res=k==0?1:0;
		}else{
		int mapValue=0;
		
		for(int i=0;i*a[index]<=k;i++){
			//前一种金钱数量 固定之后了   就看后一种的了
			  mapValue=map[index+1][k-i*a[index]]; 
			
			if(mapValue!=0){
				res+=mapValue==-1?0:mapValue;
			}else{
				res+=pro2(a,index+1,k-i*a[index],map);
			}
			
		}
			
			
			
			
			
			
		}
		
		map[index][k]=res==0?-1:res;
		return res;
		
		
		
	}
	
	
	//动态规划。
	
	public int coin3(int c3[],int k){
		if(c3.length==0||c3==null||k<0){
			return 0;
		}
		
		//首先顶一个 二维数组
		int dp[][]=new int[c3.length][k+1];
		
		//首先第一列全部都是1
		for(int i=0;i<c3.length;i++){
			dp[i][0]=1;
		}
		
		
		//然后是第一横排 只有是第一个数的倍数都够表示 设置成1  此题关系的不是几张 而是能不能
		
		for(int i=1;c3[0]*i<=k;i++){
			
			dp[0][c3[0]*i]=1;// 5  10 15   c3[0]*i
		}
		
		
		//其次就是dp[i][j]
		int num=0;
		for(int i=1;i<c3.length;i++){
			for(int j=1;j<k+1;j++){
				num=0;//代表的每一行
				
				//此处应该是大于   使用一张或者几张之后  还需要使用其他的前 
				for(int z=0;j-c3[i]*z>=0;z++){
					// 判断 上面 j使用一个此时候的钱   使用两张  使用三张
					num+=dp[i-1][j-c3[i]*z];
					//之前是否有能够对上号的  后面的意思就是  和此时候钱  凑整的那个前一个
				}
				dp[i][j]=num;
			}
			
		}
		
		
		System.out.println("-----对数组进行遍历-----");
		
		for(int a[]:dp){
			for(int b:a){
				System.out.print("-"+b);
			}
			System.out.println("-----对数组进行遍历-----");	
		}
		
		return dp[c3.length-1][k];
	}
	
	
	//动态规划--时间复杂度减少---优化 O(N*k) 将枚举的过程省略掉
	// [i][j-a[i]]
	public int coin4(int c4[],int k){
		if(c4.length==0||c4==null||k<0){
			return 0;
		}
		int dp[][]=new int[c4.length][k+1];
		
		for(int i=0;i<c4.length;i++){
			dp[i][0]=1;
		}
		
		
		//第一个数的额倍数
		for(int j=1;c4[0]*j<=k;j++){
			dp[0][c4[0]*j]=1;
		}
		
		//dp[i][j]上一个值  +  前一个自己的值
		for(int i=1;i<c4.length;i++){
			for(int j=1;j<k+1;j++){
				dp[i][j]=dp[i-1][j];
				dp[i][j]+=j-c4[i]>=0?dp[i][j-c4[i]]:0;
			}
		}
		

		System.out.println("******对数组进行遍历*******");
		
		for(int a[]:dp){
			for(int b:a){
				System.out.print("-"+b);
			}
			System.out.println("******对数组进行遍历******");	
		}

		return dp[c4.length-1][k];
		
	}
	//动态规划--空间压缩法----将二维数组变成一维数组
	// dp[k+1]
	public int coin5(int [] c5,int k){
		if(c5==null||c5.length==0||k<0){
			return 0;
		}
		
		int dp[]=new int[k+1];
		
		for(int i=0;c5[0]*i<=k;i++){
			dp[c5[0]*i]=1;
		}
		
		for(int i=1;i<c5.length;i++){
			for(int j=1;j<k+1;j++){
				dp[j]+=j-c5[i]>=0?dp[j-c5[i]]:0;
			}
		}
		
        System.out.println("&&&&&&&对数组进行遍历&&&&&&&&");
		
		for(int a:dp){		
			System.out.print("-"+a);
		}
		System.out.println("&&&&&&&&对数组进行遍历&&&&&&&&");			
		return dp[k];
		
	}
	public static void main(String []args){
		ChangeMonkeyOfMinNum rr=new ChangeMonkeyOfMinNum();
		int []aa={3,5,20};
		System.out.println("第一种:"+rr.coin1(aa, 20));
		System.out.println("第二种:"+rr.coin2(aa, 20));
		System.out.println("第三种:"+rr.coin3(aa, 20));
		System.out.println("第四种:"+rr.coin4(aa, 20));
		System.out.println("第五种:"+rr.coin5(aa, 20));
		
	}
}
