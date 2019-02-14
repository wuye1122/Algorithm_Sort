package com.wuye.tree;

public class LinkedBinTree {

/* -链式存储  没有限制 不会浪费空间 

     二叉树链式存储的意思就是让每个节点记住它的左右两个子节点

     缺点是 遍历节点时效率不高 指定节点访问其父节点也比较困难                             
    
    该方法在添加子节点没有限制，而且也不会浪费大量的空间，
  
   缺点是遍历树节点时效率不高，指定节点访问其父节点时也比较困难。
     *
     *
     */
	
	//首先定义树节点	
	public static class TreeNode{
		
		private Object data;
		
		private TreeNode leftNode;
		
		private TreeNode rightNode;
		TreeNode(Object data){
			this.data=data;
		}
		
		TreeNode(Object data,TreeNode leftNode,TreeNode rightNode){
			this.data=data;
			this.leftNode=leftNode;
			this.rightNode=rightNode;
		}	
		
		
	}
	
	
	//此处存在一个表里链表表示的二叉树  遍历出现一处错误
	/*public  String toString(){
		
		if(empty()){
			return "该树是空的";
		}
		
		while(this.root!=null){
			System.out.println("该节点数据"+this.root.data);
			TreeNode lef=this.root.leftNode;
			
			boolean flag=true;
             while(lef.leftNode!=null){
            	 System.out.println("该节点左节点是"+lef.data);
                lef=lef.leftNode;
                
             }
             
			
			TreeNode right=this.root.rightNode;
			  while(right.rightNode!=null){
	            	 System.out.println("该节点右节点是"+right.data);
	                right=right.rightNode;
	             }
			this.root=this.root.leftNode;
		}
		return null;
		
	}*/
	private TreeNode root;
	
	//将根节点定义
	LinkedBinTree(Object data){
		this.root=new TreeNode(data);
	}
	
	//添加节点
	                                              //增加的是否有左节点
	public TreeNode addNode(TreeNode parent,Object data,boolean isleft){
		
		if(parent==null){
			throw new RuntimeException(parent +
					"节点为null，无法添加子节点");
		}
		
		if(isleft&&parent.leftNode!=null){
			throw new RuntimeException(parent +
					"已经有左节点了");
		}
		if(!isleft&&parent.rightNode!=null){
			throw new RuntimeException(parent +
					"已经有右节点了");
		}
		TreeNode newNode=new TreeNode(data);
		if(isleft){
			parent.leftNode=newNode;
		}else{
			parent.rightNode=newNode;
		}
		return newNode;
		
	}
	
	//返回根节点
	public TreeNode getRoot(){
		if(empty()){
			throw new RuntimeException("树为空 出现错误");
		}
		return this.root;
	}
	
	//判断是否为null
	
	public boolean empty(){
		
		return this.root.data==null;
	}
	
	//返回指定节点的左节点或者右节点
	public TreeNode getLeft(TreeNode parent){
		return parent.leftNode!=null?parent.leftNode:null;
	}
	
	public TreeNode getRight(TreeNode parent){
		return parent.rightNode!=null?parent.rightNode:null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBinTree lb=new LinkedBinTree("A");
		
		System.out.println("获取根节点"+lb.getRoot().data);
		
		 TreeNode al=lb.addNode(lb.getRoot(), "B", true);
		 TreeNode ar=lb.addNode(lb.getRoot(), "C", false);
		 
		 TreeNode bl=lb.addNode(al, "D", true);
		 TreeNode br=lb.addNode(ar, "E", false);
		 
		 System.out.println("是否为空"+lb.empty());
		 
		 
		 System.out.println("A左节点"+lb.getLeft(lb.getRoot()).data);
		 System.out.println("A右节点"+lb.getRight(lb.getRoot()).data);
		 
		 
		 
		 //添加的时候  A  BC
		 //         D   E   --->   也就是D添加成B的左节点E添加成C的右节点
		 System.out.println("B左节点"+lb.getLeft(al).data);
		 System.out.println("C右节点"+lb.getRight(ar).data);
		 
		 System.out.println(lb.toString());
		 
	}

}
