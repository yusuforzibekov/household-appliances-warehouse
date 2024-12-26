package edu.itpu.fopjava_course_work.service;

import edu.itpu.fopjava_course_work.dao.implementation.LaptopDAOImpl;
import edu.itpu.fopjava_course_work.entity.Laptop;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminService {
    private Map<String, String> users = new HashMap<>();
    private boolean isAuthorized = false;
    private LaptopDAOImpl laptopDAO;

    public AdminService() {
        // Add default admin user
        users.put("admin", "admin123");
        laptopDAO = new LaptopDAOImpl();
    }

    public boolean authorize(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            isAuthorized = true;
            return true;
        }
        return false;
    }

    public void addAppliance(Laptop laptop) throws IOException {
        if (isAuthorized) {
            laptopDAO.createLaptop(laptop);
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public void removeAppliance(int id) throws IOException {
        if (isAuthorized) {
            laptopDAO.deleteLaptop(id);
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public List<Laptop> getAppliances() throws IOException {
        if (isAuthorized) {
            return laptopDAO.getLaptopList();
        } else {
            throw new SecurityException("Not authorized");
        }
    }
}
