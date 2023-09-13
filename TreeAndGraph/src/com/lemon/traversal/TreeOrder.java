package com.lemon.traversal;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author�� lemon
 * @date �� 2023/9/13 12:21 PM
 * @desc :  some desc
 */

public class TreeOrder {

    static TreeNode root;

    static {

        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root2 = new TreeNode(2,root4,root5);

        TreeNode root6 = new TreeNode(6);
        TreeNode root3 = new TreeNode(3,null,root6);
        root = new TreeNode(1,root2,root3);
    }

    public static List<Integer> inOrderRecursionUpdate(TreeNode root){
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        return list;
    }

    private static void inOrder(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
    //�ݹ����Լ������Լ�
    public static List<Integer> inOrderRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<Integer> leftList = inOrderRecursion(root.left);
        list.addAll(leftList);
        list.add(root.val);
        List<Integer> rightList = inOrderRecursion(root.right);
        list.addAll(rightList);
        return list;

    }

    public static List<Integer> inOrderUseStack(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //�� �� ��
        while (!stack.empty()|| root!=null){

            // ȫ��ѹ����ڵ�
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                //����null��ô�죿
                TreeNode node = stack.pop();
                list.add(node.val);
                //root������nullһֱѹ��
                // root = null;  һֱ
                root = node.right;
            }
        }
        return list;

    }

    //o(1)
    public static List<Integer> inOrder(TreeNode root) {
        //Ӳ����
        List<Integer> list = new ArrayList<>();

        TreeNode cur = root;
        //���ϱ���
        while(cur!=null){

            /**
             * cur ���� cur= cur.left һֱ����Ѱ��
             * pre һֱ��ǰ��
             * */
            //���������� ֱ�����
            if(cur.left == null){
                list.add(cur.val);
                //����������б���
                cur = cur.right;
            }else{
                //�ѵ�ǰ�ڵ����ǰ���ڵ�����
                 TreeNode pre = cur.left;
                 //����Ѱ�����ұ�
                //��ҪΪcurѰ��һ��pre ������Ҫ��pre.right = cur;
                 while (pre.right!=null && pre.right!=cur){
                     pre = pre.right;
                 }

                //���pre��Ϊnull ֱ���������
                if(pre.right != null){
                    pre.right = null;
                    list.add(cur.val);
                    cur = cur.right;
                }else{
                    //���pre�Ҳ�Ϊnull
                    pre.right = cur;
                    cur = cur.left;
                }
            }

        }
        return list;
    }



   @Test
    public void testRecursion(){
        System.out.println(inOrderRecursion(root));

    }
    @Test
    public void testRecursionUpdate(){
        System.out.println(inOrderRecursionUpdate(root));
    }


    @Test
    public void testUseStack(){
        System.out.println(inOrderUseStack(root));
    }

    @Test
    public void testInOrder(){
        List<Integer> result = inOrder(root);
        System.out.println(result);
        Assert.assertEquals(Arrays.asList(4, 2, 5, 1, 3, 6),result);
    }

}
