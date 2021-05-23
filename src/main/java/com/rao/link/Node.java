package com.rao.link;

public class Node {
    public int value;
    public Node next = null;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node(int value) {
        this.value = value;
    }
}
