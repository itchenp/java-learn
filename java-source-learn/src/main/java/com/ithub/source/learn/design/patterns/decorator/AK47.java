package com.ithub.source.learn.design.patterns.decorator;

public class AK47 extends Weapon{
    private Weapon weapon_basic;

    public AK47() {
    }

    public AK47(Weapon weapon_basic) {
        this.weapon_basic = weapon_basic;
    }

    public String shoot() {
        return weapon_basic.shoot();
    };
}
