package com.rao.link;

/*
* 与链表相关的算法
* */
public class LinkedNode {
    // 创建链表
    static public Node makeLink(int[] arr){
        Node head = null;
        Node cur = null;
        if(arr == null || arr.length == 0)
            return null;
        for (int i= 0; i < arr.length; i++){
            if (head == null)
            {
                head = new Node(arr[i]);
                cur = head;
            }else {
                Node tmp = cur;
                cur.next = new Node(arr[i]);
                cur = tmp.next;
            }
        }
        return head;
    }
    // 打印链表
    public static void printLink(Node head){
        if (head == null)
            System.out.println("link is null");
        while (head!=null){
            System.out.println(head.value);
            head = head.next;
        }
    }

    // 删除第k个节点
    static public Node removeK(Node head, int k){
        if (head == null)
            return head;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {12, 24, 32, 45, 1};
        Node head = makeLink(arr);
        printLink(head);
    }
}
