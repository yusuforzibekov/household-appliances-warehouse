package edu.itpu.fopjava_course_work;

import edu.itpu.fopjava_course_work.controller.BaseController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            new BaseController().start();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "An error occurred while running the application", e);
        }
    }
}