package com.wuye.array;


/*
 * **从一个二位数组里面找到一个数  左上到右下是逐渐变大的
 *   判断一个数是否在数组里面
 *   本题的思路考察的是从右上角开始查找
 *   
 *   1 通常思维 从左面开始看  如果>这里面没有了
 *                      <那么除了这个数之外的不规则矩形范围内进行查找
 *                      很不规则
 *                      
 *   2 如果从右上角进行查找 如果>去除一列
 *                   如果<去除一行
 *                      =正好                   
 *    
 *   3 变量的命名对你产生迷惑,注意命名规范                   
 * 
 *  1 2 8 9
 *  2 4 9 10
 *  3 5 12 11 
 *  6 7 14 17
 * 
 * 
 * 
 * */
public class FindFromOrderArray {

	public static boolean findFromOrderArray(int[][] a,int row,int colum,int num ){

		boolean flag=false;

		//需要考虑的数情况

		if(a!=null&&row>0&&colum>0){

			int r=0;
			int co=colum-1;

			while(r<row&&co>=0){
				//r一直增加 co一直减小	
				if(a[r][co]==num){
					flag=true;
					break;//跳出循环
				}
				else if(a[r][co]>num)

					--co;

				else
					++r;


		}
	}
	
	
	
	return flag;
	

}	

public static void main(String []args){
	
	int [][]a={{1,2,8,9},{2,4,9,10},{3,5,12,11},{6,7,14,17}};

	System.out.println(FindFromOrderArray.findFromOrderArray(a, 4, 4, 7));
	
}
	
	
}
