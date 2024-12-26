package edu.itpu.fopjava_course_work.service;

import edu.itpu.fopjava_course_work.entity.Laptop;
import edu.itpu.fopjava_course_work.entity.Refrigerator;
import edu.itpu.fopjava_course_work.entity.Oven;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminService {
    private boolean isAuthorized = false;
    private LaptopService laptopService;
    private RefrigeratorService refrigeratorService;
    private OvenService ovenService;
    private Connection connection;

    public AdminService(LaptopService laptopService, RefrigeratorService refrigeratorService, OvenService ovenService) throws SQLException {
        this.laptopService = laptopService;
        this.refrigeratorService = refrigeratorService;
        this.ovenService = ovenService;
        this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/final_oop", "postgres", "18102005");
        createAdminTable();
        addDefaultAdmin();
    }

    private void createAdminTable() throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS admins (username VARCHAR(50) PRIMARY KEY, password VARCHAR(50))";
        try (PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL)) {
            preparedStatement.execute();
        }
    }

    private void addDefaultAdmin() throws SQLException {
        String insertAdminSQL = "INSERT INTO admins (username, password) VALUES ('admin', 'admin123') ON CONFLICT (username) DO NOTHING";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertAdminSQL)) {
            preparedStatement.execute();
        }
    }

    public boolean authorize(String username, String password) throws SQLException {
        String selectSQL = "SELECT password FROM admins WHERE username = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next() && resultSet.getString("password").equals(password)) {
                isAuthorized = true;
                return true;
            }
        }
        return false;
    }

    public void changePassword(String username, String newPassword) throws SQLException {
        String updateSQL = "UPDATE admins SET password = ? WHERE username = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        }
    }

    public void addLaptop(Laptop laptop) throws IOException {
        if (isAuthorized) {
            laptopService.addLaptop(laptop);
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public void addRefrigerator(Refrigerator refrigerator) throws IOException {
        if (isAuthorized) {
            refrigeratorService.addRefrigerator(refrigerator);
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public void addOven(Oven oven) throws IOException {
        if (isAuthorized) {
            ovenService.addOven(oven);
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public void removeLaptop(int id) throws IOException {
        if (isAuthorized) {
            laptopService.removeLaptop(id);
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public void removeRefrigerator(int id) throws IOException {
        if (isAuthorized) {
            refrigeratorService.removeRefrigerator(id);
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public void removeOven(int id) throws IOException {
        if (isAuthorized) {
            ovenService.removeOven(id);
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public List<Laptop> getLaptops() throws IOException {
        if (isAuthorized) {
            return laptopService.getAll();
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public List<Refrigerator> getRefrigerators() throws IOException {
        if (isAuthorized) {
            return refrigeratorService.getAll();
        } else {
            throw new SecurityException("Not authorized");
        }
    }

    public List<Oven> getOvens() throws IOException {
        if (isAuthorized) {
            return ovenService.getAll();
        } else {
            throw new SecurityException("Not authorized");
        }
    }
}
