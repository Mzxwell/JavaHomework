import java.util.Scanner;

public class Literal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        if (input.hasNextInt()) System.out.println("integer");
        else if (input.hasNextDouble()) System.out.println("double");
        else if (input.hasNextBoolean()) System.out.println("boolean");
        else {
            String str = input.next();
            if (str.matches("\\d+\\.\\d+[Ff]")) System.out.println("float");
            else if (str.matches("\\d+[Ll]")) System.out.println("long");
            else System.out.println("char");
        }
    }
}