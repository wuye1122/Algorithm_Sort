package com.wuye.queue;

public class TestLinkQueue<E> {

	
	
	
	//�ڲ����ʾһ���ڵ�ṹ
	
	public class Node{
		
		private Node next;
		
		private E data;
		
		public Node(Node next, E data){
			this.data=data;
			
			this.next=next;
			
		}
		
		
	}
	
	
	private Node front;
	
	private Node rear;
	
	private int size;
	
	//���ֹ�����
	TestLinkQueue(){
		front=null;
		rear=null;
		
	}
	
	 TestLinkQueue(E data){
		 
		 front=new Node(null,data);
		 
		 rear=front;//˭ָ��˭
		 
		 size++;
		 
	 }
	 
	 
	 //�ж��Ƿ�Ϊ�� 
	 public boolean empty(){
		 //����Ϊ��
		 return size==0;
	 }
	 
	 
	 //���
	 public void clear(){
		 
		 front=null;
		 
		 rear=null;
		 
		 size=0;
		 
	 }
	 
	 
	 //����Ԫ�ظ���
	 public int length(){
		 
		 return size;
	 }
	 
	 
	 //���ض�ͷԪ��
	 
	 public E element(){
		 return front.data;
	 }
	 
	 
	//���Ԫ��
	 
	 public void add(E data){
	
		 //���ԭ������Ϊ�������һ��Ԫ��
		 if(front==null){
			
			 front=new Node(null,data);
			 
			 rear=front;
			 
			 
			 //���ԭ�����в�Ϊ��������һ�� �µĽڵ�	 
		 }else{
			 
			 Node newNode=new Node(null,data);
			 
			 rear.next=newNode;
			 
			 rear=newNode;
	 
		 }
		 size++;
 
	 }
	 
	 //ɾ��Ԫ��
	 
	 public E remove(){
		 
		Node oldNode=front;
		
		front=front.next;
		
		oldNode.next=null;
		 
		size--;
		
		return  oldNode.data;
	 }
	 
	 public String toString(){
		 
		 if(empty()){
			 
			 return "[]";
			 
		 }else{
			 StringBuffer  sb=new StringBuffer("[");
			 
			 for(Node current=front;current!=null;current=current.next){
				 sb.append(current.data.toString()+",");
			 }
			 
			 return sb.delete(sb.length()-1, sb.length()).append("]").toString();
		 }
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		TestLinkQueue<Object> tq=new TestLinkQueue<Object>();
		System.out.println(tq);
		
		tq.add("11");
		
		tq.add("22");
		
		tq.add("33");
		tq.add("β�ڵ�");
		tq.add("����pp");
		System.out.println(tq);
		
		
		System.out.println("----------------------");
		
		System.out.println(tq.element());
		System.out.println("element---"+tq);
		System.out.println(tq.length());
		
		System.out.println(tq.remove());
		System.out.println("remove---"+tq);
		System.out.println(tq.length());
		
		
		System.out.println(tq);
		System.out.println("ͷ�ڵ�"+tq.front.data);
		System.out.println("β�ڵ�"+tq.rear.data);
		tq.remove();
	
		System.out.println(tq);
		System.out.println("ͷ�ڵ�"+tq.front.data);
		System.out.println("β�ڵ�"+tq.rear.data);
//	tq.clear();
//		System.out.println("ͷ�ڵ�"+tq.front.data);
//		System.out.println("β�ڵ�"+tq.rear.data);
		System.out.println(tq);
		System.out.println(tq.empty());
		System.out.println(tq.length());
		System.out.println(tq.front.next.data);
		System.out.println(tq.rear.next);
	}

}
