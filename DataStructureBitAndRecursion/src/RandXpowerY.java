
public class RandXpowerY {
/*
 * math.random()  �ȸ����������һ��[0,1)��Χ�ϵ���
 * 
 * ��[0,x)����ĸ��� x([0,1])
 * 
 * ��������� ʹ��[0,x)�ϵĸ��ʱ��:x^k
 * 
 *  
 *  
 *  ���ں���Math.max(math.random.math.random);
 *               ���ֵĸ�����x*x---->����ֵĵȸ��ʵ���� 
 * 
 *  ������2��math.random---->x^2
 *  �������k��  x^k
 * 
 * 
 * 
 * 
 * */
	
	public double getMaxOfK(int k){
		if(k<1){
			return 0;
		}
		
		double res=0;
		for(int i=0;i<k;i++){
			res=Math.max(res, Math.random());
		}
		return res;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RandXpowerY rr=new RandXpowerY();
		
		System.out.println(rr.getMaxOfK(1));
		
		
		
		
		
	}

}
