package com.example.carpool_buddy_sam.Users;

import java.util.ArrayList;

//Parent child class of User
public class Parent extends User{
    private ArrayList<String> childrenUIDs;

    //No argument constructor
    public Parent(){
    }

    //Constructor
    public Parent(String userID, String nameString, String emailString){
        super(userID, nameString, emailString, "parent", 1.0, new ArrayList<String>());
    }

    //Constructor
    public Parent(String uid, String name, String email, String userType, double priceMultiplier, ArrayList<String> ownedVehicles, ArrayList<String> childrenUIDs) {
        super(uid, name, email, userType, priceMultiplier, ownedVehicles);
        this.childrenUIDs = childrenUIDs;
    }

    //Getters
    public ArrayList<String> getChildrenUIDs() {
        return childrenUIDs;
    }

    //Setters
    public void setChildrenUIDs(ArrayList<String> childrenUIDs) {
        this.childrenUIDs = childrenUIDs;
    }

    //To String
    @Override
    public String toString() {
        return "Parent{" +
                "uid='" + getUid() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", userType='" + getUserType() + '\'' +
                ", priceMultiplier=" + getPriceMultiplier() +
                ", ownedVehicles=" + getOwnedVehicles() +
                ", childrenUIDs=" + childrenUIDs +
                '}';
    }
}
