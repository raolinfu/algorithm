package com.rao.tree;

import com.rao.bean.TreeNode;
import com.rao.link.Node;

import java.util.LinkedList;
import java.util.Queue;

/*
*  一、注意
*   Queue<String> t = new LinkedList<>();
        t.add(null);
        t.add(null);
        * t.size() = 2
*
* */

public class Tree {
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

    public static void main(String[] args) {
        Queue<String> t = new LinkedList<>();
        t.add(null);
        t.add(null);
        System.out.println(t.size());


        int[] arr = {1, 4, 5, 6, 7, 9};
        TreeNode head = makeTree(arr);
        printTree(head);
    }


}
