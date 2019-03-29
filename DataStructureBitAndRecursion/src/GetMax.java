


public class GetMax {

	
	/*
	 *  ʹ��λ�����ҳ� ����������Ƚϴ���Ǹ���
	 * 
	 *  һ����32λ����
	 * 
	 *  ��һ�ַ����ĵ� a-b�ķ���
	 *  
	 *    (n>>31)&1 ����a-b�ķ��� ���������  ����0 ����1  ��������0
	 *    n^1ʲô��˼-->�����1����0  �����0����1
	 *    ��һ�ַ����о�����:��� a-b���  �����׼ȷ
	 *  
	 *    
	 *   �ڶ��η������Խ�������� ^  ��ͬȡ0  ��ͬȡ1
	 *             
	 *             
	 * 
	 * */
	
	
	//0--1  1--0��Ե�
	public int filp(int n){
		return n^1;
	}
	
	
	
	//�ж� ����ķ���
	
	public int sign(int n){
		
		return filp((n>>31)&1);
	}
	public int getMax1(int a,int b){
		
		
		
		
		int c=a-b;// 10  3  c=7
		int sga=sign(c);//0
		int sgb=filp(sga);//1
		return a*sga+b*sgb;
	}
		
	//�е������ڴ�����	
	public int getMax(int a,int b){
		
		int c=a-b;
		int sa=sign(a);
		int sb=sign(b);
		int sc=sign(c);
		//�жϷ����Ƿ���ͬ
		
		int dissame=sa^sb;//��ͬΪ 1
		
		int same=filp(dissame);
		
		int returna=dissame*sa+same*sc;
		
		int returnb=filp(returna);
		/*
		 *  dis=1  same=0//����ͬ��ȥ�жϲ�ֵ
		 *  
		 *      sa=1 sb=0
		 *      sa=0 sb=1     
		 *      
		 *      
		 *  dis=0 same=1 //�����ͬ��ȥ�жϲ�ֵ
		 *  
		 *      sc=1
		 *      sc=0
		 *      
		 *      
		 *      
		 *      returna=dis*sa+same*sc
		 *     
		 *      returnb=filp(a)
		 *      
		 *      
		 *      ����� a*return+b*return;
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
		 * 
		 * */
		return a*returna+b*returnb;
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GetMax gg=new GetMax();
		
	System.out.println("�Ƚ�13  3��С:�����"+gg.getMax1(12, 3));
	System.out.println("�Ƚ�-13 -17��С:�����"+gg.getMax1(-13, -17));	
      System.out.println(Integer.MAX_VALUE);
      System.out.println(Integer.MIN_VALUE);
      
     
      System.out.println("-----------------");
      System.out.println(Integer.toBinaryString(-5));
      System.out.println(Integer.toBinaryString(-5^1));
      System.out.println(5^1);

      System.out.println("-----------------");
      System.out.println(1^1);
      System.out.println(0^1);
      System.out.println("-----------------");
      System.out.println((5>>31)&1); //����0 
      System.out.println((-5>>31)&1);//����1
      System.out.println("�Ƚ�13  3��С:�����"+gg.getMax(12, 3));
  	System.out.println("�Ƚ�-13 -17��С:�����"+gg.getMax(-13, -17));	
      
	}

}
