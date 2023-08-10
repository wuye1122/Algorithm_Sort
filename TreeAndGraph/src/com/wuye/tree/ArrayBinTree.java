package com.wuye.tree;

public class ArrayBinTree<T> {

/*	顺序存储 比较耗费数组内存

    一个深度为i的二叉树 最多有2^i  -1各节点 因此定义一个【2^i-1】的数组


     A BC DEFG 二叉树的顺序存储

     (普通二叉树的而顺序存储很浪费空间)
     
     
     
     */
	private int size;//记录节点个数
	
	//用于存储二叉树的数组
	private Object nodes[];
	
	//二叉树的深度
	private int deep;
	
	//满二叉树的节点总数
	private int treesize;
	
	
	//通过深度  和 第一个数据将数建立起模子
	ArrayBinTree(int deep,T data){
		
		this.deep=deep;
		this.treesize=(int)Math.pow(2, deep)-1;
		
		nodes=new Object[treesize];
		
		nodes[0]=data;
		
		size++;
	} 
	
	
	
	//根据 父节点索引号  数据 和是否有做节点 将新的元素插入其中
	public void addNode(int index,T data,boolean left){
		
		//如果父节点的索引
		if(nodes[index]==null){
			throw new RuntimeException("不存在指定父节点");
		}
		if(index*2+1>=treesize){
			throw new RuntimeException("此树已经满了  不能添加");	
		}
		//为该父节点添加 子节点
		if(left){
			nodes[index*2+1]=data;
		}else{
			nodes[index*2+2]=data;
		}	
		size++;
	}
	
	 //返回根节点
	public T getRoot(){
		return (T)nodes[0];
		
	}
	
	//返回树的深度
	public int getDeep(){
		
		return this.deep;
		
	}
	
	//返回指定元素的位置
	public int getPos(T data){
		for(int i=0;i<treesize;i++){
			if(nodes[i]!=null&&nodes[i].equals(data)){
				return i;
			}
			
		}
		return -1;
		
	}
	
	//判断树是否为null
	public boolean empty(){
		return nodes[0]==null;
	}
	
	//返回指定索引的父节点
	public T parent(int index){
		if(index==0||index>=size){
			return (T)"索引异常";
		}
		return (T)nodes[(index-1)/2];
	}
	//返回指定索引的左节点
	public T getLeft(int index){
		if(index*2+1>=treesize){
			throw new RuntimeException("该索引无子节点");	
		}
		return  (T)nodes[index*2+1];
	}
	//返回指定索引的右节点
	public T getRight(int index){
		if(index*2+1>=treesize){
			throw new RuntimeException("该索引无子节点");	
		}
		return  (T)nodes[index*2+2];
	}

	
	public String toString(){
		
		return java.util.Arrays.toString(nodes);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayBinTree ab=new ArrayBinTree(3,"A");
		
		ab.addNode(0, "B", true);
		ab.addNode(0, "C", false);
		ab.addNode(1, "D", true);
		ab.addNode(1, "E", false);
		System.out.println("数组表示树如下:");
		for(int i=0;i<ab.treesize;i++){
			System.out.print(ab.nodes[i]);
		}
		System.out.println("");
		System.out.println("是否为null:"+ab.empty());	
		System.out.println("根节点:"+ab.getRoot());
		System.out.println("树的深度:"+ab.getDeep());
		System.out.println("");
		System.out.println("getPos():"+ab.getPos("A"));
		System.out.println("getPos():"+ab.getPos("B"));
		System.out.println("getPos():"+ab.getPos("C"));
		System.out.println("getPos():"+ab.getPos("D"));
		System.out.println("getPos():"+ab.getPos("E"));
		System.out.println("getPos():"+ab.getPos("null"));
		System.out.println("");
		
		System.out.println("指定节点的父节点:"+ab.parent(0));
		System.out.println("指定节点的父节点:"+ab.parent(1));
		System.out.println("指定节点的父节点:"+ab.parent(2));
		System.out.println("指定节点的父节点:"+ab.parent(3));
		System.out.println("指定节点的父节点:"+ab.parent(4));
		System.out.println("指定节点的父节点:"+ab.parent(5));
		System.out.println("指定节点的父节点:"+ab.parent(6));
		System.out.println("树的节点个数:"+ab.size);
		System.out.println("");
		System.out.println("指定节点的左子节点:"+ab.getLeft(0));
		System.out.println("指定节点的右子节点:"+ab.getRight(0));
		System.out.println("指定节点的左子节点:"+ab.getLeft(1));
		System.out.println("指定节点的右子节点:"+ab.getRight(1));
		System.out.println("指定节点的左子节点2:"+ab.getLeft(2));
		System.out.println("指定节点的右子节点2:"+ab.getRight(2));
		
		try {
			System.out.println("指定节点的左子节点3:"+ab.getLeft(3));
			System.out.println("指定节点的右子节点3:"+ab.getRight(3));
		} catch (Exception e) {
			// TODO: handle exception
		   System.out.println("节点三处出现异常");
		}
		
		
		
		
		
		
	}

}
