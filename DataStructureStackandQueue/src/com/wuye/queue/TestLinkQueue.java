package com.wuye.queue;

public class TestLinkQueue<E> {

	
	
	
	//内部类表示一个节点结构
	
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
	
	//两种构造器
	TestLinkQueue(){
		front=null;
		rear=null;
		
	}
	
	 TestLinkQueue(E data){
		 
		 front=new Node(null,data);
		 
		 rear=front;//谁指向谁
		 
		 size++;
		 
	 }
	 
	 
	 //判断是否为空 
	 public boolean empty(){
		 //个数为零
		 return size==0;
	 }
	 
	 
	 //清空
	 public void clear(){
		 
		 front=null;
		 
		 rear=null;
		 
		 size=0;
		 
	 }
	 
	 
	 //返回元素个数
	 public int length(){
		 
		 return size;
	 }
	 
	 
	 //返回队头元素
	 
	 public E element(){
		 return front.data;
	 }
	 
	 
	//添加元素
	 
	 public void add(E data){
	
		 //如果原来队列为空则添加一个元素
		 if(front==null){
			
			 front=new Node(null,data);
			 
			 rear=front;
			 
			 
			 //如果原来队列不为空则增加一个 新的节点	 
		 }else{
			 
			 Node newNode=new Node(null,data);
			 
			 rear.next=newNode;
			 
			 rear=newNode;
	 
		 }
		 size++;
 
	 }
	 
	 //删除元素
	 
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
		tq.add("尾节点");
		tq.add("混乱pp");
		System.out.println(tq);
		
		
		System.out.println("----------------------");
		
		System.out.println(tq.element());
		System.out.println("element---"+tq);
		System.out.println(tq.length());
		
		System.out.println(tq.remove());
		System.out.println("remove---"+tq);
		System.out.println(tq.length());
		
		
		System.out.println(tq);
		System.out.println("头节点"+tq.front.data);
		System.out.println("尾节点"+tq.rear.data);
		tq.remove();
	
		System.out.println(tq);
		System.out.println("头节点"+tq.front.data);
		System.out.println("尾节点"+tq.rear.data);
//	tq.clear();
//		System.out.println("头节点"+tq.front.data);
//		System.out.println("尾节点"+tq.rear.data);
		System.out.println(tq);
		System.out.println(tq.empty());
		System.out.println(tq.length());
		System.out.println(tq.front.next.data);
		System.out.println(tq.rear.next);
	}

}
