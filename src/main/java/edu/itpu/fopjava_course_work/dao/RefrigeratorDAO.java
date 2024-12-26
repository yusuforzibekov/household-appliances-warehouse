package edu.itpu.fopjava_course_work.dao;

import edu.itpu.fopjava_course_work.entity.Refrigerator;

import java.io.IOException;
import java.util.List;

public interface RefrigeratorDAO {
    List<String[]> readMethod() throws IOException;

    List<Refrigerator> getRefrigeratorsList() throws IOException;

    void createRefrigerator(Refrigerator refrigerator) throws IOException;

    void deleteRefrigerator(int id) throws IOException;
}