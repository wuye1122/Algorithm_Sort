package com.wuye.search;

public class AVLTree<T extends Comparable<T>> {

	 
	  class Node<T extends Comparable<T>>{
		  
		  private T key;
		  
		  public int heigth;
		  
		  private Node<T> left;
		  
		  private Node<T> right;
		  
		  Node(T key,Node<T>left,Node<T>right){
			  this.key=key;
			  this.left=left;
			  this.right=right;
		     this.heigth=0;
			  
		  }
	  } 
	
	  private Node<T> mroot;//根节点
	  
	  AVLTree(){
		this.mroot=null;  
	  }
	
	  
	  //返回数的高度
	  
	  public int getHeight(Node<T> tree){
		  
		  if(tree!=null){
			  return tree.heigth;
		  }
		  return 0;
	  }
	
	  
	  public int getHeight(){
		  return getHeight(mroot);
	  } 
	  
	  
	  //比较大小
	  
	  public int max(int a,int b){
		  return a>b?a:b;
	  }
	  
	  
	  //前序遍历
	  
	  public void pre(Node<T> tree){
		  
		  if(tree!=null){
			  
			  System.out.print(tree.key+" ");
			  pre(tree.left);
			  pre(tree.right);
			  
		  }
	  }
	  public void pre(){
		  pre(this.mroot); 
	  }
	  //中序遍历 
	  public void inter(Node<T> tree){
		  
		  if(tree!=null){
			  inter(tree.left);
			  System.out.print(tree.key+" ");
			  inter(tree.right);
		  }
	  }
	  public void  inter(){
		  inter(this.mroot);
	  }
	  
	  //后序遍历
	  public void pos(Node<T> tree){
		  if(tree!=null){
			  pos(tree.left);
			  pos(tree.right);
			  System.out.print(tree.key+" ");
		  }
	  }
	  
	  public void pos(){
		  pos(this.mroot);
	  }
	  
	  
	  //找到最小的
	  
	  public Node<T> getMin(Node<T> tree){
		  if(tree==null){
			  return null;
		  }
		  while(tree.left!=null){
			  tree=tree.left;
			  
		  }
		return tree;
		  
	  }
	  
	  public T getMin(){
		  Node<T> node=getMin(this.mroot);
		  if(node!=null){
			  return node.key;
		  }
		  return null;
	  }
	  
	  //找到最大的
	   
	  public Node<T> getMax(Node<T> tree){
		  if(tree==null){
			  return null;
		  }
		  
		  while(tree.right!=null){
			  tree=tree.right;
		  }
		return tree;
	  }
	  
	  public T getMax(){
		  
		  Node<T> node=getMax(this.mroot);
		  if(node!=null){
			  return node.key;
		  }
		  return null;
	  }
		/*
		 * LL：左左对应的情况(左单旋转)。
		 *        2
		 *     A                     B     
		 *    /  1                 /   \
		 *   B   -->>LL--->>      X     A
		 *  /  0
		 * X
		 * 返回值：旋转后的根节点
		 * (插入的节点是左子树的左边节点)
		 */
	  
	     //返回旋转之后的根节点
	     public Node<T> LL(Node<T> k1){//输入的k1相当于 ll的根节点
	    	 Node<T> k;
	    	 
	    	 k=k1.left;
	    	 k1.left=k.right;
	    	 k.right=k1;
	    	 
	    	 k1.heigth=max(getHeight(k1.left),getHeight(k1.right))+1;
	    	 k.heigth=max(getHeight(k.left),k1.heigth)+1;
			
	    	 
	    	 return k;
	    	 
	     }
	  
	  
	  
		/*
		 * RR：右右对应的情况(右单旋转)。
		 *
		 *      -2                              0
		 *     A                               B     
		 *      \ -1                         /0  \0
		 *       B         -->>RR--->>      A     X
		 *        \ 0
		 *         X
		 *
		 *(插入节点是右子树的右边节点)
		 * 返回值：旋转后的根节点
		 */
	     
