package com.wuye.array;

public class PrintZhi {

	/*
	 *  例如打印将一个二维数组
	 *  
	 *  以之字的形式打印出来
	 *  
	 *  1  2  3  4              横坐标 _________
	 *  5  6  7  8                  | 
	 *  9 10  11 12                 | 
	 *                              |
	 * 1 2 5 9 6 3 4 7 10 11 12     v    
	 * 
	 *                 纵坐标
	 *                   |
	 *                   |
	 *                   |
	 *                    —————————>
	 *                    
	 *      横坐标和纵坐标每移动一次 形成一条斜线。 按着斜线打印     
	 *      打印的方法由boolean决定 一次正 一次反          
	 */  
	
	
	public void printZhi(int [][] a){
		
		int tr=0;
		int tc=0;
		int dr=0;
		int dc=0;
		int endr=a.length-1;
		int endc=a[0].length-1;
		boolean flag=false;//代表 从上往下
		
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
			//如true 则从 右下往左下
			while(tr!=dr+1){
				System.out.println(m[tr++][tc--]+"-");
			}
		}else{
			//如false  则从左下往作右上
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
