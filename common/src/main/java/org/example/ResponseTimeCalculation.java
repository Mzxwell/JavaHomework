package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ResponseTimeCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = new ArrayList<>();
        System.out.println("Enter a Number:");
        while (scanner.hasNextInt()&&!scanner.hasNext("done")) {
            numbers.add(scanner.nextDouble());
            System.out.println("Enter a Number:");
        }
        double a = numbers.stream().reduce(0.0, Double::sum) /numbers.size();
        double b = Math.sqrt((numbers.stream().reduce(0.0, (c, d) -> c + (d - a) * (d - a))) /numbers.size());
        System.out.println("Numbers:"+ numbers.stream().map(d->String.format("%.0f",d)).collect(Collectors.joining(
                ","))+ String.format("%nThe average is %.2f.%nThe minimum is %.0f.%nThe maximum is %.0f.%n" +
                "The standard deviation is %.2f.", a, Collections.min(numbers),Collections.max(numbers),b));
    }
}