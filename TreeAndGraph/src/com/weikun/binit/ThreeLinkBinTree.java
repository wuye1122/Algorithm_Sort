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
	//��Ĭ�ϵĹ�����������������
	public ThreeLinkBinTree()
	{
		this.root = new TreeNode();
	}
	//��ָ����Ԫ��������������
	public ThreeLinkBinTree(E data)
	{
		this.root = new TreeNode(data);
	}
	/**
	 * Ϊָ���ڵ�����ӽڵ㡣
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
				"�ڵ�Ϊnull���޷�����ӽڵ�");
		}
		if (isLeft && parent.left != null)
		{
			throw new RuntimeException(parent +
				"�ڵ��������ӽڵ㣬�޷�������ӽڵ�");
		}
		if (!isLeft && parent.right != null)
		{
			throw new RuntimeException(parent +
				"�ڵ��������ӽڵ㣬�޷�������ӽڵ�");
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
		//���½ڵ��parent���õ�parent�ڵ�
		newNode.parent = parent;
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
		if (node == null)
		{
			throw new RuntimeException(node +
				"�ڵ�Ϊnull���޷������丸�ڵ�");
		}
		return (E)node.parent.data;
	}
	//����ָ���ڵ㣨��Ҷ�ӣ������ӽڵ㡣�����ӽڵ㲻����ʱ����null
	public E leftChild(TreeNode parent)
	{
		if (parent == null)
		{
			throw new RuntimeException(parent +
				"�ڵ�Ϊnull���޷�����ӽڵ�");
		}
		return parent.left == null ? null : (E)parent.left.data;
	}
	//����ָ���ڵ㣨��Ҷ�ӣ������ӽڵ㡣�����ӽڵ㲻����ʱ����null
	public E rightChild(TreeNode parent)
	{
		if (parent == null)
		{
			throw new RuntimeException(parent +
				"�ڵ�Ϊnull���޷�����ӽڵ�");
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
	//ʵ���������:�ȱ�������
	public List<TreeNode> preIterator()
	{
		return preIterator(root);
	}
	private List<TreeNode> preIterator(TreeNode node)
	{
		List<TreeNode> list = new ArrayList<TreeNode>();
		//������ڵ�
		list.add(node);
		//�ݹ鴦��������
		if (node.left != null)
		{
			list.addAll(preIterator(node.left));
		}
		//�ݹ鴦��������
		if (node.right != null)
		{
			list.addAll(preIterator(node.right));
		}
		return list;
	}
	//ʵ������������м䴦�����
	public List<TreeNode> inIterator()
	{
		return inIterator(root);
	}
	private List<TreeNode> inIterator(TreeNode node)
	{
		List<TreeNode> list = new ArrayList<TreeNode>();
		//�ݹ鴦��������
		if (node.left != null)//���Ǵ�2��ڵ㿪ʼ���ȱ��������е����ӽڵ㣬�������ӽڵ��ʱ��
		{
			
			list.addAll(inIterator(node.left));
		}
		//������ڵ�
		list.add(node);//���յ��˳��ݹ�ĳ���ʱ���ڵ������Ž��������ˣ����˳��������һ����ڵ㣬�����ڶ��˳����Ƕ����ڲ��ҽڵ㣬���������ң����ڵ㣬2�ң�����˳������
		//�ݹ鴦��������
		if (node.right != null)////���Ǵ�2��ڵ㿪ʼ���ȱ��������е����ӽڵ�
		{
			list.addAll(inIterator(node.right));
		}
		return list;
	}
	public List<TreeNode> postIterator()
	{
		return postIterator(root);
	}
	//ʵ�ֺ������������������ͬ���ĵ����������������ڵ㣬�����൱�ڱ������������ڵ�֮�󣬲Ž��뵽�б���
	private List<TreeNode> postIterator(TreeNode node)
	{
		List<TreeNode> list = new ArrayList<TreeNode>();
		//�ݹ鴦��������
		if (node.left != null)
		{
			list.addAll(postIterator(node.left));
		}
		//�ݹ鴦��������
		if (node.right != null)
		{
			list.addAll(postIterator(node.right));
		}
		//������ڵ�
		list.add(node);
		return list;
	}
	//������ȱ���
	public List<TreeNode> breadthFirst()
	{
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<TreeNode> list = new ArrayList<TreeNode>();
		if( root != null)
		{
			//����Ԫ�ؼ��롰���С�
			queue.offer(root);
			
			list.add(queue.peek());
			
		}
		/*
		 * offer��add����
һЩ�����д�С���ƣ�����������һ�����Ķ����м���һ������������ͻᱻ�ܾ���
��ʱ�µ� offer �����Ϳ����������ˡ������ǶԵ��� add() �����׳�һ�� unchecked �쳣����ֻ�ǵõ��� offer() ���ص� false�� 

poll��remove����
remove() �� poll() �������ǴӶ�����ɾ����һ��Ԫ�أ�head����remove() ����Ϊ�� Collection �ӿڵİ汾���ƣ�
�����µ� poll() �������ÿռ��ϵ���ʱ�����׳��쳣��ֻ�Ƿ��� null������µķ������ʺ����׳����쳣�����������

peek��element����
element() �� peek() �����ڶ��е�ͷ����ѯԪ�ء��� remove() �������ƣ��ڶ���Ϊ��ʱ�� element() �׳�һ���쳣���� peek() ���� null��

		 * 
		 * 
		 */
		while(!queue.isEmpty())
		{	
			TreeNode p = queue.poll();//�������Ƴ��˶��е�ͷ������˶���Ϊ�գ��򷵻� null�� ���ض��е�ͷ
			//������ӽڵ㲻Ϊnull���������롰���С�,��ڵ�
			if(p.left != null)
			{
				queue.offer(p.left);//��ָ����Ԫ�ز���˶��С�
			}
			//������ӽڵ㲻Ϊnull���������롰���С����ҽڵ�
			if(p.right != null)
			{
				queue.offer(p.right);
			}
			
			//���ö��еġ���β����Ԫ����ӵ�List��
			if(queue.peek()!=null){//��ֹ����null�ڵ�
				list.add(queue.peek());
			}
			
		}
		return list;
	}
}
