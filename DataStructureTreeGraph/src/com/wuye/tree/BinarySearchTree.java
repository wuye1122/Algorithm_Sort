package com.wuye.tree;





public class BinarySearchTree <T extends Comparable<T>>{
	/*
	   Java实现二叉搜索树
	   1.若他的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
	   2.若他的右子树不空，则右子树上所有节点的值均大于它的根节点的值。
	   3.它的左、右子树也分别为排序二叉树。
	 */
	
	private BSNode<T> mRoot;//根节点
	
	public static class BSNode<T extends Comparable<T>>{
		
		public T data;
		public BSNode<T> parent;
		public BSNode<T> left;
		public BSNode<T> right;
		
		BSNode(T data,BSNode<T> parent,BSNode<T> left,BSNode<T> right){
			this.data=data;
			this.parent=parent;
			this.left=left;
			this.right=right;
		}
		
		
	}
	
	//前序遍历
	
	public void pre(BSNode<T> parent){
		
		if(parent!=null){
			System.out.println(parent.data);
			pre(parent.left);
			pre(parent.right);	
		}	
	}
	
	//中序遍历
	
	public void zhong(BSNode<T> parent){
		
		if(parent!=null){
			zhong(parent.left);
			System.out.println(parent.data);
			zhong(parent.right);	
		}	
	}
	
	//后序遍历
	
	public void hou(BSNode<T> parent){
		
		if(parent!=null){
			hou(parent.left);
			System.out.println(parent.data);
			hou(parent.right);
		}
	}
	
	//找到二叉树的二叉树最小的节点    中序   左中右--->相当于投影 最左边
	
	public BSNode<T> getMin(BSNode<T> tree){
		if(tree==null){
			return null;
		}
		while(tree.left!=null){
			
			tree=tree.left;
		}
		return tree;
	}
	
	//找到二叉树的最大节点 中序   左中右--->相当于投影 最左边
	
	public BSNode<T>getMax(BSNode<T> tree){
		if(tree==null){
			return null;
		}
		while(tree.right!=null){
			tree=tree.right;
		}
		return tree;
		
	}
	
	//二叉树的查找:  如果小就比较左面  如果大就比较右边
	
	public BSNode<T> search(BSNode<T> tree,T key){
		
		BSNode<T> newNode=null;
		
		if(tree==null){
			return null;
		}
		
		int  cmp=tree.data.compareTo(key);
		
		if(cmp<0){
			newNode=search(tree.right,key);
		}else if(cmp>0){
			newNode=search(tree.left,key);
		}else{
			return tree;//返回根节点也就是  找到了目标节点
		}
		return newNode;
		
	}
	
	//找前驱:
	
	public BSNode<T> preQu(BSNode<T> tree){
		/*  
		  *  1 如果x存在左孩子 那么x的前驱就是  以左孩子为根的子树最大节点
		  *  
		  *  2如果x是一个右孩子 那么x的前驱就是他的父节点 
		  * 
		  *  3x是一个右孩子 查找x的最低的父节点 就是前驱并且这个父节点有右孩子 
		  * 
		  *   后两种://  通俗的说，一直往上找找到最后出现左拐那次后的祖先节点;
		  *    
		  * */
		
		if(tree.left!=null){
			return getMax(tree.left);
		}
		//不管该节点在左子树还是右子树
		//都需要先找到tree的父节点
		
		BSNode<T> y=tree.parent;
		
		while(y!=null&&y.left==tree){//当tree是左孩子的时候 需要拐弯
			tree=y;
			y=y.parent;
		}
		return y;//否则 tree是右孩子 直接返回其父节点	
	}
	 
	//找后继
	
	public BSNode<T> houJi(BSNode<T> tree){
		/*
		 * 1 如果x存在右孩子 那么后继一定是以右孩子为根的最小的
		 * 
		 * 2如果x没有右孩子  x是左孩子那么后继使其父节点
		 * 
		 * 3如果x是右孩子 那么往上面拐弯 
		 * 
		 * 
		 * 
		 * */
		
		if(tree.right!=null){
			return getMin(tree.right);
		}
		BSNode<T> x=tree.parent;
		
		while(x!=null&&x.right==tree){
			
			tree=x;
			x=x.parent;
		}
		return x;
		
		
	}

	
	//二叉搜索树的插入过程
	/*
	 *  1 二叉树的数据不能相同 不可以出现重复数据
	 *  
	 *  2 保证左子树>根节点>右子树
	 *  
	 *  
	 *  数据的插入真的不理解
	 * */
	
