package com.wuye.String;

public class IsDeformation {
/*
 *  �����:
 *  
 *  ָ�����ַ����������ĸ������ͬ����
 *  
 *  1 ��������ʹ�� map=new[256]:ʹ���ַ�����int��ʽ������������ ���ڷ���
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
 * 
 * 
 * 
 * */
	
	
	
	
	
	public static boolean isDeformation(String a,String b){
		
		//String ����ֵ����length()����
		if(a==null||b==null||a.length()!=b.length()){
			return false;
		}
		
		char[] ch1=a.toCharArray();
		char[] ch2=b.toCharArray();
		
		//������
		int [] map=new int[256];
		
		for(int i=0;i<a.length();i++){
			map[ch1[i]]++;
			//�˴�����һ�� char-->ǿתint
		}
		
		/*
		 * "a2s3d", "s1a3d"
		 * 
		 * ��������һ��ʱ��  ���������Ѿ����뵽map����
		 * 
		 * 
		 * 
		 * 
		 * */
		for(int i=0;i<b.length();i++){
		//���жϵ�b������ַ���  ���ж�֮����--  
			if(map[ch2[i]]==0){
				
				return false;
			}
			
		}
		return true;
		
		
	};
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a="abjk";
		char []ch=a.toCharArray();
		
		int [] map=new int[256];
		System.out.println(ch[0]);
		System.out.println((int)ch[0]);
		System.out.println((int)ch[1]);
		System.out.println((int)ch[2]);
		System.out.println((int)ch[3]);
        map[ch[0]]++;
        map[ch[1]]++;
        map[ch[2]]++;
        map[ch[3]]++;
        //char�Զ�ת����int
        System.out.println(map[97]);
        String str="21313";
               str="asd";
        System.out.println(str);
       System.out.println( IsDeformation.isDeformation("a2s3d", "s2a3d"));
        
		
	}

}
