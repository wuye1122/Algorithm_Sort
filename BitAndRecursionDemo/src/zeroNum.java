
public class zeroNum {
  
	/*
	 *   阶乘末尾为0的数量。
	 *    
	 *   1 求解一个数里面有多少个因子5   因为2的数量比5多。所以查出5就行
	 *   
	 *   
	 *   2 理解求阶乘里面含有0的个数。
	 *   
	 *     1  2  3  4  5  -->第五个含有 1个五
	 *     5 10 15 20 25  -->第五个含有2个5
	 *     …………
	 *     每五个含有i个因子的五  第五个数含有i+1个五
	 *     
	 *     最后z=n/5+n/5^1+n/5^2……n/5^i
	 *   
	 *   进阶:使用二进制表示阶乘   返回最低位1在哪个位置。
	 *   
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
/*	8 一个数N!末尾有几个0
	  00
	  ——
	  \     [N /5^i]  不大于他的最大整数
	  /       
	  ——
	  i=0  
	     
*/
	//方法一:找出其因子里面有几个5  NlogN
	
	public int zeroNum1(int num){
		if(num<0){
			return 0;
		}
		int res=0;
		int cur=0;
		
		for(int i=5;i<=num;i=i+5){
			cur=i;
			while(cur%5==0){
				res++;
				cur/=5;//比如 25  判断完25  还有判断5
				       //比如 500 判断 500  100  25  5  
				}
			
		}
		return res;
		
	}

	//方法二:找出其因子里面有几个5  logN
	public int zeroNum2(int num){
		
		if(num<0){
			return 0;
		}
		
		int res=0;
		
		while(num!=0){
			res+=num/5;
			num/=5;
		}
		return res;
		}
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		zeroNum zz=new zeroNum();
		System.out.println(zz.zeroNum1(10));
		System.out.println(zz.zeroNum2(10));
		
		
		
		
	}

}
