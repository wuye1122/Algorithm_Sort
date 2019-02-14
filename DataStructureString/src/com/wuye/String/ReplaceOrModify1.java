package com.wuye.String;

public class ReplaceOrModify1 {

	/*
	 *  2将数组里面的121*weq  调整**8121weq 
	 *  
	 * */
	
	
	public char[] replace1(char [ ] a){
		
		if(a.length==0||a==null){
			
			return null;
		}
		int j=a.length-1;
		char b []=new char[a.length];
		for(int i=a.length-1;i>-1;i--){
			if(a[i]!='*'){
				b[j--]=a[i];				
			}
			
		}
		for(;j>-1;){
			b[j--]='*';
		}
		return b;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReplaceOrModify1 rr=new ReplaceOrModify1();
		char[] a={'*','1','3','w'};
		char[] b={'*','1','3','w','*','*','*','*','a'};
		char[] c={'*','*','*','w'};
		System.out.println(String.valueOf(rr.replace1(a)));
		System.out.println(String.valueOf(rr.replace1(b)));
		System.out.println(String.valueOf(rr.replace1(c)));
	}

}
