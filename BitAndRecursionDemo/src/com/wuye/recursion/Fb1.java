package com.wuye.recursion;

public class Fb1 {
	
	/* 
	 * 
	 *  쳲���������:
	 *  
	 *  1 1 2 3 5 8 13 21 
	 *  
	 *  �����ݹ�:O(2^n)
	 * 
	 * 
	 *  ˳�����:O(n)
	 * 
	 * 
	 *  ʹ�þ���˷�����ʽ���Խ���O(logN)
	 * 
	 *  ע��:F(n)=F(n-1)+F(n-2)һ�����׵�������
	 *  
	 *      һ������ʹ�þ���˷����б�ʾ
	 *                                    |a  b|(n-(n-1))
	 *     (F(n),F(n-1))=(F(n-1),F(n-2))* |    | 
	 *                                    |c  d|
	 * 
	 *     ����������������
	 *                                    |a  b|(n-2)
	 *     (F(n),F(n-1))=(F(2),F(1))*     |    | 
	 *                                    |c  d|
	 * 
	 *     abcd������ǰ�����������:1110
	 * 
	 * 
	 * 
	 * */
	
	//�����ݹ�
	public int ff1(int n){
		if(n<0){
			return 0;
		}
		if(n==1|n==2){
			
			return 1;
		}
		
		return ff1(n-1)+ff1(n-2);
		
	}
	
	//˳�����
	
	public int ff2(int n){
		
		if(n<0){
			return 0;
		}
		if(n==1|n==2){
			
			return 1;
		}
		
		int res=1;//ָ��� n-1
		int pre=1;//ָ���n-2
		int tem=0;
		
		
		for(int i=3;i<=n;i++){
			tem=res;
			
			res=res+pre;//��ʱ��resָ�����ֵ
			
			pre=tem;//tem��n-1����ֵ ���ݸ� pre
			
		}
		return res;

	}
	
	//ʹ�þ���˷� ʹ��ʱ�临�ӶȽ�����O(logN)
	
	//Ȼ����һ�������n�η�  ��Ϊ��һ�������n�η� �����������
	public int[][] maxPower(int [][]c,int p){
		//���ȶ���һ����λ����
		
		int[][]res=new int[c.length][c[0].length];
		
		for(int i=0;i<c.length;i++){
			res[i][i]=1;
				}
		int [][]tem=c;
		for(;p!=0;p>>=1){
			if((p&1)!=0){
				res=matrix(res,tem);
				
			}
			tem=matrix(tem,tem);
		}
		return res;
		
	}
	
	
	
	
	//���ȶ��������������    2*4    4*5
	public  int[][] matrix(int [][]a1,int[][]b1){
		
		int [][] res=new int[a1.length][b1[0].length];
		
		
		for(int i=0;i<a1.length;i++){
			for(int j=0;j<b1[0].length;j++){
				
				for(int k=0;k<b1.length;k++){
					
					res[i][j]+=a1[i][k]*b1[k][j];
				}
				
				
			}
			
			
		}
		return res;
		
	}
	
	public  int  ff3(int n){
		
		if(n<0){
			return 0;
		}
		if(n==1|n==2){
			
			return 1;
		}
		
		   //ͨ�������������
		int res[][] ={{1,1},{1,0}};
		
		int tem[][]=maxPower(res,n-2);
		
		return tem[0][0]+tem[1][0];
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          for(int i=1;i<=10;i++){
        	 System.out.print(new Fb1().ff1(i)+".");
        	  
          }
          System.out.println();
          for(int i=1;i<=10;i++){
         	 System.out.print(new Fb1().ff2(i)+".");
         	  
           }
          System.out.println();
          
          int [][]a={{1,1},{2,2},{3,3}};//3*2
          
          System.out.println("���������:"+a.length+"����ĵ�����:"+a[0].length);
	
	      int p=100;//110 
	      System.out.println(p>>=1); //���ұ��ƶ�һλ
	     
	      //ֻ�е�p=1ʱ�� 1&1=1
	      System.out.println(1&1);
	      System.out.println(0&0);
	      System.out.println(0&1);
	      System.out.println(1&0);
	      
	      
	      //һ������ĳ˷�
	      
	      for(int q=6;q!=0;q>>=1){
	    	  if((q&1)!=0){
	    		  System.out.println("�͵�λ�������:"+q);
	    	  }
	    	  System.out.println("���Լ����:"+q);
	    	  
	      }
	      
	      
	      System.out.println("������ʹ�þ���ķ�������:-------------");
          for(int i=1;i<=10;i++){
         	 System.out.print(new Fb1().ff3(i)+".");
         	  
           }
          System.out.println();
	      
	}

}
