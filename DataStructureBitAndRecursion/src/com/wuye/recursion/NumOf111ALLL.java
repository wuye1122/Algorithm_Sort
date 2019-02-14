package com.wuye.recursion;

public class NumOf111ALLL {

	/* 
	 * rescursion-将数字串转换成字母组合的数量
	 * 
	 * 
	 * 
	 * ***C(3,1)=C(3,2)
	 * 本题的主要难点:C(4,1)=C(4,3)
	 *           C(4,2)=C(4,2) 
	 * 
	 * 
	 * 
	 *  关于暴力递归:要求数组1-9  字母A-Z 
	 *  
	 *  
	 *   
	 *  1111--> AAAA  AAL LAA LL ALA  返回5
	 * 
	 *  P[i]:代表[0,i-1]已结转换完毕     [i,N-1]有几种情况
	 *  
	 *  123   3种 
	 *  
	 *  第一种情况(其他位固定了 i+1,N  就剩一位了 结果不变)
	 *  p[i]='1'-'9' 先令p[i]=p[i+1],因为前者包含后面的元素。
	 *  
	 *   p[1] p[i+1]=BC  X=2  P[i]=2  
	 *   
	 *   
	 *  
	 *    
	 *  
	 *  
	 *  p[i,i+1]="10"-"26" p[i]=p[i]+p[i+2]
	 *  
	 *     p[i+2]=1 MC   P[i]=2+p[i+2]=3
	 *     
	 *     p[i+2]=p[3]=p[length]=1最后一位了。
	 *     
	 *  p[0]=3
	 *  p[1]=2
	 *  p[2]=1
	 *  
	 *  分析:两个递归的分支p(i+1)  p(i+2) 一共是N层
	 *  
	 *     时间复杂度O(2^n)  递归使用的函数栈 空间复杂度O(N);
	 *       
	 *      
	 *       
	 *       
	 *     
	 * 
	 * */
	
	//方法一:
	public int Recusion1(String str){
		if(str.equals("")||str==null){
			return 0;
		}
		char []ch=str.toCharArray();
		return p(ch,0);
	}
	
	
	//定义[i,N-1]有几个可转换的数
	
	public int p(char[]ch,int i){
		if(i==ch.length){
			return 1;//如果i已经达到结尾了 那么i=1就剩一个元素了
		}
		if(ch[i]=='0'){
			return 0;//如果包含0那么不能进行转换			
		}	
		int res=p(ch,i+1);
		if(i+1<ch.length&&((ch[i]-'0')*10+ch[i+1]-'0'<27)){//i一定要是倒数第二位
			res+=p(ch,i+2);		
		}
		return res;	
	}
	
     /*有上述条件我们可以指定 p(i)=p(i+1)+p(i+2)类似斐波那契数列滚动更新	
	
	
	    因为是顺序计算本题的时间复杂度可以到达O(N)
	    因为本题使用的是p(i)判断是否等于0,有状态转移的表达式
	    不可以使用 矩阵乘法进行优化   达到O(logN)
	 112221212121如果这个字符串就可以达到O(logN)   
	    
	    
	    
	    
   	    斐波那契数列是严格按照  p(i)=p(i+1)+p(i+2)的规律 
                使用矩阵乘法可以优化达到O(logN)
	
	
	
	
	*/
	//方法二:
	public int Recusion2(String st){
		if(st==null||st.equals(" ")){
			return 0; 	
		   }
		char []ch=st.toCharArray();
		
		int cur=ch[ch.length-1]=='0'?0:1;
		//代表最后一个元素如果为0则转换不了  如果不为0能转换
		
		int next=1;//next代表  下一次之前  我此时的数量
		int tem=0;//临时变量
		
		for(int i=ch.length-2;i>=0;i--){
			if(ch[i]=='0'){
				next=cur;
				cur=0;
			}
			else {
				
				tem=cur;//临时变量的作用 就是 存住上一次的 值
				        //让此时的cur再去判断  是否 存住两位数的情况
				
				if(i+1<ch.length&&((ch[i]-'0')*10+ch[i+1]-'0'<27)){//i一定要是倒数第二位
					cur+=next;	
				}
				  next=tem;
				
			}
		}
		return cur;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumOf111ALLL rr=new NumOf111ALLL();
		
		System.out.println(rr.Recusion2("1111"));
		
        System.out.println('X'-'A');
	}

}
