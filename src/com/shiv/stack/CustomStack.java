package com.shiv.stack;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;
    public CustomStack(){
        this(DEFAULT_SIZE);
    }

    public CustomStack(int arraySize){
        this.data = new int[arraySize];
    }

    public boolean isEmpty(){
        return ptr==-1;
    }
    public boolean isFull(){
        return ptr== data.length-1;
    }

    public boolean push(int val) throws StackException{
        if(isFull()){
            throw new StackException("Stack is full");
        }
        data[++ptr] = val;
        return true;
    }

    public int pop() throws StackException{
        if(isEmpty()){
            throw new StackException("Stack is Empty");
        }
        return data[ptr--];
    }

    public int peek() throws StackException{
        if(isEmpty()){
            throw new StackException("stack is empty");
        }
        return data[ptr];
    }

}
