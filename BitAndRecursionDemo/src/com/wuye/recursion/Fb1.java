package com.wuye.recursion;

public class Fb1 {
	
	/* 
	 * 
	 *  斐波那契数列:
	 *  
	 *  1 1 2 3 5 8 13 21 
	 *  
	 *  暴力递归:O(2^n)
	 * 
	 * 
	 *  顺序计算:O(n)
	 * 
	 * 
	 *  使用矩阵乘法的形式可以降到O(logN)
	 * 
	 *  注意:F(n)=F(n-1)+F(n-2)一个二阶递推数列
	 *  
	 *      一定可以使用矩阵乘法进行表示
	 *                                    |a  b|(n-(n-1))
	 *     (F(n),F(n-1))=(F(n-1),F(n-2))* |    | 
	 *                                    |c  d|
	 * 
	 *     ……………………
	 *                                    |a  b|(n-2)
	 *     (F(n),F(n-1))=(F(2),F(1))*     |    | 
	 *                                    |c  d|
	 * 
	 *     abcd可以由前几组数求出来:1110
	 * 
	 * 
	 * 
	 * */
	
	//暴力递归
	public int ff1(int n){
		if(n<0){
			return 0;
		}
		if(n==1|n==2){
			
			return 1;
		}
		
		return ff1(n-1)+ff1(n-2);
		
	}
	
	//顺序计算
	
	public int ff2(int n){
		
		if(n<0){
			return 0;
		}
		if(n==1|n==2){
			
			return 1;
		}
		
		int res=1;//指向第 n-1
		int pre=1;//指向第n-2
		int tem=0;
		
		
		for(int i=3;i<=n;i++){
			tem=res;
			
			res=res+pre;//此时的res指向求得值
			
			pre=tem;//tem把n-1处的值 传递给 pre
			
		}
		return res;

	}
	
	//使用矩阵乘法 使其时间复杂度降低至O(logN)
	
	//然后定义一个矩阵的n次方  因为是一个矩阵的n次方 所以行列相等
	public int[][] maxPower(int [][]c,int p){
		//首先定义一个单位数组
		
		int[][]res=new int[c.length][c[0].length];
		
		for(int i=0;i<c.length;i++){
			res[i][i]=1;
				}
		int [][]tem=c;
		for(;p!=0;p>>=1){
			if((p&1)!=0){
				res=matrix(res,tem);
				
			}
			tem=matrix(tem,tem);
		}
		return res;
		
	}
	
	
	
	
	//首先定义两个矩阵相乘    2*4    4*5
	public  int[][] matrix(int [][]a1,int[][]b1){
		
		int [][] res=new int[a1.length][b1[0].length];
		
		
		for(int i=0;i<a1.length;i++){
			for(int j=0;j<b1[0].length;j++){
				
				for(int k=0;k<b1.length;k++){
					
					res[i][j]+=a1[i][k]*b1[k][j];
				}
				
				
			}
			
			
		}
		return res;
		
	}
	
	public  int  ff3(int n){
		
		if(n<0){
			return 0;
		}
		if(n==1|n==2){
			
			return 1;
		}
		
		   //通过计算求出来的
		int res[][] ={{1,1},{1,0}};
		
		int tem[][]=maxPower(res,n-2);
		
		return tem[0][0]+tem[1][0];
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          for(int i=1;i<=10;i++){
        	 System.out.print(new Fb1().ff1(i)+".");
        	  
          }
          System.out.println();
          for(int i=1;i<=10;i++){
         	 System.out.print(new Fb1().ff2(i)+".");
         	  
           }
          System.out.println();
          
          int [][]a={{1,1},{2,2},{3,3}};//3*2
          
          System.out.println("矩阵的行是:"+a.length+"矩阵的的列是:"+a[0].length);
	
	      int p=100;//110 
	      System.out.println(p>>=1); //向右边移动一位
	     
	      //只有当p=1时候 1&1=1
	      System.out.println(1&1);
	      System.out.println(0&0);
	      System.out.println(0&1);
	      System.out.println(1&0);
	      
	      
	      //一个矩阵的乘方
	      
	      for(int q=6;q!=0;q>>=1){
	    	  if((q&1)!=0){
	    		  System.out.println("和单位矩阵相乘:"+q);
	    	  }
	    	  System.out.println("和自己相乘:"+q);
	    	  
	      }
	      
	      
	      System.out.println("第三种使用矩阵的方法如下:-------------");
          for(int i=1;i<=10;i++){
         	 System.out.print(new Fb1().ff3(i)+".");
         	  
           }
          System.out.println();
	      
	}

}
