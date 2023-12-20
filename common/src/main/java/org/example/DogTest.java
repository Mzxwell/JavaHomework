package org.example;

import java.util.Arrays;

public class DogTest {
    public static void main(String[] args) {
        dog a = new dog();
        a.size = 12;
        dog b = new dog();
        b.size = 8;
        a.bark();
        b.bark();
        try {
            FileReader fileReader=new FileReader();
            System.out.println(fileReader.readFile("test1"));
        } catch (Exception e) {
            System.out.println("df5");
        }
        System.out.println(Stream.getNamesStringFunctionally(Arrays.asList("neal", "s", "stu", "j", "rich", "bob")));
        System.out.println(Stream.getNamesStringImperatively(Arrays.asList("stu", "s", "neal", "j", "rich", "bob")));
        int[][] A = {{1,2}, {1,2}};
        int[][] B = {{1,2}, {1,2}};
        MatrixCalculation matrixCalculation =new MatrixCalculation();
        matrixCalculation.print(MatrixCalculation.plus(A, B));
        matrixCalculation.print(matrixCalculation.times(A, B));
        matrixCalculation.print(matrixCalculation.plusFromConsole());
        matrixCalculation.print(matrixCalculation.timesFromConsole());
    }
}
