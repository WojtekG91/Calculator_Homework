package com.company;

import java.util.Scanner;

public class ScanData {
    public double[] enterValue() {
        System.out.print("Podaj ciąg znaków w formie: xx xx xx xx...: ");
        Scanner scanner = new Scanner(System.in);
        String variables = scanner.nextLine();
        String[] numbers = variables.split(" ");

        double[] enteredNumbers = new double[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            enteredNumbers[i] = Double.parseDouble(numbers[i]);
        }
        return enteredNumbers;

    }
}
