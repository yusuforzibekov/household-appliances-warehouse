package edu.itpu.fopjava_course_work.service.implementation;

import edu.itpu.fopjava_course_work.dao.OvenDAO;
import edu.itpu.fopjava_course_work.dao.DAOFactory;
import edu.itpu.fopjava_course_work.entity.Oven;
import edu.itpu.fopjava_course_work.service.OvenService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OvenServiceImpl implements OvenService {
    private final OvenDAO ovenDAO;

    public OvenServiceImpl() {
        this.ovenDAO = DAOFactory.getInstance().getOvenDAO();
    }

    @Override
    public List<Oven> getOvensBySearch(String searchOven) throws IOException {
        List<Oven> ovens = ovenDAO.getOvensList();
        String normalizedSearchTerm = searchOven.toLowerCase();
        List<Oven> searchOvenList = new ArrayList<>();

        for (Oven oven : ovens) {
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
        List<Oven> ovens = ovenDAO.getOvensList();
        List<Oven> searchOvenList = new ArrayList<>();
        for (Oven oven : ovens) {
            if (String.valueOf(oven.getPowerConsumption()).equalsIgnoreCase(searchOvenByPowerConsumption)) {
                searchOvenList.add(oven);
            }
        }
        return searchOvenList;
    }

    @Override
    public List<Oven> getOvensByCapacity(String searchOvenByCapacity) throws IOException {
        List<Oven> ovens = ovenDAO.getOvensList();
        List<Oven> searchOvenList = new ArrayList<>();
        for (Oven oven : ovens) {
            if (String.valueOf(oven.getCapacity()).equalsIgnoreCase(searchOvenByCapacity)) {
                searchOvenList.add(oven);
            }
        }
        return searchOvenList;
    }

    @Override
    public List<Oven> getAll() throws IOException {
        return ovenDAO.getOvensList();
    }

    @Override
    public void addOven(Oven oven) throws IOException {
        ovenDAO.createOven(oven);
    }

    @Override
    public boolean removeOven(int id) throws IOException {
        ovenDAO.deleteOven(id);
        return true;
    }
}