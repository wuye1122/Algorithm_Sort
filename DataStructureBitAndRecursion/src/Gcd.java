
public class Gcd {

	
	/*
	 *  一行代码求最大公约数
	 * 
	 *  辗转相除法 被除数和除数的 最大公约数===除数和余数的最大公约数
	 * 
	 * 
	 * 
	 * 
	 * */
	
	public static int gcd(int m,int n){
		
		//仅仅需要一行代码
		
		return n==0?m:gcd(n,m%n);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Gcd.gcd(2, 3) );
	}

}
