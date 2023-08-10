package com.wuye.graph;

public class MatrixGraph {
/* 关于图的邻接矩阵 
 * 
 * 1 无向图的邻接矩阵是对称的 斜对角都是0
 * 
 * 2 有向图的邻接矩阵 不是对称的   有出度和入度 
 *   如果有向图的每两个顶点之间都是相互的就是对称的 也就跟无向图同理
 *   
 * 3 带权值的有向图 在edges的元素里面多添加一个weigth  
 * 
 * */
	
	private char[] vex;//定义点的数组
	
	private int[][] matrix;//定义邻接矩阵
	
	/*
	 *   顶点数组  : vex 存图的顶点的数组
	 * 
	 *   边数组: edges 存图的边的数组
	 * 
	 * */
	MatrixGraph(){}
	
	//原构造器  无向图
	public MatrixGraph(char[] ve,char[][]edges){
		
		
		//将图的顶点赋值
		vex=new char[ve.length];
		for(int i=0;i<ve.length;i++){
			this.vex[i]=ve[i];
		}
		
		//对矩阵赋值 矩阵长宽跟点走  但是遍历的时候遍历的边  
		matrix=new int[vex.length][vex.length];
		for(int i=0;i<edges.length;i++){
			int p1=getPostion(edges[i][0]);
			int p2=getPostion(edges[i][1]);
			this.matrix[p1][p2]=1;//对于无向图 是对称的
			this.matrix[p2][p1]=1;//有向图就是赋值的时候不一样
		}
	} 
	
	//重载构造器    这个是有向图
	public MatrixGraph(char[][]edges,char[] ve){
		
		
		//将图的顶点赋值
		vex=new char[ve.length];
		for(int i=0;i<ve.length;i++){
			this.vex[i]=ve[i];
		}
		
		//对矩阵赋值 矩阵长宽跟点走  但是遍历的时候遍历的边  
		matrix=new int[vex.length][vex.length];
		for(int i=0;i<edges.length;i++){
			int p1=getPostion(edges[i][0]);
			int p2=getPostion(edges[i][1]);
			this.matrix[p1][p2]=1;//对于有向图 是对称的
			
			//带权值  将最终赋的值=edges[i][2]   赋值几次代表有向与无向
			
			
		}
		
	}
	
public void  MatrixGraph3(char[][]edges,char[] ve){
		
		
		//将图的顶点赋值
		vex=new char[ve.length];
		for(int i=0;i<ve.length;i++){
			this.vex[i]=ve[i];
		}
		
		//对矩阵赋值 矩阵长宽跟点走  但是遍历的时候遍历的边  
		matrix=new int[vex.length][vex.length];
		for(int i=0;i<edges.length;i++){
			int p1=getPostion(edges[i][0]);
			int p2=getPostion(edges[i][1]);
			int weigth=edges[i][2];
			
			//带权值  将最终赋的值=edges[i][2]   赋值几次代表有向与无向
			this.matrix[p1][p2]=weigth-48;
			
		}
		
	}
	
	
	
	//首先定义一个方法 从顶点能够找到期索引  方便边的遍历
	
	public int getPostion(char ch){
		for(int i=0;i<vex.length;i++){
			if(vex[i]==ch){
				return i;
			}
		}
		return -1;
	   }
	public void printGraph(){
		
		for(int i=0;i<vex.length;i++){
			for(int j=0;j<vex.length;j++){
				System.out.print(this.matrix[i][j]+" ");
			}
			System.out.println();
		}		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    char[] ch={'A','B','C','D'};
    
    char[][] edge={{'A','B'},{'A','C'},{'A','D'},{'B','C'},{'D','C'}};
		
    MatrixGraph graph=new MatrixGraph(ch,edge);	
    
    System.out.println("无向图的邻接矩阵");
    graph.printGraph();
    

	System.out.println("");
	
	     char[] ch1={'A','B','C','D'};
	    
	    char[][] edge1={{'A','B'},{'A','C'},{'A','D'},{'B','D'},{'D','B'},{'D','C'}};
			
	    MatrixGraph graph1=new MatrixGraph(edge1,ch1);	
	    
	
	System.out.println("有向图的邻接矩阵");
	graph1.printGraph();
	
	
	System.out.println("");
	
    char[] ch2={'A','B','C','D'};
   
   char[][] edge2={{'A','B','1'},{'A','C','2'},{'A','D','3'},{'B','D','4'},{'D','C','5'}};
		
   MatrixGraph graph2=new MatrixGraph();	
   graph2.MatrixGraph3(edge2, ch2);

   System.out.println("带权值有向图的邻接矩阵");
   graph2.printGraph();

   char aa='0';
   System.out.println("字符0是 unicode码  是48");
   System.out.println((int)aa);
	}

}
