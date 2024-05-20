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
}