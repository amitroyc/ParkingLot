package com.Parking;

public class Car {
    String strRegistrationNo;
    String colour;

    @Override
    public String toString() {
        return "\t\t" + strRegistrationNo + "\t\t" + colour;
    }

    public Car(String strRegistrationNo, String colour) {
        this.strRegistrationNo = strRegistrationNo;
        this.colour = colour;
    }

    public String getStrRegistrationNo() {
        return strRegistrationNo;
    }

    public void setStrRegistrationNo(String strRegistrationNo) {
        this.strRegistrationNo = strRegistrationNo;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
