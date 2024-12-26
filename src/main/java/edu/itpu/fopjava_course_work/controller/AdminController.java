package edu.itpu.fopjava_course_work.controller;

import edu.itpu.fopjava_course_work.service.AdminService;
import edu.itpu.fopjava_course_work.entity.Laptop;
import edu.itpu.fopjava_course_work.entity.Refrigerator;
import edu.itpu.fopjava_course_work.entity.Oven;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AdminController {
    private AdminService adminService;
    private Scanner scanner;

    public AdminController() {
        adminService = new AdminService();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Admin Panel");
        if (authorizeAdmin()) {
            boolean exit = false;
            while (!exit) {
                showMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (choice) {
                    case 1 -> addAppliance("Laptop");
                    case 2 -> addAppliance("Refrigerator");
                    case 3 -> addAppliance("Oven");
                    case 4 -> removeAppliance("Laptop");
                    case 5 -> removeAppliance("Refrigerator");
                    case 6 -> removeAppliance("Oven");
                    case 7 -> viewAppliances("Laptop");
                    case 8 -> viewAppliances("Refrigerator");
                    case 9 -> viewAppliances("Oven");
                    case 10 -> exit = true;
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Authorization failed. Exiting...");
        }
    }

    private boolean authorizeAdmin() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        return adminService.authorize(username, password);
    }

    private void showMenu() {
        System.out.println("\nAdmin Menu:");
        System.out.println("1. Add Laptop");
        System.out.println("2. Add Refrigerator");
        System.out.println("3. Add Oven");
        System.out.println("4. Remove Laptop");
        System.out.println("5. Remove Refrigerator");
        System.out.println("6. Remove Oven");
        System.out.println("7. View Laptops");
        System.out.println("8. View Refrigerators");
        System.out.println("9. View Ovens");
        System.out.println("10. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addAppliance(String type) {
        try {
            if (type.equals("Laptop")) {
                Laptop laptop = new Laptop(
                    null,
                    getDoubleInput("Enter battery capacity (e.g., 1.5): "),
                    getStringInput("Enter OS (e.g., Windows): "),
                    getIntInput("Enter memory ROM (e.g., 8000): "),
                    getIntInput("Enter system memory (e.g., 1000): "),
                    getDoubleInput("Enter CPU (e.g., 2.2): "),
                    getIntInput("Enter display inches (e.g., 19): "),
                    getIntInput("Enter weight (e.g., 3): "),
                    getDoubleInput("Enter width (e.g., 15): "),
                    getDoubleInput("Enter height (e.g., 2): "),
                    getIntInput("Enter depth (e.g., 12): "),
                    getIntInput("Enter price (e.g., 20000): ")
                );
                adminService.addLaptop(laptop);
                System.out.println("Laptop added successfully.");
            } else if (type.equals("Refrigerator")) {
                Refrigerator refrigerator = new Refrigerator(
                    null,
                    getIntInput("Enter power consumption (e.g., 100): "),
                    getIntInput("Enter freezer capacity (e.g., 50): "),
                    getIntInput("Enter overall capacity (e.g., 300): "),
                    getIntInput("Enter weight (e.g., 85): "),
                    getDoubleInput("Enter width (e.g., 80): "),
                    getDoubleInput("Enter height (e.g., 180): "),
                    getIntInput("Enter depth (e.g., 80): "),
                    getIntInput("Enter price (e.g., 15000): ")
                );
                adminService.addRefrigerator(refrigerator);
                System.out.println("Refrigerator added successfully.");
            } else if (type.equals("Oven")) {
                Oven oven = new Oven(
                    null,
                    getIntInput("Enter power consumption (e.g., 1500): "),
                    getIntInput("Enter capacity (e.g., 32): "),
                    getIntInput("Enter weight (e.g., 10): "),
                    getDoubleInput("Enter width (e.g., 59.5): "),
                    getDoubleInput("Enter height (e.g., 45.5): "),
                    getIntInput("Enter depth (e.g., 60): "),
                    getIntInput("Enter price (e.g., 12000): ")
                );
                adminService.addOven(oven);
                System.out.println("Oven added successfully.");
            }
        } catch (IOException e) {
            System.out.println("Error adding " + type.toLowerCase() + ": " + e.getMessage());
        }
    }

    private void removeAppliance(String type) {
        try {
            System.out.print("Enter " + type.toLowerCase() + " ID to remove: ");
            int id = Integer.parseInt(scanner.nextLine());
            if (type.equals("Laptop")) {
                adminService.removeLaptop(id);
            } else if (type.equals("Refrigerator")) {
                adminService.removeRefrigerator(id);
            } else if (type.equals("Oven")) {
                adminService.removeOven(id);
            }
            System.out.println(type + " removed successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid ID.");
        } catch (IOException e) {
            System.out.println("Error removing " + type.toLowerCase() + ": " + e.getMessage());
        }
    }

    private void viewAppliances(String type) {
        try {
            if (type.equals("Laptop")) {
                List<Laptop> laptops = adminService.getLaptops();
                for (Laptop laptop : laptops) {
                    System.out.println(laptop);
                }
            } else if (type.equals("Refrigerator")) {
                List<Refrigerator> refrigerators = adminService.getRefrigerators();
                for (Refrigerator refrigerator : refrigerators) {
                    System.out.println(refrigerator);
                }
            } else if (type.equals("Oven")) {
                List<Oven> ovens = adminService.getOvens();
                for (Oven oven : ovens) {
                    System.out.println(oven);
                }
            }
        } catch (IOException e) {
            System.out.println("Error viewing " + type.toLowerCase() + "s: " + e.getMessage());
        }
    }

    private double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
