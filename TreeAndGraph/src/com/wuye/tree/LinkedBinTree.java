package com.wuye.tree;

public class LinkedBinTree {

/* -��ʽ�洢  û������ �����˷ѿռ� 

     ��������ʽ�洢����˼������ÿ���ڵ��ס�������������ӽڵ�

     ȱ���� �����ڵ�ʱЧ�ʲ��� ָ���ڵ�����丸�ڵ�Ҳ�Ƚ�����                             
    
    �÷���������ӽڵ�û�����ƣ�����Ҳ�����˷Ѵ����Ŀռ䣬
  
   ȱ���Ǳ������ڵ�ʱЧ�ʲ��ߣ�ָ���ڵ�����丸�ڵ�ʱҲ�Ƚ����ѡ�
     *
     *
     */
	
	//���ȶ������ڵ�	
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
	
	
	//�˴�����һ�����������ʾ�Ķ�����  ��������һ������
	/*public  String toString(){
		
		if(empty()){
			return "�����ǿյ�";
		}
		
		while(this.root!=null){
			System.out.println("�ýڵ�����"+this.root.data);
			TreeNode lef=this.root.leftNode;
			
			boolean flag=true;
             while(lef.leftNode!=null){
            	 System.out.println("�ýڵ���ڵ���"+lef.data);
                lef=lef.leftNode;
                
             }
             
			
			TreeNode right=this.root.rightNode;
			  while(right.rightNode!=null){
	            	 System.out.println("�ýڵ��ҽڵ���"+right.data);
	                right=right.rightNode;
	             }
			this.root=this.root.leftNode;
		}
		return null;
		
	}*/
	private TreeNode root;
	
	//�����ڵ㶨��
	LinkedBinTree(Object data){
		this.root=new TreeNode(data);
	}
	
	//��ӽڵ�
	                                              //���ӵ��Ƿ�����ڵ�
	public TreeNode addNode(TreeNode parent,Object data,boolean isleft){
		
		if(parent==null){
			throw new RuntimeException(parent +
					"�ڵ�Ϊnull���޷�����ӽڵ�");
		}
		
		if(isleft&&parent.leftNode!=null){
			throw new RuntimeException(parent +
					"�Ѿ�����ڵ���");
		}
		if(!isleft&&parent.rightNode!=null){
			throw new RuntimeException(parent +
					"�Ѿ����ҽڵ���");
		}
		TreeNode newNode=new TreeNode(data);
		if(isleft){
			parent.leftNode=newNode;
		}else{
			parent.rightNode=newNode;
		}
		return newNode;
		
	}
	
	//���ظ��ڵ�
	public TreeNode getRoot(){
		if(empty()){
			throw new RuntimeException("��Ϊ�� ���ִ���");
		}
		return this.root;
	}
	
	//�ж��Ƿ�Ϊnull
	
	public boolean empty(){
		
		return this.root.data==null;
	}
	
	//����ָ���ڵ����ڵ�����ҽڵ�
	public TreeNode getLeft(TreeNode parent){
		return parent.leftNode!=null?parent.leftNode:null;
	}
	
	public TreeNode getRight(TreeNode parent){
		return parent.rightNode!=null?parent.rightNode:null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBinTree lb=new LinkedBinTree("A");
		
		System.out.println("��ȡ���ڵ�"+lb.getRoot().data);
		
		 TreeNode al=lb.addNode(lb.getRoot(), "B", true);
		 TreeNode ar=lb.addNode(lb.getRoot(), "C", false);
		 
		 TreeNode bl=lb.addNode(al, "D", true);
		 TreeNode br=lb.addNode(ar, "E", false);
		 
		 System.out.println("�Ƿ�Ϊ��"+lb.empty());
		 
		 
		 System.out.println("A��ڵ�"+lb.getLeft(lb.getRoot()).data);
		 System.out.println("A�ҽڵ�"+lb.getRight(lb.getRoot()).data);
		 
		 
		 
		 //��ӵ�ʱ��  A  BC
		 //         D   E   --->   Ҳ����D��ӳ�B����ڵ�E��ӳ�C���ҽڵ�
		 System.out.println("B��ڵ�"+lb.getLeft(al).data);
		 System.out.println("C�ҽڵ�"+lb.getRight(ar).data);
		 
		 System.out.println(lb.toString());
		 
	}

}
