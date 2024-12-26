package edu.itpu.fopjava_course_work.entity;

import java.util.Objects;

import edu.itpu.fopjava_course_work.utils.Colors;

public class Refrigerator extends Appliance implements PowerConsumable {
    private Integer id; // Unique identifier
    private Integer powerConsumption; // Power consumption
    private Integer freezerCapacity; // Freezer capacity
    private Integer overallCapacity; // Overall capacity

    // Constructor with parameters
    public Refrigerator(Integer id, Integer powerConsumption, Integer freezerCapacity, Integer overallCapacity,
            Integer weight, double width, double height, Integer depth, Integer price) {
        // Call superclass constructor
        super(weight, width, height, depth, price);
        // Initialize the remaining fields specific to the Refrigerator class
        this.id = id;
        this.powerConsumption = powerConsumption;
        this.freezerCapacity = freezerCapacity;
        this.overallCapacity = overallCapacity;
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

    public Integer getFreezerCapacity() {
        return freezerCapacity;
    }

    public void setFreezerCapacity(Integer freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public Integer getOverallCapacity() {
        return overallCapacity;
    }

    public void setOverallCapacity(Integer overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    // Override equals, hashCode, and toString methods
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Refrigerator refrigerator = (Refrigerator) o;
        return Objects.equals(id, refrigerator.id) && Objects.equals(powerConsumption, refrigerator.powerConsumption)
                && Objects.equals(freezerCapacity, refrigerator.freezerCapacity)
                && Objects.equals(overallCapacity, refrigerator.overallCapacity) && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, powerConsumption, freezerCapacity, overallCapacity, super.hashCode());
    }

    @Override
    public String toString() {
        return Colors.BOLD + Colors.RESET + "Refrigerator [" + Colors.RESET + Colors.ID + "id=" + id + ", "
                + Colors.RESET + Colors.POWER_CONSUMPTION + "powerConsumption=" + powerConsumption + ", " + Colors.RESET
                + Colors.FREEZER_CAPACITY + "freezerCapacity=" + freezerCapacity + ", " + Colors.RESET
                + Colors.OVERALL_CAPACITY + "overallCapacity=" + overallCapacity + ", " + Colors.RESET
                + super.toString();
    }
}