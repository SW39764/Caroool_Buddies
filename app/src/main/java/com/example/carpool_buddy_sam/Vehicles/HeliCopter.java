package com.example.carpool_buddy_sam.Vehicles;

import java.util.ArrayList;

//Helicopter child class of Vehicle
public class HeliCopter extends Vehicle{

    //Instance variables
    private int maxAltitude;
    private int maxAirSpeed;

    //No argument constructor
    public HeliCopter(){
        super();
    }

    //Constructor
    public HeliCopter(String owner,
                      String model, int capacity,
                      String vehicleID, ArrayList<String> ridersUIDs,
                      boolean open, String vehicleType, double basePrice,
                      int maxAltitude, int maxAirSpeed) {

        super(owner, model, capacity, vehicleID, ridersUIDs, open, vehicleType, basePrice);
        this.maxAltitude = maxAltitude;
        this.maxAirSpeed = maxAirSpeed;
    }

    //Getters and setters
    public int getMaxAltitude() {
        return maxAltitude;
    }

    public void setMaxAltitude(int maxAltitude) {
        this.maxAltitude = maxAltitude;
    }

    public int getMaxAirSpeed() {
        return maxAirSpeed;
    }

    public void setMaxAirSpeed(int maxAirSpeed) {
        this.maxAirSpeed = maxAirSpeed;
    }

    //toString
    @Override
    public String toString() {
        return "HeliCopter{" +
                "maxAltitude=" + maxAltitude +
                ", maxAirSpeed=" + maxAirSpeed +
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
