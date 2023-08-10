package com.wuye.queue;

import java.util.Arrays;

public class SequenceQueue<T> {

	
	/*  ������ʱ�����Գ���������һ������
	 * 
	 * 
	 * ����ʵ�ֵĶ���
	 * 
	 * 1  ֻ�����ڱ��β��rear���в�������    �ڱ��ͷ��front����ɾ������ ���еķ���̶� 
	 *  FIFO�����Ա�
	 * 
	 * 2 ���õĲ���:
	 * ������һ�ֱ����Ƶ����Ա� ��˲�����������λ�÷�������
	 * 
	 * 
	 * 3 ˳����� :SequenceQueue ����ʵ��
	 *        
	 *         �����Ĵ洢��Ԫ���δ�Ŵ�front-->rear��������Ԫ��
	 *         ʹ��front �� rear �������α�����¼ ͷβ����  
	 *         rear�ƺ�������һ������Ԫ�ص�����    
	 *         front����������漴��������Ԫ�ص�����
	 *         
	 *         0 1 2 3 4 
	 *         Ԫ�صĸ���   rear-front
	 *         �ײ���õ�����ʵ��  ����Ԫ��λ���ǹ̶��� ��������rear+1 ɾ������front+1
	 *  
	 *  
	 *         ���ڴ��Ҫ����ϸ� ��Ҫ�����Ĵ洢λ�� ����ʱ�临�Ӷ�С Ч�ʸ�
	 *         
	 *  ��ʽ����:LinkQueue
	 *         
	 *         ����ָ��ֻ�Ǵ洢���ݵ�λ�� ��Ϳ������ڴ���������洢  û�б��������洢�Ŀռ�
	 *         ���ڴ�Ҫ���Ǻܸ�
	 *         �����й��ɵ����������  ʱ�临�ӶȱȽ�С Ч�ʱȽϸ�
	 *         �����޹��ɵ����� ʹ����ʽ�洢   ʱ�临�ӶȱȽϴ�  Ч�ʱȽϵ� 
	 * 
	 *     
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	private Object [] os;
	
//	private int front;//ָ���ͷԪ��
//	
//	private int rear;//ָ���β+1������
	
	public static int front;
	public static int rear;
	public SequenceQueue(){
		
		os=new Object[2];
	}
	
	
	//���Ԫ��
	
	public void add(T data){
		if(rear>=os.length){
			//��� �����һ��Ԫ�غ�����Ѿ�����  ��Ϊrear�޴����� 
			throw new IndexOutOfBoundsException("�������� ���������");
		}
		os[rear++]=data;
		//
		//
		//
	}
	
	
	//ɾ������ͷԪ�� ����
	public T remove(){
		if(empty()){
			throw new IndexOutOfBoundsException("����Ϊ�ղ�����ɾ��");
		}
		T o=(T)os[front];
		os[front++]=null;
		return o;
	}
	
	
	
	//�������ض�ͷԪ�ز�ɾ��
	
	public T element(){
		
		return (T)os[front];
	}
	
	
	//����Ԫ�ظ���
	
	public  int length(){
		
		return rear-front;
	}
	
	//����Ϊ��
	
	public boolean empty(){
		return rear==front;
		
	}
	
	//���
	
	public void clear(){
		
		//Arrays.fill(os,null);
		for(int i=0;i<os.length;i++){
			os[i]=null;
		}
		rear=front=0;//���ʱ�� rear��front������0λ�ô�
	}
	
	//toString
	
	
	public String toString(){
		
		
		return Arrays.toString(os);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SequenceQueue<Object> queue=new SequenceQueue<Object>();
		
		System.out.println(queue);
		System.out.println("---front---"+front);
		System.out.println("---rear---"+rear);
		
		queue.add("111");
		System.out.println(queue);
		System.out.println("---front---"+front);
		System.out.println("---rear---"+rear);
	
		
		queue.add("22");
		System.out.println(queue);
		System.out.println("---front---"+front);
		System.out.println("---rear---"+rear);
		//����ӵ�������ʱ�� �Ż��쳣 �Լ���һ�¾�֪����
		
		
//		queue.add("33");
//		System.out.println(queue);
//		System.out.println("---front---"+front);
//		System.out.println("---rear---"+rear);
		
	
//		System.out.println(front);
		
		
//		System.out.println("-----"+queue.element());
//		System.out.println("-----"+queue.remove());
//		System.out.println(queue);
//		System.out.println("-----"+queue.remove());
//		System.out.println(queue);
//		System.out.println(queue.length());
//		System.out.println(queue.element());
//		System.out.println(queue.empty());
//		queue.clear();
//		//System.out.println(queue.remove());
//		System.out.println(queue.empty());
//		System.out.println(front);
//		System.out.println(rear);

		
		
	}

}
