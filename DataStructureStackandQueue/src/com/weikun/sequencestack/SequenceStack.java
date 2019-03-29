package com.weikun.sequencestack;


import java.util.Arrays;
/**
 * weikun
 * ˳��ջ��ʹ������ʵ��
 * 2011-12-17
 * 
 * ѧ���ڿ��ļ�����æ�ų���
 */
public class SequenceStack<T>{
	private int DEFAULT_SIZE = 10;
	//��������ĳ��ȡ�
	private int capacity;
	//���嵱�ײ�������������ʱ������ÿ�����ӵ����鳤��
	private int capacityIncrement = 0;
	//����һ���������ڱ���˳��ջ��Ԫ��
	private Object[] elementData;
	//����˳��ջ��Ԫ�صĵ�ǰ����
	private int size = 0;
	//��Ĭ�����鳤�ȴ�����˳��ջ
	public SequenceStack(){
		capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}
	//��һ����ʼ��Ԫ��������˳��ջ
	public SequenceStack(T element){
		this();
		elementData[0] = element;
		size++;
	}
	/**
	 * ��ָ�����ȵ�����������˳��ջ
	 * @param element ָ��˳��ջ�е�һ��Ԫ��
	 * @param initSize ָ��˳��ջ�ײ�����ĳ���
	 */
	public SequenceStack(T element , int initSize){
		this.capacity = initSize;
		elementData = new Object[capacity];
		elementData[0] = element;
		size++;
	}
	/**
	 * ��ָ�����ȵ�����������˳��ջ
	 * @param element ָ��˳��ջ�е�һ��Ԫ��
	 * @param initSize ָ��˳��ջ�ײ�����ĳ���
	 * @param capacityIncrement ָ����˳��ջ�ײ�����ĳ��Ȳ���ʱ���ײ�����ÿ�����ӵĳ���
	 */
	public SequenceStack(T element , int initSize
		, int capacityIncrement){
		this.capacity = initSize;
		this.capacityIncrement = capacityIncrement;
		elementData = new Object[capacity];
		elementData[0] = element;
		size++;
	}
	//��ȡ˳��ջ�Ĵ�С
	public int length(){
		return size;
	}
	//��ջ
	public void push(T element){
		ensureCapacity(size + 1);
		elementData[size++] = element;
	}
	//���鷳���������ܺܲ�
	private void ensureCapacity(int minCapacity){
		//��������ԭ�г���С��Ŀǰ����ĳ���
		if (minCapacity > capacity)	{
			if (capacityIncrement > 0)	{
				while (capacity < minCapacity){
					//���ϵؽ�capacity���ȼ�capacityIncrement��
					//ֱ��capacity����minCapacityΪֹ
					capacity += capacityIncrement;
				}
			}
			else{
				//���ϵؽ�capacity * 2��ֱ��capacity����minCapacityΪֹ
				while (capacity < minCapacity){
					capacity <<= 1;
				}
			}
			elementData = Arrays.copyOf(elementData , capacity);
		}
	}
	//��ջ
    public T pop(){
		T oldValue = (T)elementData[size - 1];
		//�ͷ�ջ��Ԫ��
		elementData[--size] = null; 
		return oldValue;
	}
	//����ջ��Ԫ�أ�����ɾ��ջ��Ԫ��
    public T peek(){
		return (T)elementData[size - 1];
	}
	//�ж�˳��ջ�Ƿ�Ϊ��ջ
	public boolean empty(){
		return size == 0;
	}
	//���˳��ջ
	public void clear(){
		//���ײ���������Ԫ�ظ�Ϊnull
		Arrays.fill(elementData , null);
		size = 0;
	}
	public String toString(){
		if (size == 0){
			return "[]";
		}
		else{
			StringBuilder sb = new StringBuilder("[");
			for (int i = size - 1  ; i > -1 ; i-- ){
				sb.append(elementData[i].toString() + ", ");
			}
			int len = sb.length();
			return sb.delete(len - 2 , len).append("]").toString();
		}
	}
}
