package com.wuye.recursion;

public class Fb2 {
 /*
  * 
  *  ��һ��̨�� һ�ο��Կ����� ���Կ�һ�� �ж����ֲ�ͬ���߷���
  *  
  *  1  2  3  4 ........쳲���������
  *  
  *  1  2  3  5
  * 
  *  ����˼�� ���������N�Ļ�  �����һ����ʱ��  ����Կ����� n-2 Ҳ���Կ�һ��
  * 
  * 
  * 
  * 
  * 
  * 
  * 
  * 
  * 
  * 
  * */
	//�����ݹ�:
	public int  ff1(int n){
		if(n<1){
			return 0;
		}
		if(n==1||n==2){
			return n;
		}
		
		return ff1(n-1)+ff1(n-2);
	}
	
	//˳�����
	
	public int ff2(int n){
		if(n<1){
			return 0;
		}
		if(n==1||n==2){
			return n;
		}
		int res=2;
		int pre=1;
		int tem=0;
		
		for(int i=3;i<=n;i++){
			tem=res;
			res=res+pre;
			pre=tem;
		}
		return res;
	}
	
	//���پ���˷��Ķ�̬�滮
	
	public int ff3(int n){
		if(n<1){
			return 0;
		}
		if(n==1||n==2){
			return n;
		}
		            //n n-1   2 1
		int pp[][]={ {1,1},{1,0} };
		int res[][]=maxPower(pp,n-2);
		return 2*res[0][0]+res[1][0];
		
	}
	
	public int[][] maxPower(int [][]c,int p){
		//���ȶ���һ����λ����
		
		int[][]res=new int[c.length][c[0].length];
		
		for(int i=0;i<c.length;i++){
			res[i][i]=1;
				}
		int [][]tem=c;
		for(;p!=0;p>>=1){
			if((p&1)!=0){
				res=maxtrx(res,tem);
				
			}
			tem=maxtrx(tem,tem);
		}
		return res;
		
	}
	

	//���ȶ��������������
	
	public int[][] maxtrx(int [][]a,int[][]b){
		int [][]res=new int[a.length][b[0].length];
		
		for(int i=0;i<a.length;i++){
			for(int j=0;j<b[0].length;j++){
				for(int k=0;k<b.length;k++){
				//	res[i][j]+=res[i][k]*res[k][j];	
					res[i][j]+=a[i][k]*b[k][j];
				}				
			}
		}
		return res;
	}

	
	//�������   n,n-1 =(2,1) *{ {1,1},{1,0} }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 for(int i=1;i<=10;i++){
        	 System.out.print(new Fb2().ff1(i)+".");
        	  
          }
          System.out.println();
          for(int i=1;i<=10;i++){
         	 System.out.print(new Fb2().ff2(i)+".");
         	  
           }
          System.out.println();
          for(int i=1;i<=10;i++){
          	 System.out.print(new Fb2().ff3(i)+".");
          	  
            }
           System.out.println();
	}

}
