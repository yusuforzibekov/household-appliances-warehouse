package edu.itpu.fopjava_course_work.service;

import edu.itpu.fopjava_course_work.service.implementation.LaptopServiceImpl;
import edu.itpu.fopjava_course_work.service.implementation.OvenServiceImpl;
import edu.itpu.fopjava_course_work.service.implementation.RefrigeratorServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final LaptopService laptopService = new LaptopServiceImpl();
    private final OvenService ovenService = new OvenServiceImpl();
    private final RefrigeratorService refrigeratorService = new RefrigeratorServiceImpl();

    private ServiceFactory() {
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