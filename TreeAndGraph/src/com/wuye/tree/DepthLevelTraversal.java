package com.wuye.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DepthLevelTraversal {

	
	/*   
	 *   DepthOrderTraversal:������ȱ���
	 *   
	 *   ���ֱ����㷨���ȷ������������εĽڵ� ʹ��java��ջ���б����Ƚϼ�
	 * 
	 * 
	 *   LevelOrderTraversal:������ȱ���
	 *   
	 *   ʹ��java�Ķ��н��б����Ƚϼ� �����������˵ı����㷨(һ��һ���)
	 *   
	 * 
	 * 
	 *  //ֵ����ȥ�ú�˼��
	 * 
	 * 
	 * */
	
	/*
	 * ������ȣ��õ�Stack
	 * 
	 * 
	 * 	 				  0
	 *  				/  \
	 *  			    1  2
	 *  			   / \ / \
	 *                3  4 5 6
	 *               /\  /
	 *              7  8 9
	 * ����ǣ�0 1 3 7 8 4 9 2 5 6       DLR      
	 */
	
	/*
	 * 
	 * ������ȱ��� 
	 * ���÷ǵݹ�ʵ�� 
	 * ��Ҫ�������ݽṹ������ 
	 * 
	 *  				 0
	 *  				/  \
	 *  			    1  2
	 *  			   / \ / \
	 *                3  4 5 6
	 *               /\  /
	 *              7  8 9
	 *  ����ǣ�0 1 2 3 4 5 6 7 8 9
	 */
	
	
	//���ȶ���treeNode
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
	
	private TreeNode root;//������ڵ�
	
	//ʹ��list������  
	public void  createTreeList(List<Integer> lis){
		
		Queue<TreeNode> queue=new  ArrayDeque<TreeNode>();
		
		this.root=new TreeNode(null,lis.get(0),null);
		
		queue.add(root);
		
		int half=lis.size()/2;
		
		for(int i=0;i<half;i++){
			
			if(lis.get(0)!=null){
				TreeNode current=queue.poll();//���ز�ɾ��
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
	
	//ʹ�����鴴����
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
	
	
	//������ȱ���  Ҳ���� dlr
	
	public void depth(){
		
		Stack<TreeNode> stack=new Stack<TreeNode>();
		
		stack.add(root);
		System.out.print("������ȱ���");
		while(!stack.empty()){
			TreeNode tre=stack.pop();
			System.out.print(tre.value+" ");
			
			
			//�����ѹ������  �Ƚ�ȥ�ұ� Ȼ����� ��Ϊ��ջ���Գ������� 2 4
			if(tre.right!=null){
				stack.push(tre.right);
			}
			if(tre.left!=null){
				stack.push(tre.left);
			}
			
		}
		
	}
	
	
	//������ȱ��� Ҳ����һ��һ��
	public void level(){
		ArrayDeque<TreeNode> deque=new ArrayDeque<TreeNode>();
		
		deque.add(root);
		
		System.out.print("������ȱ���");
		
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
