package edu.itpu.fopjava_course_work.utils;

public class ErrorHandler {
    public static void handleInputError(String message) {
        System.out.println(Colors.RED + "Input Error: " + message + Colors.RESET);
    }

    public static void handleIOException(String message) {
        System.out.println(Colors.RED + "IO Error: " + message + Colors.RESET);
    }

    public static void handleGeneralError(String message) {
        System.out.println(Colors.RED + "Error: " + message + Colors.RESET);
    }
}
