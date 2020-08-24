package com.company;

public abstract class Vehicle {
    abstract String getBrand();
    public String getModel(){
        return "";
    };
    public String getTransmission(){
        return "";
    };
    public int getPrice(){
        return 0;
    };
    public String getShape(){
        return "";
    }
    public int getTopSpeed(){
        return 0;
    }
    public String getMaxPulledWeight(){
        return "";
    }
}
