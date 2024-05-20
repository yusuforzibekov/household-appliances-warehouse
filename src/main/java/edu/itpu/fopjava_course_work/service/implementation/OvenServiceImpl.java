package edu.itpu.fopjava_course_work.service.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.itpu.fopjava_course_work.dao.OvenDAO;
import edu.itpu.fopjava_course_work.dao.implementation.OvenDAOImpl;
import edu.itpu.fopjava_course_work.entity.Oven;
import edu.itpu.fopjava_course_work.service.OvenService;

public class OvenServiceImpl implements OvenService {
    // Dependency Injection of OvenDao
    private final OvenDAO ovenDao = new OvenDAOImpl();

    public OvenServiceImpl(OvenDAO ovenDao) {
        // Constructor injection of OvenDao
        // this.ovenDao = ovenDao;
    }

    @Override
    public List<Oven> getOvensBySearch(String searchOven) throws IOException {
        // Retrieve the list of ovens from the data source
        String normalizedSearchTerm = searchOven.toLowerCase();
        List<Oven> ovenList = ovenDao.getOvensList();
        List<Oven> searchOvenList = new ArrayList<>();

        // Filter the list based on the search criteria
        for (Oven oven : ovenList) {
            if (oven.toString().contains(searchOven)) {
                searchOvenList.add(oven);
            } else if (oven.toString().toLowerCase().contains(normalizedSearchTerm)) {
                searchOvenList.add(oven);
            }
        }
        return searchOvenList;
    }

    @Override
    public List<Oven> getOvensByPowerConsumption(String searchOvenByPowerConsumption) throws IOException {
        List<Oven> ovenList = ovenDao.getOvensList();
        List<Oven> searchOvenList = new ArrayList<>();
        for (Oven oven : ovenList) {
            // Check for exact match of search term in the power consumption attribute
            if (String.valueOf(oven.getPowerConsumption()).equalsIgnoreCase(searchOvenByPowerConsumption)) {
                searchOvenList.add(oven);
            }
        }
        return searchOvenList;
    }

    @Override
    public List<Oven> getOvensByCapacity(String searchOvenByCapacity) throws IOException {
        List<Oven> ovenList = ovenDao.getOvensList();
        List<Oven> searchOvenList = new ArrayList<>();
        for (Oven oven : ovenList) {
            // Check for exact match of search term in the capacity attribute
            if (String.valueOf(oven.getCapacity()).equalsIgnoreCase(searchOvenByCapacity)) {
                searchOvenList.add(oven);
            }
        }
        return searchOvenList;
    }

    @Override
    public List<Oven> getAll() throws IOException {
        // Retrieve and return the list of all ovens
        return ovenDao.getOvensList();
    }
}