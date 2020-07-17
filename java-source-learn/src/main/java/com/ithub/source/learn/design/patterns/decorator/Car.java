package com.ithub.source.learn.design.patterns.decorator;

public class Car extends Vehicle{

    private Vehicle vehicle;

    public Car() {
    }

    public Car(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String run() {
        return vehicle.run();
    };

}
