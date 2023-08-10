package com.wuye.array;

public class PrintZhi {

	/*
	 *  �����ӡ��һ����ά����
	 *  
	 *  ��֮�ֵ���ʽ��ӡ����
	 *  
	 *  1  2  3  4              ������ _________
	 *  5  6  7  8                  | 
	 *  9 10  11 12                 | 
	 *                              |
	 * 1 2 5 9 6 3 4 7 10 11 12     v    
	 * 
	 *                 ������
	 *                   |
	 *                   |
	 *                   |
	 *                    ������������������>
	 *                    
	 *      �������������ÿ�ƶ�һ�� �γ�һ��б�ߡ� ����б�ߴ�ӡ     
	 *      ��ӡ�ķ�����boolean���� һ���� һ�η�          
	 */  
	
	
	public void printZhi(int [][] a){
		
		int tr=0;
		int tc=0;
		int dr=0;
		int dc=0;
		int endr=a.length-1;
		int endc=a[0].length-1;
		boolean flag=false;//���� ��������
		
		while(tr!=endr+1){
			prin(a,tr,tc,dr,dc,flag);
			tr=tc==endc?tr+1:tr;
			tc=tc==endc?tc:tc+1;
			
			dc=dr==endr?dc+1:dc;
			dr=dr==endr?dr:dr+1;
			flag=!flag;
		}
		
		
		
		
	}
	
	public void prin(int[][]m,int tr,int tc,int dr,int dc,boolean ff){
		
		if(ff){
			//��true ��� ����������
			while(tr!=dr+1){
				System.out.println(m[tr++][tc--]+"-");
			}
		}else{
			//��false  ���������������
			while(dr!=tr-1){
				System.out.println(m[dr--][dc++]+"-");
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int [][]a=new int[4][4];
			
			for(int i=0;i<4;i++){
				for(int j=0;j<a[i].length;j++){
					a[i][j]=(i)*(j+1);
				}
			}	
			
			for(int k=0;k<4;k++){
				for(int j=0;j<a[k].length;j++){
					System.out.print(a[k][j]+" ");
				}
			System.out.println();
		     }
			
			System.out.println("-------------------------------");
			PrintZhi pp=new PrintZhi();
			pp.printZhi(a);
	}

}
