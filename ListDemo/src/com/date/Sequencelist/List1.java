package com.date.Sequencelist;

import java.util.Arrays;

public class List1 <T>{
 
     //����ȫ˽�� �������������	
	private final int DEFUALT_SiZE=16;//�����ʹ��ȫ��д
	
	private int  Capacity;//���Ա�������
	
	
	private Object[] elementDate;//�������Ա������
	
	private int size;//Ԫ�س���
	
	//��Ĭ�����鳤�ȴ�����˳�����Ա�
	public List1(){
		this.Capacity=this.DEFUALT_SiZE;
		this.elementDate=new Object[this.Capacity];
		
	} 
	
//��һ����ʼ��Ԫ�����������Ա�
	
	public List1(T element){
		this();
		elementDate[0]=element;
		size++;
		
	}

/**
 * ��ָ�����ȵ�����������˳�����Ա�
 * @param element ָ��˳�����Ա��е�һ��Ԫ��
 * @param initSize ָ��˳�����Ա�ײ�����ĳ���
 */
	public List1(T element ,int initSize){
		this.Capacity=1;
		while(this.Capacity<initSize){
			this.Capacity<<=1;//�����ܳ���Ҫ���ڱ�Ԫ�س���  ����2^n
			//���ܲ��� this.Capacity*=2;
		}
	elementDate=new Object[this.Capacity];//����Ҫ�ȶ���
	elementDate[0]=element;//�ٸ�ֵ
	     size++;
		
	}
	//����Ԫ�س���
	public int length(){
		return size;
	}
	//Ҫ�����Ԫ�� ������������������1
	//��������Ҫ������ԭ�������С�Ƚ�
	private void ensureCapacity(int need){
		if(Capacity<need){
			while(Capacity<need){
				Capacity<<=1;//��������������
				
			}
		}
		elementDate=Arrays.copyOf(elementDate, Capacity);
	}
	
	//����
	public void insert(T element,int index){  //����һ��Ԫ��
		if(index<0||index>size){/// 0 1 2  3 [0 3]
			throw new  IndexOutOfBoundsException("���Ա�����Խ��");
		}
		ensureCapacity(Capacity+1);//����һ��
	System.arraycopy(elementDate, index, elementDate, index+1, size-index);
	elementDate[index]=element;
	size++;
		
	}
	//����
	public void  add(T element){
		insert(element,size);//iiii 0
	}
	

		//����ĳ����������Ԫ��
	
	@SuppressWarnings("unchecked")
	public T get(int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("����ҵ�����Խ����");
		}
		
		return   (T)elementDate[index];
		
		
	}
		//����˳�����Ա���ָ��Ԫ�ص�����
	
	public int findIndex(T element){
		
		for(int i=0;i<=size-1;i++){
			if(elementDate[i].equals(element)){
				
				return i;
			}
			
		}
		return -1;
	}
		//ɾ��ָ����������Ԫ��
		public T delete(int index){//toString�������
			if(index<0||index>size-1){
				throw new IndexOutOfBoundsException("����ʦ��ʾ�����Ա�����Խ��");
				}
			@SuppressWarnings("unchecked")
			T old=(T)elementDate[index];
			int num=size-index-1;
			if(num>0){
			System.arraycopy(elementDate, index+1, elementDate, index, num);
			}
			elementDate[--size]=null;
			return old;
		}
		
		
		
		
		
		//ɾ��˳�����Ա������һ��Ԫ��
		public T remove(){
			return delete(size-1);
		}
		
		//�ж�˳�����Ա��Ƿ�Ϊ�ձ�
		public boolean empty(){
			return size==0;
		}
		//������Ա�
		public void clear(){
			Arrays.fill(elementDate, null);
			size=0;
		}
		//����ı���
		public String  toString(){
			if(size==0){
				return "[]";
				
			}
			else{
				StringBuilder sb=new  	StringBuilder("[");
				for(int i=0;i<size;i++){
					
					sb.append(elementDate[i].toString()+",");
					 //������д�������� ����һ���ո�
				}
				int l=sb.length();//ɾ���Ҳ�С����  length����ֵ�ù�ע��������
				return sb.delete(l-1, l).append("]").toString();
			}
			
			}
			//�Զ������
		public void  toString1(){
			if(size==0){
				System.out.print("[]");
			}
			else{//else if  �� if ��һ��
				for(int i=0;i<size;i++){
					if(i==0){
						System.out.print("[");
					}
					if(i==size-1){
						System.out.print(elementDate[i]+"]");
					}
					else{
						System.out.print(elementDate[i]+",");}
				}
			}
		
} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}