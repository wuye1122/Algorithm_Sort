package com.wuye.array;

public class PrintOrder {

	
	  /*
	   * 
	   *  1  2  3  4
	   * 
	   *  5  6  7  8
	   *  
	   *  9  10 11 12
	   *  
	   *  13 14 15  16
	   * 
	   *  ����˳ʱ��Ȧ��ӡ
	   * 
	   * ��ά����:a[n][m]
	   *        n:��
	   *        m:��
	   * 
	   * 
	   * 
	   * ȷ���� ��ѭ���� ��ʼ�յ�ֵ
	   * 
	   * */
	public void print(int [][]a){
		
		int tr=0;
		int tc=0;
		int dr=a.length-1;//����
		
		int dc=a[0].length-1;
		
		
		
		while(tc<=dc&&tr<=dr){
			
			pri(a,tr++,tc++,dr--,dc--);
			
		}
		
		
		
		
	}
	
	
	
	//��ӡ���������Ȧ
	
	public void pri(int[][]a,int tr,int tc,int dr,int dc){
		
		
		//������ֻʣ��һ�е�ʱ�� 
		
		if(tr==dr){
			for(int i=tc;i<=dc;i++){
				System.out.print(a[tr][i]+"-");
				
			}
			
		}
		
		else if(tc==dc){
			for(int i=tr;i<=dr;i++){
				System.out.print(a[i][tc]+"-");
				
			}
			
		}else{
			
			int curc=tc;
			int curr=tr;
			while(curc!=dc){
				
			System.out.print(a[tr][curc]+"-");	
				curc++;
	        }
			
			while(curr!=dr){
				System.out.print(a[curr][dc]+"-");
				curr++;
				
			}while(curc!=tc){
				
			System.out.print(a[dr][curc]+"-");	
				curc--;
	        }
			
			while(curr!=tr){
				System.out.print(a[curr][tc]+"-");
				curr--;
				
			}
			
			
		}
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int [][]a=new int[4][4];
		
		for(int i=0;i<4;i++){
			for(int j=0;j<a[i].length;j++){
				a[i][j]=(i+1)*(j+1);
			}
		}	
			for(int k=0;k<4;k++){
				for(int j=0;j<a[k].length;j++){
					System.out.print(a[k][j]);
				}
			System.out.println();
		     }
		System.out.println(a.length);
		System.out.println(a[0].length);
		
		PrintOrder pp=new PrintOrder();
		pp.print(a);
	}
}
