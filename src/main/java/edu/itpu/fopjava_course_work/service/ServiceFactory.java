package edu.itpu.fopjava_course_work.service;

import edu.itpu.fopjava_course_work.dao.DAOFactory;
import edu.itpu.fopjava_course_work.service.implementation.LaptopServiceImpl;
import edu.itpu.fopjava_course_work.service.implementation.OvenServiceImpl;
import edu.itpu.fopjava_course_work.service.implementation.RefrigeratorServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final LaptopService laptopService;
    private final OvenService ovenService;
    private final RefrigeratorService refrigeratorService;

    private ServiceFactory() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        laptopService = new LaptopServiceImpl(daoFactory.getLaptopDAO());
        ovenService = new OvenServiceImpl(daoFactory.getOvenDAO());
        refrigeratorService = new RefrigeratorServiceImpl(daoFactory.getRefrigeratorDAO());
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public LaptopService getLaptopService() {
        return laptopService;
    }

    public OvenService getOvenService() {
        return ovenService;
    }

    public RefrigeratorService getRefrigeratorService() {
        return refrigeratorService;
    }
}