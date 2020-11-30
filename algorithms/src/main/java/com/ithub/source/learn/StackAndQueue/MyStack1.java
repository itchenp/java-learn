package com.ithub.source.learn.StackAndQueue;

import java.util.Stack;

public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1(Stack<Integer> stackData, Stack<Integer> stackMin) {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newMin){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(newMin);
        }else if(newMin <= this.getMin()){
            this.stackMin.push(newMin);
        }
        this.stackMin.push(newMin);
    }

    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        int value = this.stackData.peek();
        if(value == this.getMin()){
            this.stackMin.pop();
        }
        return value;
    }

    private int getMin() {
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        return this.stackMin.peek();
    }
}
