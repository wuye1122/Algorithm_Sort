package com.wuye.tree;

import java.util.ArrayList;
import java.util.List;



public class SonExpress <E>{
//���ĵڶ�����ʽ    ������ʾ��
	/*
	 * 
	 * 
	 * ���ı�ʾ��������������Ҫ�����ڵ��ʾ�������ӽڵ���ʽ��ʾ����

             
              A:���ڵ��ʾ��

                ÿ���ڵ㶼��¼���ĸ��ڵ�  ��������˸��ڵ�֮�� �����ÿ���ӽڵ㶼��һ�����ڵ�

                Ϊ�˼�¼���еĽڵ���ڵ�֮��Ĺ�ϵ Ϊÿһ���ڵ�����һ�� parent��

                ���ڵ��parent����-1

              * ���ڵ��ʾ������ÿ���ڵ��ס���ĸ��ڵ�����������ַ����Ǵ��ӽڵ����ֵ� 

              * BBS ��������� 
           
              B:�ø��ڵ��ס���е��ӽڵ㣬�ͻ����һ���ڵ��кܶ���ӽڵ�  ʹ���ӽڵ�����ʾ��  
                                  
                
	 * 
	 * 
	 * 
	 * 
	 * */
private int treesize=100;
	
	private  Node<E> nodes[];
	
	private int treenum;
	
//�����ӽڵ�
	
	public  static class SonNode{

		private	SonNode next;//�ӽڵ�  ��������ӽڵ�

		private	int pos;//��¼��ǰ�ӽڵ�   ָ�򸸽ڵ������

		SonNode(int pos,SonNode next){
			this.pos=pos;

			this.next=next;
		}
		
		// �ӽڵ��޷�����:
		/*    public String toString(){
			
			if(this.next==null){
				return "!�ø��ڵ�û���ӽڵ�"+"";
			}else{
				SonNode son=this.next;
				while(son!=null){
					System.out.print("�ӽڵ�:"+nodes[son.pos]);
					son=son.next;
					
				}
				
			}
			
			return  "�ӽڵ�ֵ:"+nodes[this.pos];
		}*/

	}
	
	
//������������ڵ�
	
	
	public static class Node<T>{
		
		private T data ;
		
		private SonNode son;
		
		//���������ʱ�� ֻ�ǽ������������� ��ȥ�ܶ���
		public Node(T data){
			this.data=data;
			this.son=null;
		}
		
		public String toString(){
			
			
			return "����ڵ�:Node="+data;
			
			
		}
		
	 }
	
	
	
	
	
	//���������һ��Ԫ��
	SonExpress(E data){
		
		nodes=new Node[treesize];
		nodes[0]=new Node(data);
	    treenum++;
	}
//���ظ����ڵ�
	
	public Node getRoot(){
		return nodes[0];
	}
	
//����Ԫ��  Ϊָ���ڵ�����ӽڵ�
	
	/*   1 ��Ԫ����ӵ�nodes��������  
	 * 
	 *   2 ����������˵�һ��֮�� ÿһ���ڵ㶼�����������ڵ������ ָ�����ݵĸ��ڵ� 
	 * 
	 * 
	 * 
	 * */
	public void addNode(E data,Node<E> parent){
		
		for(int i=0;i<treesize;i++){
			
			
			if(nodes[i]==null){
				
				nodes[i]=new Node(data);//�����ݸ�ֵ
			   
			    if(parent.son==null){
			    	  
			    	    //(int pos,SonNode next)
			    	parent.son=new SonNode(i,null);
			    }
			
			    else{
				
				//������׺����кܶ�Ķ���  ȡ�������
				SonNode nex=parent.son;
				
				
				
				while(nex.next!=null){
					nex=nex.next;//�ҵ�û�еܵܵ��Ǹ����� 
				 }
				
				//�µĶ��Ӽ���
				nex.next=new SonNode(i,null);
				
			        }
			this.treenum++;
			return;
		}
	}
		throw new RuntimeException("���Ѿ����˲��ܽ��в���");
	}
	
//���ݽڵ��ȡ����
	
	public int getDeep(Node node){
		if(node.son==null){
			return 1;//���ֻ���Լ��� �͵���1
		}
		else{
			
			//��Ҫ�ݹ�
			
			int max=0;
			
			SonNode son=node.son;
			
			while(son!=null){
				int def=getDeep(nodes[son.pos]);
				
				if(def>max){
					max=def;
				      }
				
				son=son.next;
			  }
			  
			return max+1;
			
		}
		
	
	}
	
	
	public int  getIndex(Node node){
		for(int i=0;i<treesize;i++){
			
			//���б�Ҫ
			if(nodes[i]!=null&&nodes[i]==node){
			return i;	
			}
		}
		return -1;
	}
	
	
//����Ԫ�ػ�ȡ�ڵ�	
	
	
	public Node<E> getNodeByData(E data){
		
		for(int i=0;i<treesize;i++){
			
			//�Ƚϵ��������Ƿ�һ��  ����һ��bug �Լ�����
			if(nodes[i]!=null&&nodes[i].data.equals(data)){
				return nodes[i];
			}
			
			
		}
		return null;
		
	}
	
	
//��ȡԪ�ص��ӽڵ�
	
		
	public List<Node> getChild(Node parent){
		List<Node> list=new ArrayList();
		
		 SonNode son=parent.son;
		 if(parent.son==null){
			 list.add(null);
			 return list;
		 }
		 while(son!=null){
			 
			 //�˴���ȡ���ӽڵ�  ��� ����Nodeע��
			 list.add(nodes[son.pos]);
			 
			 son=son.next;
		 }
		return list;
		
	}
//������нڵ�Ķȵļ���:
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SonExpress se=new SonExpress("A");
		
		se.addNode("B", se.getNodeByData("A"));
		
		se.addNode("C", se.getNodeByData("A"));
		
		se.addNode("D", se.getNodeByData("A"));
		
		
		se.addNode("E", se.getNodeByData("C"));
		
		se.addNode("F", se.getNodeByData("D"));
		
		
		 System.out.println("�����ı�������:");
	       for(int i=0;i<se.treenum;i++){
	    	   
	    	   System.out.println(i+se.nodes[i].toString());  
	    	
                    
	    	  
	       }
	       System.out.println();
	       System.out.println("�������ҵ��ڵ�getNodeByData:|�ӽڵ�������getIndex:"+se.getIndex(se.getNodeByData("A")));
	       System.out.println("�������ҵ��ڵ�getNodeByData:|�ӽڵ�������getIndex:"+se.getIndex(se.getNodeByData("F"))); 
	       System.out.println("�������ҵ��ڵ�getNodeByData:|�ӽڵ�������getIndex:"+se.getIndex(se.getNodeByData("Z")));
		
	      
	       
	       System.out.println(se.getIndex(se.getNodeByData("Z")));
	       System.out.println(se.getIndex(null));
	       
	       System.out.println("���Ľڵ�����:"+se.treenum);
	       System.out.println("���ĸ��ڵ�:"+se.getRoot().data);
	       
	       
	  List<Node> list1 =se.getChild(se.getNodeByData("A"));
	       
	  for(Node ne:list1){
		  System.out.println("�ӽڵ�:"+ne);
	  }
	 
	  System.out.println("���������:"+se.getDeep(se.getNodeByData("A")));
	  
	}

}
