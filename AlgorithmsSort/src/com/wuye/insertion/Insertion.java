package com.wuye.insertion;

public class Insertion {
    //平均n^2/4  最次 n^2/2  最好 n-1 比较 0交换
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      //实现Comparable的数据类型:integer double string file url
	Integer [] i={12,3,5,68,1,32};
	System.out.println("排序前");
		show(i);
		System.out.println(" ");
		sort(i);
		if(isSorted(i)){
			System.out.println("排序后");	
		show(i);
		}else{
			System.out.println("真遗憾 你弄错了");}
		
		
		
		
		
           
	}
	//比较
   
	private static boolean less(Comparable  a,Comparable  b){
    	
    	return a.compareTo(b)<0;
    	}
    //交换
    
    private static void exch(Comparable [] a,int i,int j){
    	
    	Comparable t=a[i];
    	a[i]=a[j];
    	a[j]=t;
    	
    }
    //显示出来
    private static void show(Comparable []a){
    	for(int i=0;i<a.length;i++){
    		
    		System.out.print(a[i]+" ");
    		
    	}
    	
    }
    
    
    
    
    //判断最终结果是不是正序
    public static boolean isSorted(Comparable [] a){
    	
    	for(int i=1;i<a.length;i++){
    		if(less(a[i],a[i-1]))
    			return false;//如果第二个人比第一个小就返回错误，
    		   }
    	return true;
    	}
     
    public static void sort(Comparable []a){
    	
    	int N=a.length;
    	for(int i=1;i<N;i++){
    		//第一次循环完  左面的一定成升序     每次循环将新的元素放在适当位置 （但不是最终的位置）
    		//将a[i]插入a[i]  a[i-1] a[i-2] a[i-3]之中
    		for(int j=i;j>0&&less(a[j],a[j-1]);j--){
    			//首先第二个个数和第一个比较  如果比前面的小就和它交换
    			show(a);
    			System.out.println("* ");
    			exch(a,j,j-1);
    			show(a);
    			System.out.println("& ");
    			//j减完之后 继续和前面的比 如果小接着换 
    		}
    		
    		
    		
    	}
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
