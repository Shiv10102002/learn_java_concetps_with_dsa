package com.shiv;

import java.util.Scanner;

public class Primitives {
    public  static void main(String[] arg){
        // primitive is basically any data type that you can not break in any further data types
        // String is not a Primitive data type bcoz you can break it into data type char
        // primitive datatypes are int,char,float,double,long,boolean
        /*
        int rollNo = 64;
        char letter = 'a';
        float marks = 98.5f;
        double largeDecimalNumbers = 4578969.4567;
        long largeInteger = 324267823423829L;
        boolean check = false;

         */

        Scanner input  = new Scanner(System.in);
        System.out.print("Please enter some input : ");
        int rollNumber = input.nextInt();
        System.out.println("Your roll number is "+rollNumber);


    }
}


/**
 * Primitive Data Types in Java
   has 8 primitive data types that store simple values directly. They are predefined by the language and cannot be broken down further into simpler data types.

  1. byte
  Size: 1 byte (8 bits)
  Range: -128 to 127

 * Usage: Saves memory in large arrays, replaces int where range fits
   Default: 0
  Example:
  byte b = 100;

 2. short
   Size: 2 bytes (16 bits)
   Range: -32,768 to 32,767
   Usage: Stores moderately small integers with less memory than int
   Default: 0
   Example:
    short s = 20000;
 3. int
   Size: 4 bytes (32 bits)
   Range: -2,147,483,648 to 2,147,483,647
   Usage: Default integer type for most calculations
   Default: 0
   Example:
   int i = 500000;

 4. long
   Size: 8 bytes (64 bits)
   Range: -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
   Usage: For large integer values beyond int range
   Default: 0L
   Syntax note: Suffix literal with L
   Example:
    long bigNum = 9223372036854775807L;


 5. float
   Size: 4 bytes (32 bits)
   Usage: Single-precision floating point to save memory on large arrays of decimals
   Precision: About 6-7 decimal digits
   Default: 0.0f
   Syntax note: Suffix literal with f
   Example:
     float pi = 3.14f;

 6. double
   Size: 8 bytes (64 bits)
   Usage: Double-precision floating point for most decimal calculations
   Precision: About 15-16 decimal digits
   Default: 0.0d
   Example:
     double precisePi = 3.14159265359;

 7. char
   Size: 2 bytes (16 bits)
   Usage: Stores a single Unicode character
   Default: '\u0000' (null character)
   Example:
     char letter = 'A';

 8. boolean
   Size: JVM dependent (commonly 1 byte)
   Usage: True or false logical values
   Default: false
   Example:
     boolean isJavaFun = true;

 Important Notes:
   ->Primitive types store values directly.
   ->They have fixed sizes and ranges.
   ->They cannot be assigned null (only objects can be null).
   ->String is not a primitive but an object that stores a sequence of characters.

 * */