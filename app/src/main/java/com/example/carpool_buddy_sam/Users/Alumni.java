package com.example.carpool_buddy_sam.Users;

import java.util.ArrayList;

public class Alumni extends User{

    private int graduateYear;

    public Alumni(){

    }

    public Alumni(String uid, String name, String email, String userType, double priceMultiplier, ArrayList<String> ownedVehicles, int graduateYear) {
        super(uid, name, email, userType, priceMultiplier, ownedVehicles);
        this.graduateYear = graduateYear;
    }

//    Alumni newUser = new Alumni(uid, nameString, emailString, gradYearInt);

    public Alumni(String uid, String name, String email, int graduateYear){
        super(uid, name, email, "Alumni", 1, null);
        this.graduateYear = graduateYear;
    }

    public int getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(int graduateYear) {
        this.graduateYear = graduateYear;
    }

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
