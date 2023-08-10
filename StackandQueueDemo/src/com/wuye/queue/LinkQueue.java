package com.wuye.queue;

public class LinkQueue<E> {
	/*��ʽ����:LinkQueue
	 *         
	 *         ����ָ��ֻ�Ǵ洢���ݵ�λ�� ��Ϳ������ڴ���������洢  û�б��������洢�Ŀռ�
	 *         ���ڴ�Ҫ���Ǻܸ�
	 *         �����й��ɵ����������  ʱ�临�ӶȱȽ�С Ч�ʱȽϸ�
	 *         �����޹��ɵ����� ʹ����ʽ�洢   ʱ�临�ӶȱȽϴ�  Ч�ʱȽϵ� 
	 *         
	 * ��ʽ�������        ������ʽ�洢�ṹ�Ķ��г�֮Ϊ������
	 *            ����ʹ����ʽ�ṹ�������Ա�
	 *            
	 *            
	 *     �ڵ�������������Ԫ��:ʹrear.next-->�µĽڵ�
	 *                      rear-->�µĽڵ�
	 *                         
	 *     �ڵ����������ɾ��Ԫ��:ʹ   oldfront-->front
	 *                       front-->front.next
	 *                       oldfront-->null;     
	 * 
	 * 
	 * */

	//����һ���ڲ���  �ڲ��� ��Ϊ�ڵ�Ľṹ����
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkQueue<Object> queue=new LinkQueue<Object>();
		//ѡ���Ĭ�Ϲ�����
		
		System.out.println(queue.length());
		System.out.println(queue);
		
		LinkQueue<Object> queue1=new LinkQueue<Object>("222");
		System.out.println(queue1.length());
		System.out.println(queue1);
		queue1.add("11");
		queue1.add(333);
		queue1.add("Ѽͷ");
		System.out.println(queue1);
		System.out.println(queue1.length());
		System.out.println(queue1.element());
		System.out.println(queue1.remove());
		System.out.println(queue1.remove());
		System.out.println(queue1.remove());
		queue1.add("����ӵ�Ԫ��");
		System.out.println(queue1.remove());
		System.out.println(queue1.remove());
		//System.out.println(queue1.remove());
		System.out.println(queue1.length());
		System.out.println(queue1.empty());
		
		
		
	}
	private class Node{
		private Node next;
		
		private E data;
		
		public Node(Node next,E data){
			
			this.next=next;
			this.data=data;
			
		}
	
	
	
		
	}
	
	
	
	private Node front;
	
	private Node rear;
	
	private int size;//Ĭ��0
	
    //һ�ֶ���Ϊ�յĹ�����
	public LinkQueue(){
		front=null;
		rear=null;
		
	}
	
	public LinkQueue(E data){
		
		front =new Node(null,data);
		rear=front;//һ��Ԫ�ض�ָ�� һ��
	    size++;
	}

	
	//ɾ�����ҷ��� ��ͷԪ��
	
	public E remove(){
		
		//front ��ԭ���ĵ�һ��ָ��ڶ���
		//��һ���͵ڶ����ڵ�֮��Ͽ�
		//
		
		Node oldNode=front;
		
		front=front.next;
		
		oldNode.next=null;
		
		size--;
		return oldNode.data;
		
	}
	
	//������Ҫ�ж�  �Ƿ���Ԫ��
	
	
	public void add(E data){
		
		if(front==null){
			
			front =new Node(null,data);
			
			rear=front;//һ���Ƕ�ͷָ���β
			
			//��һ��Ԫ��
			
			
		}else{
			Node newNode=new Node(null,data);
			
			rear.next=newNode;
			
			rear=newNode;
			
		}
		size++;
	}
	
	
	
	//size����Ԫ�ظ���
	public boolean  empty(){
		
		return size==0;
	}
	
	//Ԫ�ظ���
   public int length(){
	
	return size;
	
}
   
   //���
   
   public void  clear(){
	   front=null;
	   rear=null;
	   size=0;
	   
   }
	
   
   //���ض�ͷԪ�� ���ǲ�ɾ��
   
   public E element(){
	   
	   return front.data;
   }
	
   
   //��д�Ǹ�����
   
   public String toString(){
	   
	   if(empty()){
		   return "[ ]";
	   }else{
		   StringBuffer sb=new StringBuffer("[");
		   
		   for(Node current=front;current!=null;current=current.next){
			   sb.append(current.data.toString()+",");
			   
		        }
		   return sb.delete(sb.length()-2, sb.length()).append("]").toString();
	   }
	   
   }

   
   
   
   
   
   
   
}
