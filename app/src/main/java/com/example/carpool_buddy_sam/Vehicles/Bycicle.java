package com.example.carpool_buddy_sam.Vehicles;

import java.util.ArrayList;

/**
 * Child class of Vehicle.
 * Used to manage one type of vehicles and store all relevant information.
 */
//Bycicle child class of Vehicle
public class Bycicle extends Vehicle{

    //Instance variables
    private String bycileType;
    private int weight;
    private int weightCapacity;

    //Constructor
    public Bycicle(String owner, String model, int capacity,
                   String vehicleID, ArrayList<String> ridersUIDs,
                   boolean open, String vehicleType, double basePrice,
                   String bycileType, int weight, int weightCapacity) {

        super(owner, model, capacity, vehicleID, ridersUIDs, open, vehicleType, basePrice);
        this.bycileType = bycileType;
        this.weight = weight;
        this.weightCapacity = weightCapacity;
    }

    //No argument constructor
    public Bycicle(){
        super();
    }

    //Getters and setters

    /**
     * getter for bycileType
     * @return String of bycileType
     */
    public String getBycileType() {
        return bycileType;
    }

    /**
     * setter for bycileType
     * @param bycileType String of bycileType
     */
    public void setBycileType(String bycileType) {
        this.bycileType = bycileType;
    }

    /**
     * getter for weight
     * @return int of weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * setter for weight
     * @param weight int of weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
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
     * @return String of : uid, name, email, userType, priceMultiplier, ownedVehicles, bycileType, weight, weightCapacity
     */
    //toString
    @Override
    public String toString() {
        return "Bycicle{" +
                "bycileType='" + bycileType + '\'' +
                ", weight=" + weight +
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
