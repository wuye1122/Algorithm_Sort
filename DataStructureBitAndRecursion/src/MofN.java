
public class MofN {

	 /**
	  * 
	  * 在N个数里面 等概率的打印出M 
	  * 
	  * 每次打印出一个  将其和最后一个元素交换 然后 在剩余里面接着打印
	  * 
	  * 
	  * 
	  * 
	  * 
	  * 
	  * 
	  * */
	public void printRand(int [] arr,int M){
		//在数组里面打印出M个数
		
		if(arr==null||arr.length==0||M<0){
			return;
			
		}
		//还应该知道抽出几个数
		
	int	m=Math.min(arr.length, M);
		
		int count=0;//代表个数
		
		int i=0;
		
		while(count<m){
			
			i=(int)(Math.random()*(arr.length-count));//
			System.out.println(arr[i]+"--");
			swap(arr,i,arr.length-count++-1);
			
		}
		
		
		
		
	}
	
	public void swap(int ar[],int left,int right){
		
		int a=ar[left];
		ar[left]=ar[right];
		ar[right]=a;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MofN mm=new MofN();
		
		int arr[]={1,2,4,5,6,12,3,5,15};
		mm.printRand(arr, 4);
	}

}
