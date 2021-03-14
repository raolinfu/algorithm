package com.rao.stackAndQueue;

import java.util.Stack;

public class MinNumStack {
    private Stack<Integer> numStack;
    private Stack<Integer> minStack;

    public MinNumStack() {
        this.numStack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    public void push(Integer num){
        numStack.push(num);
        if(!minStack.isEmpty()){
            if(minStack.peek() < num){
                minStack.push(num);
            }
        }else {
            minStack.push(num);
        }
    }

    public Integer pop(){
        if (!numStack.isEmpty())
            return  (Integer) numStack.pop();
        throw new RuntimeException("stack is empty");
    }

    public Integer getMin(){
        if(!minStack.isEmpty())
            return (Integer) minStack.peek();
        throw new RuntimeException("stack is empty");
    }



}
