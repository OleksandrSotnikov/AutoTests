package com.HomeWork;

import java.util.Scanner;

import static com.HomeWork.ReadInt.readInt;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the first digit (a) and press 'Enter':");
        int a = readInt(scanner);
        System.out.println("Input the second digit (b) and press 'Enter':");
        int b = readInt(scanner);
        System.out.println("Inputted digits are: a = " + a + ", b = " + b);
        int sum = a + b;
        System.out.println("a + b = " + sum);
        int sub = a - b;
        System.out.println("a - b = " + sub);
        int mult = a * b;
        System.out.println("a * b = " + mult);
        if (b != 0) {
            int div = a / b;
            System.out.println("a / b = " + div);
            int mod = a % b;
            System.out.println("a % b = " + mod);
        } else {
            System.out.println("b = 0, couldn't calculate / and %");
        }

    }
}
