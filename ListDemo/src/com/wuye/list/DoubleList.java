package com.wuye.list;

public class DoubleList<T> {

	/* ˫������
	 * ˫���б������ÿ���ڵ����next pre��������
	 * �ֱ�ָ��ýڵ�ǰ��ĺ͸ýڵ����Ľڵ�
	 * 
	 * �Գƽṹ �˷��˵����������Ե�ȱ�� ����ÿ���ڵ�ȿ�����ǰ����
	 * Ҳ����������� ��������ɾ��
	 * 
	 * 
	 * ˫������Ĳ��ҿ��Դ���ͷhead tail��ͷ����
	 * ���Է��Բ�������������ͷ 
	 * 
	 * ˫������Ĳ����ɾ����
	 * ����ʱ�� ����next ����pre
	 * ɾ��ʱ�� ͼ��ɾ���ڵ��next=null  pre=null
	 * 
	 * 
	 * ��ɾ���ڵ��ʱ����Ҫ���������------- ɾ��ͷ��  ɾ��β��   ɾ����
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	private class Node{
		
		Node pre;
		
		Node next;
		
		T data;
		
		Node(T data,Node pre,Node next){
			this.data=data;
			this.pre=pre;
			this.next=next;			
		}

	}
	
	private Node head;
	
	private Node tail;
	
	private int size;
	
	DoubleList(){
		//Ϊ��
		
		
	}
	
	//����һ��Ԫ�ص�˫������
	
	DoubleList(T data){
		
		head=new Node(data,null,null);
		tail=head;
		size++;
		
	}
	
	//����
	public int length(){
		return this.size;
	}
	
	//���
	public void clear(){
		head=null;
		tail=null;
		size=0;
	}
	
	//�ж��Ƿ�Ϊ��
	public boolean empty(){
		
		return size==0;
		
	}
	//���� add
	public void add(T data){
		
	//β������ <--
		
		
		if(empty()){
			Node current=new Node(data,null,null);
			head=current;
			tail=current;
			size++;
		}else{
			//<--
			Node current=new Node(data,tail,null);
			//-->
			tail.next=current;
			//   -->
			//  /
			tail=current;
			size++;
		}
		
	}
	
	
	//ͷ������-->
	public void addHead(T data){
		
		
		if(empty()){
			Node current=new Node(data,null,null);
			head=current;
			tail=current;
			size++;
		}else{
			
			//-->
			Node current=new Node(data,null,head);
			//<--
			head.pre=current;
			
			//<-- 
			//   \
			head=current;
			size++;
			
			
			
		}
	}
	
	//����ָ��λ�õ�����
	
	public void insert(T data,int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("�����쳣");
		}
		if(empty()){
			add(data);
			
			
		}else{
			if(index==0){
				addHead(data);
				
			}else{
				//��ȡ���봦 ǰ ��ڵ�
				
				Node pre=getNodeByIndex(index-1);
				
				Node net=pre.next;
				
				//  <---  --->
				Node newNode=new Node(data,pre,net);
				//  --->  <---
				pre.next=newNode;
				
				net.pre=newNode;
				
				size++;
				
				
			}
			
			
			
		}
		
		
		
	}
	
	
	//ɾ��ָ����������Ԫ��
	
	public T delete(int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("����������Χ");
			
		}
		Node del=null;
		if(index==0){//�����ͷ��Ԫ��
			 del=head;
			head=head.next;
			
			head.pre=null;
			del.next=null;
			
		}
		else if(index==size-1){
			//�����β��Ԫ��
			del=tail;
			tail=tail.pre;
			
			tail.next=null;
			del.pre=null;
			
			
			
		}
		
		
		else{
			         
			del=getNodeByIndex(index);//�ҵ���ǰ�ڵ�
			
			del.pre.next=del.next;
			//--->null--->
			del.next.pre=del.pre;
			//<---null<--- 
			
			
			 //�м�ɾ�����������Ͽ�����	 
			 del.pre=null;		 
			 del.next=null;
			
			
		}
		 size--;
		 return del.data;
	}
	//ɾ��ĩ��Ԫ��
	
	public T remove(){
		
		return delete(size-1);
		
	}
	
	//���ָ���������Ľڵ�
	
	public Node getNodeByIndex(int index){
		
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("�����쳣 ");
			
		}
		Node current=null;
		if(index<=size/2){//
			 current=head;
			for(int i=0;i<index;i++){
				current=current.next;
			}
			
		}
		else{
			 current=tail;
			for(int i=size-1;i>index;i--){
				
				current=current.pre;
			}
			
			
		}
		return current;
		

	}
	//���ָ����������Ԫ��
	
	public T get(int index){
		return getNodeByIndex(index).data;
	}
	
	//toString
	
	public String toString(){
		
		if(empty()){
			return "[]";
		}else{
			
			StringBuffer sb=new StringBuffer("[");
			for(Node current=head;current!=null;current=current.next){
				
				sb.append(current.data.toString()+",");
				
			}
			return sb.delete(sb.length()-1, sb.length()).append("]").toString();
		}
		
	}
	
	//��ת
public String AtoString(){
		
		if(empty()){
			return "[]";
		}else{
			
			StringBuffer sb=new StringBuffer("[");
			for(Node current=tail;current!=null;current=current.pre){
				
				sb.append(current.data.toString()+",");
				
			}
			return sb.delete(sb.length()-1, sb.length()).append("]").toString();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DoubleList<Object> dl=new DoubleList<Object>("aa");
		System.out.println(dl);
		dl.add("111");
		dl.add("222");
		dl.add("333");
		dl.add("444");
		dl.add("555");
		System.out.println(dl);
		System.out.println(dl.AtoString());
		dl.addHead("ͷ��");
		dl.addHead("ͷͷ��");
		dl.addHead("ͷͷͷ��");
		dl.insert("1", 0);
		System.out.println(dl);
		dl.insert("9", 9);
		System.out.println(dl);
		dl.insert("9", 9);
		System.out.println(dl);
		dl.insert("11", 11);
		dl.insert("12", 12);
	//	dl.insert("14", 14);
		
	//	System.out.println(dl.AtoString());

//		System.out.println("------���node-----"+dl.getNodeByIndex(-1));
		System.out.println("------���node-----"+dl.get(0));
		System.out.println("------���node-----"+dl.getNodeByIndex(1));
		System.out.println("------���node-----"+dl.getNodeByIndex(2));
		System.out.println("------���node-----"+dl.getNodeByIndex(3));
		System.out.println("------���node-----"+dl.getNodeByIndex(4));
		System.out.println("------���node-----"+dl.get(5));
		System.out.println("------���node-----"+dl.getNodeByIndex(6));		
		System.out.println("------���node-----"+dl.getNodeByIndex(7));
		System.out.println("------���node-----"+dl.getNodeByIndex(8));
		System.out.println("------���node-----"+dl.get(9));
		System.out.println("------���node-----"+dl.getNodeByIndex(10));
		System.out.println("------���node-----"+dl.getNodeByIndex(11));
		System.out.println("------���node-----"+dl.getNodeByIndex(12));
		System.out.println("------���node-----"+dl.get(13));
//		System.out.println("------���node-----"+dl.getNodeByIndex(14));
		
		System.out.println(dl);
		System.out.println(dl.delete(0));
		System.out.println(dl.delete(6));
		System.out.println(dl.delete(7));
		System.out.println(dl.delete(10));
		System.out.println("---��ʱ�ĳ���Ϊ---"+dl.length());
		System.out.println(dl);
		System.out.println("------���node-----"+dl.getNodeByIndex(0));
		System.out.println("------���node-----"+dl.getNodeByIndex(1));
		System.out.println("------���node-----"+dl.getNodeByIndex(2));
		System.out.println("------���node-----"+dl.getNodeByIndex(3));
		System.out.println("------���node-----"+dl.getNodeByIndex(4));
		System.out.println("------���node-----"+dl.getNodeByIndex(5));
		System.out.println("------���node-----"+dl.getNodeByIndex(6));		
		System.out.println("------���node-----"+dl.getNodeByIndex(7));
		System.out.println("------���node-----"+dl.getNodeByIndex(8));
		System.out.println("------���node-----"+dl.getNodeByIndex(9));
		System.out.println("��ȡ"+"-----"+dl);
		System.out.println(dl.remove());
		System.out.println(dl);
		System.out.println(dl.remove());
		System.out.println(dl);
		System.out.println(dl.remove());
		System.out.println(dl);
		System.out.println(dl.remove());
		System.out.println(dl.AtoString());
		System.out.println(dl.delete(0));
		System.out.println(dl);
		System.out.println(dl.delete(0));
		System.out.println(dl);
		System.out.println(dl.delete(0));
		System.out.println(dl);
		System.out.println(dl.delete(0));
		System.out.println(dl);
	  dl.insert(11, 0);
	  dl.insert(11, 0);
	  dl.insert(33, 3);
	  dl.insert(44, 4);
		System.out.println(dl);
//		dl.clear();
//		System.out.println(dl.empty());
//		System.out.println(dl);
	}

}
