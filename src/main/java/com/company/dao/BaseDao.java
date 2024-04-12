package com.company.dao;

import java.io.IOException;
import java.util.List;

public interface BaseDao<T> {
    List<T> showAll(String sort) throws IOException;

    T findByID(String id) throws IOException;

    List<T> findByColor(String color) throws IOException;

    List<T> filterByPrice(String min, String max) throws IOException;
}
