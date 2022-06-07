package com.example.carpool_buddy_sam.Users;

import java.util.ArrayList;

/**
 * Child class of User.
 * Used to manage one type of users and store all relevant information.
 */
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

    /**
     * getter for graduate year
     * @return String of graduateYear
     */
    //Getters and setters
    public String getGraduateYear() {
        return graduateYear;
    }

    /**
     * setter for graduate year
     * @param graduateYear String
     */
    public void setGraduateYear(String graduateYear) {
        this.graduateYear = graduateYear;
    }

    /**
     * getter for parentUID
     * @return ArrayList of parentUID (Strings)
     */
    public ArrayList<Student> getParentUID() {
        return parentUID;
    }

    /**
     * setter for parentUID
     * @param parentUID ArrayList of parentUID (Strings)
     */
    public void setParentUID(ArrayList<Student> parentUID) {
        this.parentUID = parentUID;
    }


    /**
     * toString method for Student
     * @return String of : uid, name, email, userType, priceMultiplier, ownedVehicles, graduateYear, parentUID
     */
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
