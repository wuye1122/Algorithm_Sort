package com.wuye.recursion;

public class LengthMaxtrixRoad {
  /*
   * recursion 矩阵最小的路径之和---***空间压缩法 很重要
   * 
   * 
   * 1 定义一个数组 dp[i][j]代表的意思  是走到i j处用的最短的而距离
   * 
   *  dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+m[i][j]
   * 
   *  时间复杂度O(m*n)  空间复杂度O(m*n)因为dp[m][n]
   * 
   * 
   * 2 使用空间压缩法 达到 时间复杂度O(m*n)   空间复杂度O(min{m,n})
   * 
   * */
	
	//使用一个二维数组
	public int minPath1(int a[][]){
		System.out.println("输出原来矩阵");
		for(int b[] :a){
		  for(int c:b){
			  System.out.print(c+".");
			  
		  }
		  System.out.println();
			
		}
		
		
		if(a==null||a.length==0||a[0]==null||a[0].length==0){
			return 0;
		}
		int res[][]=new int[a.length][a[0].length];
		
		res[0][0]=a[0][0];
		
		//定义第一列
		for(int i=1;i<res.length;i++){
			res[i][0]=res[i-1][0]+a[i][0];
			
		}
		//定义第一行
		for(int i=1;i<res[0].length;i++){
			res[0][i]=res[0][i-1]+a[0][1];	
		}
		//定义其他位置
		for(int i=1;i<res.length;i++){
			for(int j=1;j<a[0].length;j++){
				res[i][j]=Math.min(res[i-1][j],res[i][j-1])+a[i][j];
				
			}
			
		}
		
		
		System.out.println("输出距离矩阵");
		
		for(int b[] :res){
			  for(int c:b){
				  System.out.print(c+".");
				  
			  }
			  System.out.println();
				
			}
			
		
		return res[res.length-1][res[0].length-1];
		
		
		
		
		
	}
	
	public int minPath2(int a[][]){
		if(a==null||a.length==0||a[0]==null||a[0].length==0){
			return 0;
		}
		
		System.out.println("输出原来矩阵");
		for(int b[] :a){
		  for(int c:b){
			  System.out.print(c+".");
			  
		  }
		  System.out.println();
			
		}
		
		int more=Math.max(a.length, a[0].length);//more代表较大的那个
	 	int less=Math.min(a.length, a[0].length);//less代表较小的那个
	    
	 	
	 	//定义一个boolean类型  判断怎么加
	 	
	 	boolean flag=more==a.length;
	 	
	 	
	 	int res[]=new int[less];
	 	
	 	//首先确定第一排或者列
	 	res[0]=a[0][0];
	 	for(int i=1;i<less;i++){
	 		
	 		res[i]=res[i-1]+(flag?a[0][i]:a[i][0]);
	 		
	 	}
	 	
	 	for(int i=1;i<more;i++){
	 		//每一次新的res[0]都会变化
	 		res[0]=res[0]+(flag?a[i][0]:a[0][i]);
	 		
	 		for(int j=1;j<less;j++){
	 			
	 			res[j]=Math.min(res[j],res[j-1])+(flag?a[i][j]:a[j][i]);
	 		}
	 		
	 		
	 	}
	 	
	 	System.out.println("压缩法数组最终如下:");
	 	for(int cc:res){
	 		System.out.print(cc+"--");
	
	 	}
		return res[less-1];
	 	
	 	
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LengthMaxtrixRoad ll=new LengthMaxtrixRoad();
		
		int a[][]={{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
		
		System.out.println(ll.minPath1(a));
		System.out.println("以下使用空间压缩法");
		System.out.println(ll.minPath2(a));
		
	}

}
