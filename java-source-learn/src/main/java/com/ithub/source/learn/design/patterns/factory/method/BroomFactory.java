package com.ithub.source.learn.design.patterns.factory.method;

public class BroomFactory extends VehicleFactory {
    @Override
    Moveable create() {
        return new Broom();
    }
}
