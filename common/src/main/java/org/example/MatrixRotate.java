package org.example;

import java.util.Scanner;

public class MatrixRotate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = scanner.nextInt();
        int rotate = (scanner.nextInt() / 90)%4;
        if (rotate == 0) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
        } else if (rotate == 2) {
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--)
                    System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
        } else if (rotate == 1) {
            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--)
                    System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
        }else {
            for (int j = n - 1; j >= 0; j--) {
                for (int i = 0; i < m; i++)
                    System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
        }
    }
}