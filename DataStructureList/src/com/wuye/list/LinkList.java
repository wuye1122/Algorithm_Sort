package com.wuye.list;

public class LinkList<T> {
	
	
    /* ��������������***
     * 
     * ����:����ʱ�򳤶ȹ̶� �ڴ�Ҳ�������� ���±� 
     *     ����������ɾ��ĳ��Ԫ�� 
     * 
     * ����:���Ȳ��̶� ���Ը������������ڴ� û���±�
     *     ���Ը�������ɾ��Ԫ��
     * 
     *   c:���������ڽڵ�ͨ��ָ���໥��ϵ�� ֪��ͷ���ڵ���֪������ڵ�
     *     
     * java:����û��ָ�� �ڵ��ﱣ�����ڽڵ�Ķ��� �ֳ�֮����    
     *     
     * 
     * ����������һ�����ݽṹ  һ�����Ա�,������洢�����ݷ�ɢ���ڴ���
     * 
     * 
     * 
     * 7+3����  ɾ��  ���� ---��С ���  �ж� +toString
     * 
     * 
     * 
     * 
     * */
	
	
	
	private class Node{
		
		
		public T data;
		
		public Node next;
		
		public Node(T data,Node next){
			this.data=data;
			
			this.next=next;
			
			
		}
	

		
	}
	
	
	private int size=0;
	
	private Node head;
	
	private Node tail;
	
	
	//3����ͨ
	
	public int length(){
		return this.size;
	}
	
	
	public void clear(){
		head=null;
		tail=null;
		size=0;
	}
	
	public boolean empty(){
		
		
		return size==0;
	}
	
	
	//add������β������
	
	public void add(T data){
		
		Node newNode=new Node(data,null);
		
		if(empty()){
			head=newNode;
			tail=newNode;
		}
		tail.next=newNode;
		tail=newNode;
		size++;
		
	}
	
	
	//addHeadͷ����ʼ����
	
	public void addHead(T data){
		
		head=new Node(data,head);
		
		if(empty()){
			tail=head;
		}
		
		
		size++;
	}
	
	//����
	
	public void insert(T data,int index){
		
		if(index<0||index>size-1){
			
			throw new IndexOutOfBoundsException("��������");
			
		}
		
		//���ԭ��û������
		if(empty()){
			add(data);
			
		}else{
			if(index==0){
				addHead(data);
				}
			else{
			Node current=getNodeByIndex(index-1);
			
			current.next=new Node(data,current.next);
			
			
			size++;
				
			}

		}
	
	}
	
	
	//ɾ��ָ��λ��
	
	public T delete(int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("�����쳣 ���ִ���");
			
		}else{
			Node current=null;
			if(index==0){
				current=head;
				head=head.next;
			}else{
				Node pre=getNodeByIndex(index-1);
				
				current=pre.next;
				
				pre.next=current.next;
				
				current.next=null;
				
			}
			size--;
			return current.data;
			
		}
		
	}
	
	
	//ɾ�����Ա��������һ��Ԫ��
	
	public T remove(){
		
		return delete(size-1);
		
	}
	
	
	//�ҵ�ָ��λ�õĽڵ�
	public Node getNodeByIndex(int index){
		
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("�����쳣");
		}
		Node current=head;
		for(int i=0;i<size&&current!=null;i++,current=current.next){
			if(index==i){
				return current;	
			}
		}
		//����Ҳ���
		return null;	
	}
	
	//����ɾ������
	
	
	
	//�õ�ָ��λ�õ�Ԫ��
	public T get(int index){
		return getNodeByIndex(index).data;
	}
	
	public String toString(){
		
		if(empty()){
			return "[ ]";
		}else{
			
			StringBuffer sb=new StringBuffer("[");
			
			for(Node current=head;current!=null;current=current.next){
				
				sb.append(current.data.toString()+",");
				
			}
			return sb.delete(sb.length()-1, sb.length()).append("]").toString();
		}
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkList<Object> ll=new LinkList<Object>();
		
		ll.add("111");
		ll.add("222");
		ll.add("333");
		ll.add("444");
		System.out.println(ll.length());
		System.out.println(ll);
		ll.addHead("aa");
		ll.addHead("bb");
		System.out.println(ll.length());
		System.out.println(ll);
		System.out.println("---empty"+ll.empty());
		
		
		
	//	ll.clear();
//		System.out.println("---empty"+ll.empty());
//		System.out.println(ll.length());
//		System.out.println(ll);
	
	ll.add("cc");
	ll.addHead("dd");
	System.out.println(ll);
	System.out.println(ll.length());
	
	System.out.println("---------getNode--------");	
		
//	System.out.println(ll.getNodeByIndex(-1).data);
	System.out.println("index=0--"+ll.getNodeByIndex(0).data);
	System.out.println("index=3--"+ll.getNodeByIndex(3).data);
	System.out.println("index=4--"+ll.getNodeByIndex(4).data);
	System.out.println("index=7--"+ll.getNodeByIndex(7).data);
	//System.out.println("index=8--"+ll.getNodeByIndex(8).data);
	System.out.println("---------get--------");	
	System.out.println("index=0--"+ll.get(0));
	System.out.println("index=3--"+ll.get(3));
	System.out.println("index=4--"+ll.get(4));
	System.out.println("index=7--"+ll.get(7));
	System.out.println(ll);
	ll.insert("ͷ��", 0);
	System.out.println(ll);
	
	ll.insert("�м�", 4);
	System.out.println(ll);
	ll.insert("���²�λ", 6);
	System.out.println(ll);
	ll.insert("β��", 8);
	System.out.println(ll);
	ll.insert("β��", 11);
	System.out.println(ll.length());
	
	
	System.out.println(ll.remove());
	System.out.println(ll);
	System.out.println(ll.length());
	
	System.out.println(ll.remove());
	System.out.println(ll);
	System.out.println(ll.length());
	
	System.out.println(ll.remove());
	System.out.println(ll);
	System.out.println(ll.length());
	
	System.out.println(ll.remove());
	System.out.println(ll);
	System.out.println(ll.length());
	
	System.out.println(ll.delete(0));
	System.out.println(ll);
	System.out.println(ll.length());
	
	System.out.println(ll.delete(5));
	System.out.println(ll);
	System.out.println(ll.length());
	
	}

}
