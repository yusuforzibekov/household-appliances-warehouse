package edu.itpu.fopjava_course_work.controller;

import edu.itpu.fopjava_course_work.service.AdminService;
import edu.itpu.fopjava_course_work.entity.Laptop;

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
                    case 1:
                        addAppliance();
                        break;
                    case 2:
                        removeAppliance();
                        break;
                    case 3:
                        viewAppliances();
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
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
        System.out.println("1. Add Appliance");
        System.out.println("2. Remove Appliance");
        System.out.println("3. View Appliances");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addAppliance() {
        double batteryCapacity = getDoubleInput("Enter battery capacity (e.g., 1.5): ");
        String os = getStringInput("Enter OS (e.g., Windows): ");
        int memoryRom = getIntInput("Enter memory ROM (e.g., 8000): ");
        int systemMemory = getIntInput("Enter system memory (e.g., 1000): ");
        double cpu = getDoubleInput("Enter CPU (e.g., 2.2): ");
        int displayInches = getIntInput("Enter display inches (e.g., 19): ");
        int weight = getIntInput("Enter weight (e.g., 3): ");
        double width = getDoubleInput("Enter width (e.g., 15): ");
        double height = getDoubleInput("Enter height (e.g., 2): ");
        int depth = getIntInput("Enter depth (e.g., 12): ");
        int price = getIntInput("Enter price (e.g., 20000): ");

        try {
            Laptop laptop = new Laptop(null, batteryCapacity, os, memoryRom, systemMemory, cpu, displayInches, weight, width, height, depth, price);
            adminService.addAppliance(laptop);
            System.out.println("Appliance added successfully.");
        } catch (IOException e) {
            System.out.println("Error adding appliance: " + e.getMessage());
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

    private void removeAppliance() {
        try {
            System.out.print("Enter appliance ID to remove: ");
            int id = Integer.parseInt(scanner.nextLine());
            adminService.removeAppliance(id);
            System.out.println("Appliance removed successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid ID.");
        } catch (IOException e) {
            System.out.println("Error removing appliance: " + e.getMessage());
        }
    }

    private void viewAppliances() {
        try {
            List<Laptop> laptops = adminService.getAppliances();
            for (Laptop laptop : laptops) {
                System.out.println(laptop);
            }
        } catch (IOException e) {
            System.out.println("Error viewing appliances: " + e.getMessage());
        }
    }
}
