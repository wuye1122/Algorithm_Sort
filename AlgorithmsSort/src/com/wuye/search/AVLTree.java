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
	
	  private Node<T> mroot;//���ڵ�
	  
	  AVLTree(){
		this.mroot=null;  
	  }
	
	  
	  //�������ĸ߶�
	  
	  public int getHeight(Node<T> tree){
		  
		  if(tree!=null){
			  return tree.heigth;
		  }
		  return 0;
	  }
	
	  
	  public int getHeight(){
		  return getHeight(mroot);
	  } 
	  
	  
	  //�Ƚϴ�С
	  
	  public int max(int a,int b){
		  return a>b?a:b;
	  }
	  
	  
	  //ǰ�����
	  
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
	  //������� 
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
	  
	  //�������
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
	  
	  
	  //�ҵ���С��
	  
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
	  
	  //�ҵ�����
	   
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
		 * LL�������Ӧ�����(����ת)��
		 *        2
		 *     A                     B     
		 *    /  1                 /   \
		 *   B   -->>LL--->>      X     A
		 *  /  0
		 * X
		 * ����ֵ����ת��ĸ��ڵ�
		 * (����Ľڵ�������������߽ڵ�)
		 */
	  
	     //������ת֮��ĸ��ڵ�
	     public Node<T> LL(Node<T> k1){//�����k1�൱�� ll�ĸ��ڵ�
	    	 Node<T> k;
	    	 
	    	 k=k1.left;
	    	 k1.left=k.right;
	    	 k.right=k1;
	    	 
	    	 k1.heigth=max(getHeight(k1.left),getHeight(k1.right))+1;
	    	 k.heigth=max(getHeight(k.left),k1.heigth)+1;
			
	    	 
	    	 return k;
	    	 
	     }
	  
	  
	  
		/*
		 * RR�����Ҷ�Ӧ�����(�ҵ���ת)��
		 *
		 *      -2                              0
		 *     A                               B     
		 *      \ -1                         /0  \0
		 *       B         -->>RR--->>      A     X
		 *        \ 0
		 *         X
		 *
		 *(����ڵ������������ұ߽ڵ�)
		 * ����ֵ����ת��ĸ��ڵ�
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
	  
	  
	     //������������������ҽڵ�
	     /*
	 	 * LR�����Ҷ�Ӧ�����(��˫��ת)��--��ӦRR-LL
	 	 *(����ڵ������������ұ߽ڵ�)
	 	 * ����ֵ����ת��ĸ��ڵ�
	 	 */
	     public Node<T> LR(Node<T> k){
	    	 
	    	 k.left=RR(k.left);
	    	 
	    	 return LL(k);
	     }
	     
	     //�������������������ڵ�
	     /*
	 	 * RL�������Ӧ�����(��˫��ת)����Ӧ LL-RR
	 	 *(����ڵ�������������߽ڵ�)
	 	 * ����ֵ����ת��ĸ��ڵ�
	 	 */
	     public Node<T> RL(Node<T> k){
	    	 
	    	 k.right=LL(k.right);
	    	 return RR(k);
	     }
	     
	     //�����Ĳ���
	     private Node<T> insert(Node<T>tree,T key){
	    	 if(tree==null){
	    		 //�½��ڵ�
	    		 tree=new Node<T>(key,null,null);
	    		 
	    	 }else{
	    		 
	    		 int cmp=key.compareTo(tree.key);//���Ƚ����������������
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
	    			 System.out.println("���ܲ�����ͬ�Ľڵ�");
	    			 
	    		     }
	    			 
	    	 }
	    	 tree.heigth=max(getHeight(tree.left),getHeight(tree.right))+1;
			return tree;
	 
	     }
	     
	     //����
	     
	     public void insert(T key){
	    	this.mroot=insert(this.mroot,key);
	     }
	     
	    
	     private static int arr[]= {3,2,1,4,5,6,7,10,9,8};
	     
	     //��ӡ
	     /*
	 	 * ��ӡ"���������"
	 	 *
	 	 * key        -- �ڵ�ļ�ֵ 
	 	 * direction  --  0����ʾ�ýڵ��Ǹ��ڵ�;
	 	 *               -1����ʾ�ýڵ������ĸ���������;
	 	 *                1����ʾ�ýڵ������ĸ������Һ��ӡ�
	 	 */
	 	private void print(Node<T> tree, T key, int direction) {
	 		if(tree != null) {
	 			if(direction==0)    // tree�Ǹ��ڵ�
	 				System.out.printf("%2d is root\n", tree.key, key);
	 			else                // tree�Ƿ�֧�ڵ�
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

		System.out.printf("== �������: ");
		for(i=0; i<arr.length; i++) {
			
			tree.insert(arr[i]);
			System.out.printf("%d ", arr[i]);
		}

		System.out.printf("\n== ǰ�����: ");
		tree.pre();

		System.out.printf("\n== �������: ");
		tree.inter();

		System.out.printf("\n== �������: ");
		tree.pos();
		System.out.printf("\n");

		System.out.printf("== �߶�: %d\n", tree.getHeight());
		System.out.printf("== ��Сֵ: %d\n", tree.getMin());
		System.out.printf("== ���ֵ: %d\n", tree.getMax());
		System.out.printf("== ������ϸ��Ϣ: \n");
		tree.print();
	}

}
