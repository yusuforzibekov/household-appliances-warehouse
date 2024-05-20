package edu.itpu.fopjava_course_work.service.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.itpu.fopjava_course_work.dao.LaptopDAO;
import edu.itpu.fopjava_course_work.dao.implementation.LaptopDAOImpl;
import edu.itpu.fopjava_course_work.entity.Laptop;
import edu.itpu.fopjava_course_work.service.LaptopService;

public class LaptopServiceImpl implements LaptopService {
    private final LaptopDAO laptopDao = new LaptopDAOImpl();

    public LaptopServiceImpl(LaptopDAO laptopDao) {
        // this.laptopDao = laptopDao;
    }

    @Override
    public List<Laptop> getLaptopBySearch(String searchLaptop) throws IOException {
        String normalizedSearchTerm = searchLaptop.toLowerCase();
        List<Laptop> laptopList = laptopDao.getLaptopList();
        List<Laptop> searchLaptopList = new ArrayList<>();
        for (Laptop laptop : laptopList) {
            if (laptop.toString().contains(searchLaptop)) {
                searchLaptopList.add(laptop);
            } else if (laptop.toString().toLowerCase().contains(normalizedSearchTerm)) {
                searchLaptopList.add(laptop);
            }
        }
        return searchLaptopList;
    }

    @Override
    public List<Laptop> getLaptopsByOS(String searchLaptopByOS) throws IOException {
        List<Laptop> laptopList = laptopDao.getLaptopList();
        List<Laptop> searchLaptopList = new ArrayList<>();
        for (Laptop laptop : laptopList) {
            // Check for exact match of search term in the OS attribute
            if (laptop.getOs().equalsIgnoreCase(searchLaptopByOS)) {
                searchLaptopList.add(laptop);
            }
        }
        return searchLaptopList;
    }


    @Override
    public List<Laptop> getLaptopsByCPU(String searchLaptopByCPU) throws IOException {
        List<Laptop> laptopList = laptopDao.getLaptopList();
        List<Laptop> searchLaptopList = new ArrayList<>();
        for (Laptop laptop : laptopList) {
            // Check for exact match of search term in the CPU attribute
            if (String.valueOf(laptop.getCpu()).equalsIgnoreCase(searchLaptopByCPU)) {
                searchLaptopList.add(laptop);
            }
        }
        return searchLaptopList;
    }

    @Override
    public List<Laptop> getAll() throws IOException {
        return laptopDao.getLaptopList();
    }
}