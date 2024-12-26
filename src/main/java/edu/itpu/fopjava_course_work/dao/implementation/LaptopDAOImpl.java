package edu.itpu.fopjava_course_work.dao.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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

        // Iterate through each row from the CSV file, skipping the header row
        for (int i = 1; i < rows.size(); i++) {
            String[] laptopData = rows.get(i);
            try {
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
            } catch (NumberFormatException e) {
                // Skip rows with invalid data without printing
            }
        }

        // Return the list of Laptop objects
        return laptopList;
    }

    @Override
    public void createLaptop(Laptop laptop) throws IOException {
        // Read the CSV file and get the data as a list of string arrays
        List<String[]> rows = readMethod();

        // Determine the new ID for the laptop
        int newId = rows.size();

        // Create a new string array to hold the data for the new Laptop object
        String[] laptopData = new String[] {
                String.valueOf(newId), // id
                String.valueOf(laptop.getBatteryCapacity()), // batteryCapacity
                laptop.getOs(), // os
                String.valueOf(laptop.getMemoryRom()), // memoryRom
                String.valueOf(laptop.getSystemMemory()), // systemMemory
                String.valueOf(laptop.getCpu()), // cpu
                String.valueOf(laptop.getDisplayInches()), // displayInches
                String.valueOf(laptop.getWeight()), // weight
                String.valueOf(laptop.getWidth()), // width
                String.valueOf(laptop.getHeight()), // height
                String.valueOf(laptop.getDepth()), // depth
                String.valueOf(laptop.getPrice()) // price
        };

        // Add the new Laptop data to the list of rows
        rows.add(laptopData);

        // Write the updated data back to the CSV file
        CSVUtils.writeCSV(CSV_FILE_PATH, rows);
    }

    @Override
    public void deleteLaptop(int id) throws IOException {
        // Read the CSV file and get the data as a list of string arrays
        List<String[]> rows = CSVUtils.readCSV(CSV_FILE_PATH);

        // Use an iterator to avoid ConcurrentModificationException
        Iterator<String[]> iterator = rows.iterator();
        while (iterator.hasNext()) {
            String[] laptopData = iterator.next();
            // Skip the header row
            if (laptopData[0].equals("ID")) {
                continue;
            }
            // Check if the id of the current Laptop object matches the id of the Laptop
            // object to be deleted
            if (Integer.parseInt(laptopData[0]) == id) {
                // Remove the data for the Laptop object
                iterator.remove();
                break;
            }
        }

        // Write the updated data back to the CSV file
        CSVUtils.writeCSV(CSV_FILE_PATH, rows);
    }
}