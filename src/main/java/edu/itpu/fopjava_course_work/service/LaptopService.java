package edu.itpu.fopjava_course_work.service;

import java.io.IOException;
import java.util.List;

import edu.itpu.fopjava_course_work.entity.Laptop;

public interface LaptopService {
    List<Laptop> getLaptopBySearch(String searchLaptop) throws IOException;

    List<Laptop> getLaptopsByOS(String searchLaptopByOS) throws IOException;

    List<Laptop> getLaptopsByCPU(String searchLaptopByCPU) throws IOException;

    List<Laptop> getAll() throws IOException;
}