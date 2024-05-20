package edu.itpu.fopjava_course_work.entity;

import java.util.Objects;

import edu.itpu.fopjava_course_work.utils.Colors;

public class Oven extends Appliance implements PowerConsumable {

    private Integer id; // ID of the oven
    private Integer powerConsumption; // Power consumption in watts
    private Integer capacity; // Capacity of the oven in liters

    // Constructor with parameters
    public Oven(Integer id, Integer powerConsumption, Integer capacity, Integer weight, double width, double height,
            Integer depth, Integer price) {
        // Call superclass constructor to initialize common fields
        super(weight, width, height, depth, price);
        // Initialize the remaining fields specific to the Oven class
        this.id = id;
        this.powerConsumption = powerConsumption;
        this.capacity = capacity;
    }

    // Getters and setters for each field
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(Integer powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    // Override equals, hashCode, and toString methods
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Oven oven = (Oven) o;
        return Objects.equals(id, oven.id) &&
                Objects.equals(powerConsumption, oven.powerConsumption) &&
                Objects.equals(capacity, oven.capacity) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, powerConsumption, capacity, super.hashCode());
    }

    @Override
    public String toString() {
        return Colors.BOLD + Colors.RESET + "Oven [" + Colors.RESET +
                Colors.ID + "id=" + id + ", " + Colors.RESET +
                Colors.POWER_CONSUMPTION + "powerConsumption=" + powerConsumption + ", " + Colors.RESET +
                Colors.CAPACITY + "capacity=" + capacity + ", " + Colors.RESET + super.toString();
    }
}