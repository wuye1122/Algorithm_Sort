package com.weikun.command;
/*
 * 
 * �ṹ��
������ģʽ�������ֽ�ɫ
�����ߣ���������һ�����ʵ������ʵ������ִ����������صĲ���
���������һ���ӿڣ��涨��������װ��������ɸ�������
�����������������ʵ������ӿڵ����ʵ���������������ʵ������ӿ��еķ�����
�����ߣ���������һ������������ӿڡ����������ʵ����
�������еġ�����ӿڵı������Դ���κξ�����������ã������߸�����þ�������þ�������ִ����Щ��װ������ķ���
 */
public class Test {


	public static void main(String[] args) {  
		Receiver receiver = new Receiver();  //ִ����  
		Command command = new ConcreteCommand(receiver); //����;�������  
		Invoker invoker = new Invoker(); //������  
		invoker.startExceuteCommand(command); //�������´�����  
	}  


}
