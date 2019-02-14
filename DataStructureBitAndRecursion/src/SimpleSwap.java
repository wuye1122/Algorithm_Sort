
public class SimpleSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            //使用位运算符 进行两个数的交换 利用异或  只有0  1 不同写0  相同写1
		System.out.println(3^4^3);//1000含有进位
		System.out.println(3^4^4);
		
		int a=5;
		int b=3;
		a=a^b;//此时a变成一个中介  8 4 2 1 
		// 101                  011
 		//     变后的a  001
		System.out.println(a);
		b=a^b;//此时 b=101
		a=a^b;//此时 a=011
		System.out.println(a);
		System.out.println(b);
            
        
	}

}
