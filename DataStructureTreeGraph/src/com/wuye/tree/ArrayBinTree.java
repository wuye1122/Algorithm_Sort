package com.wuye.tree;

public class ArrayBinTree<T> {

/*	˳��洢 �ȽϺķ������ڴ�

    һ�����Ϊi�Ķ����� �����2^i  -1���ڵ� ��˶���һ����2^i-1��������


     A BC DEFG ��������˳��洢

     (��ͨ�������Ķ�˳��洢���˷ѿռ�)
     
     
     
     */
	private int size;//��¼�ڵ����
	
	//���ڴ洢������������
	private Object nodes[];
	
	//�����������
	private int deep;
	
	//���������Ľڵ�����
	private int treesize;
	
	
	//ͨ�����  �� ��һ�����ݽ���������ģ��
	ArrayBinTree(int deep,T data){
		
		this.deep=deep;
		this.treesize=(int)Math.pow(2, deep)-1;
		
		nodes=new Object[treesize];
		
		nodes[0]=data;
		
		size++;
	} 
	
	
	
	//���� ���ڵ�������  ���� ���Ƿ������ڵ� ���µ�Ԫ�ز�������
	public void addNode(int index,T data,boolean left){
		
		//������ڵ������
		if(nodes[index]==null){
			throw new RuntimeException("������ָ�����ڵ�");
		}
		if(index*2+1>=treesize){
			throw new RuntimeException("�����Ѿ�����  �������");	
		}
		//Ϊ�ø��ڵ���� �ӽڵ�
		if(left){
			nodes[index*2+1]=data;
		}else{
			nodes[index*2+2]=data;
		}	
		size++;
	}
	
	 //���ظ��ڵ�
	public T getRoot(){
		return (T)nodes[0];
		
	}
	
	//�����������
	public int getDeep(){
		
		return this.deep;
		
	}
	
	//����ָ��Ԫ�ص�λ��
	public int getPos(T data){
		for(int i=0;i<treesize;i++){
			if(nodes[i]!=null&&nodes[i].equals(data)){
				return i;
			}
			
		}
		return -1;
		
	}
	
	//�ж����Ƿ�Ϊnull
	public boolean empty(){
		return nodes[0]==null;
	}
	
	//����ָ�������ĸ��ڵ�
	public T parent(int index){
		if(index==0||index>=size){
			return (T)"�����쳣";
		}
		return (T)nodes[(index-1)/2];
	}
	//����ָ����������ڵ�
	public T getLeft(int index){
		if(index*2+1>=treesize){
			throw new RuntimeException("���������ӽڵ�");	
		}
		return  (T)nodes[index*2+1];
	}
	//����ָ���������ҽڵ�
	public T getRight(int index){
		if(index*2+1>=treesize){
			throw new RuntimeException("���������ӽڵ�");	
		}
		return  (T)nodes[index*2+2];
	}

	
	public String toString(){
		
		return java.util.Arrays.toString(nodes);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayBinTree ab=new ArrayBinTree(3,"A");
		
		ab.addNode(0, "B", true);
		ab.addNode(0, "C", false);
		ab.addNode(1, "D", true);
		ab.addNode(1, "E", false);
		System.out.println("�����ʾ������:");
		for(int i=0;i<ab.treesize;i++){
			System.out.print(ab.nodes[i]);
		}
		System.out.println("");
		System.out.println("�Ƿ�Ϊnull:"+ab.empty());	
		System.out.println("���ڵ�:"+ab.getRoot());
		System.out.println("�������:"+ab.getDeep());
		System.out.println("");
		System.out.println("getPos():"+ab.getPos("A"));
		System.out.println("getPos():"+ab.getPos("B"));
		System.out.println("getPos():"+ab.getPos("C"));
		System.out.println("getPos():"+ab.getPos("D"));
		System.out.println("getPos():"+ab.getPos("E"));
		System.out.println("getPos():"+ab.getPos("null"));
		System.out.println("");
		
		System.out.println("ָ���ڵ�ĸ��ڵ�:"+ab.parent(0));
		System.out.println("ָ���ڵ�ĸ��ڵ�:"+ab.parent(1));
		System.out.println("ָ���ڵ�ĸ��ڵ�:"+ab.parent(2));
		System.out.println("ָ���ڵ�ĸ��ڵ�:"+ab.parent(3));
		System.out.println("ָ���ڵ�ĸ��ڵ�:"+ab.parent(4));
		System.out.println("ָ���ڵ�ĸ��ڵ�:"+ab.parent(5));
		System.out.println("ָ���ڵ�ĸ��ڵ�:"+ab.parent(6));
		System.out.println("���Ľڵ����:"+ab.size);
		System.out.println("");
		System.out.println("ָ���ڵ�����ӽڵ�:"+ab.getLeft(0));
		System.out.println("ָ���ڵ�����ӽڵ�:"+ab.getRight(0));
		System.out.println("ָ���ڵ�����ӽڵ�:"+ab.getLeft(1));
		System.out.println("ָ���ڵ�����ӽڵ�:"+ab.getRight(1));
		System.out.println("ָ���ڵ�����ӽڵ�2:"+ab.getLeft(2));
		System.out.println("ָ���ڵ�����ӽڵ�2:"+ab.getRight(2));
		
		try {
			System.out.println("ָ���ڵ�����ӽڵ�3:"+ab.getLeft(3));
			System.out.println("ָ���ڵ�����ӽڵ�3:"+ab.getRight(3));
		} catch (Exception e) {
			// TODO: handle exception
		   System.out.println("�ڵ����������쳣");
		}
		
		
		
		
		
		
	}

}
