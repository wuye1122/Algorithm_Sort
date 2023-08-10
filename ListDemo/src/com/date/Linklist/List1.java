package com.date.Linklist;

public class List1<T> {
       //node��һ����
	private class Node{
		private T date;
		
		private Node next;
		
		private Node(){
			
		}
		
		private Node(T date,Node next){
			this.date=date;
			this.next=next;
			
		}
	}//�ڵ����Լ�����
		
		private Node header;
		private Node tail;
		private int size;
	   //��
	    public List1(){
	    header=null;
	    tail=null;
	   }
	    //һ��Ԫ�� ����
	    public List1(T element){
	    	header=new Node(element,null);//.next  .date�ڹ������������Ѿ�����
	    	tail=header;
	    	size++;
	    }
	
	//����
	    public int length(){
	    	return size;
	    }
	
		//����β�巨Ϊ��������½ڵ㡣	    
	    
	    public void add(T element){
	    	//��
	    	if(header==null){
	    		header=new Node(element,null);
	    		tail=header;
	    	}else{
	    		//�½�һ��
	    		Node	newNode=new Node(element,null);
	    		tail.next=newNode;
	    		tail=newNode;
	    	}
	    	size++; 
	    }   

	    //����ͷ�巨Ϊ��������½ڵ㡣
	    
	    public void addHeader(T element){  

	    	header=new Node(element,header);
	    	if(tail==null){
	    		tail=header;
	    	}
	    	size++;
	    } 
	  //��������index��ȡָ��λ�õĽڵ�
		private Node getNodeByIndex(int index){
	    	if(index<0||index>size){
	    		try {
					throw new Exception();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	Node currentNode=header;
	    	for(int i=0;i<size&&currentNode!=null;i++,currentNode=currentNode.next){
	    		if(i==index){
	    			return currentNode;
	    		}
	    	}
			return null;
	    	
	    	
	    } 
	    
	  //��ȡ��ʽ���Ա�������Ϊindex����Ԫ�� 
	    
	    public T get(int index){
	    	return getNodeByIndex(index).date;
	    }
	    
	    //������ʽ���Ա���ָ��Ԫ�ص����� 
	    public int FindElement(T element){
	    	Node current=header;
	    	for(int i=0;i<size&&current!=null;i++,current=current.next){
	    		if(current.date.equals(element)){
	    			return i;
	    		}
	    	}
	    	return -1;
	    }

	    
	//��ĳ����������Ԫ��
	    
	    public void Insert(T element,int index){
	    	if(index<0||index>size-1){
	    		throw new IndexOutOfBoundsException("����ʦ��ʾ�����Ա�����Խ��");
	    	}
	    	if(header==null){
	    		 add(element);
	    		
	    	}else{
	    		if(index==0){
	    			addHeader(element);
	    			
	    		}else{
	    			//ȡ��ǰһ���ڵ�
	    			Node pre=getNodeByIndex(index-1);
	    			//��prev��nextָ���½ڵ㣬���½ڵ��next����ָ��ԭ��prev����һ���ڵ�
	    			pre.next=new Node(element,pre.next);
	    			size++;
	    		}
	    		
	    	}
	    	
	    }

	    
	    
	    //ɾ����ʽ���Ա���ָ����������Ԫ��
	    public T delete(int index){
	    	if(index<0||index>size-1){
	    		throw new IndexOutOfBoundsException("����ʦ��ʾ�����Ա�����Խ��");
	    	}

	    	Node del=null;
	    	if(index==0){
	    		del=header;
	    		header=header.next;
	    	}
	    	else{
	    		Node pre=getNodeByIndex(index-1);
	    		//���ù�ϵ
	    		del=pre.next;
	    		pre.next=del.next;
	    		del.next=null;
	    	}
	    	size--;
	    	return del.date;
	    }
	    
	  //ɾ����ʽ���Ա������һ��Ԫ��
	    public T remove(){
			return delete(size-1);
	    	
	    }
	    
	    
	  //�ж���ʽ���Ա��Ƿ�Ϊ�ձ�
	    public boolean empty(){
	    	return size==0;
	    }
		//������Ա�
	    public void clear(){
	    	
	    	header=null;
	    	tail=null;
	    	size=0;
	    }
	    
	    //����

	    public String toString(){
	    	if(empty()){

	    		return "[]";

	    	}else {
	    		StringBuilder sb=new StringBuilder("[");

	    		for(Node current=header;current!=null;current=current.next){

	    			sb.append(current.date.toString()+",");
	    		}
	    		int len=sb.length();
	    		return sb.delete(len-1, len).append("]").toString(); 
	    	}
	    }  

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
