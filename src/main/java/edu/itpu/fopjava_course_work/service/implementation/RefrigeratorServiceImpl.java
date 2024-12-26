package edu.itpu.fopjava_course_work.service.implementation;

import edu.itpu.fopjava_course_work.dao.RefrigeratorDAO;
import edu.itpu.fopjava_course_work.dao.DAOFactory;
import edu.itpu.fopjava_course_work.entity.Refrigerator;
import edu.itpu.fopjava_course_work.service.RefrigeratorService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RefrigeratorServiceImpl implements RefrigeratorService {
    private final RefrigeratorDAO refrigeratorDAO;

    public RefrigeratorServiceImpl() {
        this.refrigeratorDAO = DAOFactory.getInstance().getRefrigeratorDAO();
    }

    @Override
    public List<Refrigerator> getRefrigeratorsBySearch(String searchRefrigerator) throws IOException {
        List<Refrigerator> refrigerators = refrigeratorDAO.getRefrigeratorsList();
        String normalizedSearchTerm = searchRefrigerator.toLowerCase();
        List<Refrigerator> searchRefrigeratorList = new ArrayList<>();

        for (Refrigerator refrigerator : refrigerators) {
            if (refrigerator.toString().contains(searchRefrigerator)) {
                searchRefrigeratorList.add(refrigerator);
            } else if (refrigerator.toString().toLowerCase().contains(normalizedSearchTerm)) {
                searchRefrigeratorList.add(refrigerator);
            }
        }
        return searchRefrigeratorList;
    }

    @Override
    public List<Refrigerator> getRefrigeratorsByPowerConsumption(String searchRefrigeratorByPowerConsumption)
            throws IOException {
        List<Refrigerator> refrigerators = refrigeratorDAO.getRefrigeratorsList();
        List<Refrigerator> searchRefrigeratorList = new ArrayList<>();
        for (Refrigerator refrigerator : refrigerators) {
            if (String.valueOf(refrigerator.getPowerConsumption())
                    .equalsIgnoreCase(searchRefrigeratorByPowerConsumption)) {
                searchRefrigeratorList.add(refrigerator);
            }
        }
        return searchRefrigeratorList;
    }

    @Override
    public List<Refrigerator> getRefrigeratorsByOverallCapacity(String searchRefrigeratorByOverallCapacity)
            throws IOException {
        List<Refrigerator> refrigerators = refrigeratorDAO.getRefrigeratorsList();
        List<Refrigerator> searchRefrigeratorList = new ArrayList<>();
        for (Refrigerator refrigerator : refrigerators) {
            if (String.valueOf(refrigerator.getOverallCapacity())
                    .equalsIgnoreCase(searchRefrigeratorByOverallCapacity)) {
                searchRefrigeratorList.add(refrigerator);
            }
        }
        return searchRefrigeratorList;
    }

    @Override
    public List<Refrigerator> getAll() throws IOException {
        return refrigeratorDAO.getRefrigeratorsList();
    }

    @Override
    public void addRefrigerator(Refrigerator refrigerator) throws IOException {
        refrigeratorDAO.createRefrigerator(refrigerator);
    }

    @Override
    public boolean removeRefrigerator(int id) throws IOException {
        refrigeratorDAO.deleteRefrigerator(id);
        return true;
    }
}
