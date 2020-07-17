package com.ithub.source.learn.design.patterns.factory.method;

public class PlaneFactor extends VehicleFactory {
    @Override
    Moveable create() {
        return new Plane();
    }
}
