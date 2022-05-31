package com.example.carpool_buddy_sam.Users;

import java.util.ArrayList;

//Alumni child class of User
public class Alumni extends User{

    //instance variables
    private int graduateYear;

    //no argument constructor
    public Alumni(){
    }

    //constructor
    public Alumni(String uid, String name, String email, String userType, double priceMultiplier, ArrayList<String> ownedVehicles, int graduateYear) {
        super(uid, name, email, userType, priceMultiplier, ownedVehicles);
        this.graduateYear = graduateYear;
    }

    //constructor (only some fields)
    public Alumni(String uid, String name, String email, int graduateYear){
        super(uid, name, email, "Alumni", 1, new ArrayList<String>());
        this.graduateYear = graduateYear;
    }

    //getters
    public int getGraduateYear() {
        return graduateYear;
    }

    //setters
    public void setGraduateYear(int graduateYear) {
        this.graduateYear = graduateYear;
    }

    //toString
    @Override
    public String toString() {
        return "Alumni{" +
                "uid='" + getUid() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", userType='" + getUserType() + '\'' +
                ", priceMultiplier=" + getPriceMultiplier() +
                ", ownedVehicles=" + getOwnedVehicles() +
                ", graduateYear=" + graduateYear +
                '}';
    }


}
