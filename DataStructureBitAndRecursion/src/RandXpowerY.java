
public class RandXpowerY {
/*
 * math.random()  等概率随机返回一个[0,1)范围上的数
 * 
 * 在[0,x)区间的概率 x([0,1])
 * 
 * 调整其概率 使其[0,x)上的概率变成:x^k
 * 
 *  
 *  
 *  对于函数Math.max(math.random.math.random);
 *               出现的概率是x*x---->其出现的等概率的相乘 
 * 
 *  调用了2次math.random---->x^2
 *  如果调用k次  x^k
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
