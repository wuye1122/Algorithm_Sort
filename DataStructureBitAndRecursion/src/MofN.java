
public class MofN {

	 /**
	  * 
	  * ��N�������� �ȸ��ʵĴ�ӡ��M 
	  * 
	  * ÿ�δ�ӡ��һ��  ��������һ��Ԫ�ؽ��� Ȼ�� ��ʣ��������Ŵ�ӡ
	  * 
	  * 
	  * 
	  * 
	  * 
	  * 
	  * 
	  * */
	public void printRand(int [] arr,int M){
		//�����������ӡ��M����
		
		if(arr==null||arr.length==0||M<0){
			return;
			
		}
		//��Ӧ��֪�����������
		
	int	m=Math.min(arr.length, M);
		
		int count=0;//�������
		
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
