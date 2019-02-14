package com.wuye.recursion;

public class Jump {
  
	/* 
	 *  recursion- 跳跃游戏。
	 *  
	 *  
	 *   a[i]=k 代表数组i处的数可以向右跳跃k次
	 *   
	 *   求一个数组从O开始跳跃次数最小到达最后的位置
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
		int jump=0;//代表跳了几次
		int cur=0;//当前位置
		int next=0;//代表最远能跳到哪
		for(int i=0;i<a.length;i++){
			if(cur<i){
				//再跳一次
				jump++;
				
				//cur第一次跳的时候i=1时候 
				//第二次跳是 i遍历超过了当前位置
				cur=next;
			}
			
			//next代表最远能跳到哪
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
