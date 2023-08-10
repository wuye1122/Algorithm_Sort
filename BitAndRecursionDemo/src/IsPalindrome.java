
public class IsPalindrome {

	
/* �ж�һ�����ǲ��ǻ�����
 * 
 * 1        234432
 *   ʹ�����������100000   �������10���Ƚ�
 *   Ȼ��ȥ�����λ �� ��Сλ
 * 
 * 2       ���������Ǹ����Ļ�ȡ����ֵ
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
		while(n/help>=10){//ʹhelpλ����nһ��
			help=help*10;
			
		}
		while(n!=0){

			if(n/help!=n%10){
				return false;
			}
		//��ȥ��λ
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
