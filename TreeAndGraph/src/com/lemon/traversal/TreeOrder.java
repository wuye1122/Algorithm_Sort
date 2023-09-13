package com.lemon.traversal;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author： lemon
 * @date ： 2023/9/13 12:21 PM
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
    //递归是自己调用自己
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
        //左 中 右
        while (!stack.empty()|| root!=null){

            // 全部压入左节点
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                //等于null怎么办？
                TreeNode node = stack.pop();
                list.add(node.val);
                //root不等于null一直压入
                // root = null;  一直
                root = node.right;
            }
        }
        return list;

    }

    //o(1)
    public static List<Integer> inOrder(TreeNode root) {
        //硬遍历
        List<Integer> list = new ArrayList<>();

        TreeNode cur = root;
        //不断遍历
        while(cur!=null){

            /**
             * cur 走向 cur= cur.left 一直往左寻找
             * pre 一直找前驱
             * */
            //如果是左左边 直接输出
            if(cur.left == null){
                list.add(cur.val);
                //虚拟链表进行遍历
                cur = cur.right;
            }else{
                //把当前节点挂在前驱节点上面
                 TreeNode pre = cur.left;
                 //不断寻找最右边
                //我要为cur寻找一个pre 而且需要将pre.right = cur;
                 while (pre.right!=null && pre.right!=cur){
                     pre = pre.right;
                 }

                //如果pre不为null 直接输出就行
                if(pre.right != null){
                    pre.right = null;
                    list.add(cur.val);
                    cur = cur.right;
                }else{
                    //如果pre右侧为null
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
