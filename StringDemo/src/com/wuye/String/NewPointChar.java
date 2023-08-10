package com.wuye.String;

public class NewPointChar {

	
	/*
	 *  一种新型的规定 只能有 小写字符  大写大写  大写小写在一起三种
	 *  
	 *   a d s f  AS DF VB Ds Hk Kj
	 *   
	 *   指定某处索引 然后该处的新型字符
	 *   
	 *   1 统计K-1--0期间的大写字母的个数
	 *   
	 *    如果是奇数---> k-1,k
	 *    如果是偶数--->k处为大写 k,k+1
	 *           --->k为小写 k
	 *      
	 *   
	 * 
	 * 
	 * */
	private boolean isUpper(char c) {
		// TODO Auto-generated method stub
		return c>='A'&&c<='Z';
	}
	public String ponitNew(String s,int index){
		
		if(s.equals(" ")||s==null||index<0||index>s.length()){
			return "";
		}
		
		char [] ch=s.toCharArray();
		int num=0;
		
		
		
		//统计大写字母个数。
		
	  for(int i=index-1;i>=0;i--){
		if(!isUpper(ch[i])){
			break;
		}
		num++;
	    }
		
	  
	
	 if((num&1)==1){//证明是偶数
		 
		 return s.substring(index-1, index+1);
	 }
	//否则是偶数
	 if(isUpper(ch[index])){
		 return s.substring(index, index+2);
		 
	 }
	//
	 return String.valueOf(ch[index]);
	
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewPointChar nn=new NewPointChar();
 String a="aaaAaAABa";
 

 System.out.println("第三个Aa---"+nn.ponitNew(a, 3));
 System.out.println("第四个Aa---"+nn.ponitNew(a, 4));
 System.out.println(nn.ponitNew(a, 5));
 System.out.println(nn.ponitNew(a, 6));
 System.out.println(nn.ponitNew(a, 7));
 System.out.println(nn.ponitNew(a, 8));
	}

}
