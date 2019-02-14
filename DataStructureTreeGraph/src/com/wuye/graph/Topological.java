package com.wuye.graph;

import java.util.LinkedList;
import java.util.Queue;


public class Topological {
/*
 * 主要针对:将一个有向无环图 DAG 进行排序进而得到的一个有序的线性序列
 *  
 *       就是按照箭头的顺序 将依赖关系最弱的先遍历出来 
 *       
 *       
 *      
 * 
 * */
	//首先定义节点类
		private class ENode{
			public int tp;
	     
			public ENode nextNode;
		}

		//其次定义顶点类
		private class TOP{
			public String data;

			public ENode first;

		}

		public TOP[] top;//定义顶点数组


		//构造器进行初始化节点 和边
		Topological(String [] ch,String[][]ch1){


			//进行初始化节点
			top=new TOP[ch.length];
			for(int i=0;i<ch.length;i++){
				top[i]=new TOP();
				top[i].data=ch[i];
				top[i].first=null;//暂时还没有节点 也就是没遍历边呢
			}


			for(int i=0;i<ch1.length;i++){

				int p1=getPostion(ch1[i][0]);
				int p2=getPostion(ch1[i][1]);
				
				
				
				ENode en=new ENode();//新建节点

				en.tp=p2;
	        
				if(top[p1].first==null){
					top[p1].first=en;
				}else{
					lastNode(top[p1].first,en);
				}
			}

		}
		
		//无向图  这种定义无向图的比较方便  一个边只需要定义第一就行
		
		
		//返回指定索引子在top里面索引

		public int getPostion(String ch){
			for(int i=0;i<top.length;i++){
				if(top[i].data.equals(ch)){
					return i;
				}
			}
			return -1;//没找到

		}

		//将新的节点连接到前面节点上面
		public void lastNode(ENode list,ENode node){
			ENode pp=list;
			while(pp.nextNode!=null){
				pp=pp.nextNode;
			}
			pp.nextNode=node;
		}


		//下面进行打印

		public void  printList(){

			for(int i=0;i<top.length;i++){

				System.out.print(i+"["+top[i].data+"]:");
				ENode pp=top[i].first;
				while(pp!=null){
					System.out.print(pp.tp+"("+top[pp.tp].data+")");
					pp=pp.nextNode;
				}
				System.out.println(" ");
			}	
		}
		
		
		
		//进行拓扑排序
		public int tipolo(){
			
			int index=0;
			
			int num=this.top.length;
			
			Queue<Integer> queue=new LinkedList<Integer>();// 辅助队列
			
			int [] ru=new int[num];//定义入度数组
			
			String[] results=new String[num];//排序出来的顺序
		
		   for(int i=0;i<num;i++){
			   ENode node=top[i].first;
			   while(node!=null){
				   ru[node.tp]++;
				   node=node.nextNode;
			   }
		   }
		
		   
		    //将入度为0的节点加入队列里面
		    for(int i=0;i<num;i++){
		    	if(ru[i]==0){
		    		queue.offer(i);
		    	}
		    }
		    
		    while(!queue.isEmpty()){
		    	
		    	int j=queue.poll().intValue();//取出
		    	
		    	//将结果填入到数组里面 results
		    	results[index++]=top[j].data;
		    	
		    	
		    	//取出节点执向的节点
		    	ENode node=top[j].first;
		    	
		    	while(node!=null){
		    		
		    		
		    		ru[node.tp]--;
		    		
		    		if(ru[node.tp]==0){
		    			queue.offer(node.tp);
		    		}
		    	    node=node.nextNode;
		    	}
		    	
		    }
		    
		    if(index!=num){
		    	System.out.println("图是环");
		    	return 1;
		    }
		    
		    System.out.println("图的拓扑排序如下:");
		    for(int i=0;i<num;i++){
		    	System.out.println(results[i]);
		    }
			return 0;
		    
		}
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String[] vexs = {"A", "B", "C", "D", "E", "F", "G"};//顶点数组
	        String[][] edges = new String[][]{//边数组，例如A->G B->A等
	            {"A", "G"}, 
	            {"B", "A"}, 
	            {"B", "D"}, 
	            {"C", "F"}, 
	            {"C", "G"}, 
	            {"D", "E"}, 
	            {"D", "F"}}; 
	        Topological topolog=new Topological(vexs,edges);
	        topolog.printList();
	        
	        System.out.println("有向图的遍历如上:下面进行拓扑排序");
	        
	        topolog.tipolo();
	        
	}

}
