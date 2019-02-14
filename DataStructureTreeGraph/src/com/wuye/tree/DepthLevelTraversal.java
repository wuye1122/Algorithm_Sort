package com.wuye.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DepthLevelTraversal {

	
	/*   
	 *   DepthOrderTraversal:深度优先遍历
	 *   
	 *   这种遍历算法将先访问树中最深层次的节点 使用java的栈进行遍历比较简单
	 * 
	 * 
	 *   LevelOrderTraversal:广度优先遍历
	 *   
	 *   使用java的队列进行遍历比较简单 更符合正常人的变量算法(一层一层的)
	 *   
	 * 
	 * 
	 *  //值得你去好好思考
	 * 
	 * 
	 * */
	
	/*
	 * 深度优先，用的Stack
	 * 
	 * 
	 * 	 				  0
	 *  				/  \
	 *  			    1  2
	 *  			   / \ / \
	 *                3  4 5 6
	 *               /\  /
	 *              7  8 9
	 * 结果是：0 1 3 7 8 4 9 2 5 6       DLR      
	 */
	
	/*
	 * 
	 * 广度优先遍历 
	 * 采用非递归实现 
	 * 需要辅助数据结构：队列 
	 * 
	 *  				 0
	 *  				/  \
	 *  			    1  2
	 *  			   / \ / \
	 *                3  4 5 6
	 *               /\  /
	 *              7  8 9
	 *  结果是：0 1 2 3 4 5 6 7 8 9
	 */
	
	
	//首先定义treeNode
	private static class TreeNode{
		
		public Object value;
		
		public TreeNode left;
		
		public TreeNode right;
		
		TreeNode(TreeNode left,Object value,TreeNode right){
			this.value=value;
			
			this.left=left;
			
			this.right=right;
			
		}
		
		
		
	}
	
	private TreeNode root;//定义根节点
	
	//使用list创建树  
	public void  createTreeList(List<Integer> lis){
		
		Queue<TreeNode> queue=new  ArrayDeque<TreeNode>();
		
		this.root=new TreeNode(null,lis.get(0),null);
		
		queue.add(root);
		
		int half=lis.size()/2;
		
		for(int i=0;i<half;i++){
			
			if(lis.get(0)!=null){
				TreeNode current=queue.poll();//返回并删除
				int left=2*i+1;
				int right=2*i+2;
				
				
				if(lis.get(left)!=null){
					current.left=new TreeNode(null,lis.get(left),null); 
					queue.add(current.left);
					
				}
				if(right<lis.size()&&lis.get(right)!=null){
					current.right=new TreeNode(null,lis.get(right),null);
					queue.add(current.right);
				}

				
			}

			
		}
		
		
	}
	
	//使用数组创建树
	public  void createTreeArray(Integer[]integer){
		
		this.root=new TreeNode(null,integer[0],null);
		
		Queue<TreeNode> queue=new ArrayDeque<TreeNode>();
		
		  queue.add(root);
		  
		  int half=integer.length/2;
		  
		  
		  for(int i=0;i<half;i++){
			  if(integer[0]!=null){
				  TreeNode current=queue.poll();
				  int left=2*i+1;
				  int right=2*i+2;
				  if(integer[left]!=null){
					  current.left=new TreeNode(null,integer[left],null);
					  queue.add(current.left);
				  }
				  if(right<integer.length&&integer[right]!=null){
					  current.right=new TreeNode(null,integer[right],null);
					  queue.add(current.right);
					  
				  }
			  }
			  
			  
		  }
		
		
	}
	
	
	//深度优先遍历  也就是 dlr
	
	public void depth(){
		
		Stack<TreeNode> stack=new Stack<TreeNode>();
		
		stack.add(root);
		System.out.print("深度优先遍历");
		while(!stack.empty()){
			TreeNode tre=stack.pop();
			System.out.print(tre.value+" ");
			
			
			//这个是压入数据  先进去右边 然后左边 因为是栈所以出来的是 2 4
			if(tre.right!=null){
				stack.push(tre.right);
			}
			if(tre.left!=null){
				stack.push(tre.left);
			}
			
		}
		
	}
	
	
	//广度优先遍历 也就是一层一层
	public void level(){
		ArrayDeque<TreeNode> deque=new ArrayDeque<TreeNode>();
		
		deque.add(root);
		
		System.out.print("广度优先遍历");
		
		while(!deque.isEmpty()){
			TreeNode tree=deque.remove();
			System.out.print(tree.value+" ");
			
			if(tree.left!=null){
				deque.add(tree.left);
			}
			if(tree.right!=null){
				deque.add(tree.right);
				
			}
			
		}
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DepthLevelTraversal dl=new DepthLevelTraversal();
		
		Integer []integer={1,2,3,4,5,6,7};
		 dl.createTreeArray(integer);
		 dl.depth();
		 System.out.println();
		 dl.level();
		 
		 List<Integer> list=new ArrayList<Integer>();
		 list.add(1);
		 list.add(2);
		 list.add(3);
		 list.add(4);
		 list.add(5);
		 list.add(6);
		 list.add(7);
		 System.out.println();
		 dl.createTreeList(list);
		 dl.depth();
		 System.out.println();
		 dl.level();
		 
		
	}

}
