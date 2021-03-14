package com.rao.stackAndQueue;

import java.util.Stack;

public class Stack2Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Stack2Queue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void add(Integer num) {
        stack1.push(num);
    }

    public Integer poll() {
        if (stack2.isEmpty() && stack1.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public Integer peek(){
        if(stack2.isEmpty() && stack1.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        else if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }


    public static void main(String[] args) {
        Stack2Queue stack2Queue = new Stack2Queue();
        stack2Queue.add(12);
        stack2Queue.add(11);
        System.out.println( stack2Queue.peek());
        System.out.println( stack2Queue.poll());
        System.out.println( stack2Queue.peek());



    }

}
