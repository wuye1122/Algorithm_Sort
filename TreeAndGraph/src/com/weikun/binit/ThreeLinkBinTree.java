package com.weikun.binit;
import java.util.*;

public class ThreeLinkBinTree<E>
{
	public static class TreeNode
	{
		Object data;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		public TreeNode()
		{
		}
		public TreeNode(Object data)
		{
			this.data = data;
		}
		public TreeNode(Object data , TreeNode left
			, TreeNode right , TreeNode parent)
		{
			this.data = data;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
		public String toString()
		{
			return data.toString();
		}
	}
	private TreeNode root;
	//以默认的构造器来创建二叉树
	public ThreeLinkBinTree()
	{
		this.root = new TreeNode();
	}
	//以指定根元素来创建二叉树
	public ThreeLinkBinTree(E data)
	{
		this.root = new TreeNode(data);
	}
	/**
	 * 为指定节点添加子节点。
	 * @param data 新子节点的数据
	 * @param isLeft 是否为左节点
	 * @return 新增的节点
	 */
	public TreeNode addNode(TreeNode parent , E data
		, boolean isLeft)
	{
		if (parent == null)
		{
			throw new RuntimeException(parent +
				"节点为null，无法添加子节点");
		}
		if (isLeft && parent.left != null)
		{
			throw new RuntimeException(parent +
				"节点已有左子节点，无法添加左子节点");
		}
		if (!isLeft && parent.right != null)
		{
			throw new RuntimeException(parent +
				"节点已有右子节点，无法添加右子节点");
		}
		TreeNode newNode = new TreeNode(data);
		if (isLeft)
		{
			//让父节点的left引用指向新节点
			parent.left = newNode;
		}
		else
		{
			//让父节点的left引用指向新节点
			parent.right = newNode;
		}
		//让新节点的parent引用到parent节点
		newNode.parent = parent;
		return newNode;
	}
	//判断二叉树是否为空。
	public boolean empty()
	{
		//根据根元素来判断二叉树是否为空
		return root.data == null;
	}
	//返回根节点。
	public TreeNode root()
	{
		if (empty())
		{
			throw new RuntimeException("树为空，无法访问根节点");
		}
		return root;
	}
	//返回指定节点（非根节点）的父节点。
	public E parent(TreeNode node)
	{
		if (node == null)
		{
			throw new RuntimeException(node +
				"节点为null，无法访问其父节点");
		}
		return (E)node.parent.data;
	}
	//返回指定节点（非叶子）的左子节点。当左子节点不存在时返回null
	public E leftChild(TreeNode parent)
	{
		if (parent == null)
		{
			throw new RuntimeException(parent +
				"节点为null，无法添加子节点");
		}
		return parent.left == null ? null : (E)parent.left.data;
	}
	//返回指定节点（非叶子）的右子节点。当右子节点不存在时返回null
	public E rightChild(TreeNode parent)
	{
		if (parent == null)
		{
			throw new RuntimeException(parent +
				"节点为null，无法添加子节点");
		}
		return parent.right == null ? null : (E)parent.right.data;
	}
	//返回该二叉树的深度。
	public int deep()
	{
		//获取该树的深度
		return deep(root); 
	}
	//这是一个递归方法：每棵子树的深度为其所有子树的最大深度 + 1
	private int deep(TreeNode node)
	{
		if (node == null)
		{
			return 0;
		}
		//没有子树
		if (node.left == null
			&& node.right == null)
		{
			return 1;
		}
		else
		{
			int leftDeep = deep(node.left);
			int rightDeep = deep(node.right);
			//记录其所有左、右子树中较大的深度
			int max = leftDeep > rightDeep ? 
				leftDeep : rightDeep;
			//返回其左右子树中较大的深度 + 1
			return max + 1;
		}
	}
	//实现先序遍历:先遍历根部
	public List<TreeNode> preIterator()
	{
		return preIterator(root);
	}
	private List<TreeNode> preIterator(TreeNode node)
	{
		List<TreeNode> list = new ArrayList<TreeNode>();
		//处理根节点
		list.add(node);
		//递归处理左子树
		if (node.left != null)
		{
			list.addAll(preIterator(node.left));
		}
		//递归处理右子树
		if (node.right != null)
		{
			list.addAll(preIterator(node.right));
		}
		return list;
	}
	//实现中序遍历：中间处理根部
	public List<TreeNode> inIterator()
	{
		return inIterator(root);
	}
	private List<TreeNode> inIterator(TreeNode node)
	{
		List<TreeNode> list = new ArrayList<TreeNode>();
		//递归处理左子树
		if (node.left != null)//都是从2左节点开始，先遍历其所有的左子节点，当有其子节点的时候
		{
			
			list.addAll(inIterator(node.left));
		}
		//处理根节点
		list.add(node);//最终当退出递归的程序时，节点是正着进，倒着退，先退出的是最后一个左节点，倒数第二退出的是二左，在查右节点，正好是三右，根节点，2右，所以顺序如结果
		//递归处理右子树
		if (node.right != null)////都是从2左节点开始，先遍历其所有的右子节点
		{
			list.addAll(inIterator(node.right));
		}
		return list;
	}
	public List<TreeNode> postIterator()
	{
		return postIterator(root);
	}
	//实现后序遍历：最后处理根部，同样的道理由于是最后处理根节点，所以相当于遍历左右两个节点之后，才进入到列表中
	private List<TreeNode> postIterator(TreeNode node)
	{
		List<TreeNode> list = new ArrayList<TreeNode>();
		//递归处理左子树
		if (node.left != null)
		{
			list.addAll(postIterator(node.left));
		}
		//递归处理右子树
		if (node.right != null)
		{
			list.addAll(postIterator(node.right));
		}
		//处理根节点
		list.add(node);
		return list;
	}
	//广度优先遍历
	public List<TreeNode> breadthFirst()
	{
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<TreeNode> list = new ArrayList<TreeNode>();
		if( root != null)
		{
			//将根元素加入“队列”
			queue.offer(root);
			
			list.add(queue.peek());
			
		}
		/*
		 * offer，add区别：
一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，多出的项就会被拒绝。
这时新的 offer 方法就可以起作用了。它不是对调用 add() 方法抛出一个 unchecked 异常，而只是得到由 offer() 返回的 false。 

poll，remove区别：
remove() 和 poll() 方法都是从队列中删除第一个元素（head）。remove() 的行为与 Collection 接口的版本相似，
但是新的 poll() 方法在用空集合调用时不是抛出异常，只是返回 null。因此新的方法更适合容易出现异常条件的情况。

peek，element区别：
element() 和 peek() 用于在队列的头部查询元素。与 remove() 方法类似，在队列为空时， element() 抛出一个异常，而 peek() 返回 null。

		 * 
		 * 
		 */
		while(!queue.isEmpty())
		{	
			TreeNode p = queue.poll();//检索并移除此队列的头，如果此队列为空，则返回 null。 返回队列的头
			//如果左子节点不为null，将它加入“队列”,左节点
			if(p.left != null)
			{
				queue.offer(p.left);//将指定的元素插入此队列。
			}
			//如果右子节点不为null，将它加入“队列”，右节点
			if(p.right != null)
			{
				queue.offer(p.right);
			}
			
			//将该队列的“队尾”的元素添加到List中
			if(queue.peek()!=null){//防止出现null节点
				list.add(queue.peek());
			}
			
		}
		return list;
	}
}
