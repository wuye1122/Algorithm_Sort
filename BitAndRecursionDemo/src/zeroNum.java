
public class zeroNum {
  
	/*
	 *   �׳�ĩβΪ0��������
	 *    
	 *   1 ���һ���������ж��ٸ�����5   ��Ϊ2��������5�ࡣ���Բ��5����
	 *   
	 *   
	 *   2 �����׳����溬��0�ĸ�����
	 *   
	 *     1  2  3  4  5  -->��������� 1����
	 *     5 10 15 20 25  -->���������2��5
	 *     ��������
	 *     ÿ�������i�����ӵ���  �����������i+1����
	 *     
	 *     ���z=n/5+n/5^1+n/5^2����n/5^i
	 *   
	 *   ����:ʹ�ö����Ʊ�ʾ�׳�   �������λ1���ĸ�λ�á�
	 *   
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
/*	8 һ����N!ĩβ�м���0
	  00
	  ����
	  \     [N /5^i]  �����������������
	  /       
	  ����
	  i=0  
	     
*/
	//����һ:�ҳ������������м���5  NlogN
	
	public int zeroNum1(int num){
		if(num<0){
			return 0;
		}
		int res=0;
		int cur=0;
		
		for(int i=5;i<=num;i=i+5){
			cur=i;
			while(cur%5==0){
				res++;
				cur/=5;//���� 25  �ж���25  �����ж�5
				       //���� 500 �ж� 500  100  25  5  
				}
			
		}
		return res;
		
	}

	//������:�ҳ������������м���5  logN
	public int zeroNum2(int num){
		
		if(num<0){
			return 0;
		}
		
		int res=0;
		
		while(num!=0){
			res+=num/5;
			num/=5;
		}
		return res;
		}
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		zeroNum zz=new zeroNum();
		System.out.println(zz.zeroNum1(10));
		System.out.println(zz.zeroNum2(10));
		
		
		
		
	}

}
