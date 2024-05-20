package edu.itpu.fopjava_course_work.service.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.itpu.fopjava_course_work.dao.RefrigeratorDAO;
import edu.itpu.fopjava_course_work.dao.implementation.RefrigeratorDAOImpl;
import edu.itpu.fopjava_course_work.entity.Refrigerator;
import edu.itpu.fopjava_course_work.service.RefrigeratorService;



public class RefrigeratorServiceImpl implements RefrigeratorService {
    // Dependency Injection of RefrigeratorDao
    private final RefrigeratorDAO refrigeratorDao = new RefrigeratorDAOImpl();

    public RefrigeratorServiceImpl(RefrigeratorDAO refrigeratorDao) {
        // Constructor injection of RefrigeratorDao
        // this.refrigeratorDao = refrigeratorDao;
    }

    @Override
    public List<Refrigerator> getRefrigeratorsBySearch(String searchRefrigerator) throws IOException {
        // Retrieve the list of refrigerators from the data source
        String normalizedSearchTerm = searchRefrigerator.toLowerCase();
        List<Refrigerator> refrigeratorList = refrigeratorDao.getRefrigeratorsList();
        List<Refrigerator> searchRefrigeratorList = new ArrayList<>();

        // Filter the list based on the search criteria
        for (Refrigerator refrigerator : refrigeratorList) {
            if (refrigerator.toString().contains(searchRefrigerator)) {
                searchRefrigeratorList.add(refrigerator);
            } else if (refrigerator.toString().toLowerCase().contains(normalizedSearchTerm)) {
                searchRefrigeratorList.add(refrigerator);
            }
        }
        return searchRefrigeratorList;
    }

    @Override
    public List<Refrigerator> getRefrigeratorsByPowerConsumption(String searchRefrigeratorByPowerConsumption) throws IOException {
        List<Refrigerator> refrigeratorList = refrigeratorDao.getRefrigeratorsList();
        List<Refrigerator> searchRefrigeratorList = new ArrayList<>();
        for (Refrigerator refrigerator : refrigeratorList) {
            // Check for exact match of search term in the power consumption attribute
            if (String.valueOf(refrigerator.getPowerConsumption()).equalsIgnoreCase(searchRefrigeratorByPowerConsumption)) {
                searchRefrigeratorList.add(refrigerator);
            }
        }
        return searchRefrigeratorList;
    }

    @Override
    public List<Refrigerator> getRefrigeratorsByOverallCapacity(String searchRefrigeratorByOverallCapacity) throws IOException {
        List<Refrigerator> refrigeratorList = refrigeratorDao.getRefrigeratorsList();
        List<Refrigerator> searchRefrigeratorList = new ArrayList<>();
        for (Refrigerator refrigerator : refrigeratorList) {
            // Check for exact match of search term in the overall capacity attribute
            if (String.valueOf(refrigerator.getOverallCapacity()).equalsIgnoreCase(searchRefrigeratorByOverallCapacity)) {
                searchRefrigeratorList.add(refrigerator);
            }
        }
        return searchRefrigeratorList;
    }

    @Override
    public List<Refrigerator> getAll() throws IOException {
        // Retrieve and return the list of all refrigerators
        return refrigeratorDao.getRefrigeratorsList();
    }
}
