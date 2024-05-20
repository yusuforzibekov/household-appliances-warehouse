package edu.itpu.fopjava_course_work.entity;

import java.util.Objects;

import edu.itpu.fopjava_course_work.utils.Colors;

public class Laptop extends Appliance {

    private Integer id; // Unique identifier
    private double batteryCapacity; // Battery capacity
    private String os; // Operating System
    private Integer memoryRom; // Memory ROM size
    private Integer systemMemory; // System Memory (RAM) size
    private double cpu; // CPU speed
    private Integer displayInches; // Display size in inches

    // Constructor with parameters
    public Laptop(Integer id, double batteryCapacity, String os, Integer memoryRom, Integer systemMemory, double cpu,
            Integer displayInches, Integer weight, double width, double height, Integer depth, Integer price) {
        // Call superclass constructor to initialize common fields
        super(weight, width, height, depth, price);

        this.id = id;
        this.batteryCapacity = batteryCapacity;
        this.os = os;
        this.memoryRom = memoryRom;
        this.systemMemory = systemMemory;
        this.cpu = cpu;
        this.displayInches = displayInches;
    }

    // Getters and setters for each field
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Integer getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(Integer memoryRom) {
        this.memoryRom = memoryRom;
    }

    public Integer getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(Integer systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public Integer getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(Integer displayInches) {
        this.displayInches = displayInches;
    }

    // Override equals, hashCode, and toString methods
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Laptop laptop = (Laptop) o;
        return Double.compare(laptop.batteryCapacity, batteryCapacity) == 0 &&
                memoryRom.equals(laptop.memoryRom) &&
                systemMemory.equals(laptop.systemMemory) &&
                Double.compare(laptop.cpu, cpu) == 0 &&
                displayInches.equals(laptop.displayInches) &&
                id.equals(laptop.id) &&
                os.equals(laptop.os) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, batteryCapacity, os, memoryRom, systemMemory, cpu, displayInches, super.hashCode());
    }

    @Override
    public String toString() {
        return String.format(Colors.RESET + "Laptop [" +
                Colors.ID + "id=%d, " + Colors.RESET +
                Colors.BATTERY_CAPACITY + "batteryCapacity=%s, " + Colors.RESET +
                Colors.OS + "os=%s, " + Colors.RESET +
                Colors.MEMORY_ROM + "memoryRom=%d, " + Colors.RESET +
                Colors.SYSTEM_MEMORY + "systemMemory=%d, " + Colors.RESET +
                Colors.CPU + "cpu=%s, " + Colors.RESET +
                Colors.DISPLAY_INCHES + "displayInches=%d, " + Colors.RESET +
                "%s",
                id, formatDouble(batteryCapacity), os, memoryRom, systemMemory, formatDouble(cpu), displayInches,
                super.toString());
    }
}