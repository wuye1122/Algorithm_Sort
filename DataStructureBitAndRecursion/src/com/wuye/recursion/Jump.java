package com.wuye.recursion;

public class Jump {
  
	/* 
	 *  recursion- ��Ծ��Ϸ��
	 *  
	 *  
	 *   a[i]=k ��������i����������������Ծk��
	 *   
	 *   ��һ�������O��ʼ��Ծ������С��������λ��
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	
	public int jump(int a[]){
		if(a==null||a.length==0){
			return 0;
		}
		int jump=0;//�������˼���
		int cur=0;//��ǰλ��
		int next=0;//������Զ��������
		for(int i=0;i<a.length;i++){
			if(cur<i){
				//����һ��
				jump++;
				
				//cur��һ������ʱ��i=1ʱ�� 
				//�ڶ������� i���������˵�ǰλ��
				cur=next;
			}
			
			//next������Զ��������
			next=Math.max(next, a[i]+i);
		}
		return jump;
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jump jj=new Jump();
		int a[]={3,2,3,1,1,4};
		int b[]={1,2,3,4,1,1,1,1,1,1,2,1};
		System.out.println(jj.jump(a));
		System.out.println(jj.jump(b));
		
	}

}
