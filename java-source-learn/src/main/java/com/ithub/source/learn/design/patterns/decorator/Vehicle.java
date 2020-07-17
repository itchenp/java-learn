package com.ithub.source.learn.design.patterns.decorator;

public class Vehicle {
    private String vehicle_name;

    public Vehicle() {
    }

    public Vehicle(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    public String run() {
        return vehicle_name;
    };

}
