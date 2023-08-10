package com.wuye.String;

public class GetCountString {
      
	/*
	 *  1   �ַ�����ͳ���ַ���
	 *    2wqekk-->ת����-->2_1_w_1_q_1_e_1_k_2
	 *  
	 *  2   ָ��һ������ ���ó�����������char 
	 *    
	 *  
	 * 
	 * 
	 * 
	 * */
	
	
	public String getCount(String str){
		
		if(str==null||str.equals(" ")){
			return " ";
			
		}
		char ch[]=str.toCharArray();
		
		String res=String.valueOf(ch[0]);//��char+"����"+char
		
		int num=1;//��ʼֵ����1
		
		for(int i=1;i<ch.length;i++){
			
			if(ch[i]!=ch[i-1]){
				res=concat(res,String.valueOf(num),String.valueOf(ch[i]));
				num=1;
			}else{
				num++;
				
			}
			
			
		}
		return concat(res,String.valueOf(num),"");
		
		
		
		
	}
	public String concat(String s1,String s2,String s3){
		
		return s1+"_"+s2+(s3.equals("")?s3:"_"+s3);
	}
	
	public char getIndex(String st,int index){
		if(st==null){
			return 0;
			
		}
		char ch[]=st.toCharArray();
		char cur=0;
		int sum=0;
		int num=0;
		boolean sate=true;
		//�������ַ�ʱ��Ϊtrue    ���������ַ�ʱ��Ϊfalse
		for(int i=0;i<st.length();i++){
			if(ch[i]=='_'){
				sate=!sate;
				
			}else if(sate){
				sum+=num;
				if(sum>index){
					return cur;
					
				}
				num=0;
				cur=ch[i];
				
			}else{
				
				num=num*10+ch[i]-'0';
			}
			
		}
		return sum+num>index?cur:0;
		//�ж����һ���Ƿ����  ��ѯ������
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetCountString gc=new GetCountString();
		String a=" ";
		String c=null;
		String b="aaabbweqwqqq";
		
		System.out.println(gc.getCount(a));
		System.out.println(gc.getCount(c));
		System.out.println(gc.getCount(b));
		System.out.println("------"+gc.getIndex("a_3_b_2_w_1_e_1_q_1_w_1_q_3", 0));
		System.out.println("------"+gc.getIndex("a_3_b_2_w_1_e_1_q_1_w_1_q_3", 1));
		System.out.println("------"+gc.getIndex("a_3_b_2_w_1_e_1_q_1_w_1_q_3", 2));
		System.out.println("------"+gc.getIndex("a_3_b_2_w_1_e_1_q_1_w_1_q_3", 3));
		System.out.println("------"+gc.getIndex("a_3_b_2_w_1_e_1_q_1_w_1_q_3", 4));
		System.out.println("------"+gc.getIndex("a_3_b_2_w_1_e_1_q_1_w_1_q_3", 5));
		System.out.println("------"+gc.getIndex("a_3_b_2_w_1_e_1_q_1_w_1_q_3", 8));
	}

}
