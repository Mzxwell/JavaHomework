import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static HashSet<String> option = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    static public node build(String s) {
        Stack<node> nodeStack = new Stack<>();
        for (String string : s.split(" "))
            nodeStack.push(option.contains(string) ? new node(string, nodeStack.pop(), nodeStack.pop()) : new node(string));
        return nodeStack.pop();
    }

    public static void main(String[] args) {
        System.out.println(build(new Scanner(System.in).nextLine()).tostring());
    }
}