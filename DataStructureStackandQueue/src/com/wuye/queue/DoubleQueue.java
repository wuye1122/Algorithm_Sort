package com.wuye.queue;



public class DoubleQueue<D> {
     /*
      * ˫�����:����������ͬʱ���в���ɾ�� 
      * 
      * Deque�� Stack��  Queue�����ӿڵ��ӽӿ�
      * �ȿ��Ե��ɶ���ʹ��Ҳ���Ե���ջʹ��
      * 
      * ArrayDeque:����˳��洢��˫�����
      * 
      * LinkedList:������ʽ�洢��˫����У�Ҳ�ǽӿ�list��ʵ���ࡣ
      * 
      * LinkedBlockingList:�̰߳�ȫ��ʽ�ṹ˫�����
      * 
      * ���ֳ����ķ���
      * 
      *    int size:����˫����еĳ��ȡ�
      * 
      *    displayFront: displayRear
      *    
      *    insertFront : insertRear
      *    
      *    empty():�ж��Ƿ�Ϊ��
      *    
      *    peekFront: peekRear
      *    
      *    removeFront:  removenRear
      * 
      * һ��java�����Queue
      * 
      * public interface Queue<> extends interface collection
      * 
      *   ����ÿ���������ṩ������ʽ: һ���׳��쳣  ��һ�ַ���һ�������ֵnull false
      *   
      *   ����ͨ����FIFO�����Ԫ��: �������ȶ��� LIFO(�� ջ)����
      *   
      *   
      *   1���ȶ���ͨ���Ƚ�����Ԫ�ص���Ȼ˳���������
      *   2�������պ���ȳ��ķ�ʽ��Ԫ�ؽ�������
      *   
      * 
      * �Ƚ��ȳ�����:����FIFO���Եļ���
      * 
      *    ��Ҫԭ��:ʹ�ü��ϱ���Ԫ�ص�ͬʱ ���������˳��,
      *          ʹ��������˳��ͳ��е�˳����ͬ
      *          ���в������������Ԫ�� 
      *  
      * 
      * 
      * 
      * 
      * 
      * 
      * 
      * */
	
	
	//����ڵ�
	
	private class Node{
		
		public Node next;
		
		public Node previous;
		
		D data;
		
		Node(D data){
			this.data=data;
			
		}
		
		void display(){
			System.out.print(data.toString()+"--");
		}
		
	}
	
	
	//���������ڵ�ͷβ
	
	private Node head;
	
	
	private Node tail;
	
	//�ж��Ƿ�Ϊ��
	public boolean empty(){
		
		return head==null;
		
	}
	
	
	//��������˼�������
	
	
	public void insertHead(D data){
		Node newNode=new Node(data);
		if(empty()){
			tail=newNode;
			
		}else{
			
			head.previous=newNode;
			
		}
		newNode.next=head;
		
		head=newNode;
	}
	
	
	
	
	public void insertTail(D data){
		
		Node newNode=new Node(data);
		
		if(empty()){
			head=newNode;
			
		}else{
			tail.next=newNode;
			
		}
		newNode.previous=tail;
		
		tail=newNode;
	}
	
	
	//�����˷ֱ���б���
	
	public  void displayHead(){
		
		System.out.println("����head-->tail��������");
		for(Node current=head;current!=null;current=current.next){
			
			current.display();
		}
		System.out.println();
	}
      public  void displayTail(){
		
		System.out.println("����tail-->head��������");
		for(Node current=tail;current!=null;current=current.previous){
			
			current.display();
		}
		System.out.println();
		
	}
	
	
	
	//�������Ԫ�س���
	
    public int size(){
	int count=0;
	for(Node current=head;current!=null;current=current.next){
		
		count++;
	}
	return count;
}


//������ͷԪ��

public D peekHead(){
	
	if(head!=null){
		
		return head.data;
	}
	return null;
}


public D peekTail(){
	
	if(tail!=null){
		
		return tail.data;
	}
	return null;
	
}

//�����˽������ݵ�ɾ��

public D removeHead(){
	
	if(empty()){
		throw new IndexOutOfBoundsException("����Ϊ�� ������ɾ��");
		
	}
	 Node old=head;
	
	head=head.next;
	
	head.previous=null;
	
	old.next=null;
	
	return old.data;
}
	

//��β�˽���ɾ������

public D removeTail(){
	
	if(empty()){
		throw new IndexOutOfBoundsException("����Ϊ�� ������ɾ��");
		
	}
	Node old=tail;
	
	tail=tail.previous;
	
	tail.next=null;
	
	old.next=null;
	
	return old.data;
	
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 DoubleQueue<Object> dq=new  DoubleQueue<Object>();
		
	      dq.insertHead("11");
	      dq.insertHead("22");
	      dq.insertHead("33");
	      dq.displayTail();
	      dq.displayHead();
	      dq.insertTail("44");
	      dq.insertTail("55");
	      dq.displayTail();
	      dq.displayHead();
	      System.out.println(dq.size());
		
	      System.out.println(dq.empty());
	      
	      
	      System.out.println("ɾ����ͷԪ��-------"+dq.removeHead());
	      dq.displayTail();
	      dq.displayHead();
	      System.out.println(dq.size());
		
	      System.out.println("ɾ����β��Ԫ-------"+dq.removeTail());
	      dq.displayTail();
	      dq.displayHead();
	      System.out.println(dq.size());
		
	}

}
