package edu.itpu.fopjava_course_work.controller;

import edu.itpu.fopjava_course_work.entity.Oven;
import edu.itpu.fopjava_course_work.service.OvenService;
import edu.itpu.fopjava_course_work.utils.Colors;
import edu.itpu.fopjava_course_work.utils.UserInputHandler;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class OvenController {
    private final OvenService ovenService;

    public OvenController(OvenService ovenService) {
        this.ovenService = ovenService;
    }

    public void handleOvens(Scanner scanner) throws IOException {
        while (true) {
            System.out.println("\n" + Colors.BOLD + Colors.BLUE + "=== OVEN OPERATIONS ===" + Colors.RESET);
            System.out.println("1. Search Oven by Keyword");
            System.out.println("2. Search Oven by Power Consumption");
            System.out.println("3. Search Oven by Capacity");
            System.out.println("4. Show All Ovens");
            System.out.println("5. Back to Main Menu");
            System.out.println(Colors.BOLD + Colors.BLUE + "=======================" + Colors.RESET);

            System.out.print("Please enter your choice: ");
            int ovenChoice = UserInputHandler.readInteger(scanner);

            switch (ovenChoice) {
                case 1 -> {
                    System.out.print("Enter the keyword for the oven: ");
                    String searchOven = scanner.next();
                    List<Oven> ovenList = ovenService.getOvensBySearch(searchOven);
                    if (ovenList.isEmpty()) {
                        System.out.println(Colors.RED + "No results found for '" + searchOven + "'." + Colors.RESET);
                    } else {
                        ovenList.forEach(oven -> System.out.println(Colors.CYAN + oven + Colors.RESET));
                    }
                }
                case 2 -> {
                    System.out.print("Enter the power consumption of the oven: ");
                    String searchOvenByPowerConsumption = scanner.next();
                    List<Oven> ovenList = ovenService.getOvensByPowerConsumption(searchOvenByPowerConsumption);
                    if (ovenList.isEmpty()) {
                        System.out.println(Colors.RED + "No results found for power consumption '" + searchOvenByPowerConsumption + "'." + Colors.RESET);
                        System.out.println("Try searching with different values.");
                    } else {
                        ovenList.forEach(oven -> System.out.println(Colors.CYAN + oven + Colors.RESET));
                    }
                }
                case 3 -> {
                    System.out.print("Enter the capacity of the oven: ");
                    String searchOvenByCapacity = scanner.next();
                    List<Oven> ovenList = ovenService.getOvensByCapacity(searchOvenByCapacity);
                    if (ovenList.isEmpty()) {
                        System.out.println(Colors.RED + "No results found for capacity '" + searchOvenByCapacity + "'." + Colors.RESET);
                        System.out.println("Try searching with different values.");
                    } else {
                        ovenList.forEach(oven -> System.out.println(Colors.CYAN + oven + Colors.RESET));
                    }
                }
                case 4 -> {
                    System.out.println(Colors.GREEN + "List of all ovens:" + Colors.RESET);
                    List<Oven> ovenList = ovenService.getAll();
                    ovenList.forEach(oven -> System.out.println(Colors.CYAN + oven + Colors.RESET));
                }
                case 5 -> {
                    // Go back to the main menu
                    return;
                }
                default -> System.out.println(Colors.HEIGHT + "Invalid input. Please try again." + Colors.RESET);
            }
        }
    }

    public void handleAdminOperations(Scanner scanner) throws IOException {
        while (true) {
            System.out.println("\n" + Colors.BOLD + Colors.BLUE + "=== OVEN ADMIN OPERATIONS ===" + Colors.RESET);
            System.out.println("1. Add Oven");
            System.out.println("2. Remove Oven");
            System.out.println("3. View Ovens");
            System.out.println("4. Back to Admin Menu");
            System.out.println(Colors.BOLD + Colors.BLUE + "==============================" + Colors.RESET);

            System.out.print("Please enter your choice: ");
            int choice = UserInputHandler.readInteger(scanner);

            switch (choice) {
                case 1 -> addOven(scanner);
                case 2 -> removeOven(scanner);
                case 3 -> viewOvens();
                case 4 -> {
                    return;
                }
                default -> System.out.println(Colors.RED + "Invalid choice. Please try again." + Colors.RESET);
            }
        }
    }

    private void addOven(Scanner scanner) {
        System.out.print("Enter the power consumption of the oven: ");
        String powerConsumption = scanner.next();
        System.out.print("Enter the capacity of the oven: ");
        String capacity = scanner.next();
        System.out.print("Enter the weight of the oven: ");
        String weight = scanner.next();
        System.out.print("Enter the width of the oven: ");
        String width = scanner.next();
        System.out.print("Enter the height of the oven: ");
        String height = scanner.next();
        System.out.print("Enter the depth of the oven: ");
        String depth = scanner.next();
        System.out.print("Enter the price of the oven: ");
        String price = scanner.next();
        
        Oven oven = new Oven(0, Integer.parseInt(powerConsumption), Integer.parseInt(capacity), Integer.parseInt(weight), Double.parseDouble(width), Double.parseDouble(height), Integer.parseInt(depth), Integer.parseInt(price));
        try {
            ovenService.addOven(oven);
            System.out.println(Colors.GREEN + "Oven added successfully!" + Colors.RESET);
        } catch (IOException e) {
            System.out.println(Colors.RED + "Error adding oven: " + e.getMessage() + Colors.RESET);
        }
    }

    private void removeOven(Scanner scanner) {
        System.out.print("Enter the ID of the oven to remove: ");
        int id = scanner.nextInt();
        try {
            boolean removed = ovenService.removeOven(id);
            if (removed) {
                System.out.println(Colors.GREEN + "Oven removed successfully!" + Colors.RESET);
            } else {
                System.out.println(Colors.RED + "Oven not found." + Colors.RESET);
            }
        } catch (IOException e) {
            System.out.println(Colors.RED + "Error removing oven: " + e.getMessage() + Colors.RESET);
        }
    }

    private void viewOvens() {
        try {
            List<Oven> ovenList = ovenService.getAll();
            if (ovenList.isEmpty()) {
                System.out.println(Colors.RED + "No ovens available." + Colors.RESET);
            } else {
                ovenList.forEach(oven -> System.out.println(Colors.CYAN + oven + Colors.RESET));
            }
        } catch (IOException e) {
            System.out.println(Colors.RED + "Error viewing ovens: " + e.getMessage() + Colors.RESET);
        }
    }
}