package com.wuye.graph;

public class DFSBFS {
/*
 * 1 深搜 
 *   
 *   在邻接矩阵里面进行搜索
 *   
 *   邻接矩阵图的遍历:
     0 1 0 0 0 1 0 0 0 
	 0 0 1 0 0 0 1 0 1 
	 0 1 0 1 0 0 0 0 1 
	 0 0 1 0 1 0 1 1 1 
	 0 0 0 0 0 1 0 1 0 
	 1 0 0 0 1 0 1 0 0 
	 0 1 0 1 0 0 0 1 0 
	 0 0 0 1 1 0 1 0 0 
	 0 1 1 0 0 0 0 0 0 
 * 
 *   深度搜索 先把第一竖排全部都搜索了   将遍历过得在visited[]数组里面设置true
 *   
 *   再对每一个访问过得顶点进行深搜
 * 
 * 
 * 2 广搜
 * 
 *   广度搜索 先把跟第一个连接的写出来 也就是横着看
 *   
 *   然后对遍历之后的每一个进行广搜
 * 
 * 
 * 
 * */
	
	
   //顶点的集合
   char [] vexs;
   //首先将图的邻接矩阵表示出来
   int[][] Matrix;

	//获取指定节点的下一个邻接节点的索引  在每一行刚开始 找出第一个1的地方
	public int getfirst(int v){
		if(v<0||v>(vexs.length-1)){
			return -1;
		}
		for(int i=0;i<vexs.length;i++){
			if(this.Matrix[v][i]==1){
				return i;
			}
		}
		return -1;
	}
	
	
	
	//横排获取  v m 下一处等于1的地方
	public int  getNext(int v,int m){
		if(v<0||v>(vexs.length-1)||m<0||m>(vexs.length-1)){
			return -1;
		}
		for(int i=m+1;i<vexs.length;i++){
			if(this.Matrix[v][i]==1){
				return i;
			}
		}
		return -1;
	}
	//下面进行广度优先遍历
	
	public void BFS(){
		
		int head=0;
		int rear=0;
		int queue[]=new int[this.vexs.length];
		boolean visited[]=new boolean[this.vexs.length];
		
		for(int i=0;i<visited.length;i++){
			visited[i]=false;
		    }
		
		for(int i=0;i<this.vexs.length;i++){
			if(visited[i]==false){
				visited[i]=true;
				System.out.print(this.vexs[i]+" ");
				queue[rear++]=i;
			   }
			
			while(head!=rear){
				
				int ii=queue[head++];
				int k=getfirst(ii);
				//此处有个for
				while(k>=0){
					if(visited[k]==false){
						visited[k]=true;
						System.out.print(this.vexs[k]+" ");
						queue[rear++]=k;
						}
					 k=getNext(ii, k);
				}
				
				
			   }
			
			}
		}
		
		
		
	
	
	
	//下面进行深度优先遍历  
	public void  DFS(){
		
		
	//首先定义一个boolean[]	
		boolean []visited=new boolean[this.vexs.length];
		
		for(int i=0;i<visited.length;i++){
			visited[i]=false;		
		}
		
		for(int i=0;i<visited.length;i++){
			if(visited[i]==false){
				DFS(i,visited);
			}
		}
	}
	
	private void DFS(int i, boolean[] visited) {
		// TODO Auto-generated method stub
		visited[i]=true;
		System.out.print(this.vexs[i]+" ");//输出
		int pos=getfirst(i);
		
		while(pos>=0){
			if(visited[pos]==false){
			  DFS(pos,visited);
			}
			pos=getNext(i, pos);
		}
		
		
		
	}



	public int getPostion(char ch){
		for(int i=0;i<this.vexs.length;i++){
			if(vexs[i]==ch){
				return i;
			}
		}
		return -1;
	}
	
	DFSBFS(char[]ch,char[][]edges){
		
		
		vexs=new char[ch.length];
		
		Matrix=new int[vexs.length][vexs.length];
		
		for(int i=0;i<vexs.length;i++){
		   vexs[i]=ch[i];
		}
		
		for(int i=0;i<edges.length;i++){
			int p1=getPostion(edges[i][0]);
			int p2=getPostion(edges[i][1]);
			
			Matrix[p1][p2]=1;
		  }
		}
		
	public void printGraph(){
		
		
		System.out.println("图的遍历如下:");
		for(int i=0;i<this.vexs.length;i++){
		  for(int j=0;j<vexs.length;j++){
			  System.out.print(this.Matrix[i][j]+" ");
			  }
		  System.out.println();
		}
		}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 char[] vexs = {'A', 'B', 'C', 'D','E','F','G','H','I'};
		 char[][] edges = new char[][]{//边是个二维数组
					{'A', 'B'},
					{'A', 'F'},
					{'B', 'G'},
					{'B', 'C'},
					{'B', 'I'},
					{'C', 'B'},
					{'C', 'I'},
					{'C', 'D'},
					{'D', 'C'},
					{'D', 'I'},
					{'D', 'G'},
					{'D', 'H'},
					{'D', 'E'},
					{'E', 'H'},
					{'E', 'F'},
					{'F', 'G'},
					{'F', 'A'},
					{'F', 'E'},
					{'G', 'H'},
					{'G', 'D'},
					{'G', 'B'},
					{'H', 'G'},
					{'H', 'D'},					
					{'H', 'E'},
					{'I', 'B'},
					{'I', 'C'},
	
			}; 
		 
		 DFSBFS db=new DFSBFS(vexs, edges);
		 db.printGraph();
		 System.out.println();
		 System.out.println("深度优先遍历:");
		 db.DFS();
		 System.out.println("");
		
		 System.out.println("广度优先遍历:");
		 db.BFS();
	}

}
