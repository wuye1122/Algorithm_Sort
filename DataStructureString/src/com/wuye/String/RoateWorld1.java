package com.wuye.String;

public class RoateWorld1 {

	/*  
	 * 1 ��char����������  dog loves pig--> gip sevol god
	 * 
	 *   ��һ��:��ת�ַ���dog loves pig-->pig love dog
	 * 
	 *   ����ؼ�  ������������ l r;�ֱ�����ʵĿ�ʼ�͵��ʵĽ���
	 * 
	 * 
	 * 2 �ڶ��ַ�������:
	 * 
	 *   ������Ŀ:ABCDE  -->  ָ����ǰn���ƶ�������
	 * 
	 *   ����: 1234567ABCD
	 *   
	 *        ABCD 5671234
	 *        ABCD 2341 567
	 *        ABCD1 342 567
	 *        ABCD12 34 567
	 *  
	 * */
	
	
	//��ǰsize���ַ��� �ƶ���a.length-size����
	public void RoateWorld(char []a,int size){
		if(a==null||size<=0||size>=a.length){
			return;
			
		}
		
		int start=0;
		int end=a.length-1;
		
		int lpart=size;//7
		int rpart=a.length-size;//4
		int s=Math.min(lpart, rpart);//ÿ�ν���������
		int d=lpart-rpart;//3
		
		while(true){
			Exchange(a,start,end,s);
			if(d==0){
				break;
			}else if(d>0){
				start+=s;
				lpart=d;
			}else{
				end-=s;
				rpart=-d;
				
			}
			
			 s=Math.min(lpart, rpart);
			 d=lpart-rpart;//3
		}
		
		
		
	}
	
	
	
	//���� ����ͷ��β���Ľ���
	
	public void Exchange(char []a,int start,int end,int size){
		// 0 1 2 3 4 5
		// 
		int i=end-size+1;//�������  ����size���Ŀ�ͷ����
		char tep=0;
		while(size--!=0){
			tep=a[start];
			
			a[start]=a[i];
			
			a[i]=tep;
			
			i++;
			start++;
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RoateWorld1 rr=new RoateWorld1();
		String a="1234567ABC";
		String b="we1234";
		
		char aa[]=a.toCharArray(); 
		char bb[]=b.toCharArray();
		rr.RoateWorld(aa, 7);
		System.out.println(String.valueOf(aa));
		
		rr.RoateWorld(bb, 2);
		System.out.println(String.valueOf(bb));
		System.out.println(9&1);//�ж�����ż��
	}

}
