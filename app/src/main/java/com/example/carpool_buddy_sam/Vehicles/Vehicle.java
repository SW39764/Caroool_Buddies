package com.example.carpool_buddy_sam.Vehicles;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

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

    //Getters and setters
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public ArrayList<String> getRidersUIDs() {
        return ridersUIDs;
    }

    public void setRidersUIDs(ArrayList<String> ridersUIDs) {
        this.ridersUIDs = ridersUIDs;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }


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
