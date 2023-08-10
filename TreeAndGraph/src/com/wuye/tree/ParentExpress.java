package com.wuye.tree;

import java.util.ArrayList;
import java.util.List;

public class ParentExpress<E> {
 /*  
  *  1 ���ڵ��ʾ��: ��¼�ڵ������ �� parent�������� Ҳ���Ǹ��ڵ������
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
  * */
	
	
	//�ڲ��� ���ڽڵ�
	public static class Node<T>{
		
		T data;//�ڵ�����
		
		int parent;
		
		public  Node(T data,int parent){
			
			this.data=data;
			
			this.parent=parent;
			
		}
		
		private String toSring() {
			// TODO Auto-generated method stub
          return "���ڵ��ʾ��:��data:"+data+",parent"+parent+"��";
			
		}
	
	} 
//����������
			private int treesize=100;
			//�����������ò����� ��Ϊ �����������õ������ܽ����
			
//�ڵ������
			private int nodenum;
			
//��ʾ�ڵ������
			private Node nodes[];
			
			
//��Ӹ��ڵ�
	        ParentExpress(E data){
		   
		     nodes=new Node[treesize];
		          
		       //�Ѹ��ڵ���ӽ�����
		     nodes[0]=new Node<E>(data, -1);
		
		     nodenum++;
	       }
	        
//���ؽڵ㴦������
	        
	        
	        public int getIndex(Node node){
	        	
	        	for(int i=0;i<treesize;i++){
	        		if(nodes[i]!=null&&nodes[i]==node){
	        			
	        			return i;
	        		}
	        		
	        	}
				return -1;
	        }
	        
//Ϊ�������һ���ڵ�
	        public void addNode(E data,Node parent){
	        	
	        	for(int i=0;i<treesize;i++){
	        		 
	        		
	        		//û�нڵ��Լ�����
	        		if(nodes[i]==null){
	        			nodes[i]=new Node(data,getIndex(parent));
	        			
	        			 nodenum++;
	        			 return;
	        		}
	
	        	}
	        	
	        	throw new RuntimeException("���Ѿ����˲��ܲ�����");
	        	
	        }
	        
//���ظ��ڵ�
	        
	        public Node getRoot(){
	        	
	        	return nodes[0];
	        }
	        
	        
//�ҵ�ָ�����ݶ�Ӧ�Ľڵ�
	        
	        
	        public Node<E> getNodeByData(E data){
	        	for(int i=0;i<treesize;i++){
	        		if(nodes[i]!=null&&nodes[i].data.equals(data)){
	        			return nodes[i];
	        		}      		
	        	}
				return null;

	        }
	
//�ҵ�ָ���ڵ�����Ժ���
	        
	        
	        public List<Node> getClildren(Node parent){
	        	List<Node> list=new ArrayList(); 
	        	
	        	for(int i=0;i<treesize;i++){
	        		if(nodes[i]!=null&&nodes[i].parent==getIndex(parent)){
	        			list.add(nodes[i]);
	        		}	
	        	}
				return list;
	        }
	        
//�����������
	        public int getDeep(){
	        
	        	//��¼�ڵ㵽���ڵ����ֵ
	        	
	        	int  max=0;
	        	
	        	for(int i=1;i<treesize&&nodes[i]!=null;i++){
	        		
	        		int def=1;//��ʼ�� �ӵڶ��ſ�ʼ
	        		
	        		int m=nodes[i].parent;
	        		
	        		while(m!=-1&&nodes[i]!=null){
	        			
	        			m=nodes[m].parent;
	        			def++;
	        		}
	        		if(def>max){	
	        		max=def;
	        		
	        		}	
	        		}
				return max;
	        		
	        	}
	        	
	        	
	        
	        
	        
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ParentExpress px=new ParentExpress("A");
		
	       px.addNode("B", px.getRoot());  
	       px.addNode("C", px.getNodeByData("A")); 
	       
	       px.addNode("E", px.getNodeByData("B"));
	       
	       px.addNode("F", px.getNodeByData("E"));
	       
	       px.addNode("G", px.getNodeByData("E"));
	       
	       px.addNode("Z", px.getNodeByData("G"));
	       
	       
	       System.out.println("��Ҫ �� ����������ǰ���������ܽ����");
	       System.out.println("getroot:���ظ����ڵ�"+px.getRoot().data);
	       System.out.println("���������:"+px.getDeep());
	       System.out.println("�����ж��ٸ��ڵ�:"+px.nodenum);
	       System.out.println();
	       System.out.println("�����ı�������:");
	       for(int i=0;i<px.nodenum;i++){
	    	   
	    	   System.out.println(i+px.nodes[i].toSring());  
	    	   
	       }
	       System.out.println();
	       
	       
	       System.out.println("�������ҵ��ڵ�getNodeByData:|�ӽڵ�������getIndex:"+px.getIndex(px.getNodeByData("A")));
	       System.out.println("�������ҵ��ڵ�getNodeByData:|�ӽڵ�������getIndex:"+px.getIndex(px.getNodeByData("F"))); 
	       System.out.println("�������ҵ��ڵ�getNodeByData:|�ӽڵ�������getIndex:"+px.getIndex(px.getNodeByData("O")));

	     List<Node> lis=px.getClildren(px.getNodeByData("A"));
	     
	     for(Node n:lis){
	    	 System.out.print(n.data);
	    	 
	     }
	}

}
