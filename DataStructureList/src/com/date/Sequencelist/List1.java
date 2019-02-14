package com.date.Sequencelist;

import java.util.Arrays;

public class List1 <T>{
 
     //属性全私有 方法大多数公共	
	private final int DEFUALT_SiZE=16;//不变的使用全大写
	
	private int  Capacity;//线性表总容量
	
	
	private Object[] elementDate;//保存线性表的数组
	
	private int size;//元素长度
	
	//以默认数组长度创建空顺序线性表
	public List1(){
		this.Capacity=this.DEFUALT_SiZE;
		this.elementDate=new Object[this.Capacity];
		
	} 
	
//以一个初始化元素来创建线性表
	
	public List1(T element){
		this();
		elementDate[0]=element;
		size++;
		
	}

/**
 * 以指定长度的数组来创建顺序线性表
 * @param element 指定顺序线性表中第一个元素
 * @param initSize 指定顺序线性表底层数组的长度
 */
	public List1(T element ,int initSize){
		this.Capacity=1;
		while(this.Capacity<initSize){
			this.Capacity<<=1;//数组总长度要大于表元素长度  且是2^n
			//性能不好 this.Capacity*=2;
		}
	elementDate=new Object[this.Capacity];//数组要先定义
	elementDate[0]=element;//再赋值
	     size++;
		
	}
	//返回元素长度
	public int length(){
		return size;
	}
	//要想插入元素 必须先扩大容量增加1
	//看看所需要数组与原来数组大小比较
	private void ensureCapacity(int need){
		if(Capacity<need){
			while(Capacity<need){
				Capacity<<=1;//整倍整倍的扩大
				
			}
		}
		elementDate=Arrays.copyOf(elementDate, Capacity);
	}
	
	//插入
	public void insert(T element,int index){  //看第一个元素
		if(index<0||index>size){/// 0 1 2  3 [0 3]
			throw new  IndexOutOfBoundsException("线性表索引越界");
		}
		ensureCapacity(Capacity+1);//后退一格
	System.arraycopy(elementDate, index, elementDate, index+1, size-index);
	elementDate[index]=element;
	size++;
		
	}
	//增加
	public void  add(T element){
		insert(element,size);//iiii 0
	}
	

		//返回某个索引处的元素
	
	@SuppressWarnings("unchecked")
	public T get(int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("你查找的内容越界了");
		}
		
		return   (T)elementDate[index];
		
		
	}
		//查找顺序线性表中指定元素的索引
	
	public int findIndex(T element){
		
		for(int i=0;i<=size-1;i++){
			if(elementDate[i].equals(element)){
				
				return i;
			}
			
		}
		return -1;
	}
		//删除指定索引处的元素
		public T delete(int index){//toString在最后面
			if(index<0||index>size-1){
				throw new IndexOutOfBoundsException("卫老师提示：线性表索引越界");
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
		
		
		
		
		
		//删除顺序线性表中最后一个元素
		public T remove(){
			return delete(size-1);
		}
		
		//判断顺序线性表是否为空表
		public boolean empty(){
			return size==0;
		}
		//清空线性表
		public void clear(){
			Arrays.fill(elementDate, null);
			size=0;
		}
		//神奇的遍历
		public String  toString(){
			if(size==0){
				return "[]";
				
			}
			else{
				StringBuilder sb=new  	StringBuilder("[");
				for(int i=0;i<size;i++){
					
					sb.append(elementDate[i].toString()+",");
					 //老卫这写的有问题 多了一个空格
				}
				int l=sb.length();//删除右侧小括号  length长度值得关注？？？？
				return sb.delete(l-1, l).append("]").toString();
			}
			
			}
			//自定义遍历
		public void  toString1(){
			if(size==0){
				System.out.print("[]");
			}
			else{//else if  和 if 不一样
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