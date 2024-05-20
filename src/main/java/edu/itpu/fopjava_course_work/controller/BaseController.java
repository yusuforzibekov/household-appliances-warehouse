package edu.itpu.fopjava_course_work.controller;

import edu.itpu.fopjava_course_work.service.ServiceFactory;
import edu.itpu.fopjava_course_work.utils.Colors;
import edu.itpu.fopjava_course_work.utils.UserInputHandler;

import java.io.IOException;
import java.util.Scanner;

public class BaseController {
    private static LaptopController laptopOperations;
    private static OvenController ovenOperations;
    private static RefrigeratorController refrigeratorOperations;
    private static FeedbackController feedbackController;
    private static HelpController helpController;

    public BaseController() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();

        laptopOperations = new LaptopController(serviceFactory.getLaptopService());
        ovenOperations = new OvenController(serviceFactory.getOvenService());
        refrigeratorOperations = new RefrigeratorController(serviceFactory.getRefrigeratorService());
        feedbackController = new FeedbackController();
        helpController = new HelpController();
    }

    public void start() throws IOException {
        System.out.println(Colors.GREEN + Colors.BOLD + """
                    Project: Household Appliances Warehouse
                    Student: Yusufbek Orzibekov, Yusufbek_Orzibekov@student.itpu.uz
                    Creation date: April 15th, 2024
                    Version: 1.0
                """ + Colors.RESET);

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display the main menu
            System.out.println("\n" + Colors.BOLD + Colors.BLUE + "=== MAIN MENU ===" + Colors.RESET);
            System.out.println("1. Laptops");
            System.out.println("2. Ovens");
            System.out.println("3. Refrigerators");
            System.out.println("4. Help");
            System.out.println("5. Provide Feedback");
            System.out.println("6. Exit");
            System.out.println(Colors.BOLD + Colors.BLUE + "=================" + Colors.RESET);

            System.out.print("Please enter your choice: ");
            int mainMenuChoice = UserInputHandler.readInteger(scanner);

            // Handle main menu choices
            switch (mainMenuChoice) {
                case 1 -> laptopOperations.handleLaptops(scanner);
                case 2 -> ovenOperations.handleOvens(scanner);
                case 3 -> refrigeratorOperations.handleRefrigerators(scanner);
                case 4 -> helpController.handleHelp(scanner);
                case 5 -> feedbackController.handleFeedback(scanner);
                case 6 -> {
                    System.out.println(Colors.YELLOW + "Exiting the program. Goodbye!" + Colors.RESET);
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println(Colors.RED + "Invalid input. Please try again." + Colors.RESET);
            }
        }
    }
}