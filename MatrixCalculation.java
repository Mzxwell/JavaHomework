import java.util.Scanner;
public class MatrixCalculation {
    public static int[][] plus(int[][] A, int[][] B) {
        int a = A.length, b = A[0].length;
        int[][] C = new int[a][b];
        for (int i = 0; i < a; i++)
            for (int j = 0; j < b; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }
    public int[][] times(int[][] A, int[][] B) {
        int a = A.length, b = A[0].length, c = B[0].length;
        int[][] C = new int[a][c];
        for (int i = 0; i < a; i++)
            for (int j = 0; j < c; j++) {
                C[i][j] = 0;
                for (int k = 0; k < b; k++)
                    C[i][j] += A[i][k] * B[k][j];
            }
        return C;
    }
    public int[][] plusFromConsole() {
        Scanner scanner = new Scanner(System.in);
        int[][] a = read(scanner), b = read(scanner);
        return a.length==0?new int[0][0]:plus(a, b);
    }
    public int[][] timesFromConsole() {
        Scanner scanner = new Scanner(System.in);
        int[][] A = read(scanner), B = read(scanner);
        return A.length != 0 ? times(A, B) : new int[0][0];
    }
    public void print(int[][] A) {
        System.out.printf("%n");
        for (int[] ints : A)
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(ints[j]);
                if ((j == A[0].length - 1)) System.out.printf("%n");
                else System.out.print(" ");
            }
    }
    public static int[][] read(Scanner scanner) {
        int a = scanner.nextInt(), b = scanner.nextInt();
        int[][] A = new int[a][b];
        for (int i = 0; i < a; i++)
            for (int j = 0; j < b; j++)
                A[i][j] = scanner.nextInt();
        return A;
    }
}