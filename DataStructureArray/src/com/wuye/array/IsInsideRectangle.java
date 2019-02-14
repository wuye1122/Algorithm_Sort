package com.wuye.array;

public class IsInsideRectangle {
/*
 * 判断一个点是否在矩形内部
 * 
 * 旋转问题:将一个点旋转 ，顺时针旋转@角度
 *      原坐标(x,y)--->(xcos+ysin, -xsin+ycox)
 *      
 *      
 *      假设对图片上任意点(x,y)，绕一个坐标点(rx0,ry0)逆时针旋转a角度后的新的坐标设为(x0, y0)，有公式
 *      x0= (x - rx0)*cos(a) - (y - ry0)*sin(a) + rx0 ;
 *
 *      y0= (x - rx0)*sin(a) + (y - ry0)*cos(a) + ry0 ;
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
	//正常判断一个平行x轴  y轴的矩形的 一点是否在其内部
	//注意 x1 x2 x3 x4按照顺序来  一定注意 x1---x3是对角线.
	
	public boolean isInside(double x1,double y1,double x3,double y3 ,double x,double y){
		
		if(x<x1){
			return false;
		}
		if(y<y1){
			return false;
		}
		if(y<y3){
			return false;
		}
		if(x>x3){
			return false;
		}
		return true;
	}
	
	public boolean inside1(double x1,double y1,double x2,double y2,double x3,double y3,double x4,double y4,double x,double y){
		//四个点的坐标且他们是不平行的e
		if(y1==y2){
			return isInside(x1,y1,x3,y3,x,y);
		}
		double l=Math.abs(x3-x4);
		double r=Math.abs(y3-y4);
		double s=Math.sqrt(l*l+r*r);
		double sin=l/s;
		double cos=r/s;
		double x1r=cos*x1+sin*y1;
		double y1r=-sin*x1+cos*y1;
		double x4r=cos*x4+sin*y4;
		double y4r=-sin*x4+cos*y4;
		
		double xr=cos*x+sin*y;
		double yr=-sin*x+cos*y;
		return isInside(x1r,y1r,x4r,y4r,xr,yr);
		
		
	}
	//不规则的判断 则需要将矩形变成规则的
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
