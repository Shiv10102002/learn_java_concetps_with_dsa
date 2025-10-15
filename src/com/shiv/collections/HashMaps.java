package com.shiv.collections;

import java.util.*;

public class HashMaps {

    /**
     A HashMap is part of the Java Collections Framework and is found in the java.util package.
     It stores data in key-value pairs — meaning each value is associated with a unique key.
     🔹 Keys must be unique.
     🔹 Values can be duplicate.
     🔹 It allows one null key and multiple null values.
     🔹 It is not synchronized (not thread-safe).
     🔹 It is faster than other maps like TreeMap or LinkedHashMap in most cases
     */

    public static void main(String[] args) {

        // 🌟 1. Create a HashMap
        // Syntax: HashMap<KeyType, ValueType> mapName = new HashMap<>();
        HashMap<Integer, String> map = new HashMap<>();

        // 🌟 2. put(K key, V value)
        // Adds key-value pair to map. If key exists, value is replaced.
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Mango");
        map.put(2, "Orange"); // Replaces "Banana" with "Orange"
        System.out.println("After put() => " + map);

        // 🌟 3. get(Object key)
        // Returns the value for the given key, or null if not found.
        System.out.println("Value of key 1 => " + map.get(1)); // Output: Apple

        // 🌟 4. remove(Object key)
        // Removes the mapping for the specified key.
        map.remove(3);
        System.out.println("After remove(3) => " + map);

        // 🌟 5. containsKey(Object key)
        // Returns true if the map contains the specified key.
        System.out.println("Contains key 2? " + map.containsKey(2)); // true

        // 🌟 6. containsValue(Object value)
        // Returns true if the map contains the specified value.
        System.out.println("Contains value 'Mango'? " + map.containsValue("Mango")); // false

        // 🌟 7. size()
        // Returns number of key-value pairs in the map.
        System.out.println("Size of map => " + map.size());

        // 🌟 8. isEmpty()
        // Returns true if map has no key-value pairs.
        System.out.println("Is map empty? " + map.isEmpty());

        // 🌟 9. keySet()
        // Returns a Set of all keys.
        Set<Integer> keys = map.keySet();
        System.out.println("All Keys => " + keys);

        // 🌟 10. values()
        // Returns a Collection of all values.
        Collection<String> values = map.values();
        System.out.println("All Values => " + values);

        // 🌟 11. entrySet()
        // Returns a Set of key-value pairs (Map.Entry objects)
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        // 🌟 12. putIfAbsent(K key, V value)
        // Adds key-value pair only if key does not exist.
        map.putIfAbsent(3, "Grapes");
        System.out.println("After putIfAbsent => " + map);

        // 🌟 13. replace(K key, V value)
        // Replaces value for a key only if it exists.
        map.replace(1, "Apple", "Cherry");
        System.out.println("After replace => " + map);

        // 🌟 14. clone()
        // Returns a shallow copy of the HashMap.
        HashMap<Integer, String> clonedMap = (HashMap<Integer, String>) map.clone();
        System.out.println("Cloned Map => " + clonedMap);

        // 🌟 15. clear()
        // Removes all key-value pairs.
        map.clear();
        System.out.println("After clear() => " + map);

        // 🌟 16. forEach(BiConsumer action)
        // Performs action for each entry in the map.
        clonedMap.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

        // 🌟 17. compute(K key, BiFunction remappingFunction)
        // Updates value using the provided function.
        clonedMap.compute(2, (key, val) -> val + " Juice");
        System.out.println("After compute => " + clonedMap);

        // 🌟 18. computeIfAbsent(K key, Function mappingFunction)
        // Adds new entry only if key is not already present.
        clonedMap.computeIfAbsent(4, key -> "Pineapple");
        System.out.println("After computeIfAbsent => " + clonedMap);

        // 🌟 19. computeIfPresent(K key, BiFunction remappingFunction)
        // Updates value only if key is already present.
        clonedMap.computeIfPresent(1, (key, val) -> val.toUpperCase());
        System.out.println("After computeIfPresent => " + clonedMap);

        // 🌟 20. getOrDefault(Object key, V defaultValue)
        // Returns value if key exists, else default value.
        System.out.println("Get key 5 => " + clonedMap.getOrDefault(5, "Not Found"));

        // 🌟 21. merge(K key, V value, BiFunction remappingFunction)
        // Merges given value with existing one using function.
        clonedMap.merge(1, " Fruit", (oldVal, newVal) -> oldVal + newVal);
        System.out.println("After merge => " + clonedMap);
    }
    /**
    💡 When to Use HashMap
            Use a HashMap when:
            You want fast lookups, insertions, and deletions (O(1) average time).
            You need to store unique keys with associated values.
            Order of elements doesn’t matter.

    Example problems:
            Counting frequency of elements
            Mapping IDs to names
            Storing configuration settings
            Implementing caches


         functions:
             Method	Description
             put()	Add or replace key-value pair
             get()	Get value for key
             remove()	Remove entry by key
             containsKey()	Check if key exists
             containsValue()	Check if value exists
             keySet()	Get all keys
             values()	Get all values
             entrySet()	Get all key-value pairs
             putIfAbsent()	Add entry if key doesn’t exist
             replace()	Replace value for existing key
             clear()	Remove all entries
             clone()	Copy of map
             compute(), computeIfAbsent(), computeIfPresent()	Modify values using functions
             getOrDefault()	Get value or return default
             merge()	Combine values for same key
             forEach()	Iterate over all entries
     */

    public static void wordFrequency(String st){
        String[] words = st.split(" ");
        HashMap<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        System.out.println("Word Frequency: " + frequency);
    }
}
