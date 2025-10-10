package com.shiv.collections;
import java.util.ArrayDeque;
import java.util.Deque;

public class DequeClass {

    public static void main(String[] args) {

        System.out.println("===== DEQUE (Double Ended Queue) IN JAVA =====\n");

        // Create a Deque using ArrayDeque (most common implementation)
        Deque<String> deque = new ArrayDeque<>();

        // -------------------------------------------------------------
        // 1️⃣ Adding elements
        // -------------------------------------------------------------
        System.out.println("1️⃣ ADDING ELEMENTS:");

        deque.add("A");              // Adds element at tail (end)
        deque.addFirst("B");         // Adds element at head (front)
        deque.addLast("C");          // Adds element at tail (end)
        deque.offer("D");            // Similar to add(), adds at tail
        deque.offerFirst("E");       // Adds at head (returns false if full)
        deque.offerLast("F");        // Adds at tail

        System.out.println("Deque after additions: " + deque);
        System.out.println("Explanation: addFirst() & offerFirst() insert at front, addLast() & offerLast() at end.\n");

        // -------------------------------------------------------------
        // 2️⃣ Accessing elements (without removing)
        // -------------------------------------------------------------
        System.out.println("2️⃣ ACCESSING ELEMENTS:");

        System.out.println("getFirst(): " + deque.getFirst());     // First element (throws exception if empty)
        System.out.println("getLast(): " + deque.getLast());       // Last element (throws exception if empty)
        System.out.println("peek(): " + deque.peek());             // Head element (returns null if empty)
        System.out.println("peekFirst(): " + deque.peekFirst());   // First element (returns null if empty)
        System.out.println("peekLast(): " + deque.peekLast());     // Last element (returns null if empty)

        System.out.println("Current Deque: " + deque + "\n");

        // -------------------------------------------------------------
        // 3️⃣ Removing elements
        // -------------------------------------------------------------
        System.out.println("3️⃣ REMOVING ELEMENTS:");

        System.out.println("remove(): " + deque.remove());             // Removes head (throws exception if empty)
        System.out.println("removeFirst(): " + deque.removeFirst());   // Removes first element
        System.out.println("removeLast(): " + deque.removeLast());     // Removes last element

        System.out.println("poll(): " + deque.poll());                 // Removes head (returns null if empty)
        System.out.println("pollFirst(): " + deque.pollFirst());       // Removes first element
        System.out.println("pollLast(): " + deque.pollLast());         // Removes last element

        System.out.println("Deque after removals: " + deque + "\n");

        // -------------------------------------------------------------
        // 4️⃣ Using Deque as Stack (LIFO)
        // -------------------------------------------------------------
        System.out.println("4️⃣ USING DEQUE AS STACK:");

        deque.push("Java");     // Adds at front (like stack push)
        deque.push("Python");
        deque.push("C++");

        System.out.println("Deque as Stack: " + deque);

        System.out.println("pop(): " + deque.pop());   // Removes element from front (like stack pop)
        System.out.println("After pop: " + deque + "\n");

        // -------------------------------------------------------------
        // 5️⃣ Checking elements and properties
        // -------------------------------------------------------------
        System.out.println("5️⃣ CHECKING ELEMENTS:");

        deque.clear();
        deque.add("A");
        deque.add("B");
        deque.add("C");

        System.out.println("Deque: " + deque);
        System.out.println("Contains 'B'? " + deque.contains("B"));
        System.out.println("Size of deque: " + deque.size());
        System.out.println("Is deque empty? " + deque.isEmpty());
        System.out.println("Explanation: contains(), size(), and isEmpty() are used for checking.\n");

        // -------------------------------------------------------------
        // 6️⃣ Iteration through Deque
        // -------------------------------------------------------------
        System.out.println("6️⃣ ITERATING THROUGH DEQUE:");

        System.out.println("Forward direction:");
        for (String element : deque) {
            System.out.println(element);
        }

        System.out.println("\nReverse direction:");
        for (var itr = deque.descendingIterator(); itr.hasNext(); ) {
            System.out.println(itr.next());
        }

        System.out.println("\n===== END OF DEMO =====");
    }
}

