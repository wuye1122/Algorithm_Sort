package com.wuye.queue;

public class LinkQueue<E> {
	/*链式队列:LinkQueue
	 *         
	 *         采用指针只是存储数据的位置 这就可以在内存里面随意存储  没有必须连续存储的空间
	 *         对内存要求不是很高
	 *         对于有规律的排序的数据  时间复杂度比较小 效率比较高
	 *         对于无规律的数据 使用链式存储   时间复杂度比较大  效率比较低 
	 *         
	 * 链式单向队列        采用链式存储结构的队列称之为链队列
	 *            类似使用链式结构保存线性表
	 *            
	 *            
	 *     在单向队列里面插入元素:使rear.next-->新的节点
	 *                      rear-->新的节点
	 *                         
	 *     在单向队列里面删除元素:使   oldfront-->front
	 *                       front-->front.next
	 *                       oldfront-->null;     
	 * 
	 * 
	 * */

	//包含一个内部类  内部类 作为节点的结构存在
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkQueue<Object> queue=new LinkQueue<Object>();
		//选择的默认构造器
		
		System.out.println(queue.length());
		System.out.println(queue);
		
		LinkQueue<Object> queue1=new LinkQueue<Object>("222");
		System.out.println(queue1.length());
		System.out.println(queue1);
		queue1.add("11");
		queue1.add(333);
		queue1.add("鸭头");
		System.out.println(queue1);
		System.out.println(queue1.length());
		System.out.println(queue1.element());
		System.out.println(queue1.remove());
		System.out.println(queue1.remove());
		System.out.println(queue1.remove());
		queue1.add("新添加的元素");
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
	
	private int size;//默认0
	
    //一种队列为空的构造器
	public LinkQueue(){
		front=null;
		rear=null;
		
	}
	
	public LinkQueue(E data){
		
		front =new Node(null,data);
		rear=front;//一个元素都指向 一处
	    size++;
	}

	
	//删除并且返回 队头元素
	
	public E remove(){
		
		//front 从原来的第一个指向第二个
		//第一个和第二个节点之间断开
		//
		
		Node oldNode=front;
		
		front=front.next;
		
		oldNode.next=null;
		
		size--;
		return oldNode.data;
		
	}
	
	//增加需要判断  是否有元素
	
	
	public void add(E data){
		
		if(front==null){
			
			front =new Node(null,data);
			
			rear=front;//一定是队头指向队尾
			
			//有一个元素
			
			
		}else{
			Node newNode=new Node(null,data);
			
			rear.next=newNode;
			
			rear=newNode;
			
		}
		size++;
	}
	
	
	
	//size代表元素个数
	public boolean  empty(){
		
		return size==0;
	}
	
	//元素个数
   public int length(){
	
	return size;
	
}
   
   //清空
   
   public void  clear(){
	   front=null;
	   rear=null;
	   size=0;
	   
   }
	
   
   //返回队头元素 但是不删除
   
   public E element(){
	   
	   return front.data;
   }
	
   
   //重写那个方法
   
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
