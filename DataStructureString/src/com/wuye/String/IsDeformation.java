package com.wuye.String;

public class IsDeformation {
/*
 *  互变词:
 *  
 *  指两个字符串里面的字母含有相同种类
 *  
 *  1 此题巧妙使用 map=new[256]:使用字符串的int形式存入数组里面 便于分类
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
		
		//String 里面值存在length()方法
		if(a==null||b==null||a.length()!=b.length()){
			return false;
		}
		
		char[] ch1=a.toCharArray();
		char[] ch2=b.toCharArray();
		
		//计数器
		int [] map=new int[256];
		
		for(int i=0;i<a.length();i++){
			map[ch1[i]]++;
			//此处包含一个 char-->强转int
		}
		
		/*
		 * "a2s3d", "s1a3d"
		 * 
		 * 当遍历第一个时候  五种类型已经输入到map里面
		 * 
		 * 
		 * 
		 * 
		 * */
		for(int i=0;i<b.length();i++){
		//当判断到b里面的字符串  先判断之后再--  
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
        //char自动转换成int
        System.out.println(map[97]);
        String str="21313";
               str="asd";
        System.out.println(str);
       System.out.println( IsDeformation.isDeformation("a2s3d", "s2a3d"));
        
		
	}

}
