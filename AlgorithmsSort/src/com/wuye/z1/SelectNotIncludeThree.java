package com.wuye.z1;
//��0~999999�����ҳ�����3�ĸ���
public class SelectNotIncludeThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int count=0;
       for(int i=0;i<=999999;i++){
    	   String s=i+"";
    	   if(s.indexOf('3')==-1){//����3
    		   count++;
    	   }
       }
       System.out.println("��0~999999���治��3�ĸ���"+count);
       System.out.println(Integer.valueOf("888888", 9));
       //����������ת����10����
	}

}
/*�ڶ��ַ���:һλ����8
 *        ��λ����8*9
 *        ��λ����8*9*9
 *        ������������
 *        ��λ����8*9*9*9*9*9
 */
/*�����ַ���:ÿһλ�������ĸ��� 0.9�ܹ�6λ  
 *   0.9^6*1000000 =531441
 * 
 * 
 * */
/*������:��̵ĸı�2 3 ����
 * ����һ��3   
 * ������9��һ����  999999~~~888888�����6λ�Ž���
 * ������ʮ����==531441
 * 
 * 
 * */













