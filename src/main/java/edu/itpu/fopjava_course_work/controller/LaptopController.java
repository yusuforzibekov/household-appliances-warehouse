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
                        System.out.println(Colors.RED + "No results found for OS '" + searchLaptopByOS + "'." + Colors.RESET);
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
                        System.out.println(Colors.RED + "No results found for CPU '" + searchLaptopByCPU + "'." + Colors.RESET);
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
        }
    }
}