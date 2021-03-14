package com.rao.stackAndQueue;

import java.util.Stack;

public class ReverseStackWithRecursion {
    static public Integer removeLastEle(Stack<Integer> stack){
        Integer result = stack.pop();
        if(stack.isEmpty())
            return result;
        else {
            Integer last = removeLastEle(stack);
            stack.push(result);
            return last;
        }
    }

    static public void reverse(Stack<Integer> stack){
        if(stack.isEmpty())
            return;

        Integer last = removeLastEle(stack);
        reverse(stack);
        stack.push(last);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(12);
        stack.push(45);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);


    }
}
