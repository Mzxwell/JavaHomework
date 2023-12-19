import java.util.Arrays;

public class chars {
    public static void main(String[]args){
        char[][] a={{'0','0'}, {'1','1'}};
        char[]b=a[0];
        System.out.println(Arrays.toString(b));
        b[0]='1';
        System.out.println(Arrays.toString(a[0]));
    }
}
