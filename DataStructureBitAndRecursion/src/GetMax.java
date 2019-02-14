


public class GetMax {

	
	/*
	 *  使用位运算找出 两个数里面比较大的那个数
	 * 
	 *  一定是32位整数
	 * 
	 *  第一种方法的到 a-b的符号
	 *  
	 *    (n>>31)&1 返回a-b的符号 如果是正数  或者0 返回1  负数返回0
	 *    n^1什么意思-->如果是1就是0  如果是0就是1
	 *    第一种方法有局限性:如果 a-b溢出  结果不准确
	 *  
	 *    
	 *   第二次方法可以解决溢问题 ^  相同取0  不同取1
	 *             
	 *             
	 * 
	 * */
	
	
	//0--1  1--0相对的
	public int filp(int n){
		return n^1;
	}
	
	
	
	//判断 相减的符号
	
	public int sign(int n){
		
		return filp((n>>31)&1);
	}
	public int getMax1(int a,int b){
		
		
		
		
		int c=a-b;// 10  3  c=7
		int sga=sign(c);//0
		int sgb=filp(sga);//1
		return a*sga+b*sgb;
	}
		
	//有点类似于触发器	
	public int getMax(int a,int b){
		
		int c=a-b;
		int sa=sign(a);
		int sb=sign(b);
		int sc=sign(c);
		//判断符号是否相同
		
		int dissame=sa^sb;//不同为 1
		
		int same=filp(dissame);
		
		int returna=dissame*sa+same*sc;
		
		int returnb=filp(returna);
		/*
		 *  dis=1  same=0//不相同不去判断差值
		 *  
		 *      sa=1 sb=0
		 *      sa=0 sb=1     
		 *      
		 *      
		 *  dis=0 same=1 //如果相同再去判断差值
		 *  
		 *      sc=1
		 *      sc=0
		 *      
		 *      
		 *      
		 *      returna=dis*sa+same*sc
		 *     
		 *      returnb=filp(a)
		 *      
		 *      
		 *      最后结果 a*return+b*return;
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
		 * 
		 * 
		 * */
		return a*returna+b*returnb;
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GetMax gg=new GetMax();
		
	System.out.println("比较13  3大小:大的是"+gg.getMax1(12, 3));
	System.out.println("比较-13 -17大小:大的是"+gg.getMax1(-13, -17));	
      System.out.println(Integer.MAX_VALUE);
      System.out.println(Integer.MIN_VALUE);
      
     
      System.out.println("-----------------");
      System.out.println(Integer.toBinaryString(-5));
      System.out.println(Integer.toBinaryString(-5^1));
      System.out.println(5^1);

      System.out.println("-----------------");
      System.out.println(1^1);
      System.out.println(0^1);
      System.out.println("-----------------");
      System.out.println((5>>31)&1); //整数0 
      System.out.println((-5>>31)&1);//负数1
      System.out.println("比较13  3大小:大的是"+gg.getMax(12, 3));
  	System.out.println("比较-13 -17大小:大的是"+gg.getMax(-13, -17));	
      
	}

}
