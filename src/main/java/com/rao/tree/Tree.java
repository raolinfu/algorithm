package com.rao.tree;

import com.rao.bean.TreeNode;
import com.rao.link.Node;

import java.util.*;

/*
*  一、注意
*   Queue<String> t = new LinkedList<>();
        t.add(null);
        t.add(null);
        * t.size() = 2
*
* */

public class Tree {
    // 二叉树的反序列化 前序遍历
    static public TreeNode makeSeqTree(String str){
        if(str == null || str.length() == 0)
            return null;

        String[] list = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String ele: list){
            queue.offer(ele);
        }

        return seqTreePro(queue);
    }

    static public TreeNode seqTreePro(Queue<String> queue){
        String value = queue.poll();
        // 注意用equals方法
        if(value.equals("#"))
            return null;
        TreeNode cur = new TreeNode(Integer.valueOf(value));
        cur.left = seqTreePro(queue);
        cur.right=seqTreePro(queue);
        return cur;

    }

    // 二叉树的序列化 前序遍历
    static public String seqTree(TreeNode head){
        if (head == null)
            return "#!";
        String res = head.value + "!";
        res += seqTree(head.left);
        res += seqTree(head.right);

        return res;

    }

    static public TreeNode makeTree(int[] arr){
        if (arr == null || arr.length == 0)
            return null;
        int cur = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode head = new TreeNode(arr[cur++]);
        queue.add(head);
        while (!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            if(cur < arr.length){
                tmp.left = new TreeNode(arr[cur++]);
                queue.add(tmp.left);
            }
            else break;

            if (cur<arr.length){
                tmp.right = new TreeNode(arr[cur++]);
                queue.add(tmp.right);
            }

            else break;
        }
        return head;
    }

    static public void printTree(TreeNode head){
        if (head == null)
            System.out.println("Tree is null");

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            for (int i = queue.size(); i > 0; i--){
                TreeNode tmp = queue.poll();
                if (tmp.left != null)
                    queue.add(tmp.left);
                if(tmp.right != null)
                    queue.add(tmp.right);
                System.out.println(tmp.value);
            }
        }
    }

    // 获取数的左右边界
    static public void getBorder(TreeNode head,  TreeNode[][] border, int h){
        if (head == null)
            return;
        border[h][0] = border[h][0] == null? head: border[h][0];
        border[h][1] = head;
        getBorder(head.left, border, h + 1);
        getBorder(head.right, border, h+ 1);
    }

    // 获取树的高度
    static public int getHeight(TreeNode head){
        if (head == null)
            return 0;
        return Math.max(getHeight(head.left), getHeight(head.right)) + 1;
    }

    public static void main(String[] args) {
        Queue<String> t = new LinkedList<>();
        t.add(null);
        t.add(null);
        System.out.println(t.size());


        int[] arr = {1, 4, 5, 6, 7, 9};
        TreeNode head = makeTree(arr);
        printTree(head);

        // 反序列化测试
        String str = "1!4!6!#!#!#!5!12!#!#!3!#!#!";
        head = makeSeqTree(str);
        TreeNode r = head;
        System.out.println(head);
        Queue<String> queue = new LinkedList<>();

        // 序列化测试
        String seq = seqTree(head);
        System.out.println(str.equals(seq));

        //树的高度测试
        int height = getHeight(head);
        System.out.println(height);

        // 树的边界测试
        TreeNode[][] border = new TreeNode[height][2];
        getBorder(r,border, 0);
        // 打印左边界
        for (TreeNode[] l : border){
            System.out.print(l[0].value + "\t");
        }
        System.out.println();
        for (TreeNode[] l : border){
            System.out.print(l[1].value + "\t");
        }

        System.out.println(border);
    }


}
