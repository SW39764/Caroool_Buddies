package com.example.carpool_buddy_sam.Users;

import com.example.carpool_buddy_sam.Vehicles.Vehicle;

import java.lang.reflect.Array;
import java.util.ArrayList;


//Teacher child class of User
public class Teacher extends User{

    //Instance variables
    private String inSchoolTitle;

    //Constructor (only some fields)
    public Teacher(String userID, String nameString, String emailString, String inSchoolTitle) {
        super(userID, nameString, emailString, "Teacher", 1.0, new ArrayList<String>());
        this.inSchoolTitle = inSchoolTitle;
    }

    //Constructor
    public Teacher(String uid, String name, String email, String userType, double priceMultiplier, ArrayList<String> ownedVehicles, String inSchoolTitle) {
        super(uid, name, email, userType, priceMultiplier, ownedVehicles);
        this.inSchoolTitle = inSchoolTitle;
    }

    //Getters and Setters
    public String getInSchoolTitle() {
        return inSchoolTitle;
    }

    public void setInSchoolTitle(String inSchoolTitle) {
        this.inSchoolTitle = inSchoolTitle;
    }

    //toString
    @Override
    public String toString() {
        return "Teacher{" +
                "uid='" + getUid() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", userType='" + getUserType() + '\'' +
                ", priceMultiplier=" + getPriceMultiplier() +
                ", ownedVehicles=" + getOwnedVehicles() +
                ", inSchoolTitle='" + inSchoolTitle + '\'' +
                '}';
    }
}
