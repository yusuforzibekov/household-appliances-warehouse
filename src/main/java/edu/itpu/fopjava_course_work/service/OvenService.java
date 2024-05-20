package edu.itpu.fopjava_course_work.service;

import java.io.IOException;
import java.util.List;

import edu.itpu.fopjava_course_work.entity.Oven;

public interface OvenService {
    List<Oven> getOvensBySearch(String searchOven) throws IOException;

    List<Oven> getOvensByPowerConsumption(String searchOvenByPowerConsumption) throws IOException;

    List<Oven> getOvensByCapacity(String searchOvenByCapacity) throws IOException;

    List<Oven> getAll() throws IOException;
}