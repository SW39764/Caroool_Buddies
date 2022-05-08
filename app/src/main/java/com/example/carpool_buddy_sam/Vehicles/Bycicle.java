package com.example.carpool_buddy_sam.Vehicles;

import java.util.ArrayList;

public class Bycicle extends Vehicle{

    private String bycileType;
    private int weight;
    private int weightCapacity;

    public Bycicle(String owner, String model, int capacity,
                   String vehicleID, ArrayList<String> ridersUIDs,
                   boolean open, String vehicleType, double basePrice,
                   String bycileType, int weight, int weightCapacity) {

        super(owner, model, capacity, vehicleID, ridersUIDs, open, vehicleType, basePrice);
        this.bycileType = bycileType;
        this.weight = weight;
        this.weightCapacity = weightCapacity;
    }

    public Bycicle(){
        super();
    }


    public String getBycileType() {
        return bycileType;
    }

    public void setBycileType(String bycileType) {
        this.bycileType = bycileType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(int weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

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
