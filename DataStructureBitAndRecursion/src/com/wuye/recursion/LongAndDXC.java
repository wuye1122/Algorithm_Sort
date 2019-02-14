package com.wuye.recursion;

public class LongAndDXC {

	/*   递归-龙与地下问题
	 * 
	 * 去年面试题:骑士从左上角出发往右下方向走 每次只能向右或者向下
	 *           负数代表消耗血量  正数代表此处有血瓶恢复血量  最终见到公主
	 *           血量不得少于1
	 *     
	 *   此数组相当于一个减数。你的血量到此处需要减去相应的数。         
	 *   -2  -3  3      
	 *   -5 -10  1 
	 *    0  30 -5
	 *    
	 *    
	 *    
	 *    7  5  2
	 *    6  11 5
	 *    1  1  6
	 * 
	 *           求初始血量是多少。
	 * 
	 * 此题使用动态规划进行计算。
	 * 
	 * 
	 * 、、右下角只能往左和往上走。
	 * 
	 * 此题的思路是从右下角向左上角进行出发  ,而且刚开始确定右下角的值
	 * 
	 *  先得出最下面的那一排  然后是倒数第二排               
	 *  
	 *  计算方向:<-------
	 *        <------- 
	 *        <-------    
	 *        <-------   
	 * 
	 * 
	 * */
	
	public  int minPh(int [][] b){
		if(b==null||b.length==0||b[0].length==0||b[0]==null){
			return -1;
		}
		int row=b.length;
		int col=b[0].length;
		int [][]dp=new int[row--][col--];
		//此时候的row  col变成了最后的索引
		
		//首先对dp[row][col]进行赋值 
		// dp[i][j]代表的意思是,在刚要进入b[i][j]的时候需要的最小值
		// 也就是被减数dp[i][j]-b[i][j]>=1
		//
		dp[row][col]=b[row][col]<0?1-b[row][col]:1;
		
		//下面是对dp[][]最后一行进行赋值
		//变化的是col
		for(int i=col-1;i>=0;i--){
			//1 0 
			dp[row][i]=Math.max(1, dp[row][i+1]-b[row][i]);
		}
		
		
		
		//下面是对剩余几行进行赋值
		int right=0;//记录向左走
		int up=0;//记录向上走
		
		for(int i=row-1;i>=0;i--){
			//1 0
			//首先对每一排的最后一个进行赋值
			dp[i][col]=Math.max(1, dp[i+1][col]-b[i][col]);
			for(int j=col-1;j>=0;j--){
                    // 1 0
			   right=Math.max(1, dp[i][j+1]-b[i][j]);
			   up=Math.max(1, dp[i+1][j]-b[i][j]);
			   dp[i][j]=Math.min(right, up);
			
		}
		
		
	}
		
		System.out.println("---------------");
		for(int aa[]:dp){
			for(int bb:aa){
				System.out.print(bb+"-");
			}
			System.out.println();
		}
		
		
		System.out.println("---------------");
		return dp[0][0];
	
	}
	
	//另一种采用的是空间压缩法 O(min{M,N})
	/*
	 * 
	 * 选择长度最短的一条边   编程里面多次使用长短进行判断与赋值.
	 * 如果row>col  那么选择col一定从下面那一行到上面。
	 * 
	 * 如果row<col  那么选择row一定从右面那一行到左面。
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	
	
	public int minPHP(int [][]a){
		
		if(a==null||a.length==0||a[0].length==0||a[0]==null){
			return 0;
		}
		
		//下面选择 假设more==a.length 相当于从下到上
		
		int more=Math.max(a.length, a[0].length);
		int less=Math.min(a.length, a[0].length);
		
		boolean fal=more==a.length;
		
		//下面取出a里面的最后一个值
		
		int tem=a[a.length-1][a[0].length-1];
		
		int dp[]=new int[less];
		
		dp[less-1]=tem<=0?1-tem:1;
		
		
		//定义两个变量 进行选择长宽
		int row=0;
		int col=0;
		for(int i=less-2;i>=0;i--){
			row=fal?more-1:i;
			col=fal?i:more-1;
			dp[i]=Math.max(1, dp[i+1]-a[row][col]);
		}
		
		int choose1=0;
		int choose2=0;
		
		//下面对上面一排进行更新  或者对右数第二排进行更新
		for(int i=more-2;i>=0;i--){
			row=fal?i:less-1;
			col=fal?less-1:i;
			dp[less-1]=Math.max(1, dp[less-1]-a[row][col]);
			for(int j=less-2;j>=0;j--){
				row=fal?i:j;
				col=fal?j:i;
				
				choose1=Math.max(dp[j+1]-a[row][col],1);
				choose2=Math.max(dp[j]-a[row][col], 1);
				dp[j]=Math.min(choose1, choose2);
			}
			
		
		}
		
		System.out.println("-------");
		for(int bb:dp){
			
			System.out.print(bb+" ");
			
		}
		
		
		System.out.println("-------");
		return dp[0];
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongAndDXC dd=new LongAndDXC();
		int b[][]={{-2,-3,3},{-5,-10,1},{0,30,-5},{1,2,-5}};
		System.out.println(dd.minPh(b));
		System.out.println("------------------");
		int c[][]={{-2,-3,3},{-5,-10,1}};
		System.out.println(dd.minPh(c));
		System.out.println("------------------");
		System.out.println(dd.minPHP(b));
		System.out.println("------------------");
		System.out.println(dd.minPHP(c));
		System.out.println("------------------");
		
	}

}
