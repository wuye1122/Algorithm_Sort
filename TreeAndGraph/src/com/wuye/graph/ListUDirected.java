package com.wuye.graph;

public class ListUDirected {
	/*
	 *  无向图邻接表  有向图邻接表全在这里面
	 * 
	 *  * 含有weight域的地方 在定义ENode类的时候  添加一个属性int weight
	 *  
	 *    在进行初始化的时候 int weight=edge[i][2];取出weight
	 * 
	 *  有向图邻接表 
	 * 
	 * */
	//首先定义节点类
	private class ENode{
		public int tp;
        public int weight; 
		public ENode nextNode;
	}

	//其次定义顶点类
	private class TOP{
		public String data;

		public ENode first;

	}

	public TOP[] top;//定义顶点数组


	//构造器进行初始化节点 和边
	ListUDirected(String [] ch,String[][]ch1){


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
			int weight=Integer.parseInt(ch1[i][2]);
			
			
			ENode en=new ENode();//新建节点

			en.tp=p2;
            en.weight=weight;
			if(top[p1].first==null){
				top[p1].first=en;
			}else{
				lastNode(top[p1].first,en);
			}
		}

	}
	
	//无向图  这种定义无向图的比较方便  一个边只需要定义第一就行
	ListUDirected(String[][]ch1,String [] ch){


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
			int weight=Integer.parseInt(ch1[i][2]);

			ENode en=new ENode();//新建节点

			en.tp=p2;
			en.weight=weight;

			if(top[p1].first==null){
				top[p1].first=en;
			}else{
				lastNode(top[p1].first,en);
			}
			
			ENode en1=new ENode();
			en1.tp=p1;
			en1.weight=weight;
			if(top[p2].first==null){
				top[p2].first=en1;
			}else{
				lastNode(top[p2].first,en1);
				
			}
			
		}

	}
	
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
				System.out.print(pp.tp+"("+top[pp.tp].data+")"+"权值"+pp.weight+"  ");
				pp=pp.nextNode;
			}
			System.out.println(" ");
		}	
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String []str={"A","B","C"};
      
      String [][]str1={{"A","B","3"},{"B","C","4"},{"A","C","5"}};
		ListUDirected lud=new ListUDirected(str,str1);
		System.out.println("以下是有向图的邻接表");
		lud.printList();
		
		
		 String [][]str2={{"A","B","2"},{"B","A","2"},{"B","C","3"},{"C","B","3"},{"A","C","4"},{"C","A","4"}};
		ListUDirected lud2=new ListUDirected(str,str2);
		System.out.println();
		System.out.println("以下是无向图的邻接表");
		lud2.printList();
		
		  
	}

}
