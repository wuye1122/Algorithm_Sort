package com.wuye.recursion;

public class WinerOfChoosePaper {
/*  
 * rescursion -����ֽ�Ʋ�������
 * 
 * ****�㲻���������� Ҳ�Ǻ�����
 * 
 * 
 * һ������    ��AB�������   ÿ��ֻ������������������  
 *        ��󷵻�Ӯ�ŵķ�����
 * 
 * ����һ:������֧�ݹ�ʱ�临�Ӷ�O(2^n);ָ��
 * 
 *   ��Ҫ���f()������ Ҫ�����Լ�Ҳ���Ϊһ����������:�Լ�һ��ѡ����
 *   
 *        s()��������ȡ����������֮�� �Լ�����Ϊһ����������   �����Լ�����֮�� һ������Сֵ
 *           ��Ϊ����Ҳ��ɵ
 * 
 * 
 * 
 * 
 * 
 * ������:��̬�滮 ʱ�临�Ӷ�O(n^2);�ݺ���
 * 
 *     �����д��һ����������Ȼ����˼ά
 * 
 *     ʹ����������ķ�ʽ���зֱ�����Լ����ú��õķ���
 *     f[i][j]=f(i,j)��ֵ
 *     s[i][j]=s(i,j)��ֵ
 *    
 *     1 2 100  4
 *     
 *     0 1 2 3
 *   0 0 
 *   1   2
 *   2     100 
 *   4        4 
 * 
 * */
	//��̬�滮
	public int win2(int []b){
		if(b==null||b.length==0){
			return 0;
			
		}
		int f[][]=new int[b.length][b.length];
		int s[][]=new int[b.length][b.length];
		
		for(int j=0;j<b.length;j++){
			f[j][j]=b[j];
			for(int i=j-1;i>=0;i--){
				f[i][j]=Math.max(b[i]+s[i+1][j], b[j]+s[i][j-1]);
				s[i][j]=Math.min(f[i+1][j], f[i][j-1]);
			}
			
		}
		System.out.println("������������б���");
		for(int a[]:f){
			for(int ff:a){
				System.out.print(ff+" ");
				
			}
			System.out.println();
		}
		
		System.out.println("-------------------");
		for(int a[]:s){
			for(int ff:a){
				System.out.print(ff+" ");
				
			}
			System.out.println();
		}
		
		return Math.max(f[0][b.length-1], s[0][b.length-1]);
	}
	
	
	
	//����һ  :�����ݹ�
	public int win1(int []a){
		if(a==null||a.length==0){
			return 0;
			
		}
		return Math.max(fir(a,0,a.length-1), lat(a,0,a.length-1));
	}
	
	//������������  �ֱ�������õĵõ��ķ���
	public int fir(int []a,int i,int j){
		if(i==j){
			return a[1];
		}
		
		//�����Ż�ѡ�� ( ������ �� ����ʣ�ಿ�ֺ����ߵķ�     ������  �� ʣ�ಿ�ֺ����ߵķ�)
		return Math.max(a[i]+lat(a, i+1, j ), a[j]+lat(a,i,j-1));
	}
	
	//���һ��������õĵõ��ķ���
	public int  lat(int []a,int i,int j){
		
		if(i==j){//������õ�����ֻ��һ��Ԫ�صĻ���ô��һ����ʲôҲ�ò���
		return 0;	
		}
		
		//������һ�����������˱��������� һ��i����һ��jȻ���Լ���Ϊʣ�ಿ����һ��������
		return Math.min(fir(a,i+1,j), fir(a,i,j-1));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WinerOfChoosePaper rr=new WinerOfChoosePaper();
		int a[]={1,2,3,4,5,6};
		
		System.out.println(rr.win1(a));
		System.out.println(rr.win2(a));
	}

}
