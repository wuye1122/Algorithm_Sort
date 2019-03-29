package com.wuye.graph;

public class DFSBFS {
/*
 * 1 ���� 
 *   
 *   ���ڽӾ��������������
 *   
 *   �ڽӾ���ͼ�ı���:
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
 *   ������� �Ȱѵ�һ����ȫ����������   ������������visited[]������������true
 *   
 *   �ٶ�ÿһ�����ʹ��ö����������
 * 
 * 
 * 2 ����
 * 
 *   ������� �ȰѸ���һ�����ӵ�д���� Ҳ���Ǻ��ſ�
 *   
 *   Ȼ��Ա���֮���ÿһ�����й���
 * 
 * 
 * 
 * */
	
	
   //����ļ���
   char [] vexs;
   //���Ƚ�ͼ���ڽӾ����ʾ����
   int[][] Matrix;

	//��ȡָ���ڵ����һ���ڽӽڵ������  ��ÿһ�иտ�ʼ �ҳ���һ��1�ĵط�
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
	
	
	
	//���Ż�ȡ  v m ��һ������1�ĵط�
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
	//������й�����ȱ���
	
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
				//�˴��и�for
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
		
		
		
	
	
	
	//�������������ȱ���  
	public void  DFS(){
		
		
	//���ȶ���һ��boolean[]	
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
		System.out.print(this.vexs[i]+" ");//���
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
		
		
		System.out.println("ͼ�ı�������:");
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
		 char[][] edges = new char[][]{//���Ǹ���ά����
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
		 System.out.println("������ȱ���:");
		 db.DFS();
		 System.out.println("");
		
		 System.out.println("������ȱ���:");
		 db.BFS();
	}

}
