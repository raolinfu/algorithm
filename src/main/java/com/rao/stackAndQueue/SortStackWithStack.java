package com.rao.stackAndQueue;

import java.util.Stack;

public class SortStackWithStack {
    static public void sort(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        Stack<Integer> stack1 = new Stack<>();

        while (!stack.isEmpty()) {
            Integer num = stack.pop();

            while (!stack1.isEmpty() && stack1.peek() < num) {
              stack.push(stack1.pop());
            }

            stack1.push(num);
        }

        while (!stack1.isEmpty()){
            stack.push(stack1.pop());
        }

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(4);
        stack.push(1);
        stack.push(65);
        stack.push(0);
        System.out.println(stack);

        sort(stack);

        System.out.println(stack);
    }
}
