package com.company;


import java.io.Serializable;

public class Car extends Vehicle implements Serializable  {
    private String brand;
    private String model;
    private String price;
    private String topSpeed;
    private String transmission;
    private String shape;

    public Car(String brand, String model, String price, String topSpeed, String transmission, String shape) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.topSpeed = topSpeed;
        this.transmission = transmission;
        this.shape = shape;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        int priceInteger=Integer.parseInt(price);
        return priceInteger;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getTopSpeed() {
        int topSpeedInteger=Integer.parseInt(topSpeed);
        return topSpeedInteger;
    }

    public void setTopSpeed(String topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }
}
