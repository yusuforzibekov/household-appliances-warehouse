package edu.itpu.fopjava_course_work.controller;

import edu.itpu.fopjava_course_work.entity.Feedback;
import edu.itpu.fopjava_course_work.service.FeedbackService;
import edu.itpu.fopjava_course_work.service.implementation.FeedbackServiceImpl;
import edu.itpu.fopjava_course_work.utils.Colors;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Scanner;

public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController() {
        this.feedbackService = new FeedbackServiceImpl();
    }

    public void handleFeedback(Scanner scanner) throws IOException {
        System.out.println("\n" + Colors.PURPLE + "=== PROVIDE FEEDBACK ===" + Colors.RESET);
        System.out.println("Your feedback is important to us. Please provide your " +
                Colors.NAME + "name" + Colors.RESET +
                ", " +
                Colors.SURNAME + "surname" + Colors.RESET +
                ", and " +
                Colors.FEEDBACK + "message" + Colors.RESET +
                ".");
        System.out.println("Enter " + "'" + Colors.YELLOW + "exit" + Colors.RESET + "'"
                + " at any time to return to the main menu.");
        System.out.print(Colors.NAME + "Enter your name: " + Colors.RESET);
        scanner.nextLine(); // Consume the newline character left by nextInt()
        String name = scanner.nextLine().trim();

        if (name.equalsIgnoreCase("exit")) {
            System.out.println(Colors.YELLOW + "Returning to main menu..." + Colors.RESET);
            return;
        }

        System.out.print(Colors.BATTERY_CAPACITY + "Enter your surname: " + Colors.RESET);
        String surname = scanner.nextLine().trim();

        if (surname.equalsIgnoreCase("exit")) {
            System.out.println(Colors.RED + "Returning to main menu..." + Colors.RESET);
            return;
        }

        System.out.print(Colors.FEEDBACK + "Enter your feedback message: " + Colors.RESET);
        String message = scanner.nextLine().trim();

        if (message.equalsIgnoreCase("exit")) {
            System.out.println(Colors.YELLOW + "Returning to main menu..." + Colors.RESET);
            return;
        }

        Feedback feedback = new Feedback(name, surname, message);
        try {
            feedbackService.sendFeedback(feedback);
            System.out.println("Thank you for your feedback!");
        } catch (MessagingException e) {
            System.err.println(Colors.RED + "Failed to send feedback email: " + e.getMessage() + Colors.RESET);
        }
    }
}