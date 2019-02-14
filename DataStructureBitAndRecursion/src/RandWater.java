
public class RandWater {
   /*
    * 
    * 
    * 
    *  一个袋子只能装k个球   一个机器能够吐出N>k
    * 
    *  保证吐出i的时候 使球进入袋子的概率  k/i
    *  
    *  方法如下:当吐出i的时候 将k里面的任意拿出一个小球。将i号小球加入袋子里面
    *  
    *     
    *       已经进入袋子里面k个元素  剩下k+1---N 从其中任意拿出一个小球
    *       
    *       如果小球编号<k就进入
    * 
    * 
    * 
    * 
    * 
    * */
	
	//0-n任意数
	
	public int rand(int max){
		
		return (int)(Math.random()*max+1);
		
	}
	public int [] getNum(int k,int max){
		
		if(k<1||max<1){
			return null;
		}
		
		//数组代表的能袋子
		int res[]=new int[Math.min(k, max)];
		
		//首先先将k个小球装进去
		
		for(int i=0;i<res.length;i++){
			res[i]=i+1;
			
		}
		
		for(int i=k+1;i<=max;i++){
			
			if(rand(i)<=k){//如果抽到的数字 小于袋子里面的k 就装进去
				
				//抽出的号  1--10
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
