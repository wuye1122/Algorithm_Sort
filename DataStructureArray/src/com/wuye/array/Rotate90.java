package com.wuye.array;

public class Rotate90 {

	/*
	 * 
	 *  将一个正方形 顺时针旋转90度
	 *  
	 *   1 3     ---->    4 1
	 *   4 5              5 3   
	 *   
	 *   
	 *   难点 坐标要看好否则出现错误
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	
	public void rotale(int [][] a){
		int tr=0;
		int tc=0;
		int dr=a.length-1;
		int dc=a[0].length-1;
		while(tr<dr){
			rr(a, tr++, tc++,dr--,dc--);
		}
		
		
	}
	
	//外圈进行旋转
	
	public void rr(int [][]m,int tr,int tc,int dr,int dc){
		int time=dc-tc;
		int tem=0;
		
		for(int i=0;i<time;i++){
			
			tem=m[tr][tc+i];
			m[tr][tc+i]=m[dr-i][tc];
			m[dr-i][tc]=m[dr][dc-i];
			m[dr][dc-i]=m[tr+i][dc];
			m[tr+i][dc]=tem;
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
		Rotate90 rr=new Rotate90();
		for(int k=0;k<4;k++){
			for(int j=0;j<a[k].length;j++){
				System.out.print(a[k][j]+" ");
			}
		System.out.println();
	     }
		rr.rotale(a);
		System.out.println("-------------------------------");
		for(int k=0;k<4;k++){
			for(int j=0;j<a[k].length;j++){
				System.out.print(a[k][j]+" ");
			}
		System.out.println();
	     }
	}

}
