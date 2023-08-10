package com.wuye.array;

public class IsInsideTriangle {
/*
 * �ж�һ�����Ƿ����������ڲ�
 * 
 * ����һ:ʹ����������ж�:����double����ɽ�� ���ж�ʧ���жϳ��������ⲿ�㡣
 * 
 * ע�������εĹ�ʽ: a b c   p=(a+b+c)/2 ----->  ���׹�ʽ
 *  
 *  Math.sqrt((p-a)*(p-b)*(p-c)*p)
 * 
 *   
 *   ��abo+��aoc+��obc<=��abc---->��֤��o���������ڲ�
 * 
 *   
 *  ������:ʹ�ò�������ж�һ�����ڱߵ���໹���Ҳ�
 *  
 *       ������ʾ��:ͷ����-β����
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
	
	//ʹ�����������ж� ��������궼����ʱ��Ȼ���ж���  ���յ�������������
	
	public double crossProduct(double x1,double y1,double x2,double y2){
		
		return x1*y2-x2*y1;//�жϵ����� x2 y2��x1 y1�����>0
		                   //       x2 y2��x1 y1���Ҳ�<0   
	}
	
	public boolean isInside1(double x1,double y1,double x2,double y2,double x3,double y3,double x,double y){
		
		
		if(crossProduct(x3-x1,y3-y1,x2-x1,y2-y1)>=0){
			//˵��  x2 y2������13�����  1->2->3����˳ʱ���˲��������� 
			
			double temx=x2;
			double temy=y2;
			x2=x3;
			y2=y3;
			x3=temx;
			y3=temy;
			
		}
		if(crossProduct(x2-x1,y2-y1,x-x1,y-y1)<0){
			//˵���������� ����ߵ��Ҳ�
			return false;
			
		}
		if(crossProduct(x3-x2,y3-y2,x-x2,y-y2)<0){
			//˵���������� ����ߵ��Ҳ�
			return false;
			
		}
		if(crossProduct(x1-x3,y1-y3,x-x3,y-y3)<0){
			//˵���������� ����ߵ��Ҳ�
			return false;
			
		}
		return true;
		
		
		
		
		
		
		
	}
	
	//���ȼ�����������
	
	public double getLength(double x1,double y1,double x2,double y2){
		
		return Math.sqrt(Math.abs(x1-x2)*Math.abs(x1-x2)+Math.abs(y1-y2)*Math.abs(y1-y2));
	}
	
	//���������е����
	
	public double getArea(double x1,double y1,double x2,double y2,double x3,double y3){
		double a=getLength(x1,y1,x2,y2);
		double b=getLength(x1,y1,x3,y3);
		double c=getLength(x2,y2,x3,y3);
		double p=(a+b+c)/2;
		
		return Math.sqrt((p-a)*(p-b)*(p-c)*p);
		
	}
	
	
	//�ж�������Ƿ������ڲ�
	
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
