import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class write {
    public static void main(String[] args) {
        System.out.println(class0.a+String.valueOf(class0.jie(5)));
        try {
            BufferedReader in = new BufferedReader(new FileReader("test1"));
            int a = Integer.parseInt(in.readLine())+1;
            BufferedWriter out = new BufferedWriter(new FileWriter("test1"));
            out.write(String.valueOf(a));
            out.close();
        }catch (Exception e){
            System.out.println("dfd");
        }
    }
}