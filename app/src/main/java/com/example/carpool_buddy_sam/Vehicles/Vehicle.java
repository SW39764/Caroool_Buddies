package com.example.carpool_buddy_sam.Vehicles;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Parent class of : Car, Bike, Helicopter, and Segway
 * Used to manage one type of vehicles and store all relevant information.
 * Implemens Serializable and Parcelable for passing between activities and to database
 */
//Vehicle class - parent class to : Bycicle, Car, Segway, and HeliCopter classes
//implements Parcelable, Serializable to be able to send between activities and firebase accordingly
public class Vehicle implements Serializable, Parcelable {

    //instance variables
    private  String owner;
    private String model;
    private int capacity;
    private String vehicleID;
    private ArrayList<String> ridersUIDs;
    private boolean open;
    private String vehicleType;
    private double basePrice;

    //No argument constructor
    public Vehicle(){
    }

    //Constructor
    public Vehicle(String owner, String model, int capacity, String vehicleID, ArrayList<String> ridersUIDs, boolean open, String vehicleType, double basePrice) {
        this.owner = owner;
        this.model = model;
        this.capacity = capacity;
        this.vehicleID = vehicleID;
        this.ridersUIDs = ridersUIDs;
        this.open = open;
        this.vehicleType = vehicleType;
        this.basePrice = basePrice;
    }

    //Parcel constructor
    protected Vehicle(Parcel in) {
        owner = in.readString();
        model = in.readString();
        capacity = in.readInt();
        vehicleID = in.readString();
        ridersUIDs = in.createStringArrayList();
        open = in.readByte() != 0;
        vehicleType = in.readString();
        basePrice = in.readDouble();
    }

    //Parcelable methods
    public static final Creator<Vehicle> CREATOR = new Creator<Vehicle>() {
        @Override
        public Vehicle createFromParcel(Parcel in) {
            return new Vehicle(in);
        }

        @Override
        public Vehicle[] newArray(int size) {
            return new Vehicle[size];
        }
    };

    /**
     * getter for owner
     * @return String of owner
     */
    //Getters and setters
    public String getOwner() {
        return owner;
    }

    /**
     * setter for owner
     * @param owner String of owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * getter for model
     * @return String of model
     */
    public String getModel() {
        return model;
    }

    /**
     * setter for model
     * @param model String of model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * getter for capacity
     * @return int of capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * setter for capacity
     * @param capacity int of capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * getter for vehicleID
     * @return String of vehicleID
     */
    public String getVehicleID() {
        return vehicleID;
    }

    /**
     * setter for vehicleID
     * @param vehicleID String of vehicleID
     */
    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    /**
     * getter for ridersUIDs
     * @return ArrayList of ridersUIDs (String)
     */
    public ArrayList<String> getRidersUIDs() {
        return ridersUIDs;
    }

    /**
     * setter for ridersUIDs
     * @param ridersUIDs ArrayList of ridersUIDs (String)
     */
    public void setRidersUIDs(ArrayList<String> ridersUIDs) {
        this.ridersUIDs = ridersUIDs;
    }

    /**
     * getter for open
     * @return boolean of open
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * setter for open
     * @param open boolean of open
     */
    public void setOpen(boolean open) {
        this.open = open;
    }

    /**
     * getter for vehicleType
     * @return String of vehicleType
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * setter for vehicleType
     * @param vehicleType String of vehicleType
     */
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    /**
     * getter for basePrice
     * @return double of basePrice
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * setter for basePrice
     * @param basePrice double of basePrice
     */
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }


    /**
     * Overrides the toString method to return a string of the vehicle's information
     * @return String of vehicle information including : owner, model, capacity, vehicleID, ridersUIDs, open, vehicleType, basePrice
     */
    //toString
    @Override
    public String toString() {
        return "Vehicle{" +
                "owner='" + owner + '\'' +
                ", model='" + model + '\'' +
                ", capacity=" + capacity +
                ", vehicleID='" + vehicleID + '\'' +
                ", ridersUIDs=" + ridersUIDs +
                ", open=" + open +
                ", vehicleType='" + vehicleType + '\'' +
                ", basePrice=" + basePrice +
                '}';
    }

    //Parcelable methods
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * getter for capcaity of vehicle
     * @return int of capacity left in vehicle
     */
    //return occupancy
    public String getOccupiedCapacity() {
        return Integer.toString(capacity - ridersUIDs.size());
    }

    //Create Parcel to be able to send between activities
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(owner);
        dest.writeString(model);
        dest.writeInt(capacity);
        dest.writeString(vehicleID);
        dest.writeStringList(ridersUIDs);
        dest.writeByte((byte) (open ? 1 : 0));
        dest.writeString(vehicleType);
        dest.writeDouble(basePrice);
    }
}
