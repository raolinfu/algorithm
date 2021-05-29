package com.rao.bean;

import java.util.*;

public class TreeNode {
    public int value;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int data) {
        this.value = data;
    }

    static public TreeNode createTree(List<Integer> list) throws Exception {
        TreeNode root = null;
        if (list == null || list.isEmpty()) {
            throw new Exception("list is null");
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Integer idx = 0;
        root = new TreeNode(list.get(idx++));
        queue.add(root);

        while (true) {
            TreeNode node = queue.poll();
            if (idx < list.size()) {
                TreeNode left = new TreeNode(list.get(idx++));
                node.left = left;
                queue.add(left);
            } else {
                return root;
            }

            if (idx < list.size()) {
                TreeNode right = new TreeNode(list.get(idx++));
                node.right = right;
                queue.add(right);
            } else {
                return root;
            }
        }

    }

    // 前序遍历
    static public void preOrderRecur(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.value);
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    // 递归中序遍历
    static public void inOrderRecur(TreeNode root) {
        if (root == null)
            return;
        inOrderRecur(root.left);
        System.out.println(root.value);
        inOrderRecur(root.right);
    }

    // 递归后序遍历
    static public void postOrderRecur(TreeNode root) {
        if (root == null)
            return;
        inOrderRecur(root.left);
        inOrderRecur(root.right);
        System.out.println(root.value);
    }

    // 循环前序遍历
    static public void preOrder(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        stack.push(root);
        System.out.println(root.value);
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek.left != null && peek.left != pre) {
                stack.push(peek.left);
                System.out.println(peek.left.value);
                continue;
            } else {
                pre = peek;
                stack.pop();
                if (peek.right != null) {
                    stack.push(peek.right);
                    System.out.println(peek.right.value);
                }
            }

        }
    }

    // 循环中序遍历
    static public void inOrder(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek.left != null && peek.left != pre) {
                stack.push(peek.left);
                continue;
            } else {
                pre = peek;
                stack.pop();
                System.out.println(peek.value);
                if (peek.right != null) {
                    stack.push(peek.right);
                }
            }

        }
    }

    // 循环后序遍历
    static public void postOrder(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;

        while (!stack.isEmpty()) {
            TreeNode p = stack.peek();
            if (p.left == null && p.right == null) {
                pre = p;
                System.out.println(pre.value);
                stack.pop();
                continue;
            }

            if (p.left != null) {
                if (pre == null) {
                    stack.push(p.left);
                    continue;
                } else if (p.left != pre && p.right != pre) {
                    stack.push(p.left);
                    continue;
                } else if (p.right == null) {
                    pre = p;
                    System.out.println(pre.value);
                    stack.pop();
                    continue;
                }

            }
            if (p.right != null) {
                if (pre != p.right)
                    stack.push(p.right);
                else {
                    pre = p;
                    System.out.println(pre.value);
                    stack.pop();
                    continue;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        TreeNode root = createTree(list);

        //前序遍历
        System.out.println("前序遍历");
        preOrderRecur(root);

        // 中序遍历
        System.out.println("中序遍历");
        inOrderRecur(root);

        // 后序遍历
        System.out.println("后序遍历");
        postOrder(root);

    }
}
