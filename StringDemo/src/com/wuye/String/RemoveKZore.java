package com.wuye.String;

public class RemoveKZore {

	/*
	 * 
	 *   ���ַ���������������k��oo�ĵط�ɾ��
	 * 
	 *   ���Ŀո�ɾ�����ˡ�
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	public  String removerKZore(String str,int k){
		
		if(str==null||k<1||k>str.length()){
			return str;
			
		}
		char ch[]=str.toCharArray();
		
		//���� count��¼��������O�Ĵ���  start��¼�����Ŀ�ͷλ��
		int count=0;
		int start=-1;
		for(int i=0;i<ch.length;i++){
			if(ch[i]=='o'){
			count++;
			start=start==-1?i:start;
				
			//������һ�μ�¼֮�� ���ڽ���else������Ҫ��дһ��
			}
				else{
					if(count==k){
						//�������
						while(count--!=0){
							ch[start++]=0;
						}
					}
						count=0;
						start=-1;
					}
				
				
			}
			
			if(count==k){
				//�������
				while(count--!=0){
					ch[start++]=0;
				  }
			}
			
			return String.valueOf(ch);
		
			
		}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveKZore rr=new RemoveKZore();
		 String b="oo0oo0daoooodf2o";
		 System.out.println(String.valueOf(b));
		// RemoveKZore.removerKZore(b, 1);	
		 System.out.println("1---"+rr.removerKZore(b, 1));
		
		 System.out.println("2---"+rr.removerKZore(b, 2).trim());
		
		 System.out.println("4---"+ rr.removerKZore(b, 4));
		 
		 System.out.println("4---"+ rr.removerKZore(b, 4).replaceAll(" ", ""));
		//�����0����� ���ַ����������ǿո�	 
		 String d="   assa  ee";
		 System.out.println(d.trim());//��ȥ��β�ո�
		System.out.println(d.replaceAll(" ", ""));
		 
	}

}
