package com.date.Doublelist;



public class DouList<T> {
     private class Node{
    	 private T date;
    	 private Node pre;
    	 private Node next;
    	@SuppressWarnings("unused")
		public Node(){
    		
    	}
    	 
    	 public Node(T element,Node pre,Node next){
    		 this.date=element;
    		 this.pre=pre;
    		 this.next=next;
    	 }   	 
     }    
	
	 private Node header;
	 private Node tail;
	 private int size;
	 
	public DouList(){
		
	}
    public DouList(T element ){
		header=new Node(element,null,null);
		tail=header;
		size++;
	}
//    public H(){
//		//������header��tail����null
//		header = null;
//		tail = null;
//	}
	
	public int length(){
		return size;
	}
	//��������index��ȡָ��λ�õĽڵ�
	
	private Node getNodeByIndex(int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("Խ����");
		}
		//0 1 2 3 4 5 6 7 8    size=9
		//
		//0 1 2 3 4��ͷ��ʼ/                     5 6 7 8��β��ʼ/
		if(index<=size/2){
			Node current=header;
			             //4.5
			for(int i=0;i<size/2&&current!=null;i++,current=current.next){
				if(index==i){
					return current;
				}

			}				
		}
		else {
			Node current=tail;
			//4.5
			for(int i=size-1;i>size/2&&current!=null;i--,current=current.pre){
				if(index==i){
					return current;
				}

			}			
			
		}
		return null;	
	}
	//��ȡ��ʽ���Ա�������Ϊindex����Ԫ��	
	public T get(int index){
		return  getNodeByIndex(index).date;
	}
	//������ʽ���Ա���ָ��Ԫ�ص�����
	public int findElement(T element){
		Node current=header;
		
		for(int i=0;i<size&&current!=null;i++,current=current.next){
			if(current.date.equals(element)){
				return i;
			}
		}
		
		return -1;
		
		
	}
	//��������	
	public void add(T element){
		if(header==null){
		header=new Node(element,null,null);
		tail=header;
		}else{
			
			Node newNode=new Node(element,tail,null);
			//<---
			tail.next=newNode;
			//-->
			tail=newNode;
			//   -->
			// /
		}
		size++;
	}
	
	
	
	public void addHeader(T element){
		Node  newNode=new Node(element,null,header);
		//-->
		header.pre=newNode;
		//<--
		header=newNode;
		//<--
		//   \
		
		if(header==null){
			tail=header;
		}
		size++;
	}
	

	
	
	//��������ʽ���ָ��λ�ò���һ��Ԫ�ء�
	public void insert(T element,int index){
		if(index<0||index>size){
			throw new IndexOutOfBoundsException("Խ����");
		}
		if(header==null){
			add(element);
		}else if(index==0){
         addHeader(element);

		}
		else{
			
			//��ȷ������Ľڵ�ǰ��   �����ݲ������зֱ���ǰ���ָ��  Ȼ�����ߵĽڵ���ָ���м�
             Node pre=getNodeByIndex(index-1);//�ڵ�ǰ
             
             Node next=pre.next;//�ڵ��
             
             Node newNode=new Node(element,pre,next);
             
             pre.next=newNode;
             next.pre=newNode;
             size++;
		}
  
	}
	//------------------------------------
			
//else{//ɾ���м䣬ɾ��β��
//		current=this.getNodeByIndex(index);//�ҵ���ǰ�ڵ�					
//		current.prev.next=current.next;
//		if(index!=size-1){//β���
//			current.next.prev=current.prev;
//		}
//		
//		current.next=null;
//		current.prev=null;
//	
		//------------------------------------
	
	
	
	
	
	
	
	
	
	
	//�˴�ɾ���д���
	//ɾ����ʽ���Ա���ָ����������Ԫ��
	public T delete(int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("Խ����");
		}
		Node del=null;
		if(index==0){
			del=header;
			header=header.next;
			
			header.pre=null;
			del.next=null;	

			
			

		}else{

			Node pre=getNodeByIndex(index-1);

			del=pre.next;
//    pre del 
//
//			
			pre.next=del.next;

			if(del.next!=null){
				del.next.pre=pre;
			}
			//�����
			del.next=null;
			del.pre=null;
		}
		size--;
		return del.date;
	}
	//����ɾ����Ĵ���
  public T remove(){
	  return delete(size-1);
	  
  }
  public boolean empty(){
	  return size==0;
  }
	public void clear(){
		header=null;
		tail=null;
		size=0;
	}
	
	//����&&��ת
	public String toString(){
		if(empty()){
			return "[]";
		}else{
			StringBuilder sb=new  StringBuilder("[");
			for(Node current=header;current!=null;current=current.next){
				
				sb.append(current.date.toString()+",");
			}
			int len=sb.length();
			return sb.delete(len-1, len).append("]").toString();
		}
				
	}
	public String AtoString(){
		if(empty()){
			return "[]";
		}else{
			StringBuilder sb=new  StringBuilder("[");
			
			for (Node current = tail ; current != null 
				; current = current.pre ){
				sb.append(current.date.toString() + ",");
			}
			int len=sb.length();
			return sb.delete(len-1, len).append("]").toString();
		}
				
	}



	






}
