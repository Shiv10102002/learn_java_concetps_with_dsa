package com.shiv;

import java.util.Scanner;
import java.util.Arrays;

public class MultiDimensionalArray {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        // 1. Declaration of 2D arrays
        int[][] arr1 = new int[3][3]; // 3 rows and 3 columns, filled with default 0
        int[][] arr2 = {{1, 2}, {3, 4}, {5, 6}}; // initialized with values

        // 2. Jagged array (rows with variable columns)
        int[][] jagged = new int[3][];
        jagged[0] = new int[1];
        jagged[1] = new int[3];
        jagged[2] = new int[2];
        jagged[0][0] = 10;
        jagged[1][2] = 20;

        // 3. Taking input for 2D array from user
        System.out.print("Enter number of rows: ");
        int rows = inp.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = inp.nextInt();

        int[][] userArray = new int[rows][cols];
        System.out.println("Enter elements row-wise:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                userArray[i][j] = inp.nextInt();
            }
        }

        // 4. Printing the 2D array
        System.out.println("2D array elements:");
        for (int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(userArray[i]));
        }

        // 5. Common 2D array operations:

        // Sum of all elements
        int totalSum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                totalSum += userArray[i][j];
            }
        }
        System.out.println("Sum of all elements: " + totalSum);

        // Find max and min in 2D array
        int max = userArray[0][0];
        int min = userArray[0][0];
        for (int[] row : userArray) {
            for (int val : row) {
                if (val > max) max = val;
                if (val < min) min = val;
            }
        }
        System.out.println("Maximum element: " + max);
        System.out.println("Minimum element: " + min);

        // Transpose of a square matrix
        if (rows == cols) {
            int[][] transpose = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    transpose[j][i] = userArray[i][j];
                }
            }
            System.out.println("Transpose of the matrix:");
            for (int[] row : transpose) {
                System.out.println(Arrays.toString(row));
            }
        } else {
            System.out.println("Transpose is defined for square matrices only.");
        }

        // Check if matrix is symmetric (only for square matrix)
        if (rows == cols) {
            boolean symmetric = true;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (userArray[i][j] != userArray[j][i]) {
                        symmetric = false;
                        break;
                    }
                }
            }
            System.out.println("Matrix is symmetric? " + symmetric);
        }

        // Multiply two matrices (if dimensions are compatible)
        System.out.print("Enter rows for matrix B: ");
        int r2 = inp.nextInt();
        System.out.print("Enter cols for matrix B: ");
        int c2 = inp.nextInt();
        if (cols != r2) {
            System.out.println("Matrix multiplication not possible due to incompatible dimensions.");
        } else {
            int[][] matrixB = new int[r2][c2];
            System.out.println("Enter elements for matrix B:");
            for (int i = 0; i < r2; i++) {
                for (int j = 0; j < c2; j++) {
                    matrixB[i][j] = inp.nextInt();
                }
            }

            int[][] product = new int[rows][c2];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < c2; j++) {
                    for (int k = 0; k < cols; k++) {
                        product[i][j] += userArray[i][k] * matrixB[k][j];
                    }
                }
            }

            System.out.println("Product of matrices:");
            for (int[] row : product) {
                System.out.println(Arrays.toString(row));
            }
        }

        inp.close();
    }
}
