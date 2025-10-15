package com.shiv.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListClass {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        System.out.print("Enter size of ArrayList: ");
        int n = in.nextInt();

        System.out.println("Enter the elements of the ArrayList:");
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }

        // Print elements using for loop
        System.out.println("ArrayList elements:");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // 1. Add element at a specific index
        list.add(1, 100);  // adds 100 at index 1
        System.out.println("After adding 100 at index 1: " + list);

        // 2. Remove element by index
        list.remove(2);  // removes element at index 2
        System.out.println("After removing element at index 2: " + list);

        // 3. Remove element by value (object)
        list.remove(Integer.valueOf(100)); // removes first occurrence of 100
        System.out.println("After removing element 100: " + list);

        // 4. Set (update) an element at index
        list.set(0, 50); // sets element at index 0 to 50
        System.out.println("After setting index 0 to 50: " + list);

        // 5. Check if list contains an element
        boolean contains50 = list.contains(50);
        System.out.println("List contains 50? " + contains50);

        // 6. Get size of the list
        int size = list.size();
        System.out.println("Size of the list: " + size);

        // 7. Clear the list
        //list.clear();
        //System.out.println("After clearing, list size: " + list.size());

        // 8. Check if list is empty
        boolean isEmpty = list.isEmpty();
        System.out.println("Is list empty? " + isEmpty);

        // 9. Find index of element (first and last)
        list.add(50);
        System.out.println("After adding 50 again: " + list);
        int firstIndex = list.indexOf(50);
        int lastIndex = list.lastIndexOf(50);
        System.out.println("First index of 50: " + firstIndex);
        System.out.println("Last index of 50: " + lastIndex);

        // 10. Iterate using enhanced for-loop
        System.out.print("Iterating with for-each loop: ");
        for (int val : list) {
            System.out.print(val + " ");
        }
        System.out.println();

        // 11. Sort the ArrayList
        Collections.sort(list);
        System.out.println("Sorted list: " + list);

        // 12. Reverse the ArrayList
        Collections.reverse(list);
        System.out.println("Reversed list: " + list);

        // 13. Convert ArrayList to Array
        Integer[] arr = list.toArray(new Integer[0]);
        System.out.println("Array from ArrayList: " + java.util.Arrays.toString(arr));

        // 14. Clone the ArrayList
        ArrayList<Integer> clonedList = (ArrayList<Integer>) list.clone();
        System.out.println("Cloned list: " + clonedList);

        // 15. Add all elements from one list to another
        ArrayList<Integer> extraList = new ArrayList<>();
        extraList.add(200);
        extraList.add(300);
        list.addAll(extraList);
        System.out.println("After adding all from extraList: " + list);

        // 16. Remove all elements present in another list
        list.removeAll(extraList);
        System.out.println("After removing all elements present in extraList: " + list);

        // 17. Retain only elements present in another list
        list.retainAll(extraList);
        System.out.println("After retaining only elements present in extraList: " + list);

        in.close();
    }
}
