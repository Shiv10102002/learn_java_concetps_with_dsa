package com.shiv.linkedlists;

public class DL {
    private int size;
    private Node head;
    DL(){
        size = 0;
    }

    private class Node{
        private int val;
        private Node prev;
        private Node next;
        Node(int val){
            this.val = val;
        }
    }

    public void insertFirst(int val){
        Node newNode = new Node(val);
        newNode.next = head;
        newNode.prev = null;
        if(head !=null){
            head.prev = newNode;
        }
        head = newNode;
        size++;
    }

    public void insertLast(int val){
       Node temp = head;
       if(temp == null){
           insertFirst(val);
       }else{
           while(temp.next != null){
               temp = temp.next;
           }
           Node newNode = new Node(val);
           temp.next = newNode;
           newNode.prev = temp;
           newNode.next = null;
           size++;
       }

    }
    public void displayDL(){
       Node node = head;
        Node last = null;
        System.out.println("current doubly linked list");
        while(node!=null){
            System.out.print(node.val + " -> ");
            last = node;
            node = node.next;
        }

        System.out.println("END");
        System.out.println("doubly lined list in reverse order ");


        while (last != null){
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START");

    }
    public void insertAtIndex(int ind,int val){
           if(ind == 0){
               insertFirst(val);
           }else if(ind == size){
               insertLast(val);
           }else{
               Node temp = head;
               for(int i=0; i<ind-1; i++){
                   temp = temp.next;
               }
               Node newNode = new Node(val);
               newNode.next  = temp.next;
               temp.next.prev = newNode;
               temp.next = newNode;
               newNode.prev = temp;
               size ++;
           }
    }
    public void deleteFirstNode(){
        if(head == null){
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    public void deleteLastNode(){
        if(head.next == null){
            deleteFirstNode();
        }
        Node temp = head;
        while (temp.next !=null){
            temp = temp.next;
        }
        temp = temp.prev;
        temp.next.prev = null;
        temp.next = null;
        size --;
    }

    public void deleteAtIndex(int ind){
        if(ind == 0){
            deleteFirstNode();
        }else if(ind  == size-1){
            deleteLastNode();
        }else{
            Node temp = head;
            for(int i=0; i<ind; i++){
                temp  = temp.next;
            }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            temp.prev = null;
            temp.next = null;
            size--;

        }
    }

}
