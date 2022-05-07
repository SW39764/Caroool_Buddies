package com.example.carpool_buddy_sam.Users;

import java.util.ArrayList;

public class Teacher extends User{

    private String inSchoolTitle;

    public Teacher(String userID, String nameString, String emailString, String inSchoolTitle) {
        super(userID, nameString, emailString, "Teacher", 1.0, null);
        this.inSchoolTitle = inSchoolTitle;
    }

    public Teacher(String uid, String name, String email, String userType, double priceMultiplier, ArrayList<String> ownedVehicles, String inSchoolTitle) {
        super(uid, name, email, userType, priceMultiplier, ownedVehicles);
        this.inSchoolTitle = inSchoolTitle;
    }

    public String getInSchoolTitle() {
        return inSchoolTitle;
    }

    public void setInSchoolTitle(String inSchoolTitle) {
        this.inSchoolTitle = inSchoolTitle;
    }

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
