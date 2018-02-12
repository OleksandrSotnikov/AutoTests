package com.HomeWork;

import java.util.Scanner;

public class ReadInt {
    /*Зчитує число типу int до тих пір,
    * доки юзер не введе правильне число.
    */
    public static int readInt(Scanner scanner){
        while (true){
            if(scanner.hasNextInt()){
                return scanner.nextInt();
            } else {
                System.out.println("You input was not a digit. Please input a digit: ");
                scanner.next();
            }
        }
    }
}
