package com.ithub.source.learn.design.patterns.decorator;

public class Weapon {

    private String weapon_name;

    public Weapon() {
    }

    public Weapon(String weapon_name) {
        this.weapon_name = weapon_name;
    }

    public String shoot() {
        return weapon_name;
    };
}
