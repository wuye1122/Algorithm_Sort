
public class Random {
   /* 
    *   ��������������ļ����������չ
    * 
    *   1 �����[1,5]  ȥʵ��[1,7]
    * 
    *   2 �����[0(p).1(1-p)]  ʵ�ֵȸ��ʲ���[1,6]
    * 
    *   3 �����[1,m]  ʵ�������[1,n]
    * 
    * 
    * 
    * */
	
	
	//����һ:
	
	public int rand105(){
		return  (int)(Math.random()*5+1);
	}
	
	// rand105()-1          0 1 2 3 4
	// (rand105()-1)*5      0 5 10 15 20
	// ���������������� �������������ζ����ĵ��á�---���
	// ������ӳ��ֵĶ����0 1 2 3 4 5 6 ��������20 21 22 23 24
	
	//���Ͻ���ѭ��������20���½���ѭ����ɸ���� 0-20
	//20%7ȡ���� (0 6)
	public int rand107(){
		
		
		int mun=0;
		do{
			mun=(rand105()-1)+((rand105()-1)*5);//ʹ�ò��
		}while(mun>20);//ɸ��0-20
		
		return mun%7+1;//0 20 %7  �ܹ�21���� %7֮��������� 0-6���ǵȸ��ʵ�
		
		 
	}
	
	//������:
	
	public int rand01p(){
		
		double p=0.83;
		return Math.random()<p?0:1;
	}
	
	/* 1 ��������ȸ��ʲ��� 0 1��
	 *  
	 *  ����01���� 10������������к���ֵ��Ǹ� ʵ�ֵȸ��� (1-p)p
	 *  
	 *  
	 *  2 �������0-6 15/6    0-7 ͨ��20/7
	 *   
	 *    2*6=12 0-11      3*7=21 0-20 
	 *      
	 *  
	 *   0 1������ 
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
		}while(num==rand01p());//0���1    1����ѭ��ֱ������0
		return num;
	}
	
	public int rand03(){
		return rand01()*2+rand01();//0-2 +0-1��շ�  
	}
	
	public int rand106(){
		
		int num=0;
		do{
			num=rand03()*4+rand03();
			
		}while(num>11);
		return num%6+1;
	}
	
	//������:
	
	public int randToM(int m){
		
		return  (int)(Math.random()*m+1);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random rr=new Random();
		
		System.out.println(Math.random());//[0,1)
		 
		// ��һ����� int(ǿת֮�����յ�ֵһ����0)
		// �ڶ������ int(ǿת֮��С������ȥ  1-5)
		System.out.println((int)Math.random()*5);//0.99*5��Զ������5
		System.out.println((int)(Math.random()*5+1));//[1,5.)
		
		System.out.println(rr.rand107());
		System.out.println(rr.rand107());
		System.out.println(rr.rand107());
		System.out.println(rr.rand107());
		
		for(int i=0;i<=20;i++){
			System.out.print(i%7+"-");
			
		}
		//1-M���������
		//(int)(Math.random()*M+1)
		
		
		//����0 1�ĸ��ʲ�ͬ  Math.random()<p?0:1
		System.out.println("----"+rr.rand01p());
		System.out.println("----"+rr.rand01());
		for(int i=0;i<=11;i++){
			System.out.print(i%6+"-");
		      	
		}
		System.out.println();
		System.out.println(rr.rand106());
	}

}
