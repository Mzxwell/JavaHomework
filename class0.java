public class class0 {
    static int a = 1;

    public class0() {
        System.out.println("构造");
    }
    public static int jie(int a){
        if (a==0)return 1;
        else return a*jie(a-1);
    }
}
