package com.wuye.String;

public class Replace {

	
	/*  
	 *   1 ���ַ�������ĵ�Str from�ַ����� -->to
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
	 * */
	//�滻
	
	public String replace(String str,String from,String to){
		
		
		if(str==null||from==null||from.equals("")||to.equals("")){
			return str;
			
			
		}
		
		//�����滻 ��Ҫ�� str fromת�����ַ���������
		char str1[]=str.toCharArray();
		char from1[]=from.toCharArray();
		
		int match=0;//��¼ÿ�αȽϵĸ���
		
		for(int i=0;i<str1.length;i++){
			
			if(str1[i]==from1[match++]){
				//������������λ��ȫ����
				if(match==from1.length){
					clear(str1,i,from1.length);
					match=0;//��һ��ƥ�������Ϊ0
					
				}
				
			}else{
				match=0;//δ��ȫ��ƥ��
			}
		
		}
		String res="";
		String cur="";
		
		//�ڶ����������ַ������������һ����
		for(int i=0;i<str1.length;i++){
			if(str1[i]!=0){
				cur=cur+String.valueOf(str1[i]);
				
			}
			if(str1[i]==0&&(i==0||str1[i-1]!=0)){//�ӵ�һ��λ�� ���� ǰ�治��o
				
				res=res+cur+to;
				cur="";//Ϊ���´η�o��׼��
			}
			
			
				
			}if(!cur.equals("")){
			
				res=res+cur;
			
		}
		return res;
		
		
		
	}
	
	
	//clear ��ָ���ַ������ end��ǰ  len���ظ��ַ����0
	
	public void clear(char [] ah,int end,int len){
		while(len--!=0){
			ah[end--]=0;
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Replace rr=new Replace();
		System.out.println(rr.replace("asa111f tysar", "sa", "love").replaceAll(" ", ""));
		
		
		
	}

}
