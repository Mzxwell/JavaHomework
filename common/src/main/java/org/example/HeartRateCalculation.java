package org.example;

import java.util.Scanner;

public class HeartRateCalculation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("RestingHR:");
		int restingHR = (int)Math.round(scanner.nextDouble());
		System.out.println("Age:");
		int age = (int)Math.round(scanner.nextDouble());
		System.out.println("Intensity|TargetHeartRate");
		System.out.println("--------|---------------");
		for (int intensity = 55; intensity <= 95; intensity += 5) {
			double targetHeartRate = Math.round((((220 - age) - restingHR) * intensity / 100.0) + restingHR);
			System.out.println(intensity + "%|" + (int) targetHeartRate + "bpm");
		}
	}
}
