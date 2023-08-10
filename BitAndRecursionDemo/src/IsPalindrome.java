
public class IsPalindrome {

	
/* 判断一个数是不是回文数
 * 
 * 1        234432
 *   使用这个数处于100000   和这个数10来比较
 *   然后去除最大位 和 最小位
 * 
 * 2       如果这个数是负数的话取绝对值
 * 
 *   
 * 
 * 
 * 
 * 
 * 
 * 
 * */
	
	public static boolean isPalindrome(int n){
		if(n==Integer.MAX_VALUE){
			return false;
		}
		
		n=Math.abs(n);
		
		int help=1;
		while(n/help>=10){//使help位数和n一样
			help=help*10;
			
		}
		while(n!=0){

			if(n/help!=n%10){
				return false;
			}
		//除去两位
			n=(n%help)/10;
			help=help/100;
		
		}
		return true;
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println(	IsPalindrome.isPalindrome(123421));
	}

}
