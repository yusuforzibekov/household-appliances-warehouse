package edu.itpu.fopjava_course_work.service;

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
    private LaptopService laptopService;
    private RefrigeratorService refrigeratorService;
    private OvenService ovenService;

    public AdminService(LaptopService laptopService, RefrigeratorService refrigeratorService, OvenService ovenService) {
        // Add default admin user
        users.put("admin", "admin123");
        this.laptopService = laptopService;
        this.refrigeratorService = refrigeratorService;
        this.ovenService = ovenService;
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
            laptopService.addLaptop(laptop);
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public void addRefrigerator(Refrigerator refrigerator) throws IOException {
        if (isAuthorized) {
            refrigeratorService.addRefrigerator(refrigerator);
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public void addOven(Oven oven) throws IOException {
        if (isAuthorized) {
            ovenService.addOven(oven);
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public void removeLaptop(int id) throws IOException {
        if (isAuthorized) {
            laptopService.removeLaptop(id);
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public void removeRefrigerator(int id) throws IOException {
        if (isAuthorized) {
            refrigeratorService.removeRefrigerator(id);
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public void removeOven(int id) throws IOException {
        if (isAuthorized) {
            ovenService.removeOven(id);
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public List<Laptop> getLaptops() throws IOException {
        if (isAuthorized) {
            return laptopService.getAll();
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public List<Refrigerator> getRefrigerators() throws IOException {
        if (isAuthorized) {
            return refrigeratorService.getAll();
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public List<Oven> getOvens() throws IOException {
        if (isAuthorized) {
            return ovenService.getAll();
        } else {
            throw new SecurityException("Not authorized");
        }
    }
}
