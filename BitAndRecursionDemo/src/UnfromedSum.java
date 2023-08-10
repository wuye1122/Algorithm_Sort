import java.util.HashSet;


public class UnfromedSum {

	/* 
	 *  ��С������ɺ�:����
	 *  
	 *  ���Ƚ�һ�������Ӽ�������:�ó�max min
	 *  
	 *  ��[min,max]��   �������治����ɵ����������С���Ǹ���������С�Ĳ�����ɺ�
	 *  
	 *               ���ȫ���������ô �����ɺ;���max+1
	 * 
	 * 
	 * 
	 * ������Ŀ:�������溬��1�ܷ������ҵ���С���������
	 * 
	 * 
	 * ����һ:ʹ�ñ����ݹ�
	 * 
	 *   [1 2 3]----[1 2 3 4 5 6]
	 *  
	 *   ʹ�õݹ鷽�����л����������ֵ��
	 *   pro(a,i+1,sum,set)��¼�Ķ���ֻ����a[i]��
	 *   pro(a,i+1,sum+a[i],set)    
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
	 * ������:ʹ�ö�̬�滮
	 * 
	 *   
	 *   ʹ������dp[0..sum]//����¼�ܹ����������ʾ��  
	 *   
	 *   ������һЩ
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */

   //�ڶ��� ��̬�滮 ��ʱ�临�Ӷ� O(N*sum) �ռ临�Ӷ�O(N) ���鳤��dp[]
	
	public int unfromSum1(int a[]){
		if(a==null||a.length==0){
			return 1;
		}
		
		
		int sum=0;//���������¼���ֵ����С��
		int min=Integer.MAX_VALUE;
		
		for(int i=0;i<a.length;i++){
			sum+=a[i];
			min=Math.min(min, a[i]);
			
		}
		//����һ��boolean ����
		boolean [] dp=new boolean[sum+1];
		//��ô����ĺô�����  ����:0--sum  ��Ӧ����Ҳ��0--sum
		dp[0]=true;
		
		
		//���ж����������и�ֵ
		
		for(int i=0;i<a.length;i++){
			for(int j=sum;j>=a[i];j--){
				
				/*  2  3  5 ��ʼһ��
				 * 
				 * �������͵��� dp[0]+2=dp[2]=true
				 *         dp[0]+3=dp[3]=true;
				 *         .......... 
				 *        10
				 * */
			dp[j]=dp[j-a[i]]?true:dp[j];
			
			 /* 2��ʱ��
			  * 
			  * ���ż�  10-2=8
			  *      9-2=7 
			  *      ��������
			  *      2-2=0 
			  * 
			  * 3��ʱ��
			  * 
			  * ���ż�  10-3=7
			  *      9-3=6
			  *      5-3=2
			  *      3-3=0
			  * ��������������
			  * */
				
			}
			
		}
		System.out.println("-------------"+sum);
		//sum����������ֵ
		for(int i=min;i<dp.length;i++){
			if(!dp[i]){
				return i;
			}
		}
		
		//�������������  ���� ����sum+1������
		return sum+1;//?????�˴��Ĳ�Ӱ�췵��ֵ  ��֮ǰ�Ѿ�������
		
		
	}
	
	//��һ��ʹ�ñ����ݹ�
	public int unfromSum(int [] arr){
		
		if(arr==null||arr.length==0){
			return 0;
		}
		
		HashSet<Integer> set=new HashSet<Integer>();
		proc(arr,0,0,set);
		//���Ƚ�set����� ���п����ۼӵĺ�������
		int min=Integer.MAX_VALUE;
		
		//�ҳ�ԭ�����������Сֵ
		for(int i=0;i<arr.length;i++){
			
			min=Math.min(min, arr[i]);
		}
		
		
		//��������˼��һֱѭ��  ֱ���ҳ���С������ɺ� ����
		for(int i=min+1;i!=Integer.MIN_VALUE;i++){
			if(!set.contains(i)){
				return i;
			}
			
			
		}
		return 0;
		
	}
	
	public void proc(int []a,int i,int sum,HashSet<Integer> set){
		if(i==a.length){
			set.add(sum);
			return;
		}
		proc(a,i+1,sum,set);//ֻ����a[i]�����
		proc(a,i+1,sum+a[i],set);//������a[i]�����
	}
	
	
	
	//�ڶ���ʹ�ö�̬�滮��
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> set=new HashSet<Integer>();
		UnfromedSum uu=new UnfromedSum();
		int a[]={1,4,3,7};
		uu.proc(a, 0, 0, set);
		
		System.out.println(set);
		
		System.out.println(set);
		System.out.println(Integer.MIN_VALUE);
		
		int b[]={2,3,5};
		System.out.println(uu.unfromSum(a));
		System.out.println(uu.unfromSum1(b));
	}

}
