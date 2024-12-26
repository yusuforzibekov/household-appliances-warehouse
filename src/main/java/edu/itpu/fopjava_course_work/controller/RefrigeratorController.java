package edu.itpu.fopjava_course_work.controller;

import edu.itpu.fopjava_course_work.entity.Refrigerator;
import edu.itpu.fopjava_course_work.service.RefrigeratorService;
import edu.itpu.fopjava_course_work.utils.Colors;
import edu.itpu.fopjava_course_work.utils.UserInputHandler;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class RefrigeratorController {
    private final RefrigeratorService refrigeratorService;

    public RefrigeratorController(RefrigeratorService refrigeratorService) {
        this.refrigeratorService = refrigeratorService;
    }

    public void handleRefrigerators(Scanner scanner) throws IOException {
        while (true) {
            System.out.println("\n" + Colors.BOLD + Colors.BLUE + "=== REFRIGERATOR OPERATIONS ===" + Colors.RESET);
            System.out.println("1. Search Refrigerator by Keyword");
            System.out.println("2. Search Refrigerator by Power Consumption");
            System.out.println("3. Search Refrigerator by Overall Capacity");
            System.out.println("4. Show All Refrigerators");
            System.out.println("5. Back to Main Menu");
            System.out.println(Colors.BOLD + Colors.BLUE + "===============================" + Colors.RESET);

            try {
                System.out.print("Please enter your choice: ");
                int refrigeratorChoice = UserInputHandler.readInteger(scanner);

                switch (refrigeratorChoice) {
                    case 1 -> {
                        System.out.print("Enter the keyword for the refrigerator: ");
                        String searchRefrigerator = scanner.next();
                        List<Refrigerator> refrigeratorList = refrigeratorService
                                .getRefrigeratorsBySearch(searchRefrigerator);
                        if (refrigeratorList.isEmpty()) {
                            System.out.println(
                                    Colors.RED + "No results found for '" + searchRefrigerator + "'." + Colors.RESET);
                        } else {
                            refrigeratorList
                                    .forEach(refrigerator -> System.out.println(Colors.CPU + refrigerator + Colors.RESET));
                        }
                    }

                    case 2 -> {
                        System.out.print("Enter the power consumption of the refrigerator: ");
                        String searchRefrigeratorByPowerConsumption = scanner.next();
                        List<Refrigerator> refrigeratorList = refrigeratorService
                                .getRefrigeratorsByPowerConsumption(searchRefrigeratorByPowerConsumption);
                        if (refrigeratorList.isEmpty()) {
                            System.out.println(Colors.RED + "No results found for power consumption '"
                                    + searchRefrigeratorByPowerConsumption + "'." + Colors.RESET);
                            System.out.println("Try searching with different values.");
                        } else {
                            refrigeratorList
                                    .forEach(refrigerator -> System.out.println(Colors.CPU + refrigerator + Colors.RESET));
                        }
                    }

                    case 3 -> {
                        System.out.print("Enter the overall capacity of the refrigerator: ");
                        String searchRefrigeratorByOverallCapacity = scanner.next();
                        List<Refrigerator> refrigeratorList = refrigeratorService
                                .getRefrigeratorsByOverallCapacity(searchRefrigeratorByOverallCapacity);
                        if (refrigeratorList.isEmpty()) {
                            System.out.println(Colors.RED + "No results found for overall capacity '"
                                    + searchRefrigeratorByOverallCapacity + "'." + Colors.RESET);
                            System.out.println("Try searching with different values.");
                        } else {
                            refrigeratorList
                                    .forEach(refrigerator -> System.out.println(Colors.CPU + refrigerator + Colors.RESET));
                        }
                    }

                    case 4 -> {
                        System.out.println(Colors.GREEN + "List of all refrigerators:" + Colors.RESET);
                        List<Refrigerator> refrigeratorList = refrigeratorService.getAll();
                        refrigeratorList
                                .forEach(refrigerator -> System.out.println(Colors.CYAN + refrigerator + Colors.RESET));
                    }

                    case 5 -> {
                        // Go back to the main menu
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

    public void handleAdminOperations(Scanner scanner) throws IOException {
        while (true) {
            System.out
                    .println("\n" + Colors.BOLD + Colors.BLUE + "=== REFRIGERATOR ADMIN OPERATIONS ===" + Colors.RESET);
            System.out.println("1. Add Refrigerator");
            System.out.println("2. Remove Refrigerator");
            System.out.println("3. View Refrigerators");
            System.out.println("4. Back to Admin Menu");
            System.out.println(Colors.BOLD + Colors.BLUE + "=====================================" + Colors.RESET);

            try {
                System.out.print("Please enter your choice: ");
                int choice = UserInputHandler.readInteger(scanner);

                switch (choice) {
                    case 1 -> addRefrigerator(scanner);
                    case 2 -> removeRefrigerator(scanner);
                    case 3 -> viewRefrigerators();
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

    private void addRefrigerator(Scanner scanner) {
        System.out.print("Enter the power consumption of the refrigerator: ");
        String powerConsumption = scanner.next();
        System.out.print("Enter the freezer capacity of the refrigerator: ");
        String freezerCapacity = scanner.next();
        System.out.print("Enter the overall capacity of the refrigerator: ");
        String overallCapacity = scanner.next();
        System.out.print("Enter the weight of the refrigerator: ");
        String weight = scanner.next();
        System.out.print("Enter the width of the refrigerator: ");
        String width = scanner.next();
        System.out.print("Enter the height of the refrigerator: ");
        String height = scanner.next();
        System.out.print("Enter the depth of the refrigerator: ");
        String depth = scanner.next();
        System.out.print("Enter the price of the refrigerator: ");
        String price = scanner.next();

        Refrigerator refrigerator = new Refrigerator(0, Integer.parseInt(powerConsumption),
                Integer.parseInt(freezerCapacity), Integer.parseInt(overallCapacity), Integer.parseInt(weight),
                Double.parseDouble(width), Double.parseDouble(height), Integer.parseInt(depth),
                Integer.parseInt(price));
        try {
            refrigeratorService.addRefrigerator(refrigerator);
            System.out.println(Colors.GREEN + "Refrigerator added successfully!" + Colors.RESET);
        } catch (IOException e) {
            System.out.println(Colors.RED + "Error adding refrigerator: " + e.getMessage() + Colors.RESET);
        }
    }

    private void removeRefrigerator(Scanner scanner) {
        System.out.print("Enter the ID of the refrigerator to remove: ");
        try {
            int id = Integer.parseInt(scanner.next());
            boolean removed = refrigeratorService.removeRefrigerator(id);
            if (removed) {
                System.out.println(Colors.GREEN + "Refrigerator removed successfully!" + Colors.RESET);
            } else {
                System.out.println(Colors.RED + "Refrigerator not found." + Colors.RESET);
            }
        } catch (NumberFormatException e) {
            System.out.println(Colors.RED + "Invalid input. Please enter a valid number." + Colors.RESET);
        } catch (IOException e) {
            System.out.println(Colors.RED + "Error removing refrigerator: " + e.getMessage() + Colors.RESET);
        }
    }

    private void viewRefrigerators() {
        try {
            List<Refrigerator> refrigeratorList = refrigeratorService.getAll();
            if (refrigeratorList.isEmpty()) {
                System.out.println(Colors.RED + "No refrigerators available." + Colors.RESET);
            } else {
                refrigeratorList.forEach(refrigerator -> System.out.println(Colors.CYAN + refrigerator + Colors.RESET));
            }
        } catch (IOException e) {
            System.out.println(Colors.RED + "Error viewing refrigerators: " + e.getMessage() + Colors.RESET);
        }
    }
}