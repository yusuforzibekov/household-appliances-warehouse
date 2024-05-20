package edu.itpu.fopjava_course_work.utils;

import java.util.Scanner;

public class UserInputHandler {
    public static int readInteger(Scanner scanner) {
        try {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                scanner.next(); // Consume the invalid input
                return -1; // Indicate invalid input
            }
        } catch (Exception e) {
            scanner.next(); // Consume the invalid input
            return -1; // Indicate invalid input
        }
    }
}