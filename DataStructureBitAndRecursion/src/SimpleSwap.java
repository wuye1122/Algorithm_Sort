
public class SimpleSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            //ʹ��λ����� �����������Ľ��� �������  ֻ��0  1 ��ͬд0  ��ͬд1
		System.out.println(3^4^3);//1000���н�λ
		System.out.println(3^4^4);
		
		int a=5;
		int b=3;
		a=a^b;//��ʱa���һ���н�  8 4 2 1 
		// 101                  011
 		//     ����a  001
		System.out.println(a);
		b=a^b;//��ʱ b=101
		a=a^b;//��ʱ a=011
		System.out.println(a);
		System.out.println(b);
            
        
	}

}
