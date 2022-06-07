package com.example.carpool_buddy_sam.Vehicles;

import java.util.ArrayList;

/**
 * Child class of Vehicle.
 * Used to manage one type of vehicles and store all relevant information.
 */
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

    /**
     * getter for maxAltitude
     * @return int of maxAltitude
     */
    public int getMaxAltitude() {
        return maxAltitude;
    }

    /**
     * setter for maxAltitude
     * @param maxAltitude int of maxAltitude
     */
    public void setMaxAltitude(int maxAltitude) {
        this.maxAltitude = maxAltitude;
    }

    /**
     * getter for maxAirSpeed
     * @return int of maxAirSpeed
     */
    public int getMaxAirSpeed() {
        return maxAirSpeed;
    }

    /**
     * setter for maxAirSpeed
     * @param maxAirSpeed int of maxAirSpeed
     */
    public void setMaxAirSpeed(int maxAirSpeed) {
        this.maxAirSpeed = maxAirSpeed;
    }

    /**
     * toString method for HeliCopter
     * @return String of : uid, name, email, userType, priceMultiplier, ownedVehicles, maxAltitude, maxAirSpeed
     */
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
