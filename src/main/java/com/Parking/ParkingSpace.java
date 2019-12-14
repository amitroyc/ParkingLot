package com.Parking;

public class ParkingSpace {
    Car car;

    public ParkingSpace(Car car, Integer slot) {
        this.car = car;
        System.out.println("Allocated slot number: " + slot);
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
