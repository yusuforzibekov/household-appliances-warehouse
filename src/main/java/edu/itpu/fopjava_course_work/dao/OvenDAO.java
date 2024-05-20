package edu.itpu.fopjava_course_work.dao;

import edu.itpu.fopjava_course_work.entity.Oven;

import java.io.IOException;
import java.util.List;

public interface OvenDAO {
    List<String[]> readMethod() throws IOException;

    List<Oven> getOvensList() throws IOException;
}