	     public Node<T> RR(Node<T> k2){
	    	 
	    	 Node<T> k3;
	    	 k3=k2.right;
	    	 k2.right=k3.left;
	    	 k3.left=k2;
	    	 
	    	 k2.heigth=max(getHeight(k2.left),getHeight(k2.right))+1;
	    	 k3.heigth=max(getHeight(k3.right),k2.heigth)+1;
	    	 
	    	 return k3;
	     }
	  
	  
	     //当加入的是左子树的右节点
	     /*
	 	 * LR：左右对应的情况(左双旋转)。--对应RR-LL
	 	 *(插入节点是左子树的右边节点)
	 	 * 返回值：旋转后的根节点
	 	 */
	     public Node<T> LR(Node<T> k){
	    	 
	    	 k.left=RR(k.left);
	    	 
	    	 return LL(k);
	     }
	     
	     //当加入的是右子树的左节点
	     /*
	 	 * RL：右左对应的情况(右双旋转)。对应 LL-RR
	 	 *(插入节点是右子树的左边节点)
	 	 * 返回值：旋转后的根节点
	 	 */
	     public Node<T> RL(Node<T> k){
	    	 
	    	 k.right=LL(k.right);
	    	 return RR(k);
	     }
	     
	     //真正的插入
	     private Node<T> insert(Node<T>tree,T key){
	    	 if(tree==null){
	    		 //新建节点
	    		 tree=new Node<T>(key,null,null);
	    		 
	    	 }else{
	    		 
	    		 int cmp=key.compareTo(tree.key);//来比较在左右树里面插入
	    		 if(cmp<0){
	    			 
	    			 tree.left=insert(tree.left,key);
	    			 
	    			 
	    			 if(getHeight(tree.left)-getHeight(tree.right)==2){
	    				 
	    				 if(key.compareTo(tree.left.key)<0){
	    					 
	    					 tree=LL(tree);
	    				 }
	    			     else{
	    				  tree=LR(tree);}
	    			 }
	    			 
	    			 
	    		 }else if(cmp>0){
	    			 tree.right=insert(tree.right,key); 
	    			 if(getHeight(tree.right)-getHeight(tree.left)==2){
	    				 if(key.compareTo(tree.right.key)>0){
	    					 tree=RR(tree);
	    				 }else{
	    					 tree=RL(tree);
	    				 }
	    				 
	    			 }
	    			
	    			 
	    			 
	    		 }else{
	    			 //cmp=0
	    			 System.out.println("不能插入相同的节点");
	    			 
	    		     }
	    			 
	    	 }
	    	 tree.heigth=max(getHeight(tree.left),getHeight(tree.right))+1;
			return tree;
	 
	     }
	     
	     //插入
	     
	     public void insert(T key){
	    	this.mroot=insert(this.mroot,key);
	     }
	     
	    
	     private static int arr[]= {3,2,1,4,5,6,7,10,9,8};
	     
	     //打印
	     /*
	 	 * 打印"二叉查找树"
	 	 *
	 	 * key        -- 节点的键值 
	 	 * direction  --  0，表示该节点是根节点;
	 	 *               -1，表示该节点是它的父结点的左孩子;
	 	 *                1，表示该节点是它的父结点的右孩子。
	 	 */
	 	private void print(Node<T> tree, T key, int direction) {
	 		if(tree != null) {
	 			if(direction==0)    // tree是根节点
	 				System.out.printf("%2d is root\n", tree.key, key);
	 			else                // tree是分支节点
	 				System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction==1?"right" : "left");

	 			print(tree.left, tree.key, -1);
	 			print(tree.right,tree.key,  1);
	 		}
	 	}
	 	public void print() {
			if (this.mroot != null)
				print(mroot, mroot.key, 0);
		}
	     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		AVLTree<Integer> tree = new AVLTree<Integer>();

		System.out.printf("== 依次添加: ");
		for(i=0; i<arr.length; i++) {
			
			tree.insert(arr[i]);
			System.out.printf("%d ", arr[i]);
		}

		System.out.printf("\n== 前序遍历: ");
		tree.pre();

		System.out.printf("\n== 中序遍历: ");
		tree.inter();

		System.out.printf("\n== 后序遍历: ");
		tree.pos();
		System.out.printf("\n");

		System.out.printf("== 高度: %d\n", tree.getHeight());
		System.out.printf("== 最小值: %d\n", tree.getMin());
		System.out.printf("== 最大值: %d\n", tree.getMax());
		System.out.printf("== 树的详细信息: \n");
		tree.print();
	}

}
