package com.example.carpool_buddy_sam.Vehicles;

import java.util.ArrayList;

//Segway child class of Vehicle
public class Segway extends Vehicle{

    //Instance variables
    private int range;
    private int weightCapacity;


    //No argument constructor
    public Segway(){
    }

    //Constructor
    public Segway(String owner, String model, int capacity, String vehicleID,
                  ArrayList<String> ridersUIDs, boolean open, String vehicleType,
                  double basePrice, int range, int weightCapacity) {
        super(owner, model, capacity, vehicleID, ridersUIDs, open, vehicleType, basePrice);
        this.range = range;
        this.weightCapacity = weightCapacity;
    }

    //Getters and setters
    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(int weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    //toString
    @Override
    public String toString() {
        return "Segway{" +
                "range=" + range +
                ", weightCapacity=" + weightCapacity +
                ", owner='" + getOwner() + '\'' +
                ", model='" + getModel() + '\'' +
                ", capacity=" + getCapacity() +
                ", vehicleID='" + getVehicleID() + '\'' +
                ", ridersUIDs=" + getRidersUIDs() +
                ", open=" + isOpen() +
                ", vehicleType='" + getVehicleType() + '\'' +
                ", basePrice=" + getBasePrice() +
                '}';
    }
}
