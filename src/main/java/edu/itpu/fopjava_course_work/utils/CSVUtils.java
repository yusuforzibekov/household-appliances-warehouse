package edu.itpu.fopjava_course_work.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    public static List<String[]> readCSV(String filePath) throws IOException {
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip the first line (header) of the CSV file
            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                // Split each line by semicolon ';' and add to the list
                String[] rowData = line.split(";");
                rows.add(rowData);
            }
        }
        return rows;
    }
}