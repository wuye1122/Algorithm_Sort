package com.wuye.tree;





public class BinarySearchTree <T extends Comparable<T>>{
	/*
	   Javaʵ�ֶ���������
	   1.���������������գ��������������нڵ��ֵ��С�����ĸ��ڵ��ֵ��
	   2.���������������գ��������������нڵ��ֵ���������ĸ��ڵ��ֵ��
	   3.������������Ҳ�ֱ�Ϊ�����������
	 */
	
	private BSNode<T> mRoot;//���ڵ�
	
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
	
	//ǰ�����
	
	public void pre(BSNode<T> parent){
		
		if(parent!=null){
			System.out.println(parent.data);
			pre(parent.left);
			pre(parent.right);	
		}	
	}
	
	//�������
	
	public void zhong(BSNode<T> parent){
		
		if(parent!=null){
			zhong(parent.left);
			System.out.println(parent.data);
			zhong(parent.right);	
		}	
	}
	
	//�������
	
	public void hou(BSNode<T> parent){
		
		if(parent!=null){
			hou(parent.left);
			System.out.println(parent.data);
			hou(parent.right);
		}
	}
	
	//�ҵ��������Ķ�������С�Ľڵ�    ����   ������--->�൱��ͶӰ �����
	
	public BSNode<T> getMin(BSNode<T> tree){
		if(tree==null){
			return null;
		}
		while(tree.left!=null){
			
			tree=tree.left;
		}
		return tree;
	}
	
	//�ҵ������������ڵ� ����   ������--->�൱��ͶӰ �����
	
	public BSNode<T>getMax(BSNode<T> tree){
		if(tree==null){
			return null;
		}
		while(tree.right!=null){
			tree=tree.right;
		}
		return tree;
		
	}
	
	//�������Ĳ���:  ���С�ͱȽ�����  �����ͱȽ��ұ�
	
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
			return tree;//���ظ��ڵ�Ҳ����  �ҵ���Ŀ��ڵ�
		}
		return newNode;
		
	}
	
	//��ǰ��:
	
	public BSNode<T> preQu(BSNode<T> tree){
		/*  
		  *  1 ���x�������� ��ôx��ǰ������  ������Ϊ�����������ڵ�
		  *  
		  *  2���x��һ���Һ��� ��ôx��ǰ���������ĸ��ڵ� 
		  * 
		  *  3x��һ���Һ��� ����x����͵ĸ��ڵ� ����ǰ������������ڵ����Һ��� 
		  * 
		  *   ������://  ͨ�׵�˵��һֱ�������ҵ�����������Ǵκ�����Ƚڵ�;
		  *    
		  * */
		
		if(tree.left!=null){
			return getMax(tree.left);
		}
		//���ܸýڵ�������������������
		//����Ҫ���ҵ�tree�ĸ��ڵ�
		
		BSNode<T> y=tree.parent;
		
		while(y!=null&&y.left==tree){//��tree�����ӵ�ʱ�� ��Ҫ����
			tree=y;
			y=y.parent;
		}
		return y;//���� tree���Һ��� ֱ�ӷ����丸�ڵ�	
	}
	 
	//�Һ��
	
	public BSNode<T> houJi(BSNode<T> tree){
		/*
		 * 1 ���x�����Һ��� ��ô���һ�������Һ���Ϊ������С��
		 * 
		 * 2���xû���Һ���  x��������ô���ʹ�丸�ڵ�
		 * 
		 * 3���x���Һ��� ��ô��������� 
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

	
	//�����������Ĳ������
	/*
	 *  1 �����������ݲ�����ͬ �����Գ����ظ�����
	 *  
	 *  2 ��֤������>���ڵ�>������
	 *  
	 *  
	 *  ���ݵĲ�����Ĳ����
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
				
				yy=tree;//����
				
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
	
	//������������ɾ������
	/* 1 ���������
	 * 
	 * 1 ��ɾ������һ��Ҷ�ӽڵ� û������Ҳû���Һ���  ֱ��ɾ��
	 * 
	 * 2��һ�����ӽڵ��ɾ�� ֱ�ӽ�������Ϊ�丸�ڵ�ĺ��ӾͿ��ԡ�
	 * 
	 * 3ɾ���Ľڵ���������� Ҳ��������  �����ǽ�������������С���ó���
	 *  
	 * 
	 *  ��������ɾ������
	 * 
	 * */
	public BSNode<T> remove(BinarySearchTree tree,BSNode<T> node){
		
		BSNode<T> x=null;
		
		BSNode<T> y=null;
		
		if(node.left!=null||node.right!=null){//ֻ��һ���ڵ�
			y=node;
		}else{//���Ҷ���Ϊ��
			y=houJi(node);
		}
		
		if(y.left!=null){
			x=y.left;
		}else{
			x=y.right;
		}
		if(x!=null){
			x.parent=y.parent;//���ɾ�����Ǹ��ڵ�ֻ��һ�����ڵ� ֱ�Ӷ���ȥ
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
	
	
	
	//�����������ı�������
	
	/*
	 * ��ӡ"���������"
	 *
	 * key        -- �ڵ�ļ�ֵ 
	 * direction  --  0����ʾ�ýڵ��Ǹ��ڵ�;
	 *               -1����ʾ�ýڵ������ĸ���������;
	 *                1����ʾ�ýڵ������ĸ������Һ��ӡ�
	 */
	

	public void printTree(BSNode<T> tree ,T data,int decr){
		if(tree!=null){
			
			if(decr==0){
				System.out.println("���ڵ���:"+tree.data);
			}else{
				
				System.out.println(tree.data +"��"+data+" "+ (decr==1?"�Һ���":"����"));
				
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
		
		System.out.println("����ǰ�������������");
		tree.pre(tree.mRoot);
		System.out.println("�������������������");
		tree.zhong(tree.mRoot);
		System.out.println("���ĺ��������������");
		tree.hou(tree.mRoot);
		
		System.out.println("��� ��Сǰ����� �����������ʵ��");
		System.out.println("���:"+tree.getMax(tree.mRoot).data); 
		System.out.println("��С:"+tree.getMin(tree.mRoot).data); 
	
	
     System.out.println("ǰ��:"+tree.preQu(tree.search(tree.mRoot, 4)).data);
	 System.out.println("���:"+tree.houJi(tree.search(tree.mRoot, 3)).data); 
	 System.out.println("��������ѶȺܴ��ɾ��");
	
	 tree.remove(tree,tree.search(tree.mRoot, 5));
	   tree.printTree(tree.mRoot, tree.mRoot.data, 0);
	 
	 
	}

}
