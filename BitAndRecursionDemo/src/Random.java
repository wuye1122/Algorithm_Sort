
public class Random {
   /* 
    *   关于随机数产生的几种情况及扩展
    * 
    *   1 随机数[1,5]  去实现[1,7]
    * 
    *   2 随机数[0(p).1(1-p)]  实现等概率产生[1,6]
    * 
    *   3 随机数[1,m]  实现随机数[1,n]
    * 
    * 
    * 
    * */
	
	
	//方法一:
	
	public int rand105(){
		return  (int)(Math.random()*5+1);
	}
	
	// rand105()-1          0 1 2 3 4
	// (rand105()-1)*5      0 5 10 15 20
	// 如果把上述条件相加 上述两次是两次独立的调用。---插空
	// 上述相加出现的而结果0 1 2 3 4 5 6 …………20 21 22 23 24
	
	//不断进行循环将大于20重新进行循环。筛过程 0-20
	//20%7取余数 (0 6)
	public int rand107(){
		
		
		int mun=0;
		do{
			mun=(rand105()-1)+((rand105()-1)*5);//使用插空
		}while(mun>20);//筛出0-20
		
		return mun%7+1;//0 20 %7  总共21个数 %7之后出现三组 0-6都是等概率的
		
		 
	}
	
	//方法二:
	
	public int rand01p(){
		
		double p=0.83;
		return Math.random()<p?0:1;
	}
	
	/* 1 如何做到等概率产生 0 1？
	 *  
	 *  出现01或者 10都出现输出其中后出现的那个 实现等概率 (1-p)p
	 *  
	 *  
	 *  2 如何做到0-6 15/6    0-7 通常20/7
	 *   
	 *    2*6=12 0-11      3*7=21 0-20 
	 *      
	 *  
	 *   0 1做到了 
	 *  
	 *    0-3*4+3
	 *  
	 * 
	 * 
	 * 
	 * */
	public  int rand01(){
		
		int num=0;
		do{ 
			num=rand01p();//1            1
		}while(num==rand01p());//0输出1    1继续循环直到出现0
		return num;
	}
	
	public int rand03(){
		return rand01()*2+rand01();//0-2 +0-1插空法  
	}
	
	public int rand106(){
		
		int num=0;
		do{
			num=rand03()*4+rand03();
			
		}while(num>11);
		return num%6+1;
	}
	
	//方法三:
	
	public int randToM(int m){
		
		return  (int)(Math.random()*m+1);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random rr=new Random();
		
		System.out.println(Math.random());//[0,1)
		 
		// 第一种情况 int(强转之后最终的值一定是0)
		// 第二种情况 int(强转之后将小数点舍去  1-5)
		System.out.println((int)Math.random()*5);//0.99*5永远到不了5
		System.out.println((int)(Math.random()*5+1));//[1,5.)
		
		System.out.println(rr.rand107());
		System.out.println(rr.rand107());
		System.out.println(rr.rand107());
		System.out.println(rr.rand107());
		
		for(int i=0;i<=20;i++){
			System.out.print(i%7+"-");
			
		}
		//1-M的随机产生
		//(int)(Math.random()*M+1)
		
		
		//产生0 1的概率不同  Math.random()<p?0:1
		System.out.println("----"+rr.rand01p());
		System.out.println("----"+rr.rand01());
		for(int i=0;i<=11;i++){
			System.out.print(i%6+"-");
		      	
		}
		System.out.println();
		System.out.println(rr.rand106());
	}

}
