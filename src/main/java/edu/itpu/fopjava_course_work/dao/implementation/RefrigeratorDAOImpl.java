package edu.itpu.fopjava_course_work.dao.implementation;

import java.io.IOException;
import java.util.ArrayList;
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

        // Iterate through each row from the CSV file
        for (String[] refrigeratorData : rows) {
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
        }

        // Return the list of Refrigerator objects
        return refrigeratorList;
    }
}