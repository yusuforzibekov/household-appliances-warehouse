package edu.itpu.fopjava_course_work.service;

import java.io.IOException;
import java.util.List;

import edu.itpu.fopjava_course_work.entity.Refrigerator;

public interface RefrigeratorService {
    List<Refrigerator> getRefrigeratorsBySearch(String searchRefrigerator) throws IOException;

    List<Refrigerator> getRefrigeratorsByPowerConsumption(String searchRefrigeratorByPowerConsumption) throws IOException;

    List<Refrigerator> getRefrigeratorsByOverallCapacity(String searchRefrigeratorByOverallCapacity) throws IOException;

    List<Refrigerator> getAll() throws IOException;
}