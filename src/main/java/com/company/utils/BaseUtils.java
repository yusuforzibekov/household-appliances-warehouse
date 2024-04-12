package com.company.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

public class BaseUtils {
    public static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static Gson gsonWithNulls = (new GsonBuilder()).setPrettyPrinting().serializeNulls().create();

    private static final Scanner readText;
    private static final Scanner readNumerics;

    static {
        readText = new Scanner(System.in);
        readNumerics = new Scanner(System.in);
    }

    public static void print(String data) {
        System.out.print(data);
    }

    public static void println(String data) {
        System.out.println(data);
    }

    public static String readText() {
        return readText.nextLine();
    }
}
