package edu.itpu.fopjava_course_work.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class CSVUtils {

    public static List<String[]> readCSV(String filePath) throws IOException {
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read the first line (header) of the CSV file
            String header = bufferedReader.readLine();
            rows.add(header.split(";"));

            while ((line = bufferedReader.readLine()) != null) {
                // Split each line by semicolon ';' and add to the list
                String[] rowData = line.split(";");
                rows.add(rowData);
            }
        }
        return rows;
    }

    public static void writeCSV(String filePath, List<String[]> rows) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < rows.size(); i++) {
                bufferedWriter.write(String.join(";", rows.get(i)));
                if (i < rows.size() - 1) {
                    bufferedWriter.newLine();
                }
            }
        }
    }
}