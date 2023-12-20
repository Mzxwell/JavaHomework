package org.example;

import java.util.Scanner;

public class CompareNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number:");
        int num1 = scanner.nextInt();
        System.out.println("Enter the second number:");
        int num2 = scanner.nextInt();
        System.out.println("Enter the third number:");
        int num3 = scanner.nextInt();
        if (num1 == num2 || num1 == num3 || num2 == num3) {
            System.out.println("There are same numbers.");
        } else {
            int largest = Math.max(num1, Math.max(num2, num3));
            System.out.println("The largest number is " + largest + ".");
        }
    }
}