	private static final int arr[] = {1,5,4,3,2,6};
	
	public void insert(BinarySearchTree tt,BSNode<T> node){
		
		BSNode<T> tree=tt.mRoot;
		
		BSNode<T> yy=null;
		
		if(tree==null){
			tt.mRoot=node;
		}else{
			while(tree!=null){
				int cup=node.data.compareTo(tree.data);
				
				yy=tree;//保存
				
				if(cup<0){
					
					tree=tree.left;
				}else if(cup>0){
					tree=tree.right;
				}else{
					return;
				}
			}	
				tree=yy;
				node.parent=tree;
				if(tree.data.compareTo(node.data)>0){
					tree.left=node;
				}else if(tree.data.compareTo(node.data)<0){
					tree.right=node;
				}else{
				return;
				}
			

			
		}
		
		
		
	}
	
	//二叉搜索树的删除过程
	/* 1 超级难理解
	 * 
	 * 1 被删除的是一个叶子节点 没有左孩子也没有右孩子  直接删除
	 * 
	 * 2有一个孩子节点的删除 直接将孩子作为其父节点的孩子就可以。
	 * 
	 * 3删除的节点既有左子树 也有右子树  其结果是将右子树里面最小的拿出来
	 *  
	 * 
	 *  二叉树的删除不会
	 * 
	 * */
	public BSNode<T> remove(BinarySearchTree tree,BSNode<T> node){
		
		BSNode<T> x=null;
		
		BSNode<T> y=null;
		
		if(node.left!=null||node.right!=null){//只有一个节点
			y=node;
		}else{//左右都不为空
			y=houJi(node);
		}
		
		if(y.left!=null){
			x=y.left;
		}else{
			x=y.right;
		}
		if(x!=null){
			x.parent=y.parent;//如果删除的那个节点只有一个父节点 直接堆上去
		}
		
		if(y.parent==null){
			tree.mRoot=x;
			
		}else if (y==y.parent.left){
			y.parent.left=x;
			
		}else{
			y.parent.right=x;
		}
		if(y!=node){
			node.data=y.data;
		}
		return y;
		
	}
	
	
	
	//二叉搜索树的遍历过程
	
	/*
	 * 打印"二叉查找树"
	 *
	 * key        -- 节点的键值 
	 * direction  --  0，表示该节点是根节点;
	 *               -1，表示该节点是它的父结点的左孩子;
	 *                1，表示该节点是它的父结点的右孩子。
	 */
	

	public void printTree(BSNode<T> tree ,T data,int decr){
		if(tree!=null){
			
			if(decr==0){
				System.out.println("根节点是:"+tree.data);
			}else{
				
				System.out.println(tree.data +"是"+data+" "+ (decr==1?"右孩子":"左孩子"));
				
			}
			
			printTree(tree.left,tree.data,-1);
			printTree(tree.right,tree.data,1);
			
			
		}
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree tree=new BinarySearchTree();
	
	    for(int i=0;i<tree.arr.length;i++){
	    	System.out.println(arr[i]);
	   tree.insert(tree, new BSNode(arr[i],null,null,null));
	    }
	   tree.printTree(tree.mRoot, tree.mRoot.data, 0);     
	
	   /*
		 * 		    1
		 * 		     \ 
		 *            5
		 *          /   \
		 *         4     6
		 *        /
		 *       3
		 *      /
		 *     2
		 */
		
		System.out.println("树的前序遍历遍历如下");
		tree.pre(tree.mRoot);
		System.out.println("树的中序遍历遍历如下");
		tree.zhong(tree.mRoot);
		System.out.println("树的后序遍历遍历如下");
		tree.hou(tree.mRoot);
		
		System.out.println("最大 最小前驱后继 外加搜索以下实例");
		System.out.println("最大:"+tree.getMax(tree.mRoot).data); 
		System.out.println("最小:"+tree.getMin(tree.mRoot).data); 
	
	
     System.out.println("前驱:"+tree.preQu(tree.search(tree.mRoot, 4)).data);
	 System.out.println("后继:"+tree.houJi(tree.search(tree.mRoot, 3)).data); 
	 System.out.println("下面进行难度很大的删除");
	
	 tree.remove(tree,tree.search(tree.mRoot, 5));
	   tree.printTree(tree.mRoot, tree.mRoot.data, 0);
	 
	 
	}

}
