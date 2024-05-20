package edu.itpu.fopjava_course_work.entity;

import java.util.Objects;

import edu.itpu.fopjava_course_work.utils.Colors;

public class Appliance {

    private Integer weight; // weight of the appliance
    private double width; // width of the appliance
    private double height; // height of the appliance
    private Integer depth; // depth of the appliance
    private Integer price; // price of the appliance

    // Default constructor
    public Appliance() {
    }

    // Constructor with parameters
    public Appliance(Integer weight, double width, double height, Integer depth, Integer price) {
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.price = price;
    }

    // Getters and Setters
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    String formatDouble(double value) {
        if (value % 1 == 0) {
            // The value is a whole number (no fractional part)
            return String.format("%d", (int) value);
        } else {
            // The value has a fractional part
            return String.format("%.1f", value);
        }
    }

    // Override equals method
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Appliance appliance = (Appliance) o;
        return weight.equals(appliance.weight) &&
                Double.compare(appliance.width, width) == 0 &&
                Double.compare(appliance.height, height) == 0 &&
                depth.equals(appliance.depth) &&
                Objects.equals(price, appliance.price);
    }

    // Override hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(weight, width, height, depth, price);
    }

    // Override toString method
    @Override
    public String toString() {
        return String.format(
                Colors.WEIGHT + "weight=%d" + ", " + Colors.RESET +
                        Colors.WIDTH + "width=%s" + ", " + Colors.RESET +
                        Colors.HEIGHT + "height=%s" + ", " + Colors.RESET +
                        Colors.DEPTH + "depth=%d" + ", " + Colors.RESET +
                        Colors.PRICE + "price=%d" + Colors.RESET + "]" + Colors.RESET,
                weight, formatDouble(width), formatDouble(height), depth, price);
    }
}