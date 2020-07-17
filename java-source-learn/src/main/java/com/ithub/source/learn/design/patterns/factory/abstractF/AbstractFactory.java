package com.ithub.source.learn.design.patterns.factory.abstractF;

import com.ithub.source.learn.design.patterns.decorator.Food;
import com.ithub.source.learn.design.patterns.decorator.Vehicle;
import com.ithub.source.learn.design.patterns.decorator.Weapon;

public abstract class AbstractFactory {
    public abstract Vehicle createVehicle();
    public abstract Weapon createWeapon();
    public abstract Food createFood();
}
