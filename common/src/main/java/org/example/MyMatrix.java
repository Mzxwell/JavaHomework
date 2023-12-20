package org.example;

import java.util.Scanner;
public class MyMatrix {
    private int[][] data;
    public MyMatrix(int[][] a) {this.data = a;}

    public int[][] getData() {return data;}
    public MyMatrix plus(MyMatrix B) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                data[i][j] += B.data[i][j];
        return this;
    }
    public MyMatrix times(MyMatrix B) {
        int[][] a = new int[this.data.length][B.data[0].length];
        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < B.data[0].length; j++) {
                a[i][j] = 0;
                for (int k = 0; k < B.data.length; k++)
                    a[i][j] += data[i][k] * B.data[k][j];
            }
        data = a;
        return this;
    }
    public MyMatrix times(int b) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                data[i][j] *= b;
        return this;
    }
    public MyMatrix transpose() {
        int[][] a = new int[data[0].length][data.length];
        for (int i = 0; i < data[0].length; i++)
            for (int j = 0; j < data.length; j++)
                a[i][j] = data[j][i];
        data = a;
        return this;
    }
    public MyMatrix plusFromConsole() {return plus(read());}
    public MyMatrix timesFromConsole() {return times(read());}
    public void print() {
        System.out.printf("%n");
        for (int[] ints : data)
            for (int j = 0; j < data[0].length; j++) {
                System.out.print(ints[j]);
                if (j < data[0].length - 1) System.out.print(" ");
                else System.out.printf("%n");
            }
        System.out.printf("%n");
    }
    private MyMatrix read() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(), b = scanner.nextInt();
        int[][] A = new int[a][b];
        for (int i = 0; i < a; i++)
            for (int j = 0; j < b; j++)
                A[i][j] = scanner.nextInt();
        return new MyMatrix(A);
    }
}