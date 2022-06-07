package com.example.carpool_buddy_sam.Users;

import java.util.ArrayList;

/**
 * parent class of all User types
 * used to manage one type of users and store all relevant information
 */
//User class - parent class to Alumni, Parent, Student, and Teacher
public class User {

    //Instance variables
    private String uid;
    private String name;
    private String email;
    private String userType;
    private double priceMultiplier;
    private ArrayList<String> ownedVehicles;

    //no arguement constructor
    public User(){

    }

    //constructor
    public User(String uid, String name, String email, String userType, double priceMultiplier, ArrayList<String> ownedVehicles) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.priceMultiplier = priceMultiplier;
        this.ownedVehicles = ownedVehicles;
    }

    //getters and setters

    /**
     * getter for uid
     * @return String of uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * setter for uid
     * @param uid String of uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * getter for name
     * @return String of name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for name
     * @param name String of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for email
     * @return String of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * setter for email
     * @param email String of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getter for userType
     * @return String of userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * setter for userType
     * @param userType String of userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * getter for priceMultiplier
     * @return double of priceMultiplier
     */
    public double getPriceMultiplier() {
        return priceMultiplier;
    }

    /**
     * setter for priceMultiplier
     * @param priceMultiplier double of priceMultiplier
     */
    public void setPriceMultiplier(double priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

    /**
     * getter for ownedVehicles
     * @return ArrayList of ownedVehicles (Vehicle objects)
     */

    public ArrayList<String> getOwnedVehicles() {
        return ownedVehicles;
    }

    /**
     * setter for ownedVehicles
     * @param ownedVehicles ArrayList of ownedVehicles (Vehicle objects)
     */
    public void setOwnedVehicles(ArrayList<String> ownedVehicles) {
        this.ownedVehicles = ownedVehicles;
    }

    /**
     * toString method for User
     * @return String of : uid, name, email, userType, priceMultiplier, ownedVehicles
     */
    //toString
    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userType='" + userType + '\'' +
                ", priceMultiplier=" + priceMultiplier +
                ", ownedVehicles=" + ownedVehicles +
                '}';
    }
}
