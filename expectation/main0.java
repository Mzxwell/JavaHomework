package expectation;

import java.io.IOException;

public class main0 {
    static class jin {
        public static void aVoid() {
            System.out.println("fds");
        }

        public static void aVoid(int a) {
            System.out.println(a);
        }
    }

    public static int fib(int n) {
        int i, temp0 = 0, temp1, temp2;
        if (n <= 1) return n;
        temp1 = 0;
        temp2 = 1;
        for (i = 2; i <= n; i++) {
            temp0 = temp1 + temp2;
            temp1 = temp2;
            temp2 = temp0;
        }
        return temp0;
    }

    public static int fib0(int n) {
        if (n <= 1) return n;
        return fib0(n - 1) + fib0(n - 2);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        A a = new A();
        a.show();
        son son = new son();
        son.show();
        main0.jin.aVoid(0);
        System.out.println(String.valueOf(main0.fib0(10)) + ' ' + main0.fib(10));
    }
}
