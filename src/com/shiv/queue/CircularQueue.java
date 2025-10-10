package com.shiv.queue;

public class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int front = 0;
    protected int end = 0;
    private int size = 0;
    public CircularQueue(){
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int arraySize){
        this.data = new int[arraySize];
    }

    public boolean isFull(){
        return size == data.length;
    }

    public boolean isEmpty(){
        return size ==0;
    }


    public void insert(int item) throws Exception{
        if(isFull()){
            throw  new Exception("Circular queue is full");
        }
        data[end++] = item;
        end = end%data.length;
        size++;
    }

    public int remove()throws Exception{
        if(isEmpty()){
            throw  new Exception("CircularQueue is Empty");
        }
        int removed  = data[front++];
        front = front%data.length;
        size--;
        return removed;
    }

    public int peek() throws Exception{
        if(isEmpty()){
            throw  new Exception("CircularQueue is Empty");
        }
        return data[front];
    }
    public void display(){
        int i = front;
        do{
            System.out.println(data[i++] + " ");
            i%= data.length;

        }while(i!=end);
        System.out.println("END");
    }
}
