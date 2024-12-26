package edu.itpu.fopjava_course_work.dao.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.itpu.fopjava_course_work.dao.OvenDAO;
import edu.itpu.fopjava_course_work.entity.Oven;
import edu.itpu.fopjava_course_work.utils.CSVUtils;

public class OvenDAOImpl implements OvenDAO {

    private static final String CSV_FILE_PATH = "src/main/resources/ovens.csv"; // Path to the CSV file

    @Override
    public List<String[]> readMethod() throws IOException {
        return CSVUtils.readCSV(CSV_FILE_PATH);
    }

    @Override
    public List<Oven> getOvensList() throws IOException {
        // Read the CSV file and retrieve the data as a list of arrays of strings
        List<String[]> rows = readMethod();

        // Initialize an empty list to hold `Oven` objects
        List<Oven> ovenList = new ArrayList<>();

        // Iterate through each row from the CSV file, skipping the header row
        for (int i = 1; i < rows.size(); i++) {
            String[] ovenData = rows.get(i);
            try {
                // Parse the data from each row and create an `Oven` object
                Oven oven = new Oven(
                        Integer.parseInt(ovenData[0]), // ID
                        Integer.parseInt(ovenData[1]), // Power consumption
                        Integer.parseInt(ovenData[2]), // Capacity
                        Integer.parseInt(ovenData[3]), // Weight
                        Double.parseDouble(ovenData[4]), // Width
                        Double.parseDouble(ovenData[5]), // Height
                        Integer.parseInt(ovenData[6]), // Depth
                        Integer.parseInt(ovenData[7]) // Price
                );

                // Add the `Oven` object to the list
                ovenList.add(oven);
            } catch (NumberFormatException e) {
                // Skip rows with invalid data without printing
            }
        }

        // Return the list of `Oven` objects
        return ovenList;
    }

    @Override
    public void createOven(Oven oven) throws IOException {
        List<String[]> rows = readMethod();
        int newId = rows.size();
        String[] ovenData = new String[] {
                String.valueOf(newId),
                String.valueOf(oven.getPowerConsumption()),
                String.valueOf(oven.getCapacity()),
                String.valueOf(oven.getWeight()),
                String.valueOf(oven.getWidth()),
                String.valueOf(oven.getHeight()),
                String.valueOf(oven.getDepth()),
                String.valueOf(oven.getPrice())
        };
        rows.add(ovenData);
        CSVUtils.writeCSV(CSV_FILE_PATH, rows);
    }

    @Override
    public void deleteOven(int id) throws IOException {
        List<String[]> rows = CSVUtils.readCSV(CSV_FILE_PATH);
        Iterator<String[]> iterator = rows.iterator();
        while (iterator.hasNext()) {
            String[] ovenData = iterator.next();
            if (ovenData[0].equals("ID")) {
                continue;
            }
            if (Integer.parseInt(ovenData[0]) == id) {
                iterator.remove();
                break;
            }
        }
        CSVUtils.writeCSV(CSV_FILE_PATH, rows);
    }
}