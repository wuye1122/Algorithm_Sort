package com.wuye.array;

public class FindMedian {

	
	/*
	 *   1 两个数组长度相等 且 都是排好顺序的
	 *   
	 *  奇数 arr1[a,b,c,d,e]   arr2[a1,b1,c1,d1,e1]
	 *   
	 *  偶数 arr1[a,b,c,d]   arr2[a1,b1,c1,d1]
	 *   
	 *   进行判断:比较中间值 然后确定筛选范围之后 进行二分查找法
	 * 
	 *   情况一: 对于两个数组mid=mid1
	 * 
	 *         中间数直接返回 c||c1 (无论奇数 偶数)
	 * 
	 *   情况二: 对于 c>c1
	 *   
	 *         分析中位数    :
	 *         
	 *         先看能够判断出大小的: d e在倒数两个因为d最好的情况是前面有六个
	 *                                  abca1b1c1 
	 *                        b1 小于两个数 b1最好情况 aba1b1排到第四
	 *                        
	 *          所以:(a b c) (c1 d1 e1)
	 *              end1=mid1   start2=mid2
	 *              
	 *          如果偶数会出现                  
	 *            (a c)  (c1 d1)
	 *              end1=mid1   start2=mid2+1
	 *              
	 *                         
	 *   情况三: 对于c<c1                      
	 *          
	 *         分析中位数    : 
	 *   
	 *        ()      start1=mid1
	 *      ()        end2=mid2   
	 *   
	 *         ()     start1=mid1+1
	 *       ()       end2=mid2
	 *   
	 *   
	 *   
	 *   
	 * 
	 * */
	
	public int getMidian(int []a,int []b){
		if(a==null||b==null||a.length!=b.length){
			throw new RuntimeException("your is wrong");
		}
		
		int start1=0;
		int end1=a.length-1;
		int mid1=0;
		int start2=0;
		int end2=b.length-1;
		int mid2=0;
		int offset=0;//代表正数负数的
		
		while(start1<end1){
			mid1=(end1+start1)/2;
			 mid2=(end2+start2)/2;
			//奇数偶数 一定要在循环里面 判断每一次剩余奇数还是偶数
			//中分也要每一次 进行分 不然在外面声明会造成数组越界异常
			offset=((end1-start1+1)&1)^1;
			
			
			
			// 错误原因:在于找出奇数偶数的时候 使用的不是最初的长度  而是二分之后的长度
			//
			//
			//
			if(a[mid1]>b[mid2]){
				end1=mid1;
				start2=mid2+offset;
				
			}else if(a[mid1]<b[mid2]){
				start1=mid1+offset;
				end2=mid2;
				
			}else{
				
				return a[mid1];
			}
			
		}
		return Math.min(a[start1], b[start2]);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMedian ff=new FindMedian();
		//位运算。
		System.out.println((6&1)^1);
		System.out.println((5&1)^1);
		System.out.println("------------");
		int a[]={1,2,4,6,8};
		int b[]={2,3,4,9,10};
		//1 2   2   3     4 4 6   8   9 10
		System.out.println(ff.getMidian(a, b));
		int a1[]={2,4,6,8};
		int b1[]={3,4,19,20};
		// 2 3   4 4  6 8 19 20
		System.out.println(ff.getMidian(a1, b1));
		
		
		
		
		
		
		int a2[]={2,5,6,7,10};
		int b2[]={1,2,3,6,7};
		
		// 1 2 2  3 5 6 6 7  7  10//5
		System.out.println(" 大于 "+ff.getMidian(a2, b2));
		int a3[]={2,5,6,7};
		int b3[]={1,2,3,6};
		
		// 1 2 2 3 5 6 6 7   //3
		System.out.println(" 大于  "+ff.getMidian(a3, b3));
		
		
		
		int a4[]={1,2,3,6,7};
		int b4[]={2,5,6,7,10};
		
		//
		System.out.println(" 小于 "+ff.getMidian(a4, b4));
		int a5[]={1,2,3,6};
		int b5[]={2,5,6,7};
		System.out.println(" 小于 "+ff.getMidian(a5, b5));
	}

}
