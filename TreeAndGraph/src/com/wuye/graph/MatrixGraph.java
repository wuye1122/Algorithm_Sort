package com.wuye.graph;

public class MatrixGraph {
/* ����ͼ���ڽӾ��� 
 * 
 * 1 ����ͼ���ڽӾ����ǶԳƵ� б�ԽǶ���0
 * 
 * 2 ����ͼ���ڽӾ��� ���ǶԳƵ�   �г��Ⱥ���� 
 *   �������ͼ��ÿ��������֮�䶼���໥�ľ��ǶԳƵ� Ҳ�͸�����ͼͬ��
 *   
 * 3 ��Ȩֵ������ͼ ��edges��Ԫ����������һ��weigth  
 * 
 * */
	
	private char[] vex;//����������
	
	private int[][] matrix;//�����ڽӾ���
	
	/*
	 *   ��������  : vex ��ͼ�Ķ��������
	 * 
	 *   ������: edges ��ͼ�ıߵ�����
	 * 
	 * */
	MatrixGraph(){}
	
	//ԭ������  ����ͼ
	public MatrixGraph(char[] ve,char[][]edges){
		
		
		//��ͼ�Ķ��㸳ֵ
		vex=new char[ve.length];
		for(int i=0;i<ve.length;i++){
			this.vex[i]=ve[i];
		}
		
		//�Ծ���ֵ ���󳤿������  ���Ǳ�����ʱ������ı�  
		matrix=new int[vex.length][vex.length];
		for(int i=0;i<edges.length;i++){
			int p1=getPostion(edges[i][0]);
			int p2=getPostion(edges[i][1]);
			this.matrix[p1][p2]=1;//��������ͼ �ǶԳƵ�
			this.matrix[p2][p1]=1;//����ͼ���Ǹ�ֵ��ʱ��һ��
		}
	} 
	
	//���ع�����    ���������ͼ
	public MatrixGraph(char[][]edges,char[] ve){
		
		
		//��ͼ�Ķ��㸳ֵ
		vex=new char[ve.length];
		for(int i=0;i<ve.length;i++){
			this.vex[i]=ve[i];
		}
		
		//�Ծ���ֵ ���󳤿������  ���Ǳ�����ʱ������ı�  
		matrix=new int[vex.length][vex.length];
		for(int i=0;i<edges.length;i++){
			int p1=getPostion(edges[i][0]);
			int p2=getPostion(edges[i][1]);
			this.matrix[p1][p2]=1;//��������ͼ �ǶԳƵ�
			
			//��Ȩֵ  �����ո���ֵ=edges[i][2]   ��ֵ���δ�������������
			
			
		}
		
	}
	
public void  MatrixGraph3(char[][]edges,char[] ve){
		
		
		//��ͼ�Ķ��㸳ֵ
		vex=new char[ve.length];
		for(int i=0;i<ve.length;i++){
			this.vex[i]=ve[i];
		}
		
		//�Ծ���ֵ ���󳤿������  ���Ǳ�����ʱ������ı�  
		matrix=new int[vex.length][vex.length];
		for(int i=0;i<edges.length;i++){
			int p1=getPostion(edges[i][0]);
			int p2=getPostion(edges[i][1]);
			int weigth=edges[i][2];
			
			//��Ȩֵ  �����ո���ֵ=edges[i][2]   ��ֵ���δ�������������
			this.matrix[p1][p2]=weigth-48;
			
		}
		
	}
	
	
	
	//���ȶ���һ������ �Ӷ����ܹ��ҵ�������  ����ߵı���
	
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
    
    System.out.println("����ͼ���ڽӾ���");
    graph.printGraph();
    

	System.out.println("");
	
	     char[] ch1={'A','B','C','D'};
	    
	    char[][] edge1={{'A','B'},{'A','C'},{'A','D'},{'B','D'},{'D','B'},{'D','C'}};
			
	    MatrixGraph graph1=new MatrixGraph(edge1,ch1);	
	    
	
	System.out.println("����ͼ���ڽӾ���");
	graph1.printGraph();
	
	
	System.out.println("");
	
    char[] ch2={'A','B','C','D'};
   
   char[][] edge2={{'A','B','1'},{'A','C','2'},{'A','D','3'},{'B','D','4'},{'D','C','5'}};
		
   MatrixGraph graph2=new MatrixGraph();	
   graph2.MatrixGraph3(edge2, ch2);

   System.out.println("��Ȩֵ����ͼ���ڽӾ���");
   graph2.printGraph();

   char aa='0';
   System.out.println("�ַ�0�� unicode��  ��48");
   System.out.println((int)aa);
	}

}
