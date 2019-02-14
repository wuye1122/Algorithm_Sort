package com.wuye.tree;

import java.util.ArrayList;
import java.util.List;

public class ParentExpress<E> {
 /*  
  *  1 父节点表示法: 记录节点的索引 和 parent处的索引 也就是父节点的索引
  * 树的表示法：基础而又重要【父节点表示法】【子节点链式表示法】

             
              A:父节点表示法

                每个节点都记录它的父节点  树里面除了根节点之外 其余的每个子节点都有一个父节点

                为了记录树中的节点与节点之间的关系 为每一个节点增加一个 parent域

                根节点的parent域处是-1

              * 父节点表示法是让每个节点记住它的根节点的索引，该种方法是从子节点入手的 

              * BBS 主贴与回帖 
           
              B:让父节点记住所有的子节点，就会造成一个节点有很多的子节点  使用子节点链表示法  
                                  
                
  * 
  * 
  * */
	
	
	//内部类 关于节点
	public static class Node<T>{
		
		T data;//节点数据
		
		int parent;
		
		public  Node(T data,int parent){
			
			this.data=data;
			
			this.parent=parent;
			
		}
		
		private String toSring() {
			// TODO Auto-generated method stub
          return "父节点表示法:【data:"+data+",parent"+parent+"】";
			
		}
	
	} 
//树的总数量
			private int treesize=100;
			//在主函数设置不赶趟 因为 构造器里面用到数的总结点树
			
//节点的数量
			private int nodenum;
			
//表示节点的数组
			private Node nodes[];
			
			
//添加父节点
	        ParentExpress(E data){
		   
		     nodes=new Node[treesize];
		          
		       //把父节点添加进来了
		     nodes[0]=new Node<E>(data, -1);
		
		     nodenum++;
	       }
	        
//返回节点处的索引
	        
	        
	        public int getIndex(Node node){
	        	
	        	for(int i=0;i<treesize;i++){
	        		if(nodes[i]!=null&&nodes[i]==node){
	        			
	        			return i;
	        		}
	        		
	        	}
				return -1;
	        }
	        
//为该树添加一个节点
	        public void addNode(E data,Node parent){
	        	
	        	for(int i=0;i<treesize;i++){
	        		 
	        		
	        		//没有节点自己创建
	        		if(nodes[i]==null){
	        			nodes[i]=new Node(data,getIndex(parent));
	        			
	        			 nodenum++;
	        			 return;
	        		}
	
	        	}
	        	
	        	throw new RuntimeException("树已经满了不能插入了");
	        	
	        }
	        
//返回根节点
	        
	        public Node getRoot(){
	        	
	        	return nodes[0];
	        }
	        
	        
//找到指定数据对应的节点
	        
	        
	        public Node<E> getNodeByData(E data){
	        	for(int i=0;i<treesize;i++){
	        		if(nodes[i]!=null&&nodes[i].data.equals(data)){
	        			return nodes[i];
	        		}      		
	        	}
				return null;

	        }
	
//找到指定节点的所以孩子
	        
	        
	        public List<Node> getClildren(Node parent){
	        	List<Node> list=new ArrayList(); 
	        	
	        	for(int i=0;i<treesize;i++){
	        		if(nodes[i]!=null&&nodes[i].parent==getIndex(parent)){
	        			list.add(nodes[i]);
	        		}	
	        	}
				return list;
	        }
	        
//返回树的深度
	        public int getDeep(){
	        
	        	//记录节点到父节点最大值
	        	
	        	int  max=0;
	        	
	        	for(int i=1;i<treesize&&nodes[i]!=null;i++){
	        		
	        		int def=1;//初始化 从第二排开始
	        		
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
	       
	       
	       System.out.println("需要 在 代码里面提前设置树的总结点数");
	       System.out.println("getroot:返回根部节点"+px.getRoot().data);
	       System.out.println("此树的深度:"+px.getDeep());
	       System.out.println("此树有多少个节点:"+px.nodenum);
	       System.out.println();
	       System.out.println("此树的遍历如下:");
	       for(int i=0;i<px.nodenum;i++){
	    	   
	    	   System.out.println(i+px.nodes[i].toSring());  
	    	   
	       }
	       System.out.println();
	       
	       
	       System.out.println("从数据找到节点getNodeByData:|从节点找索引getIndex:"+px.getIndex(px.getNodeByData("A")));
	       System.out.println("从数据找到节点getNodeByData:|从节点找索引getIndex:"+px.getIndex(px.getNodeByData("F"))); 
	       System.out.println("从数据找到节点getNodeByData:|从节点找索引getIndex:"+px.getIndex(px.getNodeByData("O")));

	     List<Node> lis=px.getClildren(px.getNodeByData("A"));
	     
	     for(Node n:lis){
	    	 System.out.print(n.data);
	    	 
	     }
	}

}
