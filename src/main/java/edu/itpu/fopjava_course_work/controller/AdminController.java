package edu.itpu.fopjava_course_work.controller;

import edu.itpu.fopjava_course_work.service.AdminService;
import edu.itpu.fopjava_course_work.service.ServiceFactory;
import edu.itpu.fopjava_course_work.utils.Colors;
import edu.itpu.fopjava_course_work.utils.UserInputHandler;

import java.io.IOException;
import java.util.Scanner;

public class AdminController {
    private final AdminService adminService;
    private final LaptopController laptopController;
    private final OvenController ovenController;
    private final RefrigeratorController refrigeratorController;
    private final Scanner scanner;

    public AdminController(LaptopController laptopController, OvenController ovenController, RefrigeratorController refrigeratorController) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        this.adminService = new AdminService(serviceFactory.getLaptopService(), serviceFactory.getRefrigeratorService(), serviceFactory.getOvenService());
        this.laptopController = laptopController;
        this.ovenController = ovenController;
        this.refrigeratorController = refrigeratorController;
        this.scanner = new Scanner(System.in);
    }

    public void start() throws IOException {
        System.out.println(Colors.PURPLE + "Welcome to the Admin Panel" + Colors.RESET);
        if (authorizeAdmin()) {
            while (true) {
                System.out.println("\n" + Colors.BOLD + Colors.BLUE + "=== ADMIN MENU ===" + Colors.RESET);
                System.out.println("1. Laptops");
                System.out.println("2. Ovens");
                System.out.println("3. Refrigerators");
                System.out.println("4. Exit");
                System.out.println(Colors.BOLD + Colors.BLUE + "==================" + Colors.RESET);

                System.out.print("Please enter your choice: ");
                int choice = UserInputHandler.readInteger(scanner);

                switch (choice) {
                    case 1 -> laptopController.handleAdminOperations(scanner);
                    case 2 -> ovenController.handleAdminOperations(scanner);
                    case 3 -> refrigeratorController.handleAdminOperations(scanner);
                    case 4 -> {
                        System.out.println(Colors.YELLOW + "Exiting the admin panel. Goodbye!" + Colors.RESET);
                        return;
                    }
                    default -> System.out.println(Colors.RED + "Invalid choice. Please try again." + Colors.RESET);
                }
            }
        } else {
            System.out.println(Colors.RED + "Authorization failed. Exiting..." + Colors.RESET);
        }
    }

    private boolean authorizeAdmin() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        return adminService.authorize(username, password);
    }
}
