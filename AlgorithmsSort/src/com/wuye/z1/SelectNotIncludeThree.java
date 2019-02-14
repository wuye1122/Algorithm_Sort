package com.wuye.z1;
//从0~999999里面找出不含3的个数
public class SelectNotIncludeThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int count=0;
       for(int i=0;i<=999999;i++){
    	   String s=i+"";
    	   if(s.indexOf('3')==-1){//不含3
    		   count++;
    	   }
       }
       System.out.println("在0~999999里面不含3的个数"+count);
       System.out.println(Integer.valueOf("888888", 9));
       //将其他进制转换成10进制
	}

}
/*第二种方法:一位数：8
 *        二位数：8*9
 *        三位数：8*9*9
 *        ………………
 *        六位数：8*9*9*9*9*9
 */
/*第三种方法:每一位不含三的概率 0.9总共6位  
 *   0.9^6*1000000 =531441
 * 
 * 
 * */
/*第四种:深刻的改编2 3 方法
 * 少了一个3   
 * 和少了9是一样的  999999~~~888888变成了6位九进制
 * 将其变成十进制==531441
 * 
 * 
 * */













