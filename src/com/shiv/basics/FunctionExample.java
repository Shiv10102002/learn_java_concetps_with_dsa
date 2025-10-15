package com.shiv.basics;

import java.util.Scanner;

public class FunctionExample {
    public static void main(String[] args) {
        // Calling void method with no parameters
        sum();

        // Calling method with parameters and returning int
        System.out.println("Sum using return: " + sum(2, 4));

        // Calling method that returns String and no parameters
        System.out.println(greet());

        // Variables for swapping
        int a = 4;
        int b = 5;
        // Calling method that returns multiple values using array to swap numbers
        int[] swapValue = swap(a, b);
        a = swapValue[0];
        b = swapValue[1];
        System.out.println("After swapping, a = " + a + " and b = " + b);

        // Calling method with no return, but with parameters
        printMessage("Hello from a method with parameters!");

        // Calling method with return type double, with parameters
        double avg = average(4, 5, 6);
        System.out.println("Average is: " + avg);

        // Calling method with variable number of arguments (varargs)
        System.out.println("Sum with varargs: " + sumVarArgs(1, 2, 3, 4, 5));

        // Calling recursive function
        System.out.println("Factorial of 5 is: " + factorial(5));
    }

    // 1. Void method with no parameters (returns nothing)
    public static void sum() {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter first number: ");
        int num1 = in.nextInt();
        System.out.print("Please enter second number: ");
        int num2 = in.nextInt();
        int sum = num1 + num2;
        System.out.println("The sum is: " + sum);
    }

    // 2. Method with parameters and returns int (sum)
    public static int sum(int num1, int num2) {
        return num1 + num2;
    }

    // 3. Method with no parameters, returns String
    static String greet() {
        return "Good morning!";
    }

    // 4. Method that swaps two values and returns them as an array
    static int[] swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        return new int[]{a, b};
    }

    // 5. Void method with parameters, no return
    static void printMessage(String message) {
        System.out.println(message);
    }

    // 6. Method that returns a double value (average)
    static double average(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    // 7. Method with variable-length arguments (varargs)
    static int sumVarArgs(int... numbers) {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return sum;
    }

    // 8. Recursive method to calculate factorial
    static int factorial(int n) {
        if (n <= 1) {
            return 1;  // base case
        }
        return n * factorial(n - 1);  // recursive call
    }
}
