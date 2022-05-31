package com.example.carpool_buddy_sam.Vehicles;

import android.os.Parcelable;

import java.util.ArrayList;

//Car child class of Vehicle
public class Car extends Vehicle {

    //instance variables
    private int range;

    //No argument constructor
    public Car(){

    }

    //Constructor
    public Car(String owner, String model, int capacity, String vehicleID, ArrayList<String> ridersUIDs, boolean open, String vehicleType, double basePrice, int range) {
        super(owner, model, capacity, vehicleID, ridersUIDs, open, vehicleType, basePrice);

        this.range = range;
    }

    //Getters and setters
    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    //toString
    @Override
    public String toString() {
        return "Car{" +
                "range=" + range +
                ", owner='" + getOwner() + '\'' +
                ", model='" + getModel() + '\'' +
                ", capacity=" + getCapacity() +
                ", vehicleID='" + getVehicleID() + '\'' +
                ", ridersUIDs=" + getRidersUIDs() +
                ", open=" + isOpen() +
                ", vehicleType='" + getVehicleID() + '\'' +
                ", basePrice=" + getBasePrice() +
                '}';
    }
}
