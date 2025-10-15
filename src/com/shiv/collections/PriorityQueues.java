package com.shiv.collections;
import java.util.*;

public class PriorityQueues {
    /**
     A PriorityQueue is a special type of Queue where elements are ordered based on priority, not insertion order.
     By default, it’s a min-heap (smallest element has highest priority).
     You can make it a max-heap using a custom comparator.
     It’s part of java.util.
     Implements the Queue interface.
     It does not allow null elements.
     Not thread-safe (use PriorityBlockingQueue for concurrency).
     */
    public static void main(String[] args) {

        // 🌟 1. Create a PriorityQueue (Min-Heap by default)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 🌟 2. add(E e) / offer(E e)
        // Adds elements to the queue (both work similarly)
        minHeap.add(30);
        minHeap.add(10);
        minHeap.add(50);
        minHeap.offer(20);
        minHeap.offer(40);

        System.out.println("Min-Heap (PriorityQueue): " + minHeap);

        // 🌟 3. peek()
        // Returns smallest element (head), does not remove it.
        System.out.println("Peek (smallest element): " + minHeap.peek());

        // 🌟 4. poll()
        // Removes and returns smallest element.
        System.out.println("Poll => " + minHeap.poll());
        System.out.println("After poll() => " + minHeap);

        // 🌟 5. remove(Object o)
        // Removes a specific element (if present).
        minHeap.remove(40);
        System.out.println("After remove(40) => " + minHeap);

        // 🌟 6. contains(Object o)
        System.out.println("Contains 50? => " + minHeap.contains(50));

        // 🌟 7. size() & isEmpty()
        System.out.println("Size => " + minHeap.size());
        System.out.println("Is Empty? => " + minHeap.isEmpty());

        // 🌟 8. iterator()
        // Iteration order is NOT guaranteed to be sorted!
        System.out.print("Iterating over elements => ");
        for (int num : minHeap) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 🌟 9. toArray()
        Object[] array = minHeap.toArray();
        System.out.println("Converted to Array => " + Arrays.toString(array));

        // 🌟 10. clear()
        minHeap.clear();
        System.out.println("After clear() => " + minHeap);

        // ======================================================
        System.out.println("\n=== PriorityQueue as Max-Heap ===");

        // 🌟 11. Create a Max-Heap using Comparator.reverseOrder()
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        maxHeap.add(10);
        maxHeap.add(30);
        maxHeap.add(20);
        maxHeap.add(50);
        maxHeap.add(40);

        System.out.println("Max-Heap PriorityQueue => " + maxHeap);
        System.out.println("Peek (largest element): " + maxHeap.peek());
        System.out.println("Poll => " + maxHeap.poll());
        System.out.println("After poll() => " + maxHeap);

        // ======================================================
        System.out.println("\n=== PriorityQueue with Custom Comparator ===");

        // 🌟 12. Create PQ with custom objects (e.g., Students sorted by marks)
        class Student {
            String name;
            int marks;
            Student(String name, int marks) {
                this.name = name;
                this.marks = marks;
            }
            @Override
            public String toString() {
                return name + " (" + marks + ")";
            }
        }

        PriorityQueue<Student> students = new PriorityQueue<>(
                (s1, s2) -> s2.marks - s1.marks // Sort by marks descending (max-heap)
        );

        students.offer(new Student("Ravi", 85));
        students.offer(new Student("Neha", 95));
        students.offer(new Student("Amit", 75));

        System.out.println("Students by highest marks => " + students);
        System.out.println("Top student => " + students.peek());
        System.out.println("After removing top => " + students.poll());
        System.out.println("Remaining students => " + students);

        // ======================================================
        System.out.println("\n=== Stream & forEach Example ===");

        maxHeap.forEach(System.out::println);

        // ======================================================
        System.out.println("\n=== Comparator Usage ===");
        System.out.println("Comparator used in MaxHeap => " + maxHeap.comparator());
        System.out.println("Comparator used in MinHeap => " + new PriorityQueue<Integer>().comparator());
    }
    /**
     💡 When to Use PriorityQueue
         Use a PriorityQueue when:
         You need elements processed in priority order, not FIFO.
         You need min-heap or max-heap behavior.

     You are solving problems like:
         Kth largest/smallest element
         Dijkstra’s shortest path
         Huffman coding
         Job scheduling
         Merging sorted lists

     Functions:
         add(e) / offer(e)	Add element to queue
         peek()	View head (highest priority)
         poll()	Remove and return head
         remove(e)	Remove specific element
         contains(e)	Check if element exists
         clear()	Remove all elements
         toArray()	Convert to array
         size() / isEmpty()	Size checks
         comparator()	Returns comparator (if used)
         forEach() / stream()	Iterate over elements
     */
//Problem: Find Kth Largest Element in an Array
    public static int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove smallest to keep only k largest
            }
        }
        return minHeap.peek(); // Kth largest element
    }
}

