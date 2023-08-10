package com.wuye.recursion;

public class WinerOfChoosePaper {
/*  
 * rescursion -关于纸牌博弈问题
 * 
 * ****你不仅是先拿着 也是后拿着
 * 
 * 
 * 一个数组    被AB两个玩家   每次只允许拿左面或者右面的  
 *        最后返回赢着的分数。
 * 
 * 方法一:含有两支递归时间复杂度O(2^n);指数
 * 
 *   主要理解f()先拿着 要考虑自己也会成为一个后拿着者:自己一定选择大的
 *   
 *        s()面临数组取出左右两边之后 自己就作为一个先拿着了   但是自己拿完之后 一定区最小值
 *           因为对手也不傻
 * 
 * 
 * 
 * 
 * 
 * 方法二:动态规划 时间复杂度O(n^2);幂函数
 * 
 *     将情况写在一个数组里面然后反向思维
 * 
 *     使用两个矩阵的方式进行分别计算自己先拿后拿的分数
 *     f[i][j]=f(i,j)的值
 *     s[i][j]=s(i,j)的值
 *    
 *     1 2 100  4
 *     
 *     0 1 2 3
 *   0 0 
 *   1   2
 *   2     100 
 *   4        4 
 * 
 * */
	//动态规划
	public int win2(int []b){
		if(b==null||b.length==0){
			return 0;
			
		}
		int f[][]=new int[b.length][b.length];
		int s[][]=new int[b.length][b.length];
		
		for(int j=0;j<b.length;j++){
			f[j][j]=b[j];
			for(int i=j-1;i>=0;i--){
				f[i][j]=Math.max(b[i]+s[i+1][j], b[j]+s[i][j-1]);
				s[i][j]=Math.min(f[i+1][j], f[i][j-1]);
			}
			
		}
		System.out.println("对两个矩阵进行遍历");
		for(int a[]:f){
			for(int ff:a){
				System.out.print(ff+" ");
				
			}
			System.out.println();
		}
		
		System.out.println("-------------------");
		for(int a[]:s){
			for(int ff:a){
				System.out.print(ff+" ");
				
			}
			System.out.println();
		}
		
		return Math.max(f[0][b.length-1], s[0][b.length-1]);
	}
	
	
	
	//方法一  :暴力递归
	public int win1(int []a){
		if(a==null||a.length==0){
			return 0;
			
		}
		return Math.max(fir(a,0,a.length-1), lat(a,0,a.length-1));
	}
	
	//定义两个函数  分别代表先拿的得到的分数
	public int fir(int []a,int i,int j){
		if(i==j){
			return a[1];
		}
		
		//先拿着会选择 ( 拿左面 和 面临剩余部分后拿者的分     拿右面  和 剩余部分后拿者的分)
		return Math.max(a[i]+lat(a, i+1, j ), a[j]+lat(a,i,j-1));
	}
	
	//面的一个数组后拿的得到的分数
	public int  lat(int []a,int i,int j){
		
		if(i==j){//如果后拿的面临只有一个元素的话那么她一定是什么也得不到
		return 0;	
		}
		
		//后拿着一定是在面临了别人拿走了 一个i或者一个j然后自己作为剩余部分是一个先拿着
		return Math.min(fir(a,i+1,j), fir(a,i,j-1));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WinerOfChoosePaper rr=new WinerOfChoosePaper();
		int a[]={1,2,3,4,5,6};
		
		System.out.println(rr.win1(a));
		System.out.println(rr.win2(a));
	}

}
