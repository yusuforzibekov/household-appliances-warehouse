package edu.itpu.fopjava_course_work.dao;

import edu.itpu.fopjava_course_work.dao.implementation.LaptopDAOImpl;
import edu.itpu.fopjava_course_work.dao.implementation.OvenDAOImpl;
import edu.itpu.fopjava_course_work.dao.implementation.RefrigeratorDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final LaptopDAO laptopDAO = new LaptopDAOImpl();
    private final OvenDAO ovenDAO = new OvenDAOImpl();
    private final RefrigeratorDAO refrigeratorDAO = new RefrigeratorDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public LaptopDAO getLaptopDAO() {
        return laptopDAO;
    }

    public OvenDAO getOvenDAO() {
        return ovenDAO;
    }

    public RefrigeratorDAO getRefrigeratorDAO() {
        return refrigeratorDAO;
    }
}