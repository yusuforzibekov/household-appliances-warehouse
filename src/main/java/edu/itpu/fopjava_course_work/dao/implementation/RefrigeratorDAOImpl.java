package edu.itpu.fopjava_course_work.dao.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.itpu.fopjava_course_work.dao.RefrigeratorDAO;
import edu.itpu.fopjava_course_work.entity.Refrigerator;
import edu.itpu.fopjava_course_work.utils.CSVUtils;

public class RefrigeratorDAOImpl implements RefrigeratorDAO {
    private static final String CSV_FILE_PATH = "src/main/resources/refrigerators.csv"; // Path to the CSV file

    @Override
    public List<String[]> readMethod() throws IOException {
        return CSVUtils.readCSV(CSV_FILE_PATH);
    }

    @Override
    public List<Refrigerator> getRefrigeratorsList() throws IOException {
        // Read the CSV file and get the data as a list of string arrays
        List<String[]> rows = readMethod();

        // Initialize an empty list to hold Refrigerator objects
        List<Refrigerator> refrigeratorList = new ArrayList<>();

        // Iterate through each row from the CSV file, skipping the header row
        for (int i = 1; i < rows.size(); i++) {
            String[] refrigeratorData = rows.get(i);
            try {
                // Parse the data from each row and create a Refrigerator object
                Refrigerator refrigerator = new Refrigerator(
                        Integer.parseInt(refrigeratorData[0]), // id
                        Integer.parseInt(refrigeratorData[1]), // powerConsumption
                        Integer.parseInt(refrigeratorData[2]), // freezerCapacity
                        Integer.parseInt(refrigeratorData[3]), // overallCapacity
                        Integer.parseInt(refrigeratorData[4]), // weight
                        Double.parseDouble(refrigeratorData[5]), // width
                        Double.parseDouble(refrigeratorData[6]), // height
                        Integer.parseInt(refrigeratorData[7]), // depth
                        Integer.parseInt(refrigeratorData[8]) // price
                );

                // Add the Refrigerator object to the list
                refrigeratorList.add(refrigerator);
            } catch (NumberFormatException e) {
                // Skip rows with invalid data without printing
            }
        }

        // Return the list of Refrigerator objects
        return refrigeratorList;
    }

    public void createRefrigerator(Refrigerator refrigerator) throws IOException {
        List<String[]> rows = readMethod();
        int newId = rows.size();
        String[] refrigeratorData = new String[] {
                String.valueOf(newId),
                String.valueOf(refrigerator.getPowerConsumption()),
                String.valueOf(refrigerator.getFreezerCapacity()),
                String.valueOf(refrigerator.getOverallCapacity()),
                String.valueOf(refrigerator.getWeight()),
                String.valueOf(refrigerator.getWidth()),
                String.valueOf(refrigerator.getHeight()),
                String.valueOf(refrigerator.getDepth()),
                String.valueOf(refrigerator.getPrice())
        };
        rows.add(refrigeratorData);
        CSVUtils.writeCSV(CSV_FILE_PATH, rows);
    }

    public void deleteRefrigerator(int id) throws IOException {
        List<String[]> rows = CSVUtils.readCSV(CSV_FILE_PATH);
        Iterator<String[]> iterator = rows.iterator();
        while (iterator.hasNext()) {
            String[] refrigeratorData = iterator.next();
            if (refrigeratorData[0].equals("ID")) {
                continue;
            }
            if (Integer.parseInt(refrigeratorData[0]) == id) {
                iterator.remove();
                break;
            }
        }
        CSVUtils.writeCSV(CSV_FILE_PATH, rows);
    }
}