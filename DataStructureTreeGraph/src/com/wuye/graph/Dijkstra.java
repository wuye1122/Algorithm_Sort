package com.wuye.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class Dijkstra {

	 /*
	  *   ��ͼ�������һ���� �����������·��   
	  * 
	  *   �����Ѿ���������·�Ļ�����  ��ø�Զ��������·��
	  * 
	  *   �����Ϊ����������չ ֱ����չ���յ�Ϊֹ
	  * 
	  *   ̰���㷨����:close���δ�����Ľڵ�  open����Ѿ������Ľڵ�
	  *   
	  *   
	  * */
	
	//���ȶ���ڵ�
	
	class Node{
		
		private String name;
		
		Node(String name){
			this.name=name;
		}
		
		private Map<Node,Integer> child=new HashMap<Node,Integer>();
		
		public String getName(){
			return name;
		}
		public Map<Node,Integer> getChild(){
			return this.child;
		}
		
		
	}
	
    private Set<Node> open=new HashSet<Node>();//���ڴ洢δ�������ڵ�
	private Set<Node> close=new HashSet<Node>();//���ڴ洢�Ѿ������Ľڵ�

	private Map<String,Integer> path=new HashMap<String,Integer>();//�洢·����Ϣ
	
	private Map<String,String> pathinfo =new HashMap<String,String>();//��·����Ϣ������
	
	
	//���ڵ��ʼ��
	public class Bulid{
		
		
		//���ڵ����Ϣ  ���� ����ʼ�� ���ҽ�open close���е�һ�θ�ֵ
		public Node bulid(Set<Node> open,Set<Node> close){
			
			Node nodeA=new Node("A");
			Node nodeB=new Node("B");
			Node nodeC=new Node("C");
			Node nodeD=new Node("D");
			Node nodeE=new Node("E");
			Node nodeF=new Node("F");
			Node nodeG=new Node("G");
			Node nodeH=new Node("H");
			nodeA.getChild().put(nodeB, 1);
			nodeA.getChild().put(nodeC, 1);
			nodeA.getChild().put(nodeD, 4);
			nodeA.getChild().put(nodeG, 5);
			nodeA.getChild().put(nodeF, 2);
			nodeB.getChild().put(nodeA, 1);
			nodeB.getChild().put(nodeF, 2);
			nodeB.getChild().put(nodeH, 4);
			nodeC.getChild().put(nodeA, 1);
			nodeC.getChild().put(nodeG, 3);
			nodeD.getChild().put(nodeA, 4);
			nodeD.getChild().put(nodeE, 1);
			nodeE.getChild().put(nodeD, 1);
			nodeE.getChild().put(nodeF, 1);
			nodeF.getChild().put(nodeE, 1);
			nodeF.getChild().put(nodeB, 2);
			nodeF.getChild().put(nodeA, 2);
			nodeG.getChild().put(nodeC, 3);
			nodeG.getChild().put(nodeA, 5);
			nodeG.getChild().put(nodeH, 1);
			nodeH.getChild().put(nodeB, 4);
			nodeH.getChild().put(nodeG, 1);
			open.add(nodeB);
			open.add(nodeC);
			open.add(nodeD);
			open.add(nodeE);
			open.add(nodeF);
			open.add(nodeG);
			open.add(nodeH);
			
			close.add(nodeA);
			return nodeA;
			
		}
		
		
	}
	
	
	public Node init(){
		
		
		path.put("B", 1);
		pathinfo.put("B", "A->B="+1);
		
		path.put("C", 1);
		pathinfo.put("C", "A->C="+1);
		
		path.put("D", 4);
		pathinfo.put("D", "A->D="+4);
		
		path.put("E", Integer.MAX_VALUE);		
		pathinfo.put("E", "A");
		
		path.put("F", 2);
		pathinfo.put("F", "A->F="+2);
		
		path.put("G", 5);
		pathinfo.put("G", "A->G="+5);
		
		path.put("H", Integer.MAX_VALUE);
		pathinfo.put("H", "A");
		
		Node start=new Bulid().bulid(open, close);
		return start;
		
		
	}
	
	
	//�ҵ�����node��̵��Ǹ��ڵ�
	public Node getShort(Node node){
		
		//���� node int �ڵ�;���
		Node res=null;
		int m=Integer.MAX_VALUE;
		
		 //�ڽڵ�node�Ķ��Ӽ�������Ѱ��
		
		Map<Node, Integer> childs =node.getChild();
		
		//�Ժ����� ���б���
		for(Node child:childs.keySet()){
			
			//���open������˵��û�б���
			
			if(open.contains(child)){
			    
				  //ȡ������ڵ�ľ���
				 Integer distance=childs.get(child);
				if(distance<m){
					m=distance;
					res=child;
				}
			}
		}
		return res;
	}

	//���ķ���
	private void dj(Node start){
		
		Node near =this.getShort(start);
		 if(near==null){
			 return;
		 }
		
		 close.add(near);
		 open.remove(near);
		 
		 Map<Node, Integer> Childs=near.getChild();
		 
		 for(Node child:Childs.keySet()){
			 
			 if(open.contains(child)){//֤��û����
				 
				 int a=Childs.get(child);//near -- child����
				 
				 int b=path.get(near.getName());//a---near����
				 
				 if(path.get(child.name)>a+b){
					 path.put(child.getName(),a+b);
					//pathinfo.put("G", "A->G="+5); 
					 pathinfo.put(child.getName(), near.getName()+"-->"+child.getName()+"="+(a+b));
				 }
			 }
			 
		 }
		 
		 dj(start);
		 dj(near);
		 
	}
	
	//��ӡ
	
	public void printPath(){
		
		Set<Map.Entry<String, String>> MM=pathinfo.entrySet();
		for(Map.Entry<String, String> ss:MM){
			System.out.println(" ��: "+ss.getKey()+" ֵ: "+ss.getValue());
			
			
		}
	}
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dijkstra dd=new Dijkstra();
		   Node start=dd.init();
	            dd.dj(start);
	            dd.printPath();
	}

}
