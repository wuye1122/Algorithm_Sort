
public class Gcd {

	
	/*
	 *  һ�д��������Լ��
	 * 
	 *  շת����� �������ͳ����� ���Լ��===���������������Լ��
	 * 
	 * 
	 * 
	 * 
	 * */
	
	public static int gcd(int m,int n){
		
		//������Ҫһ�д���
		
		return n==0?m:gcd(n,m%n);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Gcd.gcd(2, 3) );
	}

}
