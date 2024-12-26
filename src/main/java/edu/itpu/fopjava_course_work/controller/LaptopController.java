package edu.itpu.fopjava_course_work.controller;

import edu.itpu.fopjava_course_work.entity.Laptop;
import edu.itpu.fopjava_course_work.service.LaptopService;
import edu.itpu.fopjava_course_work.utils.Colors;
import edu.itpu.fopjava_course_work.utils.UserInputHandler;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LaptopController {
    private final LaptopService laptopService;

    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    public void handleLaptops(Scanner scanner) throws IOException {
        while (true) {
            System.out.println("\n" + Colors.BLUE + Colors.BOLD + "=== LAPTOP OPERATIONS ===" + Colors.RESET);
            System.out.println("1. Search Laptop by Keyword");
            System.out.println("2. Search Laptop by OS");
            System.out.println("3. Search Laptop by CPU");
            System.out.println("4. Show All Laptops");
            System.out.println("5. Back to Main Menu");
            System.out.println(Colors.BOLD + Colors.BLUE + "=========================" + Colors.RESET);

            try {
                System.out.print("Please enter your choice: ");
                int laptopChoice = UserInputHandler.readInteger(scanner);

                switch (laptopChoice) {
                    case 1 -> {
                        System.out.print("Enter the keyword for the laptop: ");
                        String searchLaptop = scanner.next();
                        List<Laptop> laptopList = laptopService.getLaptopBySearch(searchLaptop);
                        if (laptopList.isEmpty()) {
                            System.out.println(Colors.RED + "No results found for '" + searchLaptop + "'." + Colors.RESET);
                        } else {
                            System.out.println(Colors.GREEN + "Search results:" + Colors.RESET);
                            laptopList.forEach(laptop -> System.out.println(Colors.CYAN + laptop + Colors.RESET));
                        }
                    }
                    case 2 -> {
                        System.out.print("Enter the OS of the laptop: ");
                        String searchLaptopByOS = scanner.next();
                        List<Laptop> laptopList = laptopService.getLaptopsByOS(searchLaptopByOS);
                        if (laptopList.isEmpty()) {
                            System.out.println(
                                    Colors.RED + "No results found for OS '" + searchLaptopByOS + "'." + Colors.RESET);
                            System.out.println("Try searching with the terms such as 'Windows' or 'Linux'.");
                        } else {
                            System.out.println(Colors.GREEN + "Search results:" + Colors.RESET);
                            laptopList.forEach(laptop -> System.out.println(Colors.CYAN + laptop + Colors.RESET));
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter the CPU of the laptop: ");
                        String searchLaptopByCPU = scanner.next();
                        List<Laptop> laptopList = laptopService.getLaptopsByCPU(searchLaptopByCPU);
                        if (laptopList.isEmpty()) {
                            System.out.println(
                                    Colors.RED + "No results found for CPU '" + searchLaptopByCPU + "'." + Colors.RESET);
                            System.out.println("Try searching with different CPUs like 1.2, 2.2, or 3.2.");
                        } else {
                            System.out.println(Colors.GREEN + "Search results:" + Colors.RESET);
                            laptopList.forEach(laptop -> System.out.println(Colors.CYAN + laptop + Colors.RESET));
                        }
                    }
                    case 4 -> {
                        System.out.println(Colors.GREEN + "List of all laptops:" + Colors.RESET);
                        List<Laptop> laptopList = laptopService.getAll();
                        laptopList.forEach(laptop -> System.out.println(Colors.CYAN + laptop + Colors.RESET));
                    }
                    case 5 -> {
                        // Go back to the main menu
                        return;
                    }
                    default -> System.out.println(Colors.RED + "Invalid input. Please try again." + Colors.RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(Colors.RED + "Invalid input. Please enter a number." + Colors.RESET);
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    public void handleAdminOperations(Scanner scanner) throws IOException {
        while (true) {
            System.out.println("\n" + Colors.BOLD + Colors.BLUE + "=== LAPTOP ADMIN OPERATIONS ===" + Colors.RESET);
            System.out.println("1. Add Laptop");
            System.out.println("2. Remove Laptop");
            System.out.println("3. View Laptops");
            System.out.println("4. Back to Admin Menu");
            System.out.println(Colors.BOLD + Colors.BLUE + "===============================" + Colors.RESET);

            try {
                System.out.print("Please enter your choice: ");
                int choice = UserInputHandler.readInteger(scanner);

                switch (choice) {
                    case 1 -> addLaptop(scanner);
                    case 2 -> removeLaptop(scanner);
                    case 3 -> viewLaptops();
                    case 4 -> {
                        return;
                    }
                    default -> System.out.println(Colors.RED + "Invalid choice. Please try again." + Colors.RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(Colors.RED + "Invalid input. Please enter a number." + Colors.RESET);
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    private void addLaptop(Scanner scanner) {
        System.out.print("Enter the battery capacity of the laptop: ");
        String batteryCapacity = scanner.next();
        System.out.print("Enter the OS of the laptop: ");
        String os = scanner.next();
        System.out.print("Enter the memory ROM of the laptop: ");
        String memoryRom = scanner.next();
        System.out.print("Enter the system memory of the laptop: ");
        String systemMemory = scanner.next();
        System.out.print("Enter the CPU of the laptop: ");
        String cpu = scanner.next();
        System.out.print("Enter the display inches of the laptop: ");
        String displayInches = scanner.next();
        System.out.print("Enter the weight of the laptop: ");
        String weight = scanner.next();
        System.out.print("Enter the width of the laptop: ");
        String width = scanner.next();
        System.out.print("Enter the height of the laptop: ");
        String height = scanner.next();
        System.out.print("Enter the depth of the laptop: ");
        String depth = scanner.next();
        System.out.print("Enter the price of the laptop: ");
        String price = scanner.next();

        Laptop laptop = new Laptop(0, Double.parseDouble(batteryCapacity), os, Integer.parseInt(memoryRom),
                Integer.parseInt(systemMemory), Double.parseDouble(cpu), Integer.parseInt(displayInches),
                Integer.parseInt(weight), Double.parseDouble(width), Double.parseDouble(height),
                Integer.parseInt(depth), Integer.parseInt(price));
        try {
            laptopService.addLaptop(laptop);
            System.out.println(Colors.GREEN + "Laptop added successfully!" + Colors.RESET);
        } catch (IOException e) {
            System.out.println(Colors.RED + "Error adding laptop: " + e.getMessage() + Colors.RESET);
        }
    }

    private void removeLaptop(Scanner scanner) {
        System.out.print("Enter the ID of the laptop to remove: ");
        try {
            int id = Integer.parseInt(scanner.next());
            boolean removed = laptopService.removeLaptop(id);
            if (removed) {
                System.out.println(Colors.GREEN + "Laptop removed successfully!" + Colors.RESET);
            } else {
                System.out.println(Colors.RED + "Laptop not found." + Colors.RESET);
            }
        } catch (NumberFormatException e) {
            System.out.println(Colors.RED + "Invalid input. Please enter a valid number." + Colors.RESET);
        } catch (IOException e) {
            System.out.println(Colors.RED + "Error removing laptop: " + e.getMessage() + Colors.RESET);
        }
    }

    private void viewLaptops() {
        try {
            List<Laptop> laptopList = laptopService.getAll();
            if (laptopList.isEmpty()) {
                System.out.println(Colors.RED + "No laptops available." + Colors.RESET);
            } else {
                laptopList.forEach(laptop -> System.out.println(Colors.CYAN + laptop + Colors.RESET));
            }
        } catch (IOException e) {
            System.out.println(Colors.RED + "Error viewing laptops: " + e.getMessage() + Colors.RESET);
        }
    }
}