package com.ithub.source.learn.design.patterns.factory.abstractF;

import com.ithub.source.learn.design.patterns.decorator.*;

public class DefaultFactory extends AbstractFactory{
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Weapon createWeapon() {
        return new AK47();
    }

    @Override
    public Food createFood() {
        return new Apple();
    }
}
