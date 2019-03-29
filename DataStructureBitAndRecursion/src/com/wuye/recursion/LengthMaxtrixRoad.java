package com.wuye.recursion;

public class LengthMaxtrixRoad {
  /*
   * recursion ������С��·��֮��---***�ռ�ѹ���� ����Ҫ
   * 
   * 
   * 1 ����һ������ dp[i][j]�������˼  ���ߵ�i j���õ���̵Ķ�����
   * 
   *  dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+m[i][j]
   * 
   *  ʱ�临�Ӷ�O(m*n)  �ռ临�Ӷ�O(m*n)��Ϊdp[m][n]
   * 
   * 
   * 2 ʹ�ÿռ�ѹ���� �ﵽ ʱ�临�Ӷ�O(m*n)   �ռ临�Ӷ�O(min{m,n})
   * 
   * */
	
	//ʹ��һ����ά����
	public int minPath1(int a[][]){
		System.out.println("���ԭ������");
		for(int b[] :a){
		  for(int c:b){
			  System.out.print(c+".");
			  
		  }
		  System.out.println();
			
		}
		
		
		if(a==null||a.length==0||a[0]==null||a[0].length==0){
			return 0;
		}
		int res[][]=new int[a.length][a[0].length];
		
		res[0][0]=a[0][0];
		
		//�����һ��
		for(int i=1;i<res.length;i++){
			res[i][0]=res[i-1][0]+a[i][0];
			
		}
		//�����һ��
		for(int i=1;i<res[0].length;i++){
			res[0][i]=res[0][i-1]+a[0][1];	
		}
		//��������λ��
		for(int i=1;i<res.length;i++){
			for(int j=1;j<a[0].length;j++){
				res[i][j]=Math.min(res[i-1][j],res[i][j-1])+a[i][j];
				
			}
			
		}
		
		
		System.out.println("����������");
		
		for(int b[] :res){
			  for(int c:b){
				  System.out.print(c+".");
				  
			  }
			  System.out.println();
				
			}
			
		
		return res[res.length-1][res[0].length-1];
		
		
		
		
		
	}
	
	public int minPath2(int a[][]){
		if(a==null||a.length==0||a[0]==null||a[0].length==0){
			return 0;
		}
		
		System.out.println("���ԭ������");
		for(int b[] :a){
		  for(int c:b){
			  System.out.print(c+".");
			  
		  }
		  System.out.println();
			
		}
		
		int more=Math.max(a.length, a[0].length);//more����ϴ���Ǹ�
	 	int less=Math.min(a.length, a[0].length);//less�����С���Ǹ�
	    
	 	
	 	//����һ��boolean����  �ж���ô��
	 	
	 	boolean flag=more==a.length;
	 	
	 	
	 	int res[]=new int[less];
	 	
	 	//����ȷ����һ�Ż�����
	 	res[0]=a[0][0];
	 	for(int i=1;i<less;i++){
	 		
	 		res[i]=res[i-1]+(flag?a[0][i]:a[i][0]);
	 		
	 	}
	 	
	 	for(int i=1;i<more;i++){
	 		//ÿһ���µ�res[0]����仯
	 		res[0]=res[0]+(flag?a[i][0]:a[0][i]);
	 		
	 		for(int j=1;j<less;j++){
	 			
	 			res[j]=Math.min(res[j],res[j-1])+(flag?a[i][j]:a[j][i]);
	 		}
	 		
	 		
	 	}
	 	
	 	System.out.println("ѹ����������������:");
	 	for(int cc:res){
	 		System.out.print(cc+"--");
	
	 	}
		return res[less-1];
	 	
	 	
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LengthMaxtrixRoad ll=new LengthMaxtrixRoad();
		
		int a[][]={{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
		
		System.out.println(ll.minPath1(a));
		System.out.println("����ʹ�ÿռ�ѹ����");
		System.out.println(ll.minPath2(a));
		
	}

}
