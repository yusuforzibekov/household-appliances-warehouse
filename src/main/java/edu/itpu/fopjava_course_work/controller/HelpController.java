package edu.itpu.fopjava_course_work.controller;

import java.util.Scanner;

import edu.itpu.fopjava_course_work.utils.Colors;

public class HelpController {
    public void handleHelp(Scanner scanner) {
        System.out.println("\n" + Colors.BOLD + Colors.CYAN + "=== HELP ===" + Colors.RESET);
        System.out.println("This program allows you to manage the inventory of laptops and ovens.");
        System.out.println("You can view, add, update, and delete laptops and ovens.");
        System.out.println("You can also provide feedback to the developers of this program.");
        System.out.println("To get started, select an option from the main menu.");
        System.out.println(Colors.BOLD + Colors.CYAN + "============" + Colors.RESET);
        System.out.print("Press Enter to return to the main menu...");
        scanner.nextLine();
        scanner.nextLine();
    }
}