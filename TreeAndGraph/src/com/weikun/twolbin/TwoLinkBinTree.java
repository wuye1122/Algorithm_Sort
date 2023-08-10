/**
 * 
 */
package com.weikun.twolbin;

/**
 * @author weikun
 *
 */
public class TwoLinkBinTree<E> {
	public static class TreeNode
	{
		Object data;
		TreeNode left;
		TreeNode right;
		public TreeNode()
		{
		}
		public TreeNode(Object data)
		{
			this.data = data;
		}
		public TreeNode(Object data , TreeNode left
			, TreeNode right)
		{
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	private TreeNode root;
	//��Ĭ�ϵĹ�����������������
	public TwoLinkBinTree()
	{
		this.root = new TreeNode();
	}
	//��ָ����Ԫ��������������
	public TwoLinkBinTree(E data)
	{
		this.root = new TreeNode(data);
	}
	/**
	 * Ϊָ���ڵ������ӽڵ㡣
	 * @param data ���ӽڵ������
	 * @param isLeft �Ƿ�Ϊ��ڵ�
	 * @return �����Ľڵ�
	 */
	public TreeNode addNode(TreeNode parent , E data
		, boolean isLeft)
	{
		if (parent == null)
		{
			throw new RuntimeException(parent +
				"�ڵ�Ϊnull���޷������ӽڵ�");
		}
		if (isLeft && parent.left != null)
		{
			throw new RuntimeException(parent +
				"�ڵ��������ӽڵ㣬�޷��������ӽڵ�");
		}
		if (!isLeft && parent.right != null)
		{
			throw new RuntimeException(parent +
				"�ڵ��������ӽڵ㣬�޷��������ӽڵ�");
		}
		TreeNode newNode = new TreeNode(data);
		if (isLeft)
		{
			//�ø��ڵ��left����ָ���½ڵ�
			parent.left = newNode;
		}
		else
		{
			//�ø��ڵ��left����ָ���½ڵ�
			parent.right = newNode;
		}
		return newNode;
	}
	//�ж϶������Ƿ�Ϊ�ա�
	public boolean empty()
	{
		//���ݸ�Ԫ�����ж϶������Ƿ�Ϊ��
		return root.data == null;
	}
	//���ظ��ڵ㡣
	public TreeNode root()
	{
		if (empty())
		{
			throw new RuntimeException("��Ϊ�գ��޷����ʸ��ڵ�");
		}
		return root;
	}
	//����ָ���ڵ㣨�Ǹ��ڵ㣩�ĸ��ڵ㡣
	public E parent(TreeNode node)
	{
		//���ڶ��������洢�������Ҫ����ָ���ڵ�ĸ��ڵ�������������
		return null;
	}
	//����ָ���ڵ㣨��Ҷ�ӣ������ӽڵ㡣�����ӽڵ㲻����ʱ����null
	public E leftChild(TreeNode parent)
	{
		if (parent == null)
		{
			throw new RuntimeException(parent +
				"�ڵ�Ϊnull���޷������ӽڵ�");
		}
		return parent.left == null ? null : (E)parent.left.data;
	}
	//����ָ���ڵ㣨��Ҷ�ӣ������ӽڵ㡣�����ӽڵ㲻����ʱ����null
	public E rightChild(TreeNode parent)
	{
		if (parent == null)
		{
			throw new RuntimeException(parent +
				"�ڵ�Ϊnull���޷������ӽڵ�");
		}
		return parent.right == null ? null : (E)parent.right.data;
	}
	//���ظö���������ȡ�
	public int deep()
	{
		//��ȡ���������
		return deep(root); 
	}
	//����һ���ݹ鷽����ÿ�����������Ϊ������������������ + 1
	private int deep(TreeNode node)
	{
		if (node == null)
		{
			return 0;
		}
		//û������
		if (node.left == null
			&& node.right == null)
		{
			return 1;
		}
		else
		{
			int leftDeep = deep(node.left);
			int rightDeep = deep(node.right);
			//��¼���������������нϴ�����
			int max = leftDeep > rightDeep ? 
				leftDeep : rightDeep;
			//���������������нϴ����� + 1
			return max + 1;
		}
	}
}