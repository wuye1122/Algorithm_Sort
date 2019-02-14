package com.wuye.String;

public class RotateWord {
/*  
 * 1 将char进行逆序处理  dog loves pig--> gip sevol god
 * 
 *   进一步:反转字符串dog loves pig-->pig love dog
 * 
 *   此题关键  设置两个变量 l r;分别代表单词的开始和单词的结束
 * 
 *   补充题目:ABCDE  -->  指定将前n个移动到后面
 *   
 *        思路  CBA ED -->DEABC进行三次反转
 *   
 * */
	
	public void reverse(char [] a,int start,int end){
		
		char temp=0;//临时变量
		
		while(start<end){
			temp=a[start];
			
			a[start]=a[end];
			
			a[end]=temp;
			start++;
			end--;
		}
		
		
	}
	
	
	public void rotate(char []c){
		if(c==null||c.length==0){
			return;
		}
		
		//首先将这个字符串 全部反转
		reverse(c,0,c.length-1);
		
		int l=-1;//代表每个字母的开头
		
		int r=-1;//代表每个字母的结束
		
		for(int i=0;i<c.length;i++){
		  if(c[1]!=' '){
			  l=i==0||c[i-1]==' '?i:l;
			  r=i==c.length-1||c[i+1]==' '?i:r; 
			  
		  }
		 if(l!=-1&&r!=-1){
			 reverse(c,l,r);  
			 l=-1;
			 r=-1;
			  
		  }
		}
		
		
	}
	
	public  void rotate(char [] ch,int size){
		reverse(ch,0,size-1);
		reverse(ch,size,ch.length-1);
		reverse(ch,0,ch.length-1);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateWord rr=new RotateWord();
		char []a={'m','y','n','a','m','e','i','s'};
		String b="dog loves pig";
		char []bb= b.toCharArray(); 
//	    rr.reverse(bb, 0, bb.length-1);
//	    System.out.println(bb);
	    
	    System.out.println("一步到位");
	    
	    rr.rotate(bb);
	    System.out.println(bb);
	    
		rr.reverse(a, 0, a.length-1);
		System.out.println(String.valueOf(a));
		
		
		String str="ABCDEF";
		System.out.println(str);
		char st[]=str.toCharArray();
		rr.rotate(st, 3);
		System.out.println(String.valueOf(st));
		
		
	}

}
