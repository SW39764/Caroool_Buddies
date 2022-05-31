package com.example.carpool_buddy_sam.Users;

import java.util.ArrayList;

public class Student extends User{

    //Instance variables
    private String graduateYear;
    private ArrayList<Student> parentUID;


    //No argument constructor
    public Student(){
    }

    //Constructor
    public Student(String uid, String name, String email, String userType, double priceMultiplier, ArrayList<String> ownedVehicles, String graduateYear, ArrayList<Student> parentUID) {
        super(uid, name, email, userType, priceMultiplier, ownedVehicles);
        this.graduateYear = graduateYear;
        this.parentUID = parentUID;
    }

    //Constructor (only some fields)
    public Student(String userID, String nameString, String emailString, String gradYear) {
        super(userID, nameString, emailString, "Student", 1.0, new ArrayList<String>());
        this.graduateYear = gradYear;
    }

    //Getters and setters
    public String getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(String graduateYear) {
        this.graduateYear = graduateYear;
    }

    public ArrayList<Student> getParentUID() {
        return parentUID;
    }

    public void setParentUID(ArrayList<Student> parentUID) {
        this.parentUID = parentUID;
    }


    //toString
    @Override
    public String toString() {
        return "Student{" +
                "uid='" + getUid() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", userType='" + getUserType() + '\'' +
                ", priceMultiplier=" + getPriceMultiplier() +
                ", ownedVehicles=" + getOwnedVehicles() +
                ", graduateYear='" + graduateYear + '\'' +
                ", parentUID=" + parentUID +
                '}';
    }
}
