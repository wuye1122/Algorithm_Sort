package com.wuye.String;

public class RoateWorld1 {

	/*  
	 * 1 将char进行逆序处理  dog loves pig--> gip sevol god
	 * 
	 *   进一步:反转字符串dog loves pig-->pig love dog
	 * 
	 *   此题关键  设置两个变量 l r;分别代表单词的开始和单词的结束
	 * 
	 * 
	 * 2 第二种方法如下:
	 * 
	 *   补充题目:ABCDE  -->  指定将前n个移动到后面
	 * 
	 *   例如: 1234567ABCD
	 *   
	 *        ABCD 5671234
	 *        ABCD 2341 567
	 *        ABCD1 342 567
	 *        ABCD12 34 567
	 *  
	 * */
	
	
	//将前size个字符串 移动到a.length-size后面
	public void RoateWorld(char []a,int size){
		if(a==null||size<=0||size>=a.length){
			return;
			
		}
		
		int start=0;
		int end=a.length-1;
		
		int lpart=size;//7
		int rpart=a.length-size;//4
		int s=Math.min(lpart, rpart);//每次交换的数量
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
	
	
	
	//首先 进行头部尾部的交换
	
	public void Exchange(char []a,int start,int end,int size){
		// 0 1 2 3 4 5
		// 
		int i=end-size+1;//定义的是  倒数size个的开头索引
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
		System.out.println(9&1);//判断奇数偶数
	}

}
