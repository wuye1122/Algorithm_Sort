package com.weikun.linkstack;

public class LinkStack<T> {
	//����һ���ڲ���Node��Nodeʵ��������ջ�Ľڵ㡣
	private class Node{
		//����ڵ������
		private T data;
		//ָ���¸��ڵ������
		private Node next;
		//�޲����Ĺ�����
		public Node(){
		}
		//��ʼ��ȫ�����ԵĹ�����
		public Node(T data , Node next)	{
			this.data = data;
			this.next = next;
		}
	}
	//�������ջ��ջ��Ԫ��
	private Node top;
	//�������ջ���Ѱ����Ľڵ���
	private int size;
	//��������ջ
	public LinkStack(){
		//����ջ��top��ֵΪnull
		top = null;
	}
	//��ָ������Ԫ����������ջ������ջֻ��һ��Ԫ��
	public LinkStack(T element){
		top = new Node(element , null);
		size++;
	}
	//������ջ�ĳ���	
	public int length(){
		return size;
	}
	//��ջ
	public void push(T element){
		//��topָ���´�����Ԫ�أ���Ԫ�ص�next����ָ��ԭ����ջ��Ԫ��,��������
		top = new Node(element , top);
		size++;
	}
	//��ջ
    public T pop(){
		Node oldTop = top;
		//��top����ָ��ԭջ��Ԫ�ص���һ��Ԫ��
		top = top.next;
		//�ͷ�ԭջ��Ԫ�ص�next����
		oldTop.next = null;
		size--;
		return oldTop.data;
	}
	//����ջ��Ԫ�أ�����ɾ��ջ��Ԫ��
	public T peek(){
		return top.data;
	}
	//�ж���ջ�Ƿ�Ϊ��ջ
	public boolean empty(){
		return size == 0;
	}
	//�����ջ
	public void clear(){
		//���ײ���������Ԫ�ظ�Ϊnull
		top = null;
		size = 0;
	}
	public String toString(){
		//��ջΪ����ջʱ
		if (empty()){
			return "[]";
		}
		else{
			StringBuilder sb = new StringBuilder("[");
			for (Node current = top ; current != null
				; current = current.next ){
				sb.append(current.data.toString() + ", ");
			}
			int len = sb.length();
			return sb.delete(len - 2 , len).append("]").toString();
		}
	}
}

