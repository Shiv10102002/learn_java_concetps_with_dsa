package com.shiv.linkedlists;

public class LL {
    
    
    private int size;
    private Node head;
    private Node tail;

    public LL(){
        this.size = 0;
    }
    private class Node{
       private int val ;
       private Node next;
        public Node(int val){
            this.val = val;
        }
        
        public Node(int val,Node nextNode){
            this.val = val;
            this.next = nextNode;
        }
    }

    void insertFirst(int val){
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        if(tail == null){
            tail = head;
        }
        size++;
    }

   public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node temp = new Node(val);
        tail.next  = temp;
        tail = temp;

        size++;

    }

    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public void insertAtIndex(int index,int val){
        if(index==0){
             insertFirst(val);
        }else if(index == size){
            insertLast(val);
        }else{
            Node temp = head;
            for(int i=0; i<index-1; i++){
                temp = temp.next;
            }
            Node newNode = new Node(val);
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }
    public void deleteFirstNode(){
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
    }

    private Node getNodeAtIndex(int ind){
        Node temp = head;
        for(int i=0; i<ind; i++){
            temp = temp.next;
        }
        return temp;
    }

    public void deleteLastNode(){
        if(size<=1){
            deleteFirstNode();
        }
        Node prevNodeFromLast = getNodeAtIndex(size-2);
        prevNodeFromLast.next = null;
        tail = prevNodeFromLast;
        size--;
    }

    public int deleteAtIndex(int ind){
        if(ind == 0){
            int val  = head.val;
            deleteFirstNode();
            return val;
        }else if(ind == size-1) {
            int val = tail.val;
            deleteLastNode();
            return val;
        }else{
            Node prevNode = getNodeAtIndex(ind-1);
            int val = prevNode.next.val;
            prevNode.next = prevNode.next.next;
            size--;
            return val;
        }
    }



    public int getValueAtIndex(int ind){
        Node nodeAtIndex = getNodeAtIndex(ind);
        return nodeAtIndex.val;
    }


    public void removeDuplicates(){
        Node node = head;
        while(node.next !=null){
            if(node.next != null && node.val == node.next.val){
                node.next = node.next.next;
                size--;
            }else{
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    public void printReversedLinkedList(){
        ReverseLinkedList(head);
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val + " -> ");
            temp= temp.next;
        }
        System.out.println("END");
    }


    public void ReverseLinkedList(Node node){
        if(node == tail){
            head = tail;
            return;
        }
        ReverseLinkedList(node.next);
        tail.next = node;
        tail = node;
        tail.next  = null;
    }







}
