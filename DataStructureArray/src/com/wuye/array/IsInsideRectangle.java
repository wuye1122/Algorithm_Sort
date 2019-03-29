package com.wuye.array;

public class IsInsideRectangle {
/*
 * �ж�һ�����Ƿ��ھ����ڲ�
 * 
 * ��ת����:��һ������ת ��˳ʱ����ת@�Ƕ�
 *      ԭ����(x,y)--->(xcos+ysin, -xsin+ycox)
 *      
 *      
 *      �����ͼƬ�������(x,y)����һ�������(rx0,ry0)��ʱ����תa�ǶȺ���µ�������Ϊ(x0, y0)���й�ʽ
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
	//�����ж�һ��ƽ��x��  y��ľ��ε� һ���Ƿ������ڲ�
	//ע�� x1 x2 x3 x4����˳����  һ��ע�� x1---x3�ǶԽ���.
	
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
		//�ĸ���������������ǲ�ƽ�е�e
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
	//��������ж� ����Ҫ�����α�ɹ����
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
