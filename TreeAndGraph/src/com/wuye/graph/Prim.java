package com.wuye.graph;

public class Prim {
/*  
 *  prim�㷨  �ڽӾ��� ���ڽӱ�
 *  
 *  ������С������:ͼ��N������ȫ������   ����ʹ�õı���N-1
 * 
 *            ���ѵĴ��۱Ƚ�С 
 * 
 * 
 *  kruskal�㷨 �ڽӾ��� �� �ڽӱ�
 *  
 *  
 * 
 *   
 * */
	
	
	
	//�����ʾPrim�㷨����ͼ�ľ����ʾ��
	
	
	private char[] tops;       // ���㼯��
	private int[][] mMatrix;    // �ڽӾ���
	
	private static final int INF = Integer.MAX_VALUE;   // ���ֵ
	
	
	
	Prim(char[] vexs,int matrix[][]){
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

     public void prim(int start){//���忪ʼλ��
    	 
    	 
     int index=0;//����
     
     char top[]=new char[this.tops.length];//��������С�������ڵ������
     
     int weight[]=new int[this.tops.length];//ע���¼Ȩֵ 
     
     
     
     top[index++]=this.tops[start];
    	 
     //��weight���и�ֵ  ��һ��weight[i]=0ʱ��  ˵��i�Լ���������
     
     for(int i=0;i<weight.length;i++){
    	 weight[i]=this.mMatrix[start][i];//��ʱ��ʾ�� A ��������ľ���
    	 
     }
     
       weight[start]=0;//˵��start����Ҫ����
       
       
       //������бȽ�
       for(int i=0;i<this.tops.length;i++){
    	   if(start==i){
    		   continue;
    	   }
    	   int j=0;
    	   int k=0;
    	   int min=INF;
    	   
    	   while(j<this.tops.length){
    		   
    		   if(weight[j]!=0&&weight[j]<min){
    			   min=weight[j];//ѡ����һ����С��
    			   k=j;//����С�Ľڵ������ȡ����
    		   }
    		   j++;//j�����һ��
    	   }
    	   
    	   top[index++]=tops[k];//���µ���������������
    	   
    	   weight[k]=0;//˵��k����Ҫ����
    	   
    	   //�����k�Ŀ�ʼ����������С��
    	   
    	   /*
    	    *   top�����Ǵ�1  ��ʼ�� ������ڶ���Ԫ�ص�ʱ�� 1  2 �Ҷ�Ϊ0
    	    *   
    	    *   �������������ʱ����Ǵ�����3��ʼ������  ����  ��2������ĸ��matrix����������Ʋ�����С��
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
       
       
       System.out.println("��ӡ��С������������");
       System.out.println("");
       for(char t:top){
    	   System.out.print(t+" ");
       }
       System.out.println("");
    /*   
     *  ��һ����������  ���в�����ʹ�����ַ���
     *  
       System.out.println(top[0]-65);
        
       System.out.println(top[0]+"-"+top[1]+"Ȩֵ:"+this.mMatrix[top[0]-65][top[1]-65]);
       System.out.println(top[1]+"-"+top[2]+"Ȩֵ:"+this.mMatrix[top[1]-65][top[2]-65]);
       System.out.println(top[2]+"-"+top[3]+"Ȩֵ:"+this.mMatrix[top[2]-65][top[3]-65]);
       System.out.println(top[3]+"-"+top[4]+"Ȩֵ:"+this.mMatrix[top[3]-65][top[4]-65]);
       System.out.println(top[4]+"-"+top[5]+"Ȩֵ:"+this.mMatrix[top[4]-65][top[5]-65]);
       System.out.println(top[5]+"-"+top[6]+"Ȩֵ:"+this.mMatrix[top[5]-65][top[6]-65]);
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
    	   
    	   System.out.println("��Сֵ"+mina);
    	   sum+=mina;
       }
       System.out.println("��СȨֵ:"+sum);
     
    	 
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
		System.out.println("Prim�㷨 �ó�����С����������:");
		pp.prim(0);
	}

}
