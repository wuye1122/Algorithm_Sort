package com.wuye.graph;

public class Prim {
/*  
 *  prim算法  邻接矩阵 和邻接表
 *  
 *  生成最小生成树:图的N个顶点全都包括   但是使用的边是N-1
 * 
 *            花费的代价比较小 
 * 
 * 
 *  kruskal算法 邻接矩阵 和 邻接表
 *  
 *  
 * 
 *   
 * */
	
	
	
	//矩阵表示Prim算法利用图的矩阵表示法
	
	
	private char[] tops;       // 顶点集合
	private int[][] mMatrix;    // 邻接矩阵
	
	private static final int INF = Integer.MAX_VALUE;   // 最大值
	
	
	
	Prim(char[] vexs,int matrix[][]){
		//初始化顶点
		this.tops=new char[vexs.length];
		for(int i=0;i<vexs.length;i++){

			this.tops[i]=vexs[i];



		}
		this.mMatrix=new int[vexs.length][vexs.length];
		//初始化邻接矩阵
		for(int i=0;i<matrix.length;i++){

			for(int j=0;j<matrix[i].length;j++){
				this.mMatrix[i][j]=matrix[i][j];

			}

		}
	}
	
	
	public void printGraph(){


		System.out.println("图的遍历如下:");
		for(int i=0;i<this.tops.length;i++){
			for(int j=0;j<tops.length;j++){
				if(mMatrix[i][j]==INF){
					System.out.print("O"+" ");  
				}else{
					System.out.print(this.mMatrix[i][j]+" ");
				}
			}
			System.out.println();
		}
	}

     public void prim(int start){//定义开始位置
    	 
    	 
     int index=0;//索引
     
     char top[]=new char[this.tops.length];//定义存放最小生成树节点的数组
     
     int weight[]=new int[this.tops.length];//注意记录权值 
     
     
     
     top[index++]=this.tops[start];
    	 
     //对weight进行赋值  当一下weight[i]=0时候  说明i以及遍历完了
     
     for(int i=0;i<weight.length;i++){
    	 weight[i]=this.mMatrix[start][i];//此时显示的 A 到其他点的距离
    	 
     }
     
       weight[start]=0;//说明start不需要遍历
       
       
       //下面进行比较
       for(int i=0;i<this.tops.length;i++){
    	   if(start==i){
    		   continue;
    	   }
    	   int j=0;
    	   int k=0;
    	   int min=INF;
    	   
    	   while(j<this.tops.length){
    		   
    		   if(weight[j]!=0&&weight[j]<min){
    			   min=weight[j];//选出第一排最小的
    			   k=j;//将最小的节点的索引取出来
    		   }
    		   j++;//j变成下一个
    	   }
    	   
    	   top[index++]=tops[k];//将新的索引加入树里面
    	   
    	   weight[k]=0;//说明k不需要遍历
    	   
    	   //下面从k的开始往下面找最小的
    	   
    	   /*
    	    *   top数组是从1  开始的 当加入第二个元素的时候 1  2 且都为0
    	    *   
    	    *   索引下面遍历的时候就是从索引3开始遍历的  但是  从2对象字母在matrix矩阵里面进制查找最小的
    	    * 
    	    * 
    	    * 
    	    * */
    	   
    	  for(j=0;j<tops.length;j++){
    		  
    		  if(weight[j]!=0&&this.mMatrix[k][j]<weight[j]){
    			  weight[j]=this.mMatrix[k][j];
    			  
    		  }
    	  }
       }
       
       
       System.out.println("打印最小生成树的数组");
       System.out.println("");
       for(char t:top){
    	   System.out.print(t+" ");
       }
       System.out.println("");
    /*   
     *  不一定是连续的  所有不可以使用这种方法
     *  
       System.out.println(top[0]-65);
        
       System.out.println(top[0]+"-"+top[1]+"权值:"+this.mMatrix[top[0]-65][top[1]-65]);
       System.out.println(top[1]+"-"+top[2]+"权值:"+this.mMatrix[top[1]-65][top[2]-65]);
       System.out.println(top[2]+"-"+top[3]+"权值:"+this.mMatrix[top[2]-65][top[3]-65]);
       System.out.println(top[3]+"-"+top[4]+"权值:"+this.mMatrix[top[3]-65][top[4]-65]);
       System.out.println(top[4]+"-"+top[5]+"权值:"+this.mMatrix[top[4]-65][top[5]-65]);
       System.out.println(top[5]+"-"+top[6]+"权值:"+this.mMatrix[top[5]-65][top[6]-65]);
       */
       
       int sum=0;
       
    
       for(int i=1;i<this.tops.length;i++){
    	   int mina=INF;
    	   int m=getPosition(top[i]);
    	   
    	   for(int j=0;j<i;j++){
    		   int k=getPosition(top[j]);
    		   if(mMatrix[m][k]<mina){
    			   mina=mMatrix[m][k];
    			   
    		   }
    		   
    	   }
    	   
    	   System.out.println("最小值"+mina);
    	   sum+=mina;
       }
       System.out.println("最小权值:"+sum);
     
    	 
     }


 	private int getPosition(char ch) {
		for(int i=0; i<tops.length; i++){
			if(tops[i]==ch){
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		int matrix[][] = {
				/*A*//*B*//*C*//*D*//*E*//*F*//*G*/
				/*A*/ {   0,  12, INF, INF, INF,  16,  14},
				/*B*/ {  12,   0,  10, INF, INF,   7, INF},
				/*C*/ { INF,  10,   0,   3,   5,   6, INF},
				/*D*/ { INF, INF,   3,   0,   4, INF, INF},
				/*E*/ { INF, INF,   5,   4,   0,   2,   8},
				/*F*/ {  16,   7,   6, INF,   2,   0,   9},
				/*G*/ {  14, INF, INF, INF,   8,   9,   0}
		};

		Prim pp=new Prim(vexs, matrix);
		pp.printGraph();
		System.out.println();
		System.out.println("Prim算法 得出的最小生成树如下:");
		pp.prim(0);
	}

}
