package com.wuye.tree;

import java.util.ArrayList;
import java.util.List;



public class SonExpress <E>{
//树的第二种形式    子链表示法
	/*
	 * 
	 * 
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
	 * 
	 * 
	 * */
private int treesize=100;
	
	private  Node<E> nodes[];
	
	private int treenum;
	
//定义子节点
	
	public  static class SonNode{

		private	SonNode next;//子节点  下面跟着子节点

		private	int pos;//记录当前子节点   指向父节点的索引

		SonNode(int pos,SonNode next){
			this.pos=pos;

			this.next=next;
		}
		
		// 子节点无法遍历:
		/*    public String toString(){
			
			if(this.next==null){
				return "!该父节点没有子节点"+"";
			}else{
				SonNode son=this.next;
				while(son!=null){
					System.out.print("子节点:"+nodes[son.pos]);
					son=son.next;
					
				}
				
			}
			
			return  "子节点值:"+nodes[this.pos];
		}*/

	}
	
	
//定义数组里面节点
	
	
	public static class Node<T>{
		
		private T data ;
		
		private SonNode son;
		
		//填入数组的时候 只是将数据填入里面 不去管儿子
		public Node(T data){
			this.data=data;
			this.son=null;
		}
		
		public String toString(){
			
			
			return "数组节点:Node="+data;
			
			
		}
		
	 }
	
	
	
	
	
	//首先填入第一个元素
	SonExpress(E data){
		
		nodes=new Node[treesize];
		nodes[0]=new Node(data);
	    treenum++;
	}
//返回根部节点
	
	public Node getRoot(){
		return nodes[0];
	}
	
//填入元素  为指定节点添加子节点
	
	/*   1 将元素添加到nodes数组里面  
	 * 
	 *   2 数组里面除了第一个之外 每一个节点都是依赖其他节点而存在 指定数据的父节点 
	 * 
	 * 
	 * 
	 * */
	public void addNode(E data,Node<E> parent){
		
		for(int i=0;i<treesize;i++){
			
			
			if(nodes[i]==null){
				
				nodes[i]=new Node(data);//将数据赋值
			   
			    if(parent.son==null){
			    	  
			    	    //(int pos,SonNode next)
			    	parent.son=new SonNode(i,null);
			    }
			
			    else{
				
				//如果父亲后面有很多的儿子  取出大儿子
				SonNode nex=parent.son;
				
				
				
				while(nex.next!=null){
					nex=nex.next;//找到没有弟弟的那个儿子 
				 }
				
				//新的儿子加入
				nex.next=new SonNode(i,null);
				
			        }
			this.treenum++;
			return;
		}
	}
		throw new RuntimeException("树已经满了不能进行插入");
	}
	
//根据节点获取索引
	
	public int getDeep(Node node){
		if(node.son==null){
			return 1;//如果只有自己的 就等于1
		}
		else{
			
			//需要递归
			
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
			
			//很有必要
			if(nodes[i]!=null&&nodes[i]==node){
			return i;	
			}
		}
		return -1;
	}
	
	
//根据元素获取节点	
	
	
	public Node<E> getNodeByData(E data){
		
		for(int i=0;i<treesize;i++){
			
			//比较的是数据是否一致  出现一个bug 自己回忆
			if(nodes[i]!=null&&nodes[i].data.equals(data)){
				return nodes[i];
			}
			
			
		}
		return null;
		
	}
	
	
//获取元素的子节点
	
		
	public List<Node> getChild(Node parent){
		List<Node> list=new ArrayList();
		
		 SonNode son=parent.son;
		 if(parent.son==null){
			 list.add(null);
			 return list;
		 }
		 while(son!=null){
			 
			 //此处获取的子节点  最后 还是Node注意
			 list.add(nodes[son.pos]);
			 
			 son=son.next;
		 }
		return list;
		
	}
//下面进行节点的度的计算:
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SonExpress se=new SonExpress("A");
		
		se.addNode("B", se.getNodeByData("A"));
		
		se.addNode("C", se.getNodeByData("A"));
		
		se.addNode("D", se.getNodeByData("A"));
		
		
		se.addNode("E", se.getNodeByData("C"));
		
		se.addNode("F", se.getNodeByData("D"));
		
		
		 System.out.println("此树的遍历如下:");
	       for(int i=0;i<se.treenum;i++){
	    	   
	    	   System.out.println(i+se.nodes[i].toString());  
	    	
                    
	    	  
	       }
	       System.out.println();
	       System.out.println("从数据找到节点getNodeByData:|从节点找索引getIndex:"+se.getIndex(se.getNodeByData("A")));
	       System.out.println("从数据找到节点getNodeByData:|从节点找索引getIndex:"+se.getIndex(se.getNodeByData("F"))); 
	       System.out.println("从数据找到节点getNodeByData:|从节点找索引getIndex:"+se.getIndex(se.getNodeByData("Z")));
		
	      
	       
	       System.out.println(se.getIndex(se.getNodeByData("Z")));
	       System.out.println(se.getIndex(null));
	       
	       System.out.println("树的节点总数:"+se.treenum);
	       System.out.println("树的根节点:"+se.getRoot().data);
	       
	       
	  List<Node> list1 =se.getChild(se.getNodeByData("A"));
	       
	  for(Node ne:list1){
		  System.out.println("子节点:"+ne);
	  }
	 
	  System.out.println("此树的深度:"+se.getDeep(se.getNodeByData("A")));
	  
	}

}
