package com.ithub.source.learn.design.patterns.decorator;

public class Cream extends Food{
    private Food basic_food;

    public Cream(Food basic_food) {
        this.basic_food = basic_food;
    }

    public String make() {
        return basic_food.make()+"+奶油";
    }
}
