import java.util.Scanner;
public class CurrencyCalculation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many euros are you exchanging?");
        float euros = input.nextFloat();
        System.out.println("What is the exchange rate?");
        float rate = input.nextFloat();
        float dollars = euros * rate /100;
        System.out.printf("%.2f euros at an exchange rate of %.2f is %.2f U.S. dollars.", euros, rate, dollars);
    }
}