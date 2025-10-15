package com.shiv.collections;
import java.util.*;

public class QueueExample {
    /**
     A Queue is a First-In-First-Out (FIFO) data structure —
     meaning the first element added is the first one removed.
     It’s part of the Java Collections Framework, and it’s an interface in java.util.
     The commonly used implementations are:
         LinkedList — general-purpose FIFO queue
         PriorityQueue — elements sorted by priority (natural/comparator order)
         ArrayDeque — efficient double-ended queue

     ⚙️ Key Points
         FIFO (First-In-First-Out) order.
         No direct indexing like lists.
         Useful for task scheduling, producer-consumer problems, BFS traversal, etc.
         Common methods: add(), offer(), poll(), remove(), peek(), element().
     */
    public static void main(String[] args) {

        System.out.println("=== Queue Using LinkedList (FIFO) ===");

        // 🌟 1. Create a Queue using LinkedList
        Queue<String> queue = new LinkedList<>();

        // 🌟 2. add(E e)
        // Adds an element at the end of the queue (throws exception if full)
        queue.add("Apple");
        queue.add("Banana");
        queue.add("Mango");
        queue.add("Cherry");
        System.out.println("After add() => " + queue);

        // 🌟 3. offer(E e)
        // Adds an element; returns false if full (better for bounded queues)
        queue.offer("Grapes");
        System.out.println("After offer() => " + queue);

        // 🌟 4. peek()
        // Returns head (front) element without removing; null if empty.
        System.out.println("Peek (front) => " + queue.peek());

        // 🌟 5. element()
        // Similar to peek(), but throws exception if queue is empty.
        System.out.println("Element (front) => " + queue.element());

        // 🌟 6. poll()
        // Removes and returns head; returns null if empty.
        System.out.println("Poll => " + queue.poll());
        System.out.println("After poll() => " + queue);

        // 🌟 7. remove()
        // Removes and returns head; throws exception if empty.
        System.out.println("Remove => " + queue.remove());
        System.out.println("After remove() => " + queue);

        // 🌟 8. size()
        // Returns number of elements in the queue.
        System.out.println("Size => " + queue.size());

        // 🌟 9. isEmpty()
        // Checks if queue is empty.
        System.out.println("Is queue empty? => " + queue.isEmpty());

        // 🌟 10. contains(Object o)
        // Checks if an element exists in the queue.
        System.out.println("Contains 'Mango'? => " + queue.contains("Mango"));

        // 🌟 11. iterator()
        // Traverse elements of the queue (front to back)
        System.out.print("Iterating => ");
        for (String item : queue) {
            System.out.print(item + " ");
        }
        System.out.println();

        // 🌟 12. clear()
        // Removes all elements from the queue.
        queue.clear();
        System.out.println("After clear() => " + queue);

        // 🌟 13. Example of using offer(), poll(), peek() safely
        queue.offer("Orange");
        queue.offer("Pineapple");
        System.out.println("Peek => " + queue.peek());
        System.out.println("Poll => " + queue.poll());
        System.out.println("After Poll => " + queue);

        // -------------------------------------------------------
        System.out.println("\n=== PriorityQueue (Min-Heap by Default) ===");

        // 🌟 14. Create a PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 🌟 15. offer(E e) / add(E e)
        pq.offer(40);
        pq.offer(10);
        pq.offer(30);
        pq.offer(20);
        System.out.println("PriorityQueue => " + pq); // Internal order may vary

        // 🌟 16. peek()
        // Returns smallest element (min-heap behavior)
        System.out.println("Peek (smallest) => " + pq.peek());

        // 🌟 17. poll()
        // Removes smallest element
        System.out.println("Poll (remove smallest) => " + pq.poll());
        System.out.println("After poll() => " + pq);

        // 🌟 18. remove(Object o)
        pq.remove(30);
        System.out.println("After remove(30) => " + pq);

        // 🌟 19. size() & contains()
        System.out.println("Size => " + pq.size());
        System.out.println("Contains 20? => " + pq.contains(20));

        // 🌟 20. clear()
        pq.clear();
        System.out.println("After clear() => " + pq);

        // -------------------------------------------------------
        System.out.println("\n=== PriorityQueue with Custom Comparator (Max-Heap) ===");

        // 🌟 21. Create a PriorityQueue with custom comparator (reverse order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        maxHeap.offer(5);
        maxHeap.offer(1);
        maxHeap.offer(9);
        maxHeap.offer(3);

        System.out.println("Max-Heap PriorityQueue => " + maxHeap);
        System.out.println("Poll (largest first) => " + maxHeap.poll());
        System.out.println("After poll() => " + maxHeap);
    }

    /**
     Use a Queue when:
       You need to process elements in the same order they were added (FIFO).

     You’re implementing:
         Task scheduling (e.g., printers, job queues)
         Level-order (BFS) traversal in trees or graphs
         Producer-Consumer problems
         Waiting lines or event handling systems

     Functions:
         add(e)	Insert element (throws exception if full)
         offer(e)	Insert element (returns false if full)
         peek()	View head element (null if empty)
         element()	View head element (throws exception if empty)
         poll()	Remove and return head (null if empty)
         remove()	Remove and return head (throws exception if empty)
         size()	Get number of elements
         isEmpty()	Check if queue is empty
         contains(e)	Check if element exists
         clear()	Remove all elements
     */
}

