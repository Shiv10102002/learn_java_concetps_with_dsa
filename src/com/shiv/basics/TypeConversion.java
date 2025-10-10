package com.shiv.basics;
public class TypeConversion {

    public static void main(String[] args) {
        System.out.println("===== TYPE CONVERSION IN JAVA =====\n");

        implicitConversion();
        explicitConversion();
        charToIntAndViceVersa();
        wrapperClassConversion();
        stringConversion();
    }

    // ✅ 1. Implicit Type Conversion (Widening Conversion)
    // Happens automatically when smaller data type is assigned to a larger one
    private static void implicitConversion() {
        System.out.println("1️⃣  IMPLICIT TYPE CONVERSION (Widening Conversion):");

        int numInt = 10;
        double numDouble = numInt;  // int → double automatically

        System.out.println("int value: " + numInt);
        System.out.println("double value after conversion: " + numDouble);
        System.out.println("Explanation: int (4 bytes) → double (8 bytes) is safe, so Java does it automatically.\n");
    }

    // ✅ 2. Explicit Type Conversion (Narrowing Conversion)
    // You must explicitly cast larger type to smaller type
    private static void explicitConversion() {
        System.out.println("2️⃣  EXPLICIT TYPE CONVERSION (Narrowing Conversion):");

        double numDouble = 9.78;
        int numInt = (int) numDouble;  // double → int (you must cast manually)

        System.out.println("double value: " + numDouble);
        System.out.println("int value after casting: " + numInt);
        System.out.println("Explanation: double (8 bytes) → int (4 bytes) may lose data, so Java requires explicit cast.\n");
    }

    // ✅ 3. char to int and int to char Conversion
    private static void charToIntAndViceVersa() {
        System.out.println("3️⃣  CHAR ↔ INT CONVERSION:");

        char letter = 'A';
        int ascii = letter;  // implicit conversion (char → int)
        char newLetter = (char) (ascii + 1);  // explicit conversion (int → char)

        System.out.println("Character: " + letter);
        System.out.println("ASCII value of 'A': " + ascii);
        System.out.println("Next character after 'A': " + newLetter);
        System.out.println("Explanation: 'A' = 65 in ASCII. Adding 1 gives 66, which is 'B'.\n");
    }

    // ✅ 4. Primitive to Wrapper and Wrapper to Primitive (Boxing & Unboxing)
    private static void wrapperClassConversion() {
        System.out.println("4️⃣  BOXING & UNBOXING:");

        int primitiveInt = 100;
        Integer boxedInt = primitiveInt; // Auto-boxing: primitive → Wrapper
        int unboxedInt = boxedInt;       // Auto-unboxing: Wrapper → primitive

        System.out.println("Primitive int: " + primitiveInt);
        System.out.println("Boxed Integer: " + boxedInt);
        System.out.println("Unboxed int: " + unboxedInt);
        System.out.println("Explanation: Java automatically converts between primitives and their wrapper classes.\n");
    }

    // ✅ 5. String Conversion Examples
    private static void stringConversion() {
        System.out.println("5️⃣  STRING CONVERSIONS:");

        // Primitive → String
        int num = 50;
        String str = String.valueOf(num); // or Integer.toString(num)
        System.out.println("int to String: " + str);

        // String → Primitive
        String strNum = "123";
        int convertedInt = Integer.parseInt(strNum); // or Double.parseDouble(strNum)
        System.out.println("String to int: " + convertedInt);

        // Double example
        String strDouble = "12.34";
        double convertedDouble = Double.parseDouble(strDouble);
        System.out.println("String to double: " + convertedDouble);

        System.out.println("Explanation: 'String.valueOf()' converts primitive to String, " +
                "and 'parseInt()', 'parseDouble()' convert String to number.\n");
    }
}

