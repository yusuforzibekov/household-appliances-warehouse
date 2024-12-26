package edu.itpu.fopjava_course_work.service;

import edu.itpu.fopjava_course_work.dao.implementation.LaptopDAOImpl;
import edu.itpu.fopjava_course_work.dao.implementation.RefrigeratorDAOImpl;
import edu.itpu.fopjava_course_work.dao.implementation.OvenDAOImpl;
import edu.itpu.fopjava_course_work.entity.Laptop;
import edu.itpu.fopjava_course_work.entity.Refrigerator;
import edu.itpu.fopjava_course_work.entity.Oven;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminService {
    private Map<String, String> users = new HashMap<>();
    private boolean isAuthorized = false;
    private LaptopDAOImpl laptopDAO;
    private RefrigeratorDAOImpl refrigeratorDAO;
    private OvenDAOImpl ovenDAO;

    public AdminService() {
        // Add default admin user
        users.put("admin", "admin123");
        laptopDAO = new LaptopDAOImpl();
        refrigeratorDAO = new RefrigeratorDAOImpl();
        ovenDAO = new OvenDAOImpl();
    }

    public boolean authorize(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            isAuthorized = true;
            return true;
        }
        return false;
    }

    public void addLaptop(Laptop laptop) throws IOException {
        if (isAuthorized) {
            laptopDAO.createLaptop(laptop);
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public void addRefrigerator(Refrigerator refrigerator) throws IOException {
        if (isAuthorized) {
            refrigeratorDAO.createRefrigerator(refrigerator);
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public void addOven(Oven oven) throws IOException {
        if (isAuthorized) {
            ovenDAO.createOven(oven);
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public void removeLaptop(int id) throws IOException {
        if (isAuthorized) {
            laptopDAO.deleteLaptop(id);
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public void removeRefrigerator(int id) throws IOException {
        if (isAuthorized) {
            refrigeratorDAO.deleteRefrigerator(id);
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public void removeOven(int id) throws IOException {
        if (isAuthorized) {
            ovenDAO.deleteOven(id);
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public List<Laptop> getLaptops() throws IOException {
        if (isAuthorized) {
            return laptopDAO.getLaptopList();
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public List<Refrigerator> getRefrigerators() throws IOException {
        if (isAuthorized) {
            return refrigeratorDAO.getRefrigeratorsList();
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public List<Oven> getOvens() throws IOException {
        if (isAuthorized) {
            return ovenDAO.getOvensList();
        } else {
            throw new SecurityException("Not authorized");
        }
    }
}
