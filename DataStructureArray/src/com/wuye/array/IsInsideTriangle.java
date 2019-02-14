package com.wuye.array;

public class IsInsideTriangle {
/*
 * 判断一个点是否在三角形内部
 * 
 * 方法一:使用面积进行判断:但是double会造成结果 点判断失误判断成三角形外部点。
 * 
 * 注意三角形的公式: a b c   p=(a+b+c)/2 ----->  海伦公式
 *  
 *  Math.sqrt((p-a)*(p-b)*(p-c)*p)
 * 
 *   
 *   △abo+△aoc+△obc<=△abc---->则证明o在三角形内部
 * 
 *   
 *  方法二:使用叉积进行判断一个点在边的左侧还是右侧
 *  
 *       向量表示法:头坐标-尾坐标
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
	
	//使用向量进行判断 输入的坐标都是逆时针然后判断其  最终的坐标在其左面
	
	public double crossProduct(double x1,double y1,double x2,double y2){
		
		return x1*y2-x2*y1;//判断的向量 x2 y2在x1 y1的左侧>0
		                   //       x2 y2在x1 y1的右侧<0   
	}
	
	public boolean isInside1(double x1,double y1,double x2,double y2,double x3,double y3,double x,double y){
		
		
		if(crossProduct(x3-x1,y3-y1,x2-x1,y2-y1)>=0){
			//说明  x2 y2在向量13的左侧  1->2->3就是顺时针了不满足条件 
			
			double temx=x2;
			double temy=y2;
			x2=x3;
			y2=y3;
			x3=temx;
			y3=temy;
			
		}
		if(crossProduct(x2-x1,y2-y1,x-x1,y-y1)<0){
			//说明该坐标在 这个线的右侧
			return false;
			
		}
		if(crossProduct(x3-x2,y3-y2,x-x2,y-y2)<0){
			//说明该坐标在 这个线的右侧
			return false;
			
		}
		if(crossProduct(x1-x3,y1-y3,x-x3,y-y3)<0){
			//说明该坐标在 这个线的右侧
			return false;
			
		}
		return true;
		
		
		
		
		
		
		
	}
	
	//首先计算两点间距离
	
	public double getLength(double x1,double y1,double x2,double y2){
		
		return Math.sqrt(Math.abs(x1-x2)*Math.abs(x1-x2)+Math.abs(y1-y2)*Math.abs(y1-y2));
	}
	
	//计算三角行的面积
	
	public double getArea(double x1,double y1,double x2,double y2,double x3,double y3){
		double a=getLength(x1,y1,x2,y2);
		double b=getLength(x1,y1,x3,y3);
		double c=getLength(x2,y2,x3,y3);
		double p=(a+b+c)/2;
		
		return Math.sqrt((p-a)*(p-b)*(p-c)*p);
		
	}
	
	
	//判断这个点是否在其内部
	
	public boolean isInside(double x1,double y1,double x2,double y2,double x3,double y3,double x,double y){
		
		double area=getArea(x1,y1,x2,y2,x3,y3);
		double area1=getArea(x,y,x2,y2,x3,y3);
		double area2=getArea(x1,y1,x,y,x3,y3);
		double area3=getArea(x1,y1,x2,y2,x,y);
		return area1+area2+area3<=area;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
