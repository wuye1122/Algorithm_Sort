
public class AllFold {

	/*          ������ֽ����
	 * 
	 * 
	 * ��һ��:                ��
	 * 
	 * ������:       ��                                                      ��                
	 * 
	 * ������: ��                              ��               ��                                         ��
	 * 
	 * 
	 * ��������: �ʼ����   Ȼ�� ÿһ���ۺ۵� ǰ��һ����  ����
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
			return;//���ܳ���������
		}
		
		printA(i+1,N,true);//�µ�ǰ��һ������
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
