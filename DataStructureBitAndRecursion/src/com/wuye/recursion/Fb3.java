package com.wuye.recursion;

public class Fb3 {
/*
 *  һֻ�����ţ ���һֻСţ   һֻСţÿ�ξ�����������
 *  
 *  1 2 3 4 6 9 13........
 * 
 * 
 * c(n)=c(n-1)+c(n-3) (n>=4)
 * 
 * һ�����׵��ƹ�ʽ��
 * 
 * ����ʹ�þ���
 * 
 * {c(n),c(n-1),c(n-2)}={c(n-1),c(n-2),c(n-3)}*���׾����1�η�
 * 
 *                     ={c(3),c(2),c(1)}*���׾����n-3
 * 
 *                     ={3,2,1}*���׾����n-3
 * 
 * 
 * */
	
	
	//�����ݹ�
	public  int  ff1(int n){
		if(n<1){
			return 0;
		}
		if(n==1||n==2||n==3){
			return n;
		}
		return ff1(n-1)+ff1(n-3);
		
	}
	
	
	//˳����㷨
	
	public  int  ff2(int n){
		if(n<1){
			return 0;
		}
		if(n==1||n==2||n==3){
			return n;
		}
		int prepre=1;
		int pre=2;
		int res=3;
		
		int temp=0;
		int tempp=0;	
		
		for(int i=4;i<=n;i++){
			temp=res;
			tempp=pre;
			res=res+prepre;
			pre=temp;
			prepre=tempp;
		}
		return res;
		
	}
	
	
	public int  ff3(int n){
		if(n<1){
			return 0;
		}
		if(n==1||n==2||n==3){
			return n;
		}//3 2 1
		int base[][]={{1,1,0},{0,0,1},{1,0,0}};
		
		int power[][]=matrxPowe(base,n-3);
		
		return 3*power[0][0]+2*power[1][0]+1*power[2][0];
	}
	
	private int[][] matrxPowe(int[][] base, int p) {
		// TODO Auto-generated method stub
		
		//���ȶ���һ����λ1
		
		int[][] res=new int[base.length][base[0].length];
		
		for(int i=0;i<base.length;i++){
			res[i][i]=1;	
		}
		
		
		int [][] c=base;
		
		
		for(;p!=0;p>>=1){
			if((p&1)!=0){
				
				res=matrx(res,c);
			}
			//�����
			c=matrx(c,c);
		}
		return res;

		
	}


	//���������������
	private int[][] matrx(int[][] res, int[][] c) {
		// TODO Auto-generated method stub
	
		int pp[][]=new int[res.length][c[0].length];
		
		
		for(int i=0;i<res.length;i++){
			for(int j=0;j<c[0].length;j++){
				for(int k=0;k<c.length;k++){
                     
					pp[i][j]+=res[i][k]*c[k][j];
				
			}
			
			
		}
		
		
	}
		return pp;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=1;i<=10;i++){
			System.out.print(new Fb3().ff1(i)+".");
			
		}
		System.out.println("");
		for(int i=1;i<=10;i++){
			System.out.print(new Fb3().ff2(i)+".");
			
		}
		System.out.println("");
		for(int i=1;i<=10;i++){
			System.out.print(new Fb3().ff3(i)+".");
			
		}
		
	}

}
