package com.wuye.graph;

public class Kruskal {
/*
 *   通过Kruskal算法   得出最小生成树 矩阵表示
 * 
 * 
 *   选出权值最小的边  然后一下一下往一起拼
 * 
 * 
 * 
 * 
 * */
	
	
	private int count;//定义一下边数
   //定义一下边类
	private class ENode{
		
		char start; // 边的起点
		char end;   // 边的终点
		int weight; // 边的权重

		ENode(char start, char end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
	}
	
	

	private char[] tops;       // 顶点集合
	private int[][] mMatrix;    // 邻接矩阵
	
	private static final int INF = Integer.MAX_VALUE;   // 最大值
	
	//进行对边的排序
	
	public void sortEdge(ENode[] node){
		//对已经整理好的对象数组进行对边的排序
		for(int i=0;i<node.length;i++){
			ENode mm;
			for(int j=i+1;j<node.length;j++){
				if(node[i].weight>node[j].weight){
					mm=node[j];
					node[j]=node[i];
					node[i]=mm;
				  }
				
				
			  }
			
			
		  }
	/*	System.out.println();
		for(ENode aa:node){
			System.out.println(aa.start+"--"+aa.end+"权值:"+aa.weight);
			}
		*/
		
	}
	
	//将边初始化到数组里面
	public ENode[] getEdge(){
		
		int index=0;
		ENode[] node=new ENode[this.count];
		for(int i=0;i<this.mMatrix.length;i++){
			for(int j=i+1;j<this.mMatrix[i].length;j++){
				if(this.mMatrix[i][j]!=INF){
					node[index++]=new ENode(tops[i],tops[j],this.mMatrix[i][j]);

				}
			}
			
		}
		return node;
	}
	
	Kruskal(char[] vexs,int matrix[][]){
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
		
		//统计边的个数  只需要看矩阵的一半再减去一斜条就是
		
		for(int i=0;i<matrix.length;i++){
			for(int j=i+1;j<matrix[i].length;j++){
				if(matrix[i][j]!=INF){
					this.count++;
				}
			}
			
			
		}
		
		
	}
	
	public void Kruksal(){
		
		int index=0;//保存树使用索引
		
		int temp[]=new int[this.tops.length];
		
		ENode[] res=new ENode[this.count];
		
		ENode[] tt;
		
		tt=getEdge();
		
		this.sortEdge(tt);
		
		
		//首先进入循环
		
		
		for(int i=0;i<this.count;i++){
			
			
		int start=getPosition(tt[i].start);//将边的开始位置变成数字
			
	    int end=getPosition(tt[i].end);//将边的结束位置变成数字
	    
	    int m=getEnd(temp, start);
	    int n=getEnd(temp,end);
	    
	    if(m!=n){
	    	temp[m]=n;
	    	
	    	res[index++]=tt[i];
	        }
	    
		}  
		
		
	   int lengh=0;//因为谁也不知道有多少边
	    for(int k=0;k<index;k++){
	    	lengh+=res[k].weight;
	    	System.out.println(res[k].weight);
	    
	        }
	   System.out.println("最终结果是:"+lengh);
	    System.out.println();
		
		 for(int k=0;k<index;k++){
			 System.out.println(res[k].start+"--"+res[k].end+"权值:"+res[k].weight);
		    
		        }
		
		    
	}
		
		
		
		
	
	
	//超级不懂
	/*
	 *  // tend[4]=3 代表的而是top[4]的终点是top[3]
	 * 
	 *    此方法 判断的是top[point]的终点 在a数组里面有没有 有的情况下不需要因为后来的比前面大
	 *    
	 * */
	
	public int getEnd(int [] a,int point){
		while(a[point]!=0){
			point=a[point];
		}
		return point;
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

		Kruskal kru=new Kruskal(vexs, matrix); 
		kru.printGraph();
		System.out.println("该图一个有多少边:"+kru.count);
		
		
	/*	System.out.println();
		for(ENode aa:kru.getEdge()){
			System.out.println(aa.start+"--"+aa.end+"权值:"+aa.weight);
			}
		
		kru.sortEdge(kru.getEdge());
	*/
		kru.Kruksal();
	}

}
