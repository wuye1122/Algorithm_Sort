
public class RandWater {
   /*
    * 
    * 
    * 
    *  һ������ֻ��װk����   һ�������ܹ��³�N>k
    * 
    *  ��֤�³�i��ʱ�� ʹ�������ӵĸ���  k/i
    *  
    *  ��������:���³�i��ʱ�� ��k����������ó�һ��С�򡣽�i��С������������
    *  
    *     
    *       �Ѿ������������k��Ԫ��  ʣ��k+1---N �����������ó�һ��С��
    *       
    *       ���С����<k�ͽ���
    * 
    * 
    * 
    * 
    * 
    * */
	
	//0-n������
	
	public int rand(int max){
		
		return (int)(Math.random()*max+1);
		
	}
	public int [] getNum(int k,int max){
		
		if(k<1||max<1){
			return null;
		}
		
		//���������ܴ���
		int res[]=new int[Math.min(k, max)];
		
		//�����Ƚ�k��С��װ��ȥ
		
		for(int i=0;i<res.length;i++){
			res[i]=i+1;
			
		}
		
		for(int i=k+1;i<=max;i++){
			
			if(rand(i)<=k){//����鵽������ С�ڴ��������k ��װ��ȥ
				
				//����ĺ�  1--10
				res[rand(k)-1]=i;
				
				
			}
		}
		return res;
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RandWater ww=new RandWater();
		int a[]=ww.getNum(10, 100);
		System.out.print("[");
		for(int b:a){
			System.out.print(b+",");
		}
		System.out.println("]");
		
		
		
	}

}
