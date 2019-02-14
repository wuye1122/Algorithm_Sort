
public class AllFold {

	/*          关于折纸问题
	 * 
	 * 
	 * 折一次:                下
	 * 
	 * 折两次:       上                                                      下                
	 * 
	 * 折三次: 上                              下               上                                         下
	 * 
	 * 
	 * 综上所诉: 最开始是下   然后 每一个折痕的 前后一个是  上下
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
	
	
	public void printAllFold(int N){
		
		printA(1, N ,true);
		
		
		
		
	}
	
	public  void printA(int i,int N ,boolean down){
		
		if(i>N){
			return;//不能超过最大次数
		}
		
		printA(i+1,N,true);//下的前面一定是上
		System.out.print(down?"down"+"-":"up"+"-");
		printA(i+1,N,false);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllFold aa=new AllFold();
		aa.printAllFold(1);
		System.out.println("----------------");
		aa.printAllFold(2);
		System.out.println("----------------");

		aa.printAllFold(3);
		System.out.println("----------------");

		aa.printAllFold(4);
		System.out.println("----------------");

	}

}
