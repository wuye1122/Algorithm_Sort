package com.weikun.sequencequeue;
/*
 * weikun
 * ˳�����
 * 2011-12-17
 * 
 * 
 */

import java.util.Arrays;

public class SequenceQueue<T> {
	//Ĭ�ϳ���
	private int DEFAULT_SIZE = 10;
	//��������ĳ��ȡ�
	private int capacity;
	//����һ���������ڱ���˳����е�Ԫ��
	private Object[] elementData;
	//����˳�������Ԫ�صĵ�ǰ����
	private int front = 0;//��
	private int rear = 0;//��
	//��Ĭ�����鳤�ȴ�����˳�����
	public SequenceQueue(){
		capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}
	//��һ����ʼ��Ԫ��������˳�����
	public SequenceQueue(T element){
		this();
		elementData[0] = element;
		rear++;
	}
	/**
	 * ��ָ�����ȵ�����������˳�����
	 * @param element ָ��˳������е�һ��Ԫ��
	 * @param initSize ָ��˳����еײ�����ĳ���
	 */
	public SequenceQueue(T element , int initSize){
		this.capacity = initSize;
		elementData = new Object[capacity];
		elementData[0] = element;
		rear++;
	}
	//��ȡ˳����еĴ�С
	public int length(){
		return rear - front;
	}
	//�������
	public void add(T element){
		if (rear > capacity - 1){
			throw new IndexOutOfBoundsException("����ʦ��ʾ�������������쳣");
		}
		elementData[rear++] = element;//rear�Լ�1��rear++���仹��rear
	}
	//�Ƴ����У��������Ƴ�Ԫ��
    public T remove(){
		if (empty()){
			throw new IndexOutOfBoundsException("����ʦ��ʾ���ն����쳣");
		}
		//�������е�rear�˵�Ԫ�ص�ֵ
		T oldValue = (T)elementData[front];
		//�ͷŶ��е�rear�˵�Ԫ�أ�front�Լ�1��front++���仹��front
		elementData[front++] = null; 
		return oldValue;
	}
	//���ض��ж�Ԫ�أ�����ɾ�����ж�Ԫ��
    public T element(){
		if (empty()){
			throw new IndexOutOfBoundsException("����ʦ��ʾ���ն����쳣");
		}
		return (T)elementData[front];
	}
	//�ж�˳������Ƿ�Ϊ�ն���
	public boolean empty(){
		return rear == front;
	}
	//���˳�����
	public void clear(){
		//���ײ���������Ԫ�ظ�Ϊnull
		Arrays.fill(elementData , null);
		front = 0;
		rear = 0;
	}
	public String toString(){
		if (empty()){
			return "[]";
		}
		else{
			StringBuilder sb = new StringBuilder("[");
			for (int i = front  ; i < rear ; i++ ){
				sb.append(elementData[i].toString() + ", ");
			}
			int len = sb.length();
			return sb.delete(len - 2 , len).append("]").toString();
		}
	}
}
