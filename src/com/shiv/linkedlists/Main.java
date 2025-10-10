package com.shiv.linkedlists;


public class Main {

    public static void main(String[] arg){
        LL list = new LL();
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertLast(8);
        list.display();
        list.insertAtIndex(1,7);
        list.display();
        list.insertAtIndex(2,9);
        list.display();
        list.insertAtIndex(3,6);
        list.display();
        System.out.println(list.getValueAtIndex(3));
//        list.deleteLastNode();
//        list.display();
//        list.deleteAtIndex(2);
//        list.display();

        list.printReversedLinkedList();

//        DL dList = new DL();
//        dList.insertFirst(4);
//        dList.insertFirst(5);
//        dList.insertFirst(6);
//        dList.insertLast(7);
//        dList.displayDL();
//        dList.insertAtIndex(2,9);
//        dList.displayDL();
//
//        dList.deleteFirstNode();
//        dList.displayDL();
//        dList.deleteLastNode();
//        dList.displayDL();
//        dList.deleteAtIndex(1);
//        dList.displayDL();

//        CLL cList = new CLL();
//        cList.insert(3);
//        cList.insert(4);
//        cList.insert(5);
//        cList.display();
//        cList.delete(4);
//        cList.display();


    }


}
