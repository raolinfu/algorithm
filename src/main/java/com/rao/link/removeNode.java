package com.rao.link;
/*
* 删除节点
* */
public class removeNode {
    /*
    *   删除倒数第k个节点
    * */
    static public Node removeKth(Node head, int k){
        if(head == null)
            return null;
        Node cur = head;
        while (cur != null){
            k--;
            cur = cur.next;
        }

        if (k > 0)      // 说明链表长度比k小
            return head;
        if(k == 0)
            return head.next;

        cur = head;
        while (++k < 0){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;

    }

    public static void main(String[] args) {
        int[] list = {1, 3, 7, 9, 12};
        Node head = LinkedNode.makeLink(list);
        LinkedNode.printLink(head);
        Node r = removeKth(head, 1);
        LinkedNode.printLink(r);

    }

}
