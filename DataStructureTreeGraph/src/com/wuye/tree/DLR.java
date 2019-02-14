package com.wuye.tree;





public class DLR {
 /*  二叉树的三种遍历  D L R  
  * 
  *       DATA  LCHILD RCHILD data lchild rchild 
  * 
  * 
  * 
  * 
  * 
  * */
	
	/*
	 * 				    A
	 * 				/		\
	 * 			 B             C
	 * 			/ \          /   \
	 * 		   D    E       F     G
	 *        /
	 *       H    
	 * 
	 */
	
	public  static class TreeNode{
		
		public Object data;
		
		public TreeNode leftNode;
		
		public TreeNode rightNode;
		
		TreeNode(){
			
		}
		
       TreeNode(Object data){
			this.data=data;
		}

   TreeNode(Object data,TreeNode leftNode,TreeNode rightNode){
	
	   this.data=data;
	   this.leftNode=leftNode;
	   this.rightNode=rightNode;
	
   }
	
	}
	

	
	private void printD(TreeNode parent){
		System.out.println(parent.data);
	}
	
	
	public TreeNode init(){
		TreeNode h=new TreeNode("H",null,null);
		TreeNode e=new TreeNode("E",null,null);
		TreeNode f=new TreeNode("F",null,null);
		TreeNode g=new TreeNode("G",null,null);


		TreeNode d=new TreeNode("D",h,null);


		TreeNode b=new TreeNode("B",d,e);

		TreeNode c=new TreeNode("C",f,g);
		TreeNode a=new TreeNode("A",b,c);


		return a;
		
	}
	
	
	//D L R
	public void DLR(TreeNode parent){
		printD(parent);
		if(parent.leftNode!=null){
			DLR(parent.leftNode);
		}
		 if(parent.rightNode!=null)
		{
			DLR(parent.rightNode);
		}
	}
	
	public void LDR(TreeNode parent){
		if(parent.leftNode!=null){
			LDR(parent.leftNode);
			
		}
		printD(parent);
		if(parent.rightNode!=null){
			LDR(parent.rightNode);
		}
		
	}
	
	public void LRD(TreeNode parent){
		if(parent.leftNode!=null){
			LDR(parent.leftNode);
		}
		printD(parent);
		if(parent.rightNode!=null){
		
			 LDR(parent.rightNode);
		
		     }
		}
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DLR dlr=new DLR();
		 TreeNode node=dlr.init();
		 
		 System.out.println("前序遍历:中左右 ");
		  dlr.DLR(node);
		  System.out.println("中序遍历:左中右 ");
		  dlr.LRD(node);
		  System.out.println("前序遍历:左右中 ");
		  dlr.LDR(node);
		 
		
	}

}
