package com.example.carpool_buddy_sam.Users;

import java.util.ArrayList;

public class Student extends User{

    private String graduateYear;
    private ArrayList<Student> parentUID;

    public Student(){

    }

    public Student(String uid, String name, String email, String userType, double priceMultiplier, ArrayList<String> ownedVehicles, String graduateYear, ArrayList<Student> parentUID) {
        super(uid, name, email, userType, priceMultiplier, ownedVehicles);
        this.graduateYear = graduateYear;
        this.parentUID = parentUID;
    }

    public Student(String userID, String nameString, String emailString, String gradYear) {
        super(userID, nameString, emailString, "Student", 1.0, null);
        this.graduateYear = gradYear;
    }

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
