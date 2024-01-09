public class dbl {
    public static void main(String[] args) {
        System.out.println(Math.pow(2, -149));
        for (int i = 0; i < 200; i++) System.out.println(Math.pow(2, -125 + i) - Math.pow(2, -149 + i) +" "+Math.pow(2, -149 + i));
    }
}
