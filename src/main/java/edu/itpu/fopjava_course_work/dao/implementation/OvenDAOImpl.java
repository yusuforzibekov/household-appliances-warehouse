package edu.itpu.fopjava_course_work.dao.implementation;

import java.io.IOException;
import java.util.ArrayList;
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

        // Iterate through each row from the CSV file
        for (String[] ovenData : rows) {
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
        }

        // Return the list of `Oven` objects
        return ovenList;
    }
}