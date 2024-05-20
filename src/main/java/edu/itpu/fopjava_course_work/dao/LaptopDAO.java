package edu.itpu.fopjava_course_work.dao;

import edu.itpu.fopjava_course_work.entity.Laptop;

import java.io.IOException;
import java.util.List;

public interface LaptopDAO {
    List<String[]> readMethod() throws IOException;

    List<Laptop> getLaptopList() throws IOException;
}