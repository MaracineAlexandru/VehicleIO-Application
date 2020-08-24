package com.company;

public class Tractor extends Vehicle{
    private String brand;
    private String model;
    private String price;
    private String maxPulledWeight;

    public Tractor(String brand, String model, String price,String maxPulledWeight) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.maxPulledWeight = maxPulledWeight;
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
        if (price.contains("unknown")) {
            return 0;
        } else {
            return Integer.parseInt(price);
        }
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMaxPulledWeight() {
        return maxPulledWeight;
    }

    public void setMaxPulledWeight(String maxPulledWeight) {
        this.maxPulledWeight = maxPulledWeight;
    }


}
