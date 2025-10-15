package com.shiv.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Spliterator;

public class HashSets {
    /**
     A HashSet is a collection that stores unique elements only.
     It’s implemented using a HashMap internally, meaning:
     It does not maintain order (unordered collection).
     It doesn’t allow duplicates.
     It allows one null element.
     It offers O(1) average time for add, remove, and contains operations.
     */
    public static void main(String[] args) {

        // 🌟 1. Create a HashSet
        // Syntax: HashSet<Type> setName = new HashSet<>();
        HashSet<String> fruits = new HashSet<>();

        // 🌟 2. add(E e)
        // Adds an element to the set. Duplicates are ignored.
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Apple"); // duplicate ignored
        fruits.add(null); // one null allowed
        System.out.println("After add() => " + fruits);

        // 🌟 3. size()
        // Returns number of unique elements in the set.
        System.out.println("Size => " + fruits.size());

        // 🌟 4. contains(Object o)
        // Returns true if element is present.
        System.out.println("Contains 'Mango'? " + fruits.contains("Mango"));
        System.out.println("Contains 'Grapes'? " + fruits.contains("Grapes"));

        // 🌟 5. remove(Object o)
        // Removes an element if present.
        fruits.remove("Banana");
        System.out.println("After remove('Banana') => " + fruits);

        // 🌟 6. isEmpty()
        // Checks if set is empty.
        System.out.println("Is set empty? " + fruits.isEmpty());

        // 🌟 7. iterator()
        // Returns an iterator to traverse the set.
        System.out.print("Iterating using Iterator => ");
        Iterator<String> itr = fruits.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();

        // 🌟 8. forEach(Consumer action)
        // Iterates through each element (Java 8+)
        System.out.print("Using forEach => ");
        fruits.forEach(f -> System.out.print(f + " "));
        System.out.println();

        // 🌟 9. clear()
        // Removes all elements from the set.
        fruits.clear();
        System.out.println("After clear() => " + fruits);

        // 🌟 10. clone()
        // Returns a shallow copy of the set.
        HashSet<Integer> numbers = new HashSet<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        HashSet<Integer> clonedSet = (HashSet<Integer>) numbers.clone();
        System.out.println("Cloned Set => " + clonedSet);

        // 🌟 11. addAll(Collection c)
        // Adds all elements from another collection.
        HashSet<Integer> extra = new HashSet<>(Arrays.asList(40, 50, 60));
        numbers.addAll(extra);
        System.out.println("After addAll() => " + numbers);

        // 🌟 12. removeAll(Collection c)
        // Removes all elements that exist in the given collection.
        numbers.removeAll(Arrays.asList(40, 50));
        System.out.println("After removeAll() => " + numbers);

        // 🌟 13. retainAll(Collection c)
        // Keeps only elements that are also in the given collection.
        numbers.retainAll(Arrays.asList(20, 30));
        System.out.println("After retainAll() => " + numbers);

        // 🌟 14. toArray()
        // Converts set to array.
        Object[] arr = numbers.toArray();
        System.out.println("Converted to array: " + Arrays.toString(arr));

        // 🌟 15. stream()
        // Returns a Stream for performing operations (Java 8+)
        System.out.print("Using stream to print: ");
        clonedSet.stream().forEach(System.out::print);
        System.out.println();

        // 🌟 16. Spliterator
        // Used for parallel iteration
        System.out.print("Using Spliterator => ");
        Spliterator<Integer> spliterator = clonedSet.spliterator();
        spliterator.forEachRemaining(System.out::print);
        System.out.println();

        // 🌟 17. equals(Object o)
        // Compares two sets for equality (same elements, order doesn’t matter)
        System.out.println("Are numbers and clonedSet equal? " + numbers.equals(clonedSet));

        // 🌟 18. hashCode()
        // Returns hash code of the set (based on contents)
        System.out.println("HashCode => " + numbers.hashCode());
    }

    /**
     Use a HashSet when:
         You need to store unique items only (no duplicates).
         You want fast insertion, search, and deletion (O(1) average).
         Order doesn’t matter.
         You need set operations (union, intersection, difference).

     functions:-
     add()	Adds element (if not already present)
     size()	Returns number of elements
     contains()	Checks if element exists
     remove()	Removes an element
     isEmpty()	Checks if set is empty
     iterator()	Returns iterator to traverse set
     forEach()	Performs action for each element
     clear()	Removes all elements
     clone()	Creates shallow copy
     addAll()	Adds all elements from another collection
     removeAll()	Removes all elements from given collection
     retainAll()	Keeps only common elements
     toArray()	Converts set to array
     stream()	Returns stream for functional ops
     equals()	Compares contents of two sets
     hashCode()	Returns hash based on elements
     */

//    Problem: Remove duplicates from an array
    public int[] removeDuplicates(int[] arr){
        HashSet<Integer> unique = new HashSet<>();
        for (int num : arr) {
            unique.add(num);
        }
        System.out.println("Array after removing duplicates => " + unique);
        // Convert HashSet<Integer> to int[]
        int[] result = new int[unique.size()];
        int index = 0;
        for (int num : unique) {
            result[index++] = num;
        }
        return result;
    }
}


