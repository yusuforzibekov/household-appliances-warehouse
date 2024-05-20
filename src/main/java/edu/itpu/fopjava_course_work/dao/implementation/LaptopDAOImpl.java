package edu.itpu.fopjava_course_work.dao.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.itpu.fopjava_course_work.dao.LaptopDAO;
import edu.itpu.fopjava_course_work.entity.Laptop;
import edu.itpu.fopjava_course_work.utils.CSVUtils;

public class LaptopDAOImpl implements LaptopDAO {

    private static final String CSV_FILE_PATH = "src/main/resources/laptops.csv"; // Path to the CSV file

    @Override
    public List<String[]> readMethod() throws IOException {
        return CSVUtils.readCSV(CSV_FILE_PATH);
    }

    @Override
    public List<Laptop> getLaptopList() throws IOException {
        // Read the CSV file and get the data as a list of string arrays
        List<String[]> rows = readMethod();

        // Initialize an empty list to hold Laptop objects
        List<Laptop> laptopList = new ArrayList<>();

        // Iterate through each row from the CSV file
        for (String[] laptopData : rows) {
            // Parse the data from each row and create a Laptop object
            Laptop laptop = new Laptop(
                Integer.parseInt(laptopData[0]), // id
                Double.parseDouble(laptopData[1]), // batteryCapacity
                laptopData[2], // os
                Integer.parseInt(laptopData[3]), // memoryRom
                Integer.parseInt(laptopData[4]), // systemMemory
                Double.parseDouble(laptopData[5]), // cpu
                Integer.parseInt(laptopData[6]), // displayInches
                Integer.parseInt(laptopData[7]), // weight
                Double.parseDouble(laptopData[8]), // width
                Double.parseDouble(laptopData[9]), // height
                Integer.parseInt(laptopData[10]), // depth
                Integer.parseInt(laptopData[11]) // price              
            );

            // Add the Laptop object to the list
            laptopList.add(laptop);
        }

        // Return the list of Laptop objects
        return laptopList;
    }
}