package com.shiv.collections;
import java.util.*;

public class TreeMaps {
    /**
     TreeMap is part of the java.util package and implements the NavigableMap interface (which extends SortedMap).
     It stores key-value pairs like a HashMap, but keeps keys in sorted order (natural order or by a custom comparator).

     ⚙️ Key Points:
             Stores data in sorted order of keys (ascending by default).
             No null keys allowed (throws NullPointerException).
             Multiple null values are allowed.
             Not synchronized (use Collections.synchronizedMap() if needed).
             Backed by a Red-Black Tree (self-balancing BST).
             Time complexity: O(log n) for insertion, deletion, and lookup.
     */
    public static void main(String[] args) {

        // 🌟 1. Create a TreeMap
        // Syntax: TreeMap<KeyType, ValueType> mapName = new TreeMap<>();
        TreeMap<Integer, String> map = new TreeMap<>();

        // 🌟 2. put(K key, V value)
        // Inserts key-value pair. Automatically sorted by key.
        map.put(3, "Mango");
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(5, "Orange");
        map.put(4, "Grapes");
        System.out.println("TreeMap (sorted by key): " + map);

        // 🌟 3. get(Object key)
        // Returns value for the specified key.
        System.out.println("Value of key 3 => " + map.get(3));

        // 🌟 4. remove(Object key)
        // Removes mapping for specified key.
        map.remove(5);
        System.out.println("After remove(5): " + map);

        // 🌟 5. containsKey(Object key)
        System.out.println("Contains key 2? " + map.containsKey(2));

        // 🌟 6. containsValue(Object value)
        System.out.println("Contains value 'Apple'? " + map.containsValue("Apple"));

        // 🌟 7. firstKey() & lastKey()
        System.out.println("First Key => " + map.firstKey());
        System.out.println("Last Key => " + map.lastKey());

        // 🌟 8. firstEntry() & lastEntry()
        System.out.println("First Entry => " + map.firstEntry());
        System.out.println("Last Entry => " + map.lastEntry());

        // 🌟 9. higherKey(K key) & lowerKey(K key)
        // Returns next higher or lower key.
        System.out.println("Key higher than 2 => " + map.higherKey(2));
        System.out.println("Key lower than 3 => " + map.lowerKey(3));

        // 🌟 10. ceilingKey(K key) & floorKey(K key)
        // Similar but includes equal keys.
        System.out.println("Ceiling key of 2 => " + map.ceilingKey(2));
        System.out.println("Floor key of 2 => " + map.floorKey(2));

        // 🌟 11. keySet() - returns all keys in sorted order
        System.out.println("All Keys => " + map.keySet());

        // 🌟 12. values() - returns all values
        System.out.println("All Values => " + map.values());

        // 🌟 13. entrySet() - returns all key-value pairs
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        // 🌟 14. replace(K key, V value)
        // Replaces value only if key exists.
        map.replace(2, "Banana", "Kiwi");
        System.out.println("After replace => " + map);

        // 🌟 15. putIfAbsent(K key, V value)
        map.putIfAbsent(5, "Pineapple");
        System.out.println("After putIfAbsent => " + map);

        // 🌟 16. subMap(fromKey, toKey)
        // Returns portion of map within key range (from inclusive, to exclusive)
        System.out.println("SubMap(2 to 5): " + map.subMap(2, 5));

        // 🌟 17. headMap(toKey)
        // Returns all keys less than given key.
        System.out.println("HeadMap(<3): " + map.headMap(3));

        // 🌟 18. tailMap(fromKey)
        // Returns all keys >= given key.
        System.out.println("TailMap(>=3): " + map.tailMap(3));

        // 🌟 19. descendingMap()
        // Returns reverse order map.
        System.out.println("Descending Map => " + map.descendingMap());

        // 🌟 20. clone()
        // Creates shallow copy of TreeMap.
        TreeMap<Integer, String> cloneMap = (TreeMap<Integer, String>) map.clone();
        System.out.println("Cloned Map => " + cloneMap);

        // 🌟 21. clear()
        // Removes all key-value pairs.
        cloneMap.clear();
        System.out.println("After clear() => " + cloneMap);

        // 🌟 22. comparator()
        // Returns comparator used for sorting (null means natural order)
        System.out.println("Comparator used => " + map.comparator());

        // 🌟 23. forEach(BiConsumer)
        // Iterates through all entries (Java 8+)
        System.out.println("Using forEach:");
        map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
    }

    /**
     Use a TreeMap when you:
         Need your keys sorted automatically (e.g., alphabetically or numerically).
         Want to perform range queries (like “all keys between 10 and 20”).
         Need to find next, previous, smallest, or largest key efficiently.
         Order matters more than raw speed (since TreeMap = O(log n) vs HashMap = O(1)).

        functions:
             put()	Insert key-value pair (sorted automatically)
             get()	Fetch value for given key
             remove()	Remove entry by key
             containsKey() / containsValue()	Check presence
             firstKey() / lastKey()	Get smallest/largest key
             higherKey() / lowerKey()	Get next or previous key
             subMap() / headMap() / tailMap()	Range views
             descendingMap()	Reverse order
             replace()	Replace existing key’s value
             putIfAbsent()	Add only if key not present
             clone()	Copy TreeMap
             clear()	Remove all entries
             comparator()	Get sorting comparator
             forEach()	Iterate over entries
     */
}

