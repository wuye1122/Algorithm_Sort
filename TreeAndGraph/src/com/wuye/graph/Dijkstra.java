package com.wuye.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class Dijkstra {

	 /*
	  *   在图中求出第一个点 到其他点最短路径   
	  * 
	  *   基于已经求出的最短路的基础上  求得更远顶点的最短路径
	  * 
	  *   以起点为中心向外扩展 直到扩展到终点为止
	  * 
	  *   贪心算法策略:close存放未遍历的节点  open存放已经遍历的节点
	  *   
	  *   
	  * */
	
	//首先定义节点
	
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
	
    private Set<Node> open=new HashSet<Node>();//用于存储未被遍历节点
	private Set<Node> close=new HashSet<Node>();//用于存储已经遍历的节点

	private Map<String,Integer> path=new HashMap<String,Integer>();//存储路径信息
	
	private Map<String,String> pathinfo =new HashMap<String,String>();//将路径信息读出来
	
	
	//将节点初始化
	public class Bulid{
		
		
		//将节点的信息  名字 都初始化 并且将open close进行第一次赋值
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
	
	
	//找到距离node最短的那个节点
	public Node getShort(Node node){
		
		//变量 node int 节点和距离
		Node res=null;
		int m=Integer.MAX_VALUE;
		
		 //在节点node的儿子集合里面寻找
		
		Map<Node, Integer> childs =node.getChild();
		
		//对孩子们 进行遍历
		for(Node child:childs.keySet()){
			
			//如果open里面有说明没有遍历
			
			if(open.contains(child)){
			    
				  //取出这个节点的距离
				 Integer distance=childs.get(child);
				if(distance<m){
					m=distance;
					res=child;
				}
			}
		}
		return res;
	}

	//核心方法
	private void dj(Node start){
		
		Node near =this.getShort(start);
		 if(near==null){
			 return;
		 }
		
		 close.add(near);
		 open.remove(near);
		 
		 Map<Node, Integer> Childs=near.getChild();
		 
		 for(Node child:Childs.keySet()){
			 
			 if(open.contains(child)){//证明没访问
				 
				 int a=Childs.get(child);//near -- child距离
				 
				 int b=path.get(near.getName());//a---near距离
				 
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
	
	//打印
	
	public void printPath(){
		
		Set<Map.Entry<String, String>> MM=pathinfo.entrySet();
		for(Map.Entry<String, String> ss:MM){
			System.out.println(" 键: "+ss.getKey()+" 值: "+ss.getValue());
			
			
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
