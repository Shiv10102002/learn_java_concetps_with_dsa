package com.shiv.queue;

public class CustomQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int end = 0;
    public CustomQueue(){
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int arraySize){
        this.data = new int[arraySize];
    }

    public boolean isFull(){
        return end == data.length;
    }

    public boolean isEmpty(){
        return end ==0;
    }
    public void insert(int item) throws Exception{
        if(isFull()){
           throw new Exception("queue is full");
        }
        data[end++] = item;
    }

    public int front() throws Exception{
        if(isEmpty()){
            throw  new Exception("Stack is empty");
        }
        return data[0];
    }

    public int remove() throws  Exception{
        if(isEmpty()){
            throw  new Exception("Queue is Empty");
        }
        int removed = data[0];
        for(int i=1; i<end; i++){
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }

    public void display(){
        for(int i=0; i<end; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }


}
