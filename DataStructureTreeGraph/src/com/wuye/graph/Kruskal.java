package com.wuye.graph;

public class Kruskal {
/*
 *   ͨ��Kruskal�㷨   �ó���С������ �����ʾ
 * 
 * 
 *   ѡ��Ȩֵ��С�ı�  Ȼ��һ��һ����һ��ƴ
 * 
 * 
 * 
 * 
 * */
	
	
	private int count;//����һ�±���
   //����һ�±���
	private class ENode{
		
		char start; // �ߵ����
		char end;   // �ߵ��յ�
		int weight; // �ߵ�Ȩ��

		ENode(char start, char end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
	}
	
	

	private char[] tops;       // ���㼯��
	private int[][] mMatrix;    // �ڽӾ���
	
	private static final int INF = Integer.MAX_VALUE;   // ���ֵ
	
	//���жԱߵ�����
	
	public void sortEdge(ENode[] node){
		//���Ѿ�����õĶ���������жԱߵ�����
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
			System.out.println(aa.start+"--"+aa.end+"Ȩֵ:"+aa.weight);
			}
		*/
		
	}
	
	//���߳�ʼ������������
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
		//��ʼ������
		this.tops=new char[vexs.length];
		for(int i=0;i<vexs.length;i++){

			this.tops[i]=vexs[i];



		}
		this.mMatrix=new int[vexs.length][vexs.length];
		//��ʼ���ڽӾ���
		for(int i=0;i<matrix.length;i++){

			for(int j=0;j<matrix[i].length;j++){
				this.mMatrix[i][j]=matrix[i][j];

			}

		}
		
		//ͳ�Ʊߵĸ���  ֻ��Ҫ�������һ���ټ�ȥһб������
		
		for(int i=0;i<matrix.length;i++){
			for(int j=i+1;j<matrix[i].length;j++){
				if(matrix[i][j]!=INF){
					this.count++;
				}
			}
			
			
		}
		
		
	}
	
	public void Kruksal(){
		
		int index=0;//������ʹ������
		
		int temp[]=new int[this.tops.length];
		
		ENode[] res=new ENode[this.count];
		
		ENode[] tt;
		
		tt=getEdge();
		
		this.sortEdge(tt);
		
		
		//���Ƚ���ѭ��
		
		
		for(int i=0;i<this.count;i++){
			
			
		int start=getPosition(tt[i].start);//���ߵĿ�ʼλ�ñ������
			
	    int end=getPosition(tt[i].end);//���ߵĽ���λ�ñ������
	    
	    int m=getEnd(temp, start);
	    int n=getEnd(temp,end);
	    
	    if(m!=n){
	    	temp[m]=n;
	    	
	    	res[index++]=tt[i];
	        }
	    
		}  
		
		
	   int lengh=0;//��Ϊ˭Ҳ��֪���ж��ٱ�
	    for(int k=0;k<index;k++){
	    	lengh+=res[k].weight;
	    	System.out.println(res[k].weight);
	    
	        }
	   System.out.println("���ս����:"+lengh);
	    System.out.println();
		
		 for(int k=0;k<index;k++){
			 System.out.println(res[k].start+"--"+res[k].end+"Ȩֵ:"+res[k].weight);
		    
		        }
		
		    
	}
		
		
		
		
	
	
	//��������
	/*
	 *  // tend[4]=3 ����Ķ���top[4]���յ���top[3]
	 * 
	 *    �˷��� �жϵ���top[point]���յ� ��a����������û�� �е�����²���Ҫ��Ϊ�����ı�ǰ���
	 *    
	 * */
	
	public int getEnd(int [] a,int point){
		while(a[point]!=0){
			point=a[point];
		}
		return point;
	}
	public void printGraph(){


		System.out.println("ͼ�ı�������:");
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
		System.out.println("��ͼһ���ж��ٱ�:"+kru.count);
		
		
	/*	System.out.println();
		for(ENode aa:kru.getEdge()){
			System.out.println(aa.start+"--"+aa.end+"Ȩֵ:"+aa.weight);
			}
		
		kru.sortEdge(kru.getEdge());
	*/
		kru.Kruksal();
	}

}
