package com.example.carpool_buddy_sam.Vehicles;

import java.util.ArrayList;

/**
 * Child class of Vehicle.
 * Used to manage one type of vehicles and store all relevant information.
 */
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

    /**
     * getter for range
     * @return int of range
     */
    public int getRange() {
        return range;
    }

    /**
     * setter for range
     * @param range int of range
     */
    public void setRange(int range) {
        this.range = range;
    }

    /**
     * getter for weightCapacity
     * @return int of weightCapacity
     */
    public int getWeightCapacity() {
        return weightCapacity;
    }

    /**
     * setter for weightCapacity
     * @param weightCapacity int of weightCapacity
     */
    public void setWeightCapacity(int weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    /**
     * toString for vehicleType
     * @return String of range, weightCapacity, owner, model, capacity, vehicleID, ridersUIDs, open, vehicleType, basePrice
     */
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
