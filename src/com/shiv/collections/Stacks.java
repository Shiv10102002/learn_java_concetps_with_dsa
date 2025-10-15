package com.shiv.collections;
import java.util.*;

public class Stacks {
    /**
     A Stack is a Last-In-First-Out (LIFO) data structure —
         meaning the last element added is the first one removed.
         In Java, Stack is a class inside the java.util package and extends Vector.
         It is synchronized (thread-safe), though most modern programs prefer Deque (like ArrayDeque) for better performance.

     ⚙️ Key Features
         Works on LIFO principle.
         Provides methods like push(), pop(), peek(), search(), empty().
         Can store duplicates and nulls.
         Can be used for problems like expression evaluation, parentheses balancing, DFS traversal, etc.
     */
    public static void main(String[] args) {

        // 🌟 1. Create a Stack
        // Syntax: Stack<Type> stackName = new Stack<>();
        Stack<String> stack = new Stack<>();

        // 🌟 2. push(E item)
        // Adds (pushes) an element to the top of the stack.
        stack.push("Apple");
        stack.push("Banana");
        stack.push("Cherry");
        stack.push("Mango");
        System.out.println("After push() => " + stack);

        // 🌟 3. pop()
        // Removes and returns the top element of the stack.
        String popped = stack.pop();
        System.out.println("After pop() => " + stack);
        System.out.println("Popped Element => " + popped);

        // 🌟 4. peek()
        // Returns top element without removing it.
        System.out.println("Top Element (peek) => " + stack.peek());

        // 🌟 5. search(Object o)
        // Returns 1-based position from top of stack. -1 if not found.
        System.out.println("Position of 'Banana' => " + stack.search("Banana"));
        System.out.println("Position of 'Mango' => " + stack.search("Mango"));

        // 🌟 6. empty()
        // Checks if stack is empty.
        System.out.println("Is stack empty? => " + stack.empty());

        // 🌟 7. size()
        // Returns the number of elements.
        System.out.println("Size => " + stack.size());

        // 🌟 8. iterator()
        // Iterate through stack elements (bottom to top)
        System.out.print("Iterating using iterator => ");
        Iterator<String> itr = stack.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();

        // 🌟 9. forEach(Consumer)
        // Modern iteration using lambda
        System.out.print("Using forEach => ");
        stack.forEach(item -> System.out.print(item + " "));
        System.out.println();

        // 🌟 10. clear()
        // Removes all elements.
        stack.clear();
        System.out.println("After clear() => " + stack);

        // 🌟 11. clone()
        // Returns shallow copy (from Vector)
        Stack<Integer> numStack = new Stack<>();
        numStack.push(10);
        numStack.push(20);
        numStack.push(30);
        Stack<Integer> cloned = (Stack<Integer>) numStack.clone();
        System.out.println("Cloned Stack => " + cloned);

        // 🌟 12. capacity()
        // Since Stack extends Vector, it has capacity management.
        System.out.println("Stack Capacity => " + numStack.capacity());

        // 🌟 13. get(int index)
        // Access element at specific index (0-based from bottom)
        System.out.println("Element at index 1 => " + numStack.get(1));

        // 🌟 14. firstElement() & lastElement()
        System.out.println("First Element => " + numStack.firstElement());
        System.out.println("Last Element => " + numStack.lastElement());

        // 🌟 15. elements()
        // Returns Enumeration for iterating (older style)
        System.out.print("Using Enumeration => ");
        Enumeration<Integer> e = numStack.elements();
        while (e.hasMoreElements()) {
            System.out.print(e.nextElement() + " ");
        }
        System.out.println();

        // 🌟 16. Stream (Java 8+)
        System.out.print("Using Stream => ");
        numStack.stream().forEach(System.out::print);
        System.out.println();

        // 🌟 17. removeElement(Object o)
        // Removes first occurrence of element.
        numStack.removeElement(20);
        System.out.println("After removeElement(20) => " + numStack);

        // 🌟 18. subList(fromIndex, toIndex)
        // Returns portion of stack.
        System.out.println("SubList(0, 1) => " + numStack.subList(0, 1));
    }

    /**
     💡 When to Use Stack
            Use a Stack when you need LIFO (Last-In-First-Out) behavior.

     Common Use Cases:
         Undo/Redo operations
         Backtracking (Maze, Sudoku)
         Expression evaluation (postfix/prefix)
         Parentheses balancing
         DFS (Depth First Search) traversal in graphs or trees

     Functioins:
         Method	Description
         push(E e)	Add element to top
         pop()	Remove top element
         peek()	View top element
         search(Object o)	Find position (1-based)
         empty()	Check if stack is empty
         clear()	Remove all elements
         clone()	Create shallow copy
         get(int index)	Get element by index
         firstElement() / lastElement()	Get first or last element
         removeElement()	Remove specific element
         subList()	Get portion of stack
         iterator() / Enumeration()	Traverse stack
         stream()	Use Java 8 stream API
     */
//    Problem: Check if parentheses are balanced
